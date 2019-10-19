-------------------------------------------------------------------------------------java.lang.Object

Object：所有类的直接或者间接父类，Java认为所有的对象都具备一些基本的共性内容，这些内容可以不断的向上抽取，最终就抽取到了一个最顶层的类中的，该类中定义的就是所有对象都具备的功能。

 

具体方法：

boolean equals(Object obj)：用于比较两个对象是否相等，其实内部比较的就是两个对象地址。
2，String toString()：将对象变成字符串；默认返回的格式：类名@哈希值 = getClass().getName() + '@' + Integer.toHexString(hashCode())

    为了对象对应的字符串内容有意义，可以通过复写，建立该类对象自己特有的字符串表现形式。

    public String toString(){

        return "person : "+age;

    }

3，Class getClass()：获取任意对象运行时的所属字节码文件对象。

4，int hashCode()：返回该对象的哈希码值。支持此方法是为了提高哈希表的性能。将该对象的内部地址转换成一个整数来实现的。

 

通常equals，toString，hashCode，在应用中都会被复写，建立具体对象的特有的内容。

-------------------------------------------------------------------------------------

 

内部类：如果A类需要直接访问B类中的成员，而B类又需要建立A类的对象。这时,为了方便设计和访问，直接将A类定义在B类中。就可以了。A类就称为内部类。内部类可以直接访问外部类中的成员。而外部类想要访问内部类，必须要建立内部类的对象。

-----------------------------------------------------

class Outer{

    int num = 4;    

    class Inner {

        void show(){

            System.out.println("inner show run "+num);

        }

    }

    public void method(){

        Inner in = new Inner();//创建内部类的对象。

        in.show();//调用内部类的方法。 //内部类直接访问外部类成员，用自己的实例对象；

    }                                        //外部类访问内部类要定义内部类的对象；

}

-------------------------------------------------------

当内部类定义在外部类中的成员位置上，可以使用一些成员修饰符修饰 private、static。

1：默认修饰符。

直接访问内部类格式：外部类名.内部类名 变量名 = 外部类对象.内部类对象;

Outer.Inner in = new Outer.new Inner();//这种形式很少用。

    但是这种应用不多见，因为内部类之所以定义在内部就是为了封装。想要获取内部类对象通常都通过外部类的方法来获取。这样可以对内部类对象进行控制。

2：私有修饰符。

    通常内部类被封装，都会被私有化，因为封装性不让其他程序直接访问。

3：静态修饰符。

    如果内部类被静态修饰，相当于外部类，会出现访问局限性，只能访问外部类中的静态成员。

    注意；如果内部类中定义了静态成员，那么该内部类必须是静态的。

 

内部类编译后的文件名为："外部类名$内部类名.java"；

 

为什么内部类可以直接访问外部类中的成员呢？

那是因为内部中都持有一个外部类的引用。这个是引用是 外部类名.this

内部类可以定义在外部类中的成员位置上，也可以定义在外部类中的局部位置上。

当内部类被定义在局部位置上，只能访问局部中被final修饰的局部变量。

 

匿名内部类（对象）：没有名字的内部类。就是内部类的简化形式。一般只用一次就可以用这种形式。匿名内部类其实就是一个匿名子类对象。想要定义匿名内部类：需要前提，内部类必须继承一个类或者实现接口。

 

匿名内部类的格式：new 父类名&接口名(){ 定义子类成员或者覆盖父类方法 }.方法。

 

匿名内部类的使用场景：

当函数的参数是接口类型引用时，如果接口中的方法不超过3个。可以通过匿名内部类来完成参数的传递。

其实就是在创建匿名内部类时，该类中的封装的方法不要过多，最好两个或者两个以内。

--------------------------------------------------------

//面试

        //1

        new Object(){

            void show(){

                System.out.println("show run");                

            }

        }.show();                                    //写法和编译都没问题

        //2

        Object obj = new Object(){

            void show(){

                System.out.println("show run");

            }

        };

        obj.show();                                //写法正确，编译会报错

        

        1和2的写法正确吗？有区别吗？说出原因。

        写法是正确，1和2都是在通过匿名内部类建立一个Object类的子类对象。

        区别：

        第一个可是编译通过，并运行。

        第二个编译失败，因为匿名内部类是一个子类对象，当用Object的obj引用指向时，就被提升为了Object类型，而编译时会检查Object类中是否有show方法，此时编译失败。

 

 

