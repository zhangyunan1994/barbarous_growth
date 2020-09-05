--------------------
JAVA-脚本引擎		|
--------------------
	# 其实就是在JAVA代码中执行JavaScript的代码
	# JAVA只是提供了这个接口,但是没提供实现,由其他的脚本厂商自己编写实现.
	# 案例
		1,客户端传递了一个字符串
			"3 * 4 / 2 + 6 -5"
		2,该字符串应该用于计算最后的结果
		3,如果是使用JAVA来完成,就比较的麻烦
		4,如果是JavaScript那就简单 eval();函数就搞定
	# 脚本引擎是JDK6.0以后添加的新功能
		* 其实就是,JAVA应用程序可以通过一套固定的接口与'各种脚本引擎'交互
		* 从而达到在Java平台上调用各种脚本语言的目的
		* Java脚本API是连通Java平台好脚本语言的桥梁
		* 可以把一些复杂异变的业务逻辑交给脚本语言处理,这也大大提高了开发效率
		* 其实就是可以在java程序中执行其他的脚本语言
		* 6.0后javascript-->Rhino被添加到了JDK
	# 获取脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
	# Java脚本API为开发者提供了N多功能
		* 获取脚本程序输入,通过脚本引擎运行脚本并返回运行结果.
		* 核心的接口 : ScriptEngineFactory
			1,注意:是接口,JAVA可以使用各种不同的实现,从而调用js,groovy,python等脚本
			2,JavasScript  -->  RhinoEngineFactory
			3,Rhino 是一种使用java语言编写的javascript代码
			* Rhino <<JavaScript权威指南>>,这本书封面就是Rhino.
	# Demo
		public static void demo() throws ScriptException{
			ScriptEngineManager sem = new ScriptEngineManager();
			//获取JavaScript的脚本引擎
			ScriptEngine engine = sem.getEngineByName("javascript");
			/*
				定义一个变量,存储到引擎上下文中
				Java可以获取到,引擎也可以获取到
			*/
			engine.put("key", "value");
			/*
				定义一串JavaScript脚本语言
			*/
			String str = "var user = {name:'KevinBlandy',age:22,gender:'男'};";
			engine.eval(str);
		}

	
	# 还可以去执行或者加载,URL上的,本地的JS代码文件
