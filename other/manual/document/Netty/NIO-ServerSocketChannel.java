---------------------------------
ServerSocketChannel				 |
---------------------------------
	# ServerSocketChannel 是一个可以监听新进来的TCP连接的通道,
	# 就像标准IO中的ServerSocket一样。ServerSocketChannel类在 java.nio.channels包中。
	# Demo	
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));	//绑定端口
		while(true){
			SocketChannel socketChannel = serverSocketChannel.accept();
			//do something with socketChannel...
		}
	# accept(); 会一直阻塞线程,直到有新的客户端连接进来


---------------------------------
ServerSocketChannel-非阻塞模式	 |
---------------------------------
	# ServerSocketChannel可以设置成非阻塞模式。
	# 在非阻塞模式下，accept() 方法会立刻返回，如果还没有新进来的连接,返回的将是null。 因此，需要检查返回的SocketChannel是否是null.
	# Demo
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		serverSocketChannel.configureBlocking(false);		//设置为非阻塞模式
		while(true){
			SocketChannel socketChannel = serverSocketChannel.accept();
			if(socketChannel != null){
				//do something with socketChannel...
			}
		}


---------------------------------
ServerSocketChannel-API			 |
---------------------------------
	