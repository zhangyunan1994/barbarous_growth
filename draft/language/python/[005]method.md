
<h1> 第5 章 函数 </h1>

**Table of Contents**
<!-- TOC -->

- [函数调用](#函数调用)
- [数据类型转换](#数据类型转换)
- [定义函数](#定义函数)
- [空函数](#空函数)
- [返回多个值](#返回多个值)
- [tuple](#tuple)

<!-- /TOC -->

# 函数调用

Python内置了很多有用的函数，我们可以直接调用。

要调用一个函数，需要知道函数的名称和参数，比如在前面求长度函数len，只有一个参数。

也可以在交互式命令行通过help(len)查看len函数的帮助信息。
```python
Python 2.7.10 (default, Jul 15 2017, 17:16:57) 
[GCC 4.2.1 Compatible Apple LLVM 9.0.0 (clang-900.0.31)] on darwin
Type "help", "copyright", "credits" or "license" for more information.
>>> help(len)

Help on built-in function len in module __builtin__:

len(...)
    len(object) -> integer
    
    Return the number of items of a sequence or collection.
(END)

```

调用len函数：
```python
>>> d = 'abcd'
>>> len(d)
4
```

调用函数的时候，如果传入的参数数量不对，会报TypeError的错误，并且Python会明确地告诉你：len()有且仅有1个参数，但给出了两个：
```python
>>> len(d,12)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: len() takes exactly one argument (2 given)
>>> 
```
如果传入的参数数量是对的，但参数类型不能被函数所接受，也会报TypeError的错误，并且给出错误信息：
```python
>>> len(2345.5)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: object of type 'float' has no len()
```

而max函数max()可以接收任意多个参数，并返回最大的那个：
```python
>>> max(1, 2)
2
>>> max(2, 3, 1, -5)
3
```

# 数据类型转换

还记得这段代码吗？
```python
score_str = input('your score: ')
score = int(score_str)
if score < 60:
    print('不及格')
elif score < 70:
    print('继续努力')
elif score < 80:
    print('中等')
elif score < 90:
    print('良好')
else:
    print('优等生')
```
因为input返回的是str(字符串),字符串不能和数字进比较，所以我们使用了int() 函数将 str 转换为 int 来让程序进行下去

Python内置的常用函数还包括数据类型转换函数，比如int()函数可以把其他数据类型转换为整数：
```python
>>> int('123')
123
>>> int(12.34)
12
>>> float('12.34')
12.34
>>> str(1.23)
'1.23'
>>> str(100)
'100'
>>> bool(1)
True
>>> bool('')
False
```
函数名其实就是指向一个函数对象的引用，完全可以把函数名赋给一个变量，相当于给这个函数起了一个“别名”：
```python
>>> a = abs # 变量a指向abs函数
>>> a(-1) # 所以也可以通过a调用abs函数
1
```

# 定义函数

在Python中，定义一个函数要使用def语句，依次写出函数名、括号、括号中的参数和冒号:，然后，在缩进块中编写函数体，函数的返回值用return语句返回。

我们以自定义一个求学生等级函数为例：
```python
def score_level(score):
    if score < 60:
        level = '不及格'
    elif score < 70:
        level = '继续努力'
    elif score < 80:
        level = '中等'
    elif score < 90:
        level = '良好'
    else:
        level = '优等生'
    return level
```

调用一下：
```python
print(score_level(59))
```
输出`不及格`

请注意，函数体内部的语句在执行时，一旦执行到return时，函数就执行完毕，并将结果返回。因此，函数内部通过条件判断和循环可以实现非常复杂的逻辑。

如果没有return语句，函数执行完毕后也会返回结果，只是结果为None。

return None可以简写为return。

在Python交互环境中定义函数时，注意Python会出现...的提示。函数定义结束后需要按两次回车重新回到>>>提示符下：

# 空函数

如果想定义一个什么事也不做的空函数，可以用pass语句：
```python
def nop():
    pass
```
pass语句什么都不做，那有什么用？实际上pass可以用来作为占位符，比如现在还没想好怎么写函数的代码，就可以先放一个pass，让代码能运行起来。

pass还可以用在其他语句里，比如：
```python
if age >= 18:
    pass
```
缺少了pass，代码运行就会有语法错误。

参数检查

调用函数时，如果参数个数不对，Python解释器会自动检查出来，并抛出TypeError：

但是如果参数类型不对，Python解释器就无法帮我们检查。试试score_level输入’abc‘
```python
print(score_level('abc'))
Traceback (most recent call last):
  File "/Users/zhangyunan/PycharmProjects/study/method.py", line 15, in <module>
    print(score_level('abc'))
  File "/Users/zhangyunan/PycharmProjects/study/method.py", line 2, in score_level
    if score < 60:
TypeError: '<' not supported between instances of 'str' and 'int'
```
当传入了不恰当的参数时，会导致if语句出错。所以，这个函数定义不够完善。

让我们修改一下score_level的定义，对参数类型做检查，只允许整数和浮点数类型的参数。数据类型检查可以用内置函数`isinstance()`实现：

```python
def score_level(score):
    if not isinstance(score, (int, float)):
        raise TypeError('输入参数错误，参数应该为 int 或 float 类型')
    if score < 60:
        level = '不及格'
    elif score < 70:
        level = '继续努力'
    elif score < 80:
        level = '中等'
    elif score < 90:
        level = '良好'
    else:
        level = '优等生'
    return level

```
添加了参数检查后，如果传入错误的参数类型，函数就可以抛出一个错误：

```python
>>> print(score_level('ewer'))
Traceback (most recent call last):
  File "/Users/zhangyunan/PycharmProjects/study/method.py", line 17, in <module>
    print(score_level('ewer'))
  File "/Users/zhangyunan/PycharmProjects/study/method.py", line 3, in score_level
    raise TypeError('输入参数错误，参数应该为 int 或 float 类型')
TypeError: 输入参数错误，参数应该为 int 或 float 类型
```
错误和异常处理将在后续讲到。

# 返回多个值

函数可以返回多个值吗？答案是肯定的。

比如在游戏中经常需要从一个点移动到另一个点，给出坐标、位移和角度，就可以计算出新的新的坐标：
```python
import math

def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny
```
import math语句表示导入math包，并允许后续代码引用math包里的sin、cos等函数。

然后，我们就可以同时获得返回值：
```python
>>> x, y = move(100, 100, 60, math.pi / 6)
>>> print(x, y)
151.96152422706632 70.0
```
但其实这只是一种假象，Python函数返回的仍然是单一值：
```python
>>> r = move(100, 100, 60, math.pi / 6)
>>> print(r)
(151.96152422706632, 70.0)
```
原来返回值是一个tuple！但是，在语法上，返回一个tuple可以省略括号，而多个变量可以同时接收一个tuple，按位置赋给对应的值，所以，Python的函数返回多值其实就是返回一个tuple，但写起来更方便。

# tuple

另一种有序列表叫元组：tuple。tuple和list非常类似，但是tuple一旦初始化就不能修改，比如同样是列出同学的名字：
```python
>>> classmates = ('Michael', 'Bob', 'Tracy')
```
现在，classmates这个tuple不能变了，它也没有append()，insert()这样的方法。其他获取元素的方法和list是一样的，你可以正常地使用classmates[0]，classmates[-1]，但不能赋值成另外的元素。

不可变的tuple有什么意义？因为tuple不可变，所以代码更安全。如果可能，能用tuple代替list就尽量用tuple。

tuple的陷阱：当你定义一个tuple时，在定义的时候，tuple的元素就必须被确定下来，比如：
```python
>>> t = (1, 2)
>>> t
(1, 2)
```
如果要定义一个空的tuple，可以写成()：
```python
>>> t = ()
>>> t
()
```
但是，要定义一个只有1个元素的tuple，如果你这么定义：
```python
>>> t = (1)
>>> t
1
```
定义的不是tuple，是1这个数！这是因为括号()既可以表示tuple，又可以表示数学公式中的小括号，这就产生了歧义，因此，Python规定，这种情况下，按小括号进行计算，计算结果自然是1。

所以，只有1个元素的tuple定义时必须加一个逗号,，来消除歧义：
```python
>>> t = (1,)
>>> t
(1,)
```
Python在显示只有1个元素的tuple时，也会加一个逗号,，以免你误解成数学计算意义上的括号。

最后来看一个“可变的”tuple：
```python
>>> t = ('a', 'b', ['A', 'B'])
>>> t[2][0] = 'X'
>>> t[2][1] = 'Y'
>>> t
('a', 'b', ['X', 'Y'])
```
这个tuple定义的时候有3个元素，分别是'a'，'b'和一个list。不是说tuple一旦定义后就不可变了吗？怎么后来又变了？

别急，我们先看看定义的时候tuple包含的3个元素：

![tuple-0](./resources/py_tuple_1.png)


当我们把list的元素'A'和'B'修改为'X'和'Y'后，tuple变为：

![tuple-0](./resources/py_tuple_2.png)
表面上看，tuple的元素确实变了，但其实变的不是tuple的元素，而是list的元素。tuple一开始指向的list并没有改成别的list，所以，tuple所谓的“不变”是说，tuple的每个元素，指向永远不变。即指向'a'，就不能改成指向'b'，指向一个list，就不能改成指向其他对象，但指向的这个list本身是可变的！

理解了“指向不变”后，要创建一个内容也不变的tuple怎么做？那就必须保证tuple的每一个元素本身也不能变。

小结

定义函数时，需要确定函数名和参数个数；

如果有必要，可以先对参数的数据类型做检查；

函数体内部可以用return随时返回函数结果；

函数执行完毕也没有return语句时，自动return None。

函数可以同时返回多个值，但其实就是一个tuple。