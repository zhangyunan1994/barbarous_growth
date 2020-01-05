<h1> 第7 章 模块 优雅的封装 </h1>

**Table of Contents**

<!-- TOC -->

- [Python中的模块](#python中的模块)
- [使用模块](#使用模块)
- [定义模块](#定义模块)
- [建议](#建议)
- [模块的安装](#模块的安装)
- [模块搜索路径](#模块搜索路径)
- [作用域](#作用域)

<!-- /TOC -->

> 编程是一种美德，是促使一个人不断向上发展的一种原动力。

# Python中的模块

当我们的代码越写越多，开发的人数越来越多的时候，为了更高效的复用某个代码片段，方法，对象等，这时我们可以把常用的代码，放在一起，使用的人只需要利用这个文件中的代码就可以轻松的实现某些功能，例如上篇中提到了的 `power(x, n)` 和 `create_account(email, password, **kw)`,在一个项目中，这样的方法可能被很多人使用，不同的项目中，创建用户的方法也可能是相同的，这样我们就可以把这些功能聚在一起，让其他人更好的调用，提高开发效率。

有过编程基础的人，可能或多或少的使用过第三方库，在java中有个包的概念，c# 也有 命名空间，与之对应，python中有她的模块(Module)

Python 模块(Module)，是一个 Python 文件，以 .py 结尾，包含了 Python 对象定义和Python语句。
模块让你能够有逻辑地组织你的 Python 代码段。
把相关的代码分配到一个模块里能让你的代码更好用，更易懂。
模块能定义函数，类和变量，模块里也能包含可执行的代码。

# 使用模块

Python本身就内置了很多非常有用的模块，只要安装完毕，这些模块就可以立刻使用。

在`Python`中用关键字`import`来引入某个模块，比如要引用模块`math`，就可以在文件最开始的地方用`import math`来引入。在调用math模块中的函数时，必须这样引用：

    模块名.函数名

为什么必须加上模块名这样调用呢？因为可能存在这样一种情况：在多个模块中含有相同名称的函数，此时如果只是通过函数名来调用，解释器无法知道到底要调用哪个函数。所以如果像上述这样引入模块的时候，调用函数必须加上模块名。

```python
import math

# sprt 求算法平方根，也就是开根号操作
print(math.sqrt(2))

1.4142135623730951
```

有时候我们只需要用到模块中的某个函数，而不是整个模块，只需要引入该函数即可，此时可以通过语句

```python
from 模块名 import 函数名1,函数名2...
```

来实现，当然可以通过不仅仅可以引入函数，还可以引入一些常量。通过这种方式引入的时候，调用函数时只能给出函数名，不能给出模块名，但是当两个模块中含有相同名称函数的时候，后面一次引入会覆盖前一次引入。也就是说假如模块`math_a`中有函数`sqrt`，在模块`math_b`中也有函数`sqrt`，如果引入`math_a`中的`sqrt`在先、`math_b`中的`math_b`在后，那么当调用`sqrt`函数的时候，是去执行模块`math_b`中的`sprt`函数。

如果想一次性引入`math`中所有的东西，还可以通过
```python
from math import *
```
来实现，但是不建议这么做。

# 定义模块

在Python中，每个Python文件都可以作为一个模块，模块的名字就是文件的名字。那么我们创建两个模块`math_a` 和 `math_b` 来验证上面的说法

**math_a.py**
```python
def sqrt(x):
    print('这是 math_a 的 sqrt')
```
**math_b.py**
```python
def sqrt(x):
    print('这是 math_b 的 sqrt')
```

**module_test.py**
```python
from math_a import sqrt
from math_b import sqrt

sqrt(2)

这是 math_b 的 sqrt
```

通过上面的例子，我们创建了两个模块，并引入了这两个模块，后面模块的方法覆盖了前面模块引入的方法，到这里前面的结论是对的.

当我们项目复杂的时候，我们会引入大量的模块，难免会出现同名的方法，这时应该怎么办呢，在sql中可以为每个字段使用 `as` 起个别名，那我们在引入的时候起个别名，可不可以呢？ 当然可以了。


**module_test2.py**
```python
from math_a import sqrt as sqrta
from math_b import sqrt as sqrtb

sqrta(2)
sqrtb(5)

这是 math_a 的 sqrt
这是 math_b 的 sqrt
```

这样我们就可以同时使用两个模块的`sqrt`函数了

注意当引入模块时，模块文件中的代码会执行一次。但是注意，只在第一次引入时才会执行模块文件中的代码，因为只在第一次引入时进行加载，这样做很容易理解，不仅可以节约时间还可以节约内存。

# 建议

重新修改如下

**math_a.py**
```python
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

' a math module '

__author__ = 'zyndev'


def sqrt(x):
    """
    就是打印一下，和x一点关系都没有
    :param x: 
    :return: 
    """
    print('这是 math_a 的 sqrt')
```
第1行和第2行是标准注释，第1行注释可以让这个math_a.py文件直接在Unix/Linux/Mac上运行，第2行注释表示.py文件本身使用标准UTF-8编码；

第4行是一个字符串，表示模块的文档注释，任何模块代码的第一个字符串都被视为模块的文档注释；

第6行使用`__author__`变量把作者写进去，这样当你公开源代码后别人就可以瞻仰你的大名；

以上就是Python模块的标准文件模板，当然也可以全部删掉不写，但是，按标准办事肯定没错。

# 模块的安装

在Python中，安装第三方模块，是通过包管理工具pip完成的。

如果你正在使用Mac或Linux，安装pip本身这个步骤就可以跳过了。

如果你正在使用Windows，请参考安装Python一节的内容，确保安装时勾选了pip和Add python.exe to Path。

在命令提示符窗口下尝试运行pip，如果Windows提示未找到命令，可以重新运行安装程序添加pip。

在开发过程中，肯定会用到各种数据库，例如: `mysql`

当使用`python`连接`mysql`时就需要用到第三方模块，例如 `mysqlclient`

```python
pip install mysqlclient
```
耐心等待下载并安装后，就可以使用`mysqlclient`了。



一般来说，第三方库都会在Python官方的pypi.python.org网站注册，要安装一个第三方库，必须先知道该库的名称，可以在官网或者pypi上搜索. 有时国内访问国外网站速度并不是很快，这时就可以试试国内的一些镜像，例如豆瓣源
```python
pip install mysqlclient -i https://pypi.douban.com/simple
```

python 有很多有趣的库，大家可以不断尝试。

# 模块搜索路径

当我们试图加载一个模块时，Python会在指定的路径下搜索对应的.py文件，如果找不到，就会报错：
```python
>>> import mymodule
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ImportError: No module named mymodule
```
默认情况下，Python解释器会搜索当前目录、所有已安装的内置模块和第三方模块，搜索路径存放在sys模块的path变量中：
```python
import sys
sys.path

['/Users/zhangyunan/PycharmProjects/study', '/Users/zhangyunan/PycharmProjects/study', '/Library/Frameworks/Python.framework/Versions/3.6/lib/python36.zip', '/Library/Frameworks/Python.framework/Versions/3.6/lib/python3.6', '/Library/Frameworks/Python.framework/Versions/3.6/lib/python3.6/lib-dynload', '/Library/Frameworks/Python.framework/Versions/3.6/lib/python3.6/site-packages']

```
如果我们要添加自己的搜索目录，有两种方法：

一是直接修改sys.path，添加要搜索的目录：
```python
import sys
sys.path.append('/Users/michael/my_py_scripts')
```
这种方法是在运行时修改，运行结束后失效。

第二种方法是设置环境变量PYTHONPATH，该环境变量的内容会被自动添加到模块搜索路径中。设置方式与设置Path环境变量类似。注意只需要添加你自己的搜索路径，Python自己本身的搜索路径不受影响。


# 作用域

在一个模块中，我们可能会定义很多函数和变量，但有的函数和变量我们希望给别人使用，有的函数和变量我们希望仅仅在模块内部使用。在Python中，是通过`_`前缀来实现的。

正常的函数和变量名是公开的（public），可以被直接引用，比如：abc，x123，PI等；

类似`__xxx__`这样的变量是特殊变量，可以被直接引用，但是有特殊用途，比如上面的`__author__`就是特殊变量，`math_a.py`模块定义的文档注释也可以用特殊变量`__doc__`访问，我们自己的变量一般不要用这种变量名；

类似`_xxx`和`__xxx`这样的函数或变量就是非公开的（private），不应该被直接引用，比如`_abc`，`__abc`等；

之所以我们说，private函数和变量“不应该”被直接引用，而不是“不能”被直接引用，是因为Python并没有一种方法可以完全限制访问private函数或变量，但是，从编程习惯上不应该引用private函数或变量。毕竟大家都是成年人

private函数或变量不应该被别人引用，那它们有什么用呢？请看例子：

```python
def _private_1(name):
    return 'Hello, %s' % name

def _private_2(name):
    return 'Hi, %s' % name

def greeting(name):
    if len(name) > 3:
        return _private_1(name)
    else:
        return _private_2(name)
```

我们在模块里公开greeting()函数，而把内部逻辑用private函数隐藏起来了，这样，调用greeting()函数不用关心内部的private函数细节，这也是一种非常有用的代码封装和抽象的方法，即：

外部不需要引用的函数全部定义成private，只有外部需要引用的函数才定义为public。