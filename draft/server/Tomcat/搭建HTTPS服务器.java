----------------------------
Tomcat-搭建HTTPS服务器		|
----------------------------
	# 对于HTTPS,势在必行.
	
	1,为网站创建数字证书
		
		* 使用的是$JAVA_HOME/bin/keytool 工具(JAVA里面自带的工具)

		* keytool -genkey -alias tomcat -validity 36500 -keystore D:\home\tomcat.keystore -keyalg RSA

			* -genkey		:表示产生密钥对
			* -alias		:表示起个别名
			* -keyalg		:指定密钥算法
			* -validity		:密钥有效时间,默认为90天,36500.表示100年
			* -keystore		:指定密钥保存的路径

		
	
		* 输入 keystore 密码
			产生的证书,系统会使用一个密钥库来保存,这里就是设置密钥库的密码
		
		* 您的名字与姓氏是什么?
			这一步很重要,表示为哪个网站生成数字证书,填写域名
		
		* 您的组织单位名称是什么？
			* 无视
		
		* 您的组织名称是什么？
			* 无视
		
		* 您所在的城市或者区域名称是什么?
			* 无视
		
		* 您所在的洲,或省份是什么?
			* 无视
		
		* 该单位的两字母国家代码是什么?
			* 无视
		
		* CN=localhost,OU=Unknow,O=Unknow,L=Unknow,ST=Unknow,C=Unknow 正确吗?
			* 确定输入: y
		
		* 输入 <tomcat> 的主密码(如果和 keystore 密码相同,直接回车)
			* 数字证书的密钥,和密钥库的密码是否相同.
			* 这项较为重要，会在tomcat配置文件中使用，建议输入与keystore的密码一致，设置其它密码也可以
		
		* OK,在~目录下,会生成 .keystore 一个证书文件
			* 至此,证书创建成功
	
	2,配置服务器
		* 把 .keystore 文件复制到 $TOMCAT_HOME/conf 目录下
		* 修改server.xml,其中有段已经注释掉的
			  <Connector
				port="8443" 
				protocol="org.apache.coyote.http11.Http11Protocol"
				maxThreads="150" 
				SSLEnabled="true" 
				scheme="https" 
				secure="true"
				clientAuth="false" 
				sslProtocol="TLS"  
				keystoreFile="conf/.keystore"		//指定密钥文件
				keystorePass="123456"/>				//指定密钥库的密码
			

			
			
----------------------------
Tomcat-阿里云				|
----------------------------
	

		