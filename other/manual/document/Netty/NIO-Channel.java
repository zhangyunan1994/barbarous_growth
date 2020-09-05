-------------------------------
Netty-Channel					|
-------------------------------
	# 通道,跟自来水管道没啥区别.网络数据通过 Channel 读取/写入,'与传统流不同的是,它双向的',而流要么是读流,要么是写流
	# 最叼的是,这个通道可以同时的进行读/写
	# 最关键的是,可以和多路复用器结合起来,有多种状态位,方便多路复用器去识别.
	# 事实上,通道分为两大类
		1,SelectableChannel 网络读写
			* DatagramChannel		//从UDP中读写数据
			* SocketChannel			//从TCP中读写数据
			* ServerSocketChannel	//可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

		2,FileChannel				//从文件中读写数据
	





