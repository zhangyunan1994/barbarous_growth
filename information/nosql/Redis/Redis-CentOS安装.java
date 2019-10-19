1,官网下载
	https://redis.io/
2,解压
3,进入解压目录
4,指定安装目录,编译,安装
	make PREFIX=/usr/local/redis install
	* 注意:PREFIX是大写
	* 会在指定目录下生成目录
	bin
		redis-benchmark
		redis-check-aof
		redis-check-rdb
		redis-cli
		redis-sentinel -> redis-server
		redis-server
5,复制配置文件到目录
	从源文件目录下复制
	redis.conf
	* cp ./redis.conf /usr/local/redis/conf/

6,配置为服务,复制配置文件
	从源目录下复制文件到 /etc/ini.d 目录下,更名为redis
	cp ./utils/redis_init_script /etc/init.d/redis

7,编辑配置
	vim /etc/init.d/redis

	

	