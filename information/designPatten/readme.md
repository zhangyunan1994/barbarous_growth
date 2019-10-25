# 设计模式

## 六大原则

1. 单一职责原则(single responsibility piinciple)
应该有且仅有一个原因引起类的变更

2. 里氏替换原则
基类出现的地方，子类一定可以出现

3. 依赖倒置原则
针对接口编程，依赖抽象而不是具体

4. 接口隔离原则
使用多个隔离的接口，优于使用单个接口

5. 迪米特法则
实体应当尽量少的与其他类发生相互作用，使得系统功能模块相对独立

6. 开闭原则
对宽展开放，对修改关闭

7. 合成复用原则
尽量使用合成/聚合的方式，少用继承

## 创建型

### [单例模式](./Singleton.md)(Singletop Pattern)
概述：确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例

### 工厂模式(Factory Pattern)
定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的初始化延迟至其子类
### 建造者模式(Builder Pattern)
概述：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
### 原型模式(Prototype Pattern)
用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
## 结构型
### 适配器模式 （Adapter Pattern）
概述：将一个类的接口变换成客户端所期待的另一种接口，从而使本因接口不匹配而无法在一起工作的两个类能够在一起工作
### 桥接模式 （Bridge Pattern）
概述：将抽象和实现解耦，使得两者可以独立的变化
### 组合模式 (Composite Pattern)
概述：将对象组合成树形结构以表示 “部分-整体”的层次结构，使得用户对单个对象和组合对象的试用具有一致性
### 装饰器模式  （Decorator Pattern）
概述：动态的给一个对象添加一些额外的职责，就增加功能来说，装饰器模式相比生成子类更为灵活
### 外观模式  （Facade Pattern）
概述：要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行，外观模式提供一个高层次的接口，使得子系统更易于使用
### 享元模式 （Flyweight Pattern）
概述：使用共享对象可有效地支持大量的细粒度的对象
### 代理模式 （Proxy Paatern）
概述：为其他对象提供一种代理可以控制这个对象的访问
## 行为型
### 责任链模式 （Chain of Responsibility Pattern）
概述： 使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系，将这些对象连城一条链，并沿着这条链传递该请求，直到有对象处理它为止
### 命令模式 (Command Pattern)
概述:将请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提命令的撤销和恢复功能
### 解释器模式 (Interpreter Pattern)
概述：给定一门语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中的句子
### 迭代器模式  （Iterator Pattern）
概述：提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节
### 中介者模式 （Mediator Pattern）
概述：用一个中介对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，从而使其耦合松散，而且可以独立地改变他们之间的交互
### 备忘录模式 （Memento Pattern）
概述：在不破坏封装性的前提下，捕获一个对象内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态
### 观察者模式 （Observer Pattern）
概述：定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新
### 状态模式  (State Pattern)
概述：当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类
### 策略模式 (Strategy Pattern)
概述：定义一组算法，将每个算法封装起来，并且使它们之间可以相互转换
### 模板模式 （Template Pattern）
概述：定义一个操作中的算法框架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
### 访问者模式 (Visitor Pattern)
概述：封装一些作用于某种数据结构中的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作