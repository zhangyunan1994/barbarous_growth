-------------------------------
SocketChannel					|
-------------------------------
	# SocketChannel是一个连接到TCP网络套接字的通道。
	# 可以通过以下2种方式创建SocketChannel：
		1,打开一个SocketChannel并连接到互联网上的某台服务器。				
		2,一个新连接到达ServerSocketChannel时，会创建一个SocketChannel。
	# 打开 SocketChannel
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
	
	# 关闭 SocketChannel
		socketChannel.close();
	
	# 从 SocketChannel 中读取数据

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		int bytesRead = socketChannel.read(byteBuffer);

		* 分配一个Buffer。从SocketChannel读取到的数据将会放到这个Buffer中。
		* 然后，调用SocketChannel.read()。该方法将数据从SocketChannel 读到Buffer中。
		* read()方法返回的int值表示读了多少字节进Buffer里。如果返回的是-1，表示已经读到了流的末尾（连接关闭了）。
	
	# 写入数据到 SocketChannel
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.clear();					//清空缓冲区
		buf.put(newData.getBytes());	//填充数据
		buf.flip();						//复位,limit = position,position = 0
		while(buf.hasRemaining()) {		//确定还有数据,进行写入
			channel.write(buf);
		}
		* 注意SocketChannel.write()方法的调用是在一个while循环中的。
		* Write()方法无法保证能写多少字节到SocketChannel。所以，我们重复调用write()直到Buffer没有要写的字节为止。
	
	
	# 非阻塞模式与选择器
		* 非阻塞模式与选择器搭配会工作的更好，通过将一或多个SocketChannel注册到Selector，可以询问选择器哪个通道已经准备好了读取，写入等。
		* Selector与SocketChannel的搭配使用会在后面详讲。


-------------------------------
SocketChannel-读				|
-------------------------------

-------------------------------
SocketChannel-写				|
-------------------------------

-------------------------------
SocketChannel-非阻塞模式		|
-------------------------------
	# 可以设置 SocketChannel 为非阻塞模式（non-blocking mode）.设置之后，就可以在异步模式下调用connect(), read() 和write()了。
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
		
	# write();
		* 非阻塞模式下，write()方法在尚未写出任何内容时可能就返回了。
		* 所以需要在循环中调用write()。前面已经有例子了，这里就不赘述了。

	# read();
		* 非阻塞模式下,read()方法在尚未读取到任何数据时可能就返回了。
		* 所以需要关注它的int返回值，它会告诉你读取了多少字节。
	

-------------------------------
SocketChannel-Selector			|
-------------------------------

-------------------------------
SocketChannel-API				|
-------------------------------