异 常：★★★★
--java.lang.Throwable：

Throwable：可抛出的。

    |--Error：错误，一般情况下，不编写针对性的代码进行处理，通常是jvm发生的，需要对程序进行修正。

    |--Exception：异常，可以有针对性的处理方式

 

这个体系中的所有类和对象都具备一个独有的特点；就是可抛性。

可抛性的体现：就是这个体系中的类和对象都可以被throws和throw两个关键字所操作。

 

throw与throws区别：

throws是用来声明一个方法可能抛出的所有异常信息，而throw则是指抛出的一个具体的异常类型。此外throws是将异常声明但是不处理，而是将异常往上传，谁调用我就交给谁处理。

throw用于抛出异常对象，后面跟的是异常对象；throw用在函数内。

throws用于抛出异常类，后面跟的异常类名，可以跟多个，用逗号隔开。throws用在函数上。

 

throws格式：方法名（参数）throws 异常类1，异常类2，.....

throw：就是自己进行异常处理，处理的时候有两种方式，要么自己捕获异常（也就是try catch进行捕捉），要么声明抛出一个异常（就是throws 异常~~）。

 

处理方式有两种：1、捕捉；2、抛出。

对于捕捉：java有针对性的语句块进行处理。

try {

    需要被检测的代码；

}

catch(异常类 变量名){

    异常处理代码；

}

fianlly{

    一定会执行的代码；

}

 

定义异常处理时，什么时候定义try，什么时候定义throws呢？

功能内部如果出现异常，如果内部可以处理，就用try；

如果功能内部处理不了，就必须声明出来，让调用者处理。使用throws抛出，交给调用者处理。谁调用了这个功能谁就是调用者；

 

自定义异常的步骤：

1：定义一个子类继承Exception或RuntimeException，让该类具备可抛性(既可以使用throw和throws去调用此类)。

2：通过throw 或者throws进行操作。

 

异常的转换思想：当出现的异常是调用者处理不了的，就需要将此异常转换为一个调用者可以处理的异常抛出。

 

try catch finally的几种结合方式：

1，

try

catch

finally

 

这种情况，如果出现异常，并不处理，但是资源一定关闭，所以try finally集合只为关闭资源。

记住：finally很有用，主要用户关闭资源。无论是否发生异常，资源都必须进行关闭。

System.exit(0); //退出jvm，只有这种情况finally不执行。

 

注意：

如果父类或者接口中的方法没有抛出过异常，那么子类是不可以抛出异常的，如果子类的覆盖的方法中出现了异常，只能try不能throws。

如果这个异常子类无法处理，已经影响了子类方法的具体运算，这时可以在子类方法中，通过throw抛出RuntimeException异常或者其子类，这样，子类的方法上是不需要throws声明的。

 

 

多线程：★★★★
返回当前线程的名称：Thread.currentThread().getName()

线程的名称是由：Thread-编号定义的。编号从0开始。

线程要运行的代码都统一存放在了run方法中。

 

线程要运行必须要通过类中指定的方法开启。start方法。（启动后，就多了一条执行路径）

start方法：1）、启动了线程；2）、让jvm调用了run方法。

 

Thread类中run()和start()方法的区别：

start()：用start方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执行下面的代码。通过调用Thread类的start()方法来启动一个线程，这时此线程处于就绪（可运行）状态，并没有运行，一旦得到cpu时间片，就开始执行run()方法，这里方法run()称为线程体，它包含了要执行的这个线程的内容，Run方法运行结束，此线程随即终止。

run()：run()方法只是类的一个普通方法而已，如果直接调用Run方法，程序中依然只有主线程这一个线程，其程序执行路径还是只有一条，还是要顺序执行，还是要等待run方法体执行完毕后才可继续执行下面的代码，这样就没有达到写线程的目的。

