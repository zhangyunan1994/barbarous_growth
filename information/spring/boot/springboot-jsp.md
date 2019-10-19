------------------------------
Spring-boot 使用JSP视图		  |
------------------------------
	# 参考网站
		* http://www.cnblogs.com/God-/p/5857428.html
		* http://blog.csdn.net/alan666156/article/details/52168450


------------------------------
Spring-boot				方案一 |
------------------------------
	1,maven 创建 web项目
		* 其实就是WEB项目其实是无所谓,但是要确定目录: src/main/webapp 是存在的

	2,在pom.xml中添加依赖
		<!--JSTL标签库-->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
		<!-- Servlet -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
		</dependency>
		<!-- jsp解析 -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>

	3,在application.properties中添加配置来支持JSP
		spring.mvc.view.prefix=/WEB-INF/views
		spring.mvc.view.suffix=.jsp
	


	