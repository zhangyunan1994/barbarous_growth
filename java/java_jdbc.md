<h1> introduction </h1>


**Table of Contents**

<!-- TOC -->

- [使用 `JDBC` 完成一个简单的数据库操作](#使用-jdbc-完成一个简单的数据库操作)

<!-- /TOC -->

简单的说，JDBC 可以做三件事：
1. 与数据库建立链接
1. 发送、操作数据库的语句
1. 处理结果

# 使用 `JDBC` 完成一个简单的数据库操作
我们先看看我们最熟悉也是最基础的通过JDBC查询数据库数据，一般需要以下七个步骤：
 
1. 加载数据库驱动
2. 创建并获取数据库链接(Connection)
3. 创建statement对象(Statement或PreparedStatement)
4. 设置sql语句
5. 通过statement执行sql并获取结果
6. 对sql执行结果进行解析处理
7. 释放资源(resultSet、statement、connection)

> 数据库驱动由各个数据库厂商实现

参考代码

```java
package com.zyndev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcTest {
    public static void main(String[] args) {
        //数据库连接
        Connection connection = null;
        //预编译的Statement，使用预编译的Statement提高数据库性能
        Statement statement = null;
        //结果集
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库链接
            connection =  DriverManager.getConnection("jdbc:mysql://127。0.0.1:3306/test?characterEncoding=utf-8", "root", "root");
            //定义sql语句 ?表示占位符
            String sql = "select id,name from user";
            //获取预处理statement
            statement = connection.createStatement(sql);
            //向数据库发出sql执行查询，查询出结果集
            resultSet =  statement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

```