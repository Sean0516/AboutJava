OOP 面向对象

1. 类和对象的关系

   类是对象的抽象，对象是类的具体，类是对象的模板，对象是类的实例

2. Java中的数据类型

   整形：byte,short,int,long

   浮点型：float,double
   字符型：char
   布尔型：boolean

   | 类型    | 字节,位数   | 最小值           |               最大值 | 默认值 | 描述                                                         |
   | :------ | ----------- | ---------------- | -------------------: | ------ | ------------------------------------------------------------ |
   | byte    | 1，8        | -2^7             |                2^7-1 | 0      | byte 类型用在大型数组中节约空间，主要代替整数，因为byte 变量占用的空间只有int 类型的四分之一 |
   | short   | 2，16       | -2^15            |               2^15-1 | 0      | short 也可以像byte那样节省空间，一个short变量是int型变量所占空间的二分之一 |
   | Int     | 4，32       | -2^31            |               2^31-1 | 0      |                                                              |
   | long    | 8，64       | -2^63            |               2^63-1 | 0L     | Java 里使用 long 类型的数据一定要在数值后面加上 L，否则将作为整型解析 |
   | float   | 4，32       |                  |                      | 0.0f   | 单精度数据类型。 不能用来表示精确的值。如货币                |
   | double  | 8，64       |                  |                      | 0.0d   | 双精度 ，不能表示精确的值                                    |
   | char    | 2，16       | \u0000（即为 0） | \uffff（即为 65535） |        | char 数据类型可以存储任何字符                                |
   | boolean | true，false |                  |                      | false  | 这种类型只作为一种标志来记录 true/false 情况                 |

   

3. instanceof 关键字的作用

   instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例，用法为

   ```java
   boolean result = obj instanceof Class
   ```

4. 什么是隐式转换，什么是显式转换

   显示转换就是类型强转，把一个大类型的数据强制赋值给小类型的数据；隐式转换就是大范围的变量能够接受小范围的数据；隐式转换和显
   式转换其实就是自动类型转换和强制类型转换

5. 什么是自动拆箱装箱

   装箱就是自动将基本数据类型转换为包装器类型 （int-->Integer）   new Integer(6); ，底层调用: Integer.valueOf(6)

   拆箱 将包装类型转换为基本类型 （Integer-> int ）int i = new Integer(6); ，底层调用 i.intValue(); 方法实现。

   ###### 区别：

   1. 声明方式不同  基本类型不使用new关键字，而包装类型需要使用new关键字来**在堆中分配存储空间**
   2. 存储方式及位置不同：基本类型是直接将变量值存储在栈中，而包装类型是将对象放在堆中，然后通过引用来使用
   3. 初始值不同：基本类型的初始值如int为0，boolean为false，而包装类型的初始值为null
   4. 使用方式不同：基本类型直接赋值直接使用就好，而包装类型在集合如Collection、Map时会使用到

   

   ```
   public class Main {
   public static void main(String[] args) {
       Integer i1 = 100;
       Integer i2 = 100;
       Integer i3 = 200;
       Integer i4 = 200;
       System.out.println(i1==i2); true
       System.out.println(i3==i4); false  |  equals  为 true
   }
   }
   ```

6. 为什么要有包装类型

   为了让基本类型也具有对象的特征，也就出现了包装类型。

   

7. 一个java 类中包含那些内容

   属性、方法、内部类、构造方法、代码块

8. String 是最基本的数据类型吗？

   不是。Java 中的基本数据类型只有 8 个：byte、short、int、long、float、double、 char、boolean；除了基本类型（primitive type），剩下的都是引用类型（reference type），Java 5 以后引入的枚举类型也算是一种比较特殊的引用类型

9. float f=3.4;是否正确 ？

   不正确。3.4 是双精度数，将双精度型（double）赋值给浮点型（float）属于 下转型（down-casting，也称为窄化）会造成精度损失，因此需要强制类型转换 float f =(float)3.4; 或者写成 float f =3.4F

10. short s1 = 1; s1 = s1 + 1;有错吗?short s1 = 1; s1 += 1; 有错吗？

   对于 short s1 = 1; s1 = s1 + 1;由于 1 是 int 类型，因此 s1+1 运算结果也是 int 型，需要强制转换类型才能赋值给 short 型。而 short s1 =1; s1 += 1;可以正确 编译，因为 s1+= 1;相当于 s1 = (short)(s1 + 1);其中有隐含的强制类型转换

11. 重载和重写的区别

    重写：

    在子类中把父类本身有的方法重新写一遍。子类继承了父类原有的方法，但有时子类并不想原封不动的继承父类中的某个方法，所以在方法名，参数列表，返回类型(除过子类中方法的返回值是父类中方法返回值的子类时)都相同的情况下， 对方法体进行修改或重写，这就是重写。但要注意子类函数的访问修饰权限不能少于父类的

    重载：

    在一个类中，同名的方法如果有不同的参数列表（参数类型不同、参数个数不同甚至是参数顺序不同）则视为重载。同时，重载对返回类型没有要求，可以相同也可以不同，但不能通过返回类型是否相同来判断重载

12. equals与==的区别

    - ==：

      == 比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。

      1. 比较的是操作符两端的操作数是否是同一个对象
      2. 两边的操作数必须是同一类型的（可以是父子类之间）才能编译通过
      3. 比较的是地址，如果是具体的阿拉伯数字的比较，值相等则为true，如：int a=10 与 long b=10L 与 double c=10.0都是相同的（为true），因为他们都指向地址为10的堆

    - equals

      equals用来比较的是两个对象的内容是否相等，由于所有的类都是继承自java.lang.Object类的，所以适用于所有对象，如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法，而Object中的equals方法返回的却是==的判断

    - 总结

      所有比较是否相等时，都是用equals 并且在对常量相比较时，把常量写在前面，因为使用object的equals object可能为null 则空指针

    

13. ++i  和 i++ 的区别

    i++ ： 先赋值，后计算

    ++i : 先计算，后赋值

14. 数组实例化有几种方式

    - 静态实例化。 在创建数组的时候，指定数组中的元素
    - 动态实例化， 实例会数组的时候，只指定数组的长度，数组中所有的元素都是数组类型的默认值

15. Java 中各种数据默认值

    - Byte,short,int,long默认是都是0
    - Boolean默认值是false
    - Char类型的默认值是’’
    - Float与double类型的默认是0.0
    - 对象类型的默认值是null

16. java中有没有指针？

    有指针，但是隐藏了，开发人员无法直接操作指针，由jvm来操作指针

17. java中是值传递引用传递

    理论上说，java都是引用传递，对于基本数据类型，传递是值的副本，而不是值本身。对于对象类型，传递是对象的引用，当在一个方法操作操作参数的时候，其实操作的是引用所指向的对象

18. 形参和实参的区别

19. 构造方法能不能显式调用

    不能，构造方法当成普通方法调用，只有在创建对象的时候他才会被系统调用

20. 内部类

    ###### 定义：

    将一个类定义在另一个类里面或者一个方法里面，这样的类称为内部类

    ###### 内部类的作用

    1. 成员内部类 

       成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。 当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员

    2. 局部内部类

       局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内

    3. 匿名内部类

       匿名内部类就是没有名字的内部类

    4. 静态内部类

       指被声明为static的内部类，他可以不依赖内部类而实例，而通常的内部类需要实例化外部类，从而实例化。静态内部类不可以有与外部类有相同的类名。不能访问外部类的普通成员变量，但是可以访问静态成员变量和静态方法（包括私有类型） 一个 静态内部类去掉static 就是成员内部类，他可以自由的引用外部类的属性和方法，无论是静态还是非静态。但是不可以有静态属性和方法

       

21. 内部类和静态内部类的区别

    - 静态内部类

      1. 静态内部类相对与外部类是独立存在的，在静态内部类中无法直接访问外部类中变量，方法。 如果要访问的化，需要new 一个外部类的对象，使用new 出来的对象来访问。 但是可以直接访问静态的变量，调用静态的方法
      2. 如果其他类要访问静态内部类的属性或者调用静态内部类的方法，直接创建一个静态内部类对象即可

    - 普通内部类

      1. 普通内部类作为外部类一个成员而存在，在普通内部类中可以直接访问外部类的属性，调用外部类的方法
      2. 如果外部类要访问内部类的属性或者调用内部类的方法，必须要创建一个内部类的对象，使用该对象访问属性或方法
      3. 如果其他的类要访问普通内部类的属性或者调用普通内部类的方法，必须要在外部类中创建一个普通内部类的对象作为一个属性，外同类可以通过该属性调用普通内部类的方法或者访问普通内部类的属性

      

22. static 关键字的作用

    1. static 可以修改内部类，方法，变量，代码块
    2. static 修饰的类，是静态内部类
    3. static 修饰的方法是静态方法，表示该方法属于当前类。 而不属于某个对象，静态方法也不能被重写。 可以直接用类名来掉哦那个。 
    4. static 修饰变量是静态变量或者类变量。 静态变量被所有实例所共享。 不会依赖于对象， 静态变量在内存中只有一份拷贝，在JVM 加载类的时候，只为静态分配一次内存
    5. static 修饰的代码块叫做静态代码块。通常用来做程序优化。静态代码块中的代码在整个类加载的时候只会执行一次

23. final 在Java中的作用。

    final作为Java中的关键字可以用于三个地方。用于修饰类、类属性和类方法。特征：凡是引用final关键字的地方皆不可修改

    1. 被final 修饰的类不可以被继承
    2. final 修饰的方法不能被重写
    3. final 修饰的变量不可以被改变。 如果修饰是的引用，则引用不可变，引用指向的内容可变
    4. final 修饰的方法,JVM 会尝试将其内联，以提高运行效率
    5. final修饰的常量，在编译阶段会存入常量池中

24. String str=”aaa”,与String str=new String(“aaa”)一样吗？

    ```java
    
    String x = "张三";
    String y = "张三";
    String z = new String("张三");
    System.out.println(x == y); // true
    System.out.println(x == z); // false
    ```

    String x = "张三" 的方式，Java 虚拟机会将其分配到常量池中，而常量池中没有重复的元素，比如当执行“张三”时，java虚拟机会先在常量池中检索是否已经有“张三”,如果有那么就将“张三”的地址赋给变量，如果没有就创建一个，然后在赋给变量；而 String z = new String(“张三”) 则会被分到堆内存中，即使内容一样还是会创建新的对象

25. 强引用，弱引用，软引用和虚引用

    - 强引用

      强引用是平常中使用最多的引用，强引用在程序内存不足（OOM）的时候也不会被回收，使用方式

      ```java
      String str = new String("str");
      ```

      

    - 软引用

      软引用在程序内存不足时，会被回收。 

      可用场景： 创建缓存的时候，创建的对象放进缓存中，当内存不足时，JVM就会回收早先创建的对象

      ```java
      // 注意：wrf这个引用也是强引用，它是指向SoftReference这个对象的，
      // 这里的软引用指的是指向new String("str")的引用，也就是SoftReference类中T
      SoftReference<String> wrf = new SoftReference<String>(new String("str"));
      ```

    - 弱引用

      弱引用就是只要HVN 来及收集器发现它，就会将之回收 . 一旦我不需要某个引用，JVM会自动帮我处理它，这样我就不需要做其它操作

      ```java
      WeakReference<String> weakReference=new WeakReference<>("sss");
      ```

    - 虚引用

      虚引用的回收机制跟弱引用差不多，但是它被回收之前，会被放入ReferenceQueue中。注意哦，其它引用是被JVM回收后才被传入ReferenceQueue中的。由于这个机制，所以虚引用大多被用于引用销毁前的处理工作。还有就是，虚引用创建的时候，必须带有ReferenceQueue，使用

      ```java
      PhantomReference<String> phantomReference=new PhantomReference<>("demo",new ReferenceQueue<>());
      ```

26. java 创建对象的几种方式

    1. new 创建新对象
    2. 通过反射机制
    3. 采用clone机制
    4. 通过序列化机制

27. 有没有可能两个不相等的对象有相同的hashcode

    在产生hash 冲突时，两个不相等的对象，就会有相同的hashcode 。 当hash 冲突产生时，一般用一下方法来处理

    1. 拉链法 。 每个hash 表节点都要有一个next 指针，多个哈希表节点可以用next 指针构成一个单向链表。 被分配到同一个索引上的多个节点可以用这个单向链表进行存储
    2. 开发定址法  一旦发生了冲突，就去寻找下一个空的散列地址，只要散列表足够大，空的散列表地址总能找到
    3. 再哈希:又叫双哈希法,有多个不同的Hash函数.当发生冲突时,使用第二个,第三个….等哈希函数计算地址,直到无冲突

28. a=a+b与a+=b有什么区别吗

    += 操作符会进行隐式自动类型转换,此处a+=b隐式的将加操作的结果类型强制转换为持有结果的类型, 而a=a+b则不会自动进行类型转换.

29. final、finalize()、finally

    1. final为关键字  final为用于标识常量的关键字，final标识的关键字存储在常量池中
    2. finalize 为方法  finalize()方法在Object中进行了定义，用于在对象“消失”时，由JVM进行调用用于对对象进行垃圾回收，类似于C++中的析构函数；用户自定义时，用于释放对象占用的资源（比如进行I/0操作）
    3. finally 为区块标志。 用于try catch 语句中  finally{}用于标识代码块，与try{}进行配合，不论try中的代码执行完或没有执行完（这里指有异常），该代码块之中的程序必定会进行

31. 两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对

    不对，如果两个对象 x 和 y 满足 x.equals(y) == true，它们的哈希码（hash code）应当相同。Java 对于 eqauls 方法和 hashCode 方法是
    这样规定的：

    1. 如果两个 对象相同（equals 方法返回 true），那么它们的 hashCode 值一定要相同
    2. 如果两个对象的 hashCode 相同，它们并不一定相同。当然，你未必要按照要求去做，但是如果你违背了上述原则就会发现在使用容器时，相同的对象可以出现在 Set 集合中，同时增加新元素的效率会大大下降（对于使用哈希存储的系统，如果哈希码频繁的冲突将会造成存取性能急剧下降）

32. char 型变量中能不能存贮一个中文汉字，为什么？

    char 类型可以存储一个中文汉字，因为 Java 中使用的编码是 Unicode（不选择任何特定的编码，直接使用字符在字符集中的编号，这是统一的唯一方法），一个 char 类型占 2 个字节（16 比特），所以放一个中文是没问题的

33. 抽象的（abstract）方法是否可同时是静态的（static）,是否可同时是本地方法（native），是否可同时被 synchronized修饰

    都不能。抽象方法需要子类重写，而静态的方法是无法被重写的，因此二者是矛盾的。本地方法是由本地代码（如 C 代码）实现的方法，而抽象方法是没有实现的，也是矛盾的。synchronized 和方法的实现细节有关，抽象方法不涉及实现细节，因此也是相互矛盾的

34. 当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递

    是值传递。Java 语言的方法调用只支持参数的值传递。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的属性可以在被调用过程中被改变，但对对象引用的改变是不会影响到调用者的

35. 阐述静态变量和实例变量的区别

    静态变量是被 static 修饰符修饰的变量，也称为类变量，它属于类，不属于类的任何一个对象，一个类不管创建多少个对象，静态变量在内存中有且仅有一个拷贝；实例变量必须依存于某一实例，需要先创建对象然后通过对象才能访问到它。静态变量可以实现让多个对象共享内存

36. String s = new String(“xyz”);创建了几个字符串对象

    两个， 一个是常量区的xyz  一个是用new 创建在堆上的对象

37. try{}里有一个 return 语句，那么紧跟在这个 try 后的finally{}里的代码会不会被执行，什么时候被执行，在 return前还是后

    会执行，在方法返回调用者前执行

    ###### 注意

    在 finally 中改变返回值的做法是不好的，因为如果存在 finally 代码块，try中的 return 语句不会立马返回调用者，而是记录下返回值待 finally 代码块执行完毕之后再向调用者返回其值，然后如果在 finally 中修改了返回值，就会返回修改后的值。显然，在 finally 中返回或者修改返回值会对程序造成很大的困扰

38. Collection 和 Collections 的区别

    Collection 是一个接口，它是 Set、List 等容器的父接口；Collections 是个一个工具类，提供了一系列的静态方法来辅助容器操作，这些方法包括对容器的搜索、排序、线程安全化等等

39. 当一个线程进入一个对象的 synchronized 方法 A 之后，其它线程是否可进入此对象的 synchronized 方法 B

    不能。其它线程只能访问该对象的非同步方法，同步方法则不能进入。因为非静态方法上的 synchronized 修饰符要求执行方法时要获得对象的锁，如果已经进入A 方法说明对象锁已经被取走，那么试图进入 B 方法的线程就只能在等锁池（注意不是等待池哦）中等待对象的锁

40. 阐述 JDBC 操作数据库的步骤

    1. 加载驱动
    2. 创建连接
    3. 创建语句
    4. 执行语句
    5. 处理结果
    6. 关闭连接

41. volatile 类型变量提供什么保证

    volatile 变量提供顺序和可见性保证，例如，JVM 或者 JIT 为了获得更好的性能会对语句重排序，但是 volatile 类型变量即使在没有同步块的情况下赋值也不会与其他语句重排序。 volatile 提供 happens-before 的保证，确保一个线程的修改能对其他线程是可见的

42. 我们能将 int 强制转换为 byte 类型的变量吗？如果该值大于 byte 类型的范围，将会出现什么现象

    是的，我们可以做强制转换，但是 Java 中 int 是 32 位的，而 byte 是 8 位的，所以，如果强制转化是，int 类型的高 24 位将会被丢弃，byte 类型的范围是从 -128 到 128

43. int 和 Integer 哪个会占用更多的内存

    Integer 对象会占用更多的内存。Integer 是一个对象，需要存储对象的元数据。但是 int 是一个原始类型的数据，所以占用的空间更少

44. a==b”和”a.equals(b)”有什么区别

    如果 a 和 b 都是对象，则 a==b 是比较两个对象的引用，只有当 a 和 b 指向的是堆中的同一个对象才会返回 true，而 a.equals(b) 是进行逻辑比较，所以通常需要重写该方法来提供逻辑一致性的比较。例如，String 类重写 equals() 方法，所以可以用于两个不同对象，但是包含的字母相同的比较

45. ArrayList 和 HashMap 的默认大小是多数

    在 Java 7 中，ArrayList 的默认大小是 10 个元素，HashMap 的默认大小是16 个元素（必须是 2 的幂）

46. Java中引用数据类型有哪些，它们与基本数据类型有什么区别

    简单来说 ，只要不是基本类型，其他都是引用类型 ，他们有以下不同

    ###### 从概念来说

    1. 基本数据类型： 变量名指向具体的数值
    2. 引用数据类型： 变量名不是指向具体的数值，而是指向内存数据的内存地址。也就是hash 值

    ###### 从内存的构建方面

    1. 基本数据类型，被创建时，在栈内存中会被划分出一定的内存，并将数值存储在该内存中
    2. 引用数据类型 ， 被创建时，首先会在栈内存中分配一块空间，然后在堆内存中也会分配一块具体空间来存储数据的具体信息，即 hash 值，然后由栈中引用指向堆中的对象地址

    ###### 从使用方面来说

    1. 基本数据类型，判断数据是否想到，用 == != 判断
    2. 引用数据类型， 判断数据是否相等， 用 equals 方法 。 比较内存地址

    ##### 数据类型选择的原则

    - 如果要表示整数就使用int，表示小数就使用double；
    - 如果要描述日期时间数字或者表示文件（或内存）大小用long；
    - 如果要实现内容传递或者编码转换使用byte；
    - 如果要实现逻辑的控制，可以使用booleam；
    - 如果要使用中文，使用char避免中文乱码；
    - 如果按照保存范围：byte < int < long < double

47. 



### 集合

![image-20210805173935482](https://gitee.com/Sean0516/image/raw/master/img/image-20210805173935482.png)

![image-20210805173917414](https://gitee.com/Sean0516/image/raw/master/img/image-20210805173917414.png)

1. List Map Set 之间的区别

   - List 存储一组不唯一 ，有序的对象
   - Set 不允许重复的集合，不会有多个元素引用相同的对象
   - Map  使用键值对存储，Map 会维护与Key 有关联的值，两个key 可以引用相同的对象。 但是key 不能重复。

2. ArrayList 

   ArrayList 是最常用的 List 实现类，内部是通过数组实现的，它允许对元素进行快速随机访问。数组的缺点是每个元素之间不能有间隔， 当数组大小不满足时需要增加存储能力，就要将已经有数组的数据复制到新的存储空间中。 当从 ArrayList 的中间位置插入或者删除元素时，需要对数组进行复制、移动、代价比较高。因此，它适合随机查找和遍历，不适合插入和删除

3. Vector（ 数组实现、 线程同步）

   Vector 与 ArrayList 一样，也是通过数组实现的，不同的是它支持线程的同步，即某一时刻只有一个线程能够写 Vector，避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此，访问它比访问 ArrayList 慢

4. LinkList

   LinkedList 是用链表结构存储数据的，很适合数据的动态插入和删除，随机访问和遍历速度比较慢。另外，他还提供了 List 接口中没有定义的方法，专门用于操作表头和表尾元素，可以当作堆栈、队列和双向队列使用

5. Set 

   Set 注重独一无二的性质,该体系集合用于存储无序(存入和取出的顺序不一定相同)元素， 值不能重复。对象的相等性本质是对象 hashCode 值（java 是依据对象的内存地址计算出的此序号） 判断的， 如果想要让两个不同的对象视为相等的，就必须覆盖 Object 的 hashCode 方法和 equals 方法

6. HashSet

   哈希表边存放的是哈希值。 HashSet 存储元素的顺序并不是按照存入时的顺序（和 List 显然不同） 而是按照哈希值来存的所以取数据也是按照哈希值取得。元素的哈希值是通过元素的hashcode 方法来获取的, HashSet 首先判断两个元素的哈希值，如果哈希值一样，接着会比较equals 方法 如果 equls 结果为 true ， HashSet 就视为同一个元素。如果 equals 为 false 就不是同一个元素

7. Tree Set

   1. TreeSet()是使用二叉树的原理对新 add()的对象按照指定的顺序排序（升序、降序），每增加一个对象都会进行排序，将对象插入的二叉树指定的位置。
   2. Integer 和 String 对象都可以进行默认的 TreeSet 排序，而自定义类的对象是不可以的， 自己定义的类必须实现 Comparable 接口，并且覆写相应的 compareTo()函数，才可以正常使用。
   3. 在覆写 compare()函数时，要返回相应的值才能使 TreeSet 按照一定的规则来排序
   4. 比较此对象与指定对象的顺序。如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数

   

8. HashMap (数组+ 链表+ 红黑树)

   HashMap 根据键的 hashCode 值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的。 HashMap 最多只允许一条记录的键为 null，允许多条记录的值为 null。 HashMap 非线程安全，即任一时刻可以有多个线程同时写 HashMap，可能会导致数据的不一致。

   在 Java8 中， 当链表中的元素超过了 8 个以后，会将链表转换为红黑树，在这些位置进行查找的时候可以降低时间复杂度为 O(logN)

   

   大方向上，HashMap 里面是一个数组，然后数组中每个元素是一个单向链表。上图中，每个绿色的实体是嵌套类 Entry 的实例，Entry 包含四个属性：key, value, hash 值和用于单向链表的 next。
   1.  capacity：当前数组容量，始终保持 2^n，可以扩容，扩容后数组大小为当前的 2 倍。
   2.  loadFactor：负载因子，默认为 0.75
   3.  threshold：扩容的阈值，等于 capacity * loadFactor

   ![](http://qvi33264o.hn-bkt.clouddn.com/img/hashmap.png)

9. HashMap 的实现原理

   HashMap基于Hash算法，我们通过put(key,value)存储，get(key)来获取。当传入key时，HashMap会根据key.hashCode()计算出hash值，根据hash值将value保存在bucket里。当计算出的hash值相同时怎么办呢，我们称之为Hash冲突，HashMap的做法是用链表和红黑树存储相同hash值的value。当Hash冲突的个数比较少时，使用链表，否则使用红黑树

   ##### 常用方法

   ###### 确认哈希桶数组索引位置

   不管增加、删除、查找键值对，定位到哈希桶数组的位置都是很关键的第一步。前面说过HashMap的数据结构是数组和链表的结合，所以我们当然希望这个HashMap里面的元素位置尽量分布均匀些，尽量使得每个位置上的元素数量只有一个，那么当我们用hash算法求得这个位置的时候，马上就可以知道对应位置的元素就是我们要的，不用遍历链表，大大优化了查询的效率。HashMap定位数组索引位置，直接决定了hash方法的离散性能。先看看源码的实现(方法一+方法二):

   ```java
   方法一：
   static final int hash(Object key) { //jdk1.8 & jdk1.7
   int h;
   // h = key.hashCode() 为第一步 取hashCode值
   // h ^ (h >>> 16) 为第二步 高位参与运算
   return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
   }
   方法二：
   static int indexFor(int h, int length) { //jdk1.7的源码，jdk1.8没有这个方法，但是实现原理一样的
   return h & (length-1); //第三步 取模运算
   }
   ```

   这里的Hash算法本质上就是三步：取key的hashCode值、高位运算、取模运算

   对于任意给定的对象，只要它的hashCode()返回值相同，那么程序调用方法一所计算得到的Hash码值总是相同的。我们首先想到的就是把hash值对数组长度取模运算，这样一来，元素的分布相对来说是比较均匀的。但是，模运算的消耗还是比较大的，在HashMap中是这样做的：调用方法二来计算该对象应该保存在table数组的哪个索引处

   这个方法非常巧妙，它通过h & (table.length -1)来得到该对象的保存位，而HashMap底层数组的长度总是2的n次方，这是HashMap在速度上的优化。当length总是2的n次方时，h& (length-1)运算等价于对length取模，也就是h%length，但是&比%具有更高的效率

   ![image-20210812160333690](https://gitee.com/Sean0516/image/raw/master/img/image-20210812160333690.png)

   ###### put 操作的大致思路为

   1. 对key的hashCode()做hash，然后再计算index;
   2. 如果没碰撞直接放到bucket里；
   3. 如果碰撞了，以链表的形式存在buckets后；
   4. 如果碰撞导致链表过长(大于等于TREEIFY_THRESHOLD)，就把链表转换成红黑树；
   5. 如果节点已经存在就替换old value(保证key的唯一性)
   6. 如果bucket满了(超过load factor*current capacity)，就要resize （调整table 数组的大小）

   在Java 8以前，每次产生hash冲突，就将记录追加到链表后面，然后通过遍历链表来查找。如果某个链表中记录过大，每次遍历的数据就越多，效率也就很低，复杂度为O(n)；
   在Java 8中，加入了一个常量TREEIFY_THRESHOLD=8，如果某个链表中的记录大于这个常量的话，HashMap会动态的使用一个专门的treemap实现来替换掉它。这样复杂度是O(logn)，比链表的O(n)会好很多。

   ###### get 操作

   1. bucket里的第一个节点，直接命中；
   2. 如果有冲突，则通过key.equals(k)去查找对应的entry
   3. 若为树，则在树中通过key.equals(k)查找，O(logn)；
   4. 若为链表，则在链表中通过key.equals(k)查找，O(n)。

   ###### 扩容resize

   扩容(resize)就是重新计算容量，向HashMap对象里不停的添加元素，而HashMap对象内部的数组无法装载更多的元素时，对象就需要扩大数组的长度，以便能装入更多的元素。当然Java里的数组是无法自动扩容的，方法是使用一个新的数组代替已有的容量小的数组，就像我们用一个小桶装水，如果想装更多的水，就得换大水桶

   ```java
   1 final Node<K,V>[] resize() {
   2 Node<K,V>[] oldTab = table;
   3 int oldCap = (oldTab == null) ? 0 : oldTab.length;
   4 int oldThr = threshold;
   5 int newCap, newThr = 0;
   6 if (oldCap > 0) {
   7 // 超过最大值就不再扩充了，就只好随你碰撞去吧
   8 if (oldCap >= MAXIMUM_CAPACITY) {
   9 threshold = Integer.MAX_VALUE;
   10 return oldTab;
   11 }
   12 // 没超过最大值，就扩充为原来的2倍
   13 else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
   14 oldCap >= DEFAULT_INITIAL_CAPACITY)
   15 newThr = oldThr << 1; // double threshold
   16 }
   17 else if (oldThr > 0) // initial capacity was placed in threshold
   18 newCap = oldThr;
   19 else { // zero initial threshold signifies using defaults
   20 newCap = DEFAULT_INITIAL_CAPACITY;
   21 newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
   22 }
   23 // 计算新的resize上限
   24 if (newThr == 0) {
   25
   26 float ft = (float)newCap * loadFactor;
   27 newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
   28 (int)ft : Integer.MAX_VALUE);
   29 }
   30 threshold = newThr;
   31 @SuppressWarnings({"rawtypes"，"unchecked"})
   32 Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
   33 table = newTab;
   34 if (oldTab != null) {
   35 // 把每个bucket都移动到新的buckets中
   36 for (int j = 0; j < oldCap; ++j) {
   37 Node<K,V> e;
   38 if ((e = oldTab[j]) != null) {
   39 oldTab[j] = null;
   40 if (e.next == null)
   41 newTab[e.hash & (newCap - 1)] = e;
   42 else if (e instanceof TreeNode)
   43 ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
   44 else { // 链表优化重hash的代码块
   45 Node<K,V> loHead = null, loTail = null;
   46 Node<K,V> hiHead = null, hiTail = null;
   47 Node<K,V> next;
   48 do {
   49 next = e.next;
   50 // 原索引
   51 if ((e.hash & oldCap) == 0) {
   52 if (loTail == null)
   53 loHead = e;
   54 else
   55 loTail.next = e;
   56 loTail = e;
   57 }
   58 // 原索引+oldCap
   59 else {
   60 if (hiTail == null)
   61 hiHead = e;
   62 else
   63 hiTail.next = e;
   64 hiTail = e;
   65 }
   66 } while ((e = next) != null);
   67 // 原索引放到bucket里
   68 if (loTail != null) {
   69 loTail.next = null;
   70 newTab[j] = loHead;
   71 }
   72 // 原索引+oldCap放到bucket里
   73 if (hiTail != null) {
   74 hiTail.next = null;
   75 newTab[j + oldCap] = hiHead;
   76 }
   77 }
   78 }
   79 }
   80 }
   81 return newTab;
   82 }
   ```

   

   

10. ConcurrentHashMap

   结构和上面一致 。都使用了数组+ 链表+ 红黑树



11. HashTable（线程安全）

    Hashtable 是遗留类，很多映射的常用功能与 HashMap 类似，不同的是它承自 Dictionary 类，并且是线程安全的，任一时间只有一个线程能写 Hashtable，并发性不如 ConcurrentHashMap， Hashtable 不建议在新代码中使用，不需要线程安全的场合可以用 HashMap 替换，需要线程安全的场合可以用 ConcurrentHashMap 替换

12. TreeMap（可排序）

    TreeMap 实现 SortedMap 接口，能够把它保存的记录根据键排序，默认是按键值的升序排序，也可以指定排序的比较器，当用 Iterator 遍历 TreeMap 时，得到的记录是排过序的。如果使用排序的映射，建议使用 TreeMap。在使用 TreeMap 时， key 必须实现 Comparable 接口或者在构造 TreeMap 传入自定义的Comparator，否则会在运行时抛出 java.lang.ClassCastException 类型的异常

13. TreeMap 的实现原理

    TreeMap是一个通过红黑树实现有序的key-value集合。
    TreeMap继承AbstractMap，也即实现了Map，它是一个Map集合
    TreeMap实现了NavigableMap接口，它支持一系列的导航方法，
    TreeMap实现了Cloneable接口，它可以被克隆
    TreeMap本质是Red-Black Tree，它包含几个重要的成员变量：root、size、comparator。其中root是红黑树的根节点。它是Entry类型，Entry是红黑树的节点，它包含了红黑树的6个基本组成：key、value、left、right、parent和color。Entry节点根据根据Key排序，包含的内容是value。Entry中key比较大小是根据比较器comparator来进行判断的。size是红黑树的节点个数

14. 快速失败 (fail-fast) 和安全失败 (fail-safe) 的区别是什么

    Iterator 的安全失败是基于对底层集合做拷贝，因此，它不受源集合上修改的影响

    java.util 包下面的所有的集合类都是快速失败的，而 java.util.concurrent 包下面的所有的类都是安全失败的。快速失败的迭代器会抛出ConcurrentModificationException 异常，而安全失败的迭代器永远不会抛出这样的异常

15. ArrayList,Vector, LinkedList 的存储性能和特性

    ArrayList 和 Vector 都是使用数组方式存储数据，此数组元素数大于实际存储的数
    据以便增加和插入元素，它们都允许直接按序号索引元素，但是插入元素要涉及数组
    元素移动等内存操作，所以索引数据快而插入数据慢，Vector 由于使用了synchronized 方法（线程安全）。通常性能上较 ArrayList 差

    LinkedList 使用双向链表实现存储，按序号索引数据需要进行前向或后向遍历，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快

    ArrayList 在查找时速度快，LinkedList 在插入与删除时更具优势

16. Hashmap 什么时候进行扩容呢

    当 hashmap 中的元素个数超过数组大小 loadFactor 时，就会进行数组扩容loadFactor 的默认值为 0.75，也就是说，默认情况下，数组大小为 16，那么当hashmap 中元素个数超过 16 0.75=12 的时候，就把数组的大小扩展为 2 16=32，即扩大一倍，然后重新计算每个元素在数组中的位置，而这是一个非常消耗性能的操作，所以如果我们已经预知 hashmap 中元素的个数，那么预设元素的个数能够有效的提高 hashmap 的性能。比如说，我们有 1000 个元素 new HashMap(1000),但是理论上来newHashMap(1024) 更合适，不过上面已经说过，即使是 1000，hashmap 也自动会将其设置为 1024。 但是 new HashMap(1024) 还不是更合适的，因为 0.75*1000 < 1000, 也就是说为了让 0.75 * size > 1000, 我们必须这样 new HashMap(2048) 才最合适，既考虑了 & 的问题，也避免了 resize的问题

17. LinkedHashMap 的实现原理

    LinkedHashMap 也是基于 HashMap 实现的，不同的是它定义了一个 Entry header，这个 header 不是放在 Table 里，它是额外独立出来的。LinkedHashMap 通过继承 hashMap 中的 Entry, 并添加两个属性 Entrybefore,after, 和 header 结合起来组成一个双向链表，来实现按插入顺序或访问顺序排序。LinkedHashMap 定义了排序模式 accessOrder，该属性为 boolean 型变量，对于访问顺序，为 true；对于插入顺序，则为 false。一般情况下，不必指定排序模式，其迭代顺序即为默认为插入顺序

18. Iterator 和 ListIterator 的区别是什么

    Iterator 可用来遍历 Set 和 List 集合，但是 ListIterator 只能用来遍历 List。

    Iterator 对集合只能是前向遍历，ListIterator 既可以前向也可以后向。

    ListIterator 实现了 Iterator 接口，并包含其他的功能，比如：增加元素，替换元素，获取前一个和后一个元素的索引，等等

19. poll()方法和remove()方法区别?

    poll() 和 remove() 都是从队列中取出一个元素，但是 poll() 在获取元素失败的时候会返回空，但是remove() 失败的时候会抛出异常

20. 集合框架相关的有哪些最好的实践

    1. 根据需要选择正确的集合类型。比如，如果指定了大小，我们会选用Array而非ArrayList。如果我们想根据插入顺序遍历一个Map，我们需要使用TreeMap。如果我们不想重复，我们应该使用Set
    2. 一些集合类允许指定初始容量，所以如果我们能够估计到存储元素的数量，我们可以使用它，就避免了重新哈希或大小调整
    3. 基于接口编程，而非基于实现编程，它允许我们后来轻易地改变实现
    4. 总是使用类型安全的泛型，避免在运行时出现ClassCastException
    5. 使用JDK提供的不可变类作为Map的key，可以避免自己实现hashCode()和equals()
    6. 尽可能使用Collections工具类，或者获取只读、同步或空的集合，而非编写自己的实现。它将会提供代码重用性，它有着更好的稳定性和可维护性

21. 



### 泛型

1. 泛型类

   泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型

   ```java
   public class Box<T> {
   private T t;
   public void add(T t) {
   this.t = t;
   }
   public T get() {
   return t;
   }
   }
   ```

2. 泛型方法

   该方法在调用时可以接收不同类型的参数。根据传递给泛型方法的参数类型，编译器适当地处理每一个方法调用

   ```java
   public static < E > void printArray( E[] inputArray )
   	{
   		for ( E element : inputArray ){
   		System.out.printf( "%s ", element );
   	}
   }
   // <? extends T>表示该通配符所代表的类型是 T 类型的子类
   //<? super T>表示该通配符所代表的类型是 T 类型的父类
   ```

5. 类型通配符 ?  

   类 型 通 配 符 一 般 是 使 用 ? 代 替 具 体 的 类 型 参 数 。 例 如 List<?> 在 逻 辑 上 是List,List 等所有 List<具体类型实参>的父类

6. 类型擦除

   java 中的泛型基本上都是在编译器这个层次来实现的。在生成的 Java 字节代码中是不包含泛型中的类型信息的。使用泛型的时候加上的类
   型参数，会被编译器在编译的时候去掉。这个过程就称为类型擦除

7. 使用泛型的好处

   以集合来举例，使用泛型的好处是我们不必因为添加元素类型的不同而定义不同类型的集合，如整型集合类，浮点型集合类，字符串集合类，我们可以定义一个集合来存放整型、浮点型，字符串型数据，而这并不是最重要的，因为我们只要把底层存储设置了Object即可，添加的数据全部都可向上转型为Object。 更重要的是我们可以通过规则按照自己的想法控制存储的数据类型

### 异常

1. try catch fifinally，try里有return，finally还执行么

   执行， 并且 finally 的执行早于 try 里面的return

   1. 不管有没有出现异常，finally块中代码都会执行；
   2. 当try和catch中有return时，finally仍然会执行；
   3. finally是在return后面的表达式运算后执行的（此时并没有返回运算后的值，而是先把要返回的值保存起来，不管finally中的代码怎么样，返回的值都不会改变，任然是之前保存的值），所以函数返回值是在finally执行前确定的；
   4. finally中最好不要包含return，否则程序会提前退出，返回值不是try或catch中保存的返回值。

2. thow与thorws区别

   - 位置不同
     1. throws 作用在函数上，后面跟异常类，而throw 用在函数内，后面跟异常对象
   - 功能不同
     1. throws 用来声明异常，让调用者只知道该功能可能出现的问题，可以给出预先的处理方式；throw 抛出具体的问题对象，执行到 throw，功能就已经结束了，跳转到调用者，并将具体的问题对象抛给调用者。也就是说 throw 语句独立存在时，下面不要定义其他语句，因为执行不到
     2. throws 表示出现异常的一种可能性，并不一定会发生这些异常；throw 则是抛出了异常，执行 throw 则一定抛出了某种异常对象
     3. 两者都是消极处理异常的方式，只是抛出或者可能抛出异常，但是不会由函数去处理异常，真正的处理异常由函数的上层调用处理



### IO

1. 字符流和字节流的区别

   以字节为单位输入输出数据，字节流按照8位传输
   以字符为单位输入输出数据，字符流按照16位传输

2. 阻塞IO 模型 非阻塞IO模型 多路复用IO模型 信号驱动IO 模型 异步IO 模型

3. BIO、NIO、AIO 有什么区别

   - BIO：Block IO 同步阻塞式 IO，就是我们平常使用的传统 IO，它的特点是模式简单使用方便，并发处理能力低。
   - NIO：Non IO 同步非阻塞 IO，是传统 IO 的升级，客户端和服务器端通过 Channel（通道）通讯，实现了多路复用。
   - AIO：Asynchronous IO 是 NIO 的升级，也叫 NIO2，实现了异步非堵塞 IO ，异步 IO 的操作基于事件和回调机制

4. 



### NIO



1. Java NIO

   NIO 主要有三大核心部分： Channel(通道)， Buffer(缓冲区), Selector。传统 IO 基于字节流和字符流进行操作， 而 NIO 基于 Channel 和Buffer(缓冲区)进行操作，数据总是从通道读取到缓冲区中，或者从缓冲区写入到通道中。 Selector(选择区)用于监听多个通道的事件（比如：连接打开，数据到达）。因此，单个线程可以监听多个数据通道。 NIO 和传统 IO 之间第一个最大的区别是， IO 是面向流的， NIO 是面向缓冲区的

2. NIO 的缓冲区

   java IO 面向流意味着每次从流中读一个或多个字节，直至读取所有字节，它们没有被缓存在任何地方。此外，它不能前后移动流中的数据。如果需要前后移动从流中读取的数据， 需要先将它缓存到一个缓冲区。 NIO 的缓冲导向方法不同。数据读取到一个它稍后处理的缓冲区，需要时可在缓冲区中前后移动。这就增加了处理过程中的灵活性。但是，还需要检查是否该缓冲区中包含所有您需要处理的数据。而且，需确保当更多的数据读入缓冲区时，不要覆盖缓冲区里尚未处理的数据

3. NIO 的非阻塞

   NIO 的非阻塞模式，使一个线程从某通道发送请求读取数据，但是它仅能得到目前可用的数据，如果目前没有数据可用时，就什么都不会获取。而不是保持线程阻塞，所以直至数据变的可以读取之前，该线程可以继续做其他的事情。 非阻塞写也是如此。一个线程请求写入一些数据到某通道，但不需要等待它完全写入，这个线程同时可以去做别的事情。 线程通常将非阻塞 IO 的空闲时间用于在其它通道上执行 IO 操作，所以一个单独的线程现在可以管理多个输入和输出通道（channel）

4. Channel

   Channel 是双向的，既可以用来进行读操作，又可以用来进行写操作。NIO 中的 Channel 的主要实现有

   - FileChannel 文件IO
   - DatagramChannel UDP
   - SocketChannel TCP
   - ServerSocketChannel TCP Server 

5. Buffer

   缓冲区，实际上是一个容器，是一个连续数组。Channel 提供从文件、网络读取数据的渠道，但是读取或写入的数据都必须经由 Buffer

   从一个客户端向服务端发送数据，然后服务端接收数据的过程。客户端发送数据时，必须先将数据存入 Buffer 中，然后将 Buffer 中的内容写入通道。服务端这边接收数据必须通过 Channel 将数据读入到 Buffer 中，然后再从 Buffer 中取出数据来处理

   在 NIO 中，Buffer 是一个顶层父类，它是一个抽象类，常用的 Buffer 的子类有：
   ByteBuffer、IntBuffer、 CharBuffer、 LongBuffer、 DoubleBuffer、FloatBuffer、ShortBuffer

6. Selector

   Selector 类是 NIO 的核心类， Selector 能够检测多个注册的通道上是否有事件发生，如果有事件发生，便获取事件然后针对每个事件进行相应的响应处理。这样一来，只是用一个单线程就可以管理多个通道，也就是管理多个连接。这样使得只有在连接真正有读写事件发生时，才会调用函数来进行读写，就大大地减少了系统开销，并且不必为每个连接都创建一个线程，不用去维护多个线程，并且避免了多线程之间的上下文切换导致的开销

### 反射

1. 反射的作用

   反射机制是在运行时，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意个对象，都能够调用它的任意一个方法。在java中，只要给定类的名字，就可以通过反射机制来获得类的所有信息 。 这种动态获取信息以及动态调用对象方法的功能成为 Java 语言的反射机制

2. 反射的实现

   1. Class.forName("类的路径")
   2. 类名.class
   3. 对象名.getClass()
   4. 基本类型的包装类，可以调用包装类的Type属性来获得该包装类的Class对象

3. 反射类的组成

   - class  表示正在运行的Java应用程序中的类和接口
   - field 提供有关类和接口的属性信息，以及对他的动态访问权限
   - constructor 提供关于类的单个构造方法的信息以及它的访问权限
   - method  提供类或者接口中某个方法的信息

4. 反射使用步骤

   1. 获取想要操作的类的 Class 对象，他是反射的核心，通过 Class 对象我们可以任意调用类的方法
   2. 调用 Class 类中的方法，既就是反射的使用阶段
   3. 使用反射 API 来操作这些信息

5. 创建对象的两种方法

   1. 使用 Class 对象的 newInstance()方法来创建该 Class 对象对应类的实例，但是这种方法要求该 Class 对象对应的类有默认的空构造器

      ```java
      Person p=(Person) clazz.newInstance();
      ```

      

   2. 先使用 Class 对象获取指定的 Constructor 对象，再调用 Constructor 对象的 newInstance()方法来创建 Class 对象对应类的实例,通过这种方法可以选定构造方法创建实例

      ```java
      Constructor c=clazz.getDeclaredConstructor(String.class,String.class,int.class);
      Person p1=(Person) c.newInstance("李四","男",20);
      ```

      

6. 反射的优缺点

   ###### 优点

   1. 能够动态获取类的实例，提高灵活性
   2. 与动态编译结合

   ###### 缺点

   1. 使用反射性能较低，需要解析字节码，将内存中的对象进行解析

      ###### 解决方案

      1. 通过setAccessible(true)关闭JDK的安全检查来提升反射速度；
      2. 多次创建一个类的实例时，有缓存会快很多
      3. ReflectASM工具类，通过字节码生成的方式加快反射速度

   2. 相对不安全，破坏了封装性（因为通过反射可以获得私有方法和属性）

### 序列化

1. 什么是Java序列化，如何实现Java序列化

   序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化。可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。序列化是为了解决在对对象流进行读写操作时所引发的问题。序列化的实现：将需要被序列化的类实现Serializable接口，该接口没有需要实现的方法，implements Serializable只是为了标注该对象是可被序列化的，然后使用一个输出流(如：FileOutputStream)来构造一个ObjectOutputStream(对象流)对象，接着，使用ObjectOutputStream对象的writeObject(Object obj)方法就可以将参数为obj的对象写出(即保存其状态)，要恢复的话则用输入流

2. 序列化 ID

   虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化 ID 是否一致（就是 private static final long serialVersionUID

3. 序列化并不保存静态变量

   需要注意地是， 对象序列化保存的是对象的”状态”，即它的成员变量。由此可知，对象序列化不会关注类中的静态变量 。 要想将父类对象也序列化，就需要让父类也实现 Serializable 接口

4. Transient 关键字阻止该变量被序列化到文件中

   在变量声明前加上 Transient 关键字，可以阻止该变量被序列化到文件中，在被反序列化后， transient 变量的值被设为初始值，如 int 型的是 0，对象型的是 null

### 注解

1. 四种标准元注解

   ###### @Target 修饰对象范围

   @Target说明了Annotation所修饰的对象范围： Annotation可被用于 packages、types（类、接口、枚举、Annotation 类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch 参数）。在 Annotation 类型的声明中使用了 target可更加明晰其修饰的目标

   ###### @Retention 定义被保留的时间长短

   Retention 定义了该 Annotation 被保留的时间长短：表示需要在什么级别保存注解信息，用于描述注解的生命周期（即：被描述的注解在
   什么范围内有效），取值（RetentionPoicy）由：

   1. SOURCE:在源文件中有效（即源文件保留）
   2. CLASS:在 class 文件中有效（即 class 保留）
   3. RUNTIME:在运行时有效（即运行时保留）

   ###### @Documented 

   用于描述其他类型的 annotation 应该被作为被标注的程序成员的公共 API，因此可以被例如 javadoc 此类的工具文档化

   ###### @Inherited 阐述了某个被标注的类型是被继承的

   @Inherited 元注解是一个标记注解，@Inherited 阐述了某个被标注的类型是被继承的。如果一
   个使用了@Inherited 修饰的 annotation 类型被用于一个 class，则这个 annotation 将被用于该
   class 的子类。

2. 注解是什么

   Annotation（注解）是 Java 提供的一种对元程序中元素关联信息和元数据（metadata）的途径和方法。 Annatation(注解)是一个接口，程序可以通过反射来获取指定程序中元素的 Annotation对象，然后通过该 Annotation 对象来获取注解中的元数据信息
   
3. 注解处理器 处理器

   如果没有用来读取注解的方法和工作，那么注解也就不会比注释更有用处了。使用注解的过程中，很重要的一部分就是创建于使用注解处理器。Java SE5扩展了反射机制的API，以帮助程序员快速的构造自定义注解处理器

4. 



### 多线程

![image-20210805174400442](https://gitee.com/Sean0516/image/raw/master/img/image-20210805174400442.png)

1. 如何停止一个正在运行的线程

   - 使用退出标志，使得线程正常退出，也就是当run 方法完成后线程终止
   - 使用stop方法 强行终止
   - 使用interrupt 中断方法中断线程

2. notify 和notifyAll 有什么区别

   1. notify可能会导致死锁，而notifyAll则不会 
   2. 任何时候只有一个线程可以获得锁，也就是说只有一个线程可以运行synchronized 中的代码使用notifyall,可以唤醒所有处于wait状态的线程，使其重新进入锁的争夺队列中，而notify只能唤醒一个。
   3. wait() 应配合while循环使用，不应使用if，务必在wait()调用前后都检查条件，如果不满足，必须调用notify()唤醒另外的线程来处理，自己继续wait()直至条件满足再往下执行。
   4. notify() 是对notifyAll()的一个优化，但它有很精确的应用场景，并且要求正确使用。不然可能导致死锁。正确的场景应该是 WaitSet中等待的是相同的条件，唤醒任一个都能正确处理接下来的事项，如果唤醒的线程无法正确处理，务必确保继续notify()下一个线程，并且自身需要重新回到WaitSet中.

3. 四种线程池

   - newCachedThreadPool   创建一个可缓存线程池 ，是 无 界 线 程 池 ， 如 果 线 程 池 的 大 小 超 过 了 处 理 任 务所 需 要 的 线 程 ， 那 么 就 会 回 收 部 分 空 闲 （ 60 秒 不 执 行 任 务 ） 线 程 ， 当任 务 数 增 加 时 ， 此 线 程 池 又 可 以 智 能 的 添 加 新 线 程 来 处 理 任 务 。线 程 池 大 小 完 全 依 赖 于 操 作 系 统 （ 或 者 说 JVM） 能 够 创 建 的 最 大 线 程大 小 
   - newFixedThreadPool  创建一个定长线程池， 只 有 核 心 线 程 。 每 次 提 交 一 个任 务 就 创 建 一 个 线 程 ， 直 到 线 程 达 到 线 程 池 的 最 大 大 小 。 线 程 池 的 大 小一 旦 达 到 最 大 值 就 会 保 持 不 变 ， 如 果 某 个 线 程 因 为 执 行 异 常 而 结 束 ， 那么 线 程 池 会 补 充 一 个 新 线 程 
   - newScheduledThreadPool  创建一个定长线程池，支持定时及周期性任务执行
   - newSingleThreadExecutor  创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务  如 果 这 个 唯 一 的 线 程 因 为 异 常 结 束 ， 那 么 会 有 一 个 新 的 线 程 来替 代 它 。 此 线 程 池 保 证 所 有 任 务 的 执 行 顺 序 按 照 任 务 的 提 交 顺 序 执 行

   ![image-20210805174920035](https://gitee.com/Sean0516/image/raw/master/img/image-20210805174920035.png)

4. 线程生命周期 

   1. 新建状态（ 新建状态（NEW ）

      当程序使用 new 关键字创建了一个线程之后，该线程就处于新建状态，此时仅由 JVM 为其分配内存，并初始化其成员变量的值

   2. 就绪状态（RUNNABLE ）

      当线程对象调用了 start()方法之后，该线程处于就绪状态。Java 虚拟机会为其创建方法调用栈和程序计数器，等待调度运行

   3. 运行状 态（RUNNING ）

      如果处于就绪状态的线程获得了 CPU，开始执行 run()方法的线程执行体，则该线程处于运行状态

   4. 阻塞状态（BLOCKED ）

      阻塞状态是指线程因为某种原因放弃了 cpu 使用权，也即让出了 cpu timeslice，暂时停止运行。直到线程进入可运行(runnable)状态，才有机会再次获得 cpu timeslice 转到运行(running)状态。阻塞的情况分三种

      - 等待阻塞 （ o.wait-> 等待对列 ）  运行(running)的线程执行 o.wait()方法，JVM 会把该线程放入等待队列(waitting queue)中
      - 同步阻塞 (lock-> 锁池 )  运行(running)的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则 JVM 会把该线程放入锁池(lock pool)中
      - 其他阻塞 (sleep/join)  运行(running)的线程执行 Thread.sleep(long ms)或 t.join()方法，或者发出了 I/O 请求时，JVM 会把该线程置为阻塞状态。当 sleep()状态超时、join()等待线程终止或者超时、或者 I/O处理完毕时，线程重新转入可运行(runnable)状态

   5. 线程死亡（DEAD

      线程会以下面三种方式结束，结束后就是死亡状态

      1. run()或 call()方法执行完成，线程正常结束
      2. 线程抛出一个未捕获的 Exception 或 Error
      3. 直接调用该线程的 stop()方法来结束该线程—该方法通常容易导致死锁，不推荐使用

5. sleep()和wait() 有什么区别

   1. 对于 sleep()方法，我们首先要知道该方法是属于 Thread 类中的。而 wait()方法，则是属于Object 类中的
   2. sleep()方法导致了程序暂停执行指定的时间，让出 cpu 给其他线程，但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态 （不释放锁）
   3. 在调用 sleep()方法的过程中， 线程不会释放对象锁
   4. 而当调用 wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用 notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态

6. Thread.sleep(0)的作用是什么

   由于Java采用抢占式的线程调度算法，因此可能会出现某条线程常常获取到CPU控制权的情况，为了让某些优先级比较低的线程也能获取到CPU控制权，可以使用Thread.sleep(0)手动触发一次操作系统分配时间片的操作，这也是平衡CPU控制权的一种操作

7. interrupted 和 isInterruptedd方法的区别

   1. interrupted() 和 isInterrupted()的主要区别是前者会将中断状态清除而后者不会。Java多线程的中断机制是用内部标识来实现的，调用Thread.interrupt()来中断一个线程就会设置中断标识为true
   2. 当中断线程调用静态方法Thread.interrupted()来检查中断状态时，中断状态会被清零
   3. 而非静态方法isInterrupted()用来查询其它线程的中断状态且不会改变中断状态标识。简单的说就是任何抛出InterruptedException异常的方法都会将中断状态清零。无论如何，一个线程的中断状态有有可能被其它线程调用中断来改变

8. synchronized 和 ReentrantLock 有什么不同

   1. 最大区别就是对于Synchronized来说，它是java语言的关键字，是原生语法层面的互斥，需要jvm实现。而ReentrantLock它是JDK 1.5之后提供的API层面的互斥锁，需要lock()和unlock()方法配合try/finally语句块来完成
   2. Synchronized进过编译，会在同步块的前后分别形成monitorenter和monitorexit这个两个字节码指令。在执行monitorenter指令时，首先要尝试获取对象锁。如果这个对象没被锁定，或者当前线程已经拥有了那个对象锁，把锁的计算器加1，相应的，在执行monitorexit指令时会将锁计算器就减1，当计算器为0时，锁就被释放了。如果获取对象锁失败，那当前线程就要阻塞，直到对象锁被另一个线程释放为止 
   3. 相比Synchronized，ReentrantLock类提供了一些高级功能，主要有以下3项
      - 等待可中断，持有锁的线程长期不释放的时候，正在等待的线程可以选择放弃等待，这相当于Synchronized来说可以避免出现死锁的情况
      - 公平锁，多个线程等待同一个锁时，必须按照申请锁的时间顺序获得锁，Synchronized锁非公平锁，ReentrantLock默认的构造函数是创建的非公平锁，可以通过参数true设为公平锁，但公平锁表现的性能不是很好
      - 锁绑定多个条件，一个ReentrantLock对象可以同时绑定对个对象

9. 如何保证多个线程顺序执行

   在多线程中有多种方法让线程按特定顺序执行，你可以用线程类的join()方法在一个线程中启动另一个线程，另外一个线程完成该线程继续执行。

10. SynchronizedMap和ConcurrentHashMap有什么区别

   SynchronizedMap()和Hashtable一样，实现上在调用map所有方法时，都对整个map进行同步。而ConcurrentHashMap的实现却更加精细，它对map中的所有桶加了锁。所以，只要有一个线程访问map，其他线程就无法进入map，而如果一个线程在访问ConcurrentHashMap某个桶时，其他线程，仍然可以对map执行某些操作。

   所以，ConcurrentHashMap在性能以及安全性方面，明显比Collections.synchronizedMap()更加有优势。同时，同步操作精确控制到桶，这样，即使在遍历map时，如果其他线程试图对map进行数据修改，也不会抛出ConcurrentModificationException

11. Thread类中的yield方法有什么作用

   Yield方法可以暂停当前正在执行的线程对象，让其它有相同优先级的线程执行。它是一个静态方法而且只保证当前线程放弃CPU占用而不能保证使其它线程一定能占用CPU，执行yield()的线程有可能在进入到暂停状态后马上又被执行

11. 说说自己是怎么使用 synchronized 关键字

    修饰实例方法: 作用于当前对象实例加锁，进入同步代码前要获得当前对象实例的锁

    修饰静态方法: 也就是给当前类加锁，会作用于类的所有对象实例，因为静态成员不属于任何一个实例对象，是类成员（ static 表明这是该类的一个静态资源，不管new了多少个对象，只有一份）。所以如果一个线程A调用一个实例对象的非静态 synchronized 方法，而线程B需要调用这个实例对象所属类的静态 synchronized 方法，是允许的，不会发生互斥现象，因为访问静态 synchronized 方法占用的锁是当前类的锁，而访问非静态synchronized 方法占用的锁是当前实例对象锁。

    修饰代码块: 指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。

12. volatile关键字的作用

    一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：

    1. 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
    2. 禁止进行指令重排序

    - volatile本质是在告诉jvm当前变量在寄存器（工作内存）中的值是不确定的，需要从主存中读取；synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住
    - volatile仅能使用在变量级别；synchronized则可以使用在变量、方法、和类级别的
    - volatile仅能实现变量的修改可见性，并不能保证原子性；synchronized则可以保证变量的修改可见性和原子性
    - volatile不会造成线程的阻塞；synchronized可能会造成线程的阻塞
    - volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化

13. volatile如何保 证 变 量 对 所 有 线程 的 可 见 性 

    Java 的 内 存 模 型 定 义 了 8 种 内 存 间 操 作

    ###### lock 和 unlock

    - 把 一 个 变 量 标 识 为 一 条 线 程 独 占 的 状 态
    - 把 一 个 处 于 锁 定 状 态 的 变 量 释 放 出 来 ， 释 放 之 后 的 变 量 才 能 被 其 他 线 程锁 定 

    ###### read 和 write

    - 把 read 操 作 从 主 内 存 得 到 的 变 量 值 放 入 工 作 内 存 的 变 量 副 本 中 
    - 把 工 作 内 存 的 变 量 值 传 送 到 主 内 存 ， 以 便 write

    ###### load 和 store

    - 把 一 个 变 量 值 从 主 内 存 传 输 到 线 程 的 工 作 内 存 ， 以 便 load
    - 把 store 操 作 从 工 作 内 存 得 到 的 变 量 的 值 ， 放 入 主 内 存 的 变 量 中

    ###### use 和 assgin

    - 把 工 作 内 存 变 量 值 传 递 给 执 行 引 擎
    - 将 执 行 引 擎 值 传 递 给 工 作 内 存 变 量 值

    volatile 的 实 现 基 于 这 8 种 内 存 间 操 作 ， 保 证 了 一 个 线 程 对 某 个volatile 变 量 的 修 改 ， 一 定 会 被 另 一 个 线 程 看 见 ， 即 保 证 了 可 见 性

    

14. Synchronized 同步锁

    synchronized 它可以把任意一个非 NULL 的对象当作锁。他属于独占式的悲观锁，同时属于可重入锁

    Synchronized 是 由 JVM 实 现 的 一 种 实 现 互 斥 同 步 的 一 种 方 式 ， 如 果你 查 看 被  Synchronized  修 饰 过 的 程 序 块 编 译 后 的 字 节 码 ， 会 发 现 ，被  Synchronized  修 饰 过 的 程 序 块 ， 在 编 译 前 后 被 编 译 器 生 成 了monitorenter 和 monitorexit 两 个 字 节 码 指 令

    在 虚 拟 机 执 行 到 monitorenter 指 令 时 ， 首 先 要 尝 试 获 取 对 象 的 锁 ：如 果 这 个 对 象 没 有 锁 定 ， 或 者 当 前 线 程 已 经 拥 有 了 这 个 对 象 的 锁 ， 把 锁的 计 数 器  +1； 当 执 行 monitorexit 指 令 时 将 锁 计 数 器  -1； 当 计 数 器为 0 时 ， 锁 就 被 释 放 了 。如 果 获 取 对 象 失 败 了 ， 那 当 前 线 程 就 要 阻 塞 等 待 ， 直 到 对 象 锁 被 另 外 一个 线 程 释 放 为 止

    Java  中  Synchronize  通 过 在 对 象 头 设 置 标 记 ， 达 到 了 获 取 锁 和 释 放锁 的 目 的

15. Synchronized 作用范围

    1. 作用于方法时，锁住的是对象的实例(this)
    2. 当作用于静态方法时，锁住的是Class实例，又因为Class的相关数据存储在永久带PermGen（jdk1.8 则是 metaspace），永久带是全局共享的，因此静态方法锁相当于类的一个全局锁，会锁所有调用该方法的线程
    3. synchronized 作用于一个对象实例时，锁住的是所有以该对象为锁的代码块。它有多个队列，当多个线程一起访问某个对象监视器的时候，对象监视器会将这些线程存储在不同的容器中

16. Synchronized 核心 组件

    1. Wait Set：哪些调用 wait 方法被阻塞的线程被放置在这里
    2. Contention List：竞争队列，所有请求锁的线程首先被放在这个竞争队列中
    3. Entry List：Contention List 中那些有资格成为候选资源的线程被移动到 Entry List 中
    4. OnDeck：任意时刻，最多只有一个线程正在竞争锁资源，该线程被成为 OnDeck
    5. Owner：当前已经获取到所资源的线程被称为 Owner
    6. !Owner：当前释放锁的线程

17. Synchronized 实现

    ![image-20210805175548757](https://gitee.com/Sean0516/image/raw/master/img/image-20210805175548757.png)

    1. JVM 每次从队列的尾部取出一个数据用于锁竞争候选者（OnDeck），但是并发情况下，ContentionList 会被大量的并发线程进行 CAS 访问，为了降低对尾部元素的竞争，JVM 会将一部分线程移动到 EntryList 中作为候选竞争线程
    2. Owner 线程会在 unlock 时，将 ContentionList 中的部分线程迁移到 EntryList 中，并指定EntryList 中的某个线程为 OnDeck 线程（一般是最先进去的那个线程）
    3. Owner 线程并不直接把锁传递给 OnDeck 线程，而是把锁竞争的权利交给 OnDeck，OnDeck需要重新竞争锁。这样虽然牺牲了一些公平性，但是能极大的提升系统的吞吐量，在JVM 中，也把这种选择行为称之为“竞争切换”
    4. OnDeck 线程获取到锁资源后会变为 Owner 线程，而没有得到锁资源的仍然停留在 EntryList中。如果Owner线程被wait方法阻塞，则转移到WaitSet队列中，直到某个时刻通过notify或者 notifyAll 唤醒，会重新进去 EntryList 中
    5. 处于 ContentionList、EntryList、WaitSet 中的线程都处于阻塞状态，该阻塞是由操作系统来完成的（Linux 内核下采用 pthread_mutex_lock 内核函数实现的）
    6. Synchronized 是非公平锁。 Synchronized 在线程进入 ContentionList 时，等待的线程会先尝试自旋获取锁，如果获取不到就进入 ContentionList，这明显对于已经进入队列的线程是不公平的，还有一个不公平的事情就是自旋获取锁的线程还可能直接抢占 OnDeck 线程的锁资源
    7. 每个对象都有个 monitor 对象，加锁就是在竞争 monitor 对象，代码块加锁是在前后分别加上 monitorenter 和 monitorexit 指令来实现的，方法加锁是通过一个标记位来判断的
    8. synchronized 是一个重量级操作，需要调用操作系统相关接口，性能是低效的，有可能给线程加锁消耗的时间比有用操作消耗的时间更多
    9. Java1.6，synchronized 进行了很多的优化，有适应自旋、锁消除、锁粗化、轻量级锁及偏向锁等，效率有了本质上的提高。在之后推出的 Java1.7 与 1.8 中，均对该关键字的实现机理做了优化。引入了偏向锁和轻量级锁。都是在对象头中有标记位，不需要经过操作系统加锁
    10. 锁可以从偏向锁升级到轻量级锁，再升级到重量级锁。这种升级过程叫做锁膨胀
    11. JDK 1.6 中默认是开启偏向锁和轻量级锁，可以通过-XX:-UseBiasedLocking 来禁用偏向锁

18. ThreadLocal是什么

    即线程本地变量。如果你创建了一个ThreadLocal变量，那么访问这个变量的每个线程都会有这个变量的一个本地拷贝，多个线程操作这个变量的时候，实际是操作自己本地内存里面的变量，从而起到线程隔离的作用，避免了线程安全问题

19. ThreadLocal原理

    1. Thread类有一个类型为ThreadLocal.ThreadLocalMap的实例变量threadLocals，即每个线程都有一个属于自己的ThreadLocalMap
    2. ThreadLocalMap内部维护着Entry数组，每个Entry代表一个完整的对象，key是ThreadLocal本身，value是ThreadLocal的泛型值
    3. 每个线程在往ThreadLocal里设置值的时候，都是往自己的ThreadLocalMap里存，读也是以某个ThreadLocal作为引用，在自己的map里找对应的key，从而实现了线程隔离

20. ThreadLocal 是 怎 么 解 决 并 发 安 全 的

    ThreadLocal 这 是 Java 提 供 的 一 种 保 存 线 程 私 有 信 息 的 机 制 ， 因 为其 在 整 个 线 程 生 命 周 期 内 有 效 ， 所 以 可 以 方 便 地 在 一 个 线 程 关 联 的 不 同业 务 模 块 之 间 传 递 信 息 ， 比 如 事 务 ID、 Cookie 等 上 下 文 相 关 信 息 ThreadLocal 为 每 一 个 线 程 维 护 变 量 的 副 本 ， 把 共 享 数 据 的 可 见 范 围 限制 在 同 一 个 线 程 之 内 ， 其 实 现 原 理 是 ， 在 ThreadLocal 类 中 有 一 个Map， 用 于 存 储 每 一 个 线 程 的 变 量 的 副 本 。

21. 很 多 人 都 说 要 慎 用 ThreadLocal， 谈 谈 你 的 理 解 ， 使 用ThreadLocal 需 要 注 意 些 什 么

    ThreadLocal 的 实 现 是 基 于 一 个 所 谓 的 ThreadLocalMap， 在ThreadLocalMap 中 ， 它 的 key 是 一 个 弱 引 用 。通 常 弱 引 用 都 会 和 引 用 队 列 配 合 清 理 机 制 使 用 ， 但 是 ThreadLocal 是个 例 外 ， 它 并 没 有 这 么 做 。
    这 意 味 着 ， 废 弃 项 目 的 回 收 依 赖 于 显 式 地 触 发 ， 否 则 就 要 等 待 线 程 结束 ， 进 而 回 收 相 应 ThreadLocalMap！ 这 就 是 很 多 OOM 的 来 源 ， 所以 通 常 都 会 建 议 ， 应 用 一 定 要 自 己 负 责 remove， 并 且 不 要 和 线 程 池 配合 ， 因 为 worker 线 程 往 往 是 不 会 退 出 的

    

22. JVM 对 Java 的 原 生 锁 做 了 哪 些 优 化

    1.  使 用 自 旋 锁 ， 即 在 把 线 程 进 行 阻 塞 操 作 之 前 先 让 线 程 自 旋 等待 一 段 时 间 ， 可 能 在 等 待 期 间 其 他 线 程 已 经 解 锁 ， 这 时 就 无 需 再 让 线 程执 行 阻 塞 操 作 ， 避 免 了 用 户 态 到 内 核 态 的 切 换

    2. 现 代 JDK 中 还 提 供 了 三 种 不 同 的 Monitor 实 现 ， 也 就 是 三 种 不 同 的锁

       - 偏 向 锁  当没有竞争出现时，会默认使用偏向锁 
       - 轻量级锁
       - 重量级锁

       这 三 种 锁 使 得 JDK 得 以 优 化 Synchronized 的 运 行 ， 当 JVM 检 测到 不 同 的 竞 争 状 况 时 ， 会 自 动 切 换 到 适 合 的 锁 实 现 ， 这 就 是 锁 的 升 级 、降 级

       JVM 会 利 用 CAS 操 作 ， 在 对 象 头 上 的 Mark Word 部 分 设 置 线 程ID， 以 表 示 这 个 对 象 偏 向 于 当 前 线 程 ， 所 以 并 不 涉 及 真 正 的 互 斥 锁 ， 因为 在 很 多 应 用 场 景 中 ， 大 部 分 对 象 生 命 周 期 中 最 多 会 被 一 个 线 程 锁 定 ，使 用 偏向锁 可 以 降 低 无 竞 争 开 销 

       

       如 果 有 另 一 线 程 试 图 锁 定 某 个 被 偏 斜 过 的 对 象 ， JVM  就 撤 销 偏向锁 ，切 换 到 轻 量 级 锁 实 现

       

       轻 量 级 锁 依 赖 CAS 操 作 Mark Word 来 试 图 获 取 锁 ， 如 果 重 试 成 功 ，就 使 用 普 通 的 轻 量 级 锁 ； 否 则 ， 进 一 步 升 级 为 重 量 级 锁 

23. 为什么说 synchronized 是非公平锁

    非 公 平 主 要 表 现 在 获 取 锁 的 行 为 上 ， 并 非 是 按 照 申 请 锁 的 时 间 前 后 给 等待 线 程 分 配 锁 的 ， 每 当 锁 被 释 放 后 ， 任 何 一 个 线 程 都 有 机 会 竞 争 到 锁 ，这 样 做 的 目 的 是 为 了 提 高 执 行 性 能 ， 缺 点 是 可 能 会 产 生 线 程 饥 饿 现 象

24. 什 么 是 锁 消 除 和 锁 粗 化

    ###### 锁 消 除

     指 虚 拟 机 即 时 编 译 器 在 运 行 时 ， 对 一 些 代 码 上 要 求 同 步 ， 但 被检 测 到 不 可 能 存 在 共 享 数 据 竞 争 的 锁 进 行 消 除 。 主 要 根 据 逃 逸 分 析 。程 序 员 怎 么 会 在 明 知 道 不 存 在 数 据 竞 争 的 情 况 下 使 用 同 步 呢 ？ 很 多 不 是程 序 员 自 己 加 入 的 

    ###### 锁 粗 化

     原 则 上 ， 同 步 块 的 作 用 范 围 要 尽 量 小 。 但 是 如 果 一 系 列 的 连 续操 作 都 对 同 一 个 对 象 反 复 加 锁 和 解 锁 ， 甚 至 加 锁 操 作 在 循 环 体 内 ， 频 繁地 进 行 互 斥 同 步 操 作 也 会 导 致 不 必 要 的 性 能 损 耗 。锁 粗 化 就 是 增 大 锁 的 作 用 域

    

25. ReentrantLock

    ReentrantLock 类实现了Lock ，它拥有与synchronized 相同的并发性和内存语义，但是添加了类似锁投票、定时锁等候和可中断锁等候的一些特性。此外，它还提供了在激烈争用情况下更佳的性能。（换句话说，当许多线程都想访问共享资源时，JVM可以花更少的时候来调度线程，把更多时间用在执行线程上。

    他是一种可重入锁，除了能完成 synchronized 所能完成的所有工作外，还提供了诸如可响应中断锁、可轮询锁请求、定时锁等避免多线程死锁的方法

26. Semaphore  与 ReentrantLock

    Semaphore 基本能完成 ReentrantLock 的所有工作，使用方法也与之类似，通过 acquire()与release()方法来获得和释放临界资源。经实测，Semaphone.acquire()方法默认为可响应中断锁，与 ReentrantLock.lockInterruptibly()作用效果一致，也就是说在等待临界资源的过程中可以被
    Thread.interrupt()方法中断

    此外，Semaphore 也实现了可轮询的锁请求与定时锁的功能，除了方法名 tryAcquire 与 tryLock不同，其使用方法与 ReentrantLock几乎一致。Semaphore也提供了公平与非公平锁的机制，也可在构造函数中进行设定

    Semaphore的锁释放操作也由手动进行，因此与 ReentrantLock 一样，为避免线程因抛出异常而无法正常释放锁的情况发生，释放锁的操作也必须在 finally 代码块中完成

    

27. ReentrantLock 是 如 何 实 现 可 重 入 性 的 

    ReentrantLock 内 部 自 定 义 了 同 步 器 Sync（ Sync 既 实 现 了 AQS，又 实 现 了 AOS， 而 AOS 提 供 了 一 种 互 斥 锁 持 有 的 方 式 ） ， 其 实 就 是加 锁 的 时 候 通 过 CAS 算 法 ， 将 线 程 对 象 放 到 一 个 双 向 链 表 中 ， 每 次 获取 锁 的 时 候 ， 看 下 当 前 维 护 的 那 个 线 程 ID 和 当 前 请 求 的 线 程 ID 是 否一 样 ， 一 样 就 可 重 入 了

28. synchronized和ReentrantLock的区别

    synchronized是和if、else、for、while一样的关键字，ReentrantLock是类，这是二者的本质区别。既然ReentrantLock是类，那么它就提供了比synchronized更多更灵活的特性，可以被继承、可以有方法、可以有各种各样的类变量，ReentrantLock比synchronized的扩展性体现在几点上

    1. ReentrantLock可以对获取锁的等待时间进行设置，这样就避免了死锁
    2. ReentrantLock可以获取各种锁的信息
    3. ReentrantLock可以灵活地实现多路通知

    另外，二者的锁机制其实也是不一样的。ReentrantLock底层调用的是Unsafe的park方法加锁，synchronized操作的应该是对象头中mark word，这点我不能确定

29. ReadWriteLock 和 StampedLock

    读 写 锁 基 于 的 原 理 是 多 个 读 操 作 不 需 要 互 斥 ， 如 果 读 锁 试 图 锁 定 时 ， 写锁 是 被 某 个 线 程 持 有 ， 读 锁 将 无 法 获 得 ， 而 只 好 等 待 对 方 操 作 结 束 ， 这样 就 可 以 自 动 保 证 不 会 读 取 到 有 争 议 的 数 据 。

    

    ReadWriteLock  代 表 了 一 对 锁 ， 下 面 是 一 个 基 于 读 写 锁 实 现 的 数 据 结构 ， 当 数 据 量 较 大 ， 并 发 读 多 、 并 发 写 少 的 时 候 ， 能 够 比 纯 同 步 版 本 凸显 出 优 势 

    StampedLock， 在 提 供 类 似 读 写 锁 的 同 时 ，还 支 持 优 化 读 模 式 。 优 化 读 基 于 假 设 ， 大 多 数 情 况 下 读 操 作 并 不 会 和 写操 作 冲 突 ， 其 逻 辑 是 先 试 着 修 改 ， 然 后 通 过 validate 方 法 确 认 是 否 进入 了 写 模 式 ， 如 果 没 有 进 入 ， 就 成 功 避 免 了 开 销 ； 如 果 进 入 ， 则 尝 试 获取 读 锁 

30. Condition 类和 Object 类锁方法区别区别

    1. Condition 类的 awiat 方法和 Object 类的 wait 方法等效
    2. Condition 类的 signal 方法和 Object 类的 notify 方法等效
    3. Condition 类的 signalAll 方法和 Object 类的 notifyAll 方法等效
    4. ReentrantLock 类可以唤醒指定条件的线程，而 object 的唤醒是随机的

31. tryLock 和 lock 和 lockInterruptibly 的区别

    1. tryLock 能获得锁就返回 true，不能就立即返回 false， tryLock(long timeout,TimeUnit
    unit)，可以增加时间限制，如果超过该时间段还没获得锁，返回 false
    2. lock 能获得锁就返回 true，不能的话一直等待获得锁
    3. lock 和 lockInterruptibly，如果两个线程分别执行这两个方法，但此时中断这两个线程，
    lock 不会抛出异常，而 lockInterruptibly 会抛出异常

32. ReadWriteLock 读写锁

    为了提高性能， Java 提供了读写锁，在读的地方使用读锁，在写的地方使用写锁，灵活控制，如果没有写锁的情况下，读是无阻塞的,在一定程度上提高了程序的执行效率。 读写锁分为读锁和写锁，多个读锁不互斥，读锁与写锁互斥，这是由 jvm 自己控制的，你只要上好相应的锁即可

    ###### 读锁

    如果你的代码只读数据，可以很多人同时读，但不能同时写，那就上读锁

    ###### 写锁

    如果你的代码修改数据，只能有一个人在写，且不能同时读取，那就上写锁。总之，读的时候上读锁，写的时候上写锁

33. 共享锁和独占锁  （java 并发包提供的加锁模式分为独占锁和共享锁）

    ###### 独占锁

    独占锁模式下，每次只能有一个线程能持有锁， ReentrantLock 就是以独占方式实现的互斥锁。独占锁是一种悲观保守的加锁策略，它避免了读/读冲突，如果某个只读线程获取锁，则其他读线程都只能等待，这种情况下就限制了不必要的并发性，因为读操作并不会影响数据的一致性

    ###### 共享锁

    共享锁则允许多个线程同时获取锁，并发访问 共享资源，如： ReadWriteLock。 共享锁则是一种乐观锁，它放宽了加锁策略，允许多个执行读操作的线程同时访问共享资源

34. 重量级锁（Mutex Lock）

    Synchronized 是通过对象内部的一个叫做监视器锁（monitor）来实现的。但是监视器锁本质又是依赖于底层的操作系统的 Mutex Lock 来实现的

    操作系统实现线程之间的切换这就需要从用户态转换到核心态，这个成本非常高，状态之间的转换需要相对比较长的时间，这就是为什么
    Synchronized 效率低的原因。因此， 这种依赖于操作系统 Mutex Lock 所实现的锁我们称之为“重量级锁” 。 JDK 中对 Synchronized 做的种种优化，其核心都是为了减少这种重量级锁的使用

    JDK1.6 以后，为了减少获得锁和释放锁所带来的性能消耗，提高性能，引入了“轻量级锁”和“偏向锁”

35. 轻量级锁

36. Java 中 的 线 程 池 是 如 何 实 现 的 

    1. 在 Java 中 ， 所 谓 的 线 程 池 中 的 “ 线 程 ” ， 其 实 是 被 抽 象 为 了 一 个 静 态内 部 类  Worker， 它 基 于  AQS  实 现 ， 存 放 在 线 程 池 的HashSet<Worker> workers 成 员 变 量 中 
    2. 而 需 要 执 行 的 任 务 则 存 放 在 成 员 变 量  workQueue（ BlockingQueue<Runnable> workQueue） 中 。这 样 ， 整 个 线 程 池 实 现 的 基 本 思 想 就 是 ： 从  workQueue  中 不 断 取 出需 要 执 行 的 任 务 ， 放 在 Workers 中 进 行 处 理

37. ThreadPoolExecutor 的构造方法

    1. corePoolSize：指定了线程池中的线程数量。
    2. maximumPoolSize：指定了线程池中的最大线程数量。
    3. keepAliveTime：当前线程池数量超过 corePoolSize 时，多余的空闲线程的存活时间，即多次时间内会被销毁。
    4. unit： keepAliveTime 的单位。
    5. workQueue：任务队列，被提交但尚未被执行的任务。
    6. threadFactory：线程工厂，用于创建线程，一般用默认的即可。
    7. handler：拒绝策略，当任务太多来不及处理，如何拒绝任务。

38. 拒绝策略

    当线程池中的线程已经用完了，无法继续为新任务服务，同时，等待队列也已经排满了，再也塞不下新任务了。这时候我们就需要拒绝策略机制合理的处理这个问题。JDK 内置的拒绝策略如下

    1. AbortPolicy ： 直接抛出异常，阻止系统正常运行。

    2. CallerRunsPolicy ： 只要线程池未关闭，该策略直接在调用者线程中，运行当前被丢弃的任务。显然这样做不会真的丢弃任务，但是，任务提交线程的性能极有可能会急剧下降。

    3. DiscardOldestPolicy ： 丢弃最老的一个请求，也就是即将被执行的一个任务，并尝试再次提交当前任务。

    4. DiscardPolicy ： 该策略默默地丢弃无法处理的任务，不予任何处理。如果允许任务丢失，这是最好的一种方案。

      以上内置拒绝策略均实现了 RejectedExecutionHandler 接口，若以上策略仍无法满足实际需要，完全可以自己扩展 RejectedExecutionHandler 接口。

    ![image-20210806094243946](https://gitee.com/Sean0516/image/raw/master/img/image-20210806094243946.png)

39. Java 线程池工作过程

    1. 线程池刚创建时，里面没有一个线程。任务队列是作为参数传进来的。不过，就算队列里面
    有任务，线程池也不会马上执行它们。
    2. 当调用 execute() 方法添加一个任务时，线程池会做如下判断：
    a) 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
    b) 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列；
    c) 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要
    创建非核心线程立刻运行这个任务；
    d) 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池
    会抛出异常 RejectExecutionException。
    3. 当一个线程完成任务时，它会从队列中取下一个任务来执行。
    4. 当一个线程无事可做，超过一定的时间（keepAliveTime）时，线程池会判断，如果当前运
    行的线程数大于 corePoolSize，那么这个线程就被停掉。所以线程池的所有任务完成后，它
    最终会收缩到 corePoolSize 的大小。

40. JAVA 阻塞队列原理

    阻塞队列，关键字是阻塞，先理解阻塞的含义，在阻塞队列中，线程阻塞有这样的两种情况

    1. 当队列中没有数据的情况下，消费者端的所有线程都会被自动阻塞（挂起），直到有数据放入队列
    2. 当队列中填满数据的情况下，生产者端的所有线程都会被自动阻塞（挂起），直到队列中有空的位置，线程被自动唤醒

41. Java 中的阻塞队列

    1. ArrayBlockingQueue ：由数组结构组成的有界阻塞队列。 （公平、非公平）

       用数组实现的有界阻塞队列。此队列按照先进先出（FIFO）的原则对元素进行排序。 默认情况下不保证访问者公平的访问队列，所谓公平访问队列是指阻塞的所有生产者线程或消费者线程，当队列可用时，可以按照阻塞的先后顺序访问队列，即先阻塞的生产者线程，可以先往队列里插入元素，先阻塞的消费者线程，可以先从队列里获取元素。通常情况下为了保证公平性会降低吞吐量。我们可以使用以下代码创建一个公平的阻塞队列

    2. LinkedBlockingQueue ：由链表结构组成的有界阻塞队列。 （两个独立锁提高并发）

       基于链表的阻塞队列，同 ArrayListBlockingQueue 类似，此队列按照先进先出（FIFO）的原则对元素进行排序。而 LinkedBlockingQueue之所以能够高效的处理并发数据，还因为其对于生产者端和消费者端分别采用了独立的锁来控制数据同步，这也意味着在高并发的情况下生产者和消费者可以并行地操作队列中的数据，以此来提高整个队列的并发性能。LinkedBlockingQueue 会默认一个类似无限大小的容量（Integer.MAX_VALUE)

    3. PriorityBlockingQueue ：支持优先级排序的无界阻塞队列。 （compareTo 排序实现优先） 

       是一个支持优先级的无界队列。默认情况下元素采取自然顺序升序排列。 可以自定义实现compareTo()方法来指定元素进行排序规则，或者初始化 PriorityBlockingQueue 时，指定构造参数 Comparator 来对元素进行排序。需要注意的是不能保证同优先级元素的顺序

    4. DelayQueue：使用优先级队列实现的无界阻塞队列。 （缓存失效、定时任务 ）

       是一个支持延时获取元素的无界阻塞队列。队列使用 PriorityQueue 来实现。队列中的元素必须实现 Delayed 接口，在创建元素时可以指定多久才能从队列中获取当前元素。只有在延迟期满时才能从队列中提取元素

    5. SynchronousQueue：不存储元素的阻塞队列。（不存储数据、可用于传递数据）

       是一个不存储元素的阻塞队列。每一个 put 操作必须等待一个 take 操作，否则不能继续添加元素。SynchronousQueue 可以看成是一个传球手，负责把生产者线程处理的数据直接传递给消费者线程。队列本身并不存储任何元素，非常适合于传递性场景,比如在一个线程中使用的数据，传递给另 外 一 个 线 程 使 用 ， SynchronousQueue 的 吞 吐 量 高 于 LinkedBlockingQueue 和ArrayBlockingQueue。

    6. LinkedTransferQueue：由链表结构组成的无界阻塞队列。 相 对 于 其 他 阻 塞 队 列 ，LinkedTransferQueue 多了 tryTransfer 和 transfer 方法

       1. transfer 方法：如果当前有消费者正在等待接收元素（消费者使用 take()方法或带时间限制的poll()方法时），transfer 方法可以把生产者传入的元素立刻 transfer（传输）给消费者。如果没有消费者在等待接收元素，transfer 方法会将元素存放在队列的 tail 节点，并等到该元素被消费者消费了才返回

       2. tryTransfer 方法。则是用来试探下生产者传入的元素是否能直接传给消费者。如果没有消费者等待接收元素，则返回 false。和 transfer 方法的区别是 tryTransfer 方法无论消费者是否接收，方法立即返回。而 transfer 方法是必须等到消费者消费了才返回

          对于带有时间限制的 tryTransfer(E e, long timeout, TimeUnit unit)方法，则是试图把生产者传入的元素直接传给消费者，但是如果没有消费者消费该元素则等待指定的时间再返回，如果超时还没消费元素，则返回 false，如果在超时时间内消费了元素，则返回 true

    7. LinkedBlockingDeque：由链表结构组成的双向阻塞队列

       是一个由链表结构组成的双向阻塞队列。所谓双向队列指的你可以从队列的两端插入和移出元素。双端队列因为多了一个操作队列的入口，在多线程同时入队时，也就减少了一半的竞争。相比其他的阻塞队列，LinkedBlockingDeque 多了 addFirst，addLast，offerFirst，offerLast，peekFirst，peekLast 等方法，以 First 单词结尾的方法，表示插入，获取（peek）或移除双端队列的第一个元素。以 Last 单词结尾的方法，表示插入，获取或移除双端队列的最后一个元素。另外插入方法 add 等同于 addLast，移除方法 remove 等效于 removeFirst。但是 take 方法却等同于 takeFirst，不知道是不是 Jdk 的 bug，使用时还是用带有 First 和 Last 后缀的方法更清楚

42. 什么是多线程中的上下文切换

    多线程会共同使用一组计算机上的 CPU，而线程数大于给程序分配的 CPU 数量时，为了让各个线程都有执行的机会，就需要轮转使用 CPU。不同的线程切换使用 CPU发生的切换数据等就是上下文切换

43. 死锁与活锁的区别，死锁与饥饿的区别

    活锁：一个线程通常会有会响应其他线程的活动。如果其他线程也会响应另一个线程的活动，那么就有可能发生活锁。同死锁一样，发生活锁的线程无法继续执行。然而线程并没有阻塞——他们在忙于响应对方无法恢复工作。这就相当于两个在走廊相遇的人：甲向他自己的左边靠想让乙过去，而乙向他的右边靠想让甲过去。可见他们阻塞了对方。甲向他的右边靠，而乙向他的左边靠，他们还是阻塞了对方。

    死锁：两个或更多线程阻塞着等待其它处于死锁状态的线程所持有的锁。死锁通常发生在多个线程同时但以不同的顺序请求同一组锁的时候，死锁会让你的程序挂起无法完成任务

44. Java中的死锁

    在Java中使用多线程，就会有可能导致死锁问题。死锁会让程序一直卡住，不再程序往下执行。我们只能通过中止并重启的方式来让程序重新执行。这是我们非常不愿意看到的一种现象，我们要尽可能避免死锁的情况发生

    - 互斥条件：指进程对所分配到的资源进行排它性使用，即在一段时间内某资源只由一个进程占用。如果此时还有其它进程请求资源，则请求者只能等待，直至占有资源的进程用完释放

    - 请求和保持条件：指进程已经保持至少一个资源，但又提出了新的资源请求，而该资源已被其它进程占有，此时请求进程阻塞，但又对自己已获得的其它资源保持不放

    - 不剥夺条件：指进程已获得的资源，在未使用完之前，不能被剥夺，只能在使用完时由自己释放

    - 环路等待条件：指在发生死锁时，必然存在一个进程——资源的环形链，即进程集合{A，B，C，···，Z} 中的A正在等待一个B占用的资源；B正在等待C占用的资源，……，Z正在等待已被A占用的资源

      

45. 在 Java 中 CycliBarriar 和 CountdownLatch 有什么区别

    CyclicBarrier 可以重复使用，而 CountdownLatch 不能重复使用。 Java 的 concurrent 包里面的 CountDownLatch 其实可以把它看作一个计数器，只不过这个计数器的操作是原子操作，同时只能有一个线程去操作这个计数器，也就是同时只能有一个线程去减这个计数器里面的值。你可以向 CountDownLatch 对象设置一个初始的数字作为计数值，任何调用这个对象上的 await()方法都会阻塞，直到这个计数器的计数值被其他的线程减为 0 为止。

    

    所以在当前计数到达零之前，await 方法会一直受阻塞。之后，会释放所有等待的线程，await 的所有后续调用都将立即返回。这种现象只出现一次——计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier。

    CountDownLatch 的一个非常典型的应用场景是：有一个任务想要往下执行，但必须要等到其他的任务执行完毕后才可以继续往下执行。假如我们这个想要继续往下执行的任务调用一个 CountDownLatch 对象的 await()方法，其他的任务执行完自己的任务后调用同一个CountDownLatch 对象上的 countDown()方法，这个调用 await()方法的任务将一直阻塞等待，直到这个 CountDownLatch 对象的计数值减到 0 为止。

    CyclicBarrier 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。因为该 barrie在释放等待线程后可以重用，所以称它为循环 的barrier。

46. 为什么使用 Executor 框架比使用应用创建和管理线程好

    1. 每次执行任务创建线程 new Thread()比较消耗性能，创建一个线程是比较耗、耗资源的
    2. 调用 new Thread()创建的线程缺乏管理，被称为野线程，而且可以无限制的创建，线程之间的相互竞争会导致过多占用系统资源而导致系统瘫痪，还有线程之间的频繁交替也会消耗很多系统资源。
    3. 直接使用 new Thread() 启动的线程不利于扩展，比如定时执行、定期执行、定时定期执行、线程中断等都不便实现

47. 使用 Executor 线程池框架的优点

    1. 能复用已存在并空闲的线程从而减少线程对象的创建从而减少了消亡线程的开
       销。

    2. 可有效控制最大并发线程数，提高系统资源使用率，同时避免过多资源竞争。

    3. 框架中已经有定时、定期、单线程、并发数控制等功能。

       综上所述使用线程池框架 Executor 能更好的管理线程、提供系统资源使用率

48. Linux 上查找哪个线程使用的 CPU 时间最长

    1. 使用top 命令，然后使按下 shift + p 查找出cpu 使用率最高的 pid
    2. 根据第一步拿到的pid  使用命令 top -H -p pid  然后按下 shift +p 查找cpu 利用率最高的线程
    3. 将获取的pid 线程转换为 16 进制  printf '%x\n'  pid
    4. 使用 jstack pid > /tmp/d.dat 将进程信息打印输出
    5. 编辑 dat 文件，查找线程号对应的信息

49. 为什么代码会重排序

    在执行程序时，为了提供性能，处理器和编译器常常会对指令进行重排序，但是不能随意重排序，不是你想怎么排序就怎么排序，它需要满足以下两个条件

    1. 在单线程环境下不能改变程序运行的结果
    2. 存在数据依赖关系的不允许重排序

    需要注意的是：重排序不会影响单线程环境的执行结果，但是会破坏多线程的执行语义

50. volatile 变量和 atomic 变量有什么不同

    Volatile 变量可以确保先行关系，即写操作会发生在后续的读操作之前, 但它并不能保证原子性。例如用 volatile 修饰 count 变量那么 count++ 操作就不是原子性的

     AtomicInteger 类提供的 atomic 方法可以让这种操作具有原子性如getAndIncrement()方法会原子性的进行增量操作把当前值加一，其它数据类型和引用变量也可以进行相似操作

51. 什么是 CAS

    CAS 是 compare and swap 的缩写，即我们所说的比较交换 

    cas 是一种基于锁的操作，而且是乐观锁。在 java 中锁分为乐观锁和悲观锁。悲观锁是将资源锁住，等一个之前获得锁的线程释放锁之后，下一个线程才可以访问。而乐观锁采取了一种宽泛的态度，通过某种方式不加锁来处理资源，比如通过给记录加 version 来获取数据，性能较悲观锁有很大的提高 

    CAS 操作包含三个操作数                  内存位置（V）、预期原值（A） 新值(B)

    如果内存地址里面的值和 A 的值是一样的，那么就将内存里面的值更新成 B。CAS是通过无限循环来获取数据的，若果在第一轮循环中，a 线程获取地址里面的值被b 线程修改了，那么 a 线程需要自旋，到下次循环才有可能机会执行

    CAS  具 有 原 子 性 ， 它 的 原 子 性 由  CPU  硬 件 指 令 实 现 保 证 ， 即 使 用JNI 调 用 Native 方 法 调 用 由 C++ 编 写 的 硬 件 级 别 指 令 ， JDK 中 提供 了 Unsafe 类 执 行 这 些 操 作

52. CAS 的问题

    1. CAS 容易造成 ABA 问题

       一个线程 a 将数值改成了 b，接着又改成了 a，此时 CAS 认为是没有变化，其实是已经变化过了，而这个问题的解决方案可以使用版本号标识，每操作一次version 加 1

    2. 不能保证代码块的原子性

       CAS 机制所保证的知识一个变量的原子性操作，而不能保证整个代码块的原子性。比如需要保证 3 个变量共同进行原子性的更新，就不得不使用synchronized 了

    3. CAS 造成 CPU 利用率增加

        CAS 里面是一个循环判断的过程，如果线程一直没有获取到状态，cpu资源会一直被占用 ，可以使用自旋次数的设置，来避免这个耗时问题

53. 什么是AQS

    AQS 是 AbstactQueuedSynchronizer 的简称，它是一个 Java 提高的底层同步工具类，用一个 int 类型的变量表示同步状态，并提供了一系列的 CAS 操作来管理这个同步状态 

    AQS 是一个用来构建锁和同步器的框架，使用 AQS 能简单且高效地构造出应用广泛的大量的同步器，比如我们提到的 ReentrantLock，Semaphore，其他的诸如ReentrantReadWriteLock，SynchronousQueue，FutureTask 等等皆是基于AQS 的

    AQS定义了对双向队列所有的操作，而只开放了tryLock和tryRelease方法给开发者使用，开发者可以根据自己的实现重写tryLock和tryRelease方法，以实现自己的并发功能

54. AQS 框 架 

    1.  AQS 在 内 部 定 义 了 一 个 volatile int state 变 量 ， 表 示 同 步 状 态 ： 当 线程 调 用 lock 方 法 时 ， 如 果 state=0， 说 明 没 有 任 何 线 程 占 有 共 享 资 源的 锁 ， 可 以 获 得 锁 并 将 state=1； 如 果 state=1， 则 说 明 有 线 程 目 前 正 在使 用 共 享 变 量 ， 其 他 线 程 必 须 加 入 同 步 队 列 进 行 等 待
    2. AQS 通 过 Node 内 部 类 构 成 的 一 个 双 向 链 表 结 构 的 同 步 队 列 ， 来 完 成 线程 获 取 锁 的 排 队 工 作 ， 当 有 线 程 获 取 锁 失 败 后 ， 就 被 添 加 到 队 列 末 尾
       - Node  类 是 对 要 访 问 同 步 代 码 的 线 程 的 封 装 ， 包 含 了 线 程 本 身 及 其 状 态 叫waitStatus（ 有 五 种 不 同  取 值 ， 分 别 表 示 是 否 被 阻 塞 ， 是 否 等 待 唤 醒 ，是 否 已 经 被 取 消 等 ） ， 每 个 Node 结 点 关 联 其 prev 结 点 和 next 结点 ， 方 便 线 程 释 放 锁 后 快 速 唤 醒 下 一 个 在 等 待 的 线 程 ， 是 一 个 FIFO 的 过程
       - Node 类 有 两 个 常 量 ， SHARED 和 EXCLUSIVE， 分 别 代 表 共 享 模 式 和 独占 模 式 。 所 谓 共 享 模 式 是 一 个 锁 允 许 多 条 线 程 同 时 操 作 （ 信 号 量Semaphore 就 是 基 于 AQS 的 共 享 模 式 实 现 的 ） ， 独 占 模 式 是 同 一 个 时间 段 只 能 有 一 个 线 程 对 共 享 资 源 进 行 操 作 ， 多 余 的 请 求 线 程 需 要 排 队 等 待（ 如 ReentranLock）
    3. AQS  通 过 内 部 类  ConditionObject  构 建 等 待 队 列 （ 可 有 多 个 ） ， 当Condition  调 用  wait()  方 法 后 ， 线 程 将 会 加 入 等 待 队 列 中 ， 而 当Condition 调 用 signal() 方 法 后 ， 线 程 将 从 等 待 队 列 转 移 动 同 步 队 列 中进 行 锁 竞 争
    4.  AQS  和  Condition  各 自 维 护 了 不 同 的 队 列 ， 在 使 用  Lock  和 Condition 的 时 候 ， 其 实 就 是 两 个 队 列 的 互 相 移 动

55. 线程类的构造方法、静态块是被哪个线程调用的

    线程类的构造方法、静态块是被 new这个线程类所在的线程所调用的，而 run 方法里面的代码才是被线程自身所调用的

56. 在多线程中，什么是上下文切换(context-switching)？

    单核CPU也支持多线程执行代码，CPU通过给每个线程分配CPU时间片来实现这个机制。时间片是CPU分配给各个线程的时间，因为时间片非常短，所以CPU通过不停地切换线程执行，让我们感觉多个线程时同时执行的，时间片一般是几十毫秒（ms）。

    操作系统中，CPU时间分片切换到另一个就绪的线程，则需要保存当前线程的运行的位置，同时需要加载需要恢复线程的环境信息

57. 线程安全的级别

    ###### 不可变

    不可变的对象一定是线程安全的，并且永远也不需要额外的同步 （Java类库中大多数基本数值类如Integer、String和BigInteger都是不可变的）

    ###### 无条件的线程安全

    由类的规格说明所规定的约束在对象被多个线程访问时仍然有效，不管运行时环境如何排列，线程都不需要任何额外的同步

    如 Random 、ConcurrentHashMap、Concurrent集合、atomic

    ###### 有条件的线程安全

    有条件的线程安全类对于单独的操作可以是线程安全的，但是某些操作序列可能需要外部同步  有条件线程安全的最常见的例子是遍历由 Hashtable 或者 Vector 或者返回的迭代器

    ###### 非线程安全(线程兼容)

    线程兼容类不是线程安全的，但是可以通过正确使用同步而在并发环境中安全地使用

    ###### 线程对立

    线程对立是那些不管是否采用了同步措施，都不能在多线程环境中并发使用的代码   如如System.setOut()、System.runFinalizersOnExit()

58. 高并发、任务执行时间短的业务怎样使用线程池？并发不高、任务执行时间长的业务怎样使用线程池？并发高、业务执行时间长的业务怎样使用线程池

    1. 高并发、任务执行时间短的业务，线程池线程数可以设置为CPU核数+1，减少线程上下文的切换
    2. 并发不高、任务执行时间长的业务要区分开看
       - 假如是业务时间长集中在IO操作上，也就是IO密集型的任务，因为IO操作并不占用CPU，所以不要让所有的CPU闲下来，可以加大线程池中的线程数目，让CPU处理更多的业务
       - 假如是业务时间长集中在计算操作上，也就是计算密集型任务，这个就没办法了，和（1）一样吧，线程池中的线程数设置得少一些，减少线程上下文的切换
    3. 并发高、业务执行时间长，解决这种类型任务的关键不在于线程池而在于整体架构的设计，看看这些业务里面某些数据是否能做缓存是第一步，增加服务器是第二步，至于线程池的设置，设置参考（2）

59. 线程同步以及线程调度相关的方法

    - wait()  调用该方法的线程进入 WAITING 状态，只有等待另外线程的通知或被中断才会返回，需要注意的是调用 wait()方法后，会释放对象的锁。因此，wait 方法一般用在同步方法或同步代码块中
    - sleep  使一个正在运行的线程处于睡眠状态，与 wait 方法不同的是 sleep 不会释放当前占有的锁,sleep(long)会导致线程进入 TIMED-WATING 状态，而 wait()方法会导致当前线程进入 WATING 状态
    - yield 线程让步  yield 会使当前线程让出 CPU 执行时间片，与其他线程一起重新竞争 CPU 时间片。一般情况下，优先级高的线程有更大的可能性成功竞争得到 CPU 时间片，但这又不是绝对的，有的操作系统对线程优先级并不敏感 
    - 线程中断（interrupt） 中断一个线程，其本意是给这个线程一个通知信号，会影响这个线程内部的一个中断标识位。这个线程本身并不会因此而改变状态(如阻塞，终止等)
      - 调用 interrupt()方法并不会中断一个正在运行的线程。也就是说处于 Running 状态的线程并不会因为被中断而被终止，仅仅改变了内部维护的中断标识位而已
      - 若调用 sleep()而使线程处于 TIMED-WATING 状态，这时调用 interrupt()方法，会抛出InterruptedException,从而使线程提前结束 TIMED-WATING 状态
      - 许多声明抛出 InterruptedException 的方法(如 Thread.sleep(long mills 方法))，抛出异常前，都会清除中断标识位，所以抛出异常后，调用 isInterrupted()方法将会返回 false
      - 中断状态是线程固有的一个标识位，可以通过此标识位安全的终止线程。比如,你想终止一个线程thread的时候，可以调用thread.interrupt()方法，在线程的run方法内部可以根据 thread.isInterrupted()的值来优雅的终止线程
    - Join    等待其他线程终止  join() 方法，等待其他线程终止，在当前线程中调用一个线程的 join() 方法，则当前线程转为阻塞状态，回到另一个线程结束，当前线程再由阻塞状态变为就绪状态，等待 cpu 的宠幸
    - notify 唤醒一个处于等待状态的线程，当然在调用此方法时，并不能确切的唤醒某一个等待状态的线程，而是由JVM 确定唤醒那个线程，而且和优先级无关
    - notifyAll  唤醒所有处于等待状态的线程，该方法并不是将对象的锁给所有的线程，而是让他们竞争，只有获得锁的线程，才能进入就绪状态

60. 线程上下文切换

    巧妙地利用了时间片轮转的方式, CPU 给每个任务都服务一定的时间，然后把当前任务的状态保存下来，在加载下一任务的状态后，继续服务下一任务，任务的状态保存及再加载, 这段过程就叫做上下文切换。时间片轮转的方式使多个任务在同一颗 CPU 上执行变成了可能

    1. 上下文

       是指某一时间点 CPU 寄存器和程序计数器的内容

    2. 寄存器

       是 CPU 内部的数量较少但是速度很快的内存（与之对应的是 CPU 外部相对较慢的 RAM 主内存）。寄存器通过对常用值（通常是运算的中间值）的快速访问来提高计算机程序运行的速度

    3. 程序计数器

       是一个专用的寄存器，用于表明指令序列中 CPU 正在执行的位置，存的值为正在执行的指令的位置或者下一个将要被执行的指令的位置，具体依赖于特定的系统

    4. PCB-“切换桢

       上下文切换可以认为是内核（操作系统的核心）在 CPU 上对于进程（包括线程）进行切换，上下文切换过程中的信息是保存在进程控制块（PCB, process control block）中的。PCB 还经常被称作“切换桢”（switchframe）。信息会一直保存到 CPU 的内存中，直到他们被再次使用

    5. 上下文切换的活动

       1. 挂起一个进程，将这个进程在 CPU 中的状态（上下文）存储于内存中的某处
       2. 在内存中检索下一个进程的上下文并将其在 CPU 的寄存器中恢复、
       3. 跳转到程序计数器所指向的位置（即跳转到进程被中断时的代码行），以恢复该进程在程序中

    6. 引起线程上下文切换 引起线程上下文切换的原因

       1. 当前执行任务的时间片用完之后，系统 CPU 正常调度下一个任务
       2. 当前执行任务碰到 IO 阻塞，调度器将此任务挂起，继续下一任务
       3. 多个任务抢占锁资源，当前任务没有抢到锁资源，被调度器挂起，继续下一任务
       4. 用户代码挂起当前任务，让出 CPU 时间
       5. 硬件中断

61. 

### JVM

![image-20210805172149574](https://gitee.com/Sean0516/image/raw/master/img/image-20210805172149574.png)

1. JRE JDK JVM 以及JIT 之间有什么不同

   JRE 代表 Java 运行时（Java run-time），是运行 Java 引用所必须的。JDK 代表 Java 开发工具（Java development kit），是 Java 程序的开发工具，如 Java编译器，它也包含 JRE。JVM 代表 Java 虚拟机（Java virtual machine），它的责任是运行 Java 应用。JIT 代表即时编译（Just In Time compilation），当代执行的次数超过一定的阈值时，会将 Java 字节码转换为本地代码，如，主要的热点代码会被准换为本地代码，这样有利大幅度提高 Java 应用的性

   ![image-20210630140457284](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210630140457284.png)

2. 程序计数器（线程私有）

   一块较小的内存空间, 是当前线程所执行的字节码的行号指示器，每条线程都要有一个独立的程序计数器，这类内存也称为“线程私有” 的内存。

   正在执行 java 方法的话，计数器记录的是虚拟机字节码指令的地址（当前指令的地址） 。如果还是 Native 方法，则为空。

   这个内存区域是唯一一个在虚拟机中没有规定任何 OutOfMemoryError 情况的区域

3. 虚拟机栈（线程私有）

   是描述java方法执行的内存模型，每个方法在执行的同时都会创建一个栈帧（Stack Frame）用于存储局部变量表、操作数栈、动态链接、方法出口等信息。 每一个方法从调用直至执行完成的过程，就对应着一个栈帧在虚拟机栈中入栈到出栈的过程。

   栈帧（ Frame）是用来存储数据和部分过程结果的数据结构，同时也被用来处理动态链接(Dynamic Linking)、 方法返回值和异常分（DispatchException）。 栈帧随着方法调用而创建，随着方法结束而销毁——无论方法是正常完成还是异常完成（抛出了在方法内未被捕获的异常）都算作方法结束。

4. 本地方法区(线程私有)

   本地方法区和 Java Stack 作用类似, 区别是虚拟机栈为执行 Java 方法服务, 而本地方法栈则为Native 方法服务, 如果一个 VM 实现使用 C-linkage 模型来支持 Native 调用, 那么该栈将会是一个C 栈，但 HotSpot VM 直接就把本地方法栈和虚拟机栈合二为一

5. 堆（Heap-线程共享） -运行时数据区

   是被线程共享的一块内存区域， 创建的对象和数组都保存在 Java 堆内存中，也是垃圾收集器进行垃圾收集的最重要的内存区域。 由于现代VM 采用分代收集算法, 因此 Java 堆从 GC 的角度还可以细分为: 新生代(Eden 区、 From Survivor 区和 To Survivor 区)和老年代

6. 方法区/永久代（线程共享）

   即我们常说的永久代(Permanent Generation), 用于存储被 JVM 加载的类信息、 常量、 静态变量、 即时编译器编译后的代码等数据.HotSpot VM把GC分代收集扩展至方法区, 即使用Java堆的永久代来实现方法区, 这样 HotSpot 的垃圾收集器就可以像管理 Java 堆一样管理这部分内存,而不必为方法区开发专门的内存管理器(永久带的内存回收的主要目标是针对常量池的回收和类型的卸载, 因此收益一般很小) 。

   

   运行时常量池（Runtime Constant Pool）是方法区的一部分。 Class 文件中除了有类的版本、字段、方法、接口等描述等信息外，还有一项信息是常量池 （Constant Pool Table），用于存放编译期生成的各种字面量和符号引用，这部分内容将在类加载后存放到方法区的运行时常量池中。 Java 虚拟机对 Class 文件的每一部分（自然也包括常量池）的格式都有严格的规定，每一个字节用于存储哪种数据都必须符合规范上的要求，这样才会被虚拟机认可、装载和执行

7. Java 中堆和栈有什么区别

   JVM 中堆和栈属于不同的内存区域，使用目的也不同。栈常用于保存方法帧和局部变量，而对象总是在堆上分配。栈通常都比堆小，也不会在多个线程之间共享，而堆被整个 JVM 的所有线程共享

   ###### 栈

   在函数中定义的一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配，当在一段代码块定义一个变量时，Java 就在栈中为这个变量分配内存空间，当超过变量的作用域后，Java 会自动释放掉为该变量分配的内存空间，该内存空间可以立即被另作它用

   ###### 堆

   堆内存用来存放由 new 创建的对象和数组，在堆中分配的内存，由 Java 虚拟机的自动垃圾回收器来管理。在堆中产生了一个数组或者对象之后，还可以在栈中定义一个特殊的变量，让栈中的这个变量的取值等于数组或对象在堆内存中的首地址，栈中的这个变量就成了数组或对象的引用变量，以后就可以在程序中使用栈中的引用变量来访问堆中的数组或者对象，引用变量就相当于是为数组或者对象起的一个名称

8. 垃圾回收器的基本原理是什么

   对于GC来说，当程序员创建对象时，GC就开始监控这个对象的地址、大小以及使用情况。通常，GC采用有向图的方式记录和管理堆(heap)中的所有对象。通过这种方式确定哪些对象是"可达的"，哪些对象是"不可达的"。当GC确定一些对象为"不可达"时，GC就有责任回收这些内存空间

9. 新生代

   是用来存放新生的对象。一般占据堆的 1/3 空间。由于频繁创建对象，所以新生代会频繁触发MinorGC 进行垃圾回收。新生代又分为 Eden区、 ServivorFrom、 ServivorTo 三个区

   ###### Eden 区

   Java 新对象的出生地（如果新创建的对象占用内存很大，则直接分配到老年代）。当 Eden 区内存不够的时候就会触发 MinorGC，对新生代区进行一次垃圾回收

   ###### Servivor From

   上一次 GC 的幸存者，作为这一次 GC 的被扫描者

   ###### Servivor To

   保留了一次 MinorGC 过程中的幸存者

   ###### MinorGC 的过程（复制->清空->互换）

   1. 首先，把 Eden 和 ServivorFrom 区域中存活的对象复制到 ServicorTo 区域（如果有对象的年龄以及达到了老年的标准，则赋值到老年代区），同时把这些对象的年龄+1（如果 ServicorTo 不够位置了就放到老年区）
   2. 然后，清空 Eden 和 ServicorFrom 中的对象
   3. 最后， ServicorTo 和 ServicorFrom 互换，原 ServicorTo 成为下一次 GC 时的 ServicorFrom区

10. 老年代

   主要存放应用程序中生命周期长的内存对象。
   老年代的对象比较稳定，所以 MajorGC 不会频繁执行。在进行 MajorGC 前一般都先进行了一次 MinorGC，使得有新生代的对象晋身入老年代，导致空间够用时才触发。当无法找到足够大的连续空间分配给新创建的较大对象时也会提前触发一次 MajorGC 进行垃圾回收腾出空间。

   MajorGC 采用标记清除算法：首先扫描一次所有老年代，标记出存活的对象，然后回收没有标记的对象。 ajorGC 的耗时比较长，因为要扫描再回收。MajorGC 会产生内存碎片，为了减少内存损耗，我们一般需要进行合并或者标记出来方便下次直接分配。当老年代也满了装不下的时候，就会抛出OOM（Out of Memory）异常。

   

11. 永久代 与 元数据（JAVA8）

    指内存的永久保存区域，主要存放 Class 和 Meta（元数据）的信息,Class 在被加载的时候被放入永久区域， 它和和存放实例的区域不同,GC不会在主程序运行期对永久区域进行清理。所以这也导致了永久代的区域会随着加载的 Class 的增多而胀满，最终抛出 OOM 异常

    

    在 Java8 中， 永久代已经被移除，被一个称为“元数据区”（元空间）的区域所取代。元空间的本质和永久代类似，元空间与永久代之间最大的区别在于： 元空间并不在虚拟机中，而是使用本地内存。因此，默认情况下，元空间的大小仅受本地内存限制。 类的元数据放入nativememory, 字符串池和类的静态变量放入 java 堆中， 这样可以加载多少类的元数据就不再由MaxPermSize 控制, 而由系统的实际可用空间来控制。

12. 新生代、老年代、持久代都存储哪些东西

    ###### 新生代

    方法中new 一个对象，就会先进入新生代

    ###### 老年代

    1. 新生代中经历了N次垃圾回收仍然存活的对象就会被放到老年代中
    2. 大对象一般直接放入老年代
    3. 当Survivor空间不足。需要老年代担保一些空间，也会将对象放入老年代

    ###### 永久代

    方法区/ 元数据

    ![image-20210805172857989](https://gitee.com/Sean0516/image/raw/master/img/image-20210805172857989.png)

13. 永久代中是否回发生垃圾回收

    垃圾回收不会发生在永代，如果永久代满了或者超过了临界值，会触发 Full  GC   Java 8 中已经移除了永久代，新加了一个叫做元数据区的native 内存区

14. Full GC Major GC Minor GC 之间的区别

    ###### Minor GC 

    新生代空间的垃圾回收

    ###### Major GC 

    老年代垃圾回收 ，出现MajorGC 通常会出现至少一次的Minor GC

    ###### Full GC 

    正对整个新生代 老年代  元空间 的全局范围GC

15. 如何判断对象可以被回收

    1. 引用计数法

       在 Java 中，引用和对象是有关联的。如果要操作对象则必须用引用进行。因此，很显然一个简单的办法是通过引用计数来判断一个对象是否可以回收。

       

       所谓引用计数法就是给每一个对象设置一个引用计数器，每当有一个地方引用这个对象时，就将计数器加一，引用失效时，计数器就减一。当一个对象的引用计数器为零时，说明此对象没有被引用，也就是“死对象”,将会被垃圾回收

       

       引用计数法有一个缺陷就是无法解决循环引用问题，也就是说当对象 A 引用对象 B，对象B 又引用者对象 A，那么此时 A,B 对象的引用计数器都不为零，也就造成无法完成垃圾回收，所以主流的虚拟机都没有采用这种算法

    2. 可达性分析

       为了解决引用计数法的循环引用问题， Java 使用了可达性分析的方法。通过一系列的“GC roots”对象作为起点搜索。如果在“GC roots”和一个对象之间没有可达路径，则称该对象是不可达的。要注意的是，不可达对象不等价于可回收对象， 不可达对象变为可回收对象至少要经过两次标记过程。两次标记后仍然是可回收对象，则将面临回收

16. Java 垃圾回收机制

    在jvm 中，有一个垃圾回收线程，它是低优先级的，在正常情况下是不会执行的，只有在虚拟机空闲或者当前堆内存不足时，才会触发执行，扫面那些没有被任何引用的对象，并将它们添加到要回收的集合中，进行回收

17. 垃圾回收算法

    - 标记清除算法

      最基础的垃圾回收算法，分为两个阶段，标注和清除。标记阶段标记出所有需要回收的对象，清除阶段回收被标记的对象所占用的空间。  该算法最大的问题是内存碎片化严重，后续可能发生大对象不能找到可利用空间的问题

    - 复制算法（copying）

      为了解决 Mark-Sweep 算法内存碎片化的缺陷而被提出的算法。按内存容量将内存划分为等大小的两块。每次只使用其中一块，当这一块内存满后将尚存活的对象复制到另一块上去，把已使用的内存清掉

      这种算法虽然实现简单，内存效率高，不易产生碎片，但是最大的问题是可用内存被压缩到了原本的一半。且存活对象增多的话， Copying算法的效率会大大降低    （算法进行改进。将内存划分为 8:1:1 ） 较大那份内存交 Eden 区，其余是两块较小的内存区叫 Survior 区。每次都会优先使用 Eden 区，若 Eden 区满，就将对象复制到第二块内存区上，然后清除 Eden 区

    - 标记整理算法(Mark-Compact)

      结合了以上两个算法，为了避免缺陷而提出。标记阶段和 Mark-Sweep 算法相同， 标记后不是清理对象，而是将存活对象移向内存的一端。然后清除端边界外的对象

    - 分代收集算法

      分代收集法是目前大部分 JVM 所采用的方法，其核心思想是根据对象存活的不同生命周期将内存划分为不同的域，一般情况下将 GC 堆划分为老生代(Tenured/Old Generation)和新生代(YoungGeneration)。老生代的特点是每次垃圾回收时只有少量对象需要被回收，没有额外的空间进行分配担保，所以可以采用标记--整理和标记-清除   新生代的特点是每次垃圾回收时都有大量垃圾需要被回收，因此可以采用复制算法

18. 新生代与复制算法

    目前大部分 JVM 的 GC 对于新生代都采取 Copying 算法，因为新生代中每次垃圾回收都要回收大部分对象，即要复制的操作比较少，但通常并不是按照 1： 1 来划分新生代。一般将新生代划分为一块较大的 Eden 空间和两个较小的 Survivor 空间(From Space, To Space)，每次使用Eden 空间和其中的一块 Survivor 空间，当进行回收时，将该两块空间中还存活的对象复制到另一块 Survivor 空间中

19. 老年代与标记复制算法

    因为对象存活率高、没有额外空间对它进行分配担保, 就必须采用“标记—清理”或“标记—整理” 算法来进行回收, 不必进行内存复制, 且直接腾出空闲内存
    
    
    
20. GC 垃圾收集器

    ![image-20210630141113554](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210630141113554.png)

    - Serial 垃圾收集器（单线程、 复制算法）

      Serial收集器是Hotspot运行在Client模式下的默认新生代收集器, 它在进行垃圾收集时，会暂停所有的工作进程，用一个线程去完成GC工作

      新生代采用复制算法 ， 老年代采用标记-整理算法 

      特点：简单高效，适合jvm管理内存不大的情况（十兆到百兆）

    - ParNew 垃圾收集器（Serial+多线程）

      ParNew收集器其实是Serial的多线程版本，回收策略完全一样，但是他们又有着不同 。所以它配合多核心的cpu效果更好，如果是一个cpu，他俩效果就差不多。（可用-XX:ParallelGCThreads参数控制GC线程数）

    - CMS

      CMS(Concurrent Mark Sweep)收集器是一款具有划时代意义的收集器, 一款真正意义上的并发收集器,虽然现在已经有了理论意义上表现更好的G1收集器, 但现在主流互联网企业线上选用的仍是CMS(如Taobao),又称多并发低暂停的收集器

      ![](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210729150102785.png)

      它是基于标记-清除算法实现的。整个过程分4个步骤

      1.  初始标记(CMS initial mark):仅只标记一下GC Roots能直接关联到的对象, 速度很快
      2. 并发标记(CMS concurrent mark: GC Roots Tracing过程)
      3. 重新标记(CMS remark):修正并发标记期间因用户程序继续运行而导致标记产生变动的那一部分对象的标记记录
      4. 并发清除(CMS concurrent sweep: 已死对象将会就地释放)

      初始标记、重新标记需要STW(stop the world 即：挂起用户线程)操作。因为最耗时的操作是并发标记和并发清除。所以总体上我们认为CMS的GC与用户线程是并发运行的

      ###### 优点 

      并发收集、低停顿

      ###### 缺点

      1. CMS默认启动的回收线程数=(CPU数目+3)*4  当CPU数>4时, GC线程最多占用不超过25%的CPU资源, 但是当CPU数<=4时, GC线程可能就会过多
         的占用用户CPU资源, 从而导致应用程序变慢, 总吞吐量降低
      2. 无法清除浮动垃圾（GC运行到并发清除阶段时用户线程产生的垃圾），因为用户线程是需要内存的，如果浮动垃圾施放不及时，很可能就造成内存溢出，所以CMS不能像别的垃圾收集器那样等老年代几乎满了才触发，CMS提供了参数 -XX:CMSInitiatingOccupancyFraction 来设置GC触发百分比(1.6后默认92%),当然我们还得设置启用该策略 -XX:+UseCMSInitiatingOccupancyOnly
      3. 因为CMS采用标记-清除算法，所以可能会带来很多的碎片，如果碎片太多没有清理，jvm会因为无法分配大对象内存而触发GC，因此CMS提供了 -XX:+UseCMSCompactAtFullCollection 参数，它会在GC执行完后接着进行碎片整理，但是又会有个问题，碎片整理不能并发，所以必须单线程去处理，所以如果每次GC完都整理用户线程stop的时间累积会很长，所以XX:CMSFullGCsBeforeCompaction 参数设置隔几次GC进行一次碎片整理

    - G1 

      G1最大的特点是引入分区的思路，弱化分代的概念，合理利用垃圾收集各个周期的资源，解决了其他收集器甚至CMS的众多缺陷

      因为每个区都有E、S、O代，所以在G1中，不需要对整个Eden等代进行回收，而是寻找可回收对象比较多的区，然后进行回收（虽然也需要STW操作，但是花费的时间是很少的），保证高效率

      ###### 新生代收集

      G1的新生代收集跟ParNew类似，如果存活时间超过某个阈值，就会被转移到S/O区。年轻代内存由一组不连续的heap区组成, 这种方法使得可以动态调整各代区域的大小

      ###### 老年代收集

      1. 初始标记 (Initial Mark: Stop the World Event)

         在G1中, 该操作附着一次年轻代GC, 以标记Survivor中有可能引用到老年代对象的Regions

      2. 扫描根区域 (Root Region Scanning: 与应用程序并发执行)  

         扫描Survivor中能够引用到老年代的references. 但必须在Minor GC触发前执行完

      3. 并发标记 (Concurrent Marking : 与应用程序并发执行)
         在整个堆中查找存活对象, 但该阶段可能会被Minor GC中断

      4. 重新标记 (Remark : Stop the World Event)
         完成堆内存中存活对象的标记. 使用snapshot-at-the-beginning(SATB, 起始快照)算法, 比CMS所用算法要快得多(空Region直接被移除并回收, 并计算所有区域的活跃度).

      5. 清理 (Cleanup : Stop the World Event and Concurrent)
         在含有存活对象和完全空闲的区域上进行统计(STW)、擦除Remembered Sets(使用RememberedSet来避免扫描全堆，每个区都有对应一个Set用来记录引用信息、读写操作记录)(STW)、重置空regions并将他们返还给空闲列表(free list)(Concurrent)

      

21. JVM 类加载机制

    类加载机制，是指虚拟机把描述类的数据从 Class 文件加载到内存，并对数据进行校验，解析和初始化，最终形成可以被虚拟机直接使用的 java 类型

    JVM 类加载机制分为五个部分： 加载 ，验证，准备，解析， 初始化

    ###### 加载

    加载是类加载过程中的一个阶段， 这个阶段会在内存中生成一个代表这个类的 java.lang.Class 对象， 作为方法区这个类的各种数据的入口。注意这里不一定非得要从一个 Class 文件获取，这里既可以从 ZIP 包中读取（比如从 jar 包和 war 包中读取），也可以在运行时计算生成（动态代理），也可以由其它文件生成（比如将 JSP 文件转换成对应的 Class 类）  在这一阶段，将完成以下三件事：

    1. 通过一个类的全限定名获取该类的二进制流
    2. 将该二进制流中的静态存储结构转换为方法去进行时数据结构
    3. 在内存中生成该类的Class 对象，作为该类的数据访问入库

    ###### 验证

    这一阶段的主要目的是为了确保 Class 文件的字节流中包含的信息是否符合当前虚拟机的要求，并且不会危害虚拟机自身的安全，该阶段主要完成以下四种验证

    1. 文件格式验证： 验证字节流是否符合 Class 文件的规范，如主次版本号是否在当前虚拟机范围内，常量池中的常量是否有不被支持的类型
    2. 元数据验证:对字节码描述的信息进行语义分析，如这个类是否有父类，是否集成了不被继承的类等
    3. 字节码验证：是整个验证过程中最复杂的一个阶段，通过验证数据流和控制流的分析，确定程序语义是否正确，主要针对方法体的验证。如：方法中的类型转换是否正确，跳转指令是否正确等
    4. 符号引用验证：这个动作在后面的解析过程中发生，主要是为了确保解析动作能正确执行

    ###### 准备

    准备阶段是为类的静态变量分配内存并将其初始化为默认值，这些内存都将在方法区中进行分配。准备阶段不分配类中的实例变量的内存，实例变量将会在对象实例化时随着对象一起分配在 Java 堆中

    ```java
    public static int value=123; //在准备阶段 value 初始值为 0 。在初始化阶段才会变为 123 
    ```

    ###### 解析

    该阶段主要完成符号引用到直接引用的转换动作。解析动作并不一定在初始化动作完成之前，也有可能在初始化之后

    ###### 初始化

    初始化阶段是类加载最后一个阶段，前面的类加载阶段之后，除了在加载阶段可以自定义类加载器以外，其它操作都由 JVM 主导。到了初始阶段，才开始真正执行类中定义的 Java 程序代码

    初始化阶段是执行类构造器<client>方法的过程。<client>方法是由编译器自动收集类中的类变量的赋值操作和静态语句块中的语句合并而成的。虚拟机会保证子<client>方法执行之前，父类的<client>方法已经执行完毕，如果一个类中没有对静态变量赋值也没有静态语句块，那么编译器可以不为这个类生成<client>()方法

    

22. JVM 加载Class 文件的原理机制

    类（Class）只有被加载到 JVM 后才能运行。当运行指定程序时，JVM 会将编译生成的 .class 文件按照需求和一定的规则加载到内存中，并组织成为一个完整的 Java 应用程序。这个加载过程是由类加载器完成，具体来说，就是由 ClassLoader 和它的子类来实现的。类加载器本身也是一个类，其实质是把类文件从硬盘读取到内存中

    类的加载方式分为隐式加载和显示加载。隐式加载指的是程序在使用 new 等方式创建对象时，会隐式地调用类的加载器把对应的类加载到 JVM 中。显示加载指的是通过直接调用 class.forName()方法来把所需的类加载到 JVM 中

23. 类加载器

    虚拟机设计团队把加载动作放到 JVM 外部实现，以便让应用程序决定如何获取所需的类， JVM 提供了4 种类加载器：

    ###### 启动类加载器(Bootstrap ClassLoader)

    负责加载 JAVA_HOME\lib 目录中的， 或通过-Xbootclasspath 参数指定路径中的， 且被虚拟机认可（按文件名识别， 如 rt.jar） 的类。

    ###### 扩展类加载器(Extension ClassLoader)

    负责加载 JAVA_HOME\lib\ext 目录中的，或通过 java.ext.dirs 系统变量指定路径中的类库。

    ###### 应用程序类加载器(Application ClassLoader)：

    负责加载用户路径（classpath）上的类库。JVM 通过双亲委派模型进行类的加载， 当然我们也可以通过继承 java.lang.ClassLoader实现自定义的类加载器。

    ###### 用户自定义类加载器

    通过继承 java.lang.ClassLoader 类的方式实现

    ![image-20210630142521914](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210630142521914.png)

24. 双亲委派机制

    当一个类收到了类加载请求，他首先不会尝试自己去加载这个类，而是把这个请求委派给父类去完成，每一个层次类加载器都是如此，因此所有的加载请求都应该传送到启动类加载其中，只有当父类加载器反馈自己无法完成这个请求的时候（在它的加载路径下没有找到所需加载的Class）， 子类加载器才会尝试自己去加载。

    采用双亲委派的一个好处是比如加载位于 rt.jar 包中的类 java.lang.Object，不管是哪个加载器加载这个类，最终都是委托给顶层的启动类加载器进行加载，这样就保证了使用不同的类加载器最终得到的都是同样一个 Object 对象

    ![image-20210630142606545](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210630142606545.png)

25. 什么时候会触发FullGC

    1. 老年代空间不足

       老年代只有在新生代对象转入及创建为大对象、大数组时才会出现不足的现象，当执行Full GC后空间仍然不足，则抛出如下错误：java.lang.OutOfMemoryError: Java heap space

    2. 调用System.gc时，系统建议执行Full GC，但是不必然执行

    3. 方法区空间不足

    4. 通过Minor GC后进入老年代的平均大小大于老年代的剩余空间

    

26. 对象分配规则

    1. 对象优先分配在Eden区，如果Eden区没有足够的空间时，虚拟机执行一次Minor GC。
    2. 大对象直接进入老年代（大对象是指需要大量连续内存空间的对象）。这样做的目的是避免在Eden区和两个Survivor区之间发生大量的内存拷贝（新生代采用复制算法收集内存）。
    3. 长期存活的对象进入老年代。虚拟机为每个对象定义了一个年龄计数器，如果对象经过了1次Minor GC那么对象会进入Survivor区，之后每经过一次Minor GC那么对象的年龄加1，知道达到阀值对象进入老年区。
    4. 动态判断对象的年龄。如果Survivor区中相同年龄的所有对象大小的总和大于Survivor空间的一半，年龄大于或等于该年龄的对象可以直接进入老年代。
    5. 空间分配担保。每次进行Minor GC时，JVM会计算Survivor区移至老年区的对象的平均大小，如果这个值大于老年区的剩余值大小则进行一次Full GC，如果小于检查HandlePromotionFailure设置，如果true则只进行Monitor GC,如果false则进行Full GC、

27. Java对象创建过程

    1. 虚拟机遇到一个new 指令，首先将去检查整个指令的参数是否能在常量池中定位到这个类的符号引用，并且检查这个符号引用的类是否已经被加载--解析--初始化
    2. 如果类已经被加载，那么进行第三步。 如果没有被加载，则需要先进行类的加载
    3. 类加载通过后，进行新生对象的内存分配 （对象生成需要的内存大小在类加载完成后就可以完全确定）
    4. 为对象分配内存。一种办法“指针碰撞”、一种办法“空闲列表”，最终常用的办法“本地线程缓冲分配(TLAB)”
    5. 空间申请完毕后，JVM 需要将内存的空间都初始化为0 值，如果使用TLAB ，就可以在TLAB 分配的时候进行该进行的工作
    6. 对对象头进行必要设置
    7. 完成上面的步骤之后，从JVM 来看，一个对象基本完成了， 但是从Java程序代码来看，对象创建才刚刚开始，需要执行 init 方法，按照程序中设定的初始化操作初始化。 

28. 简述Java的对象结构

    Java对象由三个部分组成：对象头、实例数据、对齐填充。

    1. 对象头由两部分组成，第一部分存储对象自身的运行时数据：哈希码、GC分代年龄、锁标识状态、线程持有的锁、偏向线程ID（一般占32/64 bit）
    2. 第二部分是指针类型，指向对象的类元数据类型（即对象代表哪个类）。如果是数组对象，则对象头中还有一部分用来记录数组长度。
    3. 实例数据用来存储对象真正的有效信息（包括父类继承下来的和自己定义的）对齐填充：JVM要求对象起始地址必须是8字节的整数倍（8字节对齐

29. 你知道哪些JVM性能调优

    设定堆内存大小   -Xmx：堆内存最大限制。
    设定新生代大小。 新生代不宜太小，否则会有大量对象涌入老年代
    -XX:NewSize：新生代大小
    -XX:NewRatio 新生代和老生代占比
    -XX:SurvivorRatio：Eden 区和survivor空间的占比
    设定垃圾回收器 年轻代用 -XX:+UseParNewGC 年老代用-XX:+UseConcMarkSweepGC

30. OOM 异常排查

    1. 使用top 查看服务器系统状态 
    2. ps - aux | grep java 找出当前java 进程的pid
    3.  jstat  -gcutil pid interval 查看当前GC 状态
    4. jmap  -histo:live pid 可用统计存活对象的分布情况，从高到低查看占据内存最多的对象
    5. jmap -dump:format=b file= 文件名 [pid] 生成dump 文件
    6. 使用性能分析工具对 dump 文件进行分析

31. 对象是怎么从年轻代进入老年代的

    1. 如果对象够老，会通过提升（Promotion）进入老年代，这一般是根据对象的年龄进行判断的
    2. 动态对象年龄判定。有的垃圾回收算法，比如G1，并不要求age必须达到15才能晋升到老年代，它会使用一些动态的计算方法。
    3. 分配担保。当 Survivor 空间不够的时候，就需要依赖其他内存（指老年代）进行分配担保。这个时候，对象也会直接在老年代上分配
    4. 超出某个大小的对象将直接在老年代分配。不过这个值默认为0，意思是全部首选Eden区进行分配

32. OOM你遇到过哪些情况，SOF你遇到过哪些情况

    1. OutOfMemoryError异常
    2. 虚拟机栈和本地方法栈溢出
    3. 运行时常量池溢出
    4. 方法区溢出
    5. 堆栈溢出StackOverflow

33. 哪些手段用来排查内存溢出

    使用jstat命令，发现Old区在一直增长。我使用jmap命令，导出了一份线上堆栈，然后使用MAT进行分析。通过对GC Roots的分析，我发现了一个非常大的HashMap对象，这个原本是有位同学做缓存用的，但是一个无界缓存，造成了堆内存占用一直上升。后来，将这个缓存改成 guava的Cache，并设置了弱引用，故障就消失了

34. 生产上如何配置垃圾收集器的

    

35. safepoint是什么

    当发生GC时，用户线程必须全部停下来，才可以进行垃圾回收，这个状态我们可以认为JVM是安全的（safe），整个堆的状态是稳定的

    如果在GC前，有线程迟迟进入不了safepoint，那么整个JVM都在等待这个阻塞的线程，造成了整体GC的时间变长

### Spring

![image-20210806111451329](https://gitee.com/Sean0516/image/raw/master/img/image-20210806111451329.png)

1. 什么是Spring IOC 容器

   Spring 框架的核心是 Spring 容器。容器创建对象，将它们装配在一起，配置它们并管理它们的完整生命周期。Spring 容器使用依赖注入来管理组成应用程序的组件。容器通过读取提供的配置元数据来接收对象进行实例化，配置和组装的指令。该元数据可以通过 XML，Java 注解或 Java 代码提供

   ##### IoC 的一些好处是：

   1. 它将最小化应用程序中的代码量。
   2. 它将使您的应用程序易于测试，因为它不需要单元测试用例中的任何单例或 JNDI 查找机制。
   3. 它以最小的影响和最少的侵入机制促进松耦合。
   4. 它支持即时的实例化和延迟加载服务

2. 什么是依赖注入

   在依赖注入中，您不必创建对象，但必须描述如何创建它们。您不是直接在代码中将组件和服务连接在一起，而是描述配置文件中哪些组件需要哪些服务。由 IoC容器将它们装配在一起

3. spring 中有多少种 IOC 容器

   BeanFactory - BeanFactory 就像一个包含 bean 集合的工厂类。它会在客户端要求时实例化 bean。
   ApplicationContext - ApplicationContext 接口扩展了 BeanFactory 接口。它在 BeanFactory 基础上提供了一些额外的功能

   | BeanFactory              | ApplicationContext     |
   | ------------------------ | ---------------------- |
   | 使用懒加载               | 使用即时加载           |
   | 使用语法显式提高资源对象 | 自己创建和管理资源对象 |
   | 不支持国际化             | 支持国际化             |
   | 不支持基于依赖的注解     | 支持基于依赖的注解     |

4. Spring IoC 的实现机制

   Spring 中的 IoC 的实现原理就是工厂模式加反射机制

5. 什么是 spring bean

   1. 它们是构成用户应用程序主干的对象。
   2. Bean 由 Spring IoC 容器管理。
   3. 它们由 Spring IoC 容器实例化，配置，装配和管理。
   4. Bean 是基于用户提供给容器的配置元数据创建

6. spring 支持的 bean scope

   Singleton - 默认，每个容器中只有一个bean的实例，单例的模式由BeanFactory自身来维护

   Prototype - 为每一个bean请求提供一个实例

   Request - 为每一个网络请求创建一个实例，在请求完成以后，bean会失效并被垃圾回收器回收

   Session - 每一次 HTTP 请求都会产生一个新的 bean，同时该 bean 仅在当前HTTP session 内有效。在session过期后，bean会随之失效

   Global-session -  全局作用域，global-session和Portlet应用相关。当你的应用部署在Portlet容器中工作时，它包含很多portlet。如果你想要声明让所有的portlet共用全局的存储变量的话，那么这全局变量需要存储在global-session中。全局作用域与Servlet中的session作用域效果相同

   仅当用户使用支持 Web 的 Application Context 时，最后三个才可用

   ![image-20210806111818713](https://gitee.com/Sean0516/image/raw/master/img/image-20210806111818713.png)

7. spring bean 容器的生命周期

   1. Spring 容器根据配置中的 bean 定义中实例化 bean。

      对于BeanFactory容器，当客户向容器请求一个尚未初始化的bean时，或初始化bean的时候需要注入另一个尚未初始化的依赖时，容器就会调用createBean进行实例化。对于ApplicationContext容器，当容器启动结束后，通过获取BeanDefinition对象中的信息，实例化所有的bean

   2. Spring 使用依赖注入填充所有属性，如 bean 中所定义的配置。实例化后的对象被封装在BeanWrapper对象中，紧接着，Spring根据BeanDefinition的信息 以及 通过BeanWrapper提供的设置属性的接口完成依赖注入

   3. 如果 bean 实现BeanNameAware 接口，则工厂通过传递 bean 的 ID 来调用setBeanName()。

   4. 如果 bean 实现 BeanFactoryAware 接口，工厂通过传递自身的实例来调用 setBeanFactory()。

   5. 如果存在与 bean 关联的任何BeanPostProcessors，则调用 preProcessBeforeInitialization() 方法。

   6. 如果为 bean 指定了 init 方法（ 的 init-method 属性），那么将调用它。

   7. 最后，如果存在与 bean 关联的任何 BeanPostProcessors，则将调用 postProcessAfterInitialization() 方法。

   8. 如果 bean 实现DisposableBean 接口，当 spring 容器关闭时，会调用 destory()。

   9. 如果为bean 指定了 destroy 方法（ 的 destroy-method 属性），那么将调用它

8. @Autowired 注解有什么用

   @Autowired 可以更准确地控制应该在何处以及如何进行自动装配。此注解用于在 setter 方法，构造函数，具有任意名称或多个参数的属性或方法上自动装配bean。默认情况下，它是类型驱动的注入

9. @Qualifier 注解有什么用

   当您创建多个相同类型的 bean 并希望仅使用属性装配其中一个 bean 时，您可以使用@Qualifier 注解和 @Autowired 通过指定应该装配哪个确切的 bean来消除歧义

10. @RequestMapping 注解有什么用

    @RequestMapping 注解用于将特定 HTTP 请求方法映射到将处理相应请求的控制器中的特定类/方法。 此注释可应用于两个级别：
    类级别：映射请求的 URL 

    方法级别：映射 URL 以及 HTTP 请求方法

11. Spring AOP里面的几个名词

    1. 切面（Aspect）：被抽取的公共模块，可能会横切多个对象。 在Spring AOP中，切面可以使用通用类（基于模式的风格） 或者在普通类中以 @AspectJ 注解来实现
    2. 连接点（Join point）：指方法，在Spring AOP中，一个连接点 总是 代表一个方法的执行。
    3. 通知（Advice）：在切面的某个特定的连接点（Join point）上执行的动作。通知有各种类型，其中包括“around”、“before”和“after”等通知。许多AOP框架，包括Spring，都是以拦截器做通知模型， 并维护一个以连接点为中心的拦截器链
    4. 切入点（Pointcut）：切入点是指 我们要对哪些Join point进行拦截的定义。通过切入点表达式，指定拦截的方法，比如指定拦截add、search
    5. 引入（Introduction）：（也被称为内部类型声明（inter-type declaration））。声明额外的方法或者某个类型的字段。Spring允许引入新的接口（以及一个对应的实现）到任何被代理的对象。例如，你可以使用一个引入来使bean实现 IsModified 接口，以便简化缓存机制
    6. 目标对象（Target Object）： 被一个或者多个切面（aspect）所通知（advise）的对象。也有人把它叫做 被通知（adviced） 对象。 既然Spring AOP是通过运行时代理实现的，这个对象永远是一个 被代理（proxied） 对象
    7. 织入（Weaving）：指把增强应用到目标对象来创建新的代理对象的过程。Spring是在运行时完成织入

12. 有哪些类型的AOP通知（Advice）

    1. Before - 这些类型的 Advice 在 joinpoint 方法之前执行，并使用@Before 注解标记进行配置。
    2.  After Returning - 这些类型的 Advice 在连接点方法正常执行后执行，并使用@AfterReturning 注解标记进行配置。
    3.  After Throwing - 这些类型的 Advice 仅在 joinpoint 方法通过抛出异常退出并使用 @AfterThrowing 注解标记配置时执行。
    4.  After (finally) - 这些类型的 Advice 在连接点方法之后执行，无论方法退出是正常还是异常返回，并使用 @After 注解标记进行配置。
    5.  Around - 这些类型的 Advice 在连接点之前和之后执行，并使用@Around 注解标记进行配置

    ![image-20210806112045164](C:\Users\Sean\AppData\Roaming\Typora\typora-user-images\image-20210806112045164.png)

13. Spring MVC 组件

    1. DispatcherServlet：作为前端控制器，整个流程控制的中心，控制其它组件执行，统一调度，降低组件之间的耦合性，提高每个组件的扩展
    2. HandlerMapping：通过扩展处理器映射器实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等。
    3. HandlAdapter：通过扩展处理器适配器，支持更多类型的处理器。
    4. ViewResolver：通过扩展视图解析器，支持更多类型的视图解析，例如：jsp、freemarker、pdf、excel等

14. DispatcherServlet 的工作流程

    ![image-20210630153343101](C:\Users\Sean\AppData\Roaming\Typora\typora-user-images\image-20210630153343101.png)

    1. 向服务器发送 HTTP 请求，请求被前端控制器 DispatcherServlet 捕获。
    2.  DispatcherServlet 根据 -servlet.xml 中的配置对请求的 URL 进行解析，得到请求资源标识符（URI）。然后根据该 URI，调用HandlerMapping获得该 Handler 配置的所有相关的对象（包括 Handler 对象以及 Handler 对象对应的拦截器），最后以 HandlerExecutionChain 对象的形式返回。
    3.  DispatcherServlet 根据获得的 Handler，选择一个合适的HandlerAdapter。（附注：如果成功获得 HandlerAdapter 后，此时将开始执行拦截器的 preHandler(...)方法）。
    4. 提取 Request 中的模型数据，填充 Handler 入参，开始执行 Handler（ Controller)。在填充 Handler 的入参过程中，根据你的配置，Spring 将帮你做一些额外的工作：
       -  HttpMessageConveter：将请求消息（如 Json、xml 等数据）转换成一个对象，将对象转换为指定的响应信息
       -  数据转换：对请求消息进行数据转换。如 String 转换成 Integer、Double 等。
       -  数据格式化：对请求消息进行数据格式化。如将字符串转换成格式化数字或格式化日期等。
       -  数据验证：验证数据的有效性（长度、格式等），验证结果存储到BindingResult 或 Error 中。
    5. Handler(Controller)执行完成后，向 DispatcherServlet 返回一个ModelAndView 对象；
    6. 根据返回的 ModelAndView，选择一个适合的 ViewResolver（必须是已经注册到 Spring 容器中的 ViewResolver)返回给DispatcherServlet。
    7. ViewResolver 结合 Model 和 View，来渲染视图。
    8. 视图负责将渲染结果返回给客户端。

15. Spring中Autowired和Resource关键字的区别

    @Resource和@Autowired都是做bean的注入时使用，其实@Resource并不是Spring的注解，它的包是javax.annotation.Resource，需要导入，但是Spring支持该注解的注入。

    ##### 共同点

    两者都可以写在字段和setter方法上。两者如果都写在字段上，那么就不需要再写setter方法

    ##### 不同点

    1. @Autowired为Spring提供的注解，需要导入包org.springframework.beans.factory.annotation.Autowired;只按照byType注入
    2. @Autowired注解是按照类型（byType）装配依赖对象，默认情况下它要求依赖对象必须存在，如果允许null值，可以设置它的required属性为false。如果我们想使用按照名称（byName）来装配，可以结合@Qualifier注解一起使用
    3. @Resource默认按照ByName自动注入，由J2EE提供，需要导入包javax.annotation.Resource。@Resource有两个重要的属性：name和type，而Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型。所以，如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略。如果既不制定name也不制定type属性，这时将通过反射机制使用byName自动注入策略
    4. @Resource装配顺序：
       如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异
       常。
       如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常。
       如果指定了type，则从上下文中找到类似匹配的唯一bean进行装配，找不到或是找到多个，都会抛出异常
       如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹
       配则自动装配。@Resource的作用相当于@Autowired，只不过@Autowired按照byType自动注入

16. Spring框架中都用到了哪些设计模式

    （1）工厂模式：BeanFactory就是简单工厂模式的体现，用来创建对象的实例；
    （2）单例模式：Bean默认为单例模式。
    （3）代理模式：Spring的AOP功能用到了JDK的动态代理和CGLIB字节码生成技术；
    （4）模板方法：用来解决代码重复的问题。比如. RestTemplate, JmsTemplate, JpaTemplate。
    （5）观察者模式：定义对象键一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都会得到通知被制动更新，如Spring中listener的实现--ApplicationListener

17. 哪些是重要的 bean 生命周期方法？

    有两个重要的 bean 生命周期方法，第一个是 setup ， 它是在容器加载 bean的时候被调用。第二个方法是 teardown 它是在容器卸载类的时候被调用。The bean 标签有两个重要的属性（init-method 和 destroy-method）。用它们你可以自己定制初始化和注销方法。它们也有相应的注解（@PostConstruct 和@PreDestroy）

18. spring 中的事件

    1. 上下文更新事件（ContextRefreshedEvent）：该事件会在 ApplicationContext 被初始化或者更新时发布。也可以在调用 ConfigurableApplicationContext 接口中的 refresh()方法时被触发
    2. 上下文开始事件（ContextStartedEvent）：当容器调用 ConfigurableApplicationContext 的Start()方法开始/重新开始容器时触发该事件
    3. 上下文停止事件（ContextStoppedEvent）：当容器调用 ConfigurableApplicationContext 的Stop()方法停止容器时触发该事件
    4. 上下文关闭事件（ContextClosedEvent）：当 ApplicationContext 被关闭时触发该事件。容器被关闭时，其管理的所有单例 Bean 都被销毁
    5. 请求处理事件（RequestHandledEvent）：在 Web 应用中，当一个 http 请求（request）结束触发该事件。

19. Springmvc controller方法中为什么不能定义局部变量

    因为controller是默认单例模式，高并发下全局变量会出现线程安全问题
    现这种问题如何解决呢

    1. 既然是全局变量惹的祸，那就将全局变量都编程局部变量，通过方法参数来传递
    2. jdk提供了java.lang.ThreadLocal,它为多线程并发提供了新思路。
    3. 使用@Scope("session")，会话级别
    4. 将控制器的作用域从单例改为原型，即在spring配置文件Controller中声明 scope="prototype"，每次都创建新的controller

20. SpringMVC中的拦截器和Servlet中的filter有什么区别

    首先最核心的一点他们的拦截侧重点是不同的，SpringMVC中的拦截器是依赖JDK的反射实现的，SpringMVC的拦截器主要是进行拦截请求，通过对Handler进行处理的时候进行拦截，先声明的拦截器中的preHandle方法会先执行，然而它的postHandle方法（他是介于处理完业务之后和返回结果之前）和afterCompletion方法却会后执行。并且Spring的拦截器是按照配置的先后顺序进行拦截的

    而Servlet的filter是基于函数回调实现的过滤器，Filter主要是针对URL地址做一个编码的事情、过滤掉没用的参数、安全校验（比较泛的，比如登录不登录之类）

21. 列举 IoC 的一些好处

    1. 它将最小化应用程序中的代码量
    2. 它将使您的应用程序易于测试，因为它不需要单元测试用例中的任何单例或 JNDI 查找机制。
    3. 它以最小的影响和最少的侵入机制促进松耦合。
    4. 它支持即时的实例化和延迟加载服务

22. spring的事务传播行为

    spring事务的传播行为说的是，当多个事务同时存在的时候，spring如何处理这些事务的行为

    1. PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置
    2. PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行
    3. PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常
    4. PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务
    5. PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
    6. PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常
    7. PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则按REQUIRED属性执行

23. Spring中的隔离级别

    1.  ISOLATION_DEFAULT：这是个 PlatfromTransactionManager 默认的隔离级别，使用数据库默认的事务隔离级别
    2. ISOLATION_READ_UNCOMMITTED：读未提交，允许另外一个事务可以看到这个事务未提交的数据
    3. ISOLATION_READ_COMMITTED：读已提交，保证一个事务修改的数据提交后才能被另一事务读取，而且能看到该事务对已有记录的更新
    4. ISOLATION_REPEATABLE_READ：可重复读，保证一个事务修改的数据提交后才能被另一事务读取，但是不能看到该事务对已有记录的更新
    5.  ISOLATION_SERIALIZABLE：一个事务在执行的过程中完全看不到其他事务对数据库所做的更新。

24. Spring如何管理事务的

    Spring事务管理主要包括3个接口，Spring事务主要由以下三个共同完成的

    1. PlatformTransactionManager：事务管理器，主要用于平台相关事务的管理。主要包括三个方法：①、commit：事务提交。②、rollback：事务回滚。③、getTransaction：获取事务状态
    2. TransacitonDefinition：事务定义信息，用来定义事务相关属性，给事务管理器PlatformTransactionManager使用这个接口有下面四个主要方法：①、getIsolationLevel：获取隔离级别。②、getPropagationBehavior：获取传播行为。③、getTimeout获取超时时间。④、isReadOnly：是否只读（保存、更新、删除时属性变为false--可读写，查询时为true--只读）事务管理器能够根据这个返回值进行优化，这些事务的配置信息，都可以通过配置文件进行配置
    3. TransationStatus：事务具体运行状态，事务管理过程中，每个时间点事务的状态信息。例如：①、hasSavepoint()：返回这个事务内部是否包含一个保存点。②、isCompleted()：返回该事务是否已完成，也就是说，是否已经提交或回滚。③、isNewTransaction()：判断当前事务是否是一个新事务

25. 说说 BeanFactory 和 ApplicationContext 的区别？ 什么是延迟实例化，它的优缺点是什么

    BeanFactory和ApplicationContext是Spring的两大核心接口，都可以当做Spring的容器。其中ApplicationContext是BeanFactory的子接口

    

    BeanFactory：是Spring里面最底层的接口，包含了各种Bean的定义，读取bean配置文档，管理bean的加载、实例化，控制bean的生命周期，维护bean之间的依赖关系。

    ApplicationContext接口作为BeanFactory的派生，除了提供BeanFactory所具有的功能外，还提供了更完整的框架功能

    - 继承MessageSource，因此支持国际化。
    - 统一的资源文件访问方式。
    - 提供在监听器中注册bean的事件。
    - 同时加载多个配置文件。
    - 载入多个（有继承关系）上下文 ，使得每一个上下文都专注于一个特定的层次，比如应用的web层
    - BeanFactroy采用的是延迟加载形式来注入Bean的，即只有在使用到某个Bean时(调用getBean())，才对该Bean进行加载实例化。这样，我们就不能发现一些存在的Spring的配置问题。如果Bean的某一个属性没有注入，BeanFacotry加载后，直至第一次使用调用getBean方法才会抛出异常。
    - ApplicationContext，它是在容器启动时，一次性创建了所有的Bean。这样，在容器启动时，我们就可以发现Spring中存在的配置错误，这样有利于检查所依赖属性是否注入。 ApplicationContext启动后预载入所有的单实例Bean，通过预载入单实例bean ,确保当你需要的时候，你就不用等待，因为它们已经创建好了。
    - 相对于基本的BeanFactory，ApplicationContext 唯一的不足是占用内存空间。当应用程序配置Bean较多时，程序启动较慢。
    - BeanFactory通常以编程的方式被创建，ApplicationContext还能以声明的方式创建，如使用ContextLoader。
    - BeanFactory和ApplicationContext都支持BeanPostProcessor、BeanFactoryPostProcessor的使用，但两者之间的区别是：BeanFactory需要手动注册，而ApplicationContext则是自动注册

26. Java中依赖注入有哪些方式

    1. 构造器注入
    2. Setter方法注入
    3. 接口注入

27. 

### Spring Boot

1. Spring Boot 有哪些优点

   1. 减少开发，测试时间和努力。

   2. 使用 JavaConfig 有助于避免使用 XML。

   3. 避免大量的 Maven 导入和各种版本冲突。

   4. 提供意见发展方法。

   5. 通过提供默认值快速开始开发。

   6. 没有单独的 Web 服务器需要。这意味着你不再需要启动 Tomcat，Glassfish或其他任何东西。

   7. 需要更少的配置 因为没有 web.xml 文件。只需添加用@ Configuration 注释的类，然后添加用@Bean 注释的方法，Spring 将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired 添加到 bean 方法中，以使 Spring 自动装入需要的依赖关系中。

   8. 基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring 将在（application{environment} .properties）中加载后续的应用程序属性文件

      

2. Spring Boot 的核心注解 @SpringBootApplication

   @SpringBootApplication，主要组合包含了以下3 个注解：

   @SpringBootConfiguration：组合了 @Configuration 注解，实现配置文件的功能。
   @EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：
   @ComponentScan：Spring组件扫描

3.  Spring Boot启动的时候运行一些特定的代码

   如果你想在Spring Boot启动的时候运行一些特定的代码，你可以实现接口ApplicationRunner或者CommandLineRunner，这两个接口实现方式一样，它们都只提供了一个run方法。CommandLineRunner：启动获取命令行参数

4. Spring Boot 中静态资源直接映射的优先级是怎样的

   优先级顺序为：META-INF/resources > resources > static > public
   
5. Spring Boot扫描流程

   1. 调用run方法中的 refreshContext 方法
   2. 用AbstractApplicationContext中的 refresh 方法
   3. 委托给 invokeBeanFactoryPostProcessors 去处理调用链
   4. 其中一个方法 postProcessBeanDefinitionRegistry会 去调用 processConfigBeanDefinitions解析 beandefinitions
   5. 在 processConfigBeanDefinitions 中有一个 parse 方法，其中有 componentScanParser.parse的方法，这个方法会扫描当前路径下所有 Component 组件

   

6. 

### Spring Cloud 

1. 什么是 Hystrix？它如何实现容错

   Hystrix 是一个延迟和容错库，旨在隔离远程系统，服务和第三方库的访问点，当出现故障是不可避免的故障时，停止级联故障并在复杂的分布式系统中实现弹性。通常对于使用微服务架构开发的系统，涉及到许多微服务。这些微服务彼此协作

2. 什么是 Netflix Feign？它的优点是什么

   

3. 什么是 Spring Cloud Bus

   spring cloud bus 将分布式的节点用轻量的消息代理连接起来，它可以用于广播配置文件的更改或者服务直接的通讯，也可用于监控。如果修改了配置文件，发送一次请求，所有的客户端便会重新读取配置文件

4. 什么是服务熔断？什么是服务降级

   熔断机制是应对雪崩效应的一种微服务链路保护机制。当某个微服务不可用或者响应时间太长时，会进行服务降级，进而熔断该节点微服务的调用，快速返回“错误”的响应信息。当检测到该节点微服务调用响应正常后恢复调用链路。在SpringCloud框架里熔断机制通过Hystrix实现，Hystrix会监控微服务间调用的状况，当失败的调用到一定阈值，缺省是5秒内调用20次，如果失败，就会启动熔断机制

   服务降级，一般是从整体负荷考虑。就是当某个服务熔断之后，服务器将不再被调用，此时客户端可以自己准备一个本地的fallback回调，返回一个缺省值。这样做，虽然水平下降，但好歹可用，比直接挂掉强

5. Spring Cloud Gateway

   Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架，取代Zuul网关。网关作为流量的，在微服务系统中有着非常作用，网关常见的功能有路由转发、权限校验、限流控制等作用

6.  spring cloud 的核心组件有哪些

   - Eureka：服务注册于发现
   - Feign：基于动态代理机制，根据注解和选择的机器，拼接请求 url 地址，发起请求
   - Ribbon：实现负载均衡，从一个服务的多台机器中选择一台。
   - Hystrix：提供线程池，不同的服务走不同的线程池，实现了不同服务调用的隔离，避免了服务雪崩的问题
   - Zuul：网关管理，由 Zuul 网关转发请求给对应的服务

7. SpringCloud 和 Dubbo 有哪些区别

   首先，他们都是分布式管理框架。

   1. dubbo 是二进制传输，占用带宽会少一点。SpringCloud是http 传输，带宽会多一点，同时使用http协议一般会使用JSON报文，消耗会更大
   2. dubbo 开发难度较大，所依赖的 jar 包有很多问题大型工程无法解决。SpringCloud 对第三方的继承可以一键式生成，天然集成
   3. SpringCloud 接口协议约定比较松散，需要强有力的行政措施来限制接口无序升级
   4. 最大的区别: Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式

8. Ribbon和Feign的区别

   1. Ribbon都是调用其他服务的，但方式不同
   2. 启动类注解不同，Ribbon是@RibbonClient feign的是@EnableFeignClients
   3. 服务指定的位置不同，Ribbon是在@RibbonClient注解上声明，Feign则是在定义抽象方法的接口中使用@FeignClient声明
   4. 调用方式不同，Ribbon需要自己构建http请求，模拟http请求然后使用RestTemplate发送给其他服务，步骤相当繁琐。Feign需要将调用的方法定义成抽象方法即可

9. 

### Spring Cloud Alibaba

### Mybatis

1. Mybatis 的 Xml 映射文件中，不同的 Xml 映射文件，id 是否可以重复

   不同的 Xml 映射文件，如果配置了 namespace，那么 id 可以重复；如果没有配置 namespace，那么 id 不能重复；原因就是 namespace+id 是作为 Map<String, MapperStatement>的 key使用的，如果没有 namespace，就剩下 id，那么，id 重复会导致数据互相覆盖。了 namespace，自然 id 就可以重复，namespace 不同，namespace+id 自然也就不同

2. MyBatis 实现一对一有几种方式

   有联合查询和嵌套查询,联合查询是几个表联合查询,只查询一次, 通过在resultMap 里面配置 association 节点配置一对一的类就可以完成

3. MyBatis 实现一对多有几种方式

   有联合查询和嵌套查询。联合查询是几个表联合查询,只查询一次,通过在resultMap 里面的 collection 节点配置一对多的类就可以完成

4. Mybatis 是否支持延迟加载

   Mybatis 仅支持 association 关联对象和 collection 关联集合对象的延迟加载，association 指的就是一对一，collection 指的就是一对多查询。在 Mybatis配置文件中，可以配置是否启用延迟加载 lazyLoadingEnabled=true|false

5.  #{}和${}的区别是什么

   #{}是预编译处理，${}是字符串替换。
   Mybatis 在处理#{}时，会将 sql 中的#{}替换为?号，调用 PreparedStatement 的 set方法来赋值；
   Mybatis 在处理${}时，就是把${}替换成变量的值。使用#{}可以有效的防止 SQL 注入，提高系统安全性

6. Mybatis 是如何进行分页的？分页插件的原理是什么

   Mybatis 使用 RowBounds 对象进行分页，它是针对 ResultSet 结果集执行的内存分页，而非物理分页，可以在 sql 内直接书写带有物理分页的参数来完成物理分页功能，也可以使用分页插件来完成物理分页。
   分页插件的基本原理是使用 Mybatis 提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的 sql，然后重写 sql，根据 dialect 方言，添加对应的物理分页语句和物理分页参数

7. 什么是 MyBatis 的接口绑定？有哪些实现方式

   接口绑定，就是在 MyBatis 中任意定义接口,然后把接口里面的方法和 SQL 语句绑定, 我们直接调用接口方法就可以,这样比起原来了 SqlSession 提供的方法我们可以有更加灵活的选择和设置。

   接口绑定有两种实现方式

   一种是通过注解绑定，就是在接口的方法上面加上@Select、@Update 等注解，里面包含 Sql 语句来绑定；

   另外一种就是通过 xml里面写 SQL 来绑定,在这种情况下,要指定 xml 映射文件里面的 namespace 必须为接口的全路径名。当 Sql 语句比较简单时候,用注解绑定, 当 SQL 语句比较复杂时候,用 xml 绑定,一般用 xml 绑定的比较多

8. mybatis  的优缺点

   ###### 优点

   1. 基于SQL语句编程，相当灵活，不会对应用程序或者数据库的现有设计造成任何影响，SQL写在XML里，解除sql与程序代码的耦合，便于统一管理；提供XML标签，支持编写动态SQL语句，并可重用
   2. 与JDBC相比，减少了50%以上的代码量，消除了JDBC大量冗余的代码，不需要手动开关连接
   3. 很好的与各种数据库兼容（因为MyBatis使用JDBC来连接数据库，所以只要JDBC支持的数据库MyBatis都支持
   4. 能够与Spring很好的集成
   5. 提供映射标签，支持对象与数据库的ORM字段关系映射；提供对象关系映射标签，支持对象关系组件维护

   ###### 缺点

   1. SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求
   2. SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库

9. mybatis  编程步骤

   1. 创建SqlSessionFactory
   2. 通过SqlSessionFactory创建SqlSession
   3. 通过sqlsession执行数据库操作
   4. 调用session.commit()提交事务
   5. 调用session.close()关闭会话

10. MyBatis的工作原理

       1. 读取 MyBatis 配置文件：mybatis-config.xml 为 MyBatis 的全局配置文件，配置了 MyBatis 的运行环境等信息，例如数据库连接信息
       2. 加载映射文件。映射文件即 SQL 映射文件，该文件中配置了操作数据库的 SQL 语句，需要在MyBatis 配置文件 mybatis-config.xml 中加载。mybatis-config.xml 文件可以加载多个映射文件，每个文件对应数据库中的一张表
       3. 构造会话工厂：通过 MyBatis 的环境等配置信息构建会话工厂 SqlSessionFactory
       4. 创建会话对象：由会话工厂创建 SqlSession 对象，该对象中包含了执行 SQL 语句的所有方法
       5. Executor 执行器：MyBatis 底层定义了一个 Executor 接口来操作数据库，它将根据 SqlSession 传递的参数动态地生成需要执行的 SQL 语句，同时负责查询缓存的维护
       6. MappedStatement 对象：在 Executor 接口的执行方法中有一个 MappedStatement 类型的参数，该参数是对映射信息的封装，用于存储要映射的 SQL 语句的 id、参数等信息
       7. 输入参数映射：输入参数类型可以是 Map、List 等集合类型，也可以是基本数据类型和 POJO 类型。输入参数映射过程类似于 JDBC 对 preparedStatement 对象设置参数的过程
       8. 输出结果映射：输出结果类型可以是 Map、 List 等集合类型，也可以是基本数据类型和 POJO 类型。输出结果映射过程类似于 JDBC 对结果集的解析过程

11. Mybatis都有哪些Executor执行器？它们之间的区别是什么

    Mybatis有三种基本的Executor执行器，SimpleExecutor、ReuseExecutor、BatchExecutor、

    - SimpleExecutor：每执行一次update或select，就开启一个Statement对象，用完立刻关闭Statement对象
    - ReuseExecutor：执行update或select，以sql作为key查找Statement对象，存在就使用，不存在就创建，用完后，不关闭Statement对象，而是放置于Map<String, Statement>内，供下一次使用。简言之，就是重复使用Statement对象
    - BatchExecutor：执行update（没有select，JDBC批处理不支持select），将所有sql都添加到批处理中（addBatch()），等待统一执行（executeBatch()），它缓存了多个Statement对象，每个Statement对象都是addBatch()完毕后，等待逐一执行executeBatch()批处理。与JDBC批处理相同

12.  Mybatis是如何进行分页的？分页插件的原理是什么？

    1. Mybatis 使用 RowBounds 对象进行分页，也可以直接编写 sql 实现分页，也可以使用Mybatis 的分页插件
    2. 分页插件的原理：实现 Mybatis 提供的接口，实现自定义插件，在插件的拦截方法内拦截待执行的 sql，然后重写 sql

13. 在mapper中如何传递多个参数

    1. 顺序传参法  where user_name = #{0} and dept_id = #{1}     #{}里面的数字代表传入参数的顺序  这种方法不建议使用，sql层表达不直观，且一旦顺序调整容易出错。
    2. @Param注解传参法  @Param("userName") String name   where user_name = #{userName}  #{}里面的名称对应的是注解@Param括号里面修饰的名称  这种方法在参数不多的情况还是比较直观的，（推荐使用）
    3. Map传参法  
    4. Java Bean传参法  #{}里面的名称对应的是User类里面的成员属性

14. Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复

    不同的Xml映射文件，如果配置了namespace，那么id可以重复；如果没有配置namespace，那么id不能重复

15. Mybatis  缓存

    Mybatis中有一级缓存和二级缓存，默认情况下一级缓存是开启的，而且是不能关闭的。一级缓存是指 SqlSession 级别的缓存，当在同一个 SqlSession 中进行相同的 SQL 语句查询时，第二次以后的查询不会从数据库查询，而是直接从缓存中获取，一级缓存最多缓存 1024 条 SQL。二级缓存是指可以跨SqlSession 的缓存。是 mapper 级别的缓存，对于 mapper 级别的缓存不同的sqlsession 是可以共享的

    - ​	Mybatis 的一级缓存原理 的一级缓存原理 （ sqlsession 级别 ）

      第一次发出一个查询 sql，sql 查询结果写入 sqlsession 的一级缓存中，缓存使用的数据结构是一
      个 map。
      key：MapperID+offset+limit+Sql+所有的入参

      value：用户信息

      同一个 sqlsession 再次发出相同的 sql，就从缓存中取出数据。如果两次中间出现 commit 操作（修改、添加、删除），本 sqlsession 中的一级缓存区域全部清空，下次再去缓存中查询不到所以要从数据库查询，从数据库查询到再写入缓存

    - 二级缓存原理 二级缓存原理 （ mapper 级别）

      二级缓存的范围是 mapper 级别（mapper同一个命名空间），mapper 以命名空间为单位创建缓存数据结构，结构是 map。mybatis 的二级缓存是通过 CacheExecutor 实现的。CacheExecutor   其实是 Executor 的代理对象。所有的查询操作，在 CacheExecutor 中都会先匹配缓存中是否存
      在，不存在则查询数据库

      key：MapperID+offset+limit+Sql+所有的入参

      具体使用需要配置

      1. Mybatis 全局配置中启用二级缓存配置
      2. 在对应的 Mapper.xml 中配置 cache 节点
      3. 在对应的 select 查询节点中添加 useCache=true

    

16. 


### Zookeeper 

1. ZooKeeper 是什么

   是一个开放源码的分布式协调服务，它是集群的管理者，监视着集群中各个节点的状态根据节点提交的反馈进行下一步合理操作。最终，将简单易用的接口和性能高效、功能稳定的系统提供给用户。分布式应用程序可以基于 Zookeeper 实现诸如数据发布/订阅、负载均衡、命名服务、分布式协调/通知、集群管理Master 选举、分布式锁和分布式队列等功能

2. Zookeeper 文件系统

   Zookeeper 提供一个多层级的节点命名空间（节点称为 znode）。与文件系统不同的是，这些节点都可以设置关联的数据，而文件系统中只有文件节点可以存放数据而目录节点不行

   Zookeeper 为了保证高吞吐和低延迟，在内存中维护了这个树状的目录结构，这种特性使得 Zookeeper 不能用于存放大量的数据，每个节点的存放数据上限为1M

3. znode

   zookeeper集群自身维护了一套数据结构。这个存储结构是一个树形结构，其上的每一个节点，我们称之为“znode”。

   ![image-20210812151729674](https://gitee.com/Sean0516/image/raw/master/img/image-20210812151729674.png)

   - 每一个znode默认能够存储1MB的数据（对于记录状态性质的数据来说，够了）
   - 可以使用zkCli命令，登录到zookeeper上，并通过ls、create、delete、sync等命令操作这些znode节点
   - znode除了名称、数据以外，还有一套属性：zxid。这套zid与时间戳对应，记录zid不同的状态（后续我们将用到)

4. znode结构

   - zxid  时间戳，每次修改znode 都会生成一个新的 zxid ，如果zxid1 小于zxid 2 那么zxid1在zxid2 之前发生
   - version 对节点的每次修改将使得节点的版本号增加1
   - data 每一个znode 默认能够存储1M 的数据，对data的修改都会引起两者的变化
   - tick 租约协议的具体体现，如果当前节点是“临时节点” 在tick 时间周期内没有收到新的客户端租约，则视为失效

   此外，znode还有操作权限。如果我们把以上几类属性细化，又可以得到以下属性的细节

   - czxid：创建节点的事务的zxid
   - mzxid：对znode最近修改的zxid
   - ctime：以距离时间原点(epoch)的毫秒数表示的znode创建时间
   - mtime：以距离时间原点(epoch)的毫秒数表示的znode最近修改时间
   - version：znode数据的修改次数
   - cversion：znode子节点修改次数
   - aversion：znode的ACL修改次数
   - ephemeralOwner：如果znode是临时节点，则指示节点所有者的会话ID；如果不是临时节点，则为零。
   - dataLength：znode数据长度。
   - numChildren：znode子节点个数

5. 四种类型的数据节点 Znode

   ###### PERSISTENT-持久节点

   除非手动删除，否则节点一直存在于 Zookeeper 上

   ###### EPHEMERAL-临时节点

   临时节点的生命周期与客户端会话绑定，一旦客户端会话失效（客户端与zookeeper 连接断开不一定会话失效），那么这个客户端创建的所有临时节点都会被移除

   ###### PERSISTENT_SEQUENTIAL-持久顺序节点

   基本特性同持久节点，只是增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字

   ###### EPHEMERAL_SEQUENTIAL-临时顺序节点

   基本特性同临时节点，增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字

6. ZAB 协议

   ZAB 协议是为分布式协调服务 Zookeeper 专门设计的一种支持崩溃恢复的原子广播协议  ZAB 协议包括两种基本的模式：崩溃恢复和消息广播

   

   当整个 zookeeper 集群刚刚启动或者 Leader 服务器宕机、重启或者网络故障导致不存在过半的服务器与 Leader 服务器保持正常通信时，所有进程（服务器）进入崩溃恢复模式，首先选举产生新的 Leader 服务器，然后集群中 Follower 服务器开始与新的 Leader 服务器进行数据同步

   当集群中超过半数机器与该 Leader服务器完成数据同步之后，退出恢复模式进入消息广播模式，Leader 服务器开始接收客户端的事务请求生成事物提案来进行事务请求处理

7. Zab 协议有两种模式 - 恢复模式（选主）、广播模式（同步 ）

   Zab协议有两种模式，它们分别是恢复模式（选主）和广播模式（同步）。当服务启动或者在领导者崩溃后，Zab 就进入了恢复模式，当领导者被选举出来，且大多数 Server 完成了和 leader 的状态同步以后，恢复模式就结束了。状态同步保证了 leader 和 Server 具有相同的系统状态

8. ZAB 协议 4 阶段

   - Leader election （选举阶段 - 选出准 Leader 

     Leader election（选举阶段）：节点在一开始都处于选举阶段，只要有一个节点得到超半数节点的票数，它就可以当选准 leader。只有到达 广播阶段（broadcast） 准 leader 才会成为真正的 leader。这一阶段的目的是就是为了选出一个准 leader，然后进入下一个阶段

   - Discovery （发现阶段 - 接受提议、生成 epoch 、接受 epoch ）

     Discovery（发现阶段）：在这个阶段，followers 跟准 leader 进行通信，同步 followers最近接收的事务提议。这个一阶段的主要目的是发现当前大多数节点接收的最新提议，并且准 leader 生成新的 epoch，让 followers 接受，更新它们的 accepted Epoch

     一个 follower 只会连接一个 leader，如果有一个节点 f 认为另一个 follower p 是 leader，f在尝试连接 p 时会被拒绝，f 被拒绝之后，就会进入重新选举阶段。

   - Synchronization （同步阶段 - 同步 follower 副本 ）

     Synchronization（同步阶段）：同步阶段主要是利用 leader 前一阶段获得的最新提议历史，同步集群中所有的副本。只有当 大多数节点都同步完成，准 leader 才会成为真正的 leader。follower 只会接收 zxid 比自己的 lastZxid 大的提议

   - Broadcast （广播阶段 -leader 消息广播

     Broadcast（广播阶段）：到了这个阶段，Zookeeper 集群才能正式对外提供事务服务，并且 leader 可以进行消息广播。同时如果有新的节点加入，还需要对新节点进行同步

9. Zookeeper Watcher 机制 （ 数据变更通知）

   Zookeeper 允许客户端向服务端的某个 Znode 注册一个 Watcher 监听，当服务端的一些指定事件触发了这个 Watcher，服务端会向指定客户端发送一个事件通知来实现分布式的通知功能，然后客户端根据 Watcher 通知状态和事件类型做出业务上的改变

10. watcher 的工作机制

   - 客户端注册watcher
   - 服务端处理watcher
   - 客户端回调watcher

11. Watcher 特性总结

    1. 一次性

       无论是服务端还是客户端，一旦一个watcher 被触发，zookeeper 都会将其从相应的存储中移除，再次使用需要重新注册。 这样的设计有效的减轻了服务端的压力，不然对于更新非常频繁的节点，服务端会不断的向客户端发送事件通知，无论对于网络还是服务端的压力都非常大。 

    2. 客户端串行执行

       客户端watcher 回调的过程是一个串行同步的过程，只有回调后客户端才能看到最新的数据状态。一个Watcher回调逻辑不应该太多，以免影响别的watcher执行

    3. 轻量级

       WatchEvent是最小的通信单元，结构上只包含通知状态、事件类型和节点路径，并不会告诉数据节点变化前后的具体内容

    4. 时效性

       Watcher只有在当前session彻底失效时才会无效，若在session有效期内快速重连成功，则watcher依然存在，仍可接收到通知

12. 客户端注册 Watcher 实现

       1. 调用 getData()/getChildren()/exist()三个 API，传入 Watcher 对象
       2. 标记请求 request，封装 Watcher 到 WatchRegistration
       3. 封装成 Packet 对象，发服务端发送 request
       4. 收到服务端响应后，将 Watcher 注册到 ZKWatcherManager 中进行管理
       5. 请求返回，完成注册

13. 服务端处理 Watcher 实现

    1. 服务端接收 Watcher 并存储
       	接收到客户端请求，处理请求判断是否需要注册 Watcher，需要的话将数据节点的节点路径和 ServerCnxn（ServerCnxn 代表一个客户端和服务端的连接，实现了 Watcher 的process 接口，此时可以看成一个 Watcher 对象）存储在WatcherManager 的 WatchTable 和 watch2Paths 中去

    2. Watcher 触发

    3. 调用 process 方法来触发 Watcher

       这里 process 主要就是通过 ServerCnxn 对应的 TCP 连接发送 Watcher 事件通知

14. 客户端回调 Watcher

    客户端 SendThread 线程接收事件通知，交由 EventThread 线程回调 Watcher。客户端的 Watcher 机制同样是一次性的，一旦被触发后，该 Watcher 就失效了

15. Zookeeper 服务器角色

    ###### Leader

    1. 事务请求的唯一调度和处理者，保证集群事务处理的顺序性
    2. 集群内部各服务的调度者

    ###### Follower

    1. 处理客户端的非事务请求，转发事务请求给 Leader 服务器
    2. 参与事务请求 Proposal 的投票
    3. 参与 Leader 选举投票

    ###### Observer

    1. 3.0 版本以后引入的一个服务器角色，在不影响集群事务处理能力的基础上提升集群的非事务处理能力
    2. 处理客户端的非事务请求，转发事务请求给 Leader 服务器
    3. 不参与任何形式的投票

16. Zookeeper 下 Server 工作状态

    服务器具有四种状态，分别是 LOOKING、FOLLOWING、LEADING、OBSERVING。

    1. LOOKING：寻找 Leader 状态。当服务器处于该状态时，它会认为当前集群中没有 Leader，因此需要进入 Leader 选举状态。
    2. FOLLOWING：跟随者状态。表明当前服务器角色是 Follower。
    3. LEADING：领导者状态。表明当前服务器角色是 Leader。
    4. OBSERVING：观察者状态。表明当前服务器角色是 Observer

17. 数据同步

    整个集群完成 Leader 选举之后，Learner（Follower 和 Observer 的统称）回向Leader 服务器进行注册。当 Learner 服务器想 Leader 服务器完成注册后，进入数据同步环节

    ##### 数据同步流程：（均以消息传递的方式进行）

    1. Learner 向 Learder 注册
    2. 数据同步
    3. 同步确认

18. Zookeeper 的数据同步种类

    1. 直接差异化同步（DIFF 同步）
    2. 先回滚再差异化同步（TRUNC+DIFF 同步）
    3. 仅回滚同步（TRUNC 同步）
    4. 全量同步（SNAP 同步

19. zookeeper 是如何保证事务的顺序一致性的

    zookeeper 采用了全局递增的事务 Id 来标识，所有的 proposal（提议）都在被提出的时候加上了 zxid，zxid 实际上是一个 64 位的数字，高 32 位是 epoch（时期; 纪元; 世; 新时代）用来标识 leader 周期，如果有新的 leader 产生出来，epoch会自增，低 32 位用来递增计数。当新产生 proposal 的时候，会依据数据库的两阶段过程，首先会向其他的server 发出事务执行请求，如果超过半数的机器都能执行并且能够成功，那么就会开始执行

20. zk 节点宕机如何处理

    Zookeeper 本身也是集群，推荐配置不少于 3 个服务器。Zookeeper 自身也要保证当一个节点宕机时，其他节点会继续提供服务。

    如果是一个 Follower 宕机，还有 2 台服务器提供访问，因为 Zookeeper 上的数据是有多个副本的，数据并不会丢失；
    如果是一个 Leader 宕机，Zookeeper 会选举出新的 Leader。

    ZK 集群的机制是只要超过半数的节点正常，集群就能正常提供服务。只有在 ZK节点挂得太多，只剩一半或不到一半节点能工作，集群才失效。

    所以3 个节点的 cluster 可以挂掉 1 个节点(leader 可以得到 2 票>1.5)
    2 个节点的 cluster 就不能挂掉任何 1 个节点了(leader 可以得到 1 票<=1)

21. 分布式集群中为什么会有 Master

    在分布式环境中，有些业务逻辑只需要集群中的某一台机器进行执行，其他的机器可以共享这个结果，这样可以大大减少重复计算，提高性能，于是就需要进行leader 选举

22. Zookeeper 分布式锁

    有了 zookeeper 的一致性文件系统，锁的问题变得容易。锁服务可以分为两类，一个是保持独占，另一个是控制时序 对于第一类，我们将 zookeeper 上的一个 znode 看作是一把锁，通过 createznode的方式来实现。所有客户端都去创建 /distribute_lock 节点，最终成功创建的那个客户端也即拥有了这把锁。用完删除掉自己创建的 distribute_lock 节点就释放出锁。

    对于第二类， /distribute_lock 已经预先存在，所有客户端在它下面创建临时顺序编号目录节点，和选 master 一样，编号最小的获得锁，用完删除，依次方便

    ###### zk 基本锁 原理

    利用临时节点与 watch 机制。每个锁占用一个普通节点 /lock，当需要获取锁时在 /lock 目录下创建一个临时节点，创建成功则表示获取锁成功，失败则 watch/lock 节点，有删除操作后再去争锁。临时节点好处在于当进程挂掉后能自动上锁的节点自动删除即取消锁。 缺点：所有取锁失败的进程都监听父节点，很容易发生羊群效应，即当释放锁后所有等待进程一起来创建节点，并发量很大

    ###### zk 锁优化 原理

    上锁改为创建临时有序节点，每个上锁的节点均能创建节点成功，只是其序号不同。只有序号最小的可以拥有锁，如果这个节点序号不是最小的则 watch 序号比本身小的前一个节点 (公平锁)

    1. 在 /lock 节点下创建一个有序临时节点 (EPHEMERAL_SEQUENTIAL)。
    2. 判断创建的节点序号是否最小，如果是最小则获取锁成功。不是则取锁失败，然后 watch 序号比本身小的前一个节点。（避免很多线程watch同一个node，导致羊群效应）
    3. 当取锁失败，设置 watch 后则等待 watch 事件到来后，再次判断是否序号最小。
    4. 取锁成功则执行代码，最后释放锁（删除该节点）

23. epoch

    epoch：可以理解为当前集群所处的年代或者周期，每个 leader 就像皇帝，都有自己的年号，所以每次改朝换代， leader 变更之后，都会在前一个年代的基础上加 1。这样就算旧的 leader 崩溃恢复之后，也没有人听他的了，因为 follower 只听从当前年代的 leader 的命令

24. 投票机制

    ​	每个 sever 首先给自己投票， 然后用自己的选票和其他 sever 选票对比， 权重大的胜出，使用权重较大的更新自身选票箱。 具体选举过程如下

    1. 每个 Server 启动以后都询问其它的 Server 它要投票给谁。对于其他 server 的询问，server 每次根据自己的状态都回复自己推荐的 leader 的 id 和上一次处理事务的zxid（系统启动时每个 server 都会推荐自己）
    2. 收到所有 Server 回复以后，就计算出 zxid 最大的哪个 Server，并将这个 Server 相关信息设置成下一次要投票的 Server。
    3. 计算这过程中获得票数最多的的 sever 为获胜者，如果获胜者的票数超过半数，则改server 被选为 leader。否则，继续这个过程，直到 leader 被选举出来
    4. leader 就会开始等待 server 连接
    5. Follower 连接 leader，将最大的 zxid 发送给 leader
    6. Leader 根据 follower 的 zxid 确定同步点，至此选举阶段完成。
    7. 选举阶段完成 Leader 同步后通知 follower 已经成为 uptodate 状态
    8. Follower 收到 uptodate 消息后，又可以重新接受 client 的请求进行服务

25. Zookeeper 工作原理（原子广播）

    1. Zookeeper 的核心是原子广播，这个机制保证了各个 server 之间的同步。实现这个机制的协议叫做 Zab 协议。 Zab 协议有两种模式，它们分别是恢复模式和广播模式。
    2. 当服务启动或者在领导者崩溃后， Zab 就进入了恢复模式，当领导者被选举出来，且大多数 server 的完成了和 leader 的状态同步以后，恢复模式就结束了。
    3. 状态同步保证了 leader 和 server 具有相同的系统状态
    4. 一旦 leader 已经和多数的 follower 进行了状态同步后，他就可以开始广播消息了，即进入广播状态。这时候当一个 server 加入 zookeeper 服务中，它会在恢复模式下启
    动，发现 leader，并和 leader 进行状态同步。待到同步结束，它也参与消息广播。 Zookeeper服务一直维持在 Broadcast 状态，直到 leader 崩溃了或者 leader 失去了大
    部分的followers 支持。
    5. 广播模式需要保证 proposal 被按顺序处理，因此 zk 采用了递增的事务 id 号(zxid)来保证。所有的提议(proposal)都在被提出的时候加上了 zxid。
    6. 实现中 zxid 是一个 64 为的数字，它高 32 位是 epoch 用来标识 leader 关系是否改变，每次一个 leader 被选出来，它都会有一个新的 epoch。低 32 位是个递增计数。
    7. 当 leader 崩溃或者 leader 失去大多数的 follower，这时候 zk 进入恢复模式，恢复模式需要重新选举出一个新的 leader，让所有的 server 都恢复到一个正确的状态

26. Zookeeper 都有哪些功能

    1. 集群管理：监控节点存活状态、运行请求等
    2. 主节点选举：主节点挂掉了之后可以从备用的节点开始新一轮选主，主节点选举说的就是这个选举的过程，使用 Zookeeper 可以协助完成这个过程
    3. 分布式锁：Zookeeper 提供两种锁：独占锁、共享锁。独占锁即一次只能有一个线程使用资源，共享锁是读锁共享，读写互斥，即可以有多线线程同时读同一个资源，如果要使用写锁也只能有一个线程使用。Zookeeper 可以对分布式锁进行控制
    4. 命名服务：在分布式系统中，通过使用命名服务，客户端应用能够根据指定名字来获取资源或服务的地址，提供者等信息

27. zookeeper 写数据流程

    ![image-20210812152705779](https://gitee.com/Sean0516/image/raw/master/img/image-20210812152705779.png)

28. 


### Kafka

1. 消息队列的应用场景

   1. 异步处理 （用户注册）

   2. 应用解耦 （订单系统）

   3. 流量削峰 （秒杀）

      - 可以控制活动的人数
      - 可以缓解短时间内高流量压垮应用
      - 用户的请求，服务器接收后，首先写入消息队列。假如消息队列长度超过最大数量，则直接抛弃用户请求或跳转到错误页面
      - 秒杀业务根据消息队列中的请求信息，再做后续处理

   4. 日志处理

      日志处理是指将消息队列用在日志处理中，比如Kafka的应用，解决大量日志传输的问题。架构简化如下

      - 日志采集客户端，负责日志数据采集，定时写受写入Kafka队列
      - Kafka消息队列，负责日志数据的接收，存储和转发
      - 日志处理应用：订阅并消费kafka队列中的日志数据

   5. 消息通讯

      消息通讯是指，消息队列一般都内置了高效的通信机制，因此也可以用在纯的消息通讯。比如实现点对点消息队列，或者聊天室等

2. 消息的幂等处理

   由于网络原因，生产者可能会重复发送消息，因此消费者方必须做消息的幂等处理，常用的解决方案有

   1. 查询操作：查询一次和查询多次，在数据不变的情况下，查询结果是一样的。select是天然的幂等操作；

   2. 删除操作：删除操作也是幂等的，删除一次和多次删除都是把数据删除。(注意可能返回结果不一样，删除的
   数据不存在，返回0，删除的数据多条，返回结果多个) ；
   3. 唯一索引，防止新增脏数据。比如：支付宝的资金账户，支付宝也有用户账户，每个用户只能有一个资金账
   户，怎么防止给用户创建资金账户多个，那么给资金账户表中的用户ID加唯一索引，所以一个用户新增成功
   一个资金账户记录。要点：唯一索引或唯一组合索引来防止新增数据存在脏数据（当表存在唯一索引，并发
   时新增报错时，再查询一次就可以了，数据应该已经存在了，返回结果即可）；
   4. token机制，防止页面重复提交。业务要求： 页面的数据只能被点击提交一次；发生原因： 由于重复点击或
   者网络重发，或者nginx重发等情况会导致数据被重复提交；解决办法： 集群环境采用token加redis(redis单
   线程的，处理需要排队)；单JVM环境：采用token加redis或token加jvm内存。处理流程：1. 数据提交前要向
   服务的申请token，token放到redis或jvm内存，token有效时间；2. 提交后后台校验token，同时删除
   token，生成新的token返回。token特点：要申请，一次有效性，可以限流。注意：redis要用删除操作来判
   断token，删除成功代表token校验通过，如果用select+delete来校验token，存在并发问题，不建议使用；
   5. 悲观锁——获取数据的时候加锁获取。select * from table_xxx where id='xxx' for update; 注意：id字段一
   定是主键或者唯一索引，不然是锁表，会死人的悲观锁使用时一般伴随事务一起使用，数据锁定时间可能会
   很长，根据实际情况选用；
   6. 乐观锁——乐观锁只是在更新数据那一刻锁表，其他时间不锁表，所以相对于悲观锁，效率更高。乐观锁的
   实现方式多种多样可以通过version或者其他状态条件：1. 通过版本号实现update table_xxx set
   name=#name#,version=version+1 where version=#version#如下图(来自网上)；2. 通过条件限制 update
   table_xxx set avai_amount=avai_amount-#subAmount# where avai_amount-#subAmount# >= 0要求：
   quality-#subQuality# >= ，这个情景适合不用版本号，只更新是做数据安全校验，适合库存模型，扣份额和
   回滚份额，性能更高；
   7.  分布式锁——还是拿插入数据的例子，如果是分布是系统，构建全局唯一索引比较困难，例如唯一性的字段没法确定，这时候可以引入分布式锁，通过第三方的系统(redis或zookeeper)，在业务系统插入数据或者更新数据，获取分布式锁，然后做操作，之后释放锁，这样其实是把多线程并发的锁的思路，引入多多个系统，也就是分布式系统中得解决思路。要点：某个长流程处理过程要求不能并发执行，可以在流程执行之前根据某个标志(用户ID+后缀等)获取分布式锁，其他流程执行时获取锁就会失败，也就是同一时间该流程只能有一个能执行成功，执行完成后，释放分布式锁(分布式锁要第三方系统提供)；
   8.  select + insert——并发不高的后台系统，或者一些任务JOB，为了支持幂等，支持重复执行，简单的处理方法是，先查询下一些关键数据，判断是否已经执行过，在进行业务处理，就可以了。注意：核心高并发流程不要用这种方法；

3. Kafka 是什么

   Kafka 是一种高吞吐量、分布式、基于发布/订阅的消息系统，最初由 LinkedIn 公司开发，使用Scala 语言编写，目前是 Apache 的开源项目

   1. broker： Kafka 服务器，负责消息存储和转发
   2. topic：消息类别， Kafka 按照 topic 来分类消息
   3. partition： topic 的分区，一个 topic 可以包含多个 partition， topic 消息保存在各个partition 上
   4. offset：消息在日志中的位置，可以理解是消息在 partition 上的偏移量，也是代表该消息的唯一序号
   5. Producer：消息生产者
   6. Consumer：消息消费者
   7. Consumer Group：消费者分组，每个 Consumer 必须属于一个 group
   8. Zookeeper：保存着集群 broker、 topic、 partition 等 meta 数据；另外，还负责 broker 故障发现， partition leader 选举，负载均衡等功能

4. partition 的数据文件（offset， MessageSize， data）

   ###### offset

    offset 表示 Message 在这个 partition 中的偏移量， offset 不是该 Message partition 数据文件中的实际存储位置，而是逻辑上一个值，它唯一确定了 partition 中的一条 Message，可以认为 offset 是partition 中 Message 的 id

   ###### MessageSize

   MessageSize 表示消息内容 data 的大小

   ###### data

   data 为 Message 的具体内容

5. partition 会均衡分布到不同 broker 上

   由于消息 topic 由多个 partition 组成， 且 partition 会均衡分布到不同 broker 上，因此，为了有效利用 broker 集群的性能，提高消息的吞吐量， producer 可以通过随机或者hash 等方式，将消息平均发送到多个 partition 上，以实现负载均衡

6. 压缩（GZIP 或 Snappy）

   Producer 端可以通过 GZIP 或 Snappy 格式对消息集合进行压缩。 Producer 端进行压缩之后，在Consumer 端需进行解压。压缩的好处就是减少传输的数据量，减轻对网络传输的压力，在对大数据处理上，瓶颈往往体现在网络上而不是 CPU（压缩和解压会耗掉部分 CPU 资源）

7. Zookeeper 对于 Kafka 的作用是什么

   Zookeeper 是一个开放源码的、高性能的协调服务，它用于 Kafka 的分布式应用。Zookeeper 主要用于在集群中不同节点之间进行通信

   在 Kafka 中，它被用于提交偏移量，因此如果节点在任何情况下都失败了，它都可以从之前提交的偏移量中获取
   除此之外，它还执行其他活动，如: leader 检测、分布式同步、配置管理、识别新节点何时离开或连接、集群、节点实时状态等等

8. Kafka 判断一个节点是否还活着有那两个条件

   1. 节点必须可以维护和 ZooKeeper 的连接，Zookeeper 通过心跳机制检查每个节点的连接
   2. 如果节点是个 follower,他必须能及时的同步 leader 的写操作，延时不能太久

9. Kafka 与传统 MQ 消息系统之间的关键区别

   1. Kafka 持久化日志，这些日志可以被重复读取和无限期保留
   2. Kafka 是一个分布式系统：它以集群的方式运行，可以灵活伸缩，在内部通过复制数据提升容错能力和高可用性
   3. Kafka 支持实时的流式处理

10. Kafka consumer 是否可以消费指定分区消息

   Kafka consumer 消费消息时，向 broker 发出"fetch"请求去消费特定分区的消息，consumer指定消息在日志中的偏移量（offset），就可以消费从这个位置开始的消息，customer 拥有了 offset 的控制权，可以向后回滚去重新消费之前的消息，这是很有意义的

11. Kafka 存储在硬盘上的消息格式是什么

    消息由一个固定长度的头部和可变长度的字节数组组成。头部包含了一个版本号和 CRC32校验码

12. Kafka 高效文件存储设计特点

    1. Kafka 把 topic 中一个 parition 大文件分成多个小文件段，通过多个小文件段，就容易定期清除或删除已经消费完文件，减少磁盘占用
    2. 通过索引信息可以快速定位 message 和确定 response 的最大大小
    3. 通过 index 元数据全部映射到 memory，可以避免 segment file 的 IO 磁盘操作
    4. 通过索引文件稀疏存储，可以大幅降低 index 文件元数据占用空间大小

13. Kafka 与传统消息系统之间有三个关键区别

    1. Kafka 持久化日志，这些日志可以被重复读取和无限期保留
    2. Kafka 是一个分布式系统：它以集群的方式运行，可以灵活伸缩，在内部通过复制数据提升容错能力和高可用性
    3. Kafka 支持实时的流式处理

14. 消费者故障，出现活锁问题如何解决

    出现 “活锁 ” 的情 况， 是由于持续 的发 送心 跳， 但是 没有 处理 。为 了预 防消 费者 在这种 情况 下一 直持有分 区，我们 使用 max.poll.interval.ms 活跃 检测 机制 。 在此基础上， 如果 你调 用的 poll 的频 率大 于最 大间 隔， 则客 户端 将主 动地 离开 组， 以便其 他消 费者 接管 该分 区。 发生 这种 情况 时， 你会 看到 offset 提交 失败 （调 用commitSync（） 引发 的 CommitFailedException）。 这是 一种 安全 机制 ，保 障只有 活动 成员 能够 提交 offset。所 以要 留在 组中 ，你 必须 持续 调用 poll

    消费者提供两个配置设置来控制 poll 循环：
    max.poll.interval.ms：增大 poll 的间 隔 ，可以 为消 费者 提供 更多 的时 间去 处理 返回的 消息（调用 poll(long)返回 的消 息，通常 返回 的消 息都 是一 批）。缺点 是此 值越大 将会 延迟 组重 新平 衡。
    max.poll.records：此 设置 限制 每次 调用 poll 返回 的消 息数 ，这 样可 以更 容易 的预测 每次 poll 间隔 要处 理的 最大 值。通过 调整 此值 ，可以 减少 poll 间隔 ，减少 重新平 衡分 组的

    对于 消息 处理 时间 不可 预测 地的 情况 ，这些 选项 是不 够的 。 处理 这种 情况 的推 荐方法 是将 消息 处理 移到 另一 个线 程中 ，让消 费者 继续 调用 poll。 但是 必须 注意
    确保已 提交 的 offset 不超 过实 际位 置。 另外 ，你 必须 禁用 自动 提交 ，并 只有 在线 程完成 处理 后才 为记 录手 动提 交偏 移量（取决 于你 ）。 还要 注意 ，你需 要 pause暂停分 区， 不会 从 poll 接收 到新 消息 ，让 线程 处理 完之 前返 回的 消息 （如 果你 的处理能 力比 拉取 消息 的慢 ，那 创建 新线 程将 导致 你机 器内 存溢 出）

15. 上千万条消息在mq中积压了了⼏几个⼩小时还没解决

    1. 先修复consumer的问题，确保其恢复消费速度，然后将现有consumer都停掉
    2. 新建⼀一个topic，partition是原来的10倍，临时建⽴立好原先10倍或者20倍的queue数量量
    3. 然后写一个临时的分发数据的consumer程序，这个程序部署上去消费积压的数据.消费之后不不做耗时的处理理，直接均匀轮询写⼊入临时建⽴立好的10倍数量量的queue
    4. 接着临时征用10倍的机器器来部署consumer，每⼀一批consumer消费⼀一个临时queue的数据
    5. 这种做法相当于是临时将queue资源和consumer资源扩⼤大10倍，以正常的10倍速度来消费数据
    6. 等快速消费完积压数据之后，得恢复原先部署架构，重新⽤用原先的consumer机器器来消费消息 

    总结：
    1. 修复并停掉consumer；
    2. 新建一个topic，partition是原来的10倍，建⽴立临时queue，数量量是原来的10倍或20倍；
    3. 写临时consumer程序，临时征⽤用10倍的机器器去消费数据；
    4. 消费完成之后，恢复原先consumer

16. 什么是消费者组

    消费者组是Kafka提供的可扩展且具有容错性的消费者机制

    实际上，消费者组（Consumer Group）其实包含两个概念，作为队列，消费者组允许你分割数据处理到一组进程集合上（即一个消费者组中可以包含多个消费者进程，他们共同消费该topic的数据），这有助于你的消费能力的动态调整；作为发布-订阅模型（publish-subscribe），Kafka允许你将同一份消息广播到多个消费者组里，以此来丰富多种数据使用场景

    

    在消费者组中，多个实例共同订阅若干个主题，实现共同消费。同一个组下的每个实例
    都配置有相同的组ID，被分配不同的订阅分区。当某个实例挂掉的时候，其他实例会自动地承担起它负责消费的分区。因此，消费者组在一定程度上也保证了消费者程序的高可用性

    

17. __consumer_offsets是做什么用的

    一个内部主题，主要用于存储消费者的偏移量，以及消费者的元数据信息（消费者实例，消费者id等等 

    Kafka的GroupCoordinator组件提供对该主题完整的管理功能，包括该主题的创建、写入、读取和Leader维护等。
    
18. 



### Redis

1. Redis 与其他 key - value 缓存产品有以下三个特点

   1. Redis 支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。
   2. Redis 不仅仅支持简单的 key-value 类型的数据，同时还提供 list，set，zset，hash 等数据结构的存储。
   3. Redis 支持数据的备份，即 master-slave 模式的数据备份

2. Redis 的优势

   1. 性能极高 – Redis 能读的速度是 110000 次/s,写的速度是 81000 次/s 。丰富的数据类型 – Redis 支持二进制案例的 Strings, Lists, Hashes,
      Sets 及Ordered Sets 数据类型操作
   2. 原子 – Redis 的所有操作都是原子性的，意思就是要么成功执行要么失败完全不执行。单个操作是原子性的。多个操作也支持事务，即原子
      性，通过 MULTI 和 EXEC指令包起来
   3. 丰富的特性 – Redis 还支持 publish/subscribe, 通知, key 过期等等特性

3. Redis 的数据类型

   Redis 支持五种数据类型：string（字符串），hash（哈希），list（列表），set（集合）及 zsetsorted set：有序集合)

4. 使用 Redis 有哪些好处

   1. 速度快，因为数据存在内存中，类似于 HashMap，HashMap 的优势就是查找和操作的时间复杂度都是 O1)
   2. 支持丰富数据类型，支持 string，list，set，Zset，hash 等
   3. 支持事务，操作都是原子性，所谓的原子性就是对数据的更改要么全部执行，要么全部不执行
   4. 丰富的特性：可用于缓存，消息，按 key 设置过期时间，过期后将会自动删除

5. Redis 是单进程单线程的

   Redis 是单进程单线程的，redis 利用队列技术将并发访问变为串行访问，消除了传统数据库串行控制的开销

6. Redis 一个字符串类型的值能存储最大容量是多少

   512M

7. Redis持久化机制

   Redis是一个支持持久化的内存数据库，通过持久化机制把内存中的数据同步到硬盘文件来保证数据持久化。当Redis重启后通过把硬盘文件
   重新加载到内存，就能达到恢复数据的目的

8. RDB

   RDB是Redis默认的持久化方式。按照一定的时间周期策略把内存的数据以快照的形式保存到硬盘的二进制文件。即Snapshot快照存储，对
   应产生的数据文件为dump.rdb，通过配置文件中的save参数来定义快照的周期。（ 快照可以是其所表示的数据的一个副本，也可以是数据
   的一个复制品。）

   ###### 优点：

   1. 只有一个文件 dump.rdb，方便持久化。
   2. 容灾性好，一个文件可以保存到安全的磁盘。
   3. 性能最大化，fork 子进程来完成写操作，让主进程继续处理命令，所以是 IO最大化。使用单独子进程来进行持久化，主进程不会进行任
      何 IO 操作，保证了 redis的高性能) 4.相对于数据集大时，比 AOF 的启动效率更高。

   ###### 缺点：

   1. 数据安全性低。RDB 是间隔一段时间进行持久化，如果持久化之间 redis 发生故障，会发生数据丢失。所以这种方式更适合数据要求不
      严谨的时候)

9. AOF

   Redis会将每一个收到的写命令都通过Write函数追加到文件最后，类似于MySQL的binlog。当Redis重启是会通过重新执行文件中保存的写命令来在内存中重建整个数据库的内容。当两种方式同时开启时，数据恢复Redis会优先选择AOF恢复

   ###### 优点：

   1. 数据安全，aof 持久化可以配置 appendfsync 属性，有 always，每进行一次命令操作就记录到 aof 文件中一次。
   2. 通过 append 模式写文件，即使中途服务器宕机，可以通过 redis-check-aof工具解决数据一致性问题。
   3. AOF 机制的 rewrite 模式。AOF 文件没被 rewrite 之前（文件过大时会对命令进行合并重写），可以删除其中的某些命令（比如误操作
      的 flushall）)

   ###### 缺点：

   1. AOF 文件比 RDB 文件大，且恢复速度慢。
   2. 数据集大的时候，比 rdb 启动效率低。

10. 缓存雪崩

    简单理解为：由于原有缓存失效，新缓存未到期间(例如：我们设置缓存时采用了相同的过期时间，在同一时刻出现大面积的缓存过期)，所有原本应该访问缓存的请求都去查询数据库了，而对数据库CPU和内存造成巨大压力，严重的会造成数据库宕机。从而形成一系列连锁反应，造成整个系统崩溃、

    解决办法：

    1. 大多数系统设计者考虑用加锁（ 最多的解决方案）或者队列的方式保证来保证不会有大量的线程对数据库一次性进行读写，从而避免失效时大量的并发请求落到底层存储系统上。还有一个简单方案就时将缓存失效时间分散开
    2. 永远不过期：物理不过期，但逻辑过期（后台异步线程去刷新）
    3. 采用限流算法，限制流量

11. 缓存穿透

    缓存穿透是指用户查询数据，在数据库没有，自然在缓存中也不会有。这样就导致用户查询的时候，在缓存中找不到，每次都要去数据库再查询一遍，然后返回空（相当于进行了两次无用的查询）。这样请求就绕过缓存直接查数据库，这也是经常提的缓存命中率问题

    解决办法;
    最常见的则是采用布隆过滤器，将所有可能存在的数据哈希到一个足够大的bitmap中，一个一定不存在的数据会被这个bitmap拦截掉，从而避免了对底层存储系统的查询压力。另外也有一个更为简单粗暴的方法，如果一个查询返回的数据为空（不管是数据不存在，还是系统故障），我们仍然把这个空结果进行缓存，但它的过期时间会很短，最长不超过五分钟。通过这个直接设置的默认值存放到缓存，这样第二次到缓冲中获取就有值了，而不会继续访问数据库，这种办法最简单粗暴

    

12. 布隆过滤器

    就是引入了k(k>1)k(k>1)个相互独立的哈希函数，保证在给定的空间、误判率下，完成元素判重的过程。
    它的优点是空间效率和查询时间都远远超过一般的算法，缺点是有一定的误识别率和删除困难。

    Bloom-Filter算法的核心思想就是利用多个不同的Hash函数来解决“冲突”。
    Hash存在一个冲突（碰撞）的问题，用同一个Hash得到的两个URL的值有可能相同。为了减少冲突，我们可以多引入几个Hash，如果通过其中的一个Hash值我们得出某元素不在集合中，那么该元素肯定不在集合中。只有在所有的Hash函数告诉我们该元素在集合中时，才能确定该元素存在于集合中。这便是Bloom-Filter的基本思想。
    Bloom-Filter一般用于在大数据量的集合中判定某元素是否存在

13. 缓存预热

    缓存预热就是系统上线后，将相关的缓存数据直接加载到缓存系统。这样就可以避免在用户请求的时候，先查询数据库，然后再将数据缓存的问题！用户直接查询事先被预热的缓存数据

    解决思路：

    1. 直接写个缓存刷新页面，上线时手工操作下；
    2. 数据量不大，可以在项目启动的时候自动进行加载；
    3. 定时刷新缓存

14. 缓存更新

    除了缓存服务器自带的缓存失效策略之外（Redis默认的有6中策略可供选择），我们还可以根据具体的业务需求进行自定义的缓存淘汰，常见的策略有两种

    1. 定时去清理过期的缓存
    2. 当有用户请求过来时，再判断这个请求所用到的缓存是否过期，过期的话就去底层系统得到新数据并更新缓存

15. 缓存降级

    当访问量剧增、服务出现问题（如响应时间慢或不响应）或非核心服务影响到核心流程的性能时，仍然需要保证服务还是可用的，即使是有损服务。系统可以根据一些关键数据进行自动降级，也可以配置开关实现人工降级

16. redis的数据类型，以及每种数据类型的使用场景

    - String
      这个其实没啥好说的，最常规的set/get操作，value可以是String也可以是数字。一般做一些复杂的计数功能的缓存。
      
    - hashhash 

      是一个 string 类型的 field 和 value 的映射表，hash 特别适合用于存储对象，后续操作的时候，你可以直接仅仅修改这个对象中的某个字段的值。 比如我们可以 hash 数据结构来存储用户信息，商品信息等等

    - list
      list 的实现为一个双向链表，即可以支持反向查找和遍历，更方便操作，不过带来了部分额外的内
      存开销 ， 可以做简单的消息队列的功能。 另外还有一个就是，可以利用lrange命令，做基于redis的分页功能，性能极佳，用户
      体验好。本人还用一个场景，很合适—取行情信息。就也是个生产者和消费者的场景。LIST可以很好的完成排队，先进先出的原则。
      
    - set
      因为set堆放的是一堆不重复值的集合。所以可以做全局去重的功能。为什么不用JVM自带的Set进行去重？因为我们的系统一般都是集群部
      署，使用JVM自带的Set，比较麻烦，难道为了一个做一个全局去重，再起一个公共服务，太麻烦了。
      另外，就是利用交集、并集、差集等操作，可以计算共同喜好，全部的喜好，自己独有的喜好等功能。
      
    - sorted set
      sorted set多了一个权重参数score,集合中的元素能够按score进行排列。可以做排行榜应用，取TOP N操作

17. redis的过期策略

    redis采用的是定期删除+惰性删除策略

18. 为什么不用定时删除策略

    定时删除,用一个定时器来负责监视key,过期则自动删除。虽然内存及时释放，但是十分消耗CPU资源。在大并发请求下，CPU要将时间应用在处理请求，而不是删除key,因此没有采用这一策略

19. 定期删除+惰性删除是如何工作的呢

    定期删除，redis默认每个100ms检查，是否有过期的key,有过期key则删除。需要说明的是，redis不是每个100ms将所有的key检查一次，而是随机抽取进行检查(如果每隔100ms,全部key进行检查，redis岂不是卡死)。因此，如果只采用定期删除策略，会导致很多key到时间没有删除。于是，惰性删除派上用场。也就是说在你获取某个key的时候，redis会检查一下，这个key如果设置了过期时间那么是否过期了？如果过期了此时就会删除

20. 内存淘汰策略

    volatile-lru：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰 （这种情况一般是把redis既当缓存，又做持久化存储的时候才用。不推荐）
    volatile-ttl：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰
    volatile-random：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰
    allkeys-lru：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰 （推荐使用，目前项目在用这种）
    allkeys-random：从数据集（server.db[i].dict）中任意选择数据淘汰
    no-enviction（驱逐）：禁止驱逐数据，新写入操作会报错

21. Redis 常见性能问题和解决方案

    1.  Master 最好不要做任何持久化工作，如 RDB 内存快照和 AOF 日志文件
    2.  如果数据比较重要，某个 Slave 开启 AOF 备份数据，策略设置为每秒同步一次
    3.  为了主从复制的速度和连接的稳定性， Master 和 Slave 最好在同一个局域网内
    4.  尽量避免在压力很大的主库上增加从库
    5.  主从复制不要用图状结构，用单向链表结构更为稳定，即： Master <- Slave1 <- Slave2 <-Slave3 。这样的结构方便解决单点故障问题，
       实现 Slave 对 Master的替换。如果 Master 挂了，可以立刻启用 Slave1 做 Master，其他不变

22. 为什么Redis的操作是原子性的，怎么保证原子性的

    对于Redis而言，命令的原子性指的是：一个操作的不可以再分，操作要么执行，要么不执行。
    Redis的操作之所以是原子性的，是因为Redis是单线程的。
    Redis本身提供的所有API都是原子操作，Redis中的事务其实是要保证批量操作的原子性

23. Redis 的同步机制

    Redis 可以使用主从同步，从从同步。第一次同步时，主节点做一次 bgsave，并同时将后续修改操作记录到内存 buffer，待完成后将 rdb
    文件全量同步到复制节点，复制节点接受完成后将 rdb 镜像加载到内存。加载完成后，再通知主节点将期间修改的操作记录同步到复制节点
    进行重放就完成了同步过程

24. Redis 的内存用完了会发生什么

    如果达到设置的上限，Redis 的写命令会返回错误信息（但是读命令还可以正常返回。）或者你可以将 Redis 当缓存来使用配置淘汰机制，
    当 Redis 达到内存上限时会冲刷掉旧的内容

25. Redis 最适合的场景

    1. 会话缓存（Session Cache）
    2. 全页缓存（FPC）
    3. 队列
    4. 排行榜/计数器
    5. 发布/订阅

26. 使用过 Redis 做异步队列么，你是怎么用的

    一般使用 list 结构作为队列，rpush 生产消息，lpop 消费消息。当 lpop 没有消息的时候，要适当 sleep 一会再重试

    ###### 如果对方追问可不可以不用 sleep 呢？

    list 还有个指令叫 blpop，在没有消息的时候，它会阻塞住直到消息到来。如果对方追问能不能生产一次消费多次呢？使用 pub/sub 主题订
    阅者模式，可以实现1:N 的消息队列。

    ###### 如果对方追问 pub/sub 有什么缺点？

    在消费者下线的情况下，生产的消息会丢失，得使用专业的消息队列如 RabbitMQ等。

    ###### 如果对方追问 redis 如何实现延时队列？

    我估计现在你很想把面试官一棒打死如果你手上有一根棒球棍的话，怎么问的这么详细。但是你很克制，然后神态自若的回答道：使用
    sortedset，拿时间戳作为score，消息内容作为 key 调用 zadd 来生产消息，消费者用 zrangebyscore 指令获取 N 秒之前的数据轮询进行
    处理。到这里，面试官暗地里已经对你竖起了大拇指。但是他不知道的是此刻你却竖起了中指，在椅子背后

    

27. redis 分布式锁

    1. 获取锁的时 线程 A setnx(上锁的对象,超时时的时间戳 t1)，如果返回 true，获得锁
    2. 线程 B 用 get 获取 t1,与当前时间戳比较,判断是是否超时,没超时 false,若超时执行第 3 步;
    3. 计算新的超时时间 t2,使用 getset 命令返回 t3(该值可能其他线程已经修改过),如果 t1==t3，获得锁，如果 t1!=t3 说明锁被其他线程获取了
    4. 获取锁后，处理完业务逻辑，再去判断锁是否超时，如果没超时删除锁，如果已超时，不用处理（防止删除其他线程的锁）

28. Redis中数据库默认是多少个db即作用

    Redis默认支持16个数据库，可以通过配置databases来修改这一数字。客户端与Redis建立连接后会自动选择0号数据库，不过可以随时使用select命令更换数据库。
    Redis支持多个数据库，并且每个数据库是隔离的不能共享，并且基于单机才有，如果是集群就没有数据库的概念

29. Redis 集群的主从复制模型是怎样的

    为了使在部分节点失败或者大部分节点无法通信的情况下集群仍然可用，所以集群使用了主从复制模型,每个节点都会有 N-1 个复制品

30.  Redis 集群如何选择数据库

    Redis 集群目前无法做数据库选择，默认在 0 数据库。

31. Redis 中的管道有什么用

    一次请求/响应服务器能实现处理新的请求即使旧的请求还未被响应，这样就可以将多个命令发送到服务器，而不用等待回复，最后在一个步骤中读取该答复

32. 怎么理解 Redis 事务

    事务是一个单独的隔离操作：事务中的所有命令都会序列化、按顺序地执行，事务在执行的过程中，不会被其他客户端发送来的命令请求所打断

    事务是一个原子操作：事务中的命令要么全部被执行，要么全部都不执行

33. Redis 事务相关的命令有哪几个

    1. DISCARD用来取消一个事务
    2. EXEC用来执行一个事务
    3. MULTI用来组装一个事务
    4. WATCH用来监视一些key，一旦这些key在事务执行之前被改变，则取消事务的执行
    5. WATCH取消 WATCH 命令对所有 key 的监视。

34. Redis key 的过期时间和永久有效分别怎么设置

    EXPIRE 和 PERSIST 命令

    expire 指令可以设置 key 的超时时间，单 位秒。即在多少秒后过期。 返回1代表设置成功；返回 0 代表设置不成功，此时是因为key不存在导致的

    使用 persist 清除过期时间   persist "key"   persist 返回值   1：成功清理过期时间    0：key 不存在，或者没有设置过期时间

35. watch dog 自动延期机制

    客户端 1 加锁的锁 key 默认生存时间才 30 秒，如果超过了 30 秒，客户端 1 还想一直持有这把锁，怎么办呢

    简单！只要客户端 1 一旦加锁成功，就会启动一个 watch dog 看门狗，他是一个后台线程，会每隔 10秒检查一下，如果客户端 1 还持有锁 key，那么就会不断的延长锁 key 的生存时间 

36. LRU 算法实现

    1. 通过双向链表来实现，新数据插入到链表头部

    2. 每当缓存命中（即缓存数据被访问），则将数据移到链表头部

    3. 当链表满的时候，将链表尾部的数据丢弃

       LinkedHashMap 通过维护一个额外的双向链表保证了迭代顺序。该迭代顺序可以是插入顺序（默认），也可以是访问顺序

37. 

### Mysql

1. InnoDB（B+树）

   InnoDB 底层存储结构为B+树， B树的每个节点对应innodb的一个page， page大小是固定的，一般设为 16k。其中非叶子节点只有键值，
   叶子节点包含完成数据

   适用场景：
   1）经常更新的表，适合处理多重并发的更新请求。
   2）支持事务。
   3）可以从灾难中恢复（通过 bin-log 日志等）。
   4）外键约束。只有他支持外键。
   5）支持自动增加列属性 auto_increment

2. MyIASM

   MyIASM是 MySQL默认的引擎，但是它没有提供对数据库事务的支持，也不支持行级锁和外键，因此当 NSERT(插入)或 UPDATE(更新)数据
   时即写操作需要锁定整个表，效率便会低一些。

   ISAM 执行读取操作的速度很快，而且不占用大量的内存和存储资源。在设计之初就预想数据组织成有固定长度的记录，按顺序存储的。 ---
   ISAM 是一种静态索引结构。 缺点是它不 支持事务处理。

3. InnoDB与MyISAM的区别

   1. InnoDB支持事务，MyISAM不支持，对于InnoDB每一条SQL语言都默认封装成事务，自动提交，这样会影响速度，所以最好把多条
   SQL语言放在begin和commit之间，组成一个事务；
   2. InnoDB支持外键，而MyISAM不支持。对一个包含外键的InnoDB表转为MYISAM会失败；
   3. InnoDB是聚集索引，数据文件是和索引绑在一起的，必须要有主键，通过主键索引效率很高。但是辅助索引需要两次查询，先查询到
   主键，然后再通过主键查询到数据。因此，主键不应该过大，因为主键太大，其他索引也都会很大。而MyISAM是非聚集索引，数据文
   件是分离的，索引保存的是数据文件的指针。主键索引和辅助索引是独立的。
   4. InnoDB不保存表的具体行数，执行select count(*) from table时需要全表扫描。而MyISAM用一个变量保存了整个表的行数，执行上
   述语句时只需要读出该变量即可，速度很快；
   5. Innodb不支持全文索引，而MyISAM支持全文索引，查询效率上MyISAM要高

4. 索引

   索引（Index）是帮助 MySQL 高效获取数据的数据结构。 常见的查询算法,顺序查找,二分查找,二叉排序树查找,哈希散列法,分块查找,平衡多路搜索树 B 树（B-tree） ，索引是对数据库表中一个或多个列的值进行排序的结构，建立索引有助于快速获取信息

   mysql 有4种不同的索引：
   主键索引（PRIMARY）
   唯一索引（UNIQUE）
   普通索引（INDEX）
   全文索引（FULLTEXT）

5. 索引的优缺点

   优点：

   1. 索引加快数据库的检索速度
   2. 唯一索引可以确保每一行数据的唯一性
   3. 通过使用索引，可以在查询的过程中使用优化隐藏器，提高系统的性能

   缺点：

   1. 索引降低了插入、删除、修改等维护任务的速度
   2. 增加了数据库的存储空间

6. 常见索引原则

   1. 选择唯一性索引，唯一性索引的值是唯一的，可以更快速的通过该索引来确定某条记录。
   2. 为经常需要排序、分组和联合操作的字段建立索引。
   3. 为常用作为查询条件的字段建立索引。
   4. 限制索引的数目：越多的索引，会使更新表变得很浪费时间。尽量使用数据量少的索引
   5. 如果索引的值很长，那么查询的速度会受到影响。尽量使用前缀来索引
   7. 删除不再使用或者很少使用的索引
   8. 最左前缀匹配原则，非常重要的原则。
   9. 尽量选择区分度高的列作为索引区分度的公式是表示字段不重复的比例
   10. 索引列不能参与计算，保持列“干净”：带函数的查询不参与索引。
   11. 尽量的扩展索引，不要新建索引

7. SQL优化

   1. 查询语句中不要使用select *
   2. 尽量减少子查询，使用关联查询（left join,right join,inner join）替代
   3. 减少使用IN或者NOT IN ,使用exists，not exists或者关联查询语句替代
   4. or 的查询尽量用 union或者union all 代替(在确认没有重复数据或者不用剔除重复数据时，union all会更好)
   5. 应尽量避免在 where 子句中使用!=或<>操作符，否则将引擎放弃使用索引而进行全表扫描。
   6. 应尽量避免在 where 子句中对字段进行 null 值判断，否则将导致引擎放弃使用索引而进行全表扫描，如： select id from t where num is null 可以在num上设置默认值0，确保表中num列没有null值，然后这样查询： select id from t where num=0

   

9. 什么是视图

   视图是一种虚拟的表，具有和物理表相同的功能。可以对视图进行增，改，查，操作，视图通常是有一个表或者多个表的行或列的子集。对
   视图的修改不影响基本表。它使得我们获取数据更容易，相比多表查

10. 什么是内联接、左外联接、右外联接

    内联接（Inner Join）：匹配2张表中相关联的记录。
    左外联接（Left Outer Join）：除了匹配2张表中相关联的记录外，还会匹配左表中剩余的记录，右表中未匹配到的字段用NULL表示。
    右外联接（Right Outer Join）：除了匹配2张表中相关联的记录外，还会匹配右表中剩余的记录，左表中未匹配到的字段用NULL表示。在
    判定左表和右表时，要根据表名出现在Outer Join的左右位置关系

11. 并发事务带来哪些问题

    ###### 脏读（Dirty read）:

     当一个事务正在访问数据并且对数据进行了修改，而这种修改还没有提交到数据库中，这时另外一个事务也访问了这
    个数据，然后使用了这个数据。因为这个数据是还没有提交的数据，那么另外一个事务读到的这个数据是“脏数据”，依据“脏数据”所做的操
    作可能是不正确的。

    ###### 丢失修改（Lost to modify）: 

    指在一个事务读取一个数据时，另外一个事务也访问了该数据，那么在第一个事务中修改了这个数据后，第
    二个事务也修改了这个数据。这样第一个事务内的修改结果就被丢失，因此称为丢失修。 例如：事务1读取某表中的数据A=20，事务2也读
    取A=20，事务1修改A=A-1，事务2也修改A=A-1，最终结果A=19，事务1的修改被丢失。

    ###### 不可重复读（Unrepeatableread）: 

    指在一个事务内多次读同一数据。在这个事务还没有结束时，另一个事务也访问该数据。那么，在第
    一个事务中的两次读数据之间，由于第二个事务的修改导致第一个事务两次读取的数据可能不太一样。这就发生了在一个事务内两次读到的
    数据是不一样的情况，因此称为不可重复读。

    ###### 幻读（Phantom read）: 

    幻读与不可重复读类似。它发生在一个事务（T1）读取了几行数据，接着另一个并发事务（T2）插入了一些数据
    时。在随后的查询中，第一个事务（T1）就会发现多了一些原本不存在的记录，就好像发生了幻觉一样，所以称为幻读。

    ###### 不可重复读和幻读区别：

    不可重复读的重点是修改比如多次读取一条记录发现其中某些列的值被修改，幻读的重点在于新增或者删除比如多次读取一条记录发现记录
    增多或减少了

12. 大表如何优化

    ###### 限定数据的范围

    务必禁止不带任何限制数据范围条件的查询语句。比如：我们当用户在查询订单历史的时候，我们可以控制在一个月的范围内；

    ###### 读/写分离

    经典的数据库拆分方案，主库负责写，从库负责读；

    ###### 垂直分区

    根据数据库里面数据表的相关性进行拆分。 例如，用户表中既有用户的登录信息又有用户的基本信息，可以将用户表拆分成两个单独的
    表，甚至放到单独的库做分库。

13. 存储过程优化思路

    1. 尽量利用一些 sql 语句来替代一些小循环，例如聚合函数，求平均函数等。
    2. 中间结果存放于临时表，加索引。
    3. 少使用游标。 sql 是个集合语言，对于集合运算具有较高性能。而 cursors 是过程运算。比如对一个 100 万行的数据进行查询。游标
    需要读表 100 万次，而不使用游标则只需要少量几次读取。
    4. 事务越短越好。 sqlserver 支持并发操作。如果事务过多过长，或者隔离级别过高，都会造成并发操作的阻塞，死锁。导致查询极慢，
    cpu 占用率极地。
    5. 使用 try-catch 处理错误异常。
    6. 查找语句尽量不要放在循环内

14. MySQL 中有哪几种锁

    1. 表级锁：开销小，加锁快；不会出现死锁；锁定粒度大，发生锁冲突的概率最高，并发度最低。
    2. 行级锁：开销大，加锁慢；会出现死锁；锁定粒度最小，发生锁冲突的概率最低，并发度也最高。
    3. 页面锁：开销和加锁时间界于表锁和行锁之间；会出现死锁；锁定粒度界于表锁和行锁之间，并发度一般

15. LIKE 声明中的％和_是什么意思

    ％对应于 0 个或更多字符，_只是 LIKE 语句中的一个字符

16. BLOB 和 TEXT 有什么区别

    BLOB 是一个二进制对象，可以容纳可变数量的数据。TEXT 是一个不区分大小写的 BLOB  

     BLOB 和 TEXT 类型之间的唯一区别在于对 BLOB 值进行排序和比较时区分大小写，对 TEXT 值不区分大小写

17. 什么情况下设置了索引但无法使用

    1. 以“%”开头的 LIKE 语句，模糊匹配
    2. OR 语句前后没有同时使用索引
    3. 数据类型出现隐式转化（如 varchar 不加单引号的话可能会自动转换为 int 型）

18. 优化数据库的方法

    1. 选取最适用的字段属性，尽可能减少定义字段宽度，尽量把字段设置 NOTNULL，例如’省份’、’性别’最好适用 ENUM
    2. 使用连接(JOIN)来代替子查询
    3. 适用联合(UNION)来代替手动创建的临时表
    4. 事务处理
    5. 锁定表、优化事务处理
    6. 适用外键，优化锁定表
    7. 建立索引
    8. 优化查询语句

19. 索引的目的是什么

    快速访问数据表中的特定信息，提高检索速度
    创建唯一性索引，保证数据库表中每一行数据的唯一性。
    加速表和表之间的连接
    使用分组和排序子句进行数据检索时，可以显著减少查询中分组和排序的时间

20. 索引对数据库系统的负面影响是什么

    创建索引和维护索引需要耗费时间，这个时间随着数据量的增加而增加；索引需要占用物理空间，不光是表需要占用数据空间，每个索引也
    需要占用物理空间；当对表进行增、删、改、的时候索引也要动态维护，这样就降低了数据的维护速度

21. 建立索引的原则

    在最频繁使用的、用以缩小查询范围的字段上建立索引。
    在频繁使用的、需要排序的字段上建立索引

22. 主键、外键和索引的区别

    ###### 定义 ：

    主键–唯一标识一条记录，不能有重复的，不允许为空
    外键–表的外键是另一表的主键, 外键可以有重复的, 可以是空值
    索引–该字段没有重复值，但可以有一个空值

    ###### 作用：

    主键–用来保证数据完整性
    外键–用来和其他表建立联系用的
    索引–是提高查询排序的速度

    ###### 个数：

    主键–主键只能有一个
    外键–一个表可以有多个外键
    索引–一个表可以有多个唯一索引

23. 什么是行级锁

    行级锁是一种排他锁，防止其他事务修改此行；在使用以下语句时， Oracle 会自动应用行级锁：
    1. INSERT、 UPDATE、 DELETE、 SELECT … FOR UPDATE [OF columns] [WAIT n | NOWAIT];
    2. SELECT … FOR UPDATE 语句允许用户一次锁定多条记录进行更新
    3. 使用 COMMIT 或 ROLLBACK 语句释放锁

24. 什么是表级锁

    表示对当前操作的整张表加锁，它实现简单，资源消耗较少，被大部分 MySQL 引擎支持。最常使用的 MYISAM 与 INNODB 都支持表级锁
    定。表级锁定分为表共享读锁（共享锁）与表独占写锁（排他锁）

25. 什么是页级锁

    页级锁是 MySQL 中锁定粒度介于行级锁和表级锁中间的一种锁。表级锁速度快，但冲突多，行级冲突少，但速度慢。所以取了折衷的页
    级，一次锁定相邻的一组记录。 BDB 支持页级锁

26. 一张表，里面有 ID 自增主键，当 insert 了 17 条记录之后，删除了第 15,16,17 条记录，再把 Mysql 重启，再 insert 一条记录，这条记录的 ID 是 18 还是 15

    1. 如果表的类型是 MyISAM，那么是 18因为 MyISAM 表会把自增主键的最大 ID 记录到数据文件里，重启 MySQL 自增主键的最大ID 也不会丢失
    2. 如果表的类型是 InnoDB，那么是 15  InnoDB 表只是把自增主键的最大 ID 记录到内存中，所以重启数据库或者是对表进行OPTIMIZE 操作，都会导致最大 ID 丢失

27. drop,delete 与 truncate 的区别

    1. DELETE 语句执行删除的过程是每次从表中删除一行，并且同时将该行的删除操作作为事务记录在日志中保存以便进行进行回滚操作。TRUNCATE TABLE则一次性地从表中删除所有的数据并不把单独的删除操作记录记入日志保存，删除行是不能恢复的。并且在删除的过程中不会激活与表有关的删除触发器。执行速度快

    2. 表和索引所占空间。当表被 TRUNCATE 后，这个表和索引所占用的空间会恢复到初始大小，而 DELETE 操作不会减少表或索引所占用的空间。drop 语句将表所占用的空间全释放掉

    3. 一般而言，drop > truncate > delete

    4.  TRUNCATE 只能对 TABLE；DELETE 可以是 table 和 view

    5. TRUNCATE 和 DELETE 只删除数据，而 DROP 则删除整个表（结构和数据）

    6. truncate 与不带 where 的 delete ：只删除数据，而不删除表的结构（定义）drop 语句将删除表的结构被依赖的约束（constrain),触发器（trigger)索引（index);依赖于该表的存储过程/函数将被保留，但其状态会变为：invalid

    7. delete 语句为 DML （data maintain Language),这个操作会被放到 rollbacksegment 中,事务提交后才生效。如果有相应的 tigger,执行的时候将被触发

    8. truncate、drop 是 DLL（data define language),操作立即生效，原数据不放到 rollback segment 中，不能回滚

28. mysql 中  varchar 和char  的区别以及 varchar (50) 中，50 代表什么

    1. varchar 和 char  的区别在于 char 是一种固定长度的类型，varchar  则是一种可变长度的类型
    2. varchar （50） 中的50 含义最多存放50 个字符， varchar  （50） varchar （200） 存储hello 所占空间一样，但后者在排序时会消耗更多的内存，因为 order by col 采用 fixed_length 计算col 长度

29. MySQL的binlog有有几种录入格式?分别有什么区别

    有三种格式  statement  ，row  和mixed 

    - statement 模式下，记录单元为语句，即每一个sql造成的影响会记录.由于sql的执行是有上下文的,因此在保存的时候需要保存相关的信息,同时还有一些使用了函数之类的语句无法被记录复制
    - row级别下,记录单元为每一行的改动,基本是可以全部记下来但是由于很多操作,会导致大量行的改动(比如alter table),因此这种模式的文件保存的信息太多,日志量太大
      - mixed. 一种折中的方案,普通操作使用statement记录,当无法使用statement的时候使用row

30. 横向分表和纵向分表

    横向分表是按行分表.假设我们有一张用户表,主键是自增ID且同时是用户的ID.数据量较大,有1亿多条,那么此时放在一张表里的查询效果就不太理想.我们可以根据主键ID进行分表,无论是按尾号分,或者按ID的区间分都是可以的. 假设按照尾号0-99分为100个表,那么每张表中的数据就仅有100w.这时的查询效率无疑是可以满足要求的

    

    纵向分表是按列分表.假设我们现在有一张文章表.包含字段 id-摘要-内容 .而系统中的展示形式是刷新出一个列表,列表中仅包含标题和摘要,当用户点击某篇文章进入详情时才需要正文内容.此时,如果数据量大,将内容这个很大且不经常使用的列放在一起会拖慢原表的查询速度

31. 什么是存储过程？有哪些优缺点

    存储过程是一些预编译的SQL语句

    1. 更加直白的理解：存储过程可以说是一个记录集，它是由一些T-SQL语句组成的代码块，这些T-SQL语句代码像一个方法一样实现一些功能（对单表或多表的增删改
       查），然后再给这个代码块取一个名字，在用到这个功能的时候调用他就行了
    2. 存储过程是一个预编译的代码块，执行效率比较高,一个存储过程替代大量T_SQL语句 ，可以降低网络通信量，提高通信速率,可以一定程度上确保数据安全

32. 说一说三个范式

    ###### 第一范式

    每个列都不可以再拆分

    ###### 第二范式

    非主键列完全依赖于主键,而不能是依赖于主键的一部分

    ###### 第三范式

    非主键列只依赖于主键,不依赖于其他非主键.

33. MySQL的复制原理以及流程

    基本原理流程，3个线程以及之间的关联

    1. 主：binlog线程——记录下所有改变了数据库数据的语句，放进master上的binlog中
    2. 从：io线程——在使用start slave 之后，负责从master上拉取 binlog 内容，放进 自己的relay log中
    3. 从：sql执行线程——执行relay log中的语句

34. MySQL由哪些部分组成, 分别用来做什么

    ###### Server 

    - 连接器: 管理连接, 权限验证.
    - 分析器: 词法分析, 语法分析.
    - 优化器: 执行计划生成, 索引的选择.
    - 执行器: 操作存储引擎, 返回执行结果

    ###### 存储引擎

    存储数据, 提供读写接口

35. MySQL 数据库作发布系统的存储，一天五万条以上的增量， 预计运维三年,怎么优化

    1. 设计良好的数据库结构， 允许部分数据冗余， 尽量避免 join 查询， 提高效率
    2. 选择合适的表字段数据类型和存储引擎， 适当的添加索引
    3. MySQL 库主从读写分离
    4. 找规律分表， 减少单表中的数据量提高查询速度。
    5. 添加缓存机制， 比如 memcached， apc等
    6. 书写高效率的 SQL。比如 SELECT * FROM TABEL 改为 SELECT field_1, field_2, field_3 FROM TABLE.

36. MySQL 外连接、内连接与自连接的区别

    ###### 内连接

    只有条件的交叉连接，根据某个条件筛选出符合条件的记录，不符合条件的记录不会出现在结果集中， 即内连接只连接匹配的行

    ###### 外连接

    其结果集中不仅包含符合连接条件的行，而且还会包括左表、右表或两个表中的所有数据行

37. 主键使用自增ID还是UUID

    推荐使用自增ID,不要使用UUID

    因为在InnoDB存储引擎中,主键索引是作为聚簇索引存在的,也就是说,主键索引的B+树叶子节点上存储了主键索引以及全部的数据(按照顺序),如果主键索引是自增ID,那么只需要不断向后排列即可,如果是UUID,由于到来的ID与原来的大小不确定,会造成非常多的数据插入,数据移动,然后导致产生很多的内存碎片,进而造成插入性能的下降.

    总之,在数据量大一些的情况下,用自增主键性能会好一些

38. 如果要存储用户的密码散列,应该使用什么字段进行存储

    密码散列,盐,用户身份证号等固定长度的字符串应该使用char而不是varchar来存储,这样可以节省空间且提高检索效率

39. 什么情况下设置了索引但无法使用

    1. 以“%” 开头的 LIKE 语句， 模糊匹配
    2. OR 语句前后没有同时使用索引
    3. 数据类型出现隐式转化（ 如 varchar 不加单引号的话可能会自动转换为 int 型）

40. B-Tree 和 B+Tree

    ###### 区别

    1. B-Tree 的关键字和记录是放在一起的，叶子节点可以看作外部节点，不包含任何信息；B+Tree 的非叶子节点中只有关键字和指向下一个节点的索引，记录只放在叶子节点中
    2.  在 B-Tree 中，越靠近根节点的记录查找时间越快，只要找到关键字即可确定记录的存在；而
       B+Tree 中每个记录的查找时间基本是一样的，都需要从根节点走到叶子节点，而且在叶子节点中还要再比较关键字。从这个角度看 B-Tree 的性能好像要比 B+Tree 好，而在实际应用中却是B+Tree 的性能要好些。因为 B+Tree 的非叶子节点不存放实际的数据，这样每个节点可容纳的元素个数比 B-Tree 多，树高比 B-Tree 小，这样带来的好处是减少磁盘访问次数。尽管 B+Tree 找到一个记录所需的比较次数要比 B-Tree 多，但是一次磁盘访问的时间相当于成百上千次内存比较的时间，因此实际中 B+Tree 的性能可能还会好些，而且 B+Tree 的叶子节点使用指针连接在一起，
       方便顺序遍历（例如查看一个目录下的所有文件，一个表中的所有记录等），这也是很多数据库和文件系统使用 B+Tree 的缘故

41. 为什么 B+Tree 比 B-Tree 更适合实际应用中操作系统的文件索引和数据库索引

    1. B+Tree 的磁盘读写代价更低

       B+Tree 的内部结点并没有指向关键字具体信息的指针。因此其内部结点相对 B-Tree 更小。如果把所有同一内部结点的关键字存放在同一盘块中，那么盘块所能容纳的关键字数量也越多。一次性读入内存中的需要查找的关键字也就越多。相对来说 IO 读写次数也就降低了

    2.  B+Tree 的查询效率更加稳定

       由于非终结点并不是最终指向文件内容的结点，而只是叶子结点中关键字的索引。所以任何关键字的查找必须走一条从根结点到叶子结点的路。所有关键字查询的路径长度相同，致每一个数据的查询效率相当

42. 为什么用 B+ 树做索引而不用哈希表做索引

    1. 哈希表是把索引字段映射成对应的哈希码然后再存放在对应的位置，这样的话，如果我们要进行模糊查找的话，显然哈希表这种结构是不支持的，只能遍历这个表。而B+树则可以通过最左前缀原则快速找到对应的数据。
    2. 如果我们要进行范围查找，例如查找ID为100 ~ 400的人，哈希表同样不支持，只能遍历全表
    3. 索引字段通过哈希映射成哈希码，如果很多字段都刚好映射到相同值的哈希码的话，那么形成的索引结构将会是一条很长的链表，这样的话，查找的时间就会大大增加

43. 联合索引是什么?为什么需要注意联合索引中的顺序

    MySQL可以使用多个字段同时建立一个索引,叫做联合索引.在联合索引中,如果想要命中索引,需要按照建立索引时的字段顺序挨个使用,否则无法命中索引

    ###### 具体原因为:

    MySQL使用索引时需要索引有序,假设现在建立了"name,age,school"的联合索引,那么索引的排序为: 先按照name排序,如果name相同,则按照age排序,如果age的值也相等,则按照school进行排序

    当进行查询时,此时索引仅仅按照name严格有序,因此必须首先使用name字段进行等值查询,之后对于匹配到的列而言,其按照age字段严格有序,此时可以使用age字段用做索引查找,,,以此类推.因此在建立联合索引的时候应该注意索引列的顺序,一般情况下,将查询需求频繁或者字段选择性高的列放在前面.此外可以根据特例的查询或者表结构进行单独的调整.

44. 那么在哪些情况下会发生针对该列创建了索引但是在查询的时候并没有使用呢

    1. 使用不等于查询
    2. 列参与了数学运算或者函数
    3. 在字符串like时左边是通配符.类似于'%aaa'
    4. 当mysql分析全表扫描比使用索引快的时候不使用索引.
    5. 当使用联合索引,前面一个条件为范围查询,后面的即使符合最左前缀原则,也无法使用索引

45. ACID是什么?可以详细说一下吗

    A=Atomicity   原子性：就是上面说的,要么全部成功,要么全部失败.不可能只执行一部分操作

    C=Consistency  一致性：系统(数据库)总是从一个一致性的状态转移到另一个一致性的状态,不会存在中间状态

    I=Isolation   隔离性: 通常来说:一个事务在完全提交之前,对其他事务是不可见的.注意前面的通常来说加了红色,意味着有例外情况.

    D=Durability   持久性：一旦事务提交,那么就永远是这样子了,哪怕系统崩溃也不会影响到这个事务的结果

46. 并发事务带来哪些问题

    多个事务并发运行，经常会操作相同的数据来完成各自的任务（多个用户对同一数据进行操作）。并发虽然是必须的，但可能会导致以下的问题

    1. 脏读（Dirty read）: 当一个事务正在访问数据并且对数据进行了修改，而这种修改还没有提交到数据库中，这时另外一个事务也访问了这个数据，然后使用了这个数据。因为这个数据是还没有提交的数据，那么另外一个事务读到的这个数据是“脏数据”，依据“脏数据”所做的操作可能是不正确的
    2. 丢失修改（Lost to modify）: 指在一个事务读取一个数据时，另外一个事务也访问了该数据，那么在第一个事务中修改了这个数据后，第二个事务也修改了这个数据。这样第一个事务内的修改结果就被丢失，因此称为丢失修改。 例如：事务1读取某表中的数据A=20，事务2也读取A=20，事务1修改A=A-1，事务2也修改A=A-1，最终结果A=19，事务1的修改被丢失
    3. 不可重复读（Unrepeatableread）: 指在一个事务内多次读同一数据。在这个事务还没有结束时，另一个事务也访问该数据。那么，在第一个事务中的两次读数据之间，由于第二个事务的修改导致第一个事务两次读取的数据可能不太一样。这就发生了在一个事务内两次读到的数据是不一样的情况，因此称为不可重复读
    4. 幻读（Phantom read）: 幻读与不可重复读类似。它发生在一个事务（T1）读取了几行数据，接着另一个并发事务（T2）插入了一些数据时。在随后的查询中，第一个事务（T1）就会发现多了一些原本不存在的记录，就好像发生了幻觉一样，所以称为幻读

    不可重复读和幻读区别：
    不可重复读的重点是修改比如多次读取一条记录发现其中某些列的值被修改，幻读的重点在于新增或者删除比如多次读取一条记录发现记录增多或减少了

47. MySQL的事务隔离级别

    ###### 未提交读(READ UNCOMMITTED)

    这个隔离级别下,其他事务可以看到本事务没有提交的部分修改.因此会造成脏读的问题(读取到了其他事务未提交的部分,而之后该事务进行了回滚).

    这个级别的性能没有足够大的优势,但是又有很多的问题,因此很少使用

    ###### 已提交读(READ COMMITTED)

    其他事务只能读取到本事务已经提交的部分.这个隔离级别有 不可重复读的问题,在同一个事务内的两次读取,拿到的结果竟然不一样,因为另外一个事务对数据进行了修改

    ###### REPEATABLE READ(可重复读)

    可重复读隔离级别解决了上面不可重复读的问题(看名字也知道),但是仍然有一个新问题,就是 幻读,当你读取id> 10 的数据行时,对涉及到的所有行加上了读锁,此时例外一个事务新插入了一条id=11的数据,因为是新插入的,所以不会触发上面的锁的排斥,那么进行本事务进行下一次的查询时会发现有一条id=11的数据,而上次的查询操作并没有获取到,再进行插入就会有主键冲突的问题.

    ###### SERIALIZABLE(可串行化)

    这是最高的隔离级别,可以解决上面提到的所有问题,因为他强制将所以的操作串行执行,这会导致并发性能极速下降,因此也不是很常用

    InnoDB默认使用的是可重复读隔离级别

48. Explain 性能分析

    使用 EXPLAIN 关键字可以模拟优化器执行 SQL 查询语句，从而知道 MySQL 是如何处理SQL 语句的。分析查询语句或是表结构的性能瓶颈

    - 表的读取顺序
    - 数据读取操作的操作类型
    - 哪些索引可以使用
    - 哪些索引被实际使用
    - 表之间的引用
    - 每张表有多少行被优化器查询

    

49. SQL 性能优化策略

    1. 对查询进行优化，应尽量避免全表扫描，首先应考虑在where及order by涉及的列上建立索引
    2. 

50. 分区分表

    分库分表有垂直切分和水平切分两种

    - 垂直切分 ( 按照功能模块）

      将表按照功能模块、关系密切程度划分出来，部署到不同的库上。例如，我们会建立定义数据库 workDB、商品数据库 payDB、用户数据库 userDB、日志数据库 logDB 等，分别用于存储项目数据定义表、商品定义表、用户数据表、日志数据表等

    - 水平切分  （按照规则划分存储 )

      当一个表中的数据量过大时，我们可以把该表的数据按照某种规则，例如 userID 散列，进行划分，然后存储到多个结构相同的表，和不同的库上

51. 

### 微服务

1. 微服务的优点

   1. 独立开发 
   2. 独立部署
   3. 故障隔离
   4. 混合技术堆栈
   5. 粒度缩放

2. 微服务的特点

   1. 解耦
   2. 组件化
   3. 业务能力单一
   4. 自治
   5. 持续交付
   6. 责任
   7. 分散治理
   8. 敏捷

3. 微服务架构组件

   ![image-20210708113307416](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210708113307416.png)

4. 微服务架构的优缺点

   | 优点                       | 缺点                         |
   | -------------------------- | ---------------------------- |
   | 自由使用不同技术           | 增加故障排除挑战             |
   | 每个微服务都侧重单一功能   | 由于远程呼叫而增加延迟       |
   | 支持单个可部署单元         | 增加了配置和其他操作的工作量 |
   | 允许经常发布软件           | 难以保持交易安全             |
   | 确保每项服务的安全性       | 艰难地跨越各种边界跟踪数据   |
   | 多个服务是并行开发和部署的 | 难以在服务之间进行编码       |

   

5. 大型网站架构演化发展历程

   1. 初始阶段的网站架构

      大型网站都是从小型网站发展而来，网站架构也是一样，是从小型网站架构逐步演化而来。小型网站最开始没有太多人访问，只需要一台服务器就绰绰有余，这时的网站架应用程序、数据库、文件等所有资源都在一台服务器上

   2. 应用服务和数据服务分离

      随着网站业务的发展，一台服务器逐渐不能满足需求：越来越多的用户访问导致性能越来越差，越来越多的数据导致存储空间不足。这时就需要将应用和数据分离。应用和数据分离后整个网站使用3台服务器：应用服务器、文件服务器和数据库服务器。这 3 台服务器对硬件资源的要求各不相同

      - 应用服务器需要处理大量的业务逻辑，因此需要更快更强大的CPU；
      - 数据库服务器需要快速磁盘检索和数据缓存，因此需要更快的磁盘和更大的内存；
      - 文件服务器需要存储大量用户上传的文件，因此需要更大的硬盘

      ![image-20210810201644938](https://gitee.com/Sean0516/image/raw/master/img/image-20210810201644938.png)

      应用和数据分离后，不同特性的服务器承担不同的服务角色，网站的并发处理能力和数据存储空间得到了很大改善，支持网站业务进一步发展。但是随着用户逐渐增多，网站又一次面临挑战：数据库压力太大导致访问延迟，进而影响整个网站的性能，用户体验受到影响。这时需要对网站架构进一步优化

   3. 使用缓存改善网站性能

      网站访问的特点和现实世界的财富分配一样遵循二八定律：80% 的业务访问集中在20% 的数据上。既然大部分业务访问集中在一小部分数据上，那么如果把这一小部分数据缓存在内存中，就可以减少数据库的访问压力，提高整个网站的数据访问速度，改善数据库的写入性能了。 网站使用的缓存可以分为两种：缓存在应用服务器上的本地缓存和缓存在专门的分布式缓存服务器上的远程缓存

      - ​	本地缓存的访问速度更快一些，但是受应用服务器内存限制，其缓存数据量有限，而且会出现和应用程序争用内存的情况
      - 远程分布式缓存可以使用集群的方式，部署大内存的服务器作为专门的缓存服务器，可以在理论上做到不受内存容量限制的缓存服务

      ![image-20210810201937777](https://gitee.com/Sean0516/image/raw/master/img/image-20210810201937777.png)

      使用缓存后，数据访问压力得到有效缓解，但是单一应用服务器能够处理的请求连接有限，在网站访问高峰期，应用服务器成为整个网站的瓶颈

   4. 使用应用服务器集群改善网站的并发处理能力

      使用集群是网站解决高并发、海量数据问题的常用手段。当一台服务器的处理能力、存储空间不足时，不要企图去更换更强大的服务器，对大型网站而言，不管多么强大的服务器，都满足不了网站持续增长的业务需求。这种情况下，更恰当的做法是增加一台服务器分担原有服务器的访问及存储压力。 对网站架构而言，只要能通过增加一台服务器的方式改善负载压力，就可以以同样的方式持续增加服务器不断改善系统性能，从而实现系统的可伸缩性。应用服务器实现集群是网站可伸缩架构设计中较为简单成熟的一种

      ![image-20210810202159828](https://gitee.com/Sean0516/image/raw/master/img/image-20210810202159828.png)

      通过负载均衡调度服务器，可以将来自用户浏览器的访问请求分发到应用服务器集群中的任何一台服务器上，如果有更多用户，就在集群中加入更多的应用服务器，使应用服务器的压力不再成为整个网站的瓶颈

   5. 数据库读写分离

      网站在使用缓存后，使对大部分数据读操作访问都可以不通过数据库就能完成，但是仍有一部分读操作（缓存访问不命中、缓存过期）和全部的写操作都需要访问数据库，在网站的用户达到一定规模后，数据库因为负载压力过高而成为网站的瓶颈。 目前大部分的主流数据库都提供主从热备功能，通过配置两台数据库主从关系，可以将一台数据库服务器的数据更新同步到另一台服务器上。网站利用数据库的这一功能，实现数据库读写分离，从而改善数据库负载压力。如下图所示

      ![image-20210810202247655](https://gitee.com/Sean0516/image/raw/master/img/image-20210810202247655.png)

      应用服务器在写数据的时候，访问主数据库，主数据库通过主从复制机制将数据更新同步到从数据库，这样当应用服务器读数据的时候，就可以通过从数据库获得数据。为了便于应用程序访问读写分离后的数据库，通常在应用服务器端使用专门的数据访问模块，使数据库读写分离对应用透明

   6. 使用反向代理和 CDN 加速网站响应

      随着网站业务不断发展，用户规模越来越大，由于中国复杂的网络环境，不同地区的用户访问网站时，速度差别也极大。有研究表明，网站访问延迟和用户流失率正相关，网站访问越慢，用户越容易失去耐心而离开。为了提供更好的用户体验，留住用户，网站需要加速网站访问速度。主要手段有使用 CDN 和方向代理。如下图所示

      ![image-20210810202342984](https://gitee.com/Sean0516/image/raw/master/img/image-20210810202342984.png)

      CDN 和反向代理的基本原理都是缓存

      CDN 部署在网络提供商的机房，使用户在请求网站服务时，可以从距离自己最近的网络提供商机房获取数据
      反向代理则部署在网站的中心机房，当用户请求到达中心机房后，首先访问的服务器是反向代理服务器，如果反向代理服务器中缓存着用户请求的资源，就将其直接返回给用户

      使用 CDN 和反向代理的目的都是尽早返回数据给用户，一方面加快用户访问速度，另一方面也减轻后端服务器的负载压力

   7. 使用分布式文件系统和分布式数据库系统

      任何强大的单一服务器都满足不了大型网站持续增长的业务需求。数据库经过读写分离后，从一台服务器拆分成两台服务器，但是随着网站业务的发展依然不能满足需求，这时需要使用分布式数据库。文件系统也一样，需要使用分布式文件系统。如下图所示

      ![image-20210810202435081](https://gitee.com/Sean0516/image/raw/master/img/image-20210810202435081.png)

      分布式数据库是网站数据库拆分的最后手段，只有在单表数据规模非常庞大的时候才使用。不到不得已时，网站更常用的数据库拆分手段是业务分库，将不同业务的数据部署在不同的物理服务器上

   8. 使用 NoSQL 和搜索引擎

      随着网站业务越来越复杂，对数据存储和检索的需求也越来越复杂，网站需要采用一些非关系数据库技术如NoSQL 和非数据库查询技术如搜索引擎。如下图所示

      ![image-20210810202510779](https://gitee.com/Sean0516/image/raw/master/img/image-20210810202510779.png)

      NoSQL 和搜索引擎都是源自互联网的技术手段，对可伸缩的分布式特性具有更好的支持。应用服务器则通过一个统一数据访问模块访问各种数据，减轻应用程序管理诸多数据源的麻烦

   9. 分布式微服务

      随着业务拆分越来越小，存储系统越来越庞大，应用系统的整体复杂度呈指数级增加，部署维护越来越困难。由于所有应用要和所有数据库系统连接，在数万台服务器规模的网站中，这些连接的数目是服务器规模的平方，导致数据库连接资源不足，拒绝服务

      既然每一个应用系统都需要执行许多相同的业务操作，比如用户管理、商品管理等，那么可以将这些共用的业务提取出来，独立部署。由这些可复用的业务连接数据库，提供共用业务服务，而应用系统只需要管理用户界面，通过分布式服务调用共用业务服务完成具体业务操作。如下图所示

      ![image-20210810202601384](https://gitee.com/Sean0516/image/raw/master/img/image-20210810202601384.png)

6. CAP三进二和Base定理

   ##### CAP三进二

   在分布式系统中，讲究C:Consistency（强一致性）、A:Availability（可用性）、P:Partition tolerance（分区容错性）

   CAP的证明基于异步网络，异步网络也是反映了真实网络中情况的模型。真实的网络系统中，节点之间不可能保持同步，即便是时钟也不可能保持同步，所有的节点依靠获得的消息来进行本地计算和通讯。这个概念其实是相当强的，意味着任何超时判断也是不可能的，因为没有共同的时间标准。之后我们会扩展CAP的证明到弱一点的异步网
   络中，这个网络中时钟不完全一致，但是时钟运行的步调是一致的，这种系统是允许节点做超时判断的

   CAP理论的核心是：一个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求， 最多只能同时较好的满足两个。 因此，根据 CAP 原理将 NoSQL 数据库分成了满足 CA 原则、满足 CP 原则和满足 AP 原则三大类：

   - CA - 单点集群，满足一致性，可用性的系统，通常在可扩展性上不太强大。
   - CP - 满足一致性，分区容忍必的系统，通常性能不是特别高
   - AP - 满足可用性，分区容忍性的系统，通常可能对一致性要求低一些

   ##### BASE定理

   BASE就是为了解决关系数据库强一致性引起的问题而引起的可用性降低而提出的解决方案

   BASE其实是下面三个术语的缩写

   - 基本可用（Basically Available）
   - 软状态（Soft state）
   - 最终一致（Eventually consistent）

   它的思想是通过让系统放松对某一时刻数据一致性的要求来换取系统整体伸缩性和性能上改观。为什么这么说呢，缘由就在于大型系统往往由于地域分布和极高性能的要求，不可能采用分布式事务来完成这些指标，要想获得这些指标，我们必须采用另外一种方式来完成，这里BASE就是解决这个问题的办法

   分布式一致性理论paxos、raft、zab算法

   

7. 秒杀架构设计

   #### 业务特点

   1. 瞬时并发量大
   2. 库存少
   3. 业务简单

   #### 架构设计思想

   ![image-20210810205046847](https://gitee.com/Sean0516/image/raw/master/img/image-20210810205046847.png)

   ##### 限流

   由于活动库存量一般都是很少，对应的只有少部分用户才能秒杀成功。所以我们需要限制大部分用户流量，只准少量用户流量进入后端服务器

   ##### 削峰

   秒杀开始的那一瞬间，会有大量用户冲击进来，所以在开始时候会有一个瞬间流量峰值。如何把瞬间的流量峰值变得更平缓，是能否成功设计好秒杀系统的关键因素。实现流量削峰填谷，一般的采用缓存和 MQ 中间件来解决

   ##### 异步

   秒杀其实可以当做高并发系统来处理，在这个时候，可以考虑从业务上做兼容，将同步的业务，设计成异步处理的任务，提高网站的整体可用性

   ##### 缓存

   秒杀系统的瓶颈主要体现在下订单、扣减库存流程中。在这些流程中主要用到 OLTP 的数据库，类似 MySQL、SQLServer、Oracle。由于数据库底层采用 B+ 树的储存结构，对应我们随机写入与读取的效率，相对较低。如果我们把部分业务逻辑迁移到内存的缓存或者 Redis 中，会极大的提高并发效率

   #### 秒杀流程图

   ![image-20210810205247730](https://gitee.com/Sean0516/image/raw/master/img/image-20210810205247730.png)

   秒杀系统核心在于层层过滤，逐渐递减瞬时访问压力，减少最终对数据库的冲击。通过上面流程图就会发现压力最大的地方在哪里

   MQ 排队服务，只要 MQ 排队服务顶住，后面下订单与扣减库存的压力都是自己能控制的，根据数据库的压力，可以定制化创建订单消费者的数量，避免出现消费者数据量过多，导致数据库压力过大或者直接宕机。

   库存服务专门为秒杀的商品提供库存管理，实现提前锁定库存，避免超卖的现象。同时，通过超时处理任务发现已抢到商品，但未付款的订单，并在规定付款时间后，处理这些订单，将恢复订单商品对应的库存量

   #### 总结

   - 尽量将请求拦截在上游，降低下游的压力
   - 充分利用缓存与消息队列，提高请求处理速度以及削峰填谷的作用

8. 数据库架构发展历程

   #### 单机MySQL的美好年代

   在90年代，一个网站的访问量一般都不大，用单个数据库完全可以轻松应付。 在那个时候，更多的都是静态网页，动态交互类型的网站不多

   #### Memcached(缓存)+MySQL+垂直拆分

   ![image-20210810205446182](https://gitee.com/Sean0516/image/raw/master/img/image-20210810205446182.png)

   Memcached作为一个独立的分布式的缓存服务器，为多个web服务器提供了一个共享的高性能缓存服务，在Memcached服务器上，又发展了根据hash算法来进行多台Memcached缓存服务的扩展，然后又出现了一致性hash来解决增加或减少缓存服务器导致重新hash带来的大量缓存失效的弊端

   #### Mysql主从复制读写分离

   由于数据库的写入压力增加，Memcached只能缓解数据库的读取压力。读写集中在一个数据库上让数据库不堪重负，大部分网站开始使用主从复制技术来达到读写分离，以提高读写性能和读库的可扩展性。Mysql的master-slave模式成为这个时候的网站标配了

   ![image-20210810205528955](https://gitee.com/Sean0516/image/raw/master/img/image-20210810205528955.png)

   #### 分表分库+水平拆分+mysql集群

   在Memcached的高速缓存，MySQL的主从复制，读写分离的基础之上，这时MySQL主库的写压力开始出现瓶颈，而数据量的持续猛增，由于MyISAM使用表锁，在高并发下会出现严重的锁问题，大量的高并发MySQL应用开始使用InnoDB引擎代替MyISAM

9. 数据的水平拆分和垂直拆分

   当我们使用读写分离、缓存后，数据库的压力还是很大的时候，这就需要使用到数据库拆分了。
   数据库拆分简单来说，就是指通过某种特定的条件，按照某个维度，将我们存放在同一个数据库中的数据分散存放到多个数据库（主机）上面以达到分散单库（主机）负载的效果

   #### 垂直拆分

   一个数据库由很多表的构成，每个表对应着不同的业务，垂直切分是指按照业务将表进行分类，分布到不同的数据库上面，这样也就将数据或者说压力分担到不同的库上面

   ![image-20210812113519461](https://gitee.com/Sean0516/image/raw/master/img/image-20210812113519461.png)

   ###### 优点

   1. 拆分后业务清晰，拆分规则明确
   2. 系统之间整合或扩展容易
   3. 数据维护简单

   ###### 缺点

   1. 部分业务表无法join，只能通过接口方式解决，提高了系统复杂度
   2. 受每种业务不同的限制存在单库性能瓶颈，不易数据扩展跟性能提高
   3. 事务处理复杂

   #### 水平拆分

   垂直拆分后遇到单机瓶颈，可以使用水平拆分。相对于垂直拆分的区别是：垂直拆分是把不同的表拆到不同的数据库中，而水平拆分是把同一个表拆到不同的数据库中

   相对于垂直拆分，水平拆分不是将表的数据做分类，而是按照某个字段的某种规则来分散到多个库之中，每个表中包含一部分数据。简单来说，我们可以将数据的水平切分理解为是按照数据行的切分，就是将表中 的某些行切分到一个数据库，而另外的某些行又切分到其他的数据库中，主要有分表，分库两种模式

   ###### 优点

   1. 不存在单库大数据，高并发的性能瓶颈
   2. 对应用透明，应用端改造较少。
   3. 按照合理拆分规则拆分，join操作基本避免跨库
   4. 提高了系统的稳定性跟负载能力。

   ###### 缺点

   1. 拆分规则难以抽象
   2. 分片事务一致性难以解决
   3. 数据多次扩展难度跟维护量极大。
   4. 跨库join性能较差

10. 拆分的处理难点

    1. 引入分布式事务的问题
    2. 跨节点Join 的问题
    3. 跨节点合并排序分页问题

    针对数据源管理，目前主要有两种思路

    1. 客户端模式，在每个应用程序模块中配置管理自己需要的一个（或者多个）数据源，直接访问各个 数据库，在模块内完成数据的整合
       - 优点：相对简单，无性能损耗。
       - 缺点：不够通用，数据库连接的处理复杂，对业务不够透明，处理复杂
    2. 通过中间代理层来统一管理所有的数据源，后端数据库集群对前端应用程序透明
       - 优点：通用，对应用透明，改造少
       - 缺点：实现难度大，有二次转发性能损失

    #### 拆分原则

    1. 尽量不拆分，架构是进化而来，不是一蹴而就。(SOA)

    2. 最大可能的找到最合适的切分维度。
    3. 由于数据库中间件对数据Join 实现的优劣难以把握，而且实现高性能难度极大，业务读取 尽量少使用多表Join -尽量通过数据冗余，分组避免数据垮库多表join。
    4. 尽量避免分布式事务。
    5. 单表拆分到数据1000万以内

11. 什么是分布式事务

    分布式事务用于在分布式系统中保证不同节点之间的数据一致性。分布式事务的实现有很多种，最具有代表性的是由Oracle Tuxedo系统提出的XA分布式事务协议。
    XA协议包含两阶段提交（2PC）和三阶段提交（3PC）两种实现，这里我们重点介绍两阶段提交的具体过程

    #### XA两阶段提交（2PC）

    在XA协议中包含着两个角色：事务协调者和事务参与者。让我们来看一看他们之
    间的交互流程：

    ![image-20210810205852347](https://gitee.com/Sean0516/image/raw/master/img/image-20210810205852347.png)

    1. 在XA分布式事务的第一阶段，作为事务协调者的节点会首先向所有的参与者节点发送Prepare请求。在接到Prepare请求之后，每一个参与者节点会各自执行与事务有关的数据更新，写入Undo Log和Redo Log。如果参与者执行成功，暂时不提交事务，而是向事务协调节点返回“完成”消息。当事务协调者接到了所有参与者的返回消息，整个分布式事务将会进入第二阶段。

       ![image-20210810205909264](https://gitee.com/Sean0516/image/raw/master/img/image-20210810205909264.png)

    2. 在XA分布式事务的第二阶段，如果事务协调节点在之前所收到都是正向返回，那么它将会向所有事务参与者发出Commit请求。接到Commit请求之后，事务参与者节点会各自进行本地的事务提交，并释放锁资源。当本地事务完成提交后，将会向事务协调者返回“完成”消息。当事务协调者接收到所有事务参与者的“完成”反馈，整个分布式事务完成。

    #### XA三阶段提交（3PC）

    XA三阶段提交在两阶段提交的基础上增加了CanCommit阶段，并且引入了超时机制。一旦事物参与者迟迟没有接到协调者的commit请求，会自动进行本地commit。这样有效解决了协调者单点故障的问题。但是性能问题和不一致的问题仍然没有根本解决

    #### MQ事务

    利用消息中间件来异步完成事务的后一半更新，实现系统的最终一致性。这个方式避免了像XA协议那样的性能问题

    #### TCC事务

    TCC事务是Try、Commit、Cancel三种指令的缩写，其逻辑模式类似于XA两阶段提交，但是实现方式是在代码层面来人为实现

    ![image-20210810210058784](https://gitee.com/Sean0516/image/raw/master/img/image-20210810210058784.png)

12. BitMap

    #### Bit-map的基本思想

    32位机器上，对于一个整型数，比如int a=1 在内存中占32bit位，这是为了方便计算机的运算。但是对于某些应用场景而言，这属于一种巨大的浪费，因为我们可以用对应的32bit位对应存储十进制的0-31个数，而这就是Bit-map的基本思想。Bit-map算法利用这种思想处理大量数据的排序、查询以及去重。 Bitmap在用户群做交集和并集运算的时候也有极大的便利

    #### Bit-map扩展——Bloom Filter(布隆过滤器)

    当一个元素被加入集合中时,通过k各散列函数将这个元素映射成一个位数组中的k个点,并将这k个点全部置为1.有一定的误判率--在判断一个元素是否属于某个集合时,有可能会把不属于这个集合的元素误判为属于这个集合.因此,它不适合那些"零误判"的应用场合.在能容忍低误判的应用场景下,布隆过滤器通过极少的误判换区了存储空间的极大节省

    

    Bloom Filter使用k个相互独立的哈希函数（Hash Function），它们分别将集合中的每个元素映射到{1,…,m}的范围中。对任意一个元素x，第i个哈希函数映射的位置hi(x)就会被置为1（1≤i≤k）。注：如果一个位置多次被置为1，那么只有第一次会起作用，后面几次将没有任何效果   在判断y是否属于这个集合时，对y应用k次哈希函数，若所有hi(y)的位置都是1（1≤i≤k），就认为y是集合中的元素，否则就认为y不是集合中的元素

    #### 总结

    使用Bit-map的思想，我们可以将存储空间进行压缩，而且可以对数字进行快速排序、去重和查询的操作。Bloom Fliter是Bit-map思想的一种扩展，它可以在允许低错误率的场景下，大大地进行空间压缩，是一种拿错误率换取空间的数据结构

    

13. 常见的限流算法

    ### 计数器法

    计数器法是限流算法里最简单也是最容易实现的一种算法。比如我们规定，对于A接口来说，我们1分钟的访问次数不能超过100个。那么我们可以这么做：在一开 始的时候，我们可以设置一个计数器counter，每当一个请求过来的时候，counter就加1，如果counter的值大于100并且该请求与第一个 请求的间隔时间还在1分钟之内，那么说
    明请求数过多；如果该请求与第一个请求的间隔时间大于1分钟，且counter的值还在限流范围内，那么就重置counter

    这个算法虽然简单，但是有一个十分致命的问题，那就是临界问题

    #### 滑动窗口

    滑动窗口，又称rolling window。为了解决这个问题，我们引入了滑动窗口算法。如果学过TCP网络协议的话，那么一定对滑动窗口这个名词不会陌生。下面这张图，很好地解释了滑动窗口算法

    ![image-20210810210930993](https://gitee.com/Sean0516/image/raw/master/img/image-20210810210930993.png)

    在上图中，整个红色的矩形框表示一个时间窗口，在我们的例子中，一个时间窗口就是一分钟。然后我们将时间窗口进行划分，比如图中，我们就将滑动窗口 划成了6格，所以每格代表的是10秒钟。每过10秒钟，我们的时间窗口就会往右滑动一格。每一个格子都有自己独立的计数器counter，比如当一个请求 在0:35秒的时候到达，那么
    0:30~0:39对应的counter就会加1

    计数器算法其实就是滑动窗口算法。只是它没有对时间窗口做进一步地划分，所以只有1格。由此可见，当滑动窗口的格子划分的越多，那么滑动窗口的滚动就越平滑，限流的统计就会越精确。

    #### 漏桶算法

    ![image-20210810211026116](https://gitee.com/Sean0516/image/raw/master/img/image-20210810211026116.png)

    从图中我们可以看到，整个算法其实十分简单。首先，我们有一个固定容量的桶，有水流进来，也有水流出去。对于流进来的水来说，我们无法预计一共有多 少水会流进来，也无法预计水流的速度。但是对于流出去的水来说，这个桶可以固定水流出的速率。而且，当桶满了之后，多余的水将会溢出。我们将算法中的水换成实际应用中的请求，我们可以看到漏桶算法天生就限制了请求的速度。当使用了漏桶算法，我们可以保证接口会以一个常速速率来处理请求。所以漏桶算法天生不会出现临界问题

    #### 令牌桶算法

    ![image-20210810211114037](https://gitee.com/Sean0516/image/raw/master/img/image-20210810211114037.png)

    从图中我们可以看到，令牌桶算法比漏桶算法稍显复杂。首先，我们有一个固定容量的桶，桶里存放着令牌（token）。桶一开始是空的，token以 一个固定的速率r往桶里填充，直到达到桶的容量，多余的令牌将会被丢弃。每当一个请求过来时，就会尝试从桶里移除一个令牌，如果没有令牌的话，请求无法通 过

    #### 计数器 VS 滑动窗口

    计数器算法是最简单的算法，可以看成是滑动窗口的低精度实现。滑动窗口由于需要存储多份的计数器（每一个格子存一份），所以滑动窗口在实现上需要更多的存储空间。也就是说，如果滑动窗口的精度越高，需要的存储空间就越大。

    #### 漏桶算法 VS 令牌桶算法

    漏桶算法和令牌桶算法最明显的区别是令牌桶算法允许流量一定程度的突发。因为默认的令牌桶算法，取走token是不需要耗费时间的，也就是说，假设桶内有100个token时，那么可以瞬间允许100个请求通过

    令牌桶算法由于实现简单，且允许某些流量的突发，对用户友好，所以被业界采用地较多。当然我们需要具体情况具体分析，只有最合适的算法，没有最优的算法

14. Top k 问题 （海量数据中找出出现频率最好的前k个数）

    针对top K类问题，通常比较好的方案是分治+Trie树/hash+小顶堆（就是上面提到的最小堆），即先将数据集按照Hash方法分解成多个小数据集，然后使用Trie树活着Hash统计每个小数据集中的query词频，之后用小顶堆求出每个数据集中出现频率最高的前K个数，最后在所有top K中求出最终的top K

    ###### 有1亿个浮点数，如果找出期中最大的10000个

    1. 数据全部排序

       最容易想到的方法是将数据全部排序，然后在排序后的集合中进行查找，最快的排序算法的时间复杂度一般为O（nlogn），如快速排序。但是在32位的机器上，每个float类型占4个字节，1亿个浮点数就要占用400MB的存储空间，对于一些可用内存小于400M的计算机而言，很显然是不能一次将全部数据读入内存进行排序的。其实即使内存能够满足要求（我机器内存都是8GB），该方法也并不高效，因为题目的目的是寻找出最大的10000个数即可，而排序却是将所有的元素都排序了，做了很多的无用功

    2. 局部淘汰法

       第二种方法为局部淘汰法，该方法与排序方法类似，用一个容器保存前10000个数，然后将剩余的所有数字——与容器内的最小数字相比，如果所有后续的元素都比容器内的10000个数还小，那么容器内这个10000个数就是最大10000个数。如果某一后续元素比容器内最小数字大，则删掉容器内最小元素，并将该元素插入容器，最后遍历完这1亿个数，得到的结果容器中保存的数即为最终结果了。此时的时间复杂度为O（n+m^2），其中m为容器的大
       小，即10000

    3. 分治法

       第三种方法是分治法，将1亿个数据分成100份，每份100万个数据，找到每份数据中最大的10000个，最后在剩下的10010000个数据里面找出最大的10000个。如果100万数据选择足够理想，那么可以过滤掉1亿数据里面99%的数据。100万个数据里面查找最大的10000个数据的方法如下：用快速排序的方法，将数据分为2堆，如果大的那堆个数N大于10000个，继续对大堆快速排序一次分成2堆，如果大的那堆个数N大于10000个，继续对大堆快速排序一次分成2堆，如果大堆个数N小于10000个，就在小的那堆里面快速排序一次，找第10000-n大的数字；递归以上过程，就可以找到第1w大的数。参考上面的找出第1w大数字，就可以类似的方法找到前10000大数字了。此种方法需要每次的内存空间为10^64=4MB，一共需要101次这样的比较

    4. Hash法

       第四种方法是Hash法。如果这1亿个书里面有很多重复的数，先通过Hash法，把这1亿个数字去重复，这样如果重复率很高的话，会减少很大的内存用量，从而缩小运算空间，然后通过分治法或最小堆法查找最大的10000个数

    5. 最小堆

       首先读入前10000个数来创建大小为10000的最小堆，建堆的时间复杂度为O（mlogm）（m为数组的大小即为10000），然后遍历后续的数字，并于堆顶（最小）数字进行比较。如果比最小的数小，则继续读取后续数字；如果比堆顶数字大，则替换堆顶元素并重新调整堆为最小堆。整个过程直至1亿个数全部遍历完为止。然后按照中序遍历的方式输出当前堆中的所有10000个数字。该算法的时间复杂度为O（nmlogm），空间复杂度是10000（常数）

15. Jenkins 

    ![image-20210812164657035](https://gitee.com/Sean0516/image/raw/master/img/image-20210812164657035.png)

    

16. 分布式环境下全局唯一的发号器

    1. UUID  

       常见的方式。可以利用数据库也可以利用程序生成，一般来说全球唯一

       ###### 优点

       1. 简单，代码方便
       2. 生成ID性能非常好，基本不会有性能问题
       3. 全球唯一，在遇见数据迁移，系统数据合并，或者数据库变更等情况下，可以从容应对

       ###### 缺点

       1. 没有排序，无法保证趋势递增
       2. UUID往往是使用字符串存储，查询的效率比较低
       3. 存储空间比较大，如果是海量数据库，就需要考虑存储量的问题
       4. 传输数据量大
       5. 不可读

    2. 数据库自增ID 或字段

       最常见的方式。利用数据库，全数据库唯一

       ###### 优点

       1. 简单，代码方便，性能可以接受。
       2. 数字ID天然排序，对分页或者需要排序的结果很有帮助。

       ###### 缺点

       1. 不同数据库语法和实现不同，数据库迁移的时候或多数据库版本支持的时候需要处理
       2. 在单个数据库或读写分离或一主多从的情况下，只有一个主库可以生成。有单点故障的风险。
       3. 在性能达不到要求的情况下，比较难于扩展
       4. 如果遇见多个系统需要合并或者涉及到数据迁移会相当痛苦。
       5.  分表分库的时候会有麻烦

       ###### 优化方案

       针对主库单点，如果有多个Master库，则每个Master库设置的起始数字不一样，步长一样，可以是Master的个数。比如：Master1 生成的是 1，4，7，10，Master2生成的是2,5,8,11 Master3生成的是 3,6,9,12。这样就可以有效生成集群中的唯一ID，也可以大大降低ID生成数据库操作的负载

    3. Redis生成ID

       当使用数据库来生成ID性能不够要求的时候，我们可以尝试使用Redis来生成ID。这主要依赖于Redis是单线程的，所以也可以用生成全局唯一的ID。可以用Redis的原子操作 INCR和INCRBY来实现

       可以使用Redis集群来获取更高的吞吐量。假如一个集群中有5台Redis。可以初始化每台Redis的值分别是1,2,3,4,5，然后步长都是5。各个Redis生成的ID为

       另外，比较适合使用Redis来生成每天从0开始的流水号。比如订单号=日期+当日自增长号。可以每天在Redis中生成一个Key，使用INCR进行累加

       ###### 优点

       1. 不依赖于数据库，灵活方便，且性能优于数据库
       2.  数字ID天然排序，对分页或者需要排序的结果很有帮助

       ###### 缺点

       1. 如果系统中没有Redis，还需要引入新的组件，增加系统复杂度
       2. 需要编码和配置的工作量比较大。

    4. Twitter的snowflake算法

       snowflake 是 twitter 开源的分布式ID生成算法，其核心思想为，一个long型的ID

       1. 41 bit 作为毫秒数 - 41位的长度可以使用69年
       2. 10 bit 作为机器编号 （5个bit是数据中心，5个bit的机器ID） - 10位的长度最多支持部署1024个节点
       3. 12 bit 作为毫秒内序列号 - 12位的计数顺序号支持每个节点每毫秒产生4096个ID序号

       ![image-20210812171442228](https://gitee.com/Sean0516/image/raw/master/img/image-20210812171442228.png)

       算法单机每秒内理论上最多可以生成1000*(2^12)，也就是400W的ID，完全能满足业务的需求

        snowflake算法可以根据自身项目的需要进行一定的修改。比如估算未来的数据中心个数，每个数据中心的机器数以及统一毫秒可以能的并发数来调整在算法中所需要的bit数

       ###### 优点

       1. 不依赖于数据库，灵活方便，且性能优于数据库
       2. ID按照时间在单机上是递增的

       ###### 缺点

       1. 在单机上是递增的，但是由于涉及到分布式环境，每台机器上的时钟不可能完全同步，也许有时候也会出现不是全局递增的情况

       

17. 带有过期时间的LRU缓存

    LRU，全称Least Recently Used，最近最少使用缓存

    ###### LRU算法的设计原则

    如果一个数据在最近一段时间没有被访问到，那么在将来它被访问的可能性也很小 也就是说，当限定的空间已存满数据时，应当把最久没有被访问到的数据淘汰

    ###### 实现：

    利用链表和HashMap。当需要插入新数据项，在链表中命中，则把该节点移到链表头部 不存在，则新建一个节点，放在链表头部，若缓存满，则把链表最后一个节点删除即可。 在访问数据时，若数据项在链表中存在，则把该节点移到链表头部，否则返回-1 这样一来在链表尾部的节点就是最近最久未访问的数据项

    ###### set(key,value)

    若key在hashmap中存在，则先重置value，然后获取对应节点cur，将其从链表删除，并移到链表头 不存在，则新建一个节点，并将节点放到链表的头部。 当Cache满，删除链表最后一个节点

    ###### get(key)

    若key在hashmap中存在，把对应的节点放到链表头，并返回对应value 若不存在，则返回-1 即保证基本的get/set同时，还要保证最近访问(get或put)的节点保持在限定容量的Cache中，如果超过容量则应该把LRU(近期最少使用)的节点删除掉

18. 

### Linux  相关

1. 查看日志

   ###### tail 

   命令格式: tail  参数 文件
   -f 循环读取
   -q 不显示处理信息

   0-v 显示详细的处理信息
   -c<数目> 显示的字节数
   -n<行数> 显示行数
   -q, --quiet, --silent 从不输出给出文件名的首部
   -s, --sleep-interval=S 与-f合用,表示在每次反复的间隔休眠S秒

   ###### head 跟tail是相反的head是看前多少行日志

   ###### cat

   cat 是由第一行到最后一行连续显示在屏幕上

   ###### more

   more命令是一个基于vi编辑器文本过滤器，它以全屏幕的方式按页显示文本文件的内容，支持vi中的关键字定位操作。more名单中内置了若干快捷键，常用的有H（获得帮助信息），Enter（向下翻滚一行），空格（向下滚动一屏），Q（退出命令）。more命令从前向后读取文件，因此在启动时就加载整个文件。该命令一次显示一屏文本，满屏后停下来，并且在屏幕的底部出现一个提示信息，给出至今己显示的该文件的百分比：–More–（XX%）

   Enter 向下n行，需要定义，默认为1行
   Ctrl f 向下滚动一屏
   空格键 向下滚动一屏
   Ctrl b 返回上一屏
   = 输出当前行的行号
   :f 输出文件名和当前行的行号
   v 调用vi编辑器
   !命令 调用Shell，并执行命令
   q退出more

   ###### sed

   这个命令可以查找日志文件特定的一段 , 根据时间的一个范围查询，可以按照行号和时间范围查询按照行号

1. Linux 中进程有哪几种状态？
   1. 不可中断状态：进程处于睡眠状态，但是此刻进程是不可中断的。不可中断，指进程不响应异步信号。
   2. 暂停状态/跟踪状态：向进程发送一个 SIGSTOP 信号，它就会因响应该信号 而进入 TASK_STOPPED 状态;当进程正在被跟踪时，它处于 TASK_TRACED 这个特殊的状态。正被跟踪”指的是进程暂停下来，等待跟踪它的进程对它进行操作。
   3. 就绪状态：在 run_queue 队列里的状态
   4. 运行状态：在 run_queue 队列里的状态
   5. 可中断睡眠状态：处于这个状态的进程因为等待某某事件的发生（比如等待socket 连接、等待信号量），而被挂起
   6. zombie 状态（僵尸）：父亲没有通过 wait 系列的系统调用会顺便将子进程的尸体（task_struct）也释放掉
   7. 退出状态

2. 在 ps 显示出来的信息中分别用什么符号表示的

   D 不可中断 Uninterruptible（usually IO）
   R 正在运行，或在队列中的进程
   S 处于休眠状态
   T 停止或被追踪
   Z 僵尸进程
   W 进入内存交换（从内核 2.6 开始无效）
   X 死掉的进程

3. 使用什么命令查看后台任务

   job -l

4. 搜索文件用什么命令

   find <指定目录> <指定条件> <指定动作>
   whereis 加参数与文件名
   locate 只加文件名
   find 直接搜索磁盘，较慢。
   find / -name "string*"

5. 查看磁盘使用空间

   df -hl

6. du 和 df 的定义，以及区别

   du 显示目录或文件的大小
   df 显示每个<文件>所在的文件系统的信息，默认是显示所有文件系统。（文件系统分配其中的一些磁盘块用来记录它自身的一些数据，如 i 节点，磁盘分布图，间接块，超级块等。这些数据对大多数用户级的程序来说是不可见的，通常称为 Meta Data。） du 命令是用户级的程序，它不考虑 Meta Data，而 df命令则查看文件系统的磁盘分配图并考虑Meta Data。
   df 命令获得真正的文件系统数据，而 du 命令只查看文件系统的部分情况

7. 给命令绑定一个宏或者按键的时候，应该怎么做呢

   可以使用 bind 命令，bind 可以很方便地在 shell 中实现宏或按键的绑定。
   在进行按键绑定的时候，我们需要先获取到绑定按键对应的字符序列。
   比如获取 F12 的字符序列获取方法如下：先按下 Ctrl+V,然后按下 F12 .我们就可
   以得到 F12 的字符序列 ^[[24~。
   接着使用 bind 进行绑定

8. 你的系统目前有许多正在运行的任务，在不重启机器的条件下，有什么方法可以把所有正在运行的进程移除呢

   使用 linux 命令 ’disown -r ’可以将所有正在运行的进程移除

9. bash shell 中的 hash 命令有什么作用

   linux 命令’hash’管理着一个内置的哈希表，记录了已执行过的命令的完整路径,用该命令可以打印出你所使用过的命令以及执行的次数

10. 怎样一页一页地查看一个大文件的内容呢

    通过管道将命令”cat file_name.txt” 和 ’more’ 连接在一起可以实现这个需要 

    cat file_name.txt | more

11. 怎样查看一个 linux 命令的概要与用法？假设你在/bin 目录中偶然看到一个你从没见过的的命令，怎样才能知道它的作用和用法呢

    使用命令 whatis 可以先出显示出这个命令的用法简要，比如，你可以使用 whatis zcat 去查看‘zcat’的介绍以及使用简要
    
13. cd 

    ```shell
    cd / #表示进入系统根目录
    cd usr/ #表示进入当前目录下的usr目录
    cd local/ #表示进入当前目录下的local目录
    cd ./bin #表示进入当前目录下的bin目录
    cd .. #表示进入当前目录的上一级目录
    cd ../.. #表示进入当前目录的上级目录的上一级目录
    cd /usr/local/bin #进入/usr/local/bin目录
    cd ../etc #表示进入和当前目录同级的etc目录 #..表示当前目录的上一级目录 ../etc表示当前目录
    上级目录下的etc目录（和当前目录同级）
    cd ~ #表示进入当前用户的根目录（cd ~ 和直接执行cd后不加目录的效果相同）
    #例如：root用户进入/root目录，bow用户进入/home/bow目录
    cd ~/data #表示进入当前用户根目录下的data目录 例如：root用户则进入了/root/data目录
    cd - #进入上一次的目录
    ```

    

14.  》和>>命令

    和>>:输出符号，将内容输出到文件中，>表示覆盖(会删除原文件内容) >>表示追加

15. vim  

    ##### 非编辑模式命令

    ```shell
    yy：复制光标当前行
    p：粘贴
    dd:删除光标当前行
    $:光标跳到当前行的行尾
    ^:光标跳到当前行的行首
    :s/原字符串/新字符串/:替换光标当前行内容
    :%s/原字符串/新字符串/g:全文替换 #g表示global i表示ignore忽略大小写
    /要查找的内容:从光标当前行向后查找内容
    /d #在文件中查找d字母
    ?要查找的内容：从光标当前位置向前查找内容
    ?d #查找文件中的d字母
    CTRL+F:向下翻1页
    CTRL+B:向上翻1页
    :set nu：显示文件的行号
    :set nonu: 去掉行号显示
    u:撤消
    **:set ff :显示文件的格式 #unix表示在unix上的文件 dos表示文件是windows上的文件**
    :w ：表示保存文件
    :q :表示退出vim命令
    :wq:保存并退出
    :w!:强制保存
    :q!:强制退出但不保存
    :wq!:强制保存并退出
    i:表示进入编辑模式，并且光标在当前行
    o：表示进入编辑模式，并且光标出现的当前行的下一行(新行)
    ```

    

16. 用户和权限命令

    groupadd 用户组名称 #创建一个用户组

    useradd 用户名 [-g 用户组名 -G 用户组名] #创建一个用户,-g指定用户的主用户组,-G指定用户的其他用户组

    userdel 用户名 #删除用户

    passwd 用户名 #修改用户密码

17. 了解性能命令

    who命令 #查询系统中的用户(登陆的用户)
    whoami命令 #查看系统当前用户名
    whereis命令 #查看系统安装的某个软件的路径
    whereis python #查看python的安装路径
    which 命令 #查找软件的可执行文件路径
    which python #查看python可执行文件路径

18. 压缩命令

    zip 压缩文件名 要压缩的文件路径

    ```shell
    zip 2.zip 2.txt #将2.txt压缩到2.zip中
    ```

    unzip 压缩文件路径

    ```shell
    unzip 2.zip #将2.zip压缩包解压到当前目录下
    ```

    压缩.tar包

    ```shell
    tar cvf 压缩文件名 要压缩的文件或目录
    tar cvf 2.tar 2.txt #将2.txt压缩为2.tar包
    ```

    tar xvf 压缩文件名 [-C 指定解压目录]

    ```shell
    tar xvf 2.tar #将2.tar解压到当前目录
    ```

    

19. 









### 数据结构

1. BST （二叉树）

   二叉树是每个节点最多有两个子树的树结构。它有五种基本形态：二叉树可以是空集；根可以有空的左子树或右子树；或者左、右子树皆为空

   #### 二叉树的性质

   1. 二叉树第i层上的结点数目最多为 2{i-1} (i≥1)
   2. 深度为k的二叉树至多有2{k}-1个结点(k≥1)
   3. 包含n个结点的二叉树的高度至少为log2 (n+1)
   4. 在任意一棵二叉树中，若终端结点的个数为n0，度为2的结点数为n2，则n0=n2+1

2. 二叉查找树(Binary Search Tree)，二叉搜索树

   在二叉查找树中： (01) 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值； (02) 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值； (03) 任意节点的左、右子树也分别为二叉查找树。 (04) 没有键值相等的节点（no duplicate nodes

3. 平衡的二叉搜索树 （AVL）

   左子树和右子树的高度之差的绝对值不超过1树中的每个左子树和右子树都是AVL树每个节点都有一个平衡因子(balance factor--bf),任一节点的平衡因子是-1,0,1之一(每个节点的平衡因子bf 等于右子树的高度减去左子树的高度 )

   当插入或者删除节点之后，若AVL树的条件被破坏，则需要进行旋转操作来调整数据的结构以恢复AVL条件旋转至少涉及三层节点，所以至少要向上回溯一层 ，才会发现非法的平衡因子并进行旋转向上回溯校验时，需要进行旋转的几种情况

   1. 当前节点的父节点的平衡因子等于2时，说明父节点的右树比左树高：这时如果当前节点的平衡因子等于1，那么当前节点的右树比左树高，形如“ \ ”，需要进行左旋；如果当前节点的平衡因子等于-1，那么当前节点的右树比左树低，形如“ > ”，需要进行右左双旋
   2. 当前节点的父节点的平衡因子等于-2时，说明父节点的右树比左树低：这时如果当前节点的平衡因子等于-1，那么当前节点的右树比左树低，形如“ / ”,需要进行右旋；如果当前节点的平衡因子等于1，那么当前节点的右树比左树高，形如“ < ”,需要进行左右双旋

4. 红黑树

   红黑树（Red Black Tree） 是一种自平衡二叉查找树，满足以下条件

   1. 节点是红色或黑色
   2. 根节点是黑色
   3. 每个叶子节点都是黑色的空节点（NIL节点）
   4. 每个红色节点的两个子节点都是黑色。(从每个叶子到根的所有路径上不能有两个连续的红色节点)
   5. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点

   这些特性使得红黑树中从根节点到叶子节点的最长路径不会超过最短路径的两倍

   红黑树通过变色、左旋和右旋来保持平衡，任何不平衡都会在三次旋转之内解决

   首先红黑树是不符合AVL树的平衡条件的，即每个节点的左子树和右子树的高度最多差1的二叉查找树。但是提出了为节点增加颜色，红黑是用非严格的平衡来换取增删节点时候旋转次数的降低，任何不平衡都会在三次旋转之内解决，而AVL是严格平衡树，因此在增加或者删除节点的时候，根据不同情况，旋转的次数比红黑树要多。所以红黑树的插入效率更高

5. B-树

   ###### B-树就是B树，千万不要读B减树！！！！

   从算法逻辑上来讲，二叉查找树的查找次数和比较次数都是最小的。但是，我们不得不考虑一个现实的问题：磁盘IO

   数据库索引是存储在磁盘上的，当数据量比较大的时候，索引的大小可能有几个G甚至更多当我们利用索引查询的时候，能把整个索引文件全部加载到内存吗？显然不可能，能做的只有逐一加载每一个磁盘页，这里的磁盘页对应着索引树的节点

   在使用二叉查找树查询过程中，我们发现在最坏的情况下，磁盘IO次数等于索引树的高度
   因此，为了减少磁盘IO次数，我们就需要把原本“瘦高”的树结构变得“矮胖”些。这就是B-树的特征之一

   B树是一种多路平衡查找树，它的每一个节点最多包含K个孩子，K被称为B树的阶，K的大小取决于磁盘页的大小

   一个m阶的B树具有如下几个特征：

   1. 根结点至少有两个子女
   2. 每个中间节点都包含k-1个元素和k个孩子，其中 m/2 <= k <= m
   3. 每一个叶子节点都包含k-1个元素，其中 m/2 <= k <= m
   4. 所有的叶子结点都位于同一层
   5. 每个节点中的元素从小到大排列，节点当中k-1个元素正好是k个孩子包含的元素的值域分划

   ![image-20210812153725247](https://gitee.com/Sean0516/image/raw/master/img/image-20210812153725247.png)

   

6. B+树

   B+树是基于B-树的一种变体，有着比B-树更高的查询性能

   ![image-20210812153920514](https://gitee.com/Sean0516/image/raw/master/img/image-20210812153920514.png)

   一个m阶的B+树具有如下几个特征：

   1. 有k个子树的中间节点包含有k个元素（B树中是k-1个元素），每个元素不保存数据，只用来索引，所有数据都保存在叶子节点
   2. 所有的叶子结点中包含了全部元素的信息，及指向含这些元素记录的指针，且叶子结点本身依关键字的大小自小而大顺序链接
   3. 所有的中间节点元素都同时存在于子节点，在子节点元素中是最大（或最小）元素

   ###### B+树的优势

   1. 单一节点存储更多的元素，使得查询的IO次数更少
   2. 所有查询都要查找到叶子节点，查询性能稳定
   3. 所有叶子节点形成有序链表，便于范围查询

7. 字典树

   称单词查找树，Trie树，是一种树形结构，是一种哈希树的变形。典型应用是用于统计，排序和保存大量的字符串，所以经常被搜索引擎系统用于文本词频统计。它的优点是利用最大公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希表高

   ###### 性质

   1. 根节点不包含字符，除根节点以外的每一个节点都只包含一个字符
   2. 从根节点到某一节点，路径上经过的字符串连接起来，为该节点对应的字符串
   3. 每个节点的所有子节点包含的字符都不相同

   ###### 实现方法

   搜索字典项目的方法：

   1. 从根节点开始一次搜索
   2. 取得要查找关键词的第一个字母，并根据该字母选择对应的子树继续进行检索
   3. 在相应的子树上，取得要查找关键词的第二个字母，并进一步选择对应的子树进行检索
   4. 在某个结点处，关键词的所在字母已被取出，则读取附在该结点上的信息，即完成查找

8. 

### 算法题

### Elastic Search

1. es 的集群架构，索引数据大小，分片有多少，以及一些调优手段 

   - 设计阶段调优

     1. 根据业务增量需求，采取基于日期模板创建索引，通过 roll over API 滚动索引；
     2. 使用别名进行索引管理；
     3. 每天凌晨定时对索引做 force_merge 操作，以释放空间；
     4. 采取冷热分离机制，热数据存储到 SSD，提高检索效率；冷数据定期进行shrink操作，以缩减存储；
     5. 采取 curator 进行索引的生命周期管理；
     6. 仅针对需要分词的字段，合理的设置分词器；
     7. Mapping 阶段充分结合各个字段的属性，是否需要检索、是否需要存储等。

   - 写入调优

     1. 写入前副本数设置为 0；
     2. 写入前关闭 refresh_interval 设置为-1，禁用刷新机制；
     3. 写入过程中：采取 bulk 批量写入；
     4. 写入后恢复副本数和刷新间隔；
     5. 尽量使用自动生成的 id

   - 查询调优

     1. 禁用 wildcard；
     2. 禁用批量 terms（成百上千的场景）；
     3. 充分利用倒排索引机制，能 keyword 类型尽量 keyword；
     4. 数据量大时候，可以先基于时间敲定索引再检索；
     5. 设置合理的路由机制

   - 其他调优

     部署调优，业务调优等

   

3. elasticsearch 索引数据多了怎么办，如何调优，部署

   索引数据的规划，应在前期做好规划，正所谓“设计先行，编码在后”，这样才能有效的避免突如其来的数据激增导致集群处理能力不足引发的线上客户检索或者其他业务受
   到影响

   - 动态索引层面

     基于模板+时间+rollover api 滚动创建索引，举例：设计阶段定义：blog 索引的模板格式为：blog_index_时间戳的形式，每天递增数据。
     这样做的好处：不至于数据量激增导致单个索引数据量非常大，接近于上线 2 的32 次幂-1，索引存储达到了 TB+甚至更大。
     一旦单个索引很大，存储等各种风险也随之而来，所以要提前考虑+及早避免

   - 存储层面

     冷热数据分离存储，热数据（比如最近 3 天或者一周的数据），其余为冷数据。对于冷数据不会再写入新数据，可以考虑定期 force_merge 加 shrink 压缩操作，节省存储空间和检索效率。

   - 部署层面

     一旦之前没有规划，这里就属于应急策略。结合 ES 自身的支持动态扩展的特点，动态新增机器的方式可以缓解集群压力，注意：如果之前主节点等规划合理，不需要重启集群也能完成动态新增的

4. elasticsearch 是如何实现 master 选举的

   1. Elasticsearch 的选主是 ZenDiscovery 模块负责的，主要包含 Ping（节点之间通过这个 RPC 来发现彼此）和 Unicast（单播模块包含一个主机列表以控制哪些节点需要 ping
      通）这两部分；
   2. 对所有可以成为 master 的节点（node.master: true）根据 nodeId 字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第 0 位）节点，暂且认为它是 master 节点。
   3. 如果对某个节点的投票数达到一定的值（可以成为 master 节点数 n/2+1）并且该节点自己也选举自己，那这个节点就是 master。否则重新选举一直到满足上述条件。
   4. 补充：master 节点的职责主要包括集群、节点和索引的管理，不负责文档级别的管理；data 节点可以关闭 http 功能

4. Master 节点和 候选 Master节点有什么区别

   主节点负责集群相关的操作，例如创建或删除索引，跟踪哪些节点是集群的一部分，以及决定将哪些分片分配给哪些节点

   拥有稳定的主节点是衡量集群健康的重要标志

   而候选主节点是被选具备候选资格，可以被选为主节点的那些节点

7. 详细描述一下 Elasticsearch 搜索的过程

   搜索拆解为“query then fetch” 两个阶段。
   query 阶段的目的：定位到位置，但不取

   fetch 阶段的目的：取数据。
   路由节点获取所有文档，返回给客户端。

   1. 在初始查询阶段时，查询会广播到索引中每一个分片拷贝（主分片或者副本分片）。 每个分片在本地执行搜索并构建一个匹配文档的大小为 from + size 的优先队列。PS：在搜索的时候是会查询 Filesystem Cache 的，但是有部分数据还在 MemoryBuffer，所以搜索是近实时的。
   2. 每个分片返回各自优先队列中 所有文档的 ID 和排序值 给协调节点，它合并这些值到自己的优先队列中来产生一个全局排序后的结果列表。
   3. 接下来就是 取回阶段，协调节点辨别出哪些文档需要被取回并向相关的分片提交多个 GET 请求。每个分片加载并 丰富 文档，如果有需要的话，接着返回文档给协调节点。一旦所有的文档都被取回了，协调节点返回结果给客户端。
   4. 补充：Query Then Fetch 的搜索类型在文档相关性打分的时候参考的是本分片的数据，这样在文档数量较少的时候可能不够准确，DFS Query Then Fetch 增加了一个预查询的处理，询问 Term 和 Document frequency，这个评分更准确，但是性能会变差

8. Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法

   1. 关闭缓存 swap;
   2. 堆内存设置为：Min（节点内存/2, 32GB）;
   3. 设置最大文件句柄数；
   4. 线程池+队列大小根据业务需要做调整；
   5. 磁盘存储 raid 方式——存储有条件使用 RAID10，增加单节点性能以及避免单节点存储故障

9. Elasticsearch 中的节点（比如共 20 个），其中的 10 个选了一个 master，另外 10 个选了另一个 master，怎么办

   1. 当集群 master 候选数量不小于 3 个时，可以通过设置最少投票通过数量（discovery.zen.minimum_master_nodes）超过所有候选节点一半以上来解决脑裂问题；
   2. 当候选数量为两个时，只能修改为唯一的一个 master 候选，其他作为 data节点，避免脑裂问题

8. 详细描述一下 Elasticsearch 索引文档的过程

      1. 当分片所在的节点接收到来自协调节点的请求后，会将请求写入到 Memory Buffer，然后定时（默认是每隔 1 秒）写入到 Filesystem Cache，这个从 MomeryBuffer 到Filesystem Cache 的过程就叫做 refresh；
      2. 当然在某些情况下，存在 Momery Buffer 和 Filesystem Cache 的数据可能会丢失，ES 是通过 translog 的机制来保证数据的可靠性的。其实现机制是接收到请求后，同时也
         会写入到 translog 中，当 Filesystem cache 中的数据写入到磁盘中时，才会清除掉，这个过程叫做 flush；
      3. 在 flush 过程中，内存中的缓冲将被清除，内容被写入一个新段，段的 fsync将创建一个新的提交点，并将内容刷新到磁盘，旧的 translog 将被删除并开始一个新的translog。
      4. 、flush 触发的时机是定时触发（默认 30 分钟）或者 translog 变得太大（默认为 512M）时

11. Lucene 的 Segement

    1. Lucene 索引是由多个段组成，段本身是一个功能齐全的倒排索引。
    2. 段是不可变的，允许 Lucene 将新的文档增量地添加到索引中，而不用从头重建索引。
    3. 对于每一个搜索请求而言，索引中的所有段都会被搜索，并且每个段会消耗CPU 的时钟周、文件句柄和内存。这意味着段的数量越多，搜索性能会越低。
    4. 为了解决这个问题，Elasticsearch 会合并小段到一个较大的段，提交新的合并段到磁盘，并删除那些旧的小段

12. 详细描述一下 Elasticsearch 更新和删除文档的过程

    1. 删除和更新也都是写操作，但是 Elasticsearch 中的文档是不可变的，因此不能被删除或者改动以展示其变更；
    2. 磁盘上的每个段都有一个相应的.del 文件。当删除请求发送后，文档并没有真的被删除，而是在.del 文件中被标记为删除。该文档依然能匹配查询，但是会在结果中被过滤掉。当段合并时，在.del 文件中被标记为删除的文档将不会被写入新段。
    3. 在新的文档被创建时，Elasticsearch 会为该文档指定一个版本号，当执行更新时，旧版本的文档在.del 文件中被标记为删除，新版本的文档被索引到一个新段。旧版本的文档依然能匹配查询，但是会在结果中被过滤掉。

13. Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法

    1. 64 GB 内存的机器是非常理想的， 但是 32 GB 和 16 GB 机器也是很常见的。少于 8 GB 会适得其反。
    2. 如果你要在更快的 CPUs 和更多的核心之间选择，选择更多的核心更好。多个内核提供的额外并发远胜过稍微快一点点的时钟频率。
    3. 如果你负担得起 SSD，它将远远超出任何旋转介质。 基于 SSD 的节点，查询和索引性能都有提升。如果你负担得起，SSD 是一个好的选择。
    4. 即使数据中心们近在咫尺，也要避免集群跨越多个数据中心。绝对要避免集群跨越大的地理距离。
    5. 请确保运行你应用程序的 JVM 和服务器的 JVM 是完全一样的。 在Elasticsearch 的几个地方，使用 Java 的本地序列化。
    6. 通过设置 gateway.recover_after_nodes、gateway.expected_nodes、gateway.recover_after_time 可以在集群重启的时候避免过多的分片交换，这可能会让数据恢复从数个小时缩短为几秒钟。
    7. Elasticsearch 默认被配置为使用单播发现，以防止节点无意中加入集群。只有在同一台机器上运行的节点才会自动组成集群。最好使用单播代替组播。
    8. 不要随意修改垃圾回收器（CMS）和各个线程池的大小。
    9. 把你的内存的（少于）一半给 Lucene（但不要超过 32 GB！），通过ES_HEAP_SIZE 环境变量设置。
    10. 内存交换到磁盘对服务器性能来说是致命的。如果内存交换到磁盘上，一个100 微秒的操作可能变成 10 毫秒。 再想想那么多 10 微秒的操作时延累加起来。 不难看出swapping 对于性能是多么可怕。

    11. Lucene 使用了大量的文件。同时，Elasticsearch 在节点和 HTTP 客户端之间进行通信也使用了大量的套接字。 所有这一切都需要足够的文件描述符。你应该增加你的文件描述符，设置一个很大的值，如 64,000

14. 索引阶段性能提升方法

    1. 使用批量请求并调整其大小：每次批量数据 5–15 MB 大是个不错的起始点。
    2. 存储：使用 SSD
    3. 段和合并：Elasticsearch 默认值是 20 MB/s，对机械磁盘应该是个不错的设置。如果你用的是 SSD，可以考虑提高到 100–200 MB/s。如果你在做批量导入，完全不在意搜索，你可以彻底关掉合并限流。另外还可以增加index.translog.flush_threshold_size 设置，从默认的 512 MB 到更大一些的值，比如 1 GB，这可以在一次清空触发的时候在事务日志里积累出更大的段。
    4. 如果你的搜索结果不需要近实时的准确度，考虑把每个索引的index.refresh_interval 改到 30s。
    5. 如果你在做大批量导入，考虑通过设置 index.number_of_replicas: 0 关闭副本

15. 在并发情况下，Elasticsearch 如果保证读写一致

    1. 可以通过版本号使用乐观并发控制，以确保新版本不会被旧版本覆盖，由应用层来处理具体的冲突；
    2. 另外对于写操作，一致性级别支持 quorum/one/all，默认为 quorum，即只有当大多数分片可用时才允许写操作。但即使大多数可用，也可能存在因为网络等原因导致写入副本失败，这样该副本被认为故障，分片将会在一个不同的节点上重建。
    3. 对于读操作，可以设置 replication 为 sync(默认)，这使得操作在主分片和副本分片都完成后才会返回；如果设置 replication 为 async 时，也可以通过设置搜索请求参数_preference 为 primary 来查询主分片，确保文档是最新版本

16. 字典树

    

17. 拼写纠错是如何实现的

18. ElasticSearch中的集群、节点、索引、文档、类型是什么

    群集是一个或多个节点（服务器）的集合，它们共同保存您的整个数据，并提供跨所有节点的联合索引和搜索功能。群集由唯一名称标识，默认情况下为“elasticsearch”。此名称很重要，因为如果节点设置为按名称加入群集，则该节点只能是群集的一部分

    

    节点是属于集群一部分的单个服务器。它存储数据并参与群集索引和搜索功能

    

    索引就像关系数据库中的“数据库”。它有一个定义多种类型的映射。索引是逻辑名称空间，映射到一个或多个主分片，并且可以有零个或多个副本分片。 MySQL =>数据库 ElasticSearch =>索引

    

    文档类似于关系数据库中的一行。不同之处在于索引中的每个文档可以具有不同的结构（字段），但是
    对于通用字段应该具有相同的数据类型。 MySQL => Databases => Tables => Columns / Rows
    ElasticSearch => Indices => Types =>具有属性的文档

    

    类型是索引的逻辑类别/分区，其语义完全取决于用户

    

19. ES 写数据过程

    - 客户端选择一个 node 发送请求过去，这个 node 就是  coordinating node （协调节点）
    - coordinating node 对 document 进行路由，将请求转发给对应的 node（有 primaryshard）。[路由的算法是？]
    - 实际的 node 上的  primary shard 处理请求，然后将数据同步到  replica node 
    - coordinating node 如果发现  primary node 和所有  replica node 都搞定之后，就返回响应结果给客户端

20. ES 读数据过程

    可以通过  doc id 来查询，会根据  doc id 进行 hash，判断出来当时把  doc id 分配到了哪个shard 上面去，从那个 shard 去查询

    1. 客户端发送请求到任意一个 node，成为  coordinate node
    2. coordinate node 对  doc id 进行哈希路由，将请求转发到对应的 node，此时会使用  round-robin 随机轮询算法，在  primary shard 以及其所有 replica 中随机选择一个，让读请求负载均衡
    3. 接收请求的 node 返回 document 给  coordinate node
    4. coordinate node 返回 document 给客户端

21. ES中的倒排索引是什么

    传统的检索方式是通过文章，逐个遍历找到对应关键词的位置。

    倒排索引，是通过分词策略，形成了词和文章的映射关系表，也称倒排表，这种词典 + 映射表即为倒排索引

    

    其中词典中存储词元，倒排表中存储该词元在哪些文中出现的位置。

    有了倒排索引，就能实现 O(1) 时间复杂度的效率检索文章了，极大的提高了检索效率。

    

    倒排索引的底层实现是基于：FST（Finite State Transducer）数据结构。
    Lucene 从 4+ 版本后开始大量使用的数据结构是 FST。FST 有两个优点：

    1. 空间占用小。通过对词典中单词前缀和后缀的重复利用，压缩了存储空间；
    2. 查询速度快。O(len(str)) 的查询时间复杂度。

    

22. Elasticsearch对于大数据量（上亿量级）的聚合如何实现

    Elasticsearch 提供的首个近似聚合是cardinality 度量。它提供一个字段的基数，即该字段的distinct或者unique值的数目。它是基于HLL算法的。HLL 会先对我们的输入作哈希运算，然后根据哈希运算的结果中的 bits 做概率估算从而得到基数。其特点是：可配置的精度，用来控制内存的使用（更精确 ＝更多内存）；小的数据集精度是非常高的；我们可以通过配置参数，来设置去重需要的固定内存使用量。无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关

23. 



### Dubbo

1. Dubbo 的整体架构设计有哪些分层

   ###### 接口服务层（Service）：

   该层与业务逻辑相关，根据 provider 和 consumer 的业务设计对应的接口和实现

   ###### 配置层（Config）：

   对外配置接口，以 ServiceConfig 和 ReferenceConfig 为中心
   服务代理层（Proxy）：服务接口透明代理，生成服务的客户端 Stub 和 服务端的 Skeleton，以 ServiceProxy 为中心，扩展接口为ProxyFactory

   ###### 服务注册层（Registry）：

   封装服务地址的注册和发现，以服务 URL 为中心，扩展接口为 RegistryFactory、Registry、RegistryService

   ###### 路由层（Cluster）：

   封装多个提供者的路由和负载均衡，并桥接注册中心，以Invoker 为中心，扩展接口为 Cluster、Directory、Router和 LoadBlancce

   ###### 监控层（Monitor）：

   RPC 调用次数和调用时间监控，以 Statistics 为中心，扩展接口为 MonitorFactory、Monitor 和 MonitorService

   ###### 远程调用层（Protocal）：

   封装 RPC 调用，以 Invocation 和 Result 为中心，扩展接口为 Protocal、Invoker 和 Exporter

   ###### 信息交换层（Exchange）：

   封装请求响应模式，同步转异步。以 Request 和Response 为中心，扩展接口为 Exchanger、ExchangeChannel、ExchangeClient 和 ExchangeServer

   ###### 网络传输层（Transport）：

   抽象 mina 和 netty 为统一接口，以 Message 为中心，扩展接口为 Channel、Transporter、Client、Server和 Codec

   ###### 数据序列化层（Serialize）：

   可复用的一些工具，扩展接口为 Serialization、ObjectInput、ObjectOutput 和 ThreadPool

2. 服务调用是阻塞的吗

   Dubbo 是基于 NIO 的非阻塞实现并行调用，客户端不需要启动多线程即可完成并行调用多个远程服务，相对多线程开销较小，异步调用会返回一个 Future 对象

3. 默认使用什么序列化框架，你知道的还有哪些

   推荐使用 Hessian 序列化，还有 Duddo、FastJson、Java 自带序列化

4. 服务提供者能实现失效踢出是什么原理

   服务失效踢出基于 zookeeper 的临时节点原理

5. Dubbo 集群容错有几种方案

   | 集群容错方案      | 说明                                       |
   | ----------------- | ------------------------------------------ |
   | Failover Cluster  | 失败自动切换，自动重试其他服务器（默认）   |
   | Failfast Cluster  | 快速失败，立即报错，只发起一次调用         |
   | Failsafe Cluster  | 失败安全，出现异常时，直接忽略             |
   | Failback Cluster  | 失败自动恢复，记录失败请求，定时重发       |
   | Forking Cluster   | 并行调用多个服务器，只要一个成功即返回     |
   | Broadcast Cluster | 广播逐个调用所有提供者，任意一个报错则报错 |

   

6. 画一画服务注册与发现的流程图

   

7. Dubbo 服务降级，失败重试怎么做

   可以通过 dubbo:reference 中设置 mock="return null"。mock 的值也可以修改为 true，然后再跟接口同一个路径下实现一个 Mock 类，命名规则是 “接口名称+Mock” 后缀。然后在 Mock 类里实现自己的降级逻辑

8. Dubbo Monitor 实现原理

   Consumer 端在发起调用之前会先走 filter 链；provider 端在接收到请求时也是先走 filter 链，然后才进行真正的业务逻辑处理。
   默认情况下，在 consumer 和 provider 的 filter 链中都会有 Monitorfilter。

   1. MonitorFilter 向 DubboMonitor 发送数据
   2. DubboMonitor 将数据进行聚合后（默认聚合 1min 中的统计数据）暂存到ConcurrentMap<Statistics, AtomicReference>statisticsMap，然后使用一个含有 3 个线程（线程名字：DubboMonitorSendTimer）的线程池每隔 1min 钟，调用
      SimpleMonitorService 遍历发送 statisticsMap 中的统计数据，每发送完毕一个，就重置当前的 Statistics 的 AtomicReference
   3. SimpleMonitorService 将这些聚合数据塞入 BlockingQueue queue 中（队列大写为 100000）
   4. SimpleMonitorService 使用一个后台线程（线程名为：DubboMonitorAsyncWriteLogThread）将 queue 中的数据写入文件（该线程
      以死循环的形式来写）
   5. SimpleMonitorService 还会使用一个含有 1 个线程（线程名字：DubboMonitorTimer）的线程池每隔 5min 钟，将文件中的统计数据
      画成图表

9. Dubbo 如何优雅停机

   Dubbo 是通过 JDK 的 ShutdownHook 来完成优雅停机的，所以如果使用kill -9 PID 等强制关闭指令，是不会执行优雅停机的，只有通过kill PID 时，才会执行

10. Dubbo 用到哪些设计模式

    

11. Dubbo有哪几种负载均衡策略，默认是哪种

    | 负载均衡策略    | 说明                                           |
    | --------------- | ---------------------------------------------- |
    | Random          | 随机，按权重设置随机概率（默认）               |
    | RoundRobin      | 轮询，按公约后的权重                           |
    | Least Active    | 最少活跃调用数，相同活跃数的随机               |
    | Consistent Hash | 一致hash  ，相同参数的请求总是发到同一个提供者 |

    

    

13. 服务读写推荐的容错策略是怎样的

    读操作建议使用 Failover 失败自动切换，默认重试两次其他服务器。
    写操作建议使用 Failfast 快速失败，发一次调用失败就立即报错。



### 设计模式

1. OOP五大原则SOLID
   - 单一责任原则
   
     当需要修改某个类的时候原因有且只有一个（THERE SHOULD NEVER BE MORE THAN ONE REASON FOR ACLASS TO CHANGE）。换句话说就是让一个类只做一种类型责任，当这个类需要承当其他类型的责任的时候，就需要分解这个类
   
   - 开放封闭原则
   
     开闭原则的意思是：对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类
   
   - 里氏替换原则
   
     里氏代换原则是面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。LSP 是继承复用的基石，只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才能真正被复用，而派生类也能够在基类的基础上增加新的行为。里氏代换原则是对开闭原则的补充。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤原则
   
   - 依赖倒置原则
   
     1. 高层模块不应该依赖于低层模块，二者都应该依赖于抽象
     2. 抽象不应该依赖于细节，细节应该依赖于抽象
   
   - 接口分离原则
   
     这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。它还有另外一个意思是：降低类之间的耦合度。由此可见，其实设计模式就是从大型软件架构出发、便于升级和维护的软件设计思想，它强调降低依赖，降低耦合。
2. 

### Nginx

1. 什么是nginx

   nginx 是一个web 服务器和反向代理服务器 用于HTTP HTTPS SMTP POP3 和IMAP 协议

2. nginx 的特性

   - 反向代理/ L7 负载均衡
   - 嵌入式 Perl 解释器
   - 动态二进制升级
   - 可用于重新编写URL ，具有非常好的PCRE 支持

3. 请解释Nginx 如果处理HTTP 请求

   Nginx 使用反应器模式，主事件循环等待操作系统发出准备事件的信号，这样数据就可以从套接字读取。 在该实例中读取到缓冲区并进行处理，单个线程可以提供数万个并发连接

4. 什么是正向代理和反向代理

   - 正向代理就是一个人发送一个请求直接就到达了目标的服务器
   - 反方代理就是请求统一被Nginx接收，nginx反向代理服务器接收到之后，按照一定的规则分发给了后端的业务处理服务器进行处理了

5. 使用反向代理服务器的优点是什么

   反向代理服务器可以隐藏资源服务器的存在和特征，它充当互联网云和web 服务器之间的中间层。 这对安全方面来说是很好的。特别是使用web 托管服务时

6. nginx 服务器的用途

   nginx 服务器的最佳用法是在网络商部署动态HTTP 内容， 使用SCGI WSGI 应用程序服务器，用于脚本的FastCGI 处理程序。 还可以作为负载均衡器

7. nginx  服务器上的master 和worker 进程分别是什么

   - master 进程  ：  读取及评估配置和维持
   - worker进程：  处理请求

8. 是否可能讲nginx 的错误替换为502 503 错误

   502 === 错误网关 

   503 === 服务器超载

   有可能， 需要确保 fastcgi_intercept_errors 被设置为 ON，并使用错误页面指令

   Location / {fastcgi_pass 127.0.01:9001;fastcgi_intercept_errorson;error_page 502 =503/error_page.html;#…}

9. 请解释  ngx_http_upstream_module  的作用是什么

   ngx_http_upstream_module 用于定义可通过 fastcgi 传递、proxy 传递、uwsgi传递、memcached 传递和 scgi 传递指令来引用的服务器组

10. 请解释什么是 C10K  问题

   C10K 问题是指无法同时处理大量客户端(10,000)的网络套接字

11. 解释 x Nginx  是否支持将请求压缩到上游

    您可以使用 Nginx 模块 gunzip 将请求压缩到上游。gunzip 模块是一个过滤器，它可以对不支持“gzip”编码方法的客户机或服务器使用“内容编码:gzip”来解压缩响应

12. 为什么Nginx性能这么高

    因为他的事件处理机制：异步非阻塞事件处理机制：运用了epoll模型，提供了一个队列，排队解决

13. Nginx负载均衡的算法怎么实现的?策略有哪些

    为了避免服务器崩溃，大家会通过负载均衡的方式来分担服务器压力。将对台服务器组成一个集群，当用户访问时，先访问到一个转发服务器，再由转发服务器将访问分发到压力更小的服务器

    1.  轮询(默认)  每个请求按时间顺序逐一分配到不同的后端服务器，如果后端某个服务器宕机，能自动剔除故障系统

       ```shell
       upstream backserver {
       server 192.168.0.12;
       server 192.168.0.13;
       }
       ```

    2. 权重 weight 

       weight的值越大分配  到的访问概率越高，主要用于后端每台服务器性能不均衡的情况下。其次是为在主从的情况下设置不同的权值，达到合理有效的地利用主机资源 .权重越高，在被访问的概率越大

       ```shell
       upstream backserver {
       server 192.168.0.12 weight=2;
       server 192.168.0.13 weight=8;
       }	
       ```

       

    3. ip_hash( IP绑定)   每个请求按访问IP的哈希结果分配，使来自同一个IP的访客固定访问一台后端服务器，并且可以有效解决动态网页存在的session共享问题

       ```shell
       upstream backserver {
       ip_hash;
       server 192.168.0.12:88;
       server 192.168.0.13:80;
       }
       ```

    4.  fair(第三方插件)

       必须安装upstream_fair模块。对比 weight、ip_hash更加智能的负载均衡算法，fair算法可以根据页面大小和加载时间长短智能地进行负载均衡，响应时间短的优先分配

       ```shell
       upstream backserver {
       server server1;
       server server2;
       fair;
       }
       ```

    5. url_hash(第三方插件)

       必须安装Nginx的hash软件包按访问url的hash结果来分配请求，使每个url定向到同一个后端服务器，可以进一步提高后端缓存服务器的效率

       ```shell
       upstream backserver {
       server squid1:3128;
       server squid2:3128;
       hash $request_uri;
       hash_method crc32;
       }
       ```

14. Nginx配置文件nginx.conf有哪些属性模块

    ```shell
    worker_processes 1；              # worker进程的数量
    events {                     # 事件区块开始
     worker_connections 1024；         # 每个worker进程支持的最大连接数
    }                      # 事件区块结束
    http {                    # HTTP区块开始
     include    mime.types；           # Nginx支持的媒体类型库文件
     default_type application/octet-stream；      # 默认的媒体类型
     sendfile    on；            # 开启高效传输模式
     keepalive_timeout 65；          # 连接超时
     server {                  # 第一个Server区块开始，表示一个独立的
    虚拟主机站点
       listen    80；             # 提供服务的端口，默认80
       server_name localhost；        # 提供服务的域名主机名
       location / {              # 第一个location区块开始
         root  html；          # 站点的根目录，相当于Nginx的安装目录
         index index.html index.htm；      # 默认的首页文件，多个用空格分开
       }                 # 第一个location区块结果
       error_page  500502503504 /50x.html；     # 出现对应的http状态码时，使
    用50x.html回应客户
       location = /50x.html {           # location区块开始，访问
    50x.html
         root  html；               # 指定对应的站点目录为html
       }
     }
    ```

15. Nginx怎么处理请求的

    ```shell
    server {              # 第一个Server区块开始，表示一个独立的虚拟主机
    站点
       listen    80；           # 提供服务的端口，默认80
       server_name localhost；      # 提供服务的域名主机名
       location / {            # 第一个location区块开始
         root  html；        # 站点的根目录，相当于Nginx的安装目录
         index index.html index.htm；    # 默认的首页文件，多个用空格分开
       }             # 第一个location区块结果
     } 
    ```

16. Nginx虚拟主机怎么配置

    1. 基于域名的虚拟主机，通过域名来区分虚拟主机——应用：外部网站

       需要建立/data/www /data/bbs目录，windows本地hosts添加虚拟机ip地址对应的域名解析；对应域名
       网站目录下新增index.html文件

       ```shell
       #当客户端访问www.lijie.com,监听端口号为80,直接跳转到data/www目录下文件
        server {
          listen    80;
          server_name www.lijie.com;
          location / {
            root  data/www;
            index index.html index.htm;
          }
        }
        #当客户端访问www.lijie.com,监听端口号为80,直接跳转到data/bbs目录下文件
        server {
          listen    80;
          server_name bbs.lijie.com;
          location / {
            root  data/bbs;
            index index.html index.htm;
          }
        }
       ```

       

    2. 基于端口的虚拟主机，通过端口来区分虚拟主机——应用：公司内部网站，外部网站的管理后台

       ```shell
       #当客户端访问www.lijie.com,监听端口号为8080,直接跳转到data/www目录下文件
        server {
          listen    8080;
          server_name 8080.lijie.com;
          location / {
            root  data/www;
            index index.html index.htm;
          }
        }
        #当客户端访问www.lijie.com,监听端口号为80直接跳转到真实ip服务器地址 127.0.0.1:8080
        server {
          listen    80;
          server_name www.lijie.com;
          location / {
          proxy_pass http://127.0.0.1:8080;
              index index.html index.htm;
          }
        }
       ```

       

    3. 基于ip的虚拟主机

    

17. location的作用是什么？

    location指令的作用是根据用户请求的URI来执行不同的应用，也就是根据用户请求的网站URL进行匹配，匹配成功即进行相关的操作

    ```shell
    #优先级1,精确匹配，根路径
     location =/ {
       return 400;
     }
     #优先级2,以某个字符串开头,以av开头的，优先匹配这里，区分大小写
     location ^~ /av {
       root /data/av/;
     }
     #优先级3，区分大小写的正则匹配，匹配/media*****路径
     location ~ /media {
        alias /data/static/;
     }
     #优先级4 ，不区分大小写的正则匹配，所有的****.jpg|gif|png 都走这里
     location ~* .*\.(jpg|gif|png|js|css)$ {
       root /data/av/;
     }
     #优先7，通用匹配
     location / {
       return 403;
     }
    ```

18. 限流怎么做的

    Nginx限流就是限制用户请求速度，防止服务器受不了 限流有3种

    1. 正常限制访问频率（正常流量）

       限制一个用户发送的请求，我Nginx多久接收一个请求。
       Nginx中使用ngx_http_limit_req_module模块来限制的访问频率，限制的原理实质是基于漏桶算法原理来实现的。在nginx.conf配置文件中可以使用limit_req_zone命令及limit_req命令限制单个IP的请求处理频率

    2. 突发限制访问频率（突发流量）

       限制一个用户发送的请求，我Nginx多久接收一个。
       上面的配置一定程度可以限制访问频率，但是也存在着一个问题：如果突发流量超出请求被拒绝处理，无法处理活动时候的突发流量，这时候应该如何进一步处理呢？
       Nginx提供burst参数结合nodelay参数可以解决流量突发的问题，可以设置能处理的超过设置的请求数外能额外处理的请求数。我们可以将之前的例子添加burst参数以及nodelay参数

    3. 限制并发连接数

       Nginx中的ngx_http_limit_conn_module模块提供了限制并发连接数的功能，可以使用limit_conn_zone指令以及limit_conn执行进行配置

19. 

### Tomcat

1. Tomcat  的缺省端口是多少，怎么修改

   修改 conf/server.xml 下的 Connector  节点，修改 port

2. tomcat  部署方式

   1. 直接把web 项目放在webapps  下，tomcat 会自动将其部署
   2. 在server.xml 文件上配置<Context> 节点。设置相关属性即可
   3. 通过Catalina  进行配置，进入到conf/Catalina/localhost 文件下，创建一个xml 文件，该文件的名字就是站点的名字

3. tomcat 容器是如何创建 servlet 类实例，用到什么原理

   当容器启动时，会读取在webapps  目录下所有的web 应用中的web.xml 文件，然后对xml 进行解析。 并且读取servlet 注册信息，然后，将每个应用中注册的servlet  类都进行加载。 并通过反射的方式实例化

4. tomcat如何优化

   

5. 内存调优

   内存方式的设置是在 catalina.sh 中，调整一下 JAVA_OPTS 变量即可，因为后面的启动参数会把 JAVA_OPTS 作为 JVM 的启动参数来处理

   具体设置如下：
   JAVA_OPTS="$JAVA_OPTS  -Xmx3550m  -Xms3550m  -Xss128k  -XX:NewRatio=4 -XX:SurvivorRatio=4"

   其各项参数如下：

   -Xmx3550m：设置 JVM 最大可用内存为 3550M

   -Xms3550m：设置 JVM 初始内存为 3550m。此值可以设置与-Xmx 相同，以避免每次垃圾回收完成后 JVM 重新分配内存

   -Xmn2g：设置年轻代大小为 2G。整个堆大小=年轻代大小 + 年老代大小 +持久代大小。持久代一般固定大小为 64m，所以增大年轻代后，将会减小年老代大小。此值对系统性能影响较大，Sun 官方推荐配置为整个堆的 3/8

   -Xss128k：设置每个线程的堆栈大小。JDK5.0 以后每个线程堆栈大小为 1M，以前每个线程堆栈大小为 256K。更具应用的线程所需内存大小进行调整。在相同物理内存下，减小这个值能生成更多的线程。但是操作系统对一个进程内的线程数还是有限制的，不能无限生成

   -XX:NewRatio=4:设置年轻代（包括 Eden 和两个 Survivor 区）与年老代的比值（除去持久代）。设置为 4，则年轻代与年老代所占比值为 1：4，年轻代占整个堆栈的 1/5

   -XX:MaxPermSize=16m:设置持久代大小为 16m。
   -XX:MaxTenuringThreshold=0：设置垃圾最大年龄。如果设置为 0 的话，则年轻代对象不经过 Survivor 区，直接进入年老代。对于年老代比较多的应用，可以提高效率。如果将此值设置为一个较大值，则年轻代对象会在 Survivor 区进行多次复制，这样可以增加对象再年轻代的存活时间，增加在年轻代即被回收的概论

6. tomcat 一个请求的完整过程

   1. 请求被发送到本机端口 8080，被在那里侦听的 Coyote  HTTP/1.1Connector 获得
   2. Connector 把该请求交给它所在的 Service 的 Engine 来处理，并等待来自Engine 的回应
   3. Engine 获得请求路径localhost/demo/1，匹配它所拥有的所有虚拟主机 Host
   4. Engine 匹配到名为 localhost 的 Host（即使匹配不到也把请求交给该 Host处理，因为该 Host 被定义为该 Engine 的默认主机）
   5. localhost Host 获得请求/demo/1，匹配它所拥有的所有 Context
   6. Host 匹配到路径为/demo 的 Context（如果匹配不到就把该请求交给路径名为”“的 Context 去处理
   7. path=”/demo”的 Context 获得请求/1，在它的 mapping table 中寻找对应的 servlet
   8. Context 匹配到 对应的 servlet 类
   9. 构造 HttpServletRequest 对象和 HttpServletResponse 对象，作为参数调用Servlet 的 doGet 或 doPost 方法
   10. Context 把执行完了之后的 HttpServletResponse 对象返回给 Host
   11. Host 把 HttpServletResponse 对象返回给 Engine
   12. Engine 把 HttpServletResponse 对象返回给 Connector
   13. Connector 把 HttpServletResponse 对象返回给客户 browser

7. 

### Netty

1. netty 的特点

   一个高性能，异步事件驱动的NIO 框架，他提供了对TCP ，UDP 和文件传输的支持，使用更高效的socket 底层。对epoll 空轮询引起的cpu 占用飙升在内部进行了处理，避免了直接使用NIO 的陷阱，简化了NIO 的处理方式

   采用多种decoder / encoder 支持，对TCP 粘包和分包进行自动化处理

   可以使用接受/初始线程池，提高连接效率，对重连，心跳检测的简单支持

   可配置IO 线程数，TCP 参数，TCP 接受和发送缓冲区使用直接内存代替堆内存，通过内存池的方式循环利用ByteBuf 

   通过引用计数器及时申请释放不再引用的对象，降低GC 频率

   使用单线程串行化的方式吗，高效的Reactor 线程模型

   大量使用了volitale ，使用了CAS 和原子类，线程安全类的使用，读写锁的使用。

2. 多路复用 通讯方式

   Netty 架构按照 Reactor 模式设计和实现，它的服务端通信序列图如下

   ![image-20210806114444817](https://gitee.com/Sean0516/image/raw/master/img/image-20210806114444817.png)

   客户端通信序列图如下

   ![image-20210806114548001](https://gitee.com/Sean0516/image/raw/master/img/image-20210806114548001.png)

   Netty 的 IO 线程 NioEventLoop 由于聚合了多路复用器 Selector，可以同时并发处理成百上千个客户端 Channel，由于读写操作都是非阻塞的，这就可以充分提升 IO 线程的运行效率，避免由于频繁 IO 阻塞导致的线程挂起

   1. 异步通讯 异步通讯 NIO

      由于 Netty 采用了异步通信模式，一个 IO 线程可以并发处理 N 个客户端连接和读写操作，这从根本上解决了传统同步阻塞 IO 一连接一线程模型，架构的性能、弹性伸缩能力和可靠性都得到了极大的提升

   2. 零拷贝（ （DIRECT BUFFERS 使用堆外直接内存 使用堆外直接内存） ）

      1. Netty 的接收和发送 ByteBuffer 采用 DIRECT BUFFERS，使用堆外直接内存进行 Socket 读写，不需要进行字节缓冲区的二次拷贝。如果使用传统的堆内存（HEAP BUFFERS）进行 Socket 读写，JVM 会将堆内存 Buffer 拷贝一份到直接内存中，然后才写入 Socket 中。相比于堆外直接内存，消息在发送过程中多了一次缓冲区的内存拷贝
      2. Netty 提供了组合 Buffer 对象，可以聚合多个 ByteBuffer 对象，用户可以像操作一个 Buffer 那样方便的对组合 Buffer 进行操作，避免了传统通过内存拷贝的方式将几个小 Buffer 合并成一个大的Buffer
      3. Netty的文件传输采用了transferTo方法，它可以直接将文件缓冲区的数据发送到目标Channel，避免了传统通过循环 write 方式导致的内存拷贝问题

   3. 内存池 （ 基于内存池的缓冲区重用机制）

      随着 JVM 虚拟机和 JIT 即时编译技术的发展，对象的分配和回收是个非常轻量级的工作。但是对于缓冲区 Buffer，情况却稍有不同，特别是对于堆外直接内存的分配和回收，是一件耗时的操作。为了尽量重用缓冲区，Netty 提供了基于内存池的缓冲区重用机制


   

3. netty 的线程模型 

   netty 通过Reactor 模型，基于多路复用接收器接收并处理用户请求， 内部实现了两个线程池

   boss 线程池和work 线程池。其中boss 线程池的线程负责处理请求的accept 事件，当接受到accept 事件的请求时，把对应的socket 封装到一个NioSocketChannel 中，并交给work 线程，其中work 线程池负责请求的read 和write 事件 ，由对应的handler 处理

   ######  单线程模型

   所有的I/O操作都由一个线程完成。即多路复用，事件分发和处理都在一个Reactor 线程完成，既要接受客户端的连接请求，向服务端发起连接，又要发送/读取请求或应当/响应消息。 一个NIO 线程同时处理成百上千的链路，性能上无法支持，速度慢，若线程进入死循环，整个程序不可用，对高负载，大并发的应用场景不适合

   ###### 多线程模型 

   有一个NIO 线程只负责监听服务端，接收客户端的TCP连接请求。 NIO 线程池负责网络IO 的操作， 即数据的读取，解码，编码和发送。 一个NIO 线程可以同时处理N 条链路，但是一个链路只对应一个NIO 线程，这是为了防止发生并发操作问题。 但在并发百万客户端连接或需要安全认证时，一个Acceptor 线程可能会存在性能不足问题

   ###### 主从多线程模型  

   Acceptor 线程用于绑定监听端口，接收客户端连接，将SocketChannel 从主线程池的Reactor 线程的多路复用器上移除，重新注册到Sub 线程池的线程上，用于处理I/O 的读写操作，从而保证main Reactor 只负责认证，握手等操作

4. TCP 粘包/ 拆包的原因及解决方法

   TCP 是以流的方式来处理数据，一个完整的包可能会被TCP 拆分成多个包进行发送，也可能把小的封装成一个大的数据包发送。

   ###### TCP/ 粘包/分包的原因

   应用程序写入的字节大小大于套接字发送缓冲区的大小，会发生拆包现象，而应用程序写入数据小于套接字缓冲区大小，网卡将应用多次写入的数据发送到网络上，这将发生粘包现象

   ###### 解决方法

   消息定长： FixedLengthFrameDecoder 类

   包尾增加特殊字符分割： 行分隔符类  LineBaseFrameDecoder 或者自定义分隔符类。 DelimiterBaseFrameDecoder 

   将消息分割消息头和消息体  LengthFieldBaseFrameDecoder 类，分为有头部的拆包和粘包，长度字段在前且有头部的拆包和粘包，多扩展头部的拆包与粘包

5. Netty 的零拷贝实现

   Netty 的接受和发送ByteBuffer 采用DIRECT BUFFERS 。 使用堆外直接内存进行socket 读写，不需要进行字节缓冲区的二次拷贝，堆内存多了一个内存拷贝，JVM 会将堆内存 Buffer 拷贝一份到直接内存中，然后才写入Socket 中，ByteBuffer 由 ChannelConfig  分配， 而ChannelConfig 创建ByteBufAllocator 默认使用Direct Buffer 

   CompositeByteBuf 类可以将多个 ByteBuf 合并为一个逻辑上的 ByteBuf, 避免了传统通过内存拷贝的方式将几个小 Buffer 合并成一个大的 Buffer。addComponents 方法将  header与 body 合并为一个逻辑上的 ByteBuf, 这两个 ByteBuf 在 CompositeByteBuf 内部都是单独存在的, CompositeByteBuf 只是逻辑上是一个整体

   通过 FileRegion 包装的 FileChannel.tranferTo 方法 实现文件传输, 可以直接将文件缓冲区的数据发送到目标 Channel，避免了传统通过循环 write 方式导致的内存拷贝问题

   通过  wrap 方法,  我们可以将  byte[]  数组、ByteBuf、ByteBuffer 等包装成一个  NettyByteBuf 对象, 进而避免了拷贝操作

6. Netty 的高性能表现在哪些方面

   1. 心跳  

      对服务端：会定时清除闲置会话 inactive(netty5)，对客户端:用来检测会话是否断开，是否重来，检测网络延迟，其中 idleStateHandler 类 用来检测会话状态

   2. 串行无锁化设计

      即消息的处理尽可能在同一个线程内完成，期间不进行线程切换，这样就避免了多线程竞争和同步锁。表面上看，串行化设计似乎 CPU 利用率不高，并程度不够。但是，通过调整 NIO 线程池的线程参数，可以同时启动多个串行化的线程并行运行，
      这种局部无锁化的串行线程设计相比一个队列-多个工作线程模型性能更优

   3. 可靠性，链路有效性检测

      链路空闲检测机制，读/写空闲超时机制；内存保护机制：通过内存池重用ByteBuf;ByteBuf 的解码保护；优雅停机：不再接收新消息、退出前的预处理操作、资源的释放操作

   4. 安全性

      SSL V2 和 V3，TLS，SSL 单向认证、双向认证和第三方 CA认证

   5. 高效并发编程的体现

      volatile 的大量、正确使用；CAS 和原子类的广泛使用；线程安全容器的使用；通过读写锁提升并发性能。IO 通信性能三原则：传输（AIO）、协议（Http）、线程（主从多线程）

   6. 流量整型的作用

      防止由于上下游网元性能不均衡导致下游网元被压垮，业务流中断；防止由于通信模块接受消息过快，后端业务线程处理不及时导致撑死问题

### 网络编程

1. 计算机网络体系结构

   ##### OSA 模型

   OSI（Open System Interconnect），即开放式系统互联。一般都叫OSI参考模型，是ISO（国际标准化组织）组织在1985年研究的网络互连模型。ISO为了更好的使网络应用更为普及，推出了OSI参考模型，这样所有的公司都按照统一的标准来指定自己的网络，就可以互通互联了。

   OSI定义了网络互连的七层框架（物理层、数据链路层、网络层、传输层、会话层、表示层、应用层

   | OSI 七层模型 | 功能                                                         | 对应网络协议                | TCP/IP 四层概念模型 |
   | ------------ | ------------------------------------------------------------ | --------------------------- | ------------------- |
   | 应用层       | 文本传输,文本管理,电子邮件的信息处理-- apdu                  | HTTP TFTP FTP NFS WAIS SMTP | 应用层              |
   | 表示层       | 确保一个系统的应用层发送的消息可以被另一个系统的应用层读取，编码转换,数据解析，管理数据的读取和加密,最小单位---ppdu | Telnet  Rlogin SNMP Gopher  | 应用层              |
   | 会话层       | 负责在网络中的两节点建立，维持和终止通信，在一层协议中，可以解决节点连接的协调和管理问题，包括通信连接的建立，保持会话过程通信连接的畅通，两节点之间的对话，决定通信是否被终端以及通信终端是决定从何处重新发送，最小单位 spdu | SMTP DNS                    | 应用层              |
   | 传输层       | 定义一些传输数据的协议和端口，传输协议同时进行流量控制，或是根据接受方接受数据的快慢成都，规定适当的发送速率，解决传输效率及能力的问题 -- tpdu | TCP UDP                     | 传输层              |
   | 网络层       | 控制子网的运行，如逻辑地址，分组传输，路由选择最小单位---分组（包） 报文 | IP ICMP ARP RARP AKP UUCP   | 网络层              |
   | 数据链路层   | 主要是对物理层传输的比特流包装，检测保证数据传输的可靠性，将物理层接收的数据进行NAC 地址的封装和解封装，也可也简单理解为物理寻址，交换机就处在这一层，最小传输单位---帧 | FDDI Etgerbet SLIP          | 数据链路层          |
   | 物理层       | 定义物理设备的标准，主要对物理连接方式，电气特征，机械特性等定制统一标准，传输比特率，因此最小的传输单位--- 位 （比特流） | IEEE 802                    | 数据链路层          |

   

2. TCP/IP 参考模型

   ##### 应用层

   应用层是最靠近用户的一层，是为计算机用户提供应用接口，也为用户应用提供接口，也为用户直接提供各种网络服务，我们常见的应用层的网络服务协议有： HTTP HTTPS FTP TELENT 等

   ##### 传输层

   建立了主机端到端的链接 ，传输层的作用是为了上层协议提供端到端的可靠和透明的数据传输服务，包括处理差错控制和流量控制等问题，该层向高层屏蔽了下层数据通信的细节，使高层用户看到的只是在两个传输实体间的一条主机到主机的，可由用户控制和设定的，可靠的数据通路，我们通常说的 TCP UDP 就是在这一层的。端口号就是这里的端

   ##### 网络层

   本层通过IP寻址来建立两个节点之间的连接，为源端的运输层送来的分组，选择合适的路由和交换节点，正确无误地按照地址传送给目的段的运输层。 这一层就是我们经常说的IP 协议层，IP 协议是 Internet 的基础

   ##### 数据链路层

   通过一些规程或协议来控制这些数据的传输，以保证被传输数据的正确性，实现这些规程或协议的硬件和软件加上物理线路，这样就构成了数据链路

3. 什么是TCP/IP 和UDP

   1. TCP/IP 即传输控制/网络协议， 是面向连接的协议，发送数据前要先建立连接（发送方和接收方的成对的两个之间必须建立连接） TCP 提供可靠的服务，也就是说，通过TCP 连接传输的数据不会丢失，没有重复，并且按照顺序到达
   2. UDP 是属于TCP/IP 协议的一种，是无连接的协议，发送数据前不需要建立连接，是没有可靠性的协议，因为不需要建立连接所以可以在在网络上以任何可能的路径传输，因此能否到达目的地，到达目的地的时间以及内容的正确性都是不能被保证的

4. TCP与UDP区别

   1. TCP是面向连接的协议，发送数据前要先建立连接，TCP提供可靠的服务，也就是说，通过TCP连接传输的数据不会丢失，没有重复，并且按顺序到达
   2. UDP是无连接的协议，发送数据前不需要建立连接，是没有可靠性
   3. TCP通信类似于于要打个电话，接通了，确认身份后，才开始进行通行
   4. UDP通信类似于学校广播，靠着广播播报直接进行通信
   5. TCP只支持点对点通信，UDP支持一对一、一对多、多对一、多对多
   6. TCP是面向字节流的，UDP是面向报文的； 面向字节流是指发送数据时以字节为单位，一个数据包可以拆分成若干组进行发送，而UDP一个报文只能一次发完
   7. TCP首部开销（20字节）比UDP首部开销（8字节）要大
   8. UDP 的主机不需要维持复杂的连接状态表

5. 什么是Http协议

   - Http协议是对客户端和服务器端之间数据之间实现可靠性的传输文字、图片、音频、视频等超文本数据的规范，格式简称为“超文本传输协议
   - Http协议属于应用层，及用户访问的第一层就是http

6. Http和Https的区别

   Http协议运行在TCP之上，明文传输，客户端与服务器端都无法验证对方的身份；Https是身披SSL(Secure Socket Layer)外壳的Http，运行于SSL上，SSL运行于TCP之上，是添加了加密和认证机制的HTTP。二者之间存在如下不同

   - 端口不同：Http与Http使用不同的连接方式，用的端口也不一样，前者是80，后者是443
   - 资源消耗：和HTTP通信相比，Https通信会由于加减密处理消耗更多的CPU和内存资源
   - 开销：Https通信需要证书，而证书一般需要向认证机构购买

   Https的加密机制是一种共享密钥加密和公开密钥加密并用的混合加密机制

7. 什么是http的请求体

   HTTP请求体是我们请求数据时先发送给服务器的数据，毕竟我向服务器那数据，先要表明我要什么吧

   HTTP请求体由：请求行 、请求头、请求数据组成的

   注意：GIT请求是没有请求体的

8. HTTP的响应报文有哪些

   1. http的响应报是服务器返回给我们的数据，必须先有请求体再有响应报文
   2. 响应报文包含三部分 状态行、响应首部字段、响应内容实体实现

9. HTTPS工作原理

   1. 首先HTTP请求服务端生成证书，客户端对证书的有效期、合法性、域名是否与请求的域名一致、证书的公钥（RSA加密）等进行校验
   2. 客户端如果校验通过后，就根据证书的公钥的有效， 生成随机数，随机数使用公钥进行加密（RSA加密
   3. 消息体产生的后，对它的摘要进行MD5（或者SHA1）算法加密，此时就得到了RSA签名
   4. 发送给服务端，此时只有服务端（RSA私钥）能解密
   5. 解密得到的随机数，再用AES加密，作为密钥（此时的密钥只有客户端和服务端知道）

10. 三次握手与四次挥手
    ![image-20210806143224208](https://gitee.com/Sean0516/image/raw/master/img/image-20210806143224208.png)

    #####  三次握手

    - 第一次握手：Client将标志位SYN置为1，随机产生一个值seq=J，并将该数据包发送给Server，Client进入SYN_SENT状态，等待Server确认
    - 第二次握手：Server收到数据包后由标志位SYN=1知道Client请求建立连接，Server将标志位SYN和ACK都置为1，ack=J+1，随机产生一个值seq=K，并将该数据包发送给Client以确认连接请求，Server进入SYN_RCVD状态
    - 第三次握手：Client收到确认后，检查ack是否为J+1，ACK是否为1，如果正确则将标志位ACK置为1，ack=K+1，并将该数据包发送给Server，Server检查ack是否为K+1，ACK是否为1，如果正确则连接建立成功，Client和Server进入ESTABLISHED状态，完成三次握手，随后Client与Server之间可以开始传输数据了

    TCP 建立连接要进行三次握手，而断开连接要进行四次。这是由于 TCP 的半关闭造成的。因为 TCP 连接是全双工的(即数据可在两个方向上同时传递)所以进行关闭时每个方向上都要单独进行关闭。这个单方向的关闭就叫半关闭。当一方完成它的数据发送任务，就发送一个 FIN 来向另一方通告将要终止这个方向的连接

    ![image-20210806143309480](https://gitee.com/Sean0516/image/raw/master/img/image-20210806143309480.png)

    ##### 四次挥手

    - 第一次挥手：Client发送一个FIN，用来关闭Client到Server的数据传送，Client进入FIN_WAIT_1状态
    - 第二次挥手：Server收到FIN后，发送一个ACK给Client，确认序号为收到序号+1（与SYN相同，一个FIN占用一个序号），Server进入CLOSE_WAIT状态。此时TCP链接处于半关闭状态，即客户端已经没有要发送的数据了，但服务端若发送数据，则客户端仍要接收
    - 第三次挥手：Server发送一个FIN，用来关闭Server到Client的数据传送，Server进入LAST_ACK状态
    - 第四次挥手：Client收到FIN后，Client进入TIME_WAIT状态，接着发送一个ACK给Server，确认序号为收到序号+1，Server进入CLOSED状态，完成四次挥手

11. 为什么 TCP 链接需要三次握手，两次不可以么

    三次握手”的目的是为了防止已失效的链接请求报文突然又传送到了服务端，因而产生错误

    - 正常的情况：A 发出连接请求，但因连接请求报文丢失而未收到确认，于是 A 再重传一次连接请求。后来收到了确认，建立了连接。数据传输完毕后，就释放了连接。A 共发送了两个连接请求报文段，其中第一个丢失，第二个到达了 B。没有 “已失效的连接请求报文段”。
    - 现假定出现了一种异常情况：即 A 发出的第一个连接请求报文段并没有丢失，而是在某个网络结点长时间的滞留了，以致延误到连接释放以后的某个时间才到达 B。本来这是一个早已失效的报文段。但 B 收到此失效的连接请求报文段后，就误认为是 A 再次发出的一个新的连接请求。于是就向 A 发出确认报文段，同意建立连接

    假设不采用“三次握手”，那么只要 B 发出确认，新的连接就建立了。由于现在 A 并没有发出建立连接的请求，因此不会理睬 B 的确认，也不会向 B 发送数据。但 B 却以为新的运输连接已经建立，并一直等待A 发来数据。这样，B 的很多资源就白白浪费掉了。采用“三次握手”的办法可以防止上述现象发生

12. 用现实理解三次握手的具体细节

    三次握手的目的是建立可靠的通信信道，主要的目的就是双方确认自己与对方的发送与接收机能正常

    1. 第一次握手：客户什么都不能确认；服务器确认了对方发送正常
    2. 第二次握手：客户确认了：自己发送、接收正常，对方发送、接收正常；服务器确认 了：自己接收正常，对方发送正常
    3. 第三次握手：客户确认了：自己发送、接收正常，对方发送、接收正常；服务器确认 了：自己发送、接收正常，对方发送接收正常 所以三次握手就能确认双发收发功能都正常，缺一不可

13. 为什么要四次挥手

    TCP 协议是一种面向连接的、可靠的、基于字节流的运输层通信协议。TCP 是全双工模式，这就意味着，当 A 向 B 发出 FIN 报文段时，只是表示 A 已经没有数据要发送了，而此时 A 还是能够接受到来自 B发出的数据；B 向 A 发出 ACK 报文段也只是告诉 A ，它自己知道 A 没有数据要发了，但 B 还是能够向A 发送数据

14. TCP 协议如何来保证传输的可靠性

    TCP 提供一种面向连接的、可靠的字节流服务。其中，面向连接意味着两个使用 TCP 的应用（通常是一个客户和一个服务器）在彼此交换数据之前必须先建立一个 TCP 连接。在一个 TCP 连接中，仅有两方进行彼此通信；而字节流服务意味着两个应用程序通过 TCP 链接交换 8 bit 字节构成的字节流，TCP 不在字节流中插入记录标识符

    对于可靠性，TCP通过以下方式进行保证

    - 数据包校验：目的是检测数据在传输过程中的任何变化，若校验出包有错，则丢弃报文段并且不给出响应，这时TCP发送数据端超时后会重发数据
    - 对失序数据包重排序：既然TCP报文段作为IP数据报来传输，而IP数据报的到达可能会失序，因此TCP报文段的到达也可能会失序。TCP将对失序数据进行重新排序，然后才交给应用层
    - 丢弃重复数据：对于重复数据，能够丢弃重复数据
    - 应答机制：当TCP收到发自TCP连接另一端的数据，它将发送一个确认。这个确认不是立即发送，通常将推迟几分之一秒
    - 超时重发：当TCP发出一个段后，它启动一个定时器，等待目的端确认收到这个报文段。如果不能及时收到一个确认，将重发这个报文段
    - 流量控制：TCP连接的每一方都有固定大小的缓冲空间。TCP的接收端只允许另一端发送接收端缓冲区所能接纳的数据，这可以防止较快主机致使较慢主机的缓冲区溢出，这就是流量控制。TCP使用的流量控制协议是可变大小的滑动窗口协议

15. TCP 的拥塞避免机制

    ##### 拥塞：

    对资源的需求超过了可用的资源。若网络中许多资源同时供应不足，网络的性能就要明显变坏，整个网络的吞吐量随之负荷的增大而下降

    ##### 拥塞控制

    防止过多的数据注入到网络中，使得网络中的路由器或链路不致过载

    ##### 拥塞控制的方法

    1. 慢启动 + 拥塞避免：
       慢启动：不要一开始就发送大量的数据，先探测一下网络的拥塞程度，也就是说由小到大逐渐增加拥塞窗口的大小

       拥塞避免：拥塞避免算法让拥塞窗口缓慢增长，即每经过一个往返时间RTT就把发送方的拥塞窗口cwnd加1，而不是加倍，这样拥塞窗口按线性规律缓慢增长

    2. 快重传 + 快恢复

       快重传：快重传要求接收方在收到一个 失序的报文段 后就立即发出 重复确认（为的是使发送方及早知道有报文段没有到达对方）而不要等到自己发送数据时捎带确认。快重传算法规定，发送方只要一连收到三个重复确认就应当立即重传对方尚未收到的报文段，而不必继续等待设置的重传计时器时间到期

       快恢复：快重传配合使用的还有快恢复算法，当发送方连续收到三个重复确认时，就执行“乘法减小”算法，把ssthresh门限减半，但是接下去并不执行慢开始算法：因为如果网络出现拥塞的话就不会收到好几个重复的确认，所以发送方现在认为网络可能没有出现拥塞。所以此时不执行慢开始算法，而是将cwnd设置为ssthresh的大小，然后执行拥塞避免算法

16. 一次完整的HTTP请求所经历几个步骤

    1. 建立TCP连接

    2. Web浏览器向Web服务器发送请求行

       一旦建立了TCP连接，Web浏览器就会向Web服务器发送请求命令。例如：GET /sample/hello.jspHTTP/1.1

    3. Web浏览器发送请求头

       浏览器发送其请求命令之后，还要以头信息的形式向Web服务器发送一些别的信息，之后浏览器发送了一空白行来通知服务器，它已经结束了该头信息的发送。

    4. Web服务器应答

       客户机向服务器发出请求后，服务器会客户机回送应答， HTTP/1.1 200 OK ，应答的第一部分是协议的版本号和应答状态码

    5. Web服务器发送应答头

       正如客户端会随同请求发送关于自身的信息一样，服务器也会随同应答向用户发送关于它自己的数据及被请求的文档

    6. Web服务器向浏览器发送数据

       Web服务器向浏览器发送头信息后，它会发送一个空白行来表示头信息的发送到此为结束，接着，它就以Content-Type应答头信息所描述的格式发送用户所请求的实际数据

    7. Web服务器关闭TCP连接

17. 浏览器中输入：“www.xxx.com” 之后都发生了什么

    1. 由域名→IP地址 寻找IP地址的过程依次经过了浏览器缓存、系统缓存、hosts文件、路由器缓存、 递归搜索根域名服务器
    2. 建立TCP/IP连接（三次握手具体过程）
    3. 由浏览器发送一个HTTP请求
    4. 经过路由器的转发，通过服务器的防火墙，该HTTP请求到达了服务器
    5. 服务器处理该HTTP请求，返回一个HTML文件
    6. 浏览器解析该HTML文件，并且显示在浏览器端

18. 什么是 HTTP 协议无状态协议？怎么解决Http协议无状态协议

    TTP 是一个无状态的协议，也就是没有记忆力，这意味着每一次的请求都是独立的，缺少状态意味着如果后续处理需要前面的信息，则它必须要重传，这样可能导致每次连接传送的数据量增大。另一方面，在服务器不需要先前信息时它的应答就很快

    HTTP 的这种特性有优点也有缺点

    ###### 优点

    解放了服务器，每一次的请求“点到为止”，不会造成不必要的连接占用

    ###### 缺点

    每次请求会传输大量重复的内容信息，并且，在请求之间无法实现数据的共享

    ###### 解决方案

    1. 使用参数传递机制：
       将参数拼接在请求的 URL 后面，实现数据的传递（GET方式），例如：/param/list?username=wmyskxz
    2. 使用 Cookie 技术
    3. 使用 Session 技术

19. Http 状态码

    ![image-20210806143434199](https://gitee.com/Sean0516/image/raw/master/img/image-20210806143434199.png)

    ![image-20210806143530534](https://gitee.com/Sean0516/image/raw/master/img/image-20210806143530534.png)

20. HTTPS 

    ![image-20210806145104261](https://gitee.com/Sean0516/image/raw/master/img/image-20210806145104261.png)

    HTTPS（全称：Hypertext Transfer Protocol over Secure Socket Layer），是以安全为目标的HTTP 通道，简单讲是 HTTP 的安全版。即 HTTP 下加入 SSL 层，HTTPS 的安全基础是 SSL。其所用的端口号是 443。 过程大致如下

    1. 建立连接获取证书

        SSL 客户端通过 TCP 和服务器建立连接之后（443 端口），并且在一般的 tcp 连接协商（握手）过程中请求证书。即客户端发出一个消息给服务器，这个消息里面包含了自己可实现的算法列表和其它一些需要的消息，SSL 的服务器端会回应一个数据包，这里面确定了这次通信所需要的算法，然后服务器向客户端返回证书。（证书里面包含了服务器信息：域名。申请证书的公司，公共秘钥）

    2. 证书验证

       Client 在收到服务器返回的证书后，判断签发这个证书的公共签发机构，并使用这个机构的公共秘钥确认签名是否有效，客户端还会确保证书中列出的域名就是它正在连接的域名

    3. 数据加密和传输

       如果确认证书有效，那么生成对称秘钥并使用服务器的公共秘钥进行加密。然后发送给服务器，服务器使用它的私钥对它进行解密，这样两台计算机可以开始进行对称加密进行通信

       

21. Session、Cookie 与 Application

    Cookie和Session都是客户端与服务器之间保持状态的解决方案，具体来说，cookie机制采用的是在客户端保持状态的方案，而session机制采用的是在服务器端保持状态的方案

22. Session 与 Cookie 的对比

    - 实现机制：Session的实现常常依赖于Cookie机制，通过Cookie机制回传SessionID；
    - 大小限制：Cookie有大小限制并且浏览器对每个站点也有cookie的个数限制，Session没有大小限制，理论上只与服务器的内存大小有关；
    - 安全性：Cookie存在安全隐患，通过拦截或本地文件找得到cookie后可以进行攻击，而Session由于保存在服务器端，相对更加安全；
    - 服务器资源消耗：Session是保存在服务器端上会存在一段时间才会消失，如果session过多会增加服务器的压力

23. 滑动窗口机制

    由发送方和接收方在三次握手阶段，互相将自己的最大可接收的数据量告诉对方。

    也就是自己的数据接收缓冲池的大小。这样对方可以根据已发送的数据量来计算是否可以接着发送。在处理过程中，当接收缓冲池的大小发生变化时，要给对方发送更新窗口大小的通知。这就实现了流量的控制

24. 网络层的 ARP 协议工作原理

    地址解析协议(ARP) 是通过解析网路层地址来找寻数据链路层地址的一个在网络协议包中极其重要的网络传输协议

    

    网络层的ARP协议完成了IP地址与物理地址的映射。首先，每台主机都会在自己的ARP缓冲区中建立一个ARP列表，以表示IP地址和MAC地址的对应关系。当源主机需要将一个数据包要发送到目的主机时，会首先检查自己ARP列表中是否存在该IP地址对应的MAC地址：如果有，就直接将数据包发送到这个MAC地址；如果没有，就向本地网段发起一个ARP请求的广播包，查询此目的主机对应的MAC地址。此ARP请求数据包里包括源主机的IP地址、硬件地址、以及目的主机的IP地址。网络中所有的主机收到这个
    ARP请求后，会检查数据包中的目的IP是否和自己的IP地址一致。如果不相同就忽略此数据包；如果相同，该主机首先将发送端的MAC地址和IP地址添加到自己的ARP列表中，如果ARP表中已经存在该IP的信息，则将其覆盖，然后给源主机发送一个ARP响应数据包，告诉对方自己是它需要查找的MAC地址；源主机收到这个ARP响应数据包后，将得到的目的主机的IP地址和MAC地址添加到自己的ARP列表中，并利用此信息开始数据的传输。如果源主机一直没有收到ARP响应数据包，表示ARP查询失败

25. IP地址的分类

整个的因特网就是一个单一的、抽象的网络。IP 地址就是给因特网上的每一个主机（或路由器）的每一个接口分配一个在全世界范围是唯一的 32 位标识符，它是一个逻辑地址，用以屏蔽掉物理地址的差异。IP地址编址方案将IP地址空间划分为A、B、C、D、E五类，其中A、B、C是基本类，D、E类作为多播和保留使用，为特殊地址

每个IP地址包括两个标识码（ID），即网络ID和主机ID。同一个物理网络上的所有主机都使用同一个网络ID，网络上的一个主机（包括网络上工作站，服务器和路由器等）有一个主机ID与其对应。A~E类地址的特点如下

- A类地址：以0开头，第一个字节范围：0~127
- B类地址：以10开头，第一个字节范围：128~191
- C类地址：以110开头，第一个字节范围：192~223
- D类地址：以1110开头，第一个字节范围为224~239
- E类地址：以1111开头，保留地址





### 一致性算法

1. paxos  

   Paxos 算法解决的问题是一个分布式系统如何就某个值（决议）达成一致。一个典型的场景是，在一个分布式数据库系统中，如果各节点的初始状态一致，每个节点执行相同的操作序列，那么他们最后能得到一个一致的状态。为保证每个节点执行相同的命令序列，需要在每一条指令上执行一个“一致性算法”以保证每个节点看到的指令一致。zookeeper 使用的 zab 算法是该算法的一个实现。 在 Paxos 算法中，有三种角色：Proposer，Acceptor，Learners

   ###### Paxos  三种角色：Proposer ，Acceptor ，Learners

   - Proposer

     只要 Proposer 发的提案被半数以上 Acceptor 接受，Proposer 就认为该提案里的 value 被选定了

   - Acceptor

     只要 Acceptor 接受了某个提案，Acceptor 就认为该提案里的 value 被选定了

   - Learner

     Acceptor 告诉 Learner 哪个 value 被选定，Learner 就认为那个 value 被选定

   ###### Paxos  算法分为两个阶段。具体如下

   1. 阶段一 （准 leader 确定 
      1. Proposer 选择一个提案编号N，然后向半数以上的Acceptor发送编号为N的Prepare请求
      2. 如果一个 Acceptor 收到一个编号为 N 的 Prepare 请求，且 N 大于该 Acceptor 已经响应过的所有 Prepare 请求的编号，那么它就会将它已经接受过的编号最大的提案（如果有的话）作为响应反馈给 Proposer，同时该 Acceptor 承诺不再接受任何编号小于 N 的提案
   2. 阶段二 （ leader 确认
      1. 如果 Proposer 收到半数以上 Acceptor 对其发出的编号为 N 的 Prepare 请求的响应，那么它就会发送一个针对[N,V]提案的 Accept 请求给半数以上的 Acceptor。注意：V 就是收到的响应中编号最大的提案的 value，如果响应中不包含任何提案，那么 V 就由 Proposer 自己决定
      2. 如果 Acceptor 收到一个针对编号为 N 的提案的 Accept 请求，只要该 Acceptor 没有对编号大于 N 的 Prepare 请求做出过响应，它就接受该提案

2. Zab

   ZAB( ZooKeeper Atomic Broadcast , ZooKeeper 原子消息广播协议）协议包括两种基本的模式：崩溃恢复和消息广播

   1. 当整个服务框架在启动过程中，或是当 Leader 服务器出现网络中断崩溃退出与重启等异常情况时，ZAB 就会进入恢复模式并选举产生新的 Leader 服务器
   2. 当选举产生了新的 Leader 服务器，同时集群中已经有过半的机器与该 Leader 服务器完成了状态同步之后，ZAB 协议就会退出崩溃恢复模式，进入消息广播模式
   3. 当有新的服务器加入到集群中去，如果此时集群中已经存在一个 Leader 服务器在负责进行消息广播，那么新加入的服务器会自动进入数据恢复模式，找到 Leader 服务器，并与其进行数据同步，然后一起参与到消息广播流程中去

   以上其实大致经历了三个步骤

   1.  崩溃恢复：主要就是 Leader 选举过程
   2. 数据同步： Leader 服务器与其他服务器进行数据同步
   3. 消息广播： Leader 服务器将数据发送给其他

3. 一致性 Hash

   一致性哈希算法(Consistent Hashing Algorithm)是一种分布式算法，常用于负载均衡。Memcached client 也选择这种算法，解决将 key-value 均匀分配到众多 Memcached server 上的问题。它可以取代传统的取模操作，解决了取模操作无法应对增删 Memcached Server 的问题(增删 server 会导致同一个 key,在 get 操作时分配不到数据真正存储的 server，命中率会急剧下降)

   1.   一致性 Hash 的特性

      - 平衡性(Balance)：平衡性是指哈希的结果能够尽可能分布到所有的缓冲中去，这样可以使得所有的缓冲空间都得到利用
      - 单调性(Monotonicity)：单调性是指如果已经有一些内容通过哈希分派到了相应的缓冲中，又有新的缓冲加入到系统中。哈希的结果应能够保证原有已分配的内容可以被映射到新的缓冲中去，而不会被映射到旧的缓冲集合中的其他缓冲区。容易看到，上面的简单求余算法hash(object)%N 难以满足单调性要求
      - 平滑性(Smoothness)：平滑性是指缓存服务器的数目平滑改变和缓存对象的平滑改变是一致的

   2. 一致性 Hash  原理

      1. 建构环形 hash  空间

         考虑通常的 hash 算法都是将 value 映射到一个 32 为的 key 值，也即是 0~2^32-1 次方的数值空间；我们可以将这个空间想象成一个首（ 0 ）尾（ 2^32-1 ）相接的圆环

      2. 把需要缓存的内容 ( 对象 ) 映射到 hash  空间

         接下来考虑 4 个对象 object1~object4 ，通过 hash 函数计算出的 hash 值 key 在环上的分布

      3. 把服务器 ( 节点 ) 映射到 hash  空间

         Consistent hashing 的基本思想就是将对象和 cache 都映射到同一个 hash 数值空间中，并且使用相同的 hash 算法。一般的方法可以使用 服务器(节点) 机器的 IP 地址或者机器名作为hash 输入

      4. 把对象映射到 服务节点

         现在服务节点和对象都已经通过同一个 hash 算法映射到 hash 数值空间中了，首先确定对象hash 值在环上的位置，从此位置沿环顺时针“行走”，第一台遇到的服务器就是其应该定位到的服务器

      5. 考察 cache  的变动

         通过 hash 然后求余的方法带来的最大问题就在于不能满足单调性，当 cache 有所变动时，cache 会失效

4. 

### 加密算法

1. AES

   高级加密标准(AES,Advanced Encryption Standard)为最常见的对称加密算法(微信小程序加密传输就是用这个加密算法的)。对称加密算法也就是加密和解密用相同的密钥，具体的加密流程如下
   ![image-20210806160317963](https://gitee.com/Sean0516/image/raw/master/img/image-20210806160317963.png)

2. RSA

   R SA 加密算法是一种典型的非对称加密算法，它基于大数的因式分解数学难题，它也是应用最广泛的非对称加密算法。
   非对称加密是通过两个密钥（公钥-私钥）来实现对数据的加密和解密的。公钥用于加密，私钥用于解密

   ![image-20210806160413225](https://gitee.com/Sean0516/image/raw/master/img/image-20210806160413225.png)

3. CRC

   循环冗余校验(Cyclic Redundancy Check, CRC)是一种根据网络数据包或电脑文件等数据产生简短固定位数校验码的一种散列函数，主要用来检测或校验数据传输或者保存后可能出现的错误。它是利用除法及余数的原理来作错误侦测的

4. MD5

   MD5 常常作为文件的签名出现，我们在下载文件的时候，常常会看到文件页面上附带一个扩展名为.MD5 的文本或者一行字符，这行字符就是就是把整个文件当作原数据通过 MD5 计算后的值，我们下载文件后，可以用检查文件 MD5 信息的软件对下载到的文件在进行一次计算。两次结果对比就可以确保下载到文件的准确性。 另一种常见用途就是网站敏感信息加密，比如用户名密码，支付签名等等。随着 https 技术的普及，现在的网站广泛采用前台明文传输到后台，MD5 加密（使用偏移量）的方式保护敏感数据保护站点和数据安全

5. 



