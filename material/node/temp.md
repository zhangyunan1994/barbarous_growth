## 4. 

### step 2:多线程的简单使用

多线程这部分内容可能会比较难以理解和上手，前期可以先简单地了解一下基础，到了后面有精力和能力后再回来仔细看。推荐 **《Java 并发编程之美》** 或者 **《实战 Java 高并发程序设计》** 这两本书。我目前也在重构一份我之前写的多线程学习指南，后面会更新在公众号里面。

学习完多线程之后可以通过下面这些问题检测自己是否掌握。

**Java 多线程知识基础:**

1. 什么是线程和进程?
2. 请简要描述线程与进程的关系,区别及优缺点？
3. 说说并发与并行的区别?
4. 为什么要使用多线程呢?
5. 使用多线程可能带来什么问题?
6. 说说线程的生命周期和状态?
7. 什么是上下文切换?
8. 什么是线程死锁?如何避免死锁?
9. 说说 sleep() 方法和 wait() 方法区别和共同点?
10. 为什么我们调用 start() 方法时会执行 run() 方法，为什么我们不能直接调用 run() 方法？

**Java 多线程知识进阶：**

1. synchronized 关键字:① 说一说自己对于 synchronized 关键字的了解；② 说说自己是怎么使用 synchronized 关键字，在项目中用到了吗;③ 讲一下 synchronized 关键字的底层原理；④ 说说 JDK1.6 之后的 synchronized 关键字底层做了哪些优化，可以详细介绍一下这些优化吗；⑤ 谈谈 synchronized 和 ReentrantLock 的区别。
2. volatile 关键字： ① 讲一下 Java 内存模型；② 说说 synchronized 关键字和 volatile 关键字的区别。
3. ThreadLocal：① 简介；② 原理；③ 内存泄露问题。
4. 线程池：① 为什么要用线程池？；② 实现 Runnable 接口和 Callable 接口的区别；③ 执行 execute() 方法和 submit() 方法的区别是什么呢？；④ 如何创建线程池。
5. Atomic 原子类: ① 介绍一下 Atomic 原子类；② JUC 包中的原子类是哪 4 类?；③ 讲讲 AtomicInteger 的使用；④ 能不能给我简单介绍一下 AtomicInteger 类的原理。
6. AQS ：① 简介；② 原理；③ AQS 常用组件。

另外，推荐看一下下面这几篇文章：

