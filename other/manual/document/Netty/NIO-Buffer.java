-------------------------------
Netty-Buffer					|
-------------------------------
	# Buffer ��һ������,������һЩҪд����߶�ȡ������,��NIO����м��� Buffer ����,�������¿���ԭIO��һ����Ҫ����
	# ����������IO�п��԰�����ֱ��д�뵽 Stream ����,'��NIO����,���е����ݶ����û����������д��'
	# ������ʵ������һ������,ͨ������һ���ֽ�����,(ByteBuffer),Ҳ����ʹ���������͵�����,�������Ϊ�������ṩ�����ݵķ��ʶ�д�Ȳ���.���:λ��,����,���޵ȸ���(��API)
	# Buffer ����,������õľ��� ByteBuffer ,ʵ����ÿ��JAVA�������Ͷ���һ�ֻ�����(���� Boolean ����)
	# һЩ�е���
		ByteBuffer
		CharBuffer
		ShortBuffer
		IntBuffer
		LongBuffer
		FloatBuffer
		DoubleBuffer

		MappedByteBuffer	//���Ƚ��ر� ���ڱ�ʾ�ڴ�ӳ���ļ�5


-------------------------------
Netty-Buffer ����				|
-------------------------------
	# capacity,position,limit
	# ��������������һ�����д�����ݣ�Ȼ����Դ��ж�ȡ���ݵ��ڴ档����ڴ汻��װ��NIO Buffer���󣬲��ṩ��һ�鷽������������ķ��ʸÿ��ڴ档
	# Ϊ�����Buffer�Ĺ���ԭ����Ҫ��Ϥ�����������ԣ�
		capacity
		position
		limit

	# capacity
		* ��Ϊһ���ڴ�飬Buffer��һ���̶��Ĵ�Сֵ��Ҳ��"capacity".��ֻ������дcapacity��byte��long��char�����͡�
		* һ��Buffer���ˣ���Ҫ������գ�'ͨ�������ݻ����������'�����ܼ���д��������д���ݡ�
		
	# position
		* ����д���ݵ�Buffer��ʱ��position��ʾ��ǰ��λ�á���ʼ��positionֵΪ0.��һ��byte��long������д��Buffer�� position����ǰ�ƶ�����һ���ɲ������ݵ�Buffer��Ԫ��
		* position����Ϊcapacity �C 1.

	# limit
		* ��дģʽ�£�Buffer��limit��ʾ���������Buffer��д�������ݡ� дģʽ�£�limit����Buffer��capacity��			
		* ���л�Buffer����ģʽʱ��limit�ᱻ���ó�дģʽ�µ�positionֵ��Ҳ����˵,Ҳ����˵���Զ�ȡ����������


-------------------------------
Netty-Buffer ����				|
-------------------------------
	# Ҫ����һ��Buffer��������Ҫ���з��䡣 ÿһ��Buffer�඼��һ��allocate������
	# Demo
		ByteBuffer buf = ByteBuffer.allocate(48);		//����48�ֽ�capacity��ByteBuffer��
		CharBuffer buf = CharBuffer.allocate(1024);		//����1024�ֽ�capacity��CharBuffer��

-------------------------------
Netty-Buffer д������			|
-------------------------------
	# д���ݵ�Buffer�����ַ�ʽ
	# 1,��Channelд��Buffer��
		int bytesRead = inChannel.read(buf); //read into buffer.

	# 2,ͨ��Buffer��put()����д��Buffer�
		buf.put(127);
		* put�����кܶ�汾���������Բ�ͬ�ķ�ʽ������д�뵽Buffer�С�
		* ����,д��һ��ָ����λ��,���߰�һ���ֽ�����д�뵽Buffer�� 
		* ����Bufferʵ�ֵ�ϸ�ڲο�JavaDoc��

-------------------------------
Netty-Buffer ��ȡ����			|
-------------------------------
	# ��Buffer�ж�ȡ���������ַ�ʽ��
	# 1,��Buffer��ȡ���ݵ�Channel��
		int bytesWritten = inChannel.write(buf);

	# 2,ʹ��get()������Buffer�ж�ȡ���ݡ�
		byte aByte = buf.get();
		* get�����кܶ�汾���������Բ�ͬ�ķ�ʽ��Buffer�ж�ȡ���ݡ�
		* ����,��ָ��position��ȡ�����ߴ�Buffer�ж�ȡ���ݵ��ֽ����顣
		* ����Bufferʵ�ֵ�ϸ�ڲο�JavaDoc��

