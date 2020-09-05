# Nginx

<!-- TOC -->

- [Nginx](#nginx)
    - [Nginx 简介](#nginx-简介)
    - [高并发连接](#高并发连接)
    - [下载和安装](#下载和安装)
        - [widows 版本](#widows-版本)
- [Linux](#linux)
- [Windows](#windows)
- [./nginx/logs/nginx.pid](#nginxlogsnginxpid)
- [关于显示目录结构](#关于显示目录结构)

<!-- /TOC -->

## Nginx 简介

[维基百科](https://en.wikipedia.org/wiki/Nginx)

Nginx (engine x) 是一个高性能的HTTP和反向代理服务器，也是一个IMAP/POP3/SMTP服务器。Nginx是由伊戈尔·赛索耶夫为俄罗斯访问量第二的Rambler.ru站点（俄文：Рамблер）开发的，第一个公开版本0.1.0发布于2004年10月4日。

其将源代码以类BSD许可证的形式发布，因它的稳定性、丰富的功能集、示例配置文件和低系统资源的消耗而闻名。2011年6月1日，nginx 1.0.4发布。
	
Nginx是一款轻量级的Web 服务器/反向代理服务器及电子邮件（IMAP/POP3）代理服务器，并在一个BSD-like 协议下发行。其特点是占有内存少，并发能力强，事实上nginx的并发能力确实在同类型的网页服务器中表现较好，中国大陆使用nginx网站用户有：百度、京东、新浪、网易、腾讯、淘宝等。

* 是一个高性能的HTTP和反向代理服务器
* 支持的操作系统众多:Windows,Linux,MacOS X
* 可以实现负载均衡
* Rewrite功能强大
	
## 高并发连接
* 官方测试,理想状态下,可以支撑5W并发.实际测试可以达3W左右.每天可以处理上亿次的请求
* 采用最新epoll(Linux2.6内核)和kqueue(feebsd)网络IO模型,而Apache采用传统select模型



## 下载和安装
### widows 版本
	http://nginx.org/en/download.html
	*	Mainline version:内核版
	*	Stable version	:文档版


------------------------
Nginx-常规命令			|
------------------------
# Linux
	1,源码安装
		启动
			./sbin/nginx
			* 直接绝对路径执行nginx就OK
			
		关闭
			./sbin/nginx -s stop
			* 也是绝对路径,-s 参数,stop命名,当然也可以使用 kill命令
			kill -QUIT `cat /usr/local/nginx/logs/nginx.pid`
			* 这种方式在业内是比较专业的.处理完毕最后一个请求后.执行关闭

		重新加载
			./sbin/nginx -s reload
			* 也是绝对路径操作它

		开机启动
			*  直接写入:/etc/rc.d/rc.local	文件
		
		检查配置文件是否OK
			./sbin/nginx -t -c /usr/local/nginx/conf/nginx.conf
			* -t 是检测,-c是配置文件
		
		查看编译安装时候带的参数
			./ngin -V

		
	2,rpm安装的我就不说了
		service...
		chkconfig nginx on

	
	* Nginx命令大全
		https://www.nginx.com/resources/wiki/start/topics/tutorials/commandline/
	* ./nginx -h
		* 可以查看Nginx命令的选项

# Windows
	* 进入Nginx目录
	* 打开CMD输入
	启动	
		start nginx.exe

	停止	
		nginx.exe -s stop

	重新加载
		nginx.exe -s reload

	# Nginx的使用目录中不要包含中文
	# 在任务管理器中看到两个Nginx的进程,那么Nginx才是正常启动


------------------------
Nginx-一些知识			|
------------------------

# ./nginx/logs/nginx.pid
	* 该文件里面写入的是当前Nginx运行的PID

# 关于显示目录结构
	* 虚拟主机映射到一个目录,当url指向目录的时候.没有指定index.会报403
	* 可以在location中添加如下配置

	autoindex on;				# 显示目录
	autoindex_exact_size on;	# 显示文件大小
	autoindex_localtime on;		# 显示文件时间


