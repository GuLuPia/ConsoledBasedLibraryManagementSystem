### 报错：git@github.com permission denied (public key). fatal could not read from remote repository
### 解决办法：https://zhuanlan.zhihu.com/p/454666519


# Content

ContentItem(String contentType, String name, String author, String doi, String location, String publisher, boolean isAvailable) 

contentType: Book, Journal article, Conference paper

sql文件夹: sql文件 <br>
Service文件夹(刨除exception和impl): 用户鉴权 和 借书还书 相关方法及注释<br>
Main: 终端启动主方法<br>
DatabaseSeeder: 数据库插入测试数据<br>

登录数据库时:
```xml
<dataSource type="POOLED">
    <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/book?useSSL=false&amp;serverTimezone=UTC"/>
    <property name="username" value="root"/>
    <property name="password" value="lmq1226lmq"/>
</dataSource>
```
修改其中的`localhost:3306/book`为`localhost:3306/your_database`
修改其中的`root`,`lmq1226lmq`为数据库账户密码

