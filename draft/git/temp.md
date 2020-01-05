

查看已暂存和未暂存的修改
如果 git status 命令的输出对于你来说过于模糊，你想知道具体修改了什么地方，可以用 git diff 命令。 稍后我们会详细介绍 git diff，你可能通常会用它来回答这两个问题：当前做的哪些更新还没有暂存？ 有哪些更新已经暂存起来准备好了下次提交？ 尽管 git status 已经通过在相应栏下列出文件名的方式回答了这个问题，git diff 将通过文件补丁的格式显示具体哪些行发生了改变。

假如再次修改 README 文件后暂存，然后编辑 CONTRIBUTING.md 文件后先不暂存， 运行 status 命令将会看到：

$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    modified:   README

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md
要查看尚未暂存的文件更新了哪些部分，不加参数直接输入 git diff：

$ git diff
diff --git a/CONTRIBUTING.md b/CONTRIBUTING.md
index 8ebb991..643e24f 100644
--- a/CONTRIBUTING.md
+++ b/CONTRIBUTING.md
@@ -65,7 +65,8 @@ branch directly, things can get messy.
 Please include a nice description of your changes when you submit your PR;
 if we have to read the whole diff to figure out why you're contributing
 in the first place, you're less likely to get feedback and have your change
-merged in.
+merged in. Also, split your changes into comprehensive chunks if your patch is
+longer than a dozen lines.

 If you are starting to work on a particular area, feel free to submit a PR
 that highlights your work in progress (and note in the PR title that it's
此命令比较的是工作目录中当前文件和暂存区域快照之间的差异， 也就是修改之后还没有暂存起来的变化内容。

若要查看已暂存的将要添加到下次提交里的内容，可以用 git diff --cached 命令。（Git 1.6.1 及更高版本还允许使用 git diff --staged，效果是相同的，但更好记些。）

$ git diff --staged
diff --git a/README b/README
new file mode 100644
index 0000000..03902a1
--- /dev/null
+++ b/README
@@ -0,0 +1 @@
+My Project
请注意，git diff 本身只显示尚未暂存的改动，而不是自上次提交以来所做的所有改动。 所以有时候你一下子暂存了所有更新过的文件后，运行 git diff 后却什么也没有，就是这个原因。

像之前说的，暂存 CONTRIBUTING.md 后再编辑，运行 git status 会看到暂存前后的两个版本。 如果我们的环境（终端输出）看起来如下：

$ git add CONTRIBUTING.md
$ echo '# test line' >> CONTRIBUTING.md
$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    modified:   CONTRIBUTING.md

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md
现在运行 git diff 看暂存前后的变化：

$ git diff
diff --git a/CONTRIBUTING.md b/CONTRIBUTING.md
index 643e24f..87f08c8 100644
--- a/CONTRIBUTING.md
+++ b/CONTRIBUTING.md
@@ -119,3 +119,4 @@ at the
 ## Starter Projects

 See our [projects list](https://github.com/libgit2/libgit2/blob/development/PROJECTS.md).
+# test line
然后用 git diff --cached 查看已经暂存起来的变化：（--staged 和 --cached 是同义词）

$ git diff --cached
diff --git a/CONTRIBUTING.md b/CONTRIBUTING.md
index 8ebb991..643e24f 100644
--- a/CONTRIBUTING.md
+++ b/CONTRIBUTING.md
@@ -65,7 +65,8 @@ branch directly, things can get messy.
 Please include a nice description of your changes when you submit your PR;
 if we have to read the whole diff to figure out why you're contributing
 in the first place, you're less likely to get feedback and have your change
-merged in.
+merged in. Also, split your changes into comprehensive chunks if your patch is
+longer than a dozen lines.

 If you are starting to work on a particular area, feel free to submit a PR
 that highlights your work in progress (and note in the PR title that it's
Note
Git Diff 的插件版本
在本书中，我们使用 git diff 来分析文件差异。 但是，如果你喜欢通过图形化的方式或其它格式输出方式的话，可以使用 git difftool 命令来用 Araxis ，emerge 或 vimdiff 等软件输出 diff 分析结果。 使用 git difftool --tool-help 命令来看你的系统支持哪些 Git Diff 插件。



移除文件
要从 Git 中移除某个文件，就必须要从已跟踪文件清单中移除（确切地说，是从暂存区域移除），然后提交。 可以用 git rm 命令完成此项工作，并连带从工作目录中删除指定的文件，这样以后就不会出现在未跟踪文件清单中了。

如果只是简单地从工作目录中手工删除文件，运行 git status 时就会在 “Changes not staged for commit” 部分（也就是 未暂存清单）看到：

$ rm PROJECTS.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        deleted:    PROJECTS.md

no changes added to commit (use "git add" and/or "git commit -a")
然后再运行 git rm 记录此次移除文件的操作：

$ git rm PROJECTS.md
rm 'PROJECTS.md'
$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    deleted:    PROJECTS.md
下一次提交时，该文件就不再纳入版本管理了。 如果删除之前修改过并且已经放到暂存区域的话，则必须要用强制删除选项 -f（译注：即 force 的首字母）。 这是一种安全特性，用于防止误删还没有添加到快照的数据，这样的数据不能被 Git 恢复。

另外一种情况是，我们想把文件从 Git 仓库中删除（亦即从暂存区域移除），但仍然希望保留在当前工作目录中。 换句话说，你想让文件保留在磁盘，但是并不想让 Git 继续跟踪。 当你忘记添加 .gitignore 文件，不小心把一个很大的日志文件或一堆 .a 这样的编译生成文件添加到暂存区时，这一做法尤其有用。 为达到这一目的，使用 --cached 选项：

$ git rm --cached README
git rm 命令后面可以列出文件或者目录的名字，也可以使用 glob 模式。 比方说：

$ git rm log/\*.log
注意到星号 * 之前的反斜杠 \， 因为 Git 有它自己的文件模式扩展匹配方式，所以我们不用 shell 来帮忙展开。 此命令删除 log/ 目录下扩展名为 .log 的所有文件。 类似的比如：

$ git rm \*~
该命令为删除以 ~ 结尾的所有文件。

移动文件
不像其它的 VCS 系统，Git 并不显式跟踪文件移动操作。 如果在 Git 中重命名了某个文件，仓库中存储的元数据并不会体现出这是一次改名操作。 不过 Git 非常聪明，它会推断出究竟发生了什么，至于具体是如何做到的，我们稍后再谈。

既然如此，当你看到 Git 的 mv 命令时一定会困惑不已。 要在 Git 中对文件改名，可以这么做：

$ git mv file_from file_to
它会恰如预期般正常工作。 实际上，即便此时查看状态信息，也会明白无误地看到关于重命名操作的说明：

$ git mv README.md README
$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    renamed:    README.md -> README
其实，运行 git mv 就相当于运行了下面三条命令：

$ mv README.md README
$ git rm README.md
$ git add README
如此分开操作，Git 也会意识到这是一次改名，所以不管何种方式结果都一样。 两者唯一的区别是，mv 是一条命令而另一种方式需要三条命令，直接用 git mv 轻便得多。 不过有时候用其他工具批处理改名的话，要记得在提交前删除老的文件名，再添加新的文件名。





想让日志更清晰,可以运行

git log --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit --date=relative  
当然命令这么长，可以用别名


加入暂存区

对代码进行编辑和修改提交使用

git add
文件名加入"暂存区"

查看日志



使用git log 查看提交日志 参数--pretty=short只显示提交日志第一行
git log -p 文件名 显示提交之前之后文件的变化 --graph 图形化显示使用

查看状态

git status查看当前状态

提交

使用



git commit --amend
可以进行修改
若是文件较少可以用

git commit -am "recored message"
来代替add 和commit -m两步使用

git diff

git diff查看当前工作树与暂存区的差别
git diff HEAD专门查看当前工作树与最后一次提交的差别

查看分支

git branch查看当前分支 -a显示当前分支的相关信息。

切换分支

git checkout -b feature-A
创建feature-A分支并切换到feature-A分支 相当于

git branch feature-A;git checkout feature-A
两条命令
git checkout master 切换到master分支
git checkout - 切换到上一分支合并分支
git checkout master;git merge --no-ff feature-A先切换到master分支在合并 此时会打开编辑器录入合并信息 之后合并成功恢复历史

查看每次提交哈希值

git reflog查看当前仓库执行过的操作会有各个版本的哈希值

回退版本

使用git reset --hard 哈希值恢复到历史状态 解决冲突 根据冲突报告修改冲突的文件 再次git commit -am "record message"即可

压缩历史

如果遇到拼写错误等问题可以add commit之后将两个历史纪录合并成一条 使用

git rebase -i HEAD-2
命令会打开编辑器，将

 pick  7a34294 Add feature-C    pick 6fba227 Fix typo
中的第二个pick改成squash或s即可

添加远程仓库

git remote add origin git@github.com:CheungChanDevCoder/pythonTools.git
此时会把远程仓库设成origin

推送至远程仓库 推送至master分支

先切换到master分支 git push -u origin master 其中-u表示upstream（上游）在推送的同时设置了origin 仓库的master分支是本地仓库当前分支的上游。 推送至master以外的分支，不如本地创建了feature-D分支 先切换到feature-D分支然后 git push -u origin feature-D

获取远程仓库的feature-D分支

 git checkout -b feature-D origin/feature-D  
推送至远程feature-D git push即可 更新本地的feature-D到远程的最新状态

git pull origin feature-D
git diff

git diff <$id1> <$id2>  
# 比较两次提交之间的差异  是<$id2>相对于<$id1>改变了什么
git diff <branch1>..<branch2>
# 在两个分支之间比较
git diff --staged   
# 比较暂存区和版本库差异
复位中软模式、硬模式、混合模式的区别

git reset --hard硬模式代表index和working directory全部复位，包括未提交的更改
git reset混合模式代表reset index但是leving working diretory untouched，也就是变为未加入暂存区的状态，但是工作空间有所有改变的代码
git reset --soft软模式代表leaving working directory and index untouched，也就是文件所有的改变加入了暂存区而未提交

git常用分支操作

git不要在下代码的主分支上修改代码，要checkout一个开发分支，在上面开发，开发完成后再切换回主分支， 进行衍合或合并操作。最后再在主分支上向远程提交代码。类似的修bug也要在主分支上创建一个分支进行操作， 永远确保主分支是稳定版。

git修改密码

打开git bash 输入 cd ~/.ssh ls 确定有 id_rsa 和 id_rsa.pub文件 ssh-keygen -p -f id_rsa 第一次输入旧密码 新密码 确认新密码

git压缩多次提交为一次提交

切记已经推送到远程版本不可再使用。 比如压缩最后4次提交为一次提交

git rebase -i HEAD~4
该命令执行后，会弹出vim的编辑窗口，4次提交的信息会倒序排列， 最上面的是第四次提交，最下面的是最近一次提交。

我们需要修改第2-4行的第一个单词pick为squash， 这个意义为将最后三次的提交压缩到倒数第四次的提交， 效果就是我们在pick所在的提交就已经做了4次动作，但是看起来就是一次而已：

然后我们保存退出，git会一个一个压缩提交历史，如果有冲突，需要修改，修改的时候要注意， 保留最新的历史，不然我们的修改就丢弃了。修改以后要记得敲下面的命令：

git add .
git rebase --continue
如果你想放弃这次压缩的话，执行以下命令：

git rebase --abort
如果所有冲突都已经解决了，会出现如下的编辑窗口：

这个时候我们需要修改一下合并后的commit的描述信息，我们将其描述为helloworld吧：

如果想压缩第一三四次的提交，不压缩第二次的提交，可以移动一下提交顺序。

改变两次提交先后顺序

切记已经推送到远程版本不可再使用。 方法同上，使用交互式衍合操作，只需要改动图片中的顺序

拆分提交

切记已经推送到远程版本不可再使用。 拆分一个提交会撤消这个提交，然后多次地部分地暂存与提交直到完成你所需次数的提交。 例如，假设想要拆分三次提交的中间那次提交。 想要将它拆分为两次提交： 第一个 “updated README formatting”，第二个 “added blame” 来代替原来的 “updated README formatting and added blame”。 可以通过修改 rebase -i 的脚本来做到这点，将要拆分的提交的指令修改为 “edit”：

pick f7f3f6d changed my name a bit
edit 310154e updated README formatting and added blame
pick a5f4a0d added cat-file
然后，当脚本将你进入到命令行时，重置那个提交，拿到被重置的修改，从中创建几次提交。 当保存并退出编辑器时，Git 带你到列表中第一个提交的父提交， 应用第一个提交（f7f3f6d），应用第二个提交（310154e）， 然后让你进入命令行。 那里，可以通过 git reset HEAD^ 做一次针对那个提交的混合重置， 实际上将会撤消那次提交并将修改的文件未暂存。 现在可以暂存并提交文件直到有几个提交， 然后当完成时运行 git rebase --continue：

$ git reset HEAD^
$ git add README
$ git commit -m 'updated README formatting'
$ git add lib/simplegit.rb
$ git commit -m 'added blame'
$ git rebase --continue
Git 在脚本中应用最后一次提交（a5f4a0d），历史记录看起来像这样：

$ git log -4 --pretty=format:"%h %s"
1c002dd added cat-file
9b29157 added blame
35cfb2b updated README formatting
f3cc40e changed my name a bit
再一次，这些改动了所有在列表中的提交的 SHA-1 校验和， 所以要确保列表中的提交还没有推送到共享仓库中。

修改最后一次提交

切记已经推送到远程版本不可再使用。 如果你已经完成提交，又因为之前提交时忘记添加一个新创建的文件，想通过添加或修改文件来更改提交的快照， 也可以通过类似的操作来完成。 通过修改文件然后运行 git add 或 git rm 一个已追踪的文件， 随后运行 git commit --amend 拿走当前的暂存区域并使其做为新提交的快照。 使用这个技巧的时候需要小心，因为修正会改变提交的 SHA-1 校验和。 它类似于一个小的衍合 - 如果已经推送了最后一次提交就不要修正它。

Stash未提交的更改

你正在修改某个bug或者某个特性，又突然被要求展示你的工作。而你现在所做的工作还不足以提交，这个阶段你还无法进行展示（不能回到更改之前）。在这种情况下， git stash可以帮助你。 stash在本质上会取走所有的变更并存储它们为以备将来使用。stash你的变更，你只需简单地运行下面的命令-

git stash
希望检查stash列表，你可以运行下面的命令：

git stash list

如果你想要解除stash并且恢复未提交的变更，你可以进行apply stash:

git stash apply
在屏幕截图中，你可以看到每个stash都有一个标识符，一个唯一的号码（尽管在这种情况下我们只有一个stash）。 如果你只想留有余地进行apply stash，你应该给apply添加特定的标识符：

git stash apply stash@{2}
丢弃stash区的内容

git stash drop
如果想应用stash同时丢弃

git stash pop
就相当于先执行git stash apply 再执行 git stash drop

暂存文件的部分改动

一般情况下，创建一个基于特性的提交是比较好的做法 ，意思是每次提交都必须代表一个新特性的产生或者是一个bug的修复。 如果你修复了两个bug，或是添加了多个新特性但是却没有提交这些变化会怎样呢？ 在这种情况下，你可以把这些变化放在一次提交中。但更好的方法是把文件暂存(Stage)然后分别提交。 例如你对一个文件进行了多次修改并且想把他们分别提交。这种情况下，你可以在 add 命令中加上 -p 参数

git add -p [file_name]
我们来演示一下在 file_name 文件中添加了3行文字，但只想提交第一行和第三行。先看一下 git diff 显示的结果：

然后再看看在 add 命令中添加 -p 参数是怎样的？

看上去，Git 假定所有的改变都是针对同一件事情的，因此它把这些都放在了一个块里。你有如下几个选项：

输入 y 来暂存该块

输入 n 不暂存

输入 e 手工编辑该块

输入 d 退出或者转到下一个文件

输入 s 来分割该块

在我们这个例子中，最终是希望分割成更小的部分，然后有选择的添加或者忽略其中一部分。


正如你所看到的，我们添加了第一行和第三行而忽略了第二行。之后你可以查看仓库状态之后并进行提交。

Cherry Pick

我把最优雅的Git命令留到了最后。cherry-pick命令是我目前为止最喜欢的git命令， 既是因为它的字面意思，也因为它的功能。

简而言之，cherry-pick就是从不同的分支中捡出一个单独的commit， 并把它和你当前的分支合并。如果你以并行方式在处理两个或以上分支， 你可能会发现一个在全部分支中都有的bug。如果你在一个分支中解决了它， 你可以使用cherry-pick命令把它commit到其它分支上去，而不会弄乱其他的文件或commit。

让我们来设想一个用得着它的场景。我现在有两个分支，并且我想cherry-pick b20fd14: Cleaned junk 这个commit到另一个上面去。

我切换到想被cherry-pick应用到的这个分支上去，然后运行了如下命令：

git cherry-pick [commit_hash]
git操作远程分支

查看远程分支

$git branch -r
查看所有远程和本地分支

$git branch -a
新增远程分支

$git branch dev  // 先在本地创建分支
$git push origin dev //再推送到远程
删除远程分支和tag

在Git v1.7.0 之后，可以使用这种语法删除远程分支：

$ git push origin --delete <branchName>
删除tag这么用：

git push origin --delete tag <tagname>
否则，可以使用这种语法，推送一个空分支到远程分支，其实就相当于删除远程分支：

git push origin :<branchName>
这是删除tag的方法，推送一个空tag到远程tag：

git tag -d <tagname>
git push origin :refs/tags/<tagname>
两种语法作用完全相同。

删除不存在对应远程分支的本地分支

假设这样一种情况：

我创建了本地分支b1并pull到远程分支 origin/b1；
其他人在本地使用fetch或pull创建了本地的b1分支；
我删除了 origin/b1 远程分支；
其他人再次执行fetch或者pull并不会删除这个他们本地的 b1 分支，运行 git branch -a 也不能看出这个branch被删除了，如何处理？
使用下面的代码查看b1的状态：

$ git remote show origin
* remote origin
  Fetch URL: git@github.com:xxx/xxx.git
  Push  URL: git@github.com:xxx/xxx.git
  HEAD branch: master
  Remote branches:
    master                 tracked
    refs/remotes/origin/b1 stale (use 'git remote prune' to remove)
  Local branch configured for 'git pull':
    master merges with remote master
  Local ref configured for 'git push':
    master pushes to master (up to date)
这时候能够看到b1是stale(污浊，污染）的，使用 git remote prune(剪去) origin 可以将其从本地版本库中去除。
更简单的方法是使用这个命令，它在fetch之后删除掉没有与远程分支对应的本地分支：

git fetch -p
重命名本地分支：

git branch -m devel develop
推送本地分支：

$ git push origin develop
Counting objects: 92, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (48/48), done.
Writing objects: 100% (58/58), 1.38 MiB, done.
Total 58 (delta 34), reused 12 (delta 5)
To git@github.com:zrong/quick-cocos2d-x.git
 * [new branch]      develop -> develop
把本地tag推送到远程

git push --tags
获取远程tag

git fetch origin tag <tagname>
git tag — 标签相关操作

标签可以针对某一时间点的版本做标记，常用于版本发布。

列出标签

$ git tag # 在控制台打印出当前仓库的所有标签
$ git tag -l ‘v0.1.*’ # 搜索符合模式的标签
打标签
git标签分为两种类型：轻量标签和附注标签。轻量标签是指向提交对象的引用，附注标签则是仓库中的一个独立对象。建议使用附注标签。

创建轻量标签

$ git tag v0.1.2-light
创建附注标签

$ git tag -a v0.1.2 -m “0.1.2版本”
创建轻量标签不需要传递参数，直接指定标签名称即可。 创建附注标签时，参数a即annotated的缩写，指定标签类型，后附标签名。参数m指定标签说明，说明信息会保存在标签对象中。

切换到标签 与切换分支命令相同，用git checkout [tagname] 查看标签信息 用git show命令可以查看标签的版本信息：

$ git show v0.1.2
删除标签 误打或需要修改标签时，需要先将标签删除，再打新标签。

$ git tag -d v0.1.2 # 删除标签
参数d即delete的缩写，意为删除其后指定的标签。

给指定的commit打标签 打标签不必要在head之上，也可在之前的版本上打，这需要你知道某个提交对象的校验和（通过git log获取）。

补打标签

$ git tag -a v0.1.1 9fbc3d0
标签发布 通常的git push不会将标签对象提交到git服务器，我们需要进行显式的操作：

$ git push origin v0.1.2 # 将v0.1.2标签提交到git服务器
$ git push origin –tags # 将本地所有标签一次性提交到git服务器
注意：如果想看之前某个标签状态下的文件，可以这样操作

1.git tag   查看当前分支下的标签

2.git  checkout v0.21   此时会指向打v0.21标签时的代码状态，（但现在处于一个空的分支上）