总结：start()方法最本质的功能是从CPU中申请另一个线程空间来执行 run()方法中的代码,它和当前的线程是两条线,在相对独立的线程空间运行,也就是说,如果你直接调用线程对象的run()方法,当然也会执行,但那是 在当前线程中执行,run()方法执行完成后继续执行下面的代码.而调用start()方法后,run()方法的代码会和当前线程并发(单CPU)或并行 (多CPU)执行。所以请记住一句话：调用线程对象的run方法不会产生一个新的线程，虽然可以达到相同的执行结果,但执行过程和执行效率不同

 

创建线程的第一种方式：继承Thread ，由子类复写run方法。

步骤：

1，定义类继承Thread类；

2，目的是复写run方法，将要让线程运行的代码都存储到run方法中；

3，通过创建Thread类的子类对象，创建线程对象；

4，调用线程的start方法，开启线程，并执行run方法。

 

线程状态：

被创建：start()

运行：具备执行资格，同时具备执行权；

冻结：sleep(time),wait()—notify()唤醒；线程释放了执行权，同时释放执行资格；

临时阻塞状态：线程具备cpu的执行资格，没有cpu的执行权；

消亡：stop()



创建线程的第二种方式：实现一个接口Runnable。

步骤：

1，定义类实现Runnable接口。

2，覆盖接口中的run方法（用于封装线程要运行的代码）。

3，通过Thread类创建线程对象；

4，将实现了Runnable接口的子类对象作为实际参数传递给Thread类中的构造函数。

为什么要传递呢？因为要让线程对象明确要运行的run方法所属的对象。

5，调用Thread对象的start方法。开启线程，并运行Runnable接口子类中的run方法。

Ticket t = new Ticket();

        /*

        直接创建Ticket对象，并不是创建线程对象。

        因为创建对象只能通过new Thread类，或者new Thread类的子类才可以。

        所以最终想要创建线程。既然没有了Thread类的子类，就只能用Thread类。

        */

        Thread t1 = new Thread(t); //创建线程。

        /*

        只要将t作为Thread类的构造函数的实际参数传入即可完成线程对象和t之间的关联

        为什么要将t传给Thread类的构造函数呢？其实就是为了明确线程要运行的代码run方法。

        */

        t1.start();

        

为什么要有Runnable接口的出现？

1：通过继承Thread类的方式，可以完成多线程的建立。但是这种方式有一个局限性，如果一个类已经有了自己的父类，就不可以继承Thread类，因为java单继承的局限性。

可是该类中的还有部分代码需要被多个线程同时执行。这时怎么办呢？

只有对该类进行额外的功能扩展，java就提供了一个接口Runnable。这个接口中定义了run方法，其实run方法的定义就是为了存储多线程要运行的代码。

所以，通常创建线程都用第二种方式。

因为实现Runnable接口可以避免单继承的局限性。

 

2：其实是将不同类中需要被多线程执行的代码进行抽取。将多线程要运行的代码的位置单独定义到接口中。为其他类进行功能扩展提供了前提。

所以Thread类在描述线程时，内部定义的run方法，也来自于Runnable接口。

 

实现Runnable接口可以避免单继承的局限性。而且，继承Thread，是可以对Thread类中的方法，进行子类复写的。但是不需要做这个复写动作的话，只为定义线程代码存放位置，实现Runnable接口更方便一些。所以Runnable接口将线程要执行的任务封装成了对象。

-------------------------------------------------------

//面试

        new Thread(new Runnable(){ //匿名

            public void run(){

                System.out.println("runnable run");    

            }

        })

 

        {

            public void run(){

                System.out.println("subthread run");

            }

        }.start(); //结果：subthread run

---------------------------------------------------------

synchronized关键字（一）

一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。

二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。

三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。

四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。

五、以上规则对其它对象锁同样适用.

 

package ths;

public class Thread1 implements Runnable {

public void run() {

synchronized(this) {

for (int i = 0; i < 5; i++) {

System.out.println(Thread.currentThread().getName()+"synchronized loop " + i);

}

}

}

}

 

synchronized关键字（二）

synchronized 关键字，它包括两种用法：synchronized 方法和 synchronized 块。

1. synchronized 方法：通过在方法声明中加入 synchronized关键字来声明 synchronized 方法。如：

public synchronized void accessVal(int newVal);

