----------------------------
DatagramChannel				|
----------------------------
	# DatagramChannel是一个能收发UDP包的通道。
	# 因为UDP是无连接的网络协议，所以不能像其它通道那样读取和写入。它发送和接收的是数据包。
	# 打开 DatagramChannel 
		DatagramChannel channel = DatagramChannel.open();
		channel.socket().bind(new InetSocketAddress(9999));	//打开的 DatagramChannel可以在UDP端口9999上接收数据包。


----------------------------
DatagramChannel-接收数据	|
----------------------------
	DatagramChannel channel = DatagramChannel.open();
	channel.socket().bind(new InetSocketAddress(9999));
	ByteBuffer buf = ByteBuffer.allocate(48);
	buf.clear();
	channel.receive(buf);

	* receive()方法会将接收到的数据包内容复制到指定的Buffer. 
	* 如果Buffer容不下收到的数据，多出的数据将被丢弃。
	

----------------------------
DatagramChannel-发送数据	|
----------------------------
	DatagramChannel channel = DatagramChannel.open();
	channel.socket().bind(new InetSocketAddress(9999));
	String newData = "New String to write to file..." + System.currentTimeMillis();
	ByteBuffer buf = ByteBuffer.allocate(48);		//构建Buffere
	buf.clear();									//position = 0
	buf.put(newData.getBytes());					//填充数据,position = newData.length;
	buf.flip();										//复位,因为要从里面读取数据 position = 0
	int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));
	
----------------------------
连接到特定的地址			|
----------------------------
	# 可以将DatagramChannel'连接'到网络中的特定地址的。
	# 由于UDP是无连接的，连接到特定地址并不会像TCP通道那样创建一个真正的连接。而
	# 只锁住DatagramChannel ，让其只能从特定地址收发数据。
		DatagramChannel channel = DatagramChannel.open();
		/**
			把 Channel 绑定在某个通道上
			也可以使用read()和write()方法，就像在用传统的通道一样。
		*/
		channel.socket().bind(new InetSocketAddress(9999));
		int bytesRead = channel.read(buf);
		int bytesWritten = channel.write(but);



----------------------------
DatagramChannel-API			|
----------------------------