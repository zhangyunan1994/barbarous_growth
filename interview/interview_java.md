<h1> 面试题 </h1>


**Table of Contents**

- [基础篇](#%e5%9f%ba%e7%a1%80%e7%af%87)
  - [基本功](#%e5%9f%ba%e6%9c%ac%e5%8a%9f)
    - [面向对象的特征](#%e9%9d%a2%e5%90%91%e5%af%b9%e8%b1%a1%e7%9a%84%e7%89%b9%e5%be%81)
    - [final, finally, finalize 的区别](#final-finally-finalize-%e7%9a%84%e5%8c%ba%e5%88%ab)
    - [final有哪些用法](#final%e6%9c%89%e5%93%aa%e4%ba%9b%e7%94%a8%e6%b3%95)
    - [int 和 Integer 有什么区别](#int-%e5%92%8c-integer-%e6%9c%89%e4%bb%80%e4%b9%88%e5%8c%ba%e5%88%ab)
    - [重载和重写的区别](#%e9%87%8d%e8%bd%bd%e5%92%8c%e9%87%8d%e5%86%99%e7%9a%84%e5%8c%ba%e5%88%ab)
    - [throw和throws的区别](#throw%e5%92%8cthrows%e7%9a%84%e5%8c%ba%e5%88%ab)
    - [抽象类和接口有什么区别](#%e6%8a%bd%e8%b1%a1%e7%b1%bb%e5%92%8c%e6%8e%a5%e5%8f%a3%e6%9c%89%e4%bb%80%e4%b9%88%e5%8c%ba%e5%88%ab)
    - [说说反射的用途及实现](#%e8%af%b4%e8%af%b4%e5%8f%8d%e5%b0%84%e7%9a%84%e7%94%a8%e9%80%94%e5%8f%8a%e5%ae%9e%e7%8e%b0)
    - [聊聊 Redis 使用场景](#%e8%81%8a%e8%81%8a-redis-%e4%bd%bf%e7%94%a8%e5%9c%ba%e6%99%af)
    - [Redis 持久化机制](#redis-%e6%8c%81%e4%b9%85%e5%8c%96%e6%9c%ba%e5%88%b6)
    - [Redis 如何实现持久化](#redis-%e5%a6%82%e4%bd%95%e5%ae%9e%e7%8e%b0%e6%8c%81%e4%b9%85%e5%8c%96)
    - [Redis 集群方案与实现](#redis-%e9%9b%86%e7%be%a4%e6%96%b9%e6%a1%88%e4%b8%8e%e5%ae%9e%e7%8e%b0)
    - [Redis 为什么是单线程的](#redis-%e4%b8%ba%e4%bb%80%e4%b9%88%e6%98%af%e5%8d%95%e7%ba%bf%e7%a8%8b%e7%9a%84)
    - [缓存崩溃](#%e7%bc%93%e5%ad%98%e5%b4%a9%e6%ba%83)
    - [缓存降级](#%e7%bc%93%e5%ad%98%e9%99%8d%e7%ba%a7)
    - [使用缓存的合理性问题](#%e4%bd%bf%e7%94%a8%e7%bc%93%e5%ad%98%e7%9a%84%e5%90%88%e7%90%86%e6%80%a7%e9%97%ae%e9%a2%98)
  - [消息队列](#%e6%b6%88%e6%81%af%e9%98%9f%e5%88%97)
    - [消息队列的使用场景](#%e6%b6%88%e6%81%af%e9%98%9f%e5%88%97%e7%9a%84%e4%bd%bf%e7%94%a8%e5%9c%ba%e6%99%af)
    - [消息的重发补偿解决思路](#%e6%b6%88%e6%81%af%e7%9a%84%e9%87%8d%e5%8f%91%e8%a1%a5%e5%81%bf%e8%a7%a3%e5%86%b3%e6%80%9d%e8%b7%af)
    - [消息的幂等性解决思路](#%e6%b6%88%e6%81%af%e7%9a%84%e5%b9%82%e7%ad%89%e6%80%a7%e8%a7%a3%e5%86%b3%e6%80%9d%e8%b7%af)
    - [消息的堆积解决思路](#%e6%b6%88%e6%81%af%e7%9a%84%e5%a0%86%e7%a7%af%e8%a7%a3%e5%86%b3%e6%80%9d%e8%b7%af)
    - [自己如何实现消息队列](#%e8%87%aa%e5%b7%b1%e5%a6%82%e4%bd%95%e5%ae%9e%e7%8e%b0%e6%b6%88%e6%81%af%e9%98%9f%e5%88%97)
    - [如何保证消息的有序性](#%e5%a6%82%e4%bd%95%e4%bf%9d%e8%af%81%e6%b6%88%e6%81%af%e7%9a%84%e6%9c%89%e5%ba%8f%e6%80%a7)
- [框架篇](#%e6%a1%86%e6%9e%b6%e7%af%87)
  - [Spring](#spring)
    - [BeanFactory 和 ApplicationContext 有什么区别](#beanfactory-%e5%92%8c-applicationcontext-%e6%9c%89%e4%bb%80%e4%b9%88%e5%8c%ba%e5%88%ab)
    - [Spring Bean 的生命周期](#spring-bean-%e7%9a%84%e7%94%9f%e5%91%bd%e5%91%a8%e6%9c%9f)
    - [Spring IOC 如何实现](#spring-ioc-%e5%a6%82%e4%bd%95%e5%ae%9e%e7%8e%b0)
    - [说说 Spring AOP](#%e8%af%b4%e8%af%b4-spring-aop)
    - [Spring AOP 实现原理](#spring-aop-%e5%ae%9e%e7%8e%b0%e5%8e%9f%e7%90%86)
    - [动态代理（cglib 与 JDK）](#%e5%8a%a8%e6%80%81%e4%bb%a3%e7%90%86cglib-%e4%b8%8e-jdk)
    - [Spring 事务实现方式](#spring-%e4%ba%8b%e5%8a%a1%e5%ae%9e%e7%8e%b0%e6%96%b9%e5%bc%8f)
    - [Spring 事务底层原理](#spring-%e4%ba%8b%e5%8a%a1%e5%ba%95%e5%b1%82%e5%8e%9f%e7%90%86)
    - [如何自定义注解实现功能](#%e5%a6%82%e4%bd%95%e8%87%aa%e5%ae%9a%e4%b9%89%e6%b3%a8%e8%a7%a3%e5%ae%9e%e7%8e%b0%e5%8a%9f%e8%83%bd)
    - [Spring MVC 运行流程](#spring-mvc-%e8%bf%90%e8%a1%8c%e6%b5%81%e7%a8%8b)
    - [Spring MVC 启动流程](#spring-mvc-%e5%90%af%e5%8a%a8%e6%b5%81%e7%a8%8b)
    - [Spring 的单例实现原理](#spring-%e7%9a%84%e5%8d%95%e4%be%8b%e5%ae%9e%e7%8e%b0%e5%8e%9f%e7%90%86)
    - [Spring 框架中用到了哪些设计模式](#spring-%e6%a1%86%e6%9e%b6%e4%b8%ad%e7%94%a8%e5%88%b0%e4%ba%86%e5%93%aa%e4%ba%9b%e8%ae%be%e8%ae%a1%e6%a8%a1%e5%bc%8f)
    - [Spring 其他产品（Srping Boot、Spring Cloud、Spring Secuirity、Spring Data、Spring AMQP 等）](#spring-%e5%85%b6%e4%bb%96%e4%ba%a7%e5%93%81srping-bootspring-cloudspring-secuirityspring-dataspring-amqp-%e7%ad%89)
  - [Netty](#netty)
    - [为什么选择 Netty](#%e4%b8%ba%e4%bb%80%e4%b9%88%e9%80%89%e6%8b%a9-netty)
    - [说说业务中，Netty 的使用场景](#%e8%af%b4%e8%af%b4%e4%b8%9a%e5%8a%a1%e4%b8%adnetty-%e7%9a%84%e4%bd%bf%e7%94%a8%e5%9c%ba%e6%99%af)
    - [原生的 NIO 在 JDK 1.7 版本存在 epoll bug](#%e5%8e%9f%e7%94%9f%e7%9a%84-nio-%e5%9c%a8-jdk-17-%e7%89%88%e6%9c%ac%e5%ad%98%e5%9c%a8-epoll-bug)
    - [什么是TCP 粘包/拆包](#%e4%bb%80%e4%b9%88%e6%98%aftcp-%e7%b2%98%e5%8c%85%e6%8b%86%e5%8c%85)
    - [TCP粘包/拆包的解决办法](#tcp%e7%b2%98%e5%8c%85%e6%8b%86%e5%8c%85%e7%9a%84%e8%a7%a3%e5%86%b3%e5%8a%9e%e6%b3%95)
    - [Netty 线程模型](#netty-%e7%ba%bf%e7%a8%8b%e6%a8%a1%e5%9e%8b)
    - [说说 Netty 的零拷贝](#%e8%af%b4%e8%af%b4-netty-%e7%9a%84%e9%9b%b6%e6%8b%b7%e8%b4%9d)
    - [Netty 内部执行流程](#netty-%e5%86%85%e9%83%a8%e6%89%a7%e8%a1%8c%e6%b5%81%e7%a8%8b)
    - [Netty 重连实现](#netty-%e9%87%8d%e8%bf%9e%e5%ae%9e%e7%8e%b0)
- [微服务篇](#%e5%be%ae%e6%9c%8d%e5%8a%a1%e7%af%87)
  - [微服务](#%e5%be%ae%e6%9c%8d%e5%8a%a1)
    - [前后端分离是如何做的](#%e5%89%8d%e5%90%8e%e7%ab%af%e5%88%86%e7%a6%bb%e6%98%af%e5%a6%82%e4%bd%95%e5%81%9a%e7%9a%84)
    - [微服务哪些框架](#%e5%be%ae%e6%9c%8d%e5%8a%a1%e5%93%aa%e4%ba%9b%e6%a1%86%e6%9e%b6)
    - [你怎么理解 RPC 框架](#%e4%bd%a0%e6%80%8e%e4%b9%88%e7%90%86%e8%a7%a3-rpc-%e6%a1%86%e6%9e%b6)
    - [说说 RPC 的实现原理](#%e8%af%b4%e8%af%b4-rpc-%e7%9a%84%e5%ae%9e%e7%8e%b0%e5%8e%9f%e7%90%86)
    - [说说 Dubbo 的实现原理](#%e8%af%b4%e8%af%b4-dubbo-%e7%9a%84%e5%ae%9e%e7%8e%b0%e5%8e%9f%e7%90%86)
    - [你怎么理解 RESTful](#%e4%bd%a0%e6%80%8e%e4%b9%88%e7%90%86%e8%a7%a3-restful)
    - [说说如何设计一个良好的 API](#%e8%af%b4%e8%af%b4%e5%a6%82%e4%bd%95%e8%ae%be%e8%ae%a1%e4%b8%80%e4%b8%aa%e8%89%af%e5%a5%bd%e7%9a%84-api)
    - [如何理解 RESTful API 的幂等性](#%e5%a6%82%e4%bd%95%e7%90%86%e8%a7%a3-restful-api-%e7%9a%84%e5%b9%82%e7%ad%89%e6%80%a7)
    - [如何保证接口的幂等性](#%e5%a6%82%e4%bd%95%e4%bf%9d%e8%af%81%e6%8e%a5%e5%8f%a3%e7%9a%84%e5%b9%82%e7%ad%89%e6%80%a7)
    - [说说 CAP 定理、 BASE 理论](#%e8%af%b4%e8%af%b4-cap-%e5%ae%9a%e7%90%86-base-%e7%90%86%e8%ae%ba)
    - [怎么考虑数据一致性问题](#%e6%80%8e%e4%b9%88%e8%80%83%e8%99%91%e6%95%b0%e6%8d%ae%e4%b8%80%e8%87%b4%e6%80%a7%e9%97%ae%e9%a2%98)
    - [说说最终一致性的实现方案](#%e8%af%b4%e8%af%b4%e6%9c%80%e7%bb%88%e4%b8%80%e8%87%b4%e6%80%a7%e7%9a%84%e5%ae%9e%e7%8e%b0%e6%96%b9%e6%a1%88)
    - [你怎么看待微服务](#%e4%bd%a0%e6%80%8e%e4%b9%88%e7%9c%8b%e5%be%85%e5%be%ae%e6%9c%8d%e5%8a%a1)
    - [微服务与 SOA 的区别](#%e5%be%ae%e6%9c%8d%e5%8a%a1%e4%b8%8e-soa-%e7%9a%84%e5%8c%ba%e5%88%ab)
    - [如何拆分服务](#%e5%a6%82%e4%bd%95%e6%8b%86%e5%88%86%e6%9c%8d%e5%8a%a1)
    - [微服务如何进行数据库管理](#%e5%be%ae%e6%9c%8d%e5%8a%a1%e5%a6%82%e4%bd%95%e8%bf%9b%e8%a1%8c%e6%95%b0%e6%8d%ae%e5%ba%93%e7%ae%a1%e7%90%86)
    - [如何应对微服务的链式调用异常](#%e5%a6%82%e4%bd%95%e5%ba%94%e5%af%b9%e5%be%ae%e6%9c%8d%e5%8a%a1%e7%9a%84%e9%93%be%e5%bc%8f%e8%b0%83%e7%94%a8%e5%bc%82%e5%b8%b8)
    - [对于快速追踪与定位问题](#%e5%af%b9%e4%ba%8e%e5%bf%ab%e9%80%9f%e8%bf%bd%e8%b8%aa%e4%b8%8e%e5%ae%9a%e4%bd%8d%e9%97%ae%e9%a2%98)
    - [微服务的安全](#%e5%be%ae%e6%9c%8d%e5%8a%a1%e7%9a%84%e5%ae%89%e5%85%a8)
  - [分布式](#%e5%88%86%e5%b8%83%e5%bc%8f)
    - [谈谈业务中使用分布式的场景](#%e8%b0%88%e8%b0%88%e4%b8%9a%e5%8a%a1%e4%b8%ad%e4%bd%bf%e7%94%a8%e5%88%86%e5%b8%83%e5%bc%8f%e7%9a%84%e5%9c%ba%e6%99%af)
    - [Session 分布式方案](#session-%e5%88%86%e5%b8%83%e5%bc%8f%e6%96%b9%e6%a1%88)
    - [分布式锁的场景](#%e5%88%86%e5%b8%83%e5%bc%8f%e9%94%81%e7%9a%84%e5%9c%ba%e6%99%af)
    - [分布是锁的实现方案](#%e5%88%86%e5%b8%83%e6%98%af%e9%94%81%e7%9a%84%e5%ae%9e%e7%8e%b0%e6%96%b9%e6%a1%88)
    - [分布式事务](#%e5%88%86%e5%b8%83%e5%bc%8f%e4%ba%8b%e5%8a%a1)
    - [集群与负载均衡的算法与实现](#%e9%9b%86%e7%be%a4%e4%b8%8e%e8%b4%9f%e8%bd%bd%e5%9d%87%e8%a1%a1%e7%9a%84%e7%ae%97%e6%b3%95%e4%b8%8e%e5%ae%9e%e7%8e%b0)
    - [说说分库与分表设计](#%e8%af%b4%e8%af%b4%e5%88%86%e5%ba%93%e4%b8%8e%e5%88%86%e8%a1%a8%e8%ae%be%e8%ae%a1)
    - [分库与分表带来的分布式困境与应对之策](#%e5%88%86%e5%ba%93%e4%b8%8e%e5%88%86%e8%a1%a8%e5%b8%a6%e6%9d%a5%e7%9a%84%e5%88%86%e5%b8%83%e5%bc%8f%e5%9b%b0%e5%a2%83%e4%b8%8e%e5%ba%94%e5%af%b9%e4%b9%8b%e7%ad%96)
  - [安全问题](#%e5%ae%89%e5%85%a8%e9%97%ae%e9%a2%98)
    - [安全要素与 STRIDE 威胁](#%e5%ae%89%e5%85%a8%e8%a6%81%e7%b4%a0%e4%b8%8e-stride-%e5%a8%81%e8%83%81)
    - [防范常见的 Web 攻击](#%e9%98%b2%e8%8c%83%e5%b8%b8%e8%a7%81%e7%9a%84-web-%e6%94%bb%e5%87%bb)
    - [服务端通信安全攻防](#%e6%9c%8d%e5%8a%a1%e7%ab%af%e9%80%9a%e4%bf%a1%e5%ae%89%e5%85%a8%e6%94%bb%e9%98%b2)
    - [HTTPS 原理剖析](#https-%e5%8e%9f%e7%90%86%e5%89%96%e6%9e%90)
    - [HTTPS 降级攻击](#https-%e9%99%8d%e7%ba%a7%e6%94%bb%e5%87%bb)
    - [授权与认证](#%e6%8e%88%e6%9d%83%e4%b8%8e%e8%ae%a4%e8%af%81)
    - [基于角色的访问控制](#%e5%9f%ba%e4%ba%8e%e8%a7%92%e8%89%b2%e7%9a%84%e8%ae%bf%e9%97%ae%e6%8e%a7%e5%88%b6)
    - [基于数据的访问控制](#%e5%9f%ba%e4%ba%8e%e6%95%b0%e6%8d%ae%e7%9a%84%e8%ae%bf%e9%97%ae%e6%8e%a7%e5%88%b6)
  - [性能优化](#%e6%80%a7%e8%83%bd%e4%bc%98%e5%8c%96)
    - [性能指标有哪些](#%e6%80%a7%e8%83%bd%e6%8c%87%e6%a0%87%e6%9c%89%e5%93%aa%e4%ba%9b)
    - [如何发现性能瓶颈](#%e5%a6%82%e4%bd%95%e5%8f%91%e7%8e%b0%e6%80%a7%e8%83%bd%e7%93%b6%e9%a2%88)
    - [性能调优的常见手段](#%e6%80%a7%e8%83%bd%e8%b0%83%e4%bc%98%e7%9a%84%e5%b8%b8%e8%a7%81%e6%89%8b%e6%ae%b5)
    - [说说你在项目中如何进行性能调优](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%9c%a8%e9%a1%b9%e7%9b%ae%e4%b8%ad%e5%a6%82%e4%bd%95%e8%bf%9b%e8%a1%8c%e6%80%a7%e8%83%bd%e8%b0%83%e4%bc%98)
- [工程篇](#%e5%b7%a5%e7%a8%8b%e7%af%87)
  - [需求分析](#%e9%9c%80%e6%b1%82%e5%88%86%e6%9e%90)
    - [你如何对需求原型进行理解和拆分](#%e4%bd%a0%e5%a6%82%e4%bd%95%e5%af%b9%e9%9c%80%e6%b1%82%e5%8e%9f%e5%9e%8b%e8%bf%9b%e8%a1%8c%e7%90%86%e8%a7%a3%e5%92%8c%e6%8b%86%e5%88%86)
    - [说说你对功能性需求的理解](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%af%b9%e5%8a%9f%e8%83%bd%e6%80%a7%e9%9c%80%e6%b1%82%e7%9a%84%e7%90%86%e8%a7%a3)
    - [说说你对非功能性需求的理解](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%af%b9%e9%9d%9e%e5%8a%9f%e8%83%bd%e6%80%a7%e9%9c%80%e6%b1%82%e7%9a%84%e7%90%86%e8%a7%a3)
    - [你针对产品提出哪些交互和改进意见](#%e4%bd%a0%e9%92%88%e5%af%b9%e4%ba%a7%e5%93%81%e6%8f%90%e5%87%ba%e5%93%aa%e4%ba%9b%e4%ba%a4%e4%ba%92%e5%92%8c%e6%94%b9%e8%bf%9b%e6%84%8f%e8%a7%81)
    - [你如何理解用户痛点](#%e4%bd%a0%e5%a6%82%e4%bd%95%e7%90%86%e8%a7%a3%e7%94%a8%e6%88%b7%e7%97%9b%e7%82%b9)
  - [设计能力](#%e8%ae%be%e8%ae%a1%e8%83%bd%e5%8a%9b)
    - [说说你在项目中使用过的 UML 图](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%9c%a8%e9%a1%b9%e7%9b%ae%e4%b8%ad%e4%bd%bf%e7%94%a8%e8%bf%87%e7%9a%84-uml-%e5%9b%be)
    - [你如何考虑组件化](#%e4%bd%a0%e5%a6%82%e4%bd%95%e8%80%83%e8%99%91%e7%bb%84%e4%bb%b6%e5%8c%96)
    - [你如何考虑服务化](#%e4%bd%a0%e5%a6%82%e4%bd%95%e8%80%83%e8%99%91%e6%9c%8d%e5%8a%a1%e5%8c%96)
    - [你如何进行领域建模](#%e4%bd%a0%e5%a6%82%e4%bd%95%e8%bf%9b%e8%a1%8c%e9%a2%86%e5%9f%9f%e5%bb%ba%e6%a8%a1)
    - [你如何划分领域边界](#%e4%bd%a0%e5%a6%82%e4%bd%95%e5%88%92%e5%88%86%e9%a2%86%e5%9f%9f%e8%be%b9%e7%95%8c)
    - [说说你项目中的领域建模](#%e8%af%b4%e8%af%b4%e4%bd%a0%e9%a1%b9%e7%9b%ae%e4%b8%ad%e7%9a%84%e9%a2%86%e5%9f%9f%e5%bb%ba%e6%a8%a1)
    - [说说概要设计](#%e8%af%b4%e8%af%b4%e6%a6%82%e8%a6%81%e8%ae%be%e8%ae%a1)
  - [设计模式](#%e8%ae%be%e8%ae%a1%e6%a8%a1%e5%bc%8f)
    - [你项目中有使用哪些设计模式](#%e4%bd%a0%e9%a1%b9%e7%9b%ae%e4%b8%ad%e6%9c%89%e4%bd%bf%e7%94%a8%e5%93%aa%e4%ba%9b%e8%ae%be%e8%ae%a1%e6%a8%a1%e5%bc%8f)
    - [说说常用开源框架中设计模式使用分析](#%e8%af%b4%e8%af%b4%e5%b8%b8%e7%94%a8%e5%bc%80%e6%ba%90%e6%a1%86%e6%9e%b6%e4%b8%ad%e8%ae%be%e8%ae%a1%e6%a8%a1%e5%bc%8f%e4%bd%bf%e7%94%a8%e5%88%86%e6%9e%90)
    - [说说你对设计原则的理解](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%af%b9%e8%ae%be%e8%ae%a1%e5%8e%9f%e5%88%99%e7%9a%84%e7%90%86%e8%a7%a3)
    - [23种设计模式的设计理念](#23%e7%a7%8d%e8%ae%be%e8%ae%a1%e6%a8%a1%e5%bc%8f%e7%9a%84%e8%ae%be%e8%ae%a1%e7%90%86%e5%bf%b5)
    - [设计模式之间的异同，例如策略模式与状态模式的区别](#%e8%ae%be%e8%ae%a1%e6%a8%a1%e5%bc%8f%e4%b9%8b%e9%97%b4%e7%9a%84%e5%bc%82%e5%90%8c%e4%be%8b%e5%a6%82%e7%ad%96%e7%95%a5%e6%a8%a1%e5%bc%8f%e4%b8%8e%e7%8a%b6%e6%80%81%e6%a8%a1%e5%bc%8f%e7%9a%84%e5%8c%ba%e5%88%ab)
    - [设计模式之间的结合，例如策略模式+简单工厂模式的实践](#%e8%ae%be%e8%ae%a1%e6%a8%a1%e5%bc%8f%e4%b9%8b%e9%97%b4%e7%9a%84%e7%bb%93%e5%90%88%e4%be%8b%e5%a6%82%e7%ad%96%e7%95%a5%e6%a8%a1%e5%bc%8f%e7%ae%80%e5%8d%95%e5%b7%a5%e5%8e%82%e6%a8%a1%e5%bc%8f%e7%9a%84%e5%ae%9e%e8%b7%b5)
    - [设计模式的性能，例如单例模式哪种性能更好。](#%e8%ae%be%e8%ae%a1%e6%a8%a1%e5%bc%8f%e7%9a%84%e6%80%a7%e8%83%bd%e4%be%8b%e5%a6%82%e5%8d%95%e4%be%8b%e6%a8%a1%e5%bc%8f%e5%93%aa%e7%a7%8d%e6%80%a7%e8%83%bd%e6%9b%b4%e5%a5%bd)
  - [业务工程](#%e4%b8%9a%e5%8a%a1%e5%b7%a5%e7%a8%8b)
    - [你系统中的前后端分离是如何做的](#%e4%bd%a0%e7%b3%bb%e7%bb%9f%e4%b8%ad%e7%9a%84%e5%89%8d%e5%90%8e%e7%ab%af%e5%88%86%e7%a6%bb%e6%98%af%e5%a6%82%e4%bd%95%e5%81%9a%e7%9a%84)
    - [说说你的开发流程](#%e8%af%b4%e8%af%b4%e4%bd%a0%e7%9a%84%e5%bc%80%e5%8f%91%e6%b5%81%e7%a8%8b)
    - [你和团队是如何沟通的](#%e4%bd%a0%e5%92%8c%e5%9b%a2%e9%98%9f%e6%98%af%e5%a6%82%e4%bd%95%e6%b2%9f%e9%80%9a%e7%9a%84)
    - [你如何进行代码评审](#%e4%bd%a0%e5%a6%82%e4%bd%95%e8%bf%9b%e8%a1%8c%e4%bb%a3%e7%a0%81%e8%af%84%e5%ae%a1)
    - [说说你对技术与业务的理解](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%af%b9%e6%8a%80%e6%9c%af%e4%b8%8e%e4%b8%9a%e5%8a%a1%e7%9a%84%e7%90%86%e8%a7%a3)
    - [说说你在项目中经常遇到的 Exception](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%9c%a8%e9%a1%b9%e7%9b%ae%e4%b8%ad%e7%bb%8f%e5%b8%b8%e9%81%87%e5%88%b0%e7%9a%84-exception)
    - [说说你在项目中遇到感觉最难Bug，怎么解决的](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%9c%a8%e9%a1%b9%e7%9b%ae%e4%b8%ad%e9%81%87%e5%88%b0%e6%84%9f%e8%a7%89%e6%9c%80%e9%9a%bebug%e6%80%8e%e4%b9%88%e8%a7%a3%e5%86%b3%e7%9a%84)
    - [说说你在项目中遇到印象最深困难，怎么解决的](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%9c%a8%e9%a1%b9%e7%9b%ae%e4%b8%ad%e9%81%87%e5%88%b0%e5%8d%b0%e8%b1%a1%e6%9c%80%e6%b7%b1%e5%9b%b0%e9%9a%be%e6%80%8e%e4%b9%88%e8%a7%a3%e5%86%b3%e7%9a%84)
    - [你觉得你们项目还有哪些不足的地方](#%e4%bd%a0%e8%a7%89%e5%be%97%e4%bd%a0%e4%bb%ac%e9%a1%b9%e7%9b%ae%e8%bf%98%e6%9c%89%e5%93%aa%e4%ba%9b%e4%b8%8d%e8%b6%b3%e7%9a%84%e5%9c%b0%e6%96%b9)
    - [你是否遇到过 CPU 100% ，如何排查与解决](#%e4%bd%a0%e6%98%af%e5%90%a6%e9%81%87%e5%88%b0%e8%bf%87-cpu-100-%e5%a6%82%e4%bd%95%e6%8e%92%e6%9f%a5%e4%b8%8e%e8%a7%a3%e5%86%b3)
    - [你是否遇到过 内存 OOM ，如何排查与解决](#%e4%bd%a0%e6%98%af%e5%90%a6%e9%81%87%e5%88%b0%e8%bf%87-%e5%86%85%e5%ad%98-oom-%e5%a6%82%e4%bd%95%e6%8e%92%e6%9f%a5%e4%b8%8e%e8%a7%a3%e5%86%b3)
    - [说说你对敏捷开发的实践](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%af%b9%e6%95%8f%e6%8d%b7%e5%bc%80%e5%8f%91%e7%9a%84%e5%ae%9e%e8%b7%b5)
    - [说说你对开发运维的实践](#%e8%af%b4%e8%af%b4%e4%bd%a0%e5%af%b9%e5%bc%80%e5%8f%91%e8%bf%90%e7%bb%b4%e7%9a%84%e5%ae%9e%e8%b7%b5)
    - [介绍下工作中的一个对自己最有价值的项目，以及在这个过程中的角色](#%e4%bb%8b%e7%bb%8d%e4%b8%8b%e5%b7%a5%e4%bd%9c%e4%b8%ad%e7%9a%84%e4%b8%80%e4%b8%aa%e5%af%b9%e8%87%aa%e5%b7%b1%e6%9c%80%e6%9c%89%e4%bb%b7%e5%80%bc%e7%9a%84%e9%a1%b9%e7%9b%ae%e4%bb%a5%e5%8f%8a%e5%9c%a8%e8%bf%99%e4%b8%aa%e8%bf%87%e7%a8%8b%e4%b8%ad%e7%9a%84%e8%a7%92%e8%89%b2)
  - [软实力](#%e8%bd%af%e5%ae%9e%e5%8a%9b)
    - [说说你的亮点](#%e8%af%b4%e8%af%b4%e4%bd%a0%e7%9a%84%e4%ba%ae%e7%82%b9)
    - [说说你最近在看什么书](#%e8%af%b4%e8%af%b4%e4%bd%a0%e6%9c%80%e8%bf%91%e5%9c%a8%e7%9c%8b%e4%bb%80%e4%b9%88%e4%b9%a6)
    - [说说你觉得最有意义的技术书籍](#%e8%af%b4%e8%af%b4%e4%bd%a0%e8%a7%89%e5%be%97%e6%9c%80%e6%9c%89%e6%84%8f%e4%b9%89%e7%9a%84%e6%8a%80%e6%9c%af%e4%b9%a6%e7%b1%8d)
    - [工作之余做什么事情](#%e5%b7%a5%e4%bd%9c%e4%b9%8b%e4%bd%99%e5%81%9a%e4%bb%80%e4%b9%88%e4%ba%8b%e6%83%85)
    - [说说个人发展方向方面的思考](#%e8%af%b4%e8%af%b4%e4%b8%aa%e4%ba%ba%e5%8f%91%e5%b1%95%e6%96%b9%e5%90%91%e6%96%b9%e9%9d%a2%e7%9a%84%e6%80%9d%e8%80%83)
    - [说说你认为的服务端开发工程师应该具备哪些能力](#%e8%af%b4%e8%af%b4%e4%bd%a0%e8%ae%a4%e4%b8%ba%e7%9a%84%e6%9c%8d%e5%8a%a1%e7%ab%af%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b%e5%b8%88%e5%ba%94%e8%af%a5%e5%85%b7%e5%a4%87%e5%93%aa%e4%ba%9b%e8%83%bd%e5%8a%9b)
    - [说说你认为的架构师是什么样的，架构师主要做什么](#%e8%af%b4%e8%af%b4%e4%bd%a0%e8%ae%a4%e4%b8%ba%e7%9a%84%e6%9e%b6%e6%9e%84%e5%b8%88%e6%98%af%e4%bb%80%e4%b9%88%e6%a0%b7%e7%9a%84%e6%9e%b6%e6%9e%84%e5%b8%88%e4%b8%bb%e8%a6%81%e5%81%9a%e4%bb%80%e4%b9%88)
    - [说说你所理解的技术专家](#%e8%af%b4%e8%af%b4%e4%bd%a0%e6%89%80%e7%90%86%e8%a7%a3%e7%9a%84%e6%8a%80%e6%9c%af%e4%b8%93%e5%ae%b6)
    - [强引用,软引用,弱引用,虚引用.不同的引用类型主要体现在GC上:](#%e5%bc%ba%e5%bc%95%e7%94%a8%e8%bd%af%e5%bc%95%e7%94%a8%e5%bc%b1%e5%bc%95%e7%94%a8%e8%99%9a%e5%bc%95%e7%94%a8%e4%b8%8d%e5%90%8c%e7%9a%84%e5%bc%95%e7%94%a8%e7%b1%bb%e5%9e%8b%e4%b8%bb%e8%a6%81%e4%bd%93%e7%8e%b0%e5%9c%a8gc%e4%b8%8a)
    - [内部类的作用](#%e5%86%85%e9%83%a8%e7%b1%bb%e7%9a%84%e4%bd%9c%e7%94%a8)
    - [什么是编译器常量?使用它有什么风险?](#%e4%bb%80%e4%b9%88%e6%98%af%e7%bc%96%e8%af%91%e5%99%a8%e5%b8%b8%e9%87%8f%e4%bd%bf%e7%94%a8%e5%ae%83%e6%9c%89%e4%bb%80%e4%b9%88%e9%a3%8e%e9%99%a9)
    - [关于垃圾回收](#%e5%85%b3%e4%ba%8e%e5%9e%83%e5%9c%be%e5%9b%9e%e6%94%b6)
    - [简单的解释一下垃圾回收](#%e7%ae%80%e5%8d%95%e7%9a%84%e8%a7%a3%e9%87%8a%e4%b8%80%e4%b8%8b%e5%9e%83%e5%9c%be%e5%9b%9e%e6%94%b6)
    - [进程,线程相关](#%e8%bf%9b%e7%a8%8b%e7%ba%bf%e7%a8%8b%e7%9b%b8%e5%85%b3)
    - [什么是多线程的上下文切换](#%e4%bb%80%e4%b9%88%e6%98%af%e5%a4%9a%e7%ba%bf%e7%a8%8b%e7%9a%84%e4%b8%8a%e4%b8%8b%e6%96%87%e5%88%87%e6%8d%a2)
    - [synchronized和ReentrantLock的区别](#synchronized%e5%92%8creentrantlock%e7%9a%84%e5%8c%ba%e5%88%ab)
    - [FutureTask是什么](#futuretask%e6%98%af%e4%bb%80%e4%b9%88)
      - [CyclicBarrier和CountDownLatch区别](#cyclicbarrier%e5%92%8ccountdownlatch%e5%8c%ba%e5%88%ab)
    - [关于volatile关键字](#%e5%85%b3%e4%ba%8evolatile%e5%85%b3%e9%94%ae%e5%ad%97)
      - [volatile类型变量提供什么保证?](#volatile%e7%b1%bb%e5%9e%8b%e5%8f%98%e9%87%8f%e6%8f%90%e4%be%9b%e4%bb%80%e4%b9%88%e4%bf%9d%e8%af%81)
  - [JDK 1.8特性](#jdk-18%e7%89%b9%e6%80%a7)

# 基础篇
## 基本功
### 面向对象的特征

封装,继承,多态.有时候也会加上抽象.

### final, finally, finalize 的区别

1. final：用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，被其修饰的类不可继承。
2. finally：异常处理语句结构的一部分，表示总是执行。
3. finalize：Object 类的一个方法，在垃圾回收器执行的时候会调用被回收对象的此方法，可以覆盖此方法 提供垃圾收集时的其他资源回收，例如关闭文件等。该方法更像是一个对象生命周期的临终方法，当该方法 被系统调用则代表该对象即将"死亡"，但是需要注意的是，我们主动行为上去调用该方法并不会导致该对 象"死亡"，这是一个被动的方法（其实就是回调方法），不需要我们调用。

### final有哪些用法

final 也是很多面试喜欢问的地方,能回答下以下三点就不错了: 

1. 被 final 修饰的类不可以被继承 
2. 被 final 修饰的方法不可以被重写 
3. 被 final 修饰的变量不可以被改变.如果修饰引用,那么表示引用不可变,引用指向的内容可变. 
4. 被 final 修饰的方法,JVM会尝试将其内联,以提高运行效率 
5. 被 final 修饰的常量,在编译阶段会存入常量池中.

回答出编译器对final域要遵守的两个重排序规则更好: 

1. 在构造函数内对一个 final 域的写入,与随后把这个被构造对象的引用赋值给一个引用变量,这两个操作之间不能重排序. 
2. 初次读一个包含 final 域的对象的引用,与随后初次读这个 final 域,这两个操作之间不能重排序.

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

### throw和throws的区别

throw用于主动抛出java.lang.Throwable 类的一个实例化对象，意思是说你可以通过关键字 throw 抛出一个 Error 或者 一个Exception，如：throw new IllegalArgumentException(“size must be multiple of 2″), 

而throws 的作用是作为方法声明和签名的一部分，方法被抛出相应的异常以便调用者能处理。Java 中，任何未处理的受检查异常强制在 throws 子句中声明。

### 抽象类和接口有什么区别

**抽象类**

抽象类是用来捕捉子类的通用特性的 。它不能被实例化，只能被用作子类的超类。抽象类是被用来创建继承层级里子类的模板

**接口**

接口是抽象方法的集合。如果一个类实现了某个接口，那么它就继承了这个接口的抽象方法。Java8 之后接口中方法可以有默认实现

### 说说反射的用途及实现

首先要清楚，什么是Java中的反射，反射是Java语言的特征之一，运行中的Java程序获取自身的信息，并且可以操作类和对象的内部属性。通过反射，我们可以在运行时获取程序或程序集中的每一个类型成员和成员变量的信息，程序中一般的对象类型都是在编译期确定下来的，而Java的反射机制可以动态的创建对象并调用其属性，这样对象的类型在编译期是未知的。所以我们通过反射机制直接创建对象即使这个对象是在编译期是未知的。反射的核心为: 在JVM运行时才动态调用类或调用方法或属性，不需要事先知道运行对象是谁。Java的反射提供的功能如下：

1. 在运行时判断任意一个对象所属的类。
2. 在运行时构造任意一个对象。
3. 在运行时判断任意一个类所具有的成员变量和方法（通过反射设置可以调用private）。
4. 在运行时调用任意一个对象的方法。

在Java中反射最重要的用途就是用于开发各种通用的框架，而且平时的使用“.”就能展示出类所拥有的的方法或者方法的参数也是用到了反射。

Java中很多框架都是配置化的（比如通过XML文件配置Javabean、Action之类的），为了保证框架的通用性，会在运行时根据配置文件的不同加载其对应的类和对象，以调用不同的方法，这里就是根据反射所实现的======在运行时动态加载需要加载的对象。

以上所提及到的是反射可以用于判断任意对象所属的类，获得class对象，构造一个对象以及调用一个对象。反射的基本功能如下：relfect

1. 获取class对象
   ```
   （1）、使用 Class类的 forName() 静态方法：
          public static Class<?> forName(String className)
          ……
          在JDBC开发中常用此方法加载数据库驱动:
          ……java
          Class.forName(driver)
   （2）、直接获取某一个对象的 class，比如：
          Class<?> clazz = int.class;
          Class<?> classInt = Integer.TYPE;
   （3）、调用某个对象的getClass() 方法，比如：
          StringBuilder str = new StringBuilder("123");
          Class<?> clazz = str.getClass();
    ```
2. 判断是否为某个类的实例。
  
   一般的来说，通常使用instanceof关键字来判断是否为某个类的实例。同时我们也可以借助反射中class对象的isinstance()方法来判断是否为某个类的实例，这是一个native方法： public native boolean isInstance(Object obj);

3. 创建实例。
   
    有以下两种方式：

   （1）使用calss对象中newInstance（）方法来创建对象对应类的类型。
   ```
   Class<?> c  = String.calss;
   Object str = c.getInstance();
   ```
   （2）先通过Class对象获取指定的Constructor对象，在调用Constructor对象的newInstance方法来创建实例。这种方法可以用指定的构造器构造类的实例。
   ```
     //获取String所对应的Class对象
     Class<?> c = String.class;
     //获取String类带一个String参数的构造器
     Constructor constructor = c.getConstructor(String.class);
     //根据构造器创建实例
     Object obj = constructor.newInstance("23333");
     System.out.println(obj);
   ```

### 说说自定义注解的场景及实现



### HTTP 请求的 GET 与 POST 方式的区别

首先要知道的是get和post都是http协议中两种发射请求的方法，而http是基于tcp\ip的通讯协议，所以get和post都是基于tcp\ip的通讯链接，两者本源并无区别。但是两者之间有个巨大的差别就是Get产生一个TCP数据包，而Post产生两个TCP数据包。详细的请求过程如下：

1. Get在进行请求时，浏览器会一并把http header和data发送出去，服务器接收到后会响应200。
2. Post在进行请求时分为两步，会先把http header发送出去，服务器在接收到后会响应100，然后浏览器会把后续的data发送出去，服务器接收到会响应200。

所以一般来说会推荐使用get方式进行请求，因为效率相比于post高一些，其实基于现代网络的性能，两者并无太大差别，只是理论上的差距，相反post两次发送的方式在验证数据包的完整性是一个很大的优点。而且两者都有自己的定义的语义，在使用的时候要注意区分，不能无脑混用。

而且还听说firefox的浏览器，两个方式都是只发送一次。。。。~~~


### session 与 cookie 区别

Session是在服务端保存的一个数据结构，用来跟踪用户的状态，这个数据可以保存在集群、数据库、文件中；

Cookie是客户端保存用户信息的一种机制，用来记录用户的一些信息，也是实现Session的一种方式。

1. 存储位置不同， session 存储在服务端，cookie存储在客户端
2. 存储容量不同，session在服务端可以存更多的数据，但是会占据服务器的资源，但是服务器发展到如今的地步，完全可以容纳这些数据；cookie在客户端存储的数据量有限，一般不会超过4K，根据浏览器的不同存储的容量也有一些差别。
3. 两者的结合使用
  ```
  存储在服务端：通过cookie存储一个session_id，然后具体的数据则是保存在session中。如果用户已经登录，则服务器会在cookie中保存一个session_id，下次再次请求的时候，会把该session_id携带上来，服务器根据session_id在session库中获取用户的session数据。就能知道该用户到底是谁，以及之前保存的一些状态信息。这种专业术语叫做server side session。
  将session数据加密，然后存储在cookie中。这种专业术语叫做client side session。flask采用的就是这种方式，但是也可以替换成其他形式。
  ```
### session 分布式处理

1. session 复制
2. session 集中存储

如果只是为了校验一下登录信息，还可以采用一些其他的方案，例如：jwt、token 等

### JDBC 流程

1. 注册驱动
2. 获取连接
3. 创建语句
4. 执行语句并处理结果集
5. 关闭语句和数据库连接

### MVC 设计思想

MVC(Model View Controller)是一种软件设计的框架模式，它采用模型(Model)-视图(View)-控制器(controller)的方法把业务逻辑、数据与界面显示分离。把众多的业务逻辑聚集到一个部件里面，当然这种比较官方的解释是不能让我们足够清晰的理解什么是MVC的。用通俗的话来讲，MVC的理念就是把数据处理、数据展示(界面)和程序/用户的交互三者分离开的一种编程模式。注意！！是编程模式，不是设计模式。其三个核心部件（也是模式名称的来源）为Model、View、Controller。

1. Model(模型)：所有的用户数据、状态以及程序逻辑，独立于视图和控制器。
2. View(视图)：呈现模型，类似于Web程序中的界面，视图会从模型中拿到需要展现的状态以及数据，对于相同的数据可以有多种不同的显示形式(视图)。
3. Controller(控制器)：负责获取用户的输入信息，进行解析并反馈给模型，通常情况下一个视图具有一个控制器。

接下来要说的是为什么要采用MVC的编程模式。

1. 可以使同一个程序使用不同的表现形式，如果控制器反馈给模型的数据发生了变化，那么模型将及时通知有关的视图，视图会对应的刷新自己所展现的内容。
2. 因为模型是独立于视图的，所以模型可复用，模型可以独立的移植到别的地方继续使用。
3. 前后端的代码分离，使项目开发的分工更加明确，程序的测试更加简便，提高开发效率。
4. 降低项目之间的耦合性，使其更方便于后续的维护和开发。

当然MVC模式也有缺点，相对于传统的前后端不分离项目，更不易于调试，也不适用于小型的项目，前后端分离的投入还不如直接不分离。

详细说(chao)下Spring MVC的特点：
1. 能方便的设计出干净的web层。
2. 进行更简洁的web层开发。
3. 天生的与Spring框架集成（比如Ioc、Aop等）;
4. 能简单的进行web层的单元测试。
5. 提供强大的约定大于配置的契约式编程支持。
6. 支持灵活的URL到页面控制器的映射。
7. 非常容易与其他视图技术集成，因为模型数据不放在特定的API里，而是放在一个model里。
8. 非常灵活的数据验证、格式化和数据绑定机制，能使用任何对象进行数据绑定，不必实现特定框架的API。
9. 提供一套强大的JSP标签库，简化JSP开发。
10. 支持灵活的本地化、主题等解析。
11. 更加简单的异常处理。
12. 对静态资源的支持，支持Restful风格。




### equals 与 == 的区别

equals 和 == 最大的区别是一个是方法一个是运算符。

==：如果比较的对象是基本数据类型，则比较的是数值是否相等；如果比较的是引用数据类型，则比较的是对象的地址值是否相等。

equals()：用来比较方法两个对象的内容是否相等。

注意：equals 方法不能用于基本数据类型的变量，如果没有对 equals 方法进行重写，则比较的是引用类型的变 量所指向的对象的地址。

## 集合
### List、 Set 和 Map 区别

- List 用来存储有序序列，List中存放的数据是可重复的
- Set用来存储无序集合，，Set存放的数据是唯一的
- Map：存储双列数据的集合，通过键值对存储数据，存储 的数据是无序的，Key值不能重复，value值可以重复。

### ArrayList 与 LinkedList 区别

最明显的区别是 ArrrayList底层的数据结构是数组，支持随机访问，而 LinkedList 的底层数据结构是双向循环链表，不支持随机访问。使用下标访问一个元素，ArrayList 的时间复杂度是 O(1)，而 LinkedList 是 O(n)。

区别：

1. 查询上面已经提到
2. 删除元素，当删除元素时，ArrayList 会将删除位置后所有数据向前移动，效率低，LinkedList只需要移动节点指向即可
3. 增加元素，当增加元素到List的容量时，ArrayList 需要重新创建一个更大的数组，并将旧数组数据复制到新数组，LinkedList 可直接在尾部追加，无需复制数据
4. 修改数据，想要改数据得先知道数据在哪吧，所以这里 ArrayList 更有优势


### ArrayList 与 Vector 区别

1）Vector的方法都是同步的(Synchronized),是线程安全的(thread-safe)，而ArrayList的方法不是，由于线程的同步必然要影响性能，因此,ArrayList的性能比Vector好。  
2）当Vector或ArrayList中的元素超过它的初始大小时,Vector会将它的容量翻倍,而ArrayList只增加50%的大小，这样,ArrayList就有利于节约内存空间。

### HashMap 和 Hashtable 的区别

1. 两者所继承的父类不同。
   
   Hashtable继承自Dictionary类，而HashMap继承自AbstractMap类。但二者都实现了Map接口。

2. 线程安全性不同

    先说结论， Hashtable 线程安全，HashMap线程不安全。因为Hashtable中每个方法中都加入了Synchronize来保证线程的安全，而hashmap的线程不安全原因是当多个线程同时检测到总数量超过门限值的时候就会同时调用resize操作，各自生成新的数组并rehash后赋给该map底层的数组table，结果最终只有最后一个线程生成的新数组被赋给table变量，其他线程的均会丢失。而且当某些线程已经完成赋值而其他线程刚开始的时候，就会用已经被赋值的table作为原始数组，这样就会有问题。

3. 是否提供contains方法。
   
   HashMap把Hashtable的contains方法去掉了，改成containsValue和containsKey，因为contains方法容易让人引起误解可能是key也可能是value。Hashtable则保留了contains，containsValue和containsKey三个方法，其中contains和containsValue功能相同。

4. key和value是否允许null值。

    在hashtable中key和values是都不允许为null的，编辑的时候回通过，但是在运行的时候如果有null的值则会报空指针异常。

    在hashmap中可以是用null来作键，可以有多个值为null，因为hashmap中使用containskey（）方法判断是否存在，而不是用get（）。

5. 两个遍历方式的内部实现上不同。

    两者都是使用Iterator进行遍历，但是由于历史原因Hashtable使用的是Enumeration的方式 。

6. hash值的不同。

    哈希值的使用不同，HashTable直接使用对象的hashCode。而HashMap重新计算hash值。

7. 内部实现使用的数组初始化和扩容方式不同。

    HashTable在不指定容量的情况下的默认容量为11，而HashMap为16，Hashtable不要求底层数组的容量一定要为2的整数次幂，而HashMap则要求一定为2的整数次幂。
    
    Hashtable扩容时，将容量变为原来的2倍加1，而HashMap扩容时，将容量变为原来的2倍。Hashtable和HashMap它们两个内部实现方式的数组的初始大小和扩容的方式。HashTable中hash数组默认大小是11，增加的方式是 old*2+1。

### HashSet 和 HashMap 区别


### HashMap详解

1. 众所周知，HashMap是一个用于存储Key-Value键值对的集合，每一个键值对也叫做Entry。这些个键值对（Entry）分散存储在    个数组当中，这个数组就是HashMap的主干。

2. HashMap数组每一个元素的初始值都是Null，对于HashMap我们常用的操作为get and put.
      1. put的过程。 
         在写入一个元素的时候需要先利用哈希函数来确定该元素的写入位置，即该元素的index，但是如果有大量的数据写入，那必然不可避免的产生相同的index，此时HashMap的处理方案是使用链表来解决，即可以简单的认为hashmap是由链表组成的数组，其中使用数组来确定桶的位置，然后使用链表用来处理index重复的元素，但是在java8中进行了改变，在HashMap中链表的长度超过8且总元素量超过64情况下会将链表转换为红黑树，但是红黑树退化为链表的长度阈值为6，中间有个7作为缓冲，以防止过于频繁的转换浪费资源，这一点后续再说，因为我不懂红黑树。回到刚才，如果哈希函数计算出了相同的index，则将元素放入该位置的链表中（JDK 1.7 之前使用头插法、JDK 1.8 使用尾插法）。
      2. get的过程。 
         在执行get的过程中，会首先将输入端key进行一次映射运算，得到其对应的index来找到该链表，然后从链表 头开始，依次对比来找到key所对应的元素，这就是get的执行过程。 另外，HashMap的默认的长度为16，并且每次进行扩增或者初始化时，长度必须是2的幂次方，选择默认长度为16是为了服务于从key映射到index的哈希算法（index=Hash("key")）,为了实现一个均匀分布的Hash函数，设计者们采用了位运算的方式，index=HashCode(Key)&(Length-1)，length为hashmap的长度，举例如下：

        1. 计算book的hashcode，结果为十进制的3029737，二进制的101110001110101110 1001。 
        2. 假定HashMap长度是默认的16，计算Length-1的结果为十进制的15，二进制的1111。
        3. 把以上两个结果做与运算，101110001110101110 1001 & 1111 = 1001，十进制是9，所以 index=9。
    可以说，Hash算法最终得到的index结果，完全取决于Key的Hashcode值的最后几位。 这也是为何hashMap的初始长度默认16的原因，如果将HashMap的长度调整为10，则会出现某些index不会出现，而某些index会重复出现的情况。
    解决hash冲突的办法还有4种，分别是：
    
    (1)开放定址法 
    
    (2)链地址法 
    
    (3)再哈希法 
    
    (4)公共溢出区域法。

    其中底层使用基本数组来确定桶的位置是因为速度要比链表快，至于为何不使用ArrayList，因为使用基本数组可以自定义扩容机制，HashMap中数组扩容刚好是2的次幂，在进行位运算时的效率高。 而ArrayList的扩容机制是1.5倍扩容，在此并不适用。还有其他的一些相关问题： 
3. HashMap会在什么情况下进行扩容？ 
   
   如果bucket满了(超过load factor * current capacity)，就要resize。 load factor为0.75，为了最大程度避免哈希冲突 current capacity为当前数组大小。 
4. 为什么扩容是2的幂次方？ 
   
    HashMap为了存取高效，尽量减小数据间的碰撞，将数据能够较为平均的分布，使得每个链表的长度基本相等，hashmap中函数采用的是位运算进行计算桶的位置（hash&(length-1)。 也就是说hash%length==hash&(length-1)），效果等同于取模，但是如果扩容的长度为整10的倍数，则可能会产生某些index永远不会产生，而有些index则会长度过长的问题。 
5. 说说String中hashcode的实现? 
   
    顺道提一下hash算法，是将一个大范围的数映射到一个较小的范围，依次来节省资源和空间。String的hashcode算法如下：  
    public int hashCode() { 

        int h = hash; 
        if (h == 0 && value.length > 0) { 
            char val[] = value; 
            for (int i = 0; i < value.length; i++) { 
            h = 31 X h + val[i]; 
            } 
            hash = h; 
        } 
        return h; 
    }

    String类中的hashCode计算方法还是比较简单的，就是以31为权，每一位为字符的ASCII值进行运算，用自然溢出来等效取模。
那为什么以31为质数呢？
    主要是因为31是一个奇质数，所以31i=32i-i=(i<<5)-i，这种位移与减法结合的计算相比一般的运算快很多（不懂）。 

6. 为什么hashmap在链表的长度超过8时会将链表转化为红黑树？
    
   关于这个问题，首先要知道在jdk 1.8中对HashMap做了哪些优化。

   1.将原先的HashMap由数组+链表转化成为了数组+链表+红黑树，详情见上述。

   2.优化了高位运算的hash算法：h^(h>>>16)。

   3.扩容后，元素要么是在原位置，要么是在原位置再移动2次幂的位置，且链表顺序不变，且以此解决了HashMap的死循环问题。 

    至于为什么设置为链表的长度超过8时会转化为红黑树，答案就是不知道。 
1. HashMap在高并发编程的情况下可能会有哪些问题。 
   
    (1) 多线程扩容，引起的死循环问题。 
   
    (2) 多线程put的时候可能导致元素丢失。 
   
    (3) put非null元素后get出来的却是null。 
   
    其中问题（1）已经在jdk 1.8以后的版本中解决，不会出现死循环的问题。另外的两个问题可以使用ConcurrentHashmap，Hashtable等线程安全等集合类进行解决。 
2. 一般来说，用什么作为HashMap的key？ 
    
    首先，HashMap的key可以为null，在key为null的时候，会放在数组的第一个位置，一般用Integer、String这种不可变类当HashMap当key，而且String最为常用，有两个原因： 
    
    (1)因为字符串是不可变的，所以在它创建的时候hashcode就被缓存了，不需要重新计算。这就使得字符串很适合作为Map中的键，字符串的处理速度要快过其它的键对象。这就是HashMap中的键往往都使用字符串。 
    
    (2)因为获取对象的时候要用到equals()和hashCode()方法，那么键对象正确的重写这两个方法是非常重要的,这些类已经很规范的覆写了hashCode()以及equals()方法。

### HashMap 和 ConcurrentHashMap 的区别

首先，HashMap线程不安全，ConcurrentHashMap则是线程安全，在ConcurrentHashMap中引入了一个"分段锁"的概念，可以理解为把一个大的Map拆分成N个小的HashTable，根据key.hashCode()来决定把key放到哪个HashTable中。

在ConcurrentHashMap中，就是把Map分成了N个Segment，put和get的时候，都是现根据key.hashCode()算出放到哪个Segment中，在ConcurrentHashMap中默认是把segments初始化为长度为16的数组。通常来说，ConcurrentHashMap在保证线程安全的前提下，效率是HashTable的16倍。

详见：https://www.cnblogs.com/ruiati/p/6244833.html

### ConcurrentHashMap中的分段锁

原因由以下几点： 1、加入多个分段锁浪费内存空间。 2、生产环境中， map 在放入时竞争同一个锁的概率非常小，分段锁反而会造成更新等操作的长时间等待。 3、为了提高 GC 的效率。

在放弃了采用分段锁后，使用了一套新的线程安全方案，首先通过Hash找到对应的链表后，查看是否是第一个Object，如果是，直接用cas原则插入，无需加锁，然后如果不是链表第一个object，则直接用链表第一个object加锁，这里加的锁是synchronized，虽然效率不如 ReentrantLock， 但节约了空间，这里会一直用第一个object为锁， 直到重新计算map大小， 比如扩容或者操作了第一个object为止。

### LinkedHashMap和PriorityQueue的区别
PriorityQueue 是一个优先级队列,保证最高或者最低优先级的的元素总是在队列头部，但是 LinkedHashMap 维持的顺序是元素插入的顺序。当遍历一个 PriorityQueue 时，没有任何顺序保证，但是 LinkedHashMap 课保证遍历顺序是元素插入的顺序。

### WeakHashMap与HashMap的区别是什么?

WeakHashMap 的工作与正常的 HashMap 类似，但是使用弱引用作为 key，意思就是当 key 对象没有任何引用时，key/value 将会被回收。

### Comparator和Comparable的区别?

Comparable 接口用于定义对象的自然顺序，而 comparator 通常用于定义用户定制的顺序。Comparable 总是只有一个，但是可以有多个 comparator 来定义对象的顺序。

### 如何实现集合排序?

你可以使用有序集合，如 TreeSet 或 TreeMap，你也可以使用有顺序的的集合，如 list，然后通过 Collections.sort() 来排序。

### HashMap的实现原理

1. HashMap概述： HashMap是基于哈希表的Map接口的非同步实现。此实现提供所有可选的映射操作，并允许使用null值和null键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。 

2. HashMap的数据结构： 在java编程语言中，最基本的结构就是两种，一个是数组，另外一个是模拟指针（引用），所有的数据结构都可以用这两个基本结构来构造的，HashMap也不例外。HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体。

当我们往Hashmap中put元素时,首先根据key的hashcode重新计算hash值,根绝hash值得到这个元素在数组中的位置(下标),如果该数组在该位置上已经存放了其他元素,那么在这个位置上的元素将以链表的形式存放,新加入的放在链头,最先加入的放入链尾.如果数组中该位置没有元素,就直接将该元素放到数组的该位置上.

需要注意Jdk 1.8中对HashMap的实现做了优化,当链表中的节点数据超过八个之后,该链表会转为红黑树来提高查询效率,从原来的O(n)到O(logn)

### ConcurrentHashMap的并发度是什么?

ConcurrentHashMap的并发度就是segment的大小，默认为16，这意味着最多同时可以有16条线程操作ConcurrentHashMap，这也是ConcurrentHashMap对Hashtable的最大优势，任何情况下，Hashtable能同时有两条线程获取Hashtable中的数据吗？

ConcurrentHashMap的工作原理
ConcurrentHashMap在jdk 1.6和jdk 1.8实现原理是不同的.

jdk 1.6:
ConcurrentHashMap是线程安全的，但是与Hashtablea相比，实现线程安全的方式不同。Hashtable是通过对hash表结构进行锁定，是阻塞式的，当一个线程占有这个锁时，其他线程必须阻塞等待其释放锁。ConcurrentHashMap是采用分离锁的方式，它并没有对整个hash表进行锁定，而是局部锁定，也就是说当一个线程占有这个局部锁时，不影响其他线程对hash表其他地方的访问。 
具体实现:ConcurrentHashMap内部有一个Segment

jdk 1.8
在jdk 8中，ConcurrentHashMap不再使用Segment分离锁，而是采用一种乐观锁CAS算法来实现同步问题，但其底层还是“数组+链表->红黑树”的实现。

### HashMap 的工作原理及代码实现

HashMap 底层是 hash 数组和单向链表实现，数组中的每个元素都是链表，由 Node 内部类（实现 Map.Entry<K,V>接口）实现，HashMap 通过 put & get 方法存储和获取。存储对象时，将 K/V 键值传给 put() 方法：

①、调用 hash(K) 方法计算 K 的 hash 值，然后结合数组长度，计算得数组下标；

②、调整数组大小（当容器中的元素个数大于 capacity * loadfactor 时，容器会进行扩容resize 为 2n）；

③、i.如果 K 的 hash 值在 HashMap 中不存在，则执行插入，若存在，则发生碰撞；

ii.如果 K 的 hash 值在 HashMap 中存在，且它们两者 equals 返回 true，则更新键值对；

iii. 如果 K 的 hash 值在 HashMap 中存在，且它们两者 equals 返回 false，则插入链表的尾部（尾插法）或者红黑树中（树的添加方式）。（注意：当碰撞导致链表大于 TREEIFY_THRESHOLD = 8 时，就把链表转换成红黑树）获取对象时，将 K 传给 get() 方法：

①、调用 hash(K) 方法（计算 K 的 hash 值）从而获取该键值所在链表的数组下标；

②、顺序遍历链表，equals()方法查找相同 Node 链表中 K 值对应的 V 值。hashCode 是定位的，存储位置；equals是定性的，比较两者是否相等。

### ConcurrentHashMap 的工作原理及代码实现
## 线程
### 创建线程的方式及实现

在Java中有四种方法可以用来创建线程：

1. 继承Thread线程类。
   
   1)定义Thread类的子类，并重写该类的run()方法，该方法的方法体就是线程需要完成的任务，run()方法也称为线程执行体。
  
   2)创建Thread子类的实例，也就是创建了线程对象。

   3)启动线程，即调用线程的start()方法。

2. 实现runnable接口创建线程。

   1.定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体。

   2.创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象。

   3.依然是通过调用线程对象的start()方法来启动线程。

3. 使用callable和Future创建线程。

   1.创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例（从java8开始可以直接使用Lambda表达式创建Callable对象）。

   2.使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值。

   3.使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）。

   4.调用FutureTask对象的get()方法来获得子线程执行结束后的返回值。
   
    在此提供了一个call()方法，其功能比run要丰富。
    
    》call()方法可以有返回值

    》call()方法可以声明抛出异常

   实例代码如下：
```java
public class Main {

　　public static void main(String[] args){

　　　MyThread3 th=new MyThread3();

　　　//使用Lambda表达式创建Callable对象

　　   //使用FutureTask类来包装Callable对象

　　　FutureTask<Integer> future=new FutureTask<Integer>(

　　　　(Callable<Integer>)()->{

　　　　　　return 5;

　　　　}

　　  );

　　　new Thread(task,"有返回值的线程").start();//实质上还是以Callable对象来创建并启动线程

　　  try{

　　　　System.out.println("子线程的返回值："+future.get());//get()方法会阻塞，直到子线程执行结束才返回

 　　 }catch(Exception e){

　　　　ex.printStackTrace();

　　　}

　　}

}
```

4. 使用线程池例如用Excecutor框架。

需要再看看，没整明白。
### sleep() 、join（）、yield（）有什么区别

sleep()

sleep() 方法需要指定等待的时间，它可以让当前正在执行的线程在指定的时间内暂停执行，进入阻塞状态，该方法既可以让其他同优先级或者高优先级的线程得到执行的机会，也可以让低优先级的线程得到执行机会。但是 sleep() 方法不会释放“锁标志”，也就是说如果有 synchronized 同步块，其他线程仍然不能访问共享数据。

wait()

wait() 方法需要和 notify() 及 notifyAll() 两个方法一起介绍，这三个方法用于协调多个线程对共享数据的存取，所以必须在 synchronized 语句块内使用，也就是说，调用 wait()，notify() 和 notifyAll() 的任务在调用这些方法前必须拥有对象的锁。

注意，它们都是 Object 类的方法，而不是 Thread 类的方法。

wait() 方法与 sleep() 方法的不同之处在于，wait() 方法会释放对象的“锁标志”。当调用某一对象的 wait() 方法后，会使当前线程暂停执行，并将当前线程放入对象等待池中，直到调用了 notify() 方法后，将从对象等待池中移出任意一个线程并放入锁标志等待池中，只有锁标志等待池中的线程可以获取锁标志，它们随时准备争夺锁的拥有权。当调用了某个对象的 notifyAll() 方法，会将对象等待池中的所有线程都移动到该对象的锁标志等待池。

除了使用 notify() 和 notifyAll() 方法，还可以使用带毫秒参数的 wait(long timeout) 方法，效果是在延迟 timeout 毫秒后，被暂停的线程将被恢复到锁标志等待池。

此外，wait()，notify() 及 notifyAll() 只能在 synchronized 语句中使用，但是如果使用的是 ReenTrantLock 实现同步，该如何达到这三个方法的效果呢？解决方法是使用 ReenTrantLock.newCondition() 获取一个 Condition 类对象，然后 Condition 的 await()，signal() 以及 signalAll() 分别对应上面的三个方法。

yield()

yield() 方法和 sleep() 方法类似，也不会释放“锁标志”，区别在于，它没有参数，即 yield() 方法只是使当前线程重新回到可执行状态，所以执行 yield() 的线程有可能在进入到可执行状态后马上又被执行，另外 yield() 方法只能使同优先级或者高优先级的线程得到执行机会，这也和 sleep() 方法不同。

join()

join() 方法会使当前线程等待调用 join() 方法的线程结束后才能继续执行。

### 说说 CountDownLatch 原理

countDownLatch是在jkd1.5中被引入的，作用为是一个线程在等待其他所有线程都运行完之后才开始运行，具体的操作为countDownLatch作为一个计数器，每当一个线程运行完毕就计数-1，当计数器的值为0时，表示所有的线程运行完毕，然后在闭锁上等待的线程就可以运行了。源码如下：
```
//参数count为计数值，只提供了这一个构造器
public CountDownLatch(int count){};

其中有三个方法特别重要：
//调用await()方法的线程会被挂起，会等待直到count为0才开始运行
public void await() throws InterruptedException{};
//和await类型，只不过是在等待一段时间后，count不为0的话也会执行
public boolean await(long timeout,TimeUnit unit)throws InterruptedException{};
//将count值减少
public void countDown(){};
```
顺便说一下CountDownLatch和CyclicBarrier区别：

1.countDownLatch是一个计数器，线程完成一个记录一个，计数器递减，只能只用一次。

2.CyclicBarrier的计数器更像一个阀门，需要所有线程都到达，然后继续执行，计数器递增，提供reset功能，可以多次使用。
### 讲讲类的实例化顺序
比如父类静态数据，构造函数，字段，子类静态数据，构造函数，字 段，当new的时候，他们的执行顺序。

类加载器实例化时进行的操作步骤（加载–>连接->初始化）。 父类静态变量、 父类静态代码块、 子类静态变量、 子类静态代码块、 父类非静态变量（父类实例成员变量）、 父类构造函数、 子类非静态变量（子类实例成员变量）、 子类构造函数。

### 说说 CyclicBarrier 原理

先说作用：CyclicBarrier相当于栅栏，可以使一定数量的线程反复地在栅栏位置处汇集。当线程到达栅栏位置时将调用await方法，这个方法将阻塞直到所有线程都到达栅栏位置。如果所有线程都到达栅栏位置，那么栅栏将打开，此时所有的线程都将被释放，而栅栏将被重置以便下次使用。源码如下：
```
其内部使用了ReentrantLock和Condition两个类，有两个构造函数：
//参数表示拦截的线程数，线程使用await()方法表示已到达栅栏，然后阻塞
public CyclicBarrier(int parties){
    this(parties,null);
}
//查的说是用于线程到达屏障时，优先执行barrierAction，但是不明白。
public CyclicBarrier(int parties,Runnable barrierAction){
    if(parties <=0) throw new IllegalArgumentException;
    this.parties=parties;
    this.count=parties;
    this.barrierCommand=barrierAction;
}
```
CyclicBarrier还提供了一些其他有用的方法，比如getNumberWaiting()方法可以获得CyclicBarrier阻塞的线程数量，isBroken()方法用来了解阻塞的线程是否被中断；
CountDownLatch允许一个或多个线程等待一组事件的产生，而CyclicBarrier用于等待其他线程运行到栅栏位置。
### 说说 Semaphore 原理

Semaphore 是 synchronized 的加强版，作用是控制线程的并发数量。就这一点而言，单纯的synchronized 关键字是实现不了的。具体的等下班了再详细看一下，待补充ing

### 说说 Exchanger 原理
### 说说 CountDownLatch 与 CyclicBarrier 区别

1.countDownLatch是一个计数器，线程完成一个记录一个，计数器递减，只能只用一次。

2.CyclicBarrier的计数器更像一个阀门，需要所有线程都到达，然后继续执行，计数器递增，提供reset功能，可以多次使用。而且CyclicBarrier还提供了一些其他有用的方法，比如getNumberWaiting()方法可以获得CyclicBarrier阻塞的线程数量，isBroken()方法用来了解阻塞的线程是否被中断；CountDownLatch允许一个或多个线程等待一组事件的产生，而CyclicBarrier用于等待其他线程运行到栅栏位置。
### ThreadLocal 原理分析



### 讲讲线程池的实现原理
### 线程池的几种方式
### 线程的生命周期
### 锁机制
### 说说线程安全问题
### volatile 实现原理
### synchronize 实现原理
### synchronized 与 lock 的区别
### CAS 乐观锁

CAS，全称为Compare and Swap，即比较-替换。假设有三个操作数：内存值V、旧的预期值A、要修改的值B，当且仅当预期值A和内存值V相同时，才会将内存值修改为B并返回true，否则什么都不做并返回false。当然CAS一定要volatile变量配合，这样才能保证每次拿到的变量是主内存中最新的那个值，否则旧的预期值A对某条线程来说，永远是一个不会变的值A，只要某次CAS操作失败，永远都不可能成功

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

这里只说一些常规的优化方法：
1. select子句中尽量避免使用*。一般来说业务上是用不到查询全表的数据的，而如果一下子全部查出数据的话会占用很大的资源，会面对屏幕几分钟什么都做不了，如果使用select *来进行多表联查形成笛卡尔积，你会被开除的。
2. where子句比较符号左侧避免函数。在where条件中应尽量避免在比较符号左侧出现表达式、函数等操作，如果这样的话会引起数据库引擎的全表扫描，导致索引失效，比如讲where prem+1000>90改为prem>90-1000，来避免进行全表扫描。所以，为了提高效率，where子句中遇到函数或加减乘除的运算，应当将其移到比较符号的右侧。
3. 尽量避免使用in和not in。在使用in和not in的时候也会使数据库中的索引失效而进行全表扫描，所以在工作中需要使用到in或者not in的情况时，应尽量变换避免使用，比如如果要查询什么什么为8，9的数据，从in（8，9）可转换为between 8 and 9。
4. 尽量避免使用or。使用or的话同样会使数据库中的索引失效，在进行查询的时候同样会进行全表扫描，可以使用union将所需要查询的语句进行拼接，这样看起来可能sql语句特别长，但是效率会比使用or高很多。
5. 使用limit子句限制返回的数据行数。很基础，不说了。值得一提mysql使用limit限制，在oracle使用rownum进行限制。
6. 在用“=”或者“>”“<”等符号进行查询的时候，将两边的数据类型要保持一致，负责同样会产生索引失效的问题。

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

redis内部是以键值对的形式来存储数据的，每个key都对应一个字符串，每个value都对应一个object对象，其支持的数据结构有：
  ```
    1.字符串。
    2.列表list。
    3.set集合。
    4.sort-set有序集合。
    5.map。

    其内部结构为：
    #define REDIS_STRING 0
    #define REDIS_LIST 1
    #define REDIS_SET 2
    #define REDIS_ZSET 3
    #define REDIS_HASH 4
  ```
1. String的存储方式。
  
   1. int:如果字符串为类似于“123456”等纯数字的字符串，则redis会采用整形进行存储，以节省存储占用。
   2. sds:简单动态字符串，用于存储字节、字符串、浮点型数据。其中值得注意的是sds获取字符串的长度和剩余空间的时间复杂度为O(1),而普通的字符串都需要O(n)。
2. list的存储方式。
   
   1. 双链表(LinkedList)。相比于常规的链表结构，多了前驱和后驱指针的空间，用以记录上一个链表节点和下一个链表节点的位置，多占用了一些空间，更方便用于提高使用效率。
   2. 压缩链表（ziplist）。压缩双链表以连续的内存空间来表示双链表，压缩双链表节省前驱和后驱指针的空间（8b），每次新增数据都会realloc，这时可能会涉及到内存重新申请和拷贝的操作，所以通常用于list长度不长和元素不大的情况，同时因为ziplist不是标准的数组结构，遍历插入删除基本O(N)，大量数据的情况下对于linkedlist没有性能上的优势，如果数据小量并且紧凑， ziplist 能够放入 CPU 缓存效率也非常高，同时内存占用非常小。
3. Map的存储方式。
   
   1. hashtable。hashtable中有两个链表，主要为了能够在不中断服务的情况扩展哈希表，使用
   2. ziplist。在数据量小的情况下采用，存储的方式为奇数位为key，偶数位为value。

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

### 强引用,软引用,弱引用,虚引用.不同的引用类型主要体现在GC上:

1. 强引用：如果一个对象具有强引用，它就不会被垃圾回收器回收。即使当前内存空间不足，JVM也不会回收它，而是抛出 OutOfMemoryError 错误，使程序异常终止。如果想中断强引用和某个对象之间的关联，可以显式地将引用赋值为null，这样一来的话，JVM在合适的时间就会回收该对象

2. 软引用：在使用软引用时，如果内存的空间足够，软引用就能继续被使用，而不会被垃圾回收器回收，只有在内存不足时，软引用才会被垃圾回收器回收。
弱引用：具有弱引用的对象拥有的生命周期更短暂。因为当 JVM 进行垃圾回收，一旦发现

1. 弱引用对象，无论当前内存空间是否充足，都会将弱引用回收。不过由于垃圾回收器是一个优先级较低的线程，所以并不一定能迅速发现弱引用对象

1. 虚引用：顾名思义，就是形同虚设，如果一个对象仅持有虚引用，那么它相当于没有引用，在任何时候都可能被垃圾回收器回收。
更多了解参见深入对象引用

WeakReference与SoftReference的区别?
这点在四种引用类型中已经做了解释,这里简单说明一下即可: 
虽然 WeakReference 与 SoftReference 都有利于提高 GC 和 内存的效率，但是 WeakReference ，一旦失去最后一个强引用，就会被 GC 回收，而软引用虽然不能阻止被回收，但是可以延迟到 JVM 内存不足的时候。

为什么要有不同的引用类型
不像C语言,我们可以控制内存的申请和释放,在Java中有时候我们需要适当的控制对象被回收的时机,因此就诞生了不同的引用类型,可以说不同的引用类型实则是对GC回收时机不可控的妥协.有以下几个使用场景可以充分的说明:

利用软引用和弱引用解决OOM问题：用一个HashMap来保存图片的路径和相应图片对象关联的软引用之间的映射关系，在内存不足时，JVM会自动回收这些缓存图片对象所占用的空间，从而有效地避免了OOM的问题.
通过软引用实现Java对象的高速缓存:比如我们创建了一Person的类，如果每次需要查询一个人的信息,哪怕是几秒中之前刚刚查询过的，都要重新构建一个实例，这将引起大量Person对象的消耗,并且由于这些对象的生命周期相对较短,会引起多次GC影响性能。此时,通过软引用和 HashMap 的结合可以构建高速缓存,提供性能.

### 内部类的作用

内部类可以有多个实例,每个实例都有自己的状态信息,并且与其他外围对象的信息相互独立.在单个外围类当中,可以让多个内部类以不同的方式实现同一接口,或者继承同一个类.创建内部类对象的时刻不依赖于外部类对象的创建.内部类并没有令人疑惑的”is-a”关系,它就像是一个独立的实体.

内部类提供了更好的封装,除了该外围类,其他类都不能访问

### 什么是编译器常量?使用它有什么风险?

公共静态不可变（public static final ）变量也就是我们所说的编译期常量，这里的 public 可选的。实际上这些变量在编译时会被替换掉，因为编译器知道这些变量的值，并且知道这些变量在运行时不能改变。这种方式存在的一个问题是你使用了一个内部的或第三方库中的公有编译时常量，但是这个值后面被其他人改变了，但是你的客户端仍然在使用老的值，甚至你已经部署了一个新的jar。为了避免这种情况，当你在更新依赖 JAR 文件时，确保重新编译你的程序。

### 关于垃圾回收
你知道哪些垃圾回收算法?
垃圾回收从理论上非常容易理解,具体的方法有以下几种: 
1. 标记-清除 
2. 标记-复制 
3. 标记-整理 
4. 分代回收 
更详细的内容参见深入理解垃圾回收算法

如何判断一个对象是否应该被回收
这就是所谓的对象存活性判断,常用的方法有两种:1.引用计数法;2:对象可达性分析.由于引用计数法存在互相引用导致无法进行GC的问题,所以目前JVM虚拟机多使用对象可达性分析算法.

### 简单的解释一下垃圾回收
Java 垃圾回收机制最基本的做法是分代回收。内存中的区域被划分成不同的世代，对象根据其存活的时间被保存在对应世代的区域中。一般的实现是划分成3个世代：年轻、年老和永久。内存的分配是发生在年轻世代中的。当一个对象存活时间足够长的时候，它就会被复制到年老世代中。对于不同的世代可以使用不同的垃圾回收算法。进行世代划分的出发点是对应用中对象存活时间进行研究之后得出的统计规律。一般来说，一个应用中的大部分对象的存活时间都很短。比如局部变量的存活时间就只在方法的执行过程中。基于这一点，对于年轻世代的垃圾回收算法就可以很有针对性.

调用System.gc()会发生什么?
通知GC开始工作,但是GC真正开始的时间不确定.

### 进程,线程相关
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


### 什么是多线程的上下文切换
多线程的上下文切换是指CPU控制权由一个已经正在运行的线程切换到另外一个就绪并等待获取CPU执行权的线程的过程。

### synchronized和ReentrantLock的区别

synchronized是和if、else、for、while一样的关键字，ReentrantLock是类，这是二者的本质区别。既然ReentrantLock是类，那么它就提供了比synchronized更多更灵活的特性，可以被继承、可以有方法、可以有各种各样的类变量，ReentrantLock比synchronized的扩展性体现在几点上： 
（1）ReentrantLock可以对获取锁的等待时间进行设置，这样就避免了死锁 
（2）ReentrantLock可以获取各种锁的信息 
（3）ReentrantLock可以灵活地实现多路通知 
另外，二者的锁机制其实也是不一样的:ReentrantLock底层调用的是Unsafe的park方法加锁，synchronized操作的应该是对象头中mark word.

### FutureTask是什么

这个其实前面有提到过，FutureTask表示一个异步运算的任务。FutureTask里面可以传入一个Callable的具体实现类，可以对这个异步运算的任务的结果进行等待获取、判断是否已经完成、取消任务等操作。当然，由于FutureTask也是Runnable接口的实现类，所以FutureTask也可以放入线程池中。

一个线程如果出现了运行时异常怎么办?
如果这个异常没有被捕获的话，这个线程就停止执行了。另外重要的一点是：如果这个线程持有某个某个对象的监视器，那么这个对象监视器会被立即释放

#### CyclicBarrier和CountDownLatch区别
这两个类非常类似，都在java.util.concurrent下，都可以用来表示代码运行到某个点上，二者的区别在于：

CyclicBarrier的某个线程运行到某个点上之后，该线程即停止运行，直到所有的线程都到达了这个点，所有线程才重新运行；CountDownLatch则不是，某线程运行到某个点上之后，只是给某个数值-1而已，该线程继续运行
CyclicBarrier只能唤起一个任务，CountDownLatch可以唤起多个任务
CyclicBarrier可重用，CountDownLatch不可重用，计数值为0该CountDownLatch就不可再用了
java中的++操作符线程安全么?
不是线程安全的操作。它涉及到多个指令，如读取变量值，增加，然后存储回内存，这个过程可能会出现多个线程交差

### 关于volatile关键字

可以创建Volatile数组吗?
Java 中可以创建 volatile类型数组，不过只是一个指向数组的引用，而不是整个数组。如果改变引用指向的数组，将会受到volatile 的保护，但是如果多个线程同时改变数组的元素，volatile标示符就不能起到之前的保护作用了

volatile能使得一个非原子操作变成原子操作吗?
一个典型的例子是在类中有一个 long 类型的成员变量。如果你知道该成员变量会被多个线程访问，如计数器、价格等，你最好是将其设置为 volatile。为什么？因为 Java 中读取 long 类型变量不是原子的，需要分成两步，如果一个线程正在修改该 long 变量的值，另一个线程可能只能看到该值的一半（前 32 位）。但是对一个 volatile 型的 long 或 double 变量的读写是原子。

一种实践是用 volatile 修饰 long 和 double 变量，使其能按原子类型来读写。double 和 long 都是64位宽，因此对这两种类型的读是分为两部分的，第一次读取第一个 32 位，然后再读剩下的 32 位，这个过程不是原子的，但 Java 中 volatile 型的 long 或 double 变量的读写是原子的。volatile 修复符的另一个作用是提供内存屏障（memory barrier），例如在分布式框架中的应用。简单的说，就是当你写一个 volatile 变量之前，Java 内存模型会插入一个写屏障（write barrier），读一个 volatile 变量之前，会插入一个读屏障（read barrier）。意思就是说，在你写一个 volatile 域时，能保证任何线程都能看到你写的值，同时，在写之前，也能保证任何数值的更新对所有线程是可见的，因为内存屏障会将其他所有写的值更新到缓存。

#### volatile类型变量提供什么保证?

volatile 主要有两方面的作用:1.避免指令重排2.可见性保证.例如，JVM 或者 JIT为了获得更好的性能会对语句重排序，但是 volatile 类型变量即使在没有同步块的情况下赋值也不会与其他语句重排序。 volatile 提供 happens-before 的保证，确保一个线程的修改能对其他线程是可见的。某些情况下，volatile 还能提供原子性，如读 64 位数据类型，像 long 和 double 都不是原子的(低32位和高32位)，但 volatile 类型的 double 和 long 就是原子的.

## JDK 1.8特性
java 8 在 Java 历史上是一个开创新的版本，下面 JDK 8 中 5 个主要的特性： 
1. Lambda 表达式，允许像对象一样传递匿名函数 
1. Stream API，充分利用现代多核 CPU，可以写出很简洁的代码 
1. Date 与 Time API，最终，有一个稳定、简单的日期和时间库可供你使用 
1. 扩展方法，现在，接口中可以有静态、默认方法。 
1. 重复注解，现在你可以将相同的注解在同一类型上使用多次。
