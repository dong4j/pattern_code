# 抽象工厂模式

#### 每天一个 Linux 命令
**more 命令**

more 命令是一个基于 vi 编辑器文本过滤器，它以全屏幕的方式按页显示文本文件的内容，支持 vi 中的关键字定位操作。

```
按 空格 键：显示文本的下一屏内容。
按 回车 键：只显示文本的下一行内容。
/：接着输入一个模式，可以在文本中寻找下一个相匹配的模式。
按 h 键：显示帮助屏，该屏上有相关的帮助信息。
按 b 键：显示上一屏内容。
按 q 键：退出 rnore 命令
```

```
-<数字>：指定每屏显示的行数；

-d：显示“[press space to continue,'q' to quit.]”和“[Press 'h' for instructions]”；

-c：不进行滚屏操作。每次刷新这个屏幕；

-s：将多个空行压缩成一行显示；

-u：禁止下划线；

+<数字>：从指定数字的行开始显示。

```

```
# 显示文件 file 的内容，但在显示之前先清屏，并且在屏幕的最下方显示完核的百分比。
more -dc file
# 显示文件 file 的内容，每 10 行显示一次，而且在显示之前先清屏。
more -c -10 file
```

## 工厂方法回顾
工厂方式通过引入工厂等级结构, 解决了简单工厂模式中工厂类责任太重的问题, 当由于工厂方法模式中的每一个工厂只生产一类产品,可能导致系统中存在大量的工厂类,增加了系统的开销.

**优点:**

1. 增加具体产品时不需要修改原来的代码, 只需要增加一个具体工厂类和一个具体产品类即可, 是系统易于扩展.

**缺点:**
	
1. 由于内个具体工厂只能生产出一个具体产品, 增加了类的个数, 增加了系统开销.
	
**练习**

>使用工厂方法模式设计一个程序来读取各种不同类型的图片格式，针对每一种图片格式都设计一个图片读取器，如 GIF 图片读取器用于读取 GIF 格式的图片、JPG 图片读取器用于读取 JPG 格式的图片。需充分考虑系统的灵活性和可扩展性。

