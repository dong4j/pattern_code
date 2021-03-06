# 工厂方法模式

#### 每天一个 Linux 命令
**cat**

cat命令连接文件并打印到标准输出设备上，cat经常用来显示文件的内容，类似于下的type命令。

```
-n或-number：有1开始对所有输出的行数编号；

-b或--number-nonblank：和-n相似，只不过对于空白行不编号；

-s或--squeeze-blank：当遇到有连续两行以上的空白行，就代换为一行的空白行；

-A：显示不可打印字符，行尾显示“$”；

-e：等价于"-vE"选项；

-t：等价于"-vT"选项；
```

```
cat file1  # 显示 文件 file1 中的内容
cat file1 file2 # 同时显示 file1 和 file2 的内容
cat file1 file2 > file # 将文件 file1和 file2 合并和放入 file 中
```

# 回顾 简单工厂模式

优点:

1. 将创建和使用分离, 遵循单一原则
2. 引入配置文件, 遵循开闭原则
3. 使用别名代替复杂的类名, 简化代码

缺点:

1. 如果要添加新的产品类时, 必须修改工厂类逻辑, 不方便扩展
2. 引入过多的类,造成结构复杂,难于理解

关键代码:

```java
public static 产品类父类 create(String type){
        switch (type) {
                case "具体产品类1标识" :
                        return new 具体产品类1();
                case "具体产品类2标识" :
                        return new 具体产品类2();   
                .....   
        }
}
```

例子:
> 使用简单工厂模式设计一个可以创建不同几何形状（如圆形、方形和三角形等）的绘图工具，每个几何图形都具有绘制 draw() 和擦除 erase() 两个方法，要求在绘制不支持的几何图形时，提示一个 UnSupportedShapeException。