- **[Java 并发基础常见面试题总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/Multithread/JavaConcurrencyBasicsCommonInterviewQuestionsSummary.md)**
- **[Java 并发进阶常见面试题总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/Multithread/JavaConcurrencyAdvancedCommonInterviewQuestions.md)**
- [并发容器总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/Multithread/%E5%B9%B6%E5%8F%91%E5%AE%B9%E5%99%A8%E6%80%BB%E7%BB%93.md)
- [乐观锁与悲观锁](https://github.com/Snailclimb/JavaGuide/blob/master/docs/essential-content-for-interview/%E9%9D%A2%E8%AF%95%E5%BF%85%E5%A4%87%E4%B9%8B%E4%B9%90%E8%A7%82%E9%94%81%E4%B8%8E%E6%82%B2%E8%A7%82%E9%94%81.md)
- [JUC 中的 Atomic 原子类总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/Multithread/Atomic.md)
- [AQS 原理以及 AQS 同步组件总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/Multithread/AQS.md)

### step 3(可选):操作系统与计算机网络

操作系统这方面我觉得掌握操作系统的基础知识和 Linux 的常用命令就行以及一些重要概念就行了。

关于操作系统的话，我没有什么操作系统方面的书籍可以推荐，因为我自己也没认真看过几本。因为操作系统比较枯燥的原因，我建议这部分看先看视频学可能会比较好一点。我推荐一个 Github 上开源的哈工大《操作系统》课程给大家吧！地址：https://github.com/hoverwinter/HIT-OSLab 。

另外，对于 Linux 我们要掌握基本的使用就需要对一些常用命令非常熟悉比如：目录切换命令、目录操作命令、文件的操作命令、压缩或者解压文件的命令等等。推荐一个 Github 上学习 Linux 的开源文档：[《Java 程序员眼中的 Linux》](https://github.com/judasn/Linux-Tutorial "《Java 程序员眼中的 Linux》")

计算机网络方面的学习，我觉得掌握基本的知识就行了，不需要太深究，一般面试对这方面要求也不高，毕竟不是专门做网络的。推荐 **《网络是怎样连接的》** 、**《图解 HTTP》** 这两本书来看，这两本书都属于比较有趣易懂的类型，也适合没有基础的人来看。





### step 5:前端知识

这一步主要是学习前端基础 (HTML、CSS、JavaScript),当然 BootStrap、Layui 等等比较简单的前端框架你也可以了解一下。网上有很多这方面资源，我只推荐一个大部分初学这些知识都会看的网站：http://www.w3school.com.cn/ ，这个网站用来回顾知识也很不错 。推荐先把 HTML、CSS、JS 的基础知识过一遍，然后通过一个实际的前端项目来巩固。

现在都是前后端分离，就目前来看大部分项目都优先选择 React、Angular、Vue 这些厉害的框架来开发。如果你想往全栈方向发展的话（笔主目前的方向，我用 React 在公司做过两个小型项目），建议先把 JS 基础打好，然后再选择 React、Angular、Vue 其中的一个来认真学习一下。国内使用 Vue 比较多一点，国外一般用的是 React 和 Angular。

### step 5:MySQL

学习 MySQL 的基本使用，基本的增删改查，SQL 命令，索引、存储过程这些都学一下吧！推荐书籍 **《SQL 基础教程（第 2 版）》**（入门级）、**《高性能 MySQL : 第 3 版》**(进阶)、**《MySQL 必知必会》**。

下面这些 MySQL 相关的文章强烈推荐你看看：

- **[【推荐】MySQL/数据库 知识点总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/MySQL.md)**
- **[阿里巴巴开发手册数据库部分的一些最佳实践](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C%E6%95%B0%E6%8D%AE%E5%BA%93%E9%83%A8%E5%88%86%E7%9A%84%E4%B8%80%E4%BA%9B%E6%9C%80%E4%BD%B3%E5%AE%9E%E8%B7%B5.md)**
- **[一千行 MySQL 学习笔记](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/%E4%B8%80%E5%8D%83%E8%A1%8CMySQL%E5%91%BD%E4%BB%A4.md)**
- [MySQL 高性能优化规范建议](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/MySQL%E9%AB%98%E6%80%A7%E8%83%BD%E4%BC%98%E5%8C%96%E8%A7%84%E8%8C%83%E5%BB%BA%E8%AE%AE.md)
- [数据库索引总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/MySQL%20Index.md)
- [事务隔离级别(图文详解)](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/%E4%BA%8B%E5%8A%A1%E9%9A%94%E7%A6%BB%E7%BA%A7%E5%88%AB(%E5%9B%BE%E6%96%87%E8%AF%A6%E8%A7%A3).md)
- [一条 SQL 语句在 MySQL 中如何执行的](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/%E4%B8%80%E6%9D%A1sql%E8%AF%AD%E5%8F%A5%E5%9C%A8mysql%E4%B8%AD%E5%A6%82%E4%BD%95%E6%89%A7%E8%A1%8C%E7%9A%84.md)




### step 7:常用框架

学习 Struts2(可不用学)、**Spring**、**SpringMVC**、**Hibernate**、**Mybatis**、**shiro** 等框架的使用， (可选) 熟悉 **Spring 原理**（大厂面试必备），然后很有必要学习一下 **SpringBoot** ，**学好 SpringBoot 真的很重要**。很多公司对于应届生都是直接上手 **SpringBoot**，不过如果时间允许的话，我还是推荐你把 **Spring**、**SpringMVC** 提前学一下。

关于 SpringBoot ，推荐看一下笔主开源的 [Spring Boot 教程](https://github.com/Snailclimb/springboot-guide "Spring Boot 教程") （SpringBoot 核心知识点总结。 基于 Spring Boot 2.19+）。

**Spring 真的很重要！** 一定要搞懂 AOP 和 IOC 这两个概念。Spring 中 bean 的作用域与生命周期、SpringMVC 工作原理详解等等知识点都是非常重要的，一定要搞懂。

推荐看文档+视频结合的方式，中途配合实战来学习，学习期间可以多看看 JavaGuide 对于[常用框架的总结](https://github.com/Snailclimb/JavaGuide#%E5%B8%B8%E7%94%A8%E6%A1%86%E6%9E%B6 "常用框架的总结")。

**另外，都 2019 年了，咱千万不要再学 JSP 了好不？**

#

学习完之后可以看一下下面这几篇文章，检查一下自己的学习情况：

- **[Java 基础知识回顾](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/Java%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86.md)**
- **[Java 基础知识疑难点/易错点](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/Java%E7%96%91%E9%9A%BE%E7%82%B9.md)**
- **[一些重要的 Java 程序设计题](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/Java%E7%A8%8B%E5%BA%8F%E8%AE%BE%E8%AE%A1%E9%A2%98.md)**
