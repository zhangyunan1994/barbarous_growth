<h1> API </h1>

**Table of Contents**
<!-- TOC -->

- [Connection](#connection)
- [Statement](#statement)
- [ResultSet](#resultset)
- [PreparedStatement](#preparedstatement)
- [DatabaseMetaData](#databasemetadata)
- [参考书籍和资料](#参考书籍和资料)

<!-- /TOC -->

# Connection
代表一个数据库连接

**常用方法**
- Statement createStatement();
	
	创建一个Statement对象
- PreparedStatement prepareStatement(String sql);
	
	根据SQL出创建一个PreparedStatement对象
- CallableStatement prepareCall(String sql);
	
	创建一个CallableStatement对象来调用数据库存储过程
- setAutoCommit(boolean transaction);
	
	如果该值为 false 则开启手动事务,需要手动执行 commit 才会提交
- commit();
	
	提交事务
- rollback();
	
	回滚事务
# Statement
是一个接口,可以使用它来执行SQL语句
 
**实例方法**

- boolean execute(String sql)
	
	执行SQL
- ResultSet executeQuery(String sql);
	
	执行给定的 SQL 检索 语句，该语句返回单个 ResultSet 对象。
- int executeUpdate(String sql)
	
	执行给定 SQL 语句，该语句可能为 INSERT、UPDATE 或 DELETE 语句，或者不返回任何内容的 SQL 语句（如 SQL DDL 语句）,返回受影响的行数
# ResultSet

SQL执行结果集
**实例方法**

- first()
	
	将光标移动到此 ResultSet 对象的第一行。
- next();
	
	指针移到下一行,如果有下一行返回 true
- previous();
	
	指针移到上一行
- getObject(int columnIndex);
	
	获取指定 index 列的数据,以Object形式返回
- getObject(String columnLabel);
	
	获取指定 列名称 的数据,以Object形式返回
- getString(String columnName);
	
	获取指定字段的String类型值
- getString(int columnIndex);
	
	获取指定索引的String类型值
	
# PreparedStatement
预编译SQL的,statement,可以防止SQL注入
**实例方法**

- setString(int index, String param);
	
	给第index个问号赋值，有N多重载(setXxx),可以赋值不同的数据类型，注意'?'号的角标是从1开始,而不是0
- boolean execute()
	
	执行SQL语句该语句可以是任何种类的 SQL 语句。
- ResultSet executeQuery();
	
	执行检索,并返回该查询生成的 ResultSet 对象。
- int executeUpdate()
	
	执行插入或者修改语句


# DatabaseMetaData

# 参考书籍和资料
