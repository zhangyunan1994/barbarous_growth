<h1>FastSql 中 ORM 的实现</h1>

**Table of Contents**

<!-- TOC -->

- [原理](#原理)
- [实现](#实现)
    - [1. 使用注解](#1-使用注解)
    - [2. 反射工具类](#2-反射工具类)
    - [3. 简单的 model](#3-简单的-model)
    - [4. 注解解析](#4-注解解析)
    - [5. 数据库操作](#5-数据库操作)
    - [6. 结合反射实现查询操作](#6-结合反射实现查询操作)

<!-- /TOC -->

# 原理

在使用的ORM框架中，我可以想操作对象一样操作数据的存储，这是怎么实现的，我们知道数据库是认识 SQL 语句的，但并不认识`java bean` 呀！同时我们在使用ORM时，需要根据ORM框架的规定定义我们的bean，这是为什么？

这是因为 `ORM` 为我们提供了将对象操作转化为对应的 `SQL`语句，例如 `save(bean)`, 这时就需要转化成一个 `insert` 语句，`update(bean)` 这时就需要转成成对应的 update 语句

通常 insert 语句格式为 
```sql
insert into 表名 (列名) values( 值)
```
update 语句为 
```sql
update 表名 set 列名 = 值 where id = 值
```
上面的格式可以看出，如果我们能从对象中得出 `表名` `列名` `值`，我们也可以写一个简单的ORM框架


# 实现

## 1. 使用注解

上篇文章中提到了一下注解，以及自定义注解和解析注解的方法，通过使用注解，我们可以完成一个简单的ORM

要想实现对数据库的操作，我们必须知道数据表名以及表中的字段名称以及类型，正如hibernate 使用注解标识 model 与数据库的映射关系一样，这里我使用了`Java Persistence API`

**注解说明**


注解 | 作用 | 使用说明
---------|----------|---------
 @Entity | 标记这是一个实体 | 标注在类上，标明该类可以被ORM处理
 @Table | 标记实体对应的表 | 标注在类上，标明该类对应的数据库标明
 @Id | 标记该字段是id | 标注在字段上，标明该字段为id
 @Column | 标记该字段对应的列信息 | 标记在字段上，标明对应的列信息，主要对应列名


**字段属性表**
用来存储对象中字段与数据表列的对应关系
```java
package com.zyndev.tool.fastsql.core;

import lombok.Data;

import javax.persistence.GenerationType;

/**
 * The type Db column info.
 *
 * @author 张瑀楠 zyndev@gmail.com
 * @version 0.0.1
 */
@Data
class DBColumnInfo {

    /**
     * (Optional) The primary key generation strategy
     * that the persistence provider must use to
     * generate the annotated entity primary key.
     */
    private GenerationType strategy = GenerationType.AUTO;


    private String fieldName;

    /**
     * The name of the column
     */
    private String columnName;


    /**
     * Whether the column is a unique key.
     */
    private boolean unique;

    /**
     * Whether the database column is nullable.
     */
    private boolean nullable = true;

    /**
     * Whether the column is included in SQL INSERT
     */
    private boolean insertAble = true;

    /**
     * Whether the column is included in SQL UPDATE
     */
    private boolean updatable = true;

    /**
     * The SQL fragment that is used when
     * generating the DDL for the column.
     */
    private String columnDefinition;

    /**
     * The name of the table that contains the column.
     * If absent the column is assumed to be in the primary table.
     */
    private String table;

    /**
     * (Optional) The column length. (Applies only if a
     * string-valued column is used.)
     */
    private int length =  255;

    private boolean id = false;

}
```
## 2. 反射工具类
提供一些常用的反射操作

通过反射我们可以动态的得到一个类所有的成员变量的信息，同时为这些变量取值或者赋值

```java
package com.zyndev.tool.fastsql.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The type Bean reflection util.
 *
 * @author yunan.zhang zyndev@gmail.com
 * @version 0.0.3
 * @date 2017年12月26日 16点36分
 */
public class BeanReflectionUtil {

    public static Object getPrivatePropertyValue(Object obj,String propertyName)throws Exception{
        Class cls=obj.getClass();
        Field field=cls.getDeclaredField(propertyName);
        field.setAccessible(true);
        Object retvalue=field.get(obj);
        return retvalue;
    }


    /**
     * Gets static field value.
     *
     * @param className the class name
     * @param fieldName the field name
     * @return the static field value
     * @throws Exception the exception
     */
    public static Object getStaticFieldValue(String className, String fieldName) throws Exception {
        Class cls = Class.forName(className);
        Field field = cls.getField(fieldName);
        return field.get(cls);
    }


    /**
     * Gets field value.
     *
     * @param obj       the obj
     * @param fieldName the field name
     * @return the field value
     * @throws Exception the exception
     */
    public static Object getFieldValue(Object obj, String fieldName) throws Exception {
        Class cls = obj.getClass();
        Field field = cls.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }


    /**
     * Invoke method object.
     *
     * @param owner      the owner
     * @param methodName the method name
     * @param args       the args
     * @return the object
     * @throws Exception the exception
     */
    public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        Class cls = owner.getClass();
        Class[] argclass = new Class[args.length];
        for (int i = 0, j = argclass.length; i < j; i++) {
            argclass[i] = args[i].getClass();
        }
        @SuppressWarnings("unchecked")
        Method method = cls.getMethod(methodName, argclass);
        return method.invoke(owner, args);
    }


    /**
     * Invoke static method object.
     *
     * @param className  the class name
     * @param methodName the method name
     * @param args       the args
     * @return the object
     * @throws Exception the exception
     */
    public Object invokeStaticMethod(String className, String methodName, Object[] args) throws Exception {
        Class cls = Class.forName(className);
        Class[] argClass = new Class[args.length];
        for (int i = 0, j = argClass.length; i < j; i++) {
            argClass[i] = args[i].getClass();
        }
        @SuppressWarnings("unchecked")
        Method method = cls.getMethod(methodName, argClass);
        return method.invoke(null, args);
    }


    /**
     * New instance object.
     *
     * @param className the class name
     * @return the object
     * @throws Exception the exception
     */
    public static Object newInstance(String className) throws Exception {
        Class clazz = Class.forName(className);
        @SuppressWarnings("unchecked")
        java.lang.reflect.Constructor cons = clazz.getConstructor();
        return cons.newInstance();
    }

    /**
     * New instance object.
     *
     * @param clazz the clazz
     * @return the object
     * @throws Exception the exception
     */
    public static Object newInstance(Class clazz) throws Exception {
        @SuppressWarnings("unchecked")
        java.lang.reflect.Constructor cons = clazz.getConstructor();
        return cons.newInstance();
    }


    /**
     * Get bean declared fields field [ ].
     *
     * @param className the class name
     * @return the field [ ]
     * @throws ClassNotFoundException the class not found exception
     */
    public static Field[] getBeanDeclaredFields(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        return clazz.getDeclaredFields();
    }


    /**
     * Get bean declared methods method [ ].
     *
     * @param className the class name
     * @return the method [ ]
     * @throws ClassNotFoundException the class not found exception
     */
    public static Method[] getBeanDeclaredMethods(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        return clazz.getMethods();
    }


    /**
     * Copy fields.
     *
     * @param source the source
     * @param target the target
     */
    public static void copyFields(Object source, Object target) {
        try {
            List<Field> list = new ArrayList<>();
            Field[] sourceFields = getBeanDeclaredFields(source.getClass().getName());
            Field[] targetFields = getBeanDeclaredFields(target.getClass().getName());
            Map<String, Field> map = new HashMap<>(targetFields.length);
            for (Field field : targetFields) {
                map.put(field.getName(), field);
            }
            for (Field field : sourceFields) {
                if (map.get(field.getName()) != null) {
                    list.add(field);
                }
            }
            for (Field field : list) {
                Field tg = map.get(field.getName());
                tg.setAccessible(true);
                tg.set(target, getFieldValue(source, field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
```
## 3. 简单的 model

```java
package com.zyndev.tool.fastsql;

import javax.persistence.*;

/**
 * @author 张瑀楠 zyndev@gmail.com
 * @date   2017/11/30 下午11:21
 */
@Data
@Entity
@Table(name = "tb_student")
public class Student {


    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @Column(updatable = true, insertable = true, nullable = false)
    private Integer age;

}
```

## 4. 注解解析

将对象的上的注解进行解析，得到对应关系
```java
package com.zyndev.tool.fastsql.core;


import com.zyndev.tool.fastsql.util.StringUtil;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The type Annotation parser.
 * <p>
 * 注解解析工具
 *
 * @author yunan.zhang zyndev@gmail.com
 * @version 0.0.3
 * @since 2017-12-26 16:59:07
 */
public class AnnotationParser {

    /**
     * 存储类名和数据库表名的关系
     * 使用三个cache 主要为了减少反射的次数，提高效率
     */
    private final static Map<String, String> tableNameCache = new HashMap<>(30);

    /**
     * 存储类名和数据库列的关联关系
     */
    private final static Map<String, String> tableAllColumnNameCache = new HashMap<>(30);

    /**
     * 存储类名和对应的数据库全列名的关系
     */
    private final static Map<String, List<DBColumnInfo>> tableAllDBColumnCache = new HashMap<>(30);

    /**
     * Gets table name.
     * 获得表名
     * 判断是否有@Table注解，如果有得到注解的name,如果name为空，则使用类名做为表名
     * 如果没有@Table返回null
     *
     * @param <E>    the type parameter
     * @param entity the entity
     * @return the table name
     */
    public static <E> String getTableName(E entity) {
        String tableName = tableNameCache.get(entity.getClass().getName());
        if (tableName == null) {
            Table table = entity.getClass().getAnnotation(Table.class);
            if (table != null && StringUtil.isNotBlank(table.name())) {
                tableName = table.name();
            } else {
                tableName = entity.getClass().getSimpleName();
            }
            tableNameCache.put(entity.getClass().getName(), tableName);
        }
        return tableName;
    }

    /**
     * Gets all db column info.
     *
     * @param <E>    the type parameter
     * @param entity the entity
     * @return the all db column info
     */
    public static <E> List<DBColumnInfo> getAllDBColumnInfo(E entity) {
        List<DBColumnInfo> dbColumnInfoList = tableAllDBColumnCache.get(entity.getClass().getName());
        if (dbColumnInfoList == null) {
            dbColumnInfoList = new ArrayList<>();
            DBColumnInfo dbColumnInfo;
            Field[] fields = entity.getClass().getDeclaredFields();
            for (Field field : fields) {
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    dbColumnInfo = new DBColumnInfo();
                    if (StringUtil.isBlank(column.name())) {
                        dbColumnInfo.setColumnName(field.getName());
                    } else {
                        dbColumnInfo.setColumnName(column.name());
                    }
                    if (null != field.getAnnotation(Id.class)) {
                        dbColumnInfo.setId(true);
                    }
                    dbColumnInfo.setFieldName(field.getName());
                    dbColumnInfoList.add(dbColumnInfo);
                }
            }
            tableAllDBColumnCache.put(entity.getClass().getName(), dbColumnInfoList);
        }
        return dbColumnInfoList;
    }

    /**
     * 返回表字段的所有字段  column1,column2,column3
     *
     * @param <E>    the type parameter
     * @param entity the entity
     * @return string
     */
    public static <E> String getTableAllColumn(E entity) {

        String allColumn = tableAllColumnNameCache.get(entity.getClass().getName());
        if (allColumn == null) {
            List<DBColumnInfo> dbColumnInfoList = getAllDBColumnInfo(entity);
            StringBuilder allColumnsInfo = new StringBuilder();
            int i = 1;
            for (DBColumnInfo dbColumnInfo : dbColumnInfoList) {
                allColumnsInfo.append(dbColumnInfo.getColumnName());
                if (i != dbColumnInfoList.size()) {
                    allColumnsInfo.append(",");
                }
                i++;
            }
            allColumn = allColumnsInfo.toString();
            tableAllColumnNameCache.put(entity.getClass().getName(), allColumn);
        }
        return allColumn;

    }
}
```
## 5. 数据库操作

**数据库交互使用spring 提供的 JdbcTemplate**

## 6. 结合反射实现查询操作

> 保存一个entity

保存操作相对简单，这里主要是将 entity 转换为 insert 语句

```java
/**
 * Save int.
 * @param entity the entity
 * @return the int
 */
@Override
public int save(Object entity) {
    try {
        String tableName = AnnotationParser.getTableName(entity);
        StringBuilder property = new StringBuilder();
        StringBuilder value = new StringBuilder();
        List<Object> propertyValue = new ArrayList<>();
        List<DBColumnInfo> dbColumnInfoList = AnnotationParser.getAllDBColumnInfo(entity);

        for (DBColumnInfo dbColumnInfo : dbColumnInfoList) {
            if (dbColumnInfo.isId() || !dbColumnInfo.isInsertAble()) {
                continue;
            }
            // 不为null
            Object o = BeanReflectionUtil.getFieldValue(entity, dbColumnInfo.getFieldName());
            if (o != null) {
                property.append(",").append(dbColumnInfo.getColumnName());
                value.append(",").append("?");
                propertyValue.add(o);
            }
        }
        String sql = "insert into " + tableName + "(" + property.toString().substring(1) + ") values(" + value.toString().substring(1) + ")";
        return this.getJdbcTemplate().update(sql, propertyValue.toArray());
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

```

> 更新操作

更新操作相对于 保存来说，多了一步确定`where` 语句操作

```java
/**
 * Update int.
 *
 * @param entity     the entity
 * @param ignoreNull the ignore null
 * @param columns    the columns
 * @return the int
 */
@Override
public int update(Object entity, boolean ignoreNull, String... columns) {
    try {
        String tableName = AnnotationParser.getTableName(entity);
        StringBuilder property = new StringBuilder();
        StringBuilder where = new StringBuilder();
        List<Object> propertyValue = new ArrayList<>();
        List<Object> wherePropertyValue = new ArrayList<>();
        List<DBColumnInfo> dbColumnInfos = AnnotationParser.getAllDBColumnInfo(entity);
        for (DBColumnInfo dbColumnInfo : dbColumnInfos) {

            Object o = BeanReflectionUtil.getFieldValue(entity, dbColumnInfo.getFieldName());
            if (dbColumnInfo.isId()) {
                where.append(" and ").append(dbColumnInfo.getColumnName()).append(" = ? ");
                wherePropertyValue.add(o);
            } else if (ignoreNull || o != null) {
                property.append(",").append(dbColumnInfo.getColumnName()).append("=?");
                propertyValue.add(o);
            }
        }

        if (wherePropertyValue.isEmpty()) {
            throw new IllegalArgumentException("更新表 [" + tableName + "] 无法找到id, 请求数据：" + entity);
        }

        String sql = "update " + tableName + " set " + property.toString().substring(1) + " where " + where.toString().substring(5);
        propertyValue.addAll(wherePropertyValue);
        return this.getJdbcTemplate().update(sql, propertyValue.toArray());
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
```

> 删除操作

相对 update 简单一点

```
/**
 * Delete int.
 * <p>根据id 删除对应的数据</p>
 *
 * @param entity the entity
 * @return the int
 */
@Override
public int delete(Object entity) {
    try {
        String tableName = AnnotationParser.getTableName(entity);
        StringBuilder where = new StringBuilder(" 1=1 ");
        List<Object> whereValue = new ArrayList<>(5);
        List<DBColumnInfo> dbColumnInfos = AnnotationParser.getAllDBColumnInfo(entity);
        for (DBColumnInfo dbColumnInfo : dbColumnInfos) {
            if (dbColumnInfo.isId()) {
                Object o = BeanReflectionUtil.getFieldValue(entity, dbColumnInfo.getFieldName());
                if (null != o) {
                    whereValue.add(o);
                }
                where.append(" and `").append(dbColumnInfo.getColumnName()).append("` = ? ");
            }
        }

        if (whereValue.size() == 0) {
            throw new IllegalStateException("delete " + tableName + " id 无对应值，不能删除");
        }
        String sql = "delete from  " + tableName + " where " + where.toString();
        return this.getJdbcTemplate().update(sql, whereValue);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
```

> 篇幅已经很长了，下次继续写上

    源码 https://github.com/zyndev/fastsql

> 如果你喜欢，请关注