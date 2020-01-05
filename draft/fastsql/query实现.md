<h1>@Query 的实现</h1>

<!-- TOC -->

- [动态代理](#动态代理)
- [注解](#注解)
- [表设计](#表设计)
- [model](#model)
- [repository](#repository)
- [大体流程](#大体流程)
- [代理使用](#代理使用)
- [将生成代理放入 Spring IOC 容器中](#将生成代理放入-spring-ioc-容器中)
- [invoke方法处理](#invoke方法处理)

<!-- /TOC -->

# 动态代理

基于 JDK 动态代理实现

# 注解

上一篇文章中提到了如何使用注解完成一个简单的ORM，其中注解使用`Java Persistence API` 但是其中没有我们需要的 @Query 和 @Param 这里我们自定义一下这两个注解,同时为了让Query支持返回主键，在定义一个 **`ReturnGeneratedKey`** 注解

**Query.java**
```java
package com.zyndev.tool.fastsql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 查询操作 sql
 *
 * @author 张瑀楠 zyndev@gmail.com
 * @version 0.0.1
 * @since  2017/12/22 17:26
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

    /**
     * sql 语句
     */
    String value();
}
```
**Param.java**
```java
package com.zyndev.tool.fastsql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author 张瑀楠 zyndev@gmail.com
 * @version 0.0.1
 * @since  2017/12/22 17:29
 */
@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

    /**
     * 指出这个值是 SQL 语句中哪个参数的值，使用命名参数
     */
    String value();
}

```

**ReturnGeneratedKey.java**
```java
package com.zyndev.tool.fastsql.annotation;


import java.lang.annotation.*;


/**
 * 返回主键
 *
 * @author 张瑀楠 zyndev@gmail.com
 * @version 0.0.3
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReturnGeneratedKey {
}
```
# 表设计
```sql
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(40) DEFAULT NULL,
  `account_name` varchar(40) DEFAULT NULL,
  `nick_name` varchar(23) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `register_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
```

# model

这里使用一个 User.java 作为例子：
**User.java**
```java
package com.zyndev.tool.fastsql.repository;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张瑀楠 zyndev@gmail.com
 * @version 1.0
 * @date 2017-12-27 15:04:13
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String uid;

    private String accountName;

    private String nickName;

    private String password;

    private String phone;

    private Date registerTime;

    private Date updateTime;

}
```

# repository
```java
package com.zyndev.tool.fastsql.repository;

import com.zyndev.tool.fastsql.annotation.Param;
import com.zyndev.tool.fastsql.annotation.Query;
import com.zyndev.tool.fastsql.annotation.ReturnGeneratedKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 这里应该有描述
 *
 * @version 1.0
 * @author 张瑀楠 zyndev@gmail.com
 * @date 2017 /12/22 18:13
 */
@Repository
public interface UserRepository {

    @Query("select count(*) from tb_user")
    public Integer getCount();

    @Query("delete from tb_user where id = ?1")
    public Boolean deleteById(int id);

    @Query("select count(*) from tb_user where password = ?1 ")
    public int getCountByPassword(@Param("password") String password);

    @Query("select uid from tb_user where password = ?1 ")
    public String getUidByPassword(@Param("password") String password);

    @Query("select * from tb_user where id = :id ")
    public User getUserById(@Param("id") Integer id);

    @Query("select * " +
            " from tb_user " +
            " where account_name = :accountName ")
    public List<User> getUserByAccountName(@Param("accountName") String accountName);

    @Query("insert into tb_user(id, account_name, password, uid, nick_name, register_time, update_time) " +
            "values(:id, :user.accountName, :user.password, :user.uid, :user.nickName, :user.registerTime, :user.updateTime )")
    public int saveUser(@Param("id") Integer id, @Param("user") User user);

    @ReturnGeneratedKey
    @Query("insert into tb_user(account_name, password, uid, nick_name, register_time, update_time) " +
            "values(:user.accountName, :user.password, :user.uid, :user.nickName, :user.registerTime, :user.updateTime )")
    public int saveUser(@Param("user") User user);
}
```

# 大体流程

在上面的我们已经完成一些准备工作，包括：
1. 注解的定义
1. 表的设计
1. model 的设计
1. Repository 的设计

接下来，我们看看如何将这些整合在一起

大致流程：
1. 为 Repository 生成代理
1. 将生成代理放入 Spring IOC 容器中
1. 当代理的方法被调用时，得到方法的`@Query`,`@Param`,`@ReturnGeneratedKey` 注解，并取得方法的返回值
1. 重写 Query的sql，并执行，根据方法的返回类型，封装SQL返回结果集

# 代理使用

**FacadeProxy.java**

    为 Repository 生成代理，当代理方法执行时，回调 invoke 方法，invoke 中逻辑写到**StatementParser.java**中，防止类功能过大
```java
package com.zyndev.tool.fastsql.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 生成代理
 *
 * @author 张瑀楠 zyndev@gmail.com
 * @version 0.0.1
 * @since  2017 /12/23 上午12:40
 */
@SuppressWarnings("unchecked")
public class FacadeProxy implements InvocationHandler {

    private final static Log logger = LogFactory.getLog(FacadeProxy.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return StatementParser.invoke(proxy, method, args);
    }

    /**
     * New mapper proxy t.
     *
     * @param <T>             the type parameter
     * @param mapperInterface the mapper interface
     * @return the t
     */
    protected static <T> T newMapperProxy(Class<T> mapperInterface) {
        logger.info(" 生成代理：" + mapperInterface.getName());
        ClassLoader classLoader = mapperInterface.getClassLoader();
        Class<?>[] interfaces = new Class[]{mapperInterface};
        FacadeProxy proxy = new FacadeProxy();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }
}
```
# 将生成代理放入 Spring IOC 容器中

在这里使用了 `BeanFactoryAware`,关于这部分内容会单独写一篇，这里不在详细说明

```java
package com.zyndev.tool.fastsql.core;

import com.zyndev.tool.fastsql.util.ClassScanner;
import com.zyndev.tool.fastsql.util.StringUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Set;

/**
 * The type Fast sql repository registrar.
 *
 * @author 张瑀楠 zyndev@gmail.com
 * @version 1.0
 * @date 2018 /2/23 12:26
 */
public class FastSqlRepositoryRegistrar implements ImportBeanDefinitionRegistrar, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        System.out.println("FastSqlRepositoryRegistrar registerBeanDefinitions ");
        String basePackage = "com.sparrow";
        ClassScanner classScanner = new ClassScanner();
        Set<Class<?>> classSet = null;
        try {
            classSet = classScanner.getPackageAllClasses(basePackage, true);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Class clazz : classSet) {
            if (clazz.getAnnotation(Repository.class) != null) {
                beanFactory.registerSingleton(StringUtil.firstCharToLowerCase(clazz.getSimpleName()), FacadeProxy.newMapperProxy(clazz));
            }
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }
}

```

# invoke方法处理

在前面生成动态的代理的时候，可以看到，所有的**invoke**逻辑由**StatementParser.java**处理，这也是一个重量级的方法

> invoke执行流程说明：

**invoke(Object proxy, Method method, Object[] args)**
1. 得到方法的返回类型
1. 得到方法的**@Query**注解，取得需要执行的`sql`语句，无法取到sql则抛异常
1. 获得方法的参数，并将参数顺序对应为 ?1->arg0 ?2->arg1 ...
1. 获得方法的参数和参数上`@Param`注解，并将参数与对应的Param的名称关联：param1->arg0 password->arg1 
1. 判断sql是select还是其他，使用正则 `(?i)select([\\s\\S]*?)`
1. 重写sql
1. 如果不是 select 语句，判断是否是 `@ReturnGeneratedKey` 注解
1. 如果无 `@ReturnGeneratedKey` 则直接执行语句并返回对应的结果
1. 如有有 `@ReturnGeneratedKey` 并且是 insert 语句则返回生成的主键
1. 如果是 select 语句，则执行select 语句，并根据方法的返回类型封装结果集


> 关于重写sql
```java
@Query("insert into tb_user(id, 
account_name, 
password, 
uid, 
nick_name, 
register_time, 
update_time) values(
    :id, 
    :user.accountName, 
    :user.password, 
    :user.uid, 
    :user.nickName, 
    :user.registerTime, 
    :user.updateTime )")
    public int saveUser(@Param("id") Integer id, @Param("user") User user); 
```

首先获取sql
```sql
insert into tb_user(id, account_name, password, uid, nick_name, register_time, update_time)
values(:id, :user.accountName, :user.password, :user.uid, :user.nickName, :user.registerTime, :user.updateTime )
```

可以看出这并不是标准的sql 也不是 jdbc 可以识别的sql，这里我们使用正则**\?\d+(\.[A-Za-z]+)?|:[A-Za-z0-9]+(\.[A-Za-z]+)?**

来提取出 ?1 ?2 :1 :2 :id :user.accountName 的特殊标志，并将其替换为 ？

替换过程中没替换一个 ？ 则记录对应的 ？所代表的数值 

替换后的SQL为
```sql
insert into tb_user(id, account_name, password, uid, nick_name, register_time, update_time)
values(?, ?, ?, ?, ?, ?, ? )
```
这样的sql就可以被 jdbc 处理了
同时参数允许为：
```
:id, :user.accountName, :user.password, :user.uid, :user.nickName, :user.registerTime, :user.updateTime
```
这里的 id 可以从参数中 id 直接获取，
`:user.accountName` 则需要从参数 `:user` 即 user 中通过反射获取，这样 SQL 的重写就完成了

> 返回结果集封装可以通过反射，可以直接看下面代码

**StatementParser.java**

```java
package com.zyndev.tool.fastsql.core;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.zyndev.tool.fastsql.annotation.Param;
import com.zyndev.tool.fastsql.annotation.Query;
import com.zyndev.tool.fastsql.annotation.ReturnGeneratedKey;
import com.zyndev.tool.fastsql.convert.BeanConvert;
import com.zyndev.tool.fastsql.convert.ListConvert;
import com.zyndev.tool.fastsql.convert.SetConvert;
import com.zyndev.tool.fastsql.util.BeanReflectionUtil;
import com.zyndev.tool.fastsql.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sql 语句解析
 * <p>
 * 暂时只能处理 select count(*) from tb_user 类似语句
 *
 * @author 张瑀楠 zyndev@gmail.com
 * @version 0.0.1
 * @since 2017 /12/23 下午12:11
 */
class StatementParser {

    private final static Log logger = LogFactory.getLog(StatementParser.class);

    private static PreparedStatementCreator getPreparedStatementCreator(final String sql, final Object[] args, final boolean returnKeys) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql);
                if (returnKeys) {
                    ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                } else {
                    ps = con.prepareStatement(sql);
                }

                if (args != null) {
                    for (int i = 0; i < args.length; i++) {
                        Object arg = args[i];
                        if (arg instanceof SqlParameterValue) {
                            SqlParameterValue paramValue = (SqlParameterValue) arg;
                            StatementCreatorUtils.setParameterValue(ps, i + 1, paramValue,
                                    paramValue.getValue());
                        } else {
                            StatementCreatorUtils.setParameterValue(ps, i + 1,
                                    SqlTypeValue.TYPE_UNKNOWN, arg);
                        }
                    }
                }
                return ps;
            }
        };
        return creator;
    }

    /**
     * 此处对 Repository 中方法进行解析，解析成对应的sql 和 参数
     * <p>
     * sql 来自于 @Query 注解的 value
     * 参数 来自方法的参数
     * <p>
     * 注意根据返回值的不同封装结果集
     *
     * @param proxy  执行对象
     * @param method 执行方法
     * @param args   参数
     * @return object
     */
    static Object invoke(Object proxy, Method method, Object[] args) throws Exception {

        JdbcTemplate jdbcTemplate = DataSourceHolder.getInstance().getJdbcTemplate();

        boolean logDebug = logger.isDebugEnabled();

        String methodReturnType = method.getReturnType().getName();
        Query query = method.getAnnotation(Query.class);

        if (null == query || StringUtil.isBlank(query.value())) {
            logger.error(method.toGenericString() + " 无 query 注解或 SQL 为空");
            throw new IllegalStateException(method.toGenericString() + " 无 query 注解或 SQL 为空");
        }

        String originSql = query.value().trim();

        System.out.println("sql:" + query.value());
        Map<String, Object> namedParamMap = new HashMap<>();
        Parameter[] parameters = method.getParameters();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; ++i) {
                Param param = parameters[i].getAnnotation(Param.class);
                if (null != param) {
                    namedParamMap.put(param.value(), args[i]);
                }
                namedParamMap.put("?" + (i + 1), args[i]);
            }
        }

        if (logDebug) {
            logger.debug("执行 sql: " + originSql);
        }

        // 判断 sql 类型, 判断是否为 select 开头语句
        boolean isQuery = originSql.trim().matches("(?i)select([\\s\\S]*?)");
        Object[] params = null;
        // rewrite sql
        if (null != args && args.length > 0) {
            List<String> results = StringUtil.matches(originSql, "\\?\\d+(\\.[A-Za-z]+)?|:[A-Za-z0-9]+(\\.[A-Za-z]+)?");
            if (results.isEmpty()) {
                params = args;
            } else {
                params = new Object[results.size()];
                for (int i = 0; i < results.size(); ++i) {
                    if (results.get(i).charAt(0) == ':') {
                        originSql = originSql.replaceFirst(results.get(i), "?");
                        // 判断是否是 param.param 的格式
                        if (!results.get(i).contains(".")) {
                            params[i] = namedParamMap.get(results.get(i).substring(1));
                        } else {
                            String[] paramArgs = results.get(i).split("\\.");
                            Object param = namedParamMap.get(paramArgs[0].substring(1));
                            params[i] = BeanReflectionUtil.getFieldValue(param, paramArgs[1]);
                        }
                        continue;
                    }
                    int paramIndex = Integer.parseInt(results.get(i).substring(1));
                    originSql = originSql.replaceFirst("\\?" + paramIndex, "?");
                    params[i] = namedParamMap.get(results.get(i));
                }
            }
        }


        System.out.println("execute sql:" + originSql);
        System.out.print("params : ");
        if (null != params) {
            for (Object o : params) {
                System.out.print(o + ",\t");
            }
        }
        System.out.println("\n");


        /**
         * 如果返回值是基本类型或者其包装类
         */
        System.out.println(methodReturnType);
        if (isQuery) {
            // 查询方法
            if ("java.lang.Integer".equals(methodReturnType) || "int".equals(methodReturnType)) {
                return jdbcTemplate.queryForObject(originSql, params, Integer.class);
            } else if ("java.lang.String".equals(methodReturnType)) {
                return jdbcTemplate.queryForObject(originSql, params, String.class);
            } else if ("java.util.List".equals(methodReturnType) || "java.util.Set".equals(methodReturnType)) {
                String typeName = null;
                Type returnType = method.getGenericReturnType();
                if (returnType instanceof ParameterizedType) {
                    Type[] types = ((ParameterizedType) returnType).getActualTypeArguments();
                    if (null == types || types.length > 1) {
                        throw new IllegalArgumentException("当返回值为 list 时，必须标明具体类型，且只有一个");
                    }
                    typeName = types[0].getTypeName();
                }
                Object obj = BeanReflectionUtil.newInstance(typeName);
                SqlRowSet rowSet = jdbcTemplate.queryForRowSet(originSql, params);
                if ("java.util.List".equals(methodReturnType)) {
                    return ListConvert.convert(rowSet, obj);
                }
                return SetConvert.convert(rowSet, obj);
            } else if ("java.util.Map".equals(methodReturnType)) {
                throw new NotImplementedException();
            } else {
                SqlRowSet rowSet = jdbcTemplate.queryForRowSet(originSql, params);
                Object obj = BeanReflectionUtil.newInstance(methodReturnType);
                return BeanConvert.convert(rowSet, obj);
            }
        } else {
            // 非查询方法
            // 判断是否是insert 语句
            ReturnGeneratedKey returnGeneratedKeyAnnotation = method.getAnnotation(ReturnGeneratedKey.class);
            if (returnGeneratedKeyAnnotation == null) {
                int retVal = jdbcTemplate.update(originSql, params);
                if ("java.lang.Integer".equals(methodReturnType) || "int".equals(methodReturnType)) {
                    return retVal;
                } else if ("java.lang.Boolean".equals(methodReturnType)) {
                    return retVal > 0;
                }
            } else {
                // 判断是否是 insert 语句
                boolean isInsertSql = originSql.trim().matches("(?i)insert([\\s\\S]*?)");
                if (isInsertSql) {
                    KeyHolder keyHolder = new GeneratedKeyHolder();
                    PreparedStatementCreator preparedStatementCreator = getPreparedStatementCreator(originSql, params, true);
                    jdbcTemplate.update(preparedStatementCreator, keyHolder);
                    if ("java.lang.Integer".equals(methodReturnType) || "int".equals(methodReturnType)) {
                        return keyHolder.getKey().intValue();
                    } else if ("java.lang.Long".equals(methodReturnType) || "long".equals(methodReturnType)) {
                        return keyHolder.getKey().longValue();
                    }
                    logger.error(method.toGenericString() + " 返回主键id应该为 int 或者 long 类型 ");
                    throw new IllegalArgumentException(method.toGenericString() + " 返回主键id应该为 int 或者 long 类型 ");
                } else {
                    logger.error(method.toGenericString() + " 非 insert 语句 无法返回 GeneratedKey： sql语句为：" + originSql);
                    throw new IllegalStateException(method.toGenericString() + " 非 insert 语句 无法返回 GeneratedKey： sql语句为：" + originSql);
                }
            }
        }
        return null;
    }
}

```


> 谢谢阅读，如果喜欢请关注
