#GIT使用
 * 官方地址:<https://git-scm.com/book/zh/v2>
####图形化界面
#####TortoiseGit (由于图形化界面比较简单,这里主要介绍git的ssh配置)
1. 下载安装,官方地址:<https://tortoisegit.org/>
2. ssh配置
3. 开发
#####Git(这里主要介绍git的ssh配置)
1. 检查本地是否有ssh key设置,打开git bash客户端.
 `$ cd ~/.ssh 或cd .ssh`

2. 使用Git Bash生成新的ssh key.
    `$ cd ~  #保证当前路径在”~”下`

    `$ ssh-keygen -t rsa -C "xxxxxx@yy.com"  #建议填写自己真实有效的邮箱地址`

    `Generating public/private rsa key pair.`

    `Enter file in which to save the key (/c/Users/xxxx_000/.ssh/id_rsa):   #不填直接回车`

    `Enter passphrase (empty for no passphrase):   #输入密码（可以为空）`

    `Enter same passphrase again:   #再次确认密码（可以为空）`

    `Your identification has been saved in /c/Users/xxxx_000/.ssh/id_rsa.   #生成的id_rsa文件为密钥`

    `Your public key has been saved in /c/Users/xxxx_000/.ssh/id_rsa.pub.  #生成的id_rsa.pub公钥`

    `The key fingerprint is:e3:51:33:xx:xx:xx:xx:xxx:61:28:83:e2:81 xxxxxx@yy.com`


* 本机已完成ssh key设置，其存放路径为：c:/Users/xxxx_000/.ssh/下。

* 注释：可生成ssh key自定义名称的密钥，默认id_rsa。

* $ ssh-keygen -t rsa -C "邮箱地址" -f ~/.ssh/githug_blog_keys #生成ssh key的名称为githug_blog_keys，慎用容易出现其它异常。

* 添加ssh key到GItHub
`1.登录GitHub账号；点击右上角账号头像的“▼”→Settings→SSH kyes→Add SSH key。`
`2.复制id_rsa.pub的公钥内容。`
`3.进入c:/Users/xxxx_000/.ssh/目录下，打开id_rsa.pub文件，全选复制公钥内容。`
`4.Title自定义，将公钥粘贴到GitHub中Add an SSH key的key输入框，最后“Add Key”。`

* 使用git gui运行命令,语法和参考本文开始的官方地址

至此,已经完成了git生成和配置ssh(嫌麻烦直接用图形界面工具==>[TortoiseGit](https://tortoisegit.org/))


