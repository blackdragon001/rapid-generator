目的：该生成器只是生成骨架代码，减少大量的ctrl+c,ctrl+v的工作量。

使用方法：
1.启动cn.org.rapid_framework.generator.ext.CommandLine.main(String[])
2.在命令行中输入 gen [库表名称]
3.代码生成器自动生成 Controller、service、mapper、entity、mapper.xml的骨架代码
4.该生成器会定期维护
  1） 添加新的通用方法
  2）响应架构的调整
  
  
--------------------------------P.S--------------------------------------------
各位，新增了一个代码生成工具，能够根据mysql库表生成Controller、service、entity、mapper和xml文件。
代码的结构和风格参考的胡国兵的user模块。后续还会根据新的架构的变化和功能会继续维护。
目的：该生成器只是生成骨架代码，减少大量的ctrl+c,ctrl+v的工作量。

项目地址：
https://github.com/blackdragon001/rapid-generator.git
github的账号和密码
dragon0423@126.com
dragon18141533

使用方式：
ide中启动CommandLine.main(String[])后输入gen [库表名称]即可