synchronized 方法控制对类成员变量的访问：每个类实例对应一把锁，每个 synchronized 方法都必须获得调用该方法的类实例的锁方能执行，否则所属线程阻塞，方法一旦执行，就独占该锁，直到从该方法返回时才将锁释放，此后被阻塞的线程方能获得该锁，重新进入可执行状态。这种机制确保了同一时刻对于每一个类实例，其所有声明为 synchronized 的成员函数中至多只有一个处于可执行状态（因为至多只有一个能够获得该类实例对应的锁），从而有效避免了类成员变量的访问冲突（只要所有可能访问类成员变量的方法均被声明为 synchronized）。

在 Java 中，不光是类实例，每一个类也对应一把锁，这样我们也可将类的静态成员函数声明为 synchronized ，以控制其对类的静态成员变量的访问。

synchronized 方法的缺陷：若将一个大的方法声明为synchronized 将会大大影响效率，典型地，若将线程类的方法 run() 声明为synchronized ，由于在线程的整个生命期内它一直在运行，因此将导致它对本类任何 synchronized 方法的调用都永远不会成功。当然我们可以通过将访问类成员变量的代码放到专门的方法中，将其声明为 synchronized ，并在主方法中调用来解决这一问题，但是 Java 为我们提供了更好的解决办法，那就是 synchronized 块。

2. synchronized 块：通过 synchronized关键字来声明synchronized 块。语法如下：

synchronized(syncObject) {

//允许访问控制的代码

}

synchronized 块是这样一个代码块，其中的代码必须获得对象 syncObject （如前所述，可以是类实例或类）的锁方能执行，具体机制同前所述。由于可以针对任意代码块，且可任意指定上锁的对象，故灵活性较高。

对synchronized(this)的一些理解

一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。

二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。

三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。

四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。

五、以上规则对其它对象锁同样适用。

 

解决安全问题的原理：

只要将操作共享数据的语句在某一时段让一个线程执行完，在执行过程中，其他线程不能进来执行就可以解决这个问题。

如何保障共享数据的线程安全呢？

java中提供了一个解决方式：就是同步代码块。

格式：

synchronized(对象) { //任意对象都可以。这个对象就是共享数据。

    需要被同步的代码；

}

---------------------------------------------------------------

同步：★★★★★

好处：解决了线程安全问题。Synchronized

弊端：相对降低性能，因为判断锁需要消耗资源，产生了死锁。

 

 

同步的第二种表现形式：        //对共享资源的方法定义同步

同步函数：其实就是将同步关键字定义在函数上，让函数具备了同步性。

 

同步函数是用的哪个锁呢？        //synchronized(this)用以定义需要进行同步的某一部分代码块

通过验证，函数都有自己所属的对象this，所以同步函数所使用的锁就是this锁。This.方法名

 

当同步函数被static修饰时，这时的同步用的是哪个锁呢？

静态函数在加载时所属于类，这时有可能还没有该类产生的对象，但是该类的字节码文件加载进内存就已经被封装成了对象，这个对象就是该类的字节码文件对象。

所以静态加载时，只有一个对象存在，那么静态同步函数就使用的这个对象。

这个对象就是 类名.class

 

同步代码块和同步函数的区别？

同步代码块使用的锁可以是任意对象。

同步函数使用的锁是this，静态同步函数的锁是该类的字节码文件对象。

 

在一个类中只有一个同步的话，可以使用同步函数。如果有多同步，必须使用同步代码块，来确定不同的锁。所以同步代码块相对灵活一些。

-------------------------------------------------------

★考点问题：请写一个延迟加载的单例模式？写懒汉式；当出现多线程访问时怎么解决？加同步，解决安全问题；效率高吗？不高；怎样解决？通过双重判断的形式解决。

//懒汉式：延迟加载方式。

当多线程访问懒汉式时，因为懒汉式的方法内对共性数据进行多条语句的操作。所以容易出现线程安全问题。为了解决，加入同步机制，解决安全问题。但是却带来了效率降低。

为了效率问题，通过双重判断的形式解决。

class Single{

    private static Single s = null;

    private Single(){}

    public static Single getInstance(){ //锁是谁？字节码文件对象；

        if(s == null){

            synchronized(Single.class){

                if(s == null)

                    s = new Single();

            }

        }

        return s;

    }

}

---------------------------------------------------------

等待唤醒机制：涉及的方法：

