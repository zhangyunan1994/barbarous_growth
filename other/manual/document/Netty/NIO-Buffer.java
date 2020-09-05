-------------------------------
Netty-Buffer					|
-------------------------------
	# Buffer 是一个对象,它包含一些要写入或者读取的数据,在NIO类库中加入 Buffer 对象,提现了新库与原IO的一个重要区别
	# 在所有流的IO中可以把数据直接写入到 Stream 对象,'在NIO库中,所有的数据都是用缓冲区处理读写的'
	# 缓冲区实质上是一个数组,通常它是一个字节数组,(ByteBuffer),也可以使用其他类型的数组,这个数组为缓冲区提供了数据的访问读写等操作.如果:位置,容量,上限等概念(看API)
	# Buffer 类型,我们最常用的就是 ByteBuffer ,实际上每种JAVA基本类型都有一种缓冲区(除了 Boolean 类型)
	# 一些列的类
		ByteBuffer
		CharBuffer
		ShortBuffer
		IntBuffer
		LongBuffer
		FloatBuffer
		DoubleBuffer

		MappedByteBuffer	//它比较特别 用于表示内存映射文件5


-------------------------------
Netty-Buffer 属性				|
-------------------------------
	# capacity,position,limit
	# 缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。
	# 为了理解Buffer的工作原理，需要熟悉它的三个属性：
		capacity
		position
		limit

	# capacity
		* 作为一个内存块，Buffer有一个固定的大小值，也叫"capacity".你只能往里写capacity个byte、long，char等类型。
		* 一旦Buffer满了，需要将其清空（'通过读数据或者清除数据'）才能继续写数据往里写数据。
		
	# position
		* 当你写数据到Buffer中时，position表示当前的位置。初始的position值为0.当一个byte、long等数据写到Buffer后， position会向前移动到下一个可插入数据的Buffer单元。
		* position最大可为capacity – 1.

	# limit
		* 在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据。 写模式下，limit等于Buffer的capacity。			
		* 当切换Buffer到读模式时，limit会被设置成写模式下的position值。也就是说,也就是说可以读取到多少数据


-------------------------------
Netty-Buffer 分配				|
-------------------------------
	# 要想获得一个Buffer对象首先要进行分配。 每一个Buffer类都有一个allocate方法。
	# Demo
		ByteBuffer buf = ByteBuffer.allocate(48);		//分配48字节capacity的ByteBuffer。
		CharBuffer buf = CharBuffer.allocate(1024);		//分配1024字节capacity的CharBuffer。

-------------------------------
Netty-Buffer 写入数据			|
-------------------------------
	# 写数据到Buffer有两种方式
	# 1,从Channel写到Buffer。
		int bytesRead = inChannel.read(buf); //read into buffer.

	# 2,通过Buffer的put()方法写到Buffer里。
		buf.put(127);
		* put方法有很多版本，允许你以不同的方式把数据写入到Buffer中。
		* 例如,写到一个指定的位置,或者把一个字节数组写入到Buffer。 
		* 更多Buffer实现的细节参考JavaDoc。

-------------------------------
Netty-Buffer 读取数据			|
-------------------------------
	# 从Buffer中读取数据有两种方式：
	# 1,从Buffer读取数据到Channel。
		int bytesWritten = inChannel.write(buf);

	# 2,使用get()方法从Buffer中读取数据。
		byte aByte = buf.get();
		* get方法有很多版本，允许你以不同的方式从Buffer中读取数据。
		* 例如,从指定position读取，或者从Buffer中读取数据到字节数组。
		* 更多Buffer实现的细节参考JavaDoc。

-------------------------------
Netty-Buffer 方法				|
-------------------------------
	静态方法:
		allocate(int size);
			* 创建指定大小的缓冲区

		wrap(byte[] arr);
			* 新的缓冲区将由给定的 arr 数组支持
			* 缓冲区修改将导致数组修改，反之亦然
			* 新缓冲区的容量和界限将为 arr.length，不管arr中有没有数据,buffer的置(position)始终为零
		
		wrap(arr,num1,num2);
			* 同上
			* 新缓冲区的 position = num1,limit = (num1 + num2),capacity = arr.length
			* 简单说:把arr放入缓冲区,从arr的 num1 角标开始取值,取num2 个数据

	实例方法:

	get();
		* 获取到缓冲区中的数据,返回的是一单位(ByteBuffer 返回的就是 byte)
		* 每次执行 get(),都会让 position 向前移动一位
		* 有N多重载方法
	
	get(index);
		* 获取指定下标的值
		* position 不会发生变化
	
	remaining();
		* 返回当前位置与限制之间的元素数。 
	
	void flip();
		* 复位,也就是从写的状态转换为读的状态.
		* 将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。
	
	void clear();
		* clear 并没有清理数据,而是设置了postion和limit的值，让过去的数据被遗忘
		* position将被设回0，limit被设置成 capacity的值。
		* 换句话说，Buffer 被清空了。Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据。

	void compact();
		* 清空缓冲区,只会清除已经读过的数据。
		* 任何未读的数据都被移到缓冲区的起始处,新写入的数据将放到缓冲区未读数据的后面。
		* 将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。
		* limit属性依然 跟 clear()方法一样，设置成capacity。
		* 现在Buffer准备好写数据了，但是不会覆盖未读的数据。
	
	put(byte bt);
		* 向缓冲区中添加一个元素
		* posistion 会 + 1 操作

	put(byte[] data);
		* 向缓冲区中写入数据
		* 有N多重载.例如可以指定:写入到哪个位置?或者是直接把一个字节数组写入
	
	put(int po,byte b);
		* 在指定位置写入数据, position 位置不会发生变化
		* 会覆盖原来的值
	
	rewind();
		* 将position设回0，所以你可以重读Buffer中的所有数据。
		* limit保持不变，仍然表示能从Buffer中读取多少个元素（byte、char等）。
	
	mark();
		* 通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。
		* 之后可以通过调用Buffer.reset()方法恢复到这个position。

	reset();
		* 通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。
		* 之后可以通过调用Buffer.reset()方法恢复到这个position。
		* demo
			buffer.mark();
			buffer.reset();

	equals();
		* 当满足下列条件时，表示两个Buffer相等：
		* 有相同的类型（byte、char、int等）。
		* Buffer中剩余的byte、char等的个数相等。
		* Buffer中所有剩余的byte、char等都相同。
		* 如你所见，equals只是比较Buffer的一部分，不是每一个在它里面的元素都比较。实际上，它只比较Buffer中的剩余元素。
	
	compareTo();
		* compareTo()方法比较两个Buffer的剩余元素(byte、char等)， 如果满足下列条件，则认为一个Buffer“小于”另一个Buffer：
		1,第一个不相等的元素小于另一个Buffer中对应的元素 。
		2,所有元素都相等，但第一个Buffer比另一个先耗尽(第一个Buffer的元素个数比另一个少)

	hasRemaining();
		* 判断Buffer中是否还有操作完毕的数据
		* 源码: return position < limit;
		