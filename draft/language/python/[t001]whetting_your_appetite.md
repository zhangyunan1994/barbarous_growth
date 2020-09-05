# 1. Whetting Your Appetite
	1.吊起你的食欲

If you do much work on computers, eventually you find that there’s some task you’d like to automate. For example, you may wish to perform a search-and-replace over a large number of text files, or rename and rearrange a bunch of photo files in a complicated way. Perhaps you’d like to write a small custom database, or a specialized GUI application, or a simple game.

如果你在电脑上做了很多工作，最终你会发现有些任务是你想要自动化的。例如，您可能希望对大量文本文件执行搜索和替换，或者以复杂的方式重命名和重新排列一组照片文件。也许您想编写一个小的定制数据库，或者一个专业的GUI应用程序，或者一个简单的游戏。

If you’re a professional software developer, you may have to work with several C/C++/Java libraries but find the usual write/compile/test/re-compile cycle is too slow. Perhaps you’re writing a test suite for such a library and find writing the testing code a tedious task. Or maybe you’ve written a program that could use an extension language, and you don’t want to design and implement a whole new language for your application.

如果您是专业的软件开发人员，您可能需要使用几个C / c++ / Java库，但是发现通常的写/编译/测试/重新编译周期太慢了。也许您正在为这样的库编写一个测试套件，并发现编写测试代码是一个乏味的任务。或者您已经编写了一个可以使用扩展语言的程序，并且您不想为您的应用程序设计和实现一种全新的语言。

Python is just the language for you.

Python就是你的语言。

You could write a Unix shell script or Windows batch files for some of these tasks, but shell scripts are best at moving around files and changing text data, not well-suited for GUI applications or games. You could write a C/C++/Java program, but it can take a lot of development time to get even a first-draft program. Python is simpler to use, available on Windows, Mac OS X, and Unix operating systems, and will help you get the job done more quickly.

您可以为这些任务编写一个Unix shell脚本或Windows批处理文件，但是shell脚本最好是移动文件和更改文本数据，不适合GUI应用程序或游戏。您可以编写一个C / c++ / Java程序，但要获得一个初稿程序，还需要大量的开发时间。Python更简单，可以在Windows、Mac OS X和Unix操作系统上使用，并将帮助您更快地完成任务。

Python is simple to use, but it is a real programming language, offering much more structure and support for large programs than shell scripts or batch files can offer. On the other hand, Python also offers much more error checking than C, and, being a very-high-level language, it has high-level data types built in, such as flexible arrays and dictionaries. Because of its more general data types Python is applicable to a much larger problem domain than Awk or even Perl, yet many things are at least as easy in Python as in those languages.

Python使用起来很简单，但它是一种真正的编程语言，它提供了比shell脚本或批处理文件所提供的大型程序更大的结构和支持。另一方面，Python也提供比C更多的错误检查，并且作为一种高级语言，它拥有内置的高级数据类型，例如灵活的数组和字典。由于其更一般的数据类型Python适用于比Awk甚至Perl更大的问题域，但是许多东西至少在Python中和那些语言中一样容易。


Python allows you to split your program into modules that can be reused in other Python programs. It comes with a large collection of standard modules that you can use as the basis of your programs — or as examples to start learning to program in Python. Some of these modules provide things like file I/O, system calls, sockets, and even interfaces to graphical user interface toolkits like Tk.

Python允许您将您的程序拆分为可以在其他Python程序中重用的模块。它附带了大量标准模块，可以作为程序的基础——或者作为开始学习Python程序的例子。其中一些模块提供了诸如文件I / O、系统调用、套接字，甚至是像Tk这样的图形用户界面工具包的接口。

Python is an interpreted language, which can save you considerable time during program development because no compilation and linking is necessary. The interpreter can be used interactively, which makes it easy to experiment with features of the language, to write throw-away programs, or to test functions during bottom-up program development. It is also a handy desk calculator.

Python是一种解释语言，它可以在程序开发过程中节省大量时间，因为不需要编译和链接。可以交互式地使用解释器，这样可以很容易地尝试使用语言的特性，编写一次性程序，或者在自底向上的程序开发过程中测试函数。它也是一个方便的台式计算器。

Python enables programs to be written compactly and readably. Programs written in Python are typically much shorter than equivalent C, C++, or Java programs, for several reasons:

	* the high-level data types allow you to express complex operations in a single statement;
	* statement grouping is done by indentation instead of beginning and ending brackets;
	* no variable or argument declarations are necessary.

Python使程序能够紧凑而易读。用Python编写的程序通常比等效的C、c++或Java程序要短得多，原因如下:

高级数据类型允许您在单个语句中表达复杂的操作

语句分组是由缩进而不是开始和结束括号完成的

没有必要变量或参数声明



Python is extensible: if you know how to program in C it is easy to add a new built-in function or module to the interpreter, either to perform critical operations at maximum speed, or to link Python programs to libraries that may only be available in binary form (such as a vendor-specific graphics library). Once you are really hooked, you can link the Python interpreter into an application written in C and use it as an extension or command language for that application.

Python是可扩展的:如果你知道如何用C程序很容易添加一个新的内置函数或模块的翻译,在最大速度执行关键操作,或者Python程序链接到库,可能只是在二进制形式(如特定于供应商的图形库)。一旦您真的上钩了，您就可以将Python解释器链接到一个用C编写的应用程序中，并将它用作该应用程序的扩展或命令语言。

By the way, the language is named after the BBC show “Monty Python’s Flying Circus” and has nothing to do with reptiles. Making references to Monty Python skits in documentation is not only allowed, it is encouraged!

顺便说一下，这种语言是以BBC“Monty Python的飞行马戏团”节目命名的，与爬行动物没有任何关系。在文档中引用Monty Python skits不仅是允许的，而且是鼓励的!

Now that you are all excited about Python, you’ll want to examine it in some more detail. Since the best way to learn a language is to use it, the tutorial invites you to play with the Python interpreter as you read.

既然您已经对Python感到很兴奋了，那么您将需要更详细地研究它。既然学习一门语言的最佳方法是使用它，那么教程就会邀请您在阅读时与Python解释器一起玩。

In the next chapter, the mechanics of using the interpreter are explained. This is rather mundane information, but essential for trying out the examples shown later.

在下一章中，解释了使用解释器的机制。这是相当平凡的信息，但对于尝试稍后展示的示例是必不可少的。

The rest of the tutorial introduces various features of the Python language and system through examples, beginning with simple expressions, statements and data types, through functions and modules, and finally touching upon advanced concepts like exceptions and user-defined classes.

本教程的其余部分通过示例介绍了Python语言和系统的各种特性，从简单的表达式、语句和数据类型开始，通过函数和模块，最后涉及到高级概念，如异常和用户定义类。