wait:将同步中的线程处于冻结状态。释放了执行权，释放了资格。同时将线程对象存储到线程池中。

notify：唤醒线程池中某一个等待线程。

notifyAll:唤醒的是线程池中的所有线程。

 

注意：

1：这些方法都需要定义在同步中。

2：因为这些方法必须要标示所属的锁。

    你要知道 A锁上的线程被wait了,那这个线程就相当于处于A锁的线程池中，只能A锁的notify唤醒。

3：这三个方法都定义在Object类中。为什么操作线程的方法定义在Object类中？

    因为这三个方法都需要定义同步内，并标示所属的同步锁，既然被锁调用，而锁又可以是任意对象，那么能被任意对象调用的方法一定定义在Object类中。

 

wait和sleep区别： 分析这两个方法：从执行权和锁上来分析：

wait：可以指定时间也可以不指定时间。不指定时间，只能由对应的notify或者notifyAll来唤醒。

sleep：必须指定时间，时间到自动从冻结状态转成运行状态(临时阻塞状态)。

wait：线程会释放执行权，而且线程会释放锁。

sleep：线程会释放执行权，但不是不释放锁。

 

线程的停止：通过stop方法就可以停止线程。但是这个方式过时了。

停止线程：原理就是：让线程运行的代码结束，也就是结束run方法。

怎么结束run方法？一般run方法里肯定定义循环。所以只要结束循环即可。

第一种方式：定义循环的结束标记。

第二种方式：如果线程处于了冻结状态，是不可能读到标记的，这时就需要通过Thread类中的interrupt方法，将其冻结状态强制清除。让线程恢复具备执行资格的状态，让线程可以读到标记，并结束。

 

---------< java.lang.Thread >----------

interrupt()：中断线程。

setPriority(int newPriority)：更改线程的优先级。

getPriority()：返回线程的优先级。

toString()：返回该线程的字符串表示形式，包括线程名称、优先级和线程组。

Thread.yield()：暂停当前正在执行的线程对象，并执行其他线程。

setDaemon(true)：将该线程标记为守护线程或用户线程。将该线程标记为守护线程或用户线程。当正在运行的线程都是守护线程时，Java 虚拟机退出。该方法必须在启动线程前调用。

join：临时加入一个线程的时候可以使用join方法。

当A线程执行到了B线程的join方式。A线程处于冻结状态，释放了执行权，B开始执行。A什么时候执行呢？只有当B线程运行结束后，A才从冻结状态恢复运行状态执行。

 

 

LOCK的出现替代了同步：lock.lock();………lock.unlock();

Lock接口：多线程在JDK1.5版本升级时，推出一个接口Lock接口。

解决线程安全问题使用同步的形式，(同步代码块，要么同步函数)其实最终使用的都是锁机制。

 

到了后期版本，直接将锁封装成了对象。线程进入同步就是具备了锁，执行完，离开同步，就是释放了锁。

在后期对锁的分析过程中，发现，获取锁，或者释放锁的动作应该是锁这个事物更清楚。所以将这些动作定义在了锁当中，并把锁定义成对象。

 

所以同步是隐示的锁操作，而Lock对象是显示的锁操作，它的出现就替代了同步。

 

在之前的版本中使用Object类中wait、notify、notifyAll的方式来完成的。那是因为同步中的锁是任意对象，所以操作锁的等待唤醒的方法都定义在Object类中。

 

而现在锁是指定对象Lock。所以查找等待唤醒机制方式需要通过Lock接口来完成。而Lock接口中并没有直接操作等待唤醒的方法，而是将这些方式又单独封装到了一个对象中。这个对象就是Condition，将Object中的三个方法进行单独的封装。并提供了功能一致的方法 await()、signal()、signalAll()体现新版本对象的好处。

< java.util.concurrent.locks > Condition接口：await()、signal()、signalAll()；

--------------------------------------------------------

class BoundedBuffer {

final Lock lock = new ReentrantLock();

final Condition notFull = lock.newCondition();

final Condition notEmpty = lock.newCondition();

final Object[] items = new Object[100];

int putptr, takeptr, count;

public void put(Object x) throws InterruptedException {

lock.lock();

try {

while (count == items.length)

notFull.await();

items[putptr] = x;

if (++putptr == items.length) putptr = 0;

++count;

notEmpty.signal();

}

    finally {

lock.unlock();

}

}

public Object take() throws InterruptedException {

lock.lock();

try {

while (count == 0)

notEmpty.await();

Object x = items[takeptr];

if (++takeptr == items.length) takeptr = 0;

--count;

notFull.signal();

return x;

}

finally {

lock.unlock();

}

}

}

 

