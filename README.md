eclise（android官方下载的ADT）中导入工程的步骤（**与常规的maven工程略有不同**）。

1. 在ADT上安装m2e插件，插件地址：http://download.eclipse.org/technology/m2e/releases

2. 安装Marketplace Client：

    Help-Install New Software...-下拉选择Juno...-General Purpose Tools-Marketplace Client-安装过程...，记得重启ADT。
    ![juno](http://bwlsq.img38.wal8.com/img38/394592_20131215155111/138709414926.jpg)
    ![general purpose tools](http://bwlsq.img38.wal8.com/img38/394592_20131215155111/138709414857.jpg)
    ![marketplace client](http://bwlsq.img38.wal8.com/img38/394592_20131215155111/138709414974.jpg)

3. 安装android Configurator：

    Help-Eclipse Marketplace-输入android m2e搜索，选择
    ![android configurator](http://bwlsq.img38.wal8.com/img38/394592_20131215155111/13870949132.jpg)

4. 设置环境变量ANDROID_HOME（即sdk那个目录，sdk要有level 10和16版本）

5. 使用**maven3.0.5（一定要这个版本）**版本编译下工程（主要为了将相关的jar包下下来），**不要使用mvn eclipse:eclipse**来生成eclipse工程，它不能很好的处理gen源文件目录。

6. import 工程到ADT。import-**Maven**-**Existing Maven Projects**，不能选android project，也不是General中的project。