-------------------------------
Netty-Buffer ����				|
-------------------------------
	��̬����:
		allocate(int size);
			* ����ָ����С�Ļ�����

		wrap(byte[] arr);
			* �µĻ��������ɸ����� arr ����֧��
			* �������޸Ľ����������޸ģ���֮��Ȼ
			* �»������������ͽ��޽�Ϊ arr.length������arr����û������,buffer����(position)ʼ��Ϊ��
		
		wrap(arr,num1,num2);
			* ͬ��
			* �»������� position = num1,limit = (num1 + num2),capacity = arr.length
			* ��˵:��arr���뻺����,��arr�� num1 �Ǳ꿪ʼȡֵ,ȡnum2 ������

	ʵ������:

	get();
		* ��ȡ���������е�����,���ص���һ��λ(ByteBuffer ���صľ��� byte)
		* ÿ��ִ�� get(),������ position ��ǰ�ƶ�һλ
		* ��N�����ط���
	
	get(index);
		* ��ȡָ���±��ֵ
		* position ���ᷢ���仯
	
	remaining();
		* ���ص�ǰλ��������֮���Ԫ������ 
	
	void flip();
		* ��λ,Ҳ���Ǵ�д��״̬ת��Ϊ����״̬.
		* ��Buffer��дģʽ�л�����ģʽ������flip()�����Ὣposition���0������limit���ó�֮ǰposition��ֵ��
	
	void clear();
		* clear ��û����������,����������postion��limit��ֵ���ù�ȥ�����ݱ�����
		* position�������0��limit�����ó� capacity��ֵ��
		* ���仰˵��Buffer ������ˡ�Buffer�е����ݲ�δ�����ֻ����Щ��Ǹ������ǿ��Դ����￪ʼ��Buffer��д���ݡ�

	void compact();
		* ��ջ�����,ֻ������Ѿ����������ݡ�
		* �κ�δ�������ݶ����Ƶ�����������ʼ��,��д������ݽ��ŵ�������δ�����ݵĺ��档
		* ������δ�������ݿ�����Buffer��ʼ����Ȼ��position�赽���һ��δ��Ԫ�������档
		* limit������Ȼ �� clear()����һ�������ó�capacity��
		* ����Buffer׼����д�����ˣ����ǲ��Ḳ��δ�������ݡ�
	
	put(byte bt);
		* �򻺳��������һ��Ԫ��
		* posistion �� + 1 ����

	put(byte[] data);
		* �򻺳�����д������
		* ��N������.�������ָ��:д�뵽�ĸ�λ��?������ֱ�Ӱ�һ���ֽ�����д��
	
	put(int po,byte b);
		* ��ָ��λ��д������, position λ�ò��ᷢ���仯
		* �Ḳ��ԭ����ֵ
	
	rewind();
		* ��position���0������������ض�Buffer�е��������ݡ�
		* limit���ֲ��䣬��Ȼ��ʾ�ܴ�Buffer�ж�ȡ���ٸ�Ԫ�أ�byte��char�ȣ���
	
	mark();
		* ͨ������Buffer.mark()���������Ա��Buffer�е�һ���ض�position��
		* ֮�����ͨ������Buffer.reset()�����ָ������position��

	reset();
		* ͨ������Buffer.mark()���������Ա��Buffer�е�һ���ض�position��
		* ֮�����ͨ������Buffer.reset()�����ָ������position��
		* demo
			buffer.mark();
			buffer.reset();

	equals();
		* ��������������ʱ����ʾ����Buffer��ȣ�
		* ����ͬ�����ͣ�byte��char��int�ȣ���
		* Buffer��ʣ���byte��char�ȵĸ�����ȡ�
		* Buffer������ʣ���byte��char�ȶ���ͬ��
		* ����������equalsֻ�ǱȽ�Buffer��һ���֣�����ÿһ�����������Ԫ�ض��Ƚϡ�ʵ���ϣ���ֻ�Ƚ�Buffer�е�ʣ��Ԫ�ء�
	
	compareTo();
		* compareTo()�����Ƚ�����Buffer��ʣ��Ԫ��(byte��char��)�� ���������������������Ϊһ��Buffer��С�ڡ���һ��Buffer��
		1,��һ������ȵ�Ԫ��С����һ��Buffer�ж�Ӧ��Ԫ�� ��
		2,����Ԫ�ض���ȣ�����һ��Buffer����һ���Ⱥľ�(��һ��Buffer��Ԫ�ظ�������һ����)

	hasRemaining();
		* �ж�Buffer���Ƿ��в�����ϵ�����
		* Դ��: return position < limit;
		