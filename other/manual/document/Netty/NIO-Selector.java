----------------------------
Selector					|
----------------------------
	# 多路复用器,它是NIO编程的基础,非常重要.多路复用器,提供'选择已经就绪的任务的能力'
	# 简单说,Selector 会不断的轮询,注册在其上的通道 Channel,如果某个通道发生了读写操作.这个通道就处于就绪状态.会被 Selector 轮询出来,然后通过 SelectionKey 可以 取得就绪的 Channel 集合,从而进行后续的操作
	# 一个多路复用器,可以负责成千上万的 Channel 通道,没有上限.这也是JDK使用 epoll代替了传统 Select实现,获取连接句柄没有限制,意味着我们只需要一个线程负责 Selector 的轮询.就可以接入成千上万的客户端,这就是JDK NIO库的巨大进步
	# Selector 线程就类似于一个管理者(Master),管理成千万的通道,然后轮询出哪个通道已经准备好.通知CPU执行I/O操作
	# Selector 模式:当IO事件(管道)注册到选择器后,Selector 会分配给每个管道一个 key 值,标签.Selector 轮询注册的管道,当管道就绪后, select就会识别,通过key值来找到对应的管道.进行相关数据处理操作.(写入,或者读到缓冲区)
	# 每个管道都会对选择器注册不同的事件状态,以便选择器查找

		SelectionKey.OP_ACCEPT	//用于套接字接受操作的操作集位。
		SelectionKey.OP_CONNECT //用于套接字连接操作的操作集位。
		SelectionKey.OP_READ	//用于读取操作的操作集位。
		SelectionKey.OP_WRITE	//用于写入操作的操作集位。
	
	# Selector允许单线程处理多个 Channel。
	# 如果你的应用打开了多个连接（通道），但每个连接的流量都很低，使用Selector就会很方便。
	# 例如，在一个聊天服务器中。这是在一个单线程中使用一个Selector处理3个Channel的图示：
				Thread
				  |
			   Selector
			|----|----|
		Channel Channel Channel
	
----------------------------
Selector-创建				|
----------------------------
	Selector selector = Selector.open();

----------------------------
Selector-注册通道(Channel)	|
----------------------------
	# 为了将Channel和Selector配合使用，必须将channel注册到selector上。
	# 与Selector一起使用时，Channel必须处于非阻塞模式下。
	# 这意味着'不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以'。
	# 通过SelectableChannel.register()方法来实现

		Selector selector = Selector.open();
		channel.configureBlocking(false);		//设置非阻塞模式
		SelectionKey key = channel.register(selector,Selectionkey.OP_READ);

		* 第一个参数,就是 channel 要注册的 selector
		* 第二个参数,是监听的事件,枚举值,意思是在通过Selector监听Channel时对什么事件感兴趣。可以监听四种不同类型的事件：
			SelectionKey.OP_ACCEPT	
			SelectionKey.OP_CONNECT 
			SelectionKey.OP_READ	
			SelectionKey.OP_WRITE

	# 通道触发了一个事件意思是该事件已经就绪。
		* 某个channel成功连接到另一个服务器称为"连接就绪"。
		* 一个server socket channel准备好接收新进入的连接称为"接收就绪"。
		* 一个有数据可读的通道可以说是"读就绪"。
		* 等待写数据的通道可以说是"写就绪"。
	
	# 如果需要注册多个事件,就用位移操作运算多个事件
		int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;


----------------------------
Selector-SelectionKey		|
----------------------------
	# 当向Selector注册Channel时，register()方法会返回一个SelectionKey对象。这个对象包含了一些属性
		interest集合
		ready集合
		Channel
		Selector
		附加的对象（可选）
	
	# interest集合
		interest集合是你所选择的感兴趣的事件集合。可以通过 SelectionKey 读写interest集合
		int interestSet = selectionKey.interestOps();
		boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
		boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
		boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;
		boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE;
		
		* 可以看到，用"位与"操作interest 集合和给定的SelectionKey常量，可以确定某个确定的事件是否在interest 集合中。
	
	# ready集合
		# ready 集合是通道已经准备就绪的操作的集合。
		# 在一次选择(Selection)之后，你会首先访问这个ready set。Selection将在下一小节进行解释。可以这样访问ready集合
			int readySet = selectionKey.readyOps();
		# 可以用像检测interest集合那样的方法，来检测channel中什么事件或操作已经就绪。但是，也可以使用以下四个方法，它们都会返回一个布尔类型
			selectionKey.isAcceptable();		//是否可以接收客户端的请求
			selectionKey.isConnectable();		//是否有客户端连接
			selectionKey.isReadable();			//是否可读
			selectionKey.isWritable();			//是否可写

	# 访问 Channel 和 Selector
		Channel  channel  = selectionKey.channel();
		Selector selector = selectionKey.selector();
	

	# 附加的对象
		* 可以将一个对象或者更多信息附着到SelectionKey上，这样就能方便的识别某个给定的通道。
		* 例如，可以附加与通道一起使用的Buffer，或是包含聚集数据的某个对象。使用方法如下：
			selectionKey.attach(theObject);						//设置附加对象
			Object attachedObj = selectionKey.attachment();		//获取附加对象
		* 也可以在通道注册的时候设置附加对象('最后一个参数')
			SelectionKey key = channel.register(selector,Selectionkey.OP_READm,attachedObj);

	# API
		
----------------------------
Selector-选择通道			|
----------------------------
	# 一旦向Selector注册了一或多个通道，就可以调用几个重载的select()方法。
	# 这些方法返回你所感兴趣的事件（如连接、接受、读或写）已经准备就绪的那些通道。
	# 换句话说，如果你对“读就绪”的通道感兴趣，select()方法会返回读事件已经就绪的那些通道。
	#　select 方法
		int select();
			* 阻塞到至少有一个通道在你注册的事件上就绪了。
		int select(long timeout);
			* 和select()一样，除了最长会阻塞timeout毫秒(参数)。
		int selectNow();
			* 不会阻塞，不管什么通道就绪都立刻返回
			* 此方法执行非阻塞的选择操作。如果自从前一次选择操作后，没有通道变成可选择的，则此方法直接返回零。

----------------------------
Selector-API				|
----------------------------
	