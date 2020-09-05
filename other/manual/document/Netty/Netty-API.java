NioEventLoopGroup
	# 是用来处理I/O操作的多线程事件循环器
	# Netty 提供了许多不同的 EventLoopGroup的实现用来处理不同的传输。

AbstractBootstrap
	# io.netty.bootstrap.AbstractBootstrap

ChannelHandlerAdapter 
	# io.netty.channel.ChannelHandlerAdapter

ChannelHandler
	# io.netty.channel.ChannelHandler
	# handler 中最顶层的接口



SimpleChannelInboundHandler
	# io.netty.channel.SimpleChannelInboundHandler
	# Client端Handler继承
	# 接收到数据后会自动release掉数据占用的Bytebuffer资源(自动调用Bytebuffer.release())。

ChannelInboundHandlerAdapter
	# io.netty.channel.ChannelInboundHandlerAdapter
	# Server端Handler继承
	# 这个类实现了 ChannelInboundHandler 接口
	# 现在仅仅只需要继承 ChannelInboundHandlerAdapter 类而不是你自己去实现接口方法


ChannelInboundHandler
	# io.netty.channel.ChannelInboundHandler
	#  ChannelInboundHandler 接口提供了许多事件处理的接口方法，然后你可以覆盖这些方法。


ByteToMessageDecoder
	# ChannelInboundHandler 的一个实现类，他可以在处理数据拆分的问题上变得很简单

ReferenceCountUtil
	# io.netty.util.ReferenceCountUtil
	# 静态方法
		public static boolean release(Object msg);
		public static boolean release(Object msg, int decrement);

ServerBootstrap
	# 方法
	option(ChannelOption.SO_BACKLOG,128);
		* 系统内核,TCP维护的俩队列的长度的和

		