![](http://7xr3bu.com1.z0.glb.clouddn.com/2017-01-20-14849160779713.png)


代码:

抽象工厂接口

```java
public interface PictureFactory {
    public Picture getPicture();
}
```

具体工厂类

```java
class GifPictureFactory implements PictureFactory{
    @Override
    public Picture getPicture() {
        return new GifPicture();
    }
}
class JpgPictureFactory implements PictureFactory {
    @Override
    public Picture getPicture() {
        return new JpgPicture();
    }
}
```

抽象产品 

```java
public interface Picture {
    void readInfo();
}
```

具体产品类

```java
class GifPicture implements Picture{
    @Override
    public void readInfo(){
        System.out.println("读取 gif 图片信息");
    }
}

class JpgPicture implements Picture{
    @Override
    public void readInfo(){
        System.out.println("读取 jpg 图片信息");
    }
}
```

测试类

```java
@Test
    public void homeworkTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        PictureFactory pictureFactory = (PictureFactory) ConfigUtil.getType("pictureType");
        pictureFactory.getPicture().readInfo();
    }
```

# 创建者模式之三: 抽象工厂模式

## 案例

> 开发一套界面皮肤库，可以对 Java 桌面软件进行界面美化。为了保护版权，该皮肤库源代码不打算公开，而只向用户提供已打包为 jar 文件的 class 字节码文件。用户在使用时可以通过菜单来选择皮肤，不同的皮肤将提供视觉效果不同的按钮、文本框、组合框等界面元素

![](http://7xr3bu.com1.z0.glb.clouddn.com/2017-01-20-14849136638776.png)

使用工厂方法模式 UML 结构

![](http://7xr3bu.com1.z0.glb.clouddn.com/2017-01-20-14849162919706.png)



使用工厂方法模板存在的问题:

1. 如果需要添加具体组件时, 都需要添加一个具体工厂, 类的个数增大.
2. 由于统一风格的具体界面组件需要一起显示, 如果某个具体工厂选择出错将导致界面混乱.
3. 客户端和配置文件复杂.

如何减少类的个数和保证每次初始化时只是用一种风格的具体界面的组件?
是用抽象工厂模式解决.

## 抽象工厂模式

抽象工厂提个一个创建一系列相关或相互依赖对象的接口, 而无需指定他们具体的类. 

![](http://7xr3bu.com1.z0.glb.clouddn.com/2017-01-20-14849165531553.png)

- AbstractFactory 抽象工厂 : 声明了一组用于创建同一类产品的方法,每个方法对应一种产品.
- ConcreteFactory 具体工厂 : 实现了抽象工厂中声明的创建产品的方法,, 生产一组具体的产品.
- AbstractProduct 抽象产品 : 每种产品的接口
- ConcreteProduct 具体产品 : 具体工厂生产的具体产品, 实现了抽象产品中的声明的业务方法.

### 使用抽象方法模式实现案例

![](http://7xr3bu.com1.z0.glb.clouddn.com/2017-01-20-14849178677023.png)

代码

皮肤抽象工厂接口

```java
public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    Combobox createCombobox();
}
```

Spring 风格皮肤工厂实现

```java
public class SpringSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public Combobox createCombobox() {
        return new SpringCombobox();
    }
}
```

Summer 风格皮肤工厂实现

```java
public class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public Combobox createCombobox() {
        return new SummerCombobox();
    }
}
```

删个控件接口

```java
public interface Button {
    void display();
}

public interface Combobox {
    void display();
}

public interface TextField {
    void display();
}
```

Spring 风格系列控件实现

```java
public class SpringButton implements Button{
    @Override
    public void display() {
        System.out.println("spring 风格按钮");
    }
}

public class SpringCombobox implements Combobox{
    @Override
    public void display() {
        System.out.println("spring 风格下拉列表框");
    }
}

public class SpringTextField implements TextField{
    @Override
    public void display() {
        System.out.println("spring 风格文本输入框");
    }
}
```

Summer 风格系列控件实现

```java
public class SummerButton implements Button{
    @Override
    public void display() {
        System.out.println("summer 风格按钮");
    }
}

public class SummerCombobox implements Combobox{
    @Override
    public void display() {
        System.out.println("summer 风格下拉列表框");
    }
}

public class SummerTextField implements TextField{
    @Override
    public void display() {
        System.out.println("summer 风格文本输入框");
    }
}
```

配置文件

```
skinType=com.dong4j.factory.SpringSkinFactory
```

测试代码

```java
public class AbstractFactoryTest {
    @Test
    public void abstractFactoryTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // 使用抽象层定义
        SkinFactory factory;
        Button      bt;
        TextField   tf;
        Combobox    cb;
        factory = (SkinFactory) ConfigUtil.getType("skinType");
        bt = factory.createButton();
        tf = factory.createTextField();
        cb = factory.createCombobox();
        bt.display();
        tf.display();
        cb.display();
    }
}
```

1. 如果需要增加新的皮肤，只需要添加一个皮肤工厂,然后添加组件的实现即可，修改配置文件即可使用新的皮肤，原有代码无须修改，符合 “开闭原则”。

2. 如果需要增加新的控件, 需要修改抽象工厂, 添加一个组件抽象接口, 然后添加两种风格的实现, 还要修改皮肤具体工厂.

## 总结

**优点:**

1. 抽象工厂模式隔离了具体类的生成, 使得客户不需要知道什么被创建.由于隔离性,是的更换一个具体工厂变得容易, 所以的具体工厂都实现了抽象工厂的定义的方法, 因此只需要改变具体工厂的实例,就可以某种程度上改变整个软件系统的行为.
2. 当一个产品族中的多个对象被设计成一起工作时,它能保证客户端始终只使用同一个产品族中的对象.
3. 增加新的产品族很方便,符合开闭原则.

**缺点:**

1. 增加新的产品登记结构需要修改众多代码,违背开闭原则.

** 适用场景**

1. 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是很重要的，用户无须关心对象的创建过程，将对象的创建和使用解耦。
2. 系统中有多于一个的产品族，而每次只使用其中某一产品族。可以通过配置文件等方式来使得用户可以动态改变产品族，也可以很方便地增加新的产品族。
3. 属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来。同一个产品族中的产品可以是没有任何关系的对象，但是它们都具有一些共同的约束，如同一操作系统下的按钮和文本框，按钮与文本框之间没有直接关系，但它们都是属于某一操作系统的，此时具有一个共同的约束条件：操作系统的类型。
4. 产品等级结构稳定，设计完成之后，不会向系统中增加新的产品等级结构或者删除已有的产品等级结构。


## 引用

http://blog.csdn.net/lovelion/article/details/9319181

http://blog.csdn.net/lovelion/article/details/9319323

http://blog.csdn.net/lovelion/article/details/9319423

http://blog.csdn.net/lovelion/article/details/9319481

http://blog.csdn.net/lovelion/article/details/9319571