集合框架
集合框架：★★★★★，用于存储数据的容器。

 

对于集合容器，有很多种。因为每一个容器的自身特点不同，其实原理在于每个容器的内部数据结构不同。

集合容器在不断向上抽取过程中。出现了集合体系。

在使用一个体系时，原则：参阅顶层内容。建立底层对象。



------------------------------------------------------------

--< java.util >-- List接口：

List本身是Collection接口的子接口，具备了Collection的所有方法。现在学习List体系特有的共性方法，查阅方法发现List的特有方法都有索引，这是该集合最大的特点。

 

List：有序(元素存入集合的顺序和取出的顺序一致)，元素都有索引。元素可以重复。

    |--ArrayList：底层的数据结构是数组,线程不同步，ArrayList替代了Vector，查询元素的速度非常快。

    |--LinkedList：底层的数据结构是链表，线程不同步，增删元素的速度非常快。

    |--Vector：底层的数据结构就是数组，线程同步的，Vector无论查询和增删都巨慢。

 

 

可变长度数组的原理：

当元素超出数组长度，会产生一个新数组，将原数组的数据复制到新数组中，再将新的元素添加到新数组中。

ArrayList：是按照原数组的50%延长。构造一个初始容量为 10 的空列表。

Vector：是按照原数组的100%延长。

------------------------------------------------------------

--< java.util >-- Set接口：

数据结构：数据的存储方式；

Set接口中的方法和Collection中方法一致的。Set接口取出方式只有一种，迭代器。

    |--HashSet：底层数据结构是哈希表，线程是不同步的。无序，高效；

        HashSet集合保证元素唯一性：通过元素的hashCode方法，和equals方法完成的。

        当元素的hashCode值相同时，才继续判断元素的equals是否为true。

        如果为true，那么视为相同元素，不存。如果为false，那么存储。

        如果hashCode值不同，那么不判断equals，从而提高对象比较的速度。

|--LinkedHashSet：有序，hashset的子类。

    |--TreeSet：对Set集合中的元素的进行指定顺序的排序。不同步。TreeSet底层的数据结构就是二叉树。

 

对于ArrayList集合，判断元素是否存在，或者删元素底层依据都是equals方法。

对于HashSet集合，判断元素是否存在，或者删除元素，底层依据的是hashCode方法和equals方法。

 

------------------------------------------------------------

Map集合：

|--Hashtable：底层是哈希表数据结构，是线程同步的。不可以存储null键，null值。

|--HashMap：底层是哈希表数据结构，是线程不同步的。可以存储null键，null值。替代了Hashtable.

|--TreeMap：底层是二叉树结构，可以对map集合中的键进行指定顺序的排序。

 

Map集合存储和Collection有着很大不同：

Collection一次存一个元素；Map一次存一对元素。

Collection是单列集合；Map是双列集合。

Map中的存储的一对元素：一个是键，一个是值，键与值之间有对应(映射)关系。

特点：要保证map集合中键的唯一性。

 

5，想要获取map中的所有元素：

    原理：map中是没有迭代器的，collection具备迭代器，只要将map集合转成Set集合，可以使用迭代器了。之所以转成set，是因为map集合具备着键的唯一性，其实set集合就来自于map，set集合底层其实用的就是map的方法。

把map集合转成set的方法：
    Set keySet();

    Set entrySet();//取的是键和值的映射关系。

Entry就是Map接口中的内部接口；

为什么要定义在map内部呢？entry是访问键值关系的入口，是map的入口，访问的是map中的键值对。

---------------------------------------------------------

取出map集合中所有元素的方式一：keySet()方法。

可以将map集合中的键都取出存放到set集合中。对set集合进行迭代。迭代完成，再通过get方法对获取到的键进行值的获取。

        Set keySet = map.keySet();

        Iterator it = keySet.iterator();

        while(it.hasNext()) {

            Object key = it.next();

            Object value = map.get(key);

            System.out.println(key+":"+value);

        }