![](http://7xr3bu.com1.z0.glb.clouddn.com/2017-01-19-14847949515193.png)
使用简化的简单工厂模式,即将静态工厂放入到父类中.

代码:

图形父类

```java
public class Graphics {
     public void draw(){
         System.out.println("画图方法");
     }
     public void erase(){
         System.out.println("擦除方法");
     }

     public static Graphics createGraphics(String type) throws UnSupportedShapeException {
         switch (type){
             case "rot" :
                 return new Rotundity();
             case "squ" :
                 return new Squareness();
             case "tri" :
                 return new Trigon();
             default :
                 throw new UnSupportedShapeException();
         }
     }
}
```

具体图形类

```java
class Rotundity extends Graphics {
    @Override
    public void draw(){
        System.out.println("画圆");
    }

    @Override
    public void erase(){
        System.out.println("擦除圆形");
    }
}

class Squareness extends Graphics {
    @Override
    public void draw(){
        System.out.println("画方形");
    }

    @Override
    public void erase(){
        System.out.println("擦除方形");
    }
}

class Trigon extends Graphics {
    @Override
    public void draw(){
        System.out.println("画三角形");
    }

    @Override
    public void erase(){
        System.out.println("擦除三角形");
    }
}
```

异常类

```java
public class UnSupportedShapeException extends Exception{
    public UnSupportedShapeException(){
        super("不支持的图形");
    }
}
```

config 配置

```
type=tri
```

测试类

```java
@Test
    public void graphicsTest() throws UnSupportedShapeException {
        String type = ConfigUtil.getType("type");
        Graphics graphics = Graphics.createGraphics(type);
        graphics.draw();
        graphics.erase();
    }
```

生活中的例子:

银行办理业务, 比如开户, 挂失, 补办等
我只要给大堂经理说我需要办理的业务(具体产品), 然后填写相应的信息(初始化具体产品的信息),
然后就可以开始办理(使用具体产品).
如果银行不支持我办理的业务,比如说我要办小学入学代缴费,就只有等待银行向上级反映,做好相关工作后支持这项业务后才能使用.

# 创建者模式之二: 工厂方法模式

使用简单工厂最大的一个缺点就是新增具体产品时, 必须修改静态工厂,违背了开闭原则.
**如果实现增加新产品时不影响原来的代码?**

抽象出一个工厂接口,里面有一个创建具体产品的方法, 然后让具体工厂实现这个接口, 使用具体产品时, new 一个对应的工厂获取具体产品(或者使用配置文件)

> 定义一个用于创建对象的接口, 让子类决定实例化哪一个类. 工厂方法使一个类的实例化延迟到其子类.

![](http://7xr3bu.com1.z0.glb.clouddn.com/2017-01-20-14849159502467.png)

- 抽象工厂: 申明了工厂方法,用于返回一个产品.所有的具体工厂类都要事先这个接口
- 具体工厂: 是抽象工厂的子类,实现了工厂方法,并由客户端调用,返回一个具体产品类实例.
- 抽象产品: 所有产品类的父类
- 具体产品: 实现了抽象产品类, 和具体工厂一一对应

与简单工厂相比,工厂方法引入了抽象工厂,抽象工厂可以是接口,抽象类或者具体类.

```java
interface Factory{
        public Product createProduct();
}
```

具体工厂实现抽象工厂, 产生对应的具体产品实例. 

```java
class ConcteteFactory implements Factory{
        public Product createProduct(){
                return new ConcreteProduct();
        }
}
```

在客户端只需要关心工厂类即可

```java
Factory factory = new ConcreteFactory(); // 可通过配置文件实现
Product product = factory.createProduct();
```

## 案例

记录 log 的方式现在有2种,一种是写入文件, 一种是写入数据库

![](http://7xr3bu.com1.z0.glb.clouddn.com/2017-01-20-14849159693824.jpg)


代码:

抽象工厂接口

```java
public interface LoggerFactory {
    public Logger createLogger();
}
```

具体工厂类

```java
class DatabaseLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}

class FileLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
```

抽象产品类

```java
public interface Logger {
    void writeLog();
}
```

具体产品类

```java
class FileLogger implements Logger{
    @Override
    public void writeLog(){
        System.out.println("将日志写入文件");
    }
}
class DatabaseLogger implements Logger{
    @Override
    public void writeLog(){
        System.out.println("将日志写入数据库");
    }
}
```

通过配置文件获取具体产品工厂

```java
public class ConfigUtil {
    public static Object getType(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        try {
            // config.properties 必须放在 classpath 路径下才能加载.
            properties.load(ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class obj = Class.forName(properties.getProperty(type));
        return obj.newInstance();
    }
}
```

测试类

```java
public class FactoryTest {
    @Test
    public void factoryTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        LoggerFactory loggerFactory = (LoggerFactory)ConfigUtil.getType("loggerType");
        Logger logger = loggerFactory.createLogger();
        logger.writeLog();
    }
}
```

添加新的日志记录方式的步骤:

1. 让新的日志记录类继承抽象日志记录器类 Logger;
2. 添加一个对应的具体工厂类,继承抽象日志记录工厂 LoggerFactory, 并实现其中的工厂方法 createLogger();
3. 修改 config.properties, 将原来的全类名修改为新的全类名
4. 编译新增的两个类,原来的代码不做任何修改, 运行测试类即可.

通过工厂模式使得系统更加灵活, 新增产品时只需要添加两个类即可,不需要修改原有代码.

## 简化工厂模式
将抽象工厂接口改为抽象类 

```java
public abstract class LoggerFactory {
    public abstract Logger createLogger();

    // 在工厂类中直接调用日志记录器类的业务方法 writeLogger()
    public void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }
}
```

## 总结

工厂方法是简单工厂的延伸, 修复了简单工厂添加新产品时必须修改源代码的问题

**优点:**

1. 使用具体工厂类创建对应的产品, 想客户端隐藏了具体实现, 用户只需要关系所需的产品即可,甚至不需要知道产品类名.
2. 增加新产品时, 只需要添加一个具体工厂类和一个具体产品类, 无需修改原来的代码, 使系统更具扩展性.

**缺点:**

1. 因为具体产品类和具体工厂类要一一对应, 所以增加了类的个数, 给系统造成了一定的复杂度.
2. 为了更好的遵循开闭原则,使用配置文件,反射,增加了系统复杂度

**适用场景**

在以下情况下可以考虑使用工厂方法模式：

1. 客户端不知道它所需要的对象的类。在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所 对应的工厂即可，具体的产品对象由具体工厂类创建，可将具体工厂类的类名存储在配置文件或数据库中。

2. 抽象工厂类通过其子类来指定创建哪个对象。在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的 接口，而由其子类来确定具体要创建的对象，利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象 将覆盖父类对象，从而使得系统更容易扩展。

## 引用

http://blog.csdn.net/lovelion/article/details/9306457

http://blog.csdn.net/lovelion/article/details/9306745

http://blog.csdn.net/lovelion/article/details/9307137

http://blog.csdn.net/lovelion/article/details/9307561


