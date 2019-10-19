-----------------------
MyBatis-分页插件		|
-----------------------
	# maven仓库,一共有俩依赖
		<dependency>
			<groupId>com.github.pagehelper</groupId>
			<artifactId>pagehelper</artifactId>
			<version>${pagehelper.version}</version>
		</dependency>						
		<dependency>
			<groupId>com.github.jsqlparser</groupId>
			<artifactId>jsqlparser</artifactId>
			<version>${jsqlparser.version}</version>
		</dependency>
	
-----------------------
MyBatis-集成			|
-----------------------
	# 在mybatis全局配置中,添加插件
		<plugin interceptor="com.github.pagehelper.PageHelper">
			<!-- 指定数据库版本 -->
	        <property name="dialect" value="mysql"/>
			<!-- 默认为false
				使用RowBounds分页会进行count查询,就是说是不是要查询数据的总条数
			-->
	        <property name="rowBoundsWithCount" value="true"/>
		</plugin>
	# 最详细的配置信息
		<plugins>
			<!-- com.github.pagehelper为PageHelper类所在包名 -->
			<plugin interceptor="com.github.pagehelper.PageHelper">
				<property name="dialect" value="mysql"/>
				<!-- 该参数默认为false -->
				<!-- 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用 -->
				<!-- 和startPage中的pageNum效果一样-->
				<property name="offsetAsPageNum" value="true"/>
				<!-- 该参数默认为false -->
				<!-- 设置为true时，使用RowBounds分页会进行count查询 -->
				<property name="rowBoundsWithCount" value="true"/>
				<!-- 设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果 -->
				<!-- （相当于没有执行分页查询，但是返回结果仍然是Page类型）-->
				<property name="pageSizeZero" value="true"/>
				<!-- 3.3.0版本可用 - 分页参数合理化，默认false禁用 -->
				<!-- 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页 -->
				<!-- 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据 -->
				<property name="reasonable" value="true"/>
			</plugin>
		</plugins>
	
	# 与spring集成
		<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		  <property name="dataSource" ref="dataSource"/>
		  <property name="mapperLocations">
			<array>
			  <value>classpath:mapper/*.xml</value>									*/
			</array>
		  </property>
		  <property name="typeAliasesPackage" value="com.isea533.ssm.model"/>
		  <property name="plugins">
			<array>
			  <bean class="com.github.pagehelper.PageHelper">
				<property name="properties">
				  <value>
					dialect=hsqldb
					reasonable=true
				  </value>
				</property>
			  </bean>
			</array>
		  </property>
		</bean>

-----------------------
MyBatis-使用			|
-----------------------
	# 日了狗了分页工具
		PageHelper.startPage(1,3);
		List<User> list = mapper.queryAll();
		* 第几页,要多少条数据
	
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		System.out.println(pageInfo.getTotal());		//总记录数
		System.out.println(pageInfo.getPages());		//总页数