CheckIn
=======

实验室管理系统的主要功能是人员管理和签到记录，分为C/S和B/S模型。
=======
在C/S端主要是通过自定义通信协议、java socket、线程池等技术进行数据传输，客户端由java swing编写（有一版是采用node-webkit写的客户端，由于在java与node.js交互上卡住所以采用了java版本的客户端）
========
在B/S端则采用流行的javaweb构建技术SSH框架进行后台开发，使用MySQL的数据库，前台展示采用的是UI框架bootstrap，和highchart.js进行图表展示

