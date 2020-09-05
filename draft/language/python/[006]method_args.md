<h1> 第6 章 函数的参数 </h1>

**Table of Contents**
<!-- TOC -->

- [位置参数](#位置参数)
- [默认参数](#默认参数)
- [可变参数](#可变参数)
- [关键字参数](#关键字参数)
- [命名关键字参数](#命名关键字参数)
- [参数组合](#参数组合)

<!-- /TOC -->

> 每天步履匆匆，迎接新的战场，面对未知，我还会害怕，但不会退缩。


上一篇讲了函数的定义和使用，在定义函数的时候，我们把参数的名字和位置都确定了下来，函数的定义就完成了，这时我们需要传递正确的参数（正确的类型和个数），然后函数返回指定的结果，函数内部的复杂逻辑被封装起来，调用者无需了解。

但是当我们尝试错误参数类型和参数个数的时候就会发生错误：

```python
>>> len(d,12)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: len() takes exactly one argument (2 given)
>>> 

>>> len(2345.5)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: object of type 'float' has no len()
```

为了防止这种事情的发生，下面来介绍一下如何使用更加强大，灵活的参数，来扩展我们的函数。

Python的函数定义非常简单，但灵活度却非常大。除了正常定义的必选参数外，还可以使用默认参数、可变参数和关键字参数，使得函数定义出来的接口，不但能处理复杂的参数，还可以简化调用者的代码。

# 位置参数

我们先写一个计算平方的函数(我学c语言第一个函数哦)：

```python
def power(x):
    return x * x
```
对于`power(x)`函数，参数x就是一个位置参数。

当我们调用power函数时，必须传入有且仅有的一个参数x：

```python
>>> power(5)
25
>>> power(15)
225
```

现在，如果我们要计算x3怎么办？可以再定义一个`power3`函数，但是如果要计算x4、x5……怎么办？我们不可能定义无限多个函数。

你也许想到了，可以把power(x)修改为power(x, n)，用来计算xn，说干就干：
```python
def power(x, n):
    result = 1
    for i in range(n):
        result = result * x
    return result
```
对于这个修改后的power(x, n)函数，可以计算任意n次方：
```python
>>> power(5, 2)
25
>>> power(5, 3)
125
```

修改后的power(x, n)函数有两个参数：x和n，这两个参数都是位置参数，调用函数时，传入的两个值按照位置顺序依次赋给参数x和n。

# 默认参数

新的power(x, n)函数定义没有问题，但是，旧的调用代码失败了，原因是我们增加了一个参数，导致旧的代码因为缺少一个参数而无法正常调用：

```python
>>> power(5)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: power() missing 1 required positional argument: 'n'
```
Python的错误信息很明确：调用函数power()缺少了一个位置参数n。

如果你学过`java`语言，可能会想到重载来兼容旧的方法，这对于`java`是个不错的想法，但是`python`可没有重载这个概念，那我们怎么办呢？试试默认参数吧！

由于我们经常计算x2，所以，完全可以把第二个参数n的默认值设定为2：
```python
def power(x, n=2):
    result = 1
    for i in range(n):
        result = result * x
    return result
```

这样，当我们调用power(5)时，相当于调用power(5, 2)：
```python
>>> power(5)
25
>>> power(5, 2)
25
```
而对于n > 2的其他情况，就必须明确地传入n，比如power(5, 3)。

从上面的例子可以看出，默认参数可以简化函数的调用。设置默认参数时，有几点要注意：

1. 必选参数在前，默认参数在后，否则Python的解释器会报错（思考一下为什么默认参数不能放在必选参数前面）；

2. 如何设置默认参数。

当函数有多个参数时，把变化大的参数放前面，变化小的参数放后面。变化小的参数就可以作为默认参数。

使用默认参数有什么好处？最大的好处是能降低调用函数的难度，提高代码的简洁行。

举个例子，常见的用户注册函数，一般注册页面既可以只填写 邮箱，密码 即可注册，也可以填写完详细信息再注册

```python
def create_account(email, password, nickname='新手', sex=None, age=18)
    pass
```

当用户只输入 email 和 password 也可以调用该函数，

如果要输入详细信息，就可以按顺序输入全部信息即可。当然也可以只传入部分默认参数例如：
```python
create_account('zyndev@gmail.com', '1234567890', '小白')

# 好吧 我承认我是新手，但我想告诉大家，我是男的呀！这时只需要
create_account('zyndev@gmail.com', '1234567890', sex='male')
```
在python中注释是 `#` 开头的

可见，默认参数降低了函数调用的难度，而一旦需要更复杂的调用时，又可以传递更多的参数来实现。无论是简单调用还是复杂调用，函数只需要定义一个。

为什么要写成 `sex='male'` 而不是 'male' 呢？

```python
def create_account(email, password, nickname='新手', sex=None, age=18)

create_account('zyndev@gmail.com', '1234567890', '小白')
create_account('zyndev@gmail.com', '1234567890', sex='male')
```

当有多个默认参数时，调用的时候，既可以按顺序提供默认参数，按照顺序`'小白'`这个值将应用在 `nickname` 上, 因为我承认我是新手了，但我想告诉大家，我是男的，所以我只需要告诉这个函数，注册用户时，我是一个男的，次数没有按照参数顺序，需要把参数名写上，意思是，sex参数用传进去的`male`值，其他默认参数继续使用默认值。

默认参数很有用，但使用不当，也会掉坑里。默认参数有个最大的坑，演示如下：

先定义一个函数，传入一个list，添加一个END再返回：
```python
def add_end(L=[]):
    L.append('END')
    return L
```
当你正常调用时，结果似乎不错：
```python
>>> add_end([1, 2, 3])
[1, 2, 3, 'END']
>>> add_end(['x', 'y', 'z'])
['x', 'y', 'z', 'END']
```
当你使用默认参数调用时，一开始结果也是对的：
```python
>>> add_end()
['END']
```
但是，再次调用add_end()时，结果就不对了：
```python
>>> add_end()
['END', 'END']
>>> add_end()
['END', 'END', 'END']
```
很多初学者很疑惑，默认参数是[]，但是函数似乎每次都“记住了”上次添加了'END'后的list。

原因解释如下：

Python函数在定义的时候，默认参数L的值就被计算出来了，即[]，因为默认参数L也是一个变量，它指向对象[]，每次调用该函数，如果改变了L的内容，则下次调用时，默认参数的内容就变了，不再是函数定义时的[]了。

所以，定义默认参数要牢记一点：默认参数必须指向不变对象！

要修改上面的例子，我们可以用None这个不变对象来实现：
```python
def add_end(L=None):
    if L is None:
        L = []
    L.append('END')
    return L
```
现在，无论调用多少次，都不会有问题：
```python
>>> add_end()
['END']
>>> add_end()
['END']
```
为什么要设计str、None这样的不变对象呢？因为不变对象一旦创建，对象内部的数据就不能修改，这样就减少了由于修改数据导致的错误。此外，由于对象不变，多任务环境下同时读取对象不需要加锁，同时读一点问题都没有。我们在编写程序时，如果可以设计一个不变对象，那就尽量设计成不变对象。

# 可变参数

在Python函数中，还可以定义可变参数。顾名思义，可变参数就是传入的参数个数是可变的，可以是1个、2个到任意个，还可以是0个。

在前面我们使用了：

> 而max函数max()可以接收任意多个参数，并返回最大的那个：
```python
>>> max(1, 2)
2
>>> max(2, 3, 1, -5)
3
```

大家还记得吗？这里的`max`函数可以传入不定长的参数。

我们以求不定参数的和为例讲解`可变参数`的使用

要定义出这个函数，我们必须确定输入的参数。由于参数个数不确定，我们首先想到可以把a，b，c……作为一个list或tuple传进来，这样，函数可以定义如下：
```python
def calc(numbers):
    sum = 0
    for n in numbers:
        sum = sum + n
    return sum
```
但是调用的时候，需要先组装出一个list或tuple：
```python
>>> calc([1, 2, 3])
6
>>> calc((1, 3, 5, 7))
16
```
如果利用可变参数，调用函数的方式可以简化成这样：
```python
>>> calc(1, 2, 3)
6
>>> calc(1, 3, 5, 7)
16
```
所以，我们把函数的参数改为可变参数：
```python
def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n
    return sum
```

定义可变参数和定义一个list或tuple参数相比，仅仅在参数前面加了一个*号。在函数内部，参数numbers接收到的是一个tuple，因此，函数代码完全不变。但是，调用该函数时，可以传入任意个参数，包括0个参数：

```python
>>> calc(1, 2)
3
>>> calc()
0
```

如果已经有一个list或者tuple，要调用一个可变参数怎么办？可以这样做：
```python
>>> nums = [1, 2, 3]
>>> calc(nums[0], nums[1], nums[2])
6
```

这种写法当然是可行的，问题是太繁琐，所以Python允许你在list或tuple前面加一个*号，把list或tuple的元素变成可变参数传进去：

```python
>>> nums = [1, 2, 3]
>>> calc(*nums)
14
```

*nums表示把nums这个list的所有元素作为可变参数传进去。这种写法相当有用，而且很常见。

# 关键字参数

可变参数允许你传入0个或任意个参数，这些可变参数在函数调用时自动组装为一个tuple。而关键字参数允许你传入0个或任意个含参数名的参数，这些关键字参数在函数内部自动组装为一个dict。请看示例：

```python
def create_account(email, password, **kw):
    print('email:', email, 'password:', password, 'other:', kw)
```

函数`create_account`除了必选参数`email`和`password`外，还接受关键字参数kw。在调用该函数时，可以只传入必选参数：

```python
>>> create_account('zyndev@gmail.com', '123456')
email: zyndev@gmail.com password: 123456 other: {}
```
也可以传入任意个数的关键字参数：

```python
>>> create_account('zyndev@gmail.com', '123456', city='Beijing')
email: zyndev@gmail.com password: 123456 other: {'city': 'Beijing'}
>>> create_account('zyndev@gmail.com', '123456', gender='male', job='Software Engineer')
email: zyndev@gmail.com password: 123456 other: {'gender': 'male', 'job': 'Software Engineer'}
```

看看是不是很有意思，打印出了 **gender** 而且是 **male**。

关键字参数有什么用？它可以扩展函数的功能。比如，在`create_account`函数里，我们保证能接收到 email 和 password 这两个参数，但是，如果注册用户愿意提供更多的隐私，我们也能收到。试想你正在做一个用户注册的功能，这个功能很好用。

和可变参数类似，也可以先组装出一个dict，然后，把该dict转换为关键字参数传进去：

```python
>>> extra = {'city': 'Beijing', 'job': 'Software Engineer'}
>>> create_account('zyndev@gmail.com', '123456', city=extra['city'], job=extra['job'])
email: zyndev@gmail.com password: 123456 other: {'city': 'Beijing', 'job': 'Software Engineer'}
```

当然，上面复杂的调用可以用简化的写法：
```python
>>> extra = {'city': 'Beijing', 'job': 'Software Engineer'}
>>> create_account('zyndev@gmail.com', '123456', **extra)
email: zyndev@gmail.com password: 123456 other: {'city': 'Beijing', 'job': 'Software Engineer'}
```
`**extra` 表示把 `extra` 这个 `dict` 的所有 `key-value` 用关键字参数传入到函数的`**kw` 参数，`kw` 将获得一个 `dict`，注意`kw`获得的`dict`是`extra`的一份拷贝，对`kw`的改动不会影响到函数外的extra。

# 命名关键字参数

对于关键字参数，函数的调用者可以传入任意不受限制的关键字参数。至于到底传入了哪些，就需要在函数内部通过kw检查。

仍以person()函数为例，我们希望检查是否有city和job参数：
```python
def create_account(email, password, **kw):
    if 'city' in kw:
        # 有city参数
        pass
    if 'job' in kw:
        # 有job参数
        pass
    print('email:', email, 'password:', password, 'other:', kw)
```

但是调用者仍可以传入不受限制的关键字参数：
```python
>>> create_account('zyndev@gmail.com', '123456', gender='male', job='Software Engineer', nickname='我有一定基础了哦')
```

如果要限制关键字参数的名字，就可以用命名关键字参数，例如，只接收city,age,job作为关键字参数。这种方式定义的函数如下：
```python
def create_account(email, password, *, city, job, age):
    print("email", email, '\tpassword:', password, '\tjob', job, '\tage:', age)
```

和关键字参数`**kw`不同，命名关键字参数需要一个特殊分隔符 `*`，`*` 后面的参数被视为命名关键字参数。

调用方式如下：
```python
>>> create_account('zyndev@gmail.com', '123456', city='Beijing', job='Software Engineer', age=1)
```
这时所有的参数，我们都需要传入，那不传入：
```python
create_account('zyndev@gmail.com', '123456', city='Beijing')

Traceback (most recent call last):
  File "/Users/zhangyunan/PycharmProjects/study/method.py", line 5, in <module>
    create_account('zyndev@gmail.com', '123456', city='Beijing')
TypeError: create_account() missing 2 required keyword-only arguments: 'job' and 'age'
```
报错了，可是我并不想全部传入呀！好苦恼，还记得`默认参数`吗？结合默认参数就可以解决这个问题。彩蛋在下面哦。

上面可以得出，我们必须传入所有的参数，那我们多传一个可以吗？别忘了我还有性别呢！
```python

create_account('zyndev@gmail.com', '123456', city='Beijing', job="Full Stack Developer", age=1, gender='male')
Traceback (most recent call last):
  File "/Users/zhangyunan/PycharmProjects/study/method.py", line 5, in <module>
    create_account('zyndev@gmail.com', '123456', city='Beijing', job="Full Stack Developer", age=1, gender='male')
TypeError: create_account() got an unexpected keyword argument 'gender'
```
从代码中可以看出，我性别是男，工作是 全栈开发者，不过这报错了，当然我性别是对的，那工作也是对的，肯定是代码错了，从这里可以看出，我们不能像 `关键字参数` 那样随意传参数了，这次我们要做一个有规矩的人了。

如果函数定义中已经有了一个可变参数，后面跟着的命名关键字参数就不再需要一个特殊分隔符*了：

```python
def account(name, age, *args, city, job):
    print(name, age, args, city, job)
```

命名关键字参数必须传入参数名，这和位置参数不同。如果没有传入参数名，调用将报错：

```python
>>> account('Jack', 24, 'Beijing', 'Engineer')
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: account() takes 2 positional arguments but 4 were given
```

由于调用时缺少参数名city和job，Python解释器把这4个参数均视为位置参数，但account()函数仅接受2个位置参数。

命名关键字参数可以有缺省值，从而简化调用：

```python
def account(name, age, *, city='Beijing', job):
    print(name, age, city, job)
```
由于命名关键字参数city具有默认值，调用时，可不传入city参数：
```python
>>> account('Jack', 24, job='Engineer')
Jack 24 Beijing Engineer
```
使用命名关键字参数时，要特别注意，如果没有可变参数，就必须加一个 `*` 作为特殊分隔符。如果缺少 `*`，Python解释器将无法识别位置参数和命名关键字参数：
```python
def account(name, age, city, job):
    # 缺少 *，city和job被视为位置参数
    pass
```

# 参数组合

在Python中定义函数，可以用必选参数、默认参数、可变参数、关键字参数和命名关键字参数，这5种参数都可以组合使用。但是请注意，参数定义的顺序必须是：**必选参数、默认参数、可变参数、命名关键字参数和关键字参数**。

比如定义一个函数，包含上述若干种参数：
```python
def f1(a, b, c=0, *args, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'args =', args, 'kw =', kw)

def f2(a, b, c=0, *, d, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'd =', d, 'kw =', kw)
```
在函数调用的时候，Python解释器自动按照参数位置和参数名把对应的参数传进去。
```python
>>> f1(1, 2)
a = 1 b = 2 c = 0 args = () kw = {}
>>> f1(1, 2, c=3)
a = 1 b = 2 c = 3 args = () kw = {}
>>> f1(1, 2, 3, 'a', 'b')
a = 1 b = 2 c = 3 args = ('a', 'b') kw = {}
>>> f1(1, 2, 3, 'a', 'b', x=99)
a = 1 b = 2 c = 3 args = ('a', 'b') kw = {'x': 99}
>>> f2(1, 2, d=99, ext=None)
a = 1 b = 2 c = 0 d = 99 kw = {'ext': None}
```
最神奇的是通过一个tuple和dict，你也可以调用上述函数：
```python
>>> args = (1, 2, 3, 4)
>>> kw = {'d': 99, 'x': '#'}
>>> f1(*args, **kw)
a = 1 b = 2 c = 3 args = (4,) kw = {'d': 99, 'x': '#'}
>>> args = (1, 2, 3)
>>> kw = {'d': 88, 'x': '#'}
>>> f2(*args, **kw)
a = 1 b = 2 c = 3 d = 88 kw = {'x': '#'}
```
所以，对于任意函数，都可以通过类似func(*args, **kw)的形式调用它，无论它的参数是如何定义的。

Python的函数具有非常灵活的参数形态，既可以实现简单的调用，又可以传入非常复杂的参数。

默认参数一定要用不可变对象，如果是可变对象，程序运行时会有逻辑错误！

要注意定义可变参数和关键字参数的语法：

*args是可变参数，args接收的是一个tuple；

**kw是关键字参数，kw接收的是一个dict。

使用*args和**kw是Python的习惯写法，当然也可以用其他参数名，但最好使用习惯用法。

命名的关键字参数是为了限制调用者可以传入的参数名，同时可以提供默认值。

定义命名的关键字参数在没有可变参数的情况下不要忘了写分隔符*，否则定义的将是位置参数。

> 题外话，今天公众平台邀请我使用原创保护功能，这也算对我的一种认可吧！每一件事，只要坚持，最终还是有收获的，你的肯定，也是我继续写下去的动力，如果写的不好，请指正。

    公众平台邀请你使用原创保护功能
    公众平台邀请你使用原创保护功能，申请通过后将开通原创声明、赞赏、留言、页面模板四个功能。