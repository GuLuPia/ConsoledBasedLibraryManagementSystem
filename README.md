### 报错：git@github.com permission denied (public key). fatal could not read from remote repository
### 解决办法：https://zhuanlan.zhihu.com/p/454666519



ContentItem(String contentType, String name, String author, String doi, String location, String publisher, boolean isAvailable) 

contentType: Book, Journal article, Conference paper

完成了功能
- 用户鉴权-登录注册
- 书籍的借阅和归还
- 主终端的显示
- 异常的处理
  添加sql文件和Maven环境
  修改ReadMe文件和Book文件,保留了全部功能

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



## full factory method + builder说明:
1. Content is an interface that outlines standard methods for any type of content. It includes methods to get the name, author, location, publisher, contentType, doi, isAvailable.
2. ContentBuilder(等于contentFactory) is an abstract class that provides a common skeleton for building any specific type of content.
   It includes builder methods for setting name, author, location, publisher, etc.
3. Book, JournalArticle, and ConferencePaper are concrete implementations of the Content interface. Each class includes a builder class (a subclass) that extends ContentBuilder.
4. 理想范例：


    // 使用建造者模式创建 Book 对象
    Book book = Book.builder()
                .id(1)
                .contentType("Book")
                .name("Death Note")
                .author("Yakami")
                .doi("1234567890")
                .location("Library A")
                .publisher("L")
                .isAvailable(true)
                .build();
    
    System.out.println(book.toString());
    
    // 测试 Content 接口方法
    System.out.println("Content Type: " + book.getContentType());
    System.out.println("Name: " + book.getName());
    //...略
