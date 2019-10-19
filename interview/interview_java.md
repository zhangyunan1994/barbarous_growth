# 面试题


**Table of Contents**
<!-- TOC -->

- [面试题](#面试题)
- [基础篇](#基础篇)
    - [基本功](#基本功)
        - [面向对象的特征](#面向对象的特征)
        - [final, finally, finalize 的区别](#final-finally-finalize-的区别)
        - [int 和 Integer 有什么区别](#int-和-integer-有什么区别)
        - [重载和重写的区别](#重载和重写的区别)
        - [抽象类和接口有什么区别](#抽象类和接口有什么区别)
        - [说说反射的用途及实现](#说说反射的用途及实现)
        - [说说自定义注解的场景及实现](#说说自定义注解的场景及实现)
        - [HTTP 请求的 GET 与 POST 方式的区别](#http-请求的-get-与-post-方式的区别)
        - [session 与 cookie 区别](#session-与-cookie-区别)
        - [session 分布式处理](#session-分布式处理)
        - [JDBC 流程](#jdbc-流程)
        - [MVC 设计思想](#mvc-设计思想)
        - [equals 与 == 的区别](#equals-与--的区别)
    - [集合](#集合)
        - [List 和 Set 区别](#list-和-set-区别)
        - [List 和 Map 区别](#list-和-map-区别)
        - [Arraylist 与 LinkedList 区别](#arraylist-与-linkedlist-区别)
        - [ArrayList 与 Vector 区别](#arraylist-与-vector-区别)
        - [HashMap 和 Hashtable 的区别](#hashmap-和-hashtable-的区别)
        - [HashSet 和 HashMap 区别](#hashset-和-hashmap-区别)
        - [HashMap 和 ConcurrentHashMap 的区别](#hashmap-和-concurrenthashmap-的区别)
        - [HashMap 的工作原理及代码实现](#hashmap-的工作原理及代码实现)
        - [ConcurrentHashMap 的工作原理及代码实现](#concurrenthashmap-的工作原理及代码实现)
    - [线程](#线程)
        - [创建线程的方式及实现](#创建线程的方式及实现)
        - [sleep() 、join（）、yield（）有什么区别](#sleep-joinyield有什么区别)
        - [说说 CountDownLatch 原理](#说说-countdownlatch-原理)
        - [说说 CyclicBarrier 原理](#说说-cyclicbarrier-原理)
        - [说说 Semaphore 原理](#说说-semaphore-原理)
        - [说说 Exchanger 原理](#说说-exchanger-原理)
        - [说说 CountDownLatch 与 CyclicBarrier 区别](#说说-countdownlatch-与-cyclicbarrier-区别)
        - [ThreadLocal 原理分析](#threadlocal-原理分析)
        - [讲讲线程池的实现原理](#讲讲线程池的实现原理)
        - [线程池的几种方式](#线程池的几种方式)
        - [线程的生命周期](#线程的生命周期)
    - [锁机制](#锁机制)
        - [说说线程安全问题](#说说线程安全问题)
        - [volatile 实现原理](#volatile-实现原理)
        - [synchronize 实现原理](#synchronize-实现原理)
        - [synchronized 与 lock 的区别](#synchronized-与-lock-的区别)
        - [CAS 乐观锁](#cas-乐观锁)
        - [ABA 问题](#aba-问题)
        - [乐观锁的业务场景及实现方式](#乐观锁的业务场景及实现方式)
- [核心篇](#核心篇)
    - [数据存储](#数据存储)
        - [MySQL 索引使用的注意事项](#mysql-索引使用的注意事项)
        - [说说反模式设计](#说说反模式设计)
        - [说说分库与分表设计](#说说分库与分表设计)
        - [分库与分表带来的分布式困境与应对之策](#分库与分表带来的分布式困境与应对之策)
        - [说说 SQL 优化之道](#说说-sql-优化之道)
        - [MySQL 遇到的死锁问题](#mysql-遇到的死锁问题)
        - [存储引擎的 InnoDB 与 MyISAM](#存储引擎的-innodb-与-myisam)
        - [数据库索引的原理](#数据库索引的原理)
        - [为什么要用 B-tree](#为什么要用-b-tree)
        - [聚集索引与非聚集索引的区别](#聚集索引与非聚集索引的区别)
        - [limit 20000 加载很慢怎么解决](#limit-20000-加载很慢怎么解决)
        - [选择合适的分布式主键方案](#选择合适的分布式主键方案)
        - [选择合适的数据存储方案](#选择合适的数据存储方案)
        - [ObjectId 规则](#objectid-规则)
        - [聊聊 MongoDB 使用场景](#聊聊-mongodb-使用场景)
        - [倒排索引](#倒排索引)
        - [聊聊 ElasticSearch 使用场景](#聊聊-elasticsearch-使用场景)
    - [缓存使用](#缓存使用)
        - [Redis 有哪些类型](#redis-有哪些类型)
    - [消息队列](#消息队列)
- [框架篇](#框架篇)
    - [Spring](#spring)
    - [Netty](#netty)
- [微服务篇](#微服务篇)
    - [微服务](#微服务)
    - [分布式](#分布式)
    - [安全问题](#安全问题)
    - [性能优化](#性能优化)
- [工程篇](#工程篇)
    - [需求分析](#需求分析)
    - [设计能力](#设计能力)
    - [设计模式](#设计模式)
    - [业务工程](#业务工程)
    - [软实力](#软实力)

<!-- /TOC -->
# 基础篇
## 基本功
### 面向对象的特征

封装,继承,多态.有时候也会加上抽象.

### final, finally, finalize 的区别

1. final：用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，被其修饰的类不可继承。
2. finally：异常处理语句结构的一部分，表示总是执行。
3. finalize：Object 类的一个方法，在垃圾回收器执行的时候会调用被回收对象的此方法，可以覆盖此方法 提供垃圾收集时的其他资源回收，例如关闭文件等。该方法更像是一个对象生命周期的临终方法，当该方法 被系统调用则代表该对象即将"死亡"，但是需要注意的是，我们主动行为上去调用该方法并不会导致该对 象"死亡"，这是一个被动的方法（其实就是回调方法），不需要我们调用。

### int 和 Integer 有什么区别

Java 为每一个基本数据类型都引入了对应的包装类型（wrapper class），int 的包装类就是 Integer，int 是基本类型，Integer是包装类型，int 默认值为0，Integer 默认值是 null,Integer 提供了一个简便的方法

### 重载和重写的区别

方法的重载和重写都是实现多态的方式，区别在于前者实现的是编译时的多态性，而后者实现的是运行时的多态性。

重载发生在一个类中，同名的方法如果有不同的参数列表（参数类型不同、参数个数不同或者二者都不同）则视为 重载；重写发生在子类与父类之间，

重写要求子类被重写方法与父类被重写方法有相同的返回类型和参数列表，比父类被重写方法更好访问，不能比父类被重写方法声明更多的异常（里氏代换原则）。重载对返回类型没有特殊的要求。

方法重载的规则：
1. 方法名一致，参数列表中参数的顺序，类型，个数不同。
2. 重载与方法的返回值无关，存在于父类和子类，同类中。
3. 可以抛出不同的异常，可以有不同修饰符。

方法重写的规则：

1. 参数列表必须完全与被重写方法的一致，返回类型必须完全与被重写方法的返回类型一致。
2. 构造方法不能被重写，声明为 final 的方法不能被重写，声明为 static 的方法不能被重写，但是能够被再次 声明。
3. 访问权限不能比父类中被重写的方法的访问权限更低。
4. 重写的方法能够抛出任何非强制异常（UncheckedException，也叫非运行时异常），无论被重写的方法是 否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则 可以。

### 抽象类和接口有什么区别

**抽象类**

抽象类是用来捕捉子类的通用特性的 。它不能被实例化，只能被用作子类的超类。抽象类是被用来创建继承层级里子类的模板

**接口**

接口是抽象方法的集合。如果一个类实现了某个接口，那么它就继承了这个接口的抽象方法。

### 说说反射的用途及实现

### 说说自定义注解的场景及实现

### HTTP 请求的 GET 与 POST 方式的区别

### session 与 cookie 区别

Session是在服务端保存的一个数据结构，用来跟踪用户的状态，这个数据可以保存在集群、数据库、文件中；
Cookie是客户端保存用户信息的一种机制，用来记录用户的一些信息，也是实现Session的一种方式。

1. 存储位置不同， session 存储在服务端，cookie存储在客户端

### session 分布式处理

### JDBC 流程

1. 注册驱动
1. 获取连接
1. 创建语句
1. 执行语句并处理结果集
1. 关闭语句和数据库连接

### MVC 设计思想

### equals 与 == 的区别

equals 和 == 最大的区别是一个是方法一个是运算符。

==：如果比较的对象是基本数据类型，则比较的是数值是否相等；如果比较的是引用数据类型，则比较的是对象的地址值是否相等。

equals()：用来比较方法两个对象的内容是否相等。

注意：equals 方法不能用于基本数据类型的变量，如果没有对 equals 方法进行重写，则比较的是引用类型的变 量所指向的对象的地址。

## 集合
### List 和 Set 区别

List 用来存储有序序列，Set用来存储无序集合，List中存放的数据是可重复的，Set存放的数据是唯一的

### List 和 Map 区别
### Arraylist 与 LinkedList 区别

最明显的区别是 ArrrayList底层的数据结构是数组，支持随机访问，而 LinkedList 的底层数据结构是双向循环链表，不支持随机访问。使用下标访问一个元素，ArrayList 的时间复杂度是 O(1)，而 LinkedList 是 O(n)。

区别：
1. 查询上面已经提到
1. 删除元素，当删除元素时，ArrayList 会将删除位置后所有数据向前移动，效率低，LinkedList只需要移动节点指向即可
1. 增加元素，当增加元素到List的容量时，ArrayList 需要重新创建一个更大的数组，并将旧数组数据复制到新数组，LinkedList 可直接在尾部追加，无需复制数据
1. 修改数据，想要改数据得先知道数据在哪吧，所以这里 ArrayList 更有优势


### ArrayList 与 Vector 区别
### HashMap 和 Hashtable 的区别
### HashSet 和 HashMap 区别
### HashMap 和 ConcurrentHashMap 的区别
### HashMap 的工作原理及代码实现
### ConcurrentHashMap 的工作原理及代码实现
## 线程
### 创建线程的方式及实现
### sleep() 、join（）、yield（）有什么区别
### 说说 CountDownLatch 原理
### 说说 CyclicBarrier 原理
### 说说 Semaphore 原理
### 说说 Exchanger 原理
### 说说 CountDownLatch 与 CyclicBarrier 区别
### ThreadLocal 原理分析
### 讲讲线程池的实现原理
### 线程池的几种方式
### 线程的生命周期
## 锁机制
### 说说线程安全问题
### volatile 实现原理
### synchronize 实现原理
### synchronized 与 lock 的区别
### CAS 乐观锁
CAS，全称为Compare and Swap，即比较-替换。假设有三个操作数：内存值V、旧的预期值A、要修改的值B，当且仅当预期值A和内存值V相同时，才会将内存值修改为B并返回true，否则什么都不做并返回false。当然CAS一定要volatile变量配合，这样才能保证每次拿到的变量是主内存中最新的那个值，否则旧的预期值A对某条线程来说，永远是一个不会变的值A，只要某次CAS操作失败，永远都不可能成
功

乐观锁：乐观锁认为竞争不总是会发生，因此它不需要持有锁，将比较-替换这两个动作作为一个原子操作尝试去修改内存中的变量，如果失败则表示发生冲突，那么就应该有相应的重试逻辑。

### ABA 问题
### 乐观锁的业务场景及实现方式
# 核心篇
## 数据存储
### MySQL 索引使用的注意事项
### 说说反模式设计
### 说说分库与分表设计
### 分库与分表带来的分布式困境与应对之策
### 说说 SQL 优化之道
### MySQL 遇到的死锁问题
### 存储引擎的 InnoDB 与 MyISAM
### 数据库索引的原理
### 为什么要用 B-tree
### 聚集索引与非聚集索引的区别
### limit 20000 加载很慢怎么解决
### 选择合适的分布式主键方案
### 选择合适的数据存储方案
### ObjectId 规则
### 聊聊 MongoDB 使用场景
### 倒排索引
### 聊聊 ElasticSearch 使用场景
## 缓存使用
### Redis 有哪些类型
* string
* list
* set
* zset
* hash

### Redis 内部结构
### 聊聊 Redis 使用场景
### Redis 持久化机制

aof 和 快照

### Redis 如何实现持久化
### Redis 集群方案与实现
### Redis 为什么是单线程的

因为CPU不是Redis的瓶颈。Redis的瓶颈最有可能是机器内存或者网络带宽。（以上主要来自官方FAQ）既然单线程容易实现，而且CPU不会成为瓶颈，那就顺理成章地采用单线程的方案了。关于redis的性能，官方网站也有，普通笔记本轻松处理每秒几十万的请求

### 缓存崩溃
### 缓存降级
### 使用缓存的合理性问题
## 消息队列
### 消息队列的使用场景
### 消息的重发补偿解决思路
### 消息的幂等性解决思路
### 消息的堆积解决思路
### 自己如何实现消息队列
### 如何保证消息的有序性
# 框架篇
## Spring
### BeanFactory 和 ApplicationContext 有什么区别
### Spring Bean 的生命周期
### Spring IOC 如何实现
### 说说 Spring AOP
### Spring AOP 实现原理
### 动态代理（cglib 与 JDK）
### Spring 事务实现方式
### Spring 事务底层原理
### 如何自定义注解实现功能
### Spring MVC 运行流程
### Spring MVC 启动流程
### Spring 的单例实现原理
### Spring 框架中用到了哪些设计模式
### Spring 其他产品（Srping Boot、Spring Cloud、Spring Secuirity、Spring Data、Spring AMQP 等）
## Netty
### 为什么选择 Netty
### 说说业务中，Netty 的使用场景
### 原生的 NIO 在 JDK 1.7 版本存在 epoll bug
### 什么是TCP 粘包/拆包
### TCP粘包/拆包的解决办法
### Netty 线程模型
### 说说 Netty 的零拷贝
### Netty 内部执行流程
### Netty 重连实现
# 微服务篇
## 微服务
### 前后端分离是如何做的
### 微服务哪些框架
### 你怎么理解 RPC 框架
### 说说 RPC 的实现原理
### 说说 Dubbo 的实现原理
### 你怎么理解 RESTful
### 说说如何设计一个良好的 API
### 如何理解 RESTful API 的幂等性
### 如何保证接口的幂等性
### 说说 CAP 定理、 BASE 理论
### 怎么考虑数据一致性问题
### 说说最终一致性的实现方案
### 你怎么看待微服务
### 微服务与 SOA 的区别
### 如何拆分服务
### 微服务如何进行数据库管理
### 如何应对微服务的链式调用异常
### 对于快速追踪与定位问题
### 微服务的安全
## 分布式
### 谈谈业务中使用分布式的场景
### Session 分布式方案
### 分布式锁的场景
### 分布是锁的实现方案
### 分布式事务
### 集群与负载均衡的算法与实现
### 说说分库与分表设计
### 分库与分表带来的分布式困境与应对之策
## 安全问题
### 安全要素与 STRIDE 威胁
### 防范常见的 Web 攻击
### 服务端通信安全攻防
### HTTPS 原理剖析
### HTTPS 降级攻击
### 授权与认证
### 基于角色的访问控制
### 基于数据的访问控制
## 性能优化
### 性能指标有哪些
### 如何发现性能瓶颈
### 性能调优的常见手段
### 说说你在项目中如何进行性能调优
# 工程篇
## 需求分析
### 你如何对需求原型进行理解和拆分
### 说说你对功能性需求的理解
### 说说你对非功能性需求的理解
### 你针对产品提出哪些交互和改进意见
### 你如何理解用户痛点
## 设计能力
### 说说你在项目中使用过的 UML 图
### 你如何考虑组件化
### 你如何考虑服务化
### 你如何进行领域建模
### 你如何划分领域边界
### 说说你项目中的领域建模
### 说说概要设计
## 设计模式
### 你项目中有使用哪些设计模式
### 说说常用开源框架中设计模式使用分析
### 说说你对设计原则的理解
### 23种设计模式的设计理念
### 设计模式之间的异同，例如策略模式与状态模式的区别
### 设计模式之间的结合，例如策略模式+简单工厂模式的实践
### 设计模式的性能，例如单例模式哪种性能更好。
## 业务工程
### 你系统中的前后端分离是如何做的
### 说说你的开发流程
### 你和团队是如何沟通的
### 你如何进行代码评审
### 说说你对技术与业务的理解
### 说说你在项目中经常遇到的 Exception
### 说说你在项目中遇到感觉最难Bug，怎么解决的
### 说说你在项目中遇到印象最深困难，怎么解决的
### 你觉得你们项目还有哪些不足的地方
### 你是否遇到过 CPU 100% ，如何排查与解决
### 你是否遇到过 内存 OOM ，如何排查与解决
### 说说你对敏捷开发的实践
### 说说你对开发运维的实践
### 介绍下工作中的一个对自己最有价值的项目，以及在这个过程中的角色
## 软实力
### 说说你的亮点
### 说说你最近在看什么书
### 说说你觉得最有意义的技术书籍
### 工作之余做什么事情
### 说说个人发展方向方面的思考
### 说说你认为的服务端开发工程师应该具备哪些能力
### 说说你认为的架构师是什么样的，架构师主要做什么
### 说说你所理解的技术专家







强引用,软引用,弱引用,虚引用.不同的引用类型主要体现在GC上:

强引用：如果一个对象具有强引用，它就不会被垃圾回收器回收。即使当前内存空间不足，JVM也不会回收它，而是抛出 OutOfMemoryError 错误，使程序异常终止。如果想中断强引用和某个对象之间的关联，可以显式地将引用赋值为null，这样一来的话，JVM在合适的时间就会回收该对象
软引用：在使用软引用时，如果内存的空间足够，软引用就能继续被使用，而不会被垃圾回收器回收，只有在内存不足时，软引用才会被垃圾回收器回收。
弱引用：具有弱引用的对象拥有的生命周期更短暂。因为当 JVM 进行垃圾回收，一旦发现弱引用对象，无论当前内存空间是否充足，都会将弱引用回收。不过由于垃圾回收器是一个优先级较低的线程，所以并不一定能迅速发现弱引用对象
虚引用：顾名思义，就是形同虚设，如果一个对象仅持有虚引用，那么它相当于没有引用，在任何时候都可能被垃圾回收器回收。
更多了解参见深入对象引用

WeakReference与SoftReference的区别?
这点在四种引用类型中已经做了解释,这里简单说明一下即可: 
虽然 WeakReference 与 SoftReference 都有利于提高 GC 和 内存的效率，但是 WeakReference ，一旦失去最后一个强引用，就会被 GC 回收，而软引用虽然不能阻止被回收，但是可以延迟到 JVM 内存不足的时候。

为什么要有不同的引用类型
不像C语言,我们可以控制内存的申请和释放,在Java中有时候我们需要适当的控制对象被回收的时机,因此就诞生了不同的引用类型,可以说不同的引用类型实则是对GC回收时机不可控的妥协.有以下几个使用场景可以充分的说明:

利用软引用和弱引用解决OOM问题：用一个HashMap来保存图片的路径和相应图片对象关联的软引用之间的映射关系，在内存不足时，JVM会自动回收这些缓存图片对象所占用的空间，从而有效地避免了OOM的问题.
通过软引用实现Java对象的高速缓存:比如我们创建了一Person的类，如果每次需要查询一个人的信息,哪怕是几秒中之前刚刚查询过的，都要重新构建一个实例，这将引起大量Person对象的消耗,并且由于这些对象的生命周期相对较短,会引起多次GC影响性能。此时,通过软引用和 HashMap 的结合可以构建高速缓存,提供性能.

内部类的作用
内部类可以有多个实例,每个实例都有自己的状态信息,并且与其他外围对象的信息相互独立.在单个外围类当中,可以让多个内部类以不同的方式实现同一接口,或者继承同一个类.创建内部类对象的时刻不依赖于外部类对象的创建.内部类并没有令人疑惑的”is-a”关系,它就像是一个独立的实体.

内部类提供了更好的封装,除了该外围类,其他类都不能访问



clone()是哪个类的方法?
java.lang.Cloneable 是一个标示性接口，不包含任何方法，clone 方法在 object 类中定义。并且需要知道 clone() 方法是一个本地方法，这意味着它是由 c 或 c++ 或 其他本地语言实现的。

深拷贝和浅拷贝的区别是什么?
浅拷贝：被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。换言之，浅拷贝仅仅复制所考虑的对象，而不复制它所引用的对象。

深拷贝：被复制对象的所有变量都含有与原来的对象相同的值，而那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。换言之，深拷贝把要复制的对象所引用的对象都复制了一遍。

static都有哪些用法?
几乎所有的人都知道static关键字这两个基本的用法:静态变量和静态方法.也就是被static所修饰的变量/方法都属于类的静态资源,类实例所共享.

除了静态变量和静态方法之外,static也用于静态块,多用于初始化操作:

public calss PreCache{
    static{
        //执行相关操作
    }
}

此外static也多用于修饰内部类,此时称之为静态内部类.

最后一种用法就是静态导包,即import static.import static是在JDK 1.5之后引入的新特性,可以用来指定导入某个类中的静态资源,并且不需要使用类名.资源名,可以直接使用资源名,比如:

import static java.lang.Math.*;

public class Test{

    public static void main(String[] args){
        //System.out.println(Math.sin(20));传统做法
        System.out.println(sin(20));
    }
}

final有哪些用法
final也是很多面试喜欢问的地方,能回答下以下三点就不错了: 
1.被final修饰的类不可以被继承 
2.被final修饰的方法不可以被重写 
3.被final修饰的变量不可以被改变.如果修饰引用,那么表示引用不可变,引用指向的内容可变. 
4.被final修饰的方法,JVM会尝试将其内联,以提高运行效率 
5.被final修饰的常量,在编译阶段会存入常量池中.

回答出编译器对final域要遵守的两个重排序规则更好: 
1.在构造函数内对一个final域的写入,与随后把这个被构造对象的引用赋值给一个引用变量,这两个操作之间不能重排序. 
2.初次读一个包含final域的对象的引用,与随后初次读这个final域,这两个操作之间不能重排序.

数据类型相关
java中int char,long各占多少字节?
类型	位数	字节数
short	2	16
int	4	32
long	8	64
float	4	32
double	8	64
char	2	16
64位的JVM当中,int的长度是多少?
Java 中，int 类型变量的长度是一个固定值，与平台无关，都是 32 位。意思就是说，在 32 位 和 64 位 的Java 虚拟机中，int 类型的长度是相同的。


什么是编译器常量?使用它有什么风险?
公共静态不可变（public static final ）变量也就是我们所说的编译期常量，这里的 public 可选的。实际上这些变量在编译时会被替换掉，因为编译器知道这些变量的值，并且知道这些变量在运行时不能改变。这种方式存在的一个问题是你使用了一个内部的或第三方库中的公有编译时常量，但是这个值后面被其他人改变了，但是你的客户端仍然在使用老的值，甚至你已经部署了一个新的jar。为了避免这种情况，当你在更新依赖 JAR 文件时，确保重新编译你的程序。



如何将byte转为String
可以使用 String 接收 byte[] 参数的构造器来进行转换，需要注意的点是要使用的正确的编码，否则会使用平台默认编码，这个编码可能跟原来的编码相同，也可能不同。

可以将int强转为byte类型么?会产生什么问题?
我们可以做强制转换，但是Java中int是32位的而byte是8 位的，所以,如果强制转化int类型的高24位将会被丢弃，byte 类型的范围是从-128到128

关于垃圾回收
你知道哪些垃圾回收算法?
垃圾回收从理论上非常容易理解,具体的方法有以下几种: 
1. 标记-清除 
2. 标记-复制 
3. 标记-整理 
4. 分代回收 
更详细的内容参见深入理解垃圾回收算法

如何判断一个对象是否应该被回收
这就是所谓的对象存活性判断,常用的方法有两种:1.引用计数法;2:对象可达性分析.由于引用计数法存在互相引用导致无法进行GC的问题,所以目前JVM虚拟机多使用对象可达性分析算法.

简单的解释一下垃圾回收
Java 垃圾回收机制最基本的做法是分代回收。内存中的区域被划分成不同的世代，对象根据其存活的时间被保存在对应世代的区域中。一般的实现是划分成3个世代：年轻、年老和永久。内存的分配是发生在年轻世代中的。当一个对象存活时间足够长的时候，它就会被复制到年老世代中。对于不同的世代可以使用不同的垃圾回收算法。进行世代划分的出发点是对应用中对象存活时间进行研究之后得出的统计规律。一般来说，一个应用中的大部分对象的存活时间都很短。比如局部变量的存活时间就只在方法的执行过程中。基于这一点，对于年轻世代的垃圾回收算法就可以很有针对性.

调用System.gc()会发生什么?
通知GC开始工作,但是GC真正开始的时间不确定.

进程,线程相关
说说进程,线程,协程之间的区别
简而言之,进程是程序运行和资源分配的基本单位,一个程序至少有一个进程,一个进程至少有一个线程.进程在执行过程中拥有独立的内存单元,而多个线程共享内存资源,减少切换次数,从而效率更高.线程是进程的一个实体,是cpu调度和分派的基本单位,是比程序更小的能独立运行的基本单位.同一进程中的多个线程之间可以并发执行.

你了解守护线程吗?它和非守护线程有什么区别
程序运行完毕,jvm会等待非守护线程完成后关闭,但是jvm不会等待守护线程.守护线程最典型的例子就是GC线程

什么是多线程上下文切换
多线程的上下文切换是指CPU控制权由一个已经正在运行的线程切换到另外一个就绪并等待获取CPU执行权的线程的过程。

创建两种线程的方式?他们有什么区别?
通过实现java.lang.Runnable或者通过扩展java.lang.Thread类.相比扩展Thread,实现Runnable接口可能更优.原因有二:

Java不支持多继承.因此扩展Thread类就代表这个子类不能扩展其他类.而实现Runnable接口的类还可能扩展另一个类.
类可能只要求可执行即可,因此继承整个Thread类的开销过大.
Thread类中的start()和run()方法有什么区别?
start()方法被用来启动新创建的线程，而且start()内部调用了run()方法，这和直接调用run()方法的效果不一样。当你调用run()方法的时候，只会是在原来的线程中调用，没有新的线程启动，start()方法才会启动新线程。

怎么检测一个线程是否持有对象监视器
Thread类提供了一个holdsLock(Object obj)方法，当且仅当对象obj的监视器被某条线程持有的时候才会返回true，注意这是一个static方法，这意味着”某条线程”指的是当前线程。

Runnable和Callable的区别
Runnable接口中的run()方法的返回值是void，它做的事情只是纯粹地去执行run()方法中的代码而已；Callable接口中的call()方法是有返回值的，是一个泛型，和Future、FutureTask配合可以用来获取异步执行的结果。 
这其实是很有用的一个特性，因为多线程相比单线程更难、更复杂的一个重要原因就是因为多线程充满着未知性，某条线程是否执行了？某条线程执行了多久？某条线程执行的时候我们期望的数据是否已经赋值完毕？无法得知，我们能做的只是等待这条多线程的任务执行完毕而已。而Callable+Future/FutureTask却可以方便获取多线程运行的结果，可以在等待时间太长没获取到需要的数据的情况下取消该线程的任务

什么导致线程阻塞
阻塞指的是暂停一个线程的执行以等待某个条件发生（如某资源就绪），学过操作系统的同学对它一定已经很熟悉了。Java 提供了大量方法来支持阻塞，下面让我们逐一分析。

方法	说明
sleep()	sleep() 允许 指定以毫秒为单位的一段时间作为参数，它使得线程在指定的时间内进入阻塞状态，不能得到CPU 时间，指定的时间一过，线程重新进入可执行状态。 典型地，sleep() 被用在等待某个资源就绪的情形：测试发现条件不满足后，让线程阻塞一段时间后重新测试，直到条件满足为止
suspend() 和 resume()	两个方法配套使用，suspend()使得线程进入阻塞状态，并且不会自动恢复，必须其对应的resume() 被调用，才能使得线程重新进入可执行状态。典型地，suspend() 和 resume() 被用在等待另一个线程产生的结果的情形：测试发现结果还没有产生后，让线程阻塞，另一个线程产生了结果后，调用 resume() 使其恢复。
yield()	yield() 使当前线程放弃当前已经分得的CPU 时间，但不使当前线程阻塞，即线程仍处于可执行状态，随时可能再次分得 CPU 时间。调用 yield() 的效果等价于调度程序认为该线程已执行了足够的时间从而转到另一个线程
wait() 和 notify()	两个方法配套使用，wait() 使得线程进入阻塞状态，它有两种形式，一种允许 指定以毫秒为单位的一段时间作为参数，另一种没有参数，前者当对应的 notify() 被调用或者超出指定时间时线程重新进入可执行状态，后者则必须对应的 notify() 被调用.
wait(),notify()和suspend(),resume()之间的区别
初看起来它们与 suspend() 和 resume() 方法对没有什么分别，但是事实上它们是截然不同的。区别的核心在于，前面叙述的所有方法，阻塞时都不会释放占用的锁（如果占用了的话），而这一对方法则相反。上述的核心区别导致了一系列的细节上的区别。

首先，前面叙述的所有方法都隶属于 Thread 类，但是这一对却直接隶属于 Object 类，也就是说，所有对象都拥有这一对方法。初看起来这十分不可思议，但是实际上却是很自然的，因为这一对方法阻塞时要释放占用的锁，而锁是任何对象都具有的，调用任意对象的 wait() 方法导致线程阻塞，并且该对象上的锁被释放。而调用 任意对象的notify()方法则导致从调用该对象的 wait() 方法而阻塞的线程中随机选择的一个解除阻塞（但要等到获得锁后才真正可执行）。

其次，前面叙述的所有方法都可在任何位置调用，但是这一对方法却必须在 synchronized 方法或块中调用，理由也很简单，只有在synchronized 方法或块中当前线程才占有锁，才有锁可以释放。同样的道理，调用这一对方法的对象上的锁必须为当前线程所拥有，这样才有锁可以释放。因此，这一对方法调用必须放置在这样的 synchronized 方法或块中，该方法或块的上锁对象就是调用这一对方法的对象。若不满足这一条件，则程序虽然仍能编译，但在运行时会出现IllegalMonitorStateException 异常。

wait() 和 notify() 方法的上述特性决定了它们经常和synchronized关键字一起使用，将它们和操作系统进程间通信机制作一个比较就会发现它们的相似性：synchronized方法或块提供了类似于操作系统原语的功能，它们的执行不会受到多线程机制的干扰，而这一对方法则相当于 block 和wakeup 原语（这一对方法均声明为 synchronized）。它们的结合使得我们可以实现操作系统上一系列精妙的进程间通信的算法（如信号量算法），并用于解决各种复杂的线程间通信问题。

关于 wait() 和 notify() 方法最后再说明两点： 
第一：调用 notify() 方法导致解除阻塞的线程是从因调用该对象的 wait() 方法而阻塞的线程中随机选取的，我们无法预料哪一个线程将会被选择，所以编程时要特别小心，避免因这种不确定性而产生问题。

第二：除了 notify()，还有一个方法 notifyAll() 也可起到类似作用，唯一的区别在于，调用 notifyAll() 方法将把因调用该对象的 wait() 方法而阻塞的所有线程一次性全部解除阻塞。当然，只有获得锁的那一个线程才能进入可执行状态。

谈到阻塞，就不能不谈一谈死锁，略一分析就能发现，suspend() 方法和不指定超时期限的 wait() 方法的调用都可能产生死锁。遗憾的是，Java 并不在语言级别上支持死锁的避免，我们在编程中必须小心地避免死锁。

以上我们对 Java 中实现线程阻塞的各种方法作了一番分析，我们重点分析了 wait() 和 notify() 方法，因为它们的功能最强大，使用也最灵活，但是这也导致了它们的效率较低，较容易出错。实际使用中我们应该灵活使用各种方法，以便更好地达到我们的目的。

产生死锁的条件
1.互斥条件：一个资源每次只能被一个进程使用。 
2.请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。 
3.不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。 
4.循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。

为什么wait()方法和notify()/notifyAll()方法要在同步块中被调用
这是JDK强制的，wait()方法和notify()/notifyAll()方法在调用前都必须先获得对象的锁

wait()方法和notify()/notifyAll()方法在放弃对象监视器时有什么区别
wait()方法和notify()/notifyAll()方法在放弃对象监视器的时候的区别在于：wait()方法立即释放对象监视器，notify()/notifyAll()方法则会等待线程剩余代码执行完毕才会放弃对象监视器。

wait()与sleep()的区别
关于这两者已经在上面进行详细的说明,这里就做个概括好了:

sleep()来自Thread类，和wait()来自Object类.调用sleep()方法的过程中，线程不会释放对象锁。而 调用 wait 方法线程会释放对象锁
sleep()睡眠后不出让系统资源，wait让其他线程可以占用CPU
sleep(milliseconds)需要指定一个睡眠时间，时间一到会自动唤醒.而wait()需要配合notify()或者notifyAll()使用
为什么wait,nofity和nofityAll这些方法不放在Thread类当中
一个很明显的原因是JAVA提供的锁是对象级的而不是线程级的，每个对象都有锁，通过线程获得。如果线程需要等待某些锁那么调用对象中的wait()方法就有意义了。如果wait()方法定义在Thread类中，线程正在等待的是哪个锁就不明显了。简单的说，由于wait，notify和notifyAll都是锁级别的操作，所以把他们定义在Object类中因为锁属于对象。

怎么唤醒一个阻塞的线程
如果线程是因为调用了wait()、sleep()或者join()方法而导致的阻塞，可以中断线程，并且通过抛出InterruptedException来唤醒它；如果线程遇到了IO阻塞，无能为力，因为IO是操作系统实现的，Java代码并没有办法直接接触到操作系统。

什么是多线程的上下文切换
多线程的上下文切换是指CPU控制权由一个已经正在运行的线程切换到另外一个就绪并等待获取CPU执行权的线程的过程。

synchronized和ReentrantLock的区别
synchronized是和if、else、for、while一样的关键字，ReentrantLock是类，这是二者的本质区别。既然ReentrantLock是类，那么它就提供了比synchronized更多更灵活的特性，可以被继承、可以有方法、可以有各种各样的类变量，ReentrantLock比synchronized的扩展性体现在几点上： 
（1）ReentrantLock可以对获取锁的等待时间进行设置，这样就避免了死锁 
（2）ReentrantLock可以获取各种锁的信息 
（3）ReentrantLock可以灵活地实现多路通知 
另外，二者的锁机制其实也是不一样的:ReentrantLock底层调用的是Unsafe的park方法加锁，synchronized操作的应该是对象头中mark word.

FutureTask是什么
这个其实前面有提到过，FutureTask表示一个异步运算的任务。FutureTask里面可以传入一个Callable的具体实现类，可以对这个异步运算的任务的结果进行等待获取、判断是否已经完成、取消任务等操作。当然，由于FutureTask也是Runnable接口的实现类，所以FutureTask也可以放入线程池中。

一个线程如果出现了运行时异常怎么办?
如果这个异常没有被捕获的话，这个线程就停止执行了。另外重要的一点是：如果这个线程持有某个某个对象的监视器，那么这个对象监视器会被立即释放

Java当中有哪几种锁
自旋锁: 自旋锁在JDK1.6之后就默认开启了。基于之前的观察，共享数据的锁定状态只会持续很短的时间，为了这一小段时间而去挂起和恢复线程有点浪费，所以这里就做了一个处理，让后面请求锁的那个线程在稍等一会，但是不放弃处理器的执行时间，看看持有锁的线程能否快速释放。为了让线程等待，所以需要让线程执行一个忙循环也就是自旋操作。在jdk6之后，引入了自适应的自旋锁，也就是等待的时间不再固定了，而是由上一次在同一个锁上的自旋时间及锁的拥有者状态来决定

偏向锁: 在JDK1.之后引入的一项锁优化，目的是消除数据在无竞争情况下的同步原语。进一步提升程序的运行性能。 偏向锁就是偏心的偏，意思是这个锁会偏向第一个获得他的线程，如果接下来的执行过程中，改锁没有被其他线程获取，则持有偏向锁的线程将永远不需要再进行同步。偏向锁可以提高带有同步但无竞争的程序性能，也就是说他并不一定总是对程序运行有利，如果程序中大多数的锁都是被多个不同的线程访问，那偏向模式就是多余的，在具体问题具体分析的前提下，可以考虑是否使用偏向锁。

轻量级锁: 为了减少获得锁和释放锁所带来的性能消耗，引入了“偏向锁”和“轻量级锁”，所以在Java SE1.6里锁一共有四种状态，无锁状态，偏向锁状态，轻量级锁状态和重量级锁状态，它会随着竞争情况逐渐升级。锁可以升级但不能降级，意味着偏向锁升级成轻量级锁后不能降级成偏向锁

如何在两个线程间共享数据
通过在线程之间共享对象就可以了，然后通过wait/notify/notifyAll、await/signal/signalAll进行唤起和等待，比方说阻塞队列BlockingQueue就是为线程之间共享数据而设计的

如何正确的使用wait()?使用if还是while?
wait() 方法应该在循环调用，因为当线程获取到 CPU 开始执行的时候，其他条件可能还没有满足，所以在处理前，循环检测条件是否满足会更好。下面是一段标准的使用 wait 和 notify 方法的代码：

 synchronized (obj) {
    while (condition does not hold)
      obj.wait(); // (Releases lock, and reacquires on wakeup)
      ... // Perform action appropriate to condition
 }
1
2
3
4
5
什么是线程局部变量ThreadLocal
线程局部变量是局限于线程内部的变量，属于线程自身所有，不在多个线程间共享。Java提供ThreadLocal类来支持线程局部变量，是一种实现线程安全的方式。但是在管理环境下（如 web 服务器）使用线程局部变量的时候要特别小心，在这种情况下，工作线程的生命周期比任何应用变量的生命周期都要长。任何线程局部变量一旦在工作完成后没有释放，Java 应用就存在内存泄露的风险。

ThreadLoal的作用是什么?
简单说ThreadLocal就是一种以空间换时间的做法在每个Thread里面维护了一个ThreadLocal.ThreadLocalMap把数据进行隔离，数据不共享，自然就没有线程安全方面的问题了.

生产者消费者模型的作用是什么?
（1）通过平衡生产者的生产能力和消费者的消费能力来提升整个系统的运行效率，这是生产者消费者模型最重要的作用 
（2）解耦，这是生产者消费者模型附带的作用，解耦意味着生产者和消费者之间的联系少，联系越少越可以独自发展而不需要收到相互的制约

写一个生产者-消费者队列
可以通过阻塞队列实现,也可以通过wait-notify来实现.

使用阻塞队列来实现
//消费者
public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue q){
        this.queue=q;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(1000);//模拟耗时
                queue.put(produce());
            }
        }catch (InterruptedException e){

        }
    }

    private int produce() {
        int n=new Random().nextInt(10000);
        System.out.println("Thread:" + Thread.currentThread().getId() + " produce:" + n);
        return n;
    }
}
//消费者
public class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue q){
        this.queue=q;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);//模拟耗时
                consume(queue.take());
            }catch (InterruptedException e){

            }

        }
    }

    private void consume(Integer n) {
        System.out.println("Thread:" + Thread.currentThread().getId() + " consume:" + n);

    }
}
//测试
public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(100);
        Producer p=new Producer(queue);
        Consumer c1=new Consumer(queue);
        Consumer c2=new Consumer(queue);

        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

使用wait-notify来实现
该种方式应该最经典,这里就不做说明了

如果你提交任务时，线程池队列已满，这时会发生什么
如果你使用的LinkedBlockingQueue，也就是无界队列的话，没关系，继续添加任务到阻塞队列中等待执行，因为LinkedBlockingQueue可以近乎认为是一个无穷大的队列，可以无限存放任务；如果你使用的是有界队列比方说ArrayBlockingQueue的话，任务首先会被添加到ArrayBlockingQueue中，ArrayBlockingQueue满了，则会使用拒绝策略RejectedExecutionHandler处理满了的任务，默认是AbortPolicy。

为什么要使用线程池
避免频繁地创建和销毁线程，达到线程对象的重用。另外，使用线程池还可以根据项目灵活地控制并发的数目。

java中用到的线程调度算法是什么
抢占式。一个线程用完CPU之后，操作系统会根据线程优先级、线程饥饿情况等数据算出一个总的优先级并分配下一个时间片给某个线程执行。

Thread.sleep(0)的作用是什么
由于Java采用抢占式的线程调度算法，因此可能会出现某条线程常常获取到CPU控制权的情况，为了让某些优先级比较低的线程也能获取到CPU控制权，可以使用Thread.sleep(0)手动触发一次操作系统分配时间片的操作，这也是平衡CPU控制权的一种操作。


悲观锁：悲观锁认为竞争总是会发生，因此每次对某资源进行操作时，都会持有一个独占的锁，就像synchronized，不管三七二十一，直接上了锁就操作资源了。

ConcurrentHashMap的并发度是什么?
ConcurrentHashMap的并发度就是segment的大小，默认为16，这意味着最多同时可以有16条线程操作ConcurrentHashMap，这也是ConcurrentHashMap对Hashtable的最大优势，任何情况下，Hashtable能同时有两条线程获取Hashtable中的数据吗？

ConcurrentHashMap的工作原理
ConcurrentHashMap在jdk 1.6和jdk 1.8实现原理是不同的.

jdk 1.6:
ConcurrentHashMap是线程安全的，但是与Hashtablea相比，实现线程安全的方式不同。Hashtable是通过对hash表结构进行锁定，是阻塞式的，当一个线程占有这个锁时，其他线程必须阻塞等待其释放锁。ConcurrentHashMap是采用分离锁的方式，它并没有对整个hash表进行锁定，而是局部锁定，也就是说当一个线程占有这个局部锁时，不影响其他线程对hash表其他地方的访问。 
具体实现:ConcurrentHashMap内部有一个Segment

jdk 1.8
在jdk 8中，ConcurrentHashMap不再使用Segment分离锁，而是采用一种乐观锁CAS算法来实现同步问题，但其底层还是“数组+链表->红黑树”的实现。

CyclicBarrier和CountDownLatch区别
这两个类非常类似，都在java.util.concurrent下，都可以用来表示代码运行到某个点上，二者的区别在于：

CyclicBarrier的某个线程运行到某个点上之后，该线程即停止运行，直到所有的线程都到达了这个点，所有线程才重新运行；CountDownLatch则不是，某线程运行到某个点上之后，只是给某个数值-1而已，该线程继续运行
CyclicBarrier只能唤起一个任务，CountDownLatch可以唤起多个任务
CyclicBarrier可重用，CountDownLatch不可重用，计数值为0该CountDownLatch就不可再用了
java中的++操作符线程安全么?
不是线程安全的操作。它涉及到多个指令，如读取变量值，增加，然后存储回内存，这个过程可能会出现多个线程交差

你有哪些多线程开发良好的实践?
给线程命名
最小化同步范围
优先使用volatile
尽可能使用更高层次的并发工具而非wait和notify()来实现线程通信,如BlockingQueue,Semeaphore
优先使用并发容器而非同步容器.
考虑使用线程池
关于volatile关键字
可以创建Volatile数组吗?
Java 中可以创建 volatile类型数组，不过只是一个指向数组的引用，而不是整个数组。如果改变引用指向的数组，将会受到volatile 的保护，但是如果多个线程同时改变数组的元素，volatile标示符就不能起到之前的保护作用了

volatile能使得一个非原子操作变成原子操作吗?
一个典型的例子是在类中有一个 long 类型的成员变量。如果你知道该成员变量会被多个线程访问，如计数器、价格等，你最好是将其设置为 volatile。为什么？因为 Java 中读取 long 类型变量不是原子的，需要分成两步，如果一个线程正在修改该 long 变量的值，另一个线程可能只能看到该值的一半（前 32 位）。但是对一个 volatile 型的 long 或 double 变量的读写是原子。

一种实践是用 volatile 修饰 long 和 double 变量，使其能按原子类型来读写。double 和 long 都是64位宽，因此对这两种类型的读是分为两部分的，第一次读取第一个 32 位，然后再读剩下的 32 位，这个过程不是原子的，但 Java 中 volatile 型的 long 或 double 变量的读写是原子的。volatile 修复符的另一个作用是提供内存屏障（memory barrier），例如在分布式框架中的应用。简单的说，就是当你写一个 volatile 变量之前，Java 内存模型会插入一个写屏障（write barrier），读一个 volatile 变量之前，会插入一个读屏障（read barrier）。意思就是说，在你写一个 volatile 域时，能保证任何线程都能看到你写的值，同时，在写之前，也能保证任何数值的更新对所有线程是可见的，因为内存屏障会将其他所有写的值更新到缓存。

volatile类型变量提供什么保证?
volatile 主要有两方面的作用:1.避免指令重排2.可见性保证.例如，JVM 或者 JIT为了获得更好的性能会对语句重排序，但是 volatile 类型变量即使在没有同步块的情况下赋值也不会与其他语句重排序。 volatile 提供 happens-before 的保证，确保一个线程的修改能对其他线程是可见的。某些情况下，volatile 还能提供原子性，如读 64 位数据类型，像 long 和 double 都不是原子的(低32位和高32位)，但 volatile 类型的 double 和 long 就是原子的.

关于集合
Java中的集合及其继承关系
关于集合的体系是每个人都应该烂熟于心的,尤其是对我们经常使用的List,Map的原理更该如此.这里我们看这张图即可: 
这里写图片描述

更多内容可见集合类总结

poll()方法和remove()方法区别?
poll() 和 remove() 都是从队列中取出一个元素，但是 poll() 在获取元素失败的时候会返回空，但是 remove() 失败的时候会抛出异常。

LinkedHashMap和PriorityQueue的区别
PriorityQueue 是一个优先级队列,保证最高或者最低优先级的的元素总是在队列头部，但是 LinkedHashMap 维持的顺序是元素插入的顺序。当遍历一个 PriorityQueue 时，没有任何顺序保证，但是 LinkedHashMap 课保证遍历顺序是元素插入的顺序。

WeakHashMap与HashMap的区别是什么?
WeakHashMap 的工作与正常的 HashMap 类似，但是使用弱引用作为 key，意思就是当 key 对象没有任何引用时，key/value 将会被回收。

ArrayList和Array有什么区别?
Array可以容纳基本类型和对象，而ArrayList只能容纳对象。
Array是指定大小的，而ArrayList大小是固定的

Comparator和Comparable的区别?
Comparable 接口用于定义对象的自然顺序，而 comparator 通常用于定义用户定制的顺序。Comparable 总是只有一个，但是可以有多个 comparator 来定义对象的顺序。

如何实现集合排序?
你可以使用有序集合，如 TreeSet 或 TreeMap，你也可以使用有顺序的的集合，如 list，然后通过 Collections.sort() 来排序。

如何打印数组内容
你可以使用 Arrays.toString() 和 Arrays.deepToString() 方法来打印数组。由于数组没有实现 toString() 方法，所以如果将数组传递给 System.out.println() 方法，将无法打印出数组的内容，但是 Arrays.toString() 可以打印每个元素。

HashMap的实现原理
1 HashMap概述： HashMap是基于哈希表的Map接口的非同步实现。此实现提供所有可选的映射操作，并允许使用null值和null键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。 
2 HashMap的数据结构： 在java编程语言中，最基本的结构就是两种，一个是数组，另外一个是模拟指针（引用），所有的数据结构都可以用这两个基本结构来构造的，HashMap也不例外。HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体。

当我们往Hashmap中put元素时,首先根据key的hashcode重新计算hash值,根绝hash值得到这个元素在数组中的位置(下标),如果该数组在该位置上已经存放了其他元素,那么在这个位置上的元素将以链表的形式存放,新加入的放在链头,最先加入的放入链尾.如果数组中该位置没有元素,就直接将该元素放到数组的该位置上.

需要注意Jdk 1.8中对HashMap的实现做了优化,当链表中的节点数据超过八个之后,该链表会转为红黑树来提高查询效率,从原来的O(n)到O(logn)

你了解Fail-Fast机制吗
Fail-Fast即我们常说的快速失败,更多内容参看fail-fast机制

Fail-fast和Fail-safe有什么区别
Iterator的fail-fast属性与当前的集合共同起作用，因此它不会受到集合中任何改动的影响。Java.util包中的所有集合类都被设计为fail->fast的，而java.util.concurrent中的集合类都为fail-safe的。当检测到正在遍历的集合的结构被改变时，Fail-fast迭代器抛出ConcurrentModificationException，而fail-safe迭代器从不抛出ConcurrentModificationException。

throw和throws的区别
throw用于主动抛出java.lang.Throwable 类的一个实例化对象，意思是说你可以通过关键字 throw 抛出一个 Error 或者 一个Exception，如：throw new IllegalArgumentException(“size must be multiple of 2″), 
而throws 的作用是作为方法声明和签名的一部分，方法被抛出相应的异常以便调用者能处理。Java 中，任何未处理的受检查异常强制在 throws 子句中声明。

关于序列化
Java 中，Serializable 与 Externalizable 的区别
Serializable 接口是一个序列化 Java 类的接口，以便于它们可以在网络上传输或者可以将它们的状态保存在磁盘上，是 JVM 内嵌的默认序列化方式，成本高、脆弱而且不安全。Externalizable 允许你控制整个序列化过程，指定特定的二进制格式，增加安全机制。

简述堆和栈的区别
VM 中堆和栈属于不同的内存区域，使用目的也不同。栈常用于保存方法帧和局部变量，而对象总是在堆上分配。栈通常都比堆小，也不会在多个线程之间共享，而堆被整个 JVM 的所有线程共享。

JDK 1.8特性
java 8 在 Java 历史上是一个开创新的版本，下面 JDK 8 中 5 个主要的特性： 
Lambda 表达式，允许像对象一样传递匿名函数 
Stream API，充分利用现代多核 CPU，可以写出很简洁的代码 
Date 与 Time API，最终，有一个稳定、简单的日期和时间库可供你使用 
扩展方法，现在，接口中可以有静态、默认方法。 
重复注解，现在你可以将相同的注解在同一类型上使用多次。