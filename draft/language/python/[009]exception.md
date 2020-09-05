<h1>第9 章 就算是错误 我也要更正 </h1>

> 我们就像长不大的小孩，无时无刻都在犯错误，我们又像成熟的智者，总是在错误中成长

**Table of Contents**
<!-- TOC -->

- [try](#try)
- [调用堆栈](#调用堆栈)
- [记录错误](#记录错误)
- [抛出错误](#抛出错误)

<!-- /TOC -->

在程序运行的过程中,出现错误是一件很常见的情况,发生这种情况的原因有很多例如：

* 用户未按正常流程进行操作
* 用户输入的内容，我们的程序无法处理
* 用户输入数据，计算机无法处理
* 网络延迟
* 计算机硬件故障
...

当遇到错误的时候，有时我们并不想终止程序运行，遇到某些错误，我们想给用户一个友好的提示，告诉用户为什么出错，这也是必要的。

回顾前面的函数：

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

如果参数类型不对，Python解释器就无法帮我们检查。试试score_level输入’abc‘
```python
print(score_level('abc'))
Traceback (most recent call last):
  File "/Users/zhangyunan/PycharmProjects/study/method.py", line 15, in <module>
    print(score_level('abc'))
  File "/Users/zhangyunan/PycharmProjects/study/method.py", line 2, in score_level
    if score < 60:
TypeError: '<' not supported between instances of 'str' and 'int'
```
当调用 `score_level('abc')` 出错了，这是因为我们的程序应该处理一个数字，而用户输入了一个字符串


Python内置了一套try...except...finally...的错误处理机制，Python也不例外。

# try

让我们用一个例子来看看try的机制：
```python
try:
    print('try...')
    r = 10 / 0
    print('result:', r)
except ZeroDivisionError as e:
    print('except:', e)
finally:
    print('finally...')
print('END')
```
当我们认为某些代码可能会出错时，就可以用`try`来运行这段代码，如果执行出错，则后续代码不会继续执行，而是直接跳转至错误处理代码，即`except`语句块，执行完`except`后，如果有`finally`语句块，则执行`finally`语句块，至此，执行完毕。

上面的代码在计算`10 / 0`时会产生一个除法运算错误：
```python
try...
except: division by zero
finally...
END
```
从输出可以看到，当错误发生时，后续语句`print('result:', r)`不会被执行，`except`由于捕获到`ZeroDivisionError`，因此被执行。最后，`finally`语句被执行。然后，程序继续按照流程往下走。

如果把除数0改成2，则执行结果如下：
```python
try...
result: 5
finally...
END
```
由于没有错误发生，所以except语句块不会被执行，但是finally如果有，则一定会被执行（可以没有finally语句）。

你还可以猜测，错误应该有很多种类，如果发生了不同类型的错误，应该由不同的except语句块处理。没错，可以有多个except来捕获不同类型的错误：

```python
try:
    print('try...')
    r = 10 / int('a')
    print('result:', r)
except ValueError as e:
    print('ValueError:', e)
except ZeroDivisionError as e:
    print('ZeroDivisionError:', e)
finally:
    print('finally...')
print('END')
```
`int()`函数可能会抛出ValueError，所以我们用一个except捕获ValueError，用另一个except捕获ZeroDivisionError。

此外，如果没有错误发生，可以在`except`语句块后面加一个`else`，当没有错误发生时，会自动执行else语句：
```python
try:
    print('try...')
    r = 10 / int('2')
    print('result:', r)
except ValueError as e:
    print('ValueError:', e)
except ZeroDivisionError as e:
    print('ZeroDivisionError:', e)
else:
    print('no error!')
finally:
    print('finally...')
print('END')
```
Python的错误其实也是class，所有的错误类型都继承自BaseException，所以在使用except时需要注意的是，它不但捕获该类型的错误，还把其子类也“一网打尽”。比如：
```python
try:
    foo()
except ValueError as e:
    print('ValueError')
except UnicodeError as e:
    print('UnicodeError')
```

第二个except永远也捕获不到UnicodeError，因为UnicodeError是ValueError的子类，如果有，也被第一个except给捕获了。

Python所有的错误都是从BaseException类派生的，常见的错误类型和继承关系看这里：

https://docs.python.org/3/library/exceptions.html#exception-hierarchy

使用try...except捕获错误还有一个巨大的好处，就是可以跨越多层调用，比如函数main()调用foo()，foo()调用bar()，结果bar()出错了，这时，只要main()捕获到了，就可以处理：
```python
def foo(s):
    return 10 / int(s)

def bar(s):
    return foo(s) * 2

def main():
    try:
        bar('0')
    except Exception as e:
        print('Error:', e)
    finally:
        print('finally...')
```

也就是说，不需要在每个可能出错的地方去捕获错误，只要在合适的层次去捕获错误就可以了。这样一来，就大大减少了写try...except...finally的麻烦。

# 调用堆栈

如果错误没有被捕获，它就会一直往上抛，最后被Python解释器捕获，打印一个错误信息，然后程序退出。来看看 err.py：

**err.py**
```python
def foo(s):
    return 10 / int(s)

def bar(s):
    return foo(s) * 2

def main():
    bar('0')

main()
```
执行，结果如下：
```python
$ python3 err.py
Traceback (most recent call last):
  File "err.py", line 11, in <module>
    main()
  File "err.py", line 9, in main
    bar('0')
  File "err.py", line 6, in bar
    return foo(s) * 2
  File "err.py", line 3, in foo
    return 10 / int(s)
ZeroDivisionError: division by zero
```
出错并不可怕，可怕的是不知道哪里出错了。解读错误信息是定位错误的关键。我们从上往下可以看到整个错误的调用函数链：

错误信息第1行：
```python
Traceback (most recent call last):
```
告诉我们这是错误的跟踪信息。

第2~3行：
```python
  File "err.py", line 11, in <module>
    main()
```
调用main()出错了，在代码文件err.py的第11行代码，但原因是第9行：
```python
  File "err.py", line 9, in main
    bar('0')
```
调用bar('0')出错了，在代码文件err.py的第9行代码，但原因是第6行：
```python
  File "err.py", line 6, in bar
    return foo(s) * 2
```
原因是return foo(s) * 2这个语句出错了，但这还不是最终原因，继续往下看：
```python
  File "err.py", line 3, in foo
    return 10 / int(s)
```
原因是return 10 / int(s)这个语句出错了，这是错误产生的源头，因为下面打印了：
```python
ZeroDivisionError: integer division or modulo by zero
```
根据错误类型ZeroDivisionError，我们判断，int(s)本身并没有出错，但是int(s)返回0，在计算10 / 0时出错，至此，找到错误源头。

# 记录错误

如果不捕获错误，自然可以让Python解释器来打印出错误堆栈，但程序也被结束了。既然我们能捕获错误，就可以把错误堆栈打印出来，然后分析错误原因，同时，让程序继续执行下去。

Python内置的logging模块可以非常容易地记录错误信息：

**err_logging.py**
```python
import logging

def foo(s):
    return 10 / int(s)

def bar(s):
    return foo(s) * 2

def main():
    try:
        bar('0')
    except Exception as e:
        logging.exception(e)

main()
print('END')
```
同样是出错，但程序打印完错误信息后会继续执行，并正常退出：
```python
$ python3 err_logging.py
ERROR:root:division by zero
Traceback (most recent call last):
  File "err_logging.py", line 13, in main
    bar('0')
  File "err_logging.py", line 9, in bar
    return foo(s) * 2
  File "err_logging.py", line 6, in foo
    return 10 / int(s)
ZeroDivisionError: division by zero
END
```

通过配置，logging还可以把错误记录到日志文件里，方便事后排查。

# 抛出错误

因为错误是class，捕获一个错误就是捕获到该class的一个实例。因此，错误并不是凭空产生的，而是有意创建并抛出的。Python的内置函数会抛出很多类型的错误，我们自己编写的函数也可以抛出错误。

如果要抛出错误，首先根据需要，可以定义一个错误的class，选择好继承关系，然后，用raise语句抛出一个错误的实例：

**err_raise.py**
```python
class FooError(ValueError):
    pass

def foo(s):
    n = int(s)
    if n==0:
        raise FooError('invalid value: %s' % s)
    return 10 / n

foo('0')
```
执行，可以最后跟踪到我们自己定义的错误：
```python
$ python3 err_raise.py 
Traceback (most recent call last):
  File "err_throw.py", line 11, in <module>
    foo('0')
  File "err_throw.py", line 8, in foo
    raise FooError('invalid value: %s' % s)
__main__.FooError: invalid value: 0
```
只有在必要的时候才定义我们自己的错误类型。如果可以选择Python已有的内置的错误类型（比如ValueError，TypeError），尽量使用Python内置的错误类型。

最后，我们来看另一种错误处理的方式：

**err_reraise.py**
```python
def foo(s):
    n = int(s)
    if n==0:
        raise ValueError('invalid value: %s' % s)
    return 10 / n

def bar():
    try:
        foo('0')
    except ValueError as e:
        print('ValueError!')
        raise

bar()
```
在bar()函数中，我们明明已经捕获了错误，但是，打印一个ValueError!后，又把错误通过raise语句抛出去了，这不有病么？

其实这种错误处理方式不但没病，而且相当常见。捕获错误目的只是记录一下，便于后续追踪。但是，由于当前函数不知道应该怎么处理该错误，所以，最恰当的方式是继续往上抛，让顶层调用者去处理。好比一个员工处理不了一个问题时，就把问题抛给他的老板，如果他的老板也处理不了，就一直往上抛，最终会抛给CEO去处理。

raise语句如果不带参数，就会把当前错误原样抛出。此外，在except中raise一个Error，还可以把一种类型的错误转化成另一种类型：
```python
try:
    10 / 0
except ZeroDivisionError:
    raise ValueError('input error!')
```
只要是合理的转换逻辑就可以，但是，决不应该把一个IOError转换成毫不相干的ValueError。

小结

Python内置的try...except...finally用来处理错误十分方便。出错时，会分析错误信息并定位错误发生的代码位置才是最关键的。

程序也可以主动抛出错误，让调用者来处理相应的错误。但是，应该在文档中写清楚可能会抛出哪些错误，以及错误产生的原因。