--------------------------------------------------------

取出map集合中所有元素的方式二：entrySet()方法。

Set entrySet = map.entrySet();

        Iterator it = entrySet.iterator();

        while(it.hasNext()) {

            Map.Entry me = (Map.Entry)it.next();

            System.out.println(me.getKey()+"::::"+me.getValue());

        }

--------------------------------------------------------

 

将非同步集合转成同步集合的方法：Collections中的 XXX synchronizedXXX(XXX);

List synchronizedList(list);

Map synchronizedMap(map);

public static <K,V> Map<K,V> synchronizedMap(Map<K,V> m) {

return new SynchronizedMap<K,V>(m);

}

原理：定义一个类，将集合所有的方法加同一把锁后返回。

List list = Collections.synchronizedList(new ArrayList());

Map<String,String> synmap = Collections.synchronizedMap(map);

 

Collection 和 Collections的区别：

Collections是个java.util下的类，是针对集合类的一个工具类,提供一系列静态方法,实现对集合的查找、排序、替换、线程安全化（将非同步的集合转换成同步的）等操作。

Collection是个java.util下的接口，它是各种集合结构的父接口，继承于它的接口主要有Set和List,提供了关于集合的一些操作,如插入、删除、判断一个元素是否其成员、遍历等。

-------------------------------------------------------

自动拆装箱：java中数据类型分为两种 ： 基本数据类型 引用数据类型(对象)

在 java程序中所有的数据都需要当做对象来处理，针对8种基本数据类型提供了包装类，如下：

int --> Integer

byte --> Byte

short --> Short

long --> Long

char --> Character

double --> Double

float --> Float

boolean --> Boolean

 

jdk5以前基本数据类型和包装类之间需要互转：

基本---引用 Integer x = new Integer(x);

引用---基本 int num = x.intValue();

1)、Integer x = 1; x = x + 1; 经历了什么过程？装箱 à 拆箱 à 装箱；

2)、为了优化，虚拟机为包装类提供了缓冲池，Integer池的大小 -128~127 一个字节的大小；

3)、String池：Java为了优化字符串操作 提供了一个缓冲池；

----------------------------------------------------------

泛型：jdk1.5版本以后出现的一个安全机制。表现格式：< >

好处：

1：将运行时期的问题ClassCastException问题转换成了编译失败，体现在编译时期，程序员就可以解决问题。

2：避免了强制转换的麻烦。

 

泛型中的通配符：可以解决当具体类型不确定的时候，这个通配符就是 ? ；当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。

-------------------------------------------------------------------------------------------------------------------------------

 

反射技术
反射技术：其实就是动态加载一个指定的类，并获取该类中的所有的内容。并将字节码文件中的内容都封装成对象，这样便于操作这些成员。简单说：反射技术可以对一个类进行解剖。

 

反射的好处：大大的增强了程序的扩展性。

 

反射的基本步骤：

1、获得Class对象，就是获取到指定的名称的字节码文件对象。

2、实例化对象，获得类的属性、方法或构造函数。

3、访问属性、调用方法、调用构造函数创建对象。

 

获取这个Class对象，有三种方式：

1：通过每个对象都具备的方法getClass来获取。弊端：必须要创建该类对象，才可以调用getClass方法。

2：每一个数据类型(基本数据类型和引用数据类型)都有一个静态的属性class。弊端：必须要先明确该类。

     前两种方式不利于程序的扩展，因为都需要在程序使用具体的类来完成。

3：使用的Class类中的方法，静态的forName方法。

     指定什么类名，就获取什么类字节码文件对象，这种方式的扩展性最强，只要将类名的字符串传入即可。

// 1. 根据给定的类名来获得 用于类加载

String classname = "cn.itcast.reflect.Person";// 来自配置文件

Class clazz = Class.forName(classname);// 此对象代表Person.class

// 2. 如果拿到了对象，不知道是什么类型 用于获得对象的类型

Object obj = new Person();

Class clazz1 = obj.getClass();// 获得对象具体的类型

// 3. 如果是明确地获得某个类的Class对象 主要用于传参

Class clazz2 = Person.class;    

 

反射的用法：

