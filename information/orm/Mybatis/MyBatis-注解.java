----------------------------
MyBatis-注解				|
----------------------------
	@Param
		* 这个注解,是标识在Mapper接口的形参上
		* 其实就是说,Mapper接口的形参,可以是多个简单的数据类型,通过注解来声明名称,在mapper.xml中就使用注解标识的名称来代表参数名称
		* 通过这个注解,来指定入参的参数名
		['Demo']
			public User queryByNameAndPass(
										@Param(value="userName")String userName,
										@Param(value="password")String password);

			<select id="queryByNameAndPass" resultType="User">
				SELECT * FROM tb_user WHERE user_name = #{userName} AND password = #{password}
			</select>
	
	@Insert
	@Update
	@Delete
	@Selct
		# 以上注解,一眼就看明白
	
	@Result
	@Results
