
> 栈管运行，堆管存储


## java代码执行流程
1. 编译（前端编译，与执行引擎中的编译成热点代码（后端编译）形成区分），形成字节码文件
2. 字节码文件运行在jvm之上

![Java代码执行流程图](assets/image/java代码执行流程.png)

## jvm的架构模型
> 一种是基于栈的指令集架构（Hotspot），另一种是基于寄存器的指令集架构。
> 基于栈的指令集架构以零地址为主，基于寄存器的指令集架构都以一地址指令，二地址指令，三地址指令为主
>
> .class文件反编译的命令为 javap -v xxx.class
> 
>  jps 查看执行中的进程

## 内存结构
### 概述
> 如果自己手写一个java虚拟机的话，主要考虑哪些结构呢？类加载器和执行引擎
>

![内存结构概述](assets/image/内存结构概述.jpg)

### 类加载器子系统
> 负责从文件系统或者网络中加载Class文件
> 加载的类信息放在一块称为方法区的内存空间。
> 除了类的信息外，方法区还会存放运行时常量池信息，可能还包括字符串字面量和数字常量（这部分常量信息是Class文件中常量池部分的内存映射）

### 类的加载过程(loading)
1. 通过一个类的全限定名获取定义此类的二进制字节流
2. 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
3. 在内存中成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口

### 类的加载过程(Linking)
> 验证，准备，解析
> final修饰的static,在编译的时候就会分配
> 解析：将常量池的符号引用转换为直接引用的过程
> jclasslib bytecode viewer, 打开字节码文件，可以安装idea插件，打开字节码文件
> binary Viewer, 查看字节码文件，HxD 也可以查看字节码文件

### 类的加载过程(Initialization)
- 初始化阶段就是执行类构造器方法&lt;clinit>()的过程
-  &lt;clinit>()不同于类的构造器（关联：构造器是虚拟机视角下的&lt;init>()）
- 此方法不需定义，是javac编译器自动收集类中的所有类变量的赋值动作和静态代码块中的语句合并而来
- 构造器方法中指令按语句在源文件中出现的顺序执行
- 若该类具有父类，jvm会保证子类的&lt;clinit>()执行前，父类的&lt;clinit>()已经执行完毕
- 虚拟机必须保证一个类的&lt;clinit>()方法在多线程下被同步加锁

### 类加载器的分类
![类加载器的分类](assets/image/类加载器的分类.jpg)
> 上图四者之间的关系是包含关系。不是上层下层，也不是子父类的继承关系。
> jvm支持两种类型的类加载器，分别为引导类加载器（Bootstrap ClassLoader）和自定义类加载器（User-Defined ClassLoader）
> 将所有派生于抽象类ClassLoader 的类加载器都划分为自定义类加载器
> ctrl+H 查看类的继承关系

#### 启动类加载器（引导类加载器，Bootstrap ClassLoader）
  - 这个类加载使用c/c++语言实现的，嵌套在JVM内部
  - 并不继承自java.lang,ClassLoader,没有父加载器
  - 加载扩展类和应用程序类加载器，并指定为他们的父类加载器
  - 出于安全考虑，Bootstrap启动类加载器只加载包名为java,javax,sun等开头的类
#### 扩展类加载器（Extension ClassLoader）
  - 从java.ext.dirs系统属性所指定的目录中加载类库，或从JDK的安装目录的jre/lib/ext 子目录下加载类库。如果用户创建的JAR放在此目录下，也会自动由扩展类加载器加载。
#### 应用程序类加载器（系统类加载器，AppClassLoader）
  - 负责加载环境变量classpath或系统属性 java.class.path 指定路径下的类库
  - 该类加载是程序中默认的类加载器，一般来说，java应用的类都是由塔来完成加载
  - 通过ClassLoader#getSystemClassLoader()方法可以获取到该类加载器
#### 用户自定义类加载器
  - 为什么要自定义类加载器？
    - 隔离加载类（类冲突，做类的仲裁）
    - 修改类加载的方式
    - 扩展加载源
    - 防止源码泄露（对字节码文件加解密）
  - 开发人员可以通过继承抽象类java.lang.ClassLoader类的方式，实现自己的类加载器，以满足一些特殊的需求
  - 如果没有太过于复杂的需求，可以直接继承URLClassLoader类，这样就可以避免自己去编写findClass()方法及其获取字节码流的方式，使自定义类加载器编写更加简洁
#### 关于ClassLoader
> ClassLoader类，它是一个抽象类，其后所有的类加载器都继承自ClassLoader（不包括启动类加载器）
> sun.misc.Launcher 它是java虚拟机的入口应用
##### 获取ClassLoader的途径
1. 获取当前类的ClassLoader: clazz.getClassLoader()
2. 获取当前线程上下文的ClassLoader：Thread.currentThread().getContextClassLoader()
3. 获取系统的ClassLoader: ClassLoader.getSystemClassLoader()
4. 获取调用者的ClassLoader:DriverManager.getCallerClassLoader()