1）、需要获得java类的各个组成部分，首先需要获得类的Class对象，获得Class对象的三种方式：

    Class.forName(classname)    用于做类加载

    obj.getClass()                用于获得对象的类型

    类名.class             用于获得指定的类型，传参用

 

2)、反射类的成员方法：

    Class clazz = Person.class;

    Method method = clazz.getMethod(methodName, new Class[]{paramClazz1, paramClazz2});

    method.invoke();

    

3)、反射类的构造函数：

    Constructor con = clazz.getConstructor(new Class[]{paramClazz1, paramClazz2,...})

    con.newInstance(params...)

 

4)、反射类的属性：

    Field field = clazz.getField(fieldName);

    field.setAccessible(true);

    field.setObject(value);

 

获取了字节码文件对象后，最终都需要创建指定类的对象：

创建对象的两种方式(其实就是对象在进行实例化时的初始化方式)：

1，调用空参数的构造函数：使用了Class类中的newInstance()方法。

2，调用带参数的构造函数：先要获取指定参数列表的构造函数对象，然后通过该构造函数的对象的newInstance(实际参数) 进行对象的初始化。

 

综上所述，第二种方式，必须要先明确具体的构造函数的参数类型，不便于扩展。所以一般情况下，被反射的类，内部通常都会提供一个公有的空参数的构造函数。

------------------------------------------------------

    // 如何生成获取到字节码文件对象的实例对象。

        Class clazz = Class.forName("cn.itcast.bean.Person");//类加载

// 直接获得指定的类型

        clazz = Person.class;

        // 根据对象获得类型

        Object obj = new Person("zhangsan", 19);

        clazz = obj.getClass();

 

        Object obj = clazz.newInstance();//该实例化对象的方法调用就是指定类中的空参数构造函数，给创建对象进行初始化。当指定类中没有空参数构造函数时，该如何创建该类对象呢？请看method_2();

    public static void method_2() throws Exception {

        Class clazz = Class.forName("cn.itcast.bean.Person");

        //既然类中没有空参数的构造函数,那么只有获取指定参数的构造函数,用该函数来进行实例化。

        //获取一个带参数的构造器。

        Constructor constructor = clazz.getConstructor(String.class,int.class);

        //想要对对象进行初始化，使用构造器的方法newInstance();

        Object obj = constructor.newInstance("zhagnsan",30);

        //获取所有构造器。

        Constructor[] constructors = clazz.getConstructors();//只包含公共的

        constructors = clazz.getDeclaredConstructors();//包含私有的

        for(Constructor con : constructors) {

            System.out.println(con);

        }

    }

------------------------------------------------------

反射指定类中的方法：

    //获取类中所有的方法。

    public static void method_1() throws Exception {

        Class clazz = Class.forName("cn.itcast.bean.Person");

        Method[] methods = clazz.getMethods();//获取的是该类中的公有方法和父类中的公有方法。

        methods = clazz.getDeclaredMethods();//获取本类中的方法，包含私有方法。

        for(Method method : methods) {

            System.out.println(method);

        }

    }

    //获取指定方法；

    public static void method_2() throws Exception {

        Class clazz = Class.forName("cn.itcast.bean.Person");

        //获取指定名称的方法。

        Method method = clazz.getMethod("show", int.class,String.class);

        //想要运行指定方法，当然是方法对象最清楚，为了让方法运行，调用方法对象的invoke方法即可，但是方法运行必须要明确所属的对象和具体的实际参数。

        Object obj = clazz.newInstance();

        method.invoke(obj, 39,"hehehe");//执行一个方法

    }

    //想要运行私有方法。

    public static void method_3() throws Exception {

        Class clazz = Class.forName("cn.itcast.bean.Person");

        //想要获取私有方法。必须用getDeclearMethod();

        Method method = clazz.getDeclaredMethod("method", null);

        // 私有方法不能直接访问，因为权限不够。非要访问，可以通过暴力的方式。

        method.setAccessible(true);//一般很少用，因为私有就是隐藏起来，所以尽量不要访问。

    }

    //反射静态方法。

    public static void method_4() throws Exception {

        Class clazz = Class.forName("cn.itcast.bean.Person");

        Method method = clazz.getMethod("function",null);

        method.invoke(null,null);

    }

