- [数据结构](#数据结构)
- [数据库](#数据库)
- [Java基础](#java)
- [Redis](#redis)
- [算法相关](#算法)
- [JVM相关](#jvm)
- [Spring Cloud](#sc)
- [消息队列](#mq)
- [分布式架构](#fbs)
- [计算机网络](#network)
- [Mybatis](#mybatis)

<span id="数据结构">数据结构</span>
----------------------------------
HashMap
-------
      众所周知，HashMap是一个用于存储Key-Value键值对的集合，每一个键值对也叫做Entry。这些个键值对（Entry）分散存储在一个数组当中，这个数组就是HashMap的主干。HashMap数组每一个元素的初始值都是Null，对于HashMap我们常用的操作为get and put.
      1.put的过程。
      在写入一个元素的时候需要先利用哈希函数来确定该元素的写入位置，即该元素的index，但是如果有大量的数据写入，那必然不可避免的产生相同的index，此时HashMap的处理方案是使用链表来解决，即可以简单的认为hashmap是由链表组成的数据，但是在java8中进行了改变，在一定情况下会将链表转换为红黑树，这一点后续再说。回到刚才，如果哈希函数计算出了相同的index，则将元素放入该位置的链表头，因为设计者认为后写入的元素被调用的概率更大。
      2.get的过程。
      在执行get的过程中，会首先将输入端key进行一次映射运算，得到其对应的index来找到该链表，然后从链表头开始，依次对比来找到key所对应的元素，这就是get的执行过程。
      另外，HashMap的默认的长度为16，并且每次进行扩增或者初始化时，长度必须是2的幂次方，选择默认长度为16是为了服务于从key映射到index的哈希算法（index=Hash("key")）,为了实现一个均匀分布的Hash函数，设计者们采用了位运算的方式，index=HashCode(Key)&(Length-1)，length为hashmap的长度，举例如下：
      1.计算book的hashcode，结果为十进制的3029737，二进制的101110001110101110 1001。
      2.假定HashMap长度是默认的16，计算Length-1的结果为十进制的15，二进制的1111。
      3.把以上两个结果做与运算，101110001110101110 1001 & 1111 = 1001，十进制是9，所以 index=9。
      可以说，Hash算法最终得到的index结果，完全取决于Key的Hashcode值的最后几位。
      这也是为何hashMap的初始长度默认16的原因，
<span id="数据库">数据库</span>
------------------------------
<span id="java">Java基础</span>
-------------------------------
<span id="redis">Redis</span>
------------------------------
<span id="算法">算法相关</span>
-------
<span id="jvm">JVM相关</span>
-------
<span id="sc">Spring Cloud</span>
------------
<span id="mq">消息队列</span>
-------
<span id="fbs">分布式架构</span>
---------
<span id="network">计算机网络</span>
-----------------------------------
<span id="mybatis">Mybatis</span>
-------
