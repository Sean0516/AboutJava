ClassLoader 的作用主要是用来加载Class的，它负责将Class的字节码形式转换为内存形式的Class 对象。字节码本质就是一个字节数组 byte[] ，它有特定的内部格式。每个class 对象的内部都有一个ClassLoader 字段来标识自己是由那个Class Loader 加载的， ClassLoader 就像一个容器，里面装了很多已经加载的class 对象

### 不同种类的ClassLoader
JVM 运行实例中会存在多个ClassLoader ，不同的ClassLoader 会从不同的地方加载字节码文件，它可以从不同的文件目录加载，也可以从不同的jar 文件中加载，也可以从网络不同的静态文件服务器上下载字节码再加载
JVM 中内置了三个重要的ClassLoader  ，分别是 BootStrapClassLoader  ，ExtensionClassLoader  ， AppClassLoader 和URLClassLoader

##### BootStrapClassLoader  
BootStrapClassLoader负责加载JVM 运行时核心类，这些类位于 JAVA_HOME/lib/rt.jar文件中，我们常用的内置库 java.xxx 如  Java.util java.io 等，这个classloader 比较特殊，它是由C 代码实现，我们将他称为 根加载器
##### ExtensionClassLoader   
ExtensionClassLoader负责加载 JVM 扩展类， 比如swing ，内置的js 引擎，xml 解析器等，这些库名通常以java x 开头，他们的jar 包位于  JAVA_HOME/lib/ext/*.jar  中
##### AppClassLoader 
AppClassLoader 才是直接面对用户的加载器，它会加载Classpath 环境变量里定义的路径中的jar包和目录，我们自己编写的代码和使用的第三方jar 通常都是由它来加载的
##### URLClassLoader
对于位于网络上静态文件服务器提高的jar  包和class 文件，jdk 内置了一个URLClassLoader 。用户只需要传递规范的网络路径给构造器，就可以使用URLClassLoader来加载远程类库， URLClassLoader 不但可以加载远程类库，还可以加载本地路径的类库， 取决于构造器中不同的队长， Extensionclassloade 和AppClassLoader都是URLClassLoader 的子类，他们都是从本地文件系统里加载类库

### 双亲委派
前面提到AppClassLoader只负责加载classpath下的类库，如果遇到没有加载的系统类库，AppClassLoader 必须将系统类库的加载工作交给BootStrapClassLoader和ExtensionClassLoader来做，这就是我们常说的双亲委派

当AppClassLoader再加载一个未知的类名时，它并不是立即去搜寻classpath ，它会首先将这个类名称交给ExtensionClassLoader来加载，如果ExtensionClassLoader可以加载，那么app 就不用麻烦，否则他会搜索class path

当 ExtensionClassLoader在加载一个未知类名时，它也不是立即搜寻ext 路径，而是将类名交给 BootStrapClassLoader 来加载，如果BootStrapClassLoader 可以加载，那么ExtensionClassLoader就不用麻烦

这三个ClassLoader形成了级联的父子关系，每个ClassLoader尽量将工作交给父亲做，当父亲干不了才会自己做

双亲委派模型 保证了Java程序的稳定运行，可以避免类的重复加载（JVM 区分不同类的方式并不仅仅根据类名。相同的类文件被不同的类加载器加载产生的两个不同的类） 也保证了Java的核心api 不被篡改
