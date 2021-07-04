

### OOP 面向对象

1. 类和对象的关系

   类是对象的抽象，对象是类的具体，类是对象的模板，对象是类的实例

2. Java中的数据类型

   整形：byte,short,int,long
   浮点型：float,double
   字符型：char
   布尔型：boolean

3. instanceof 关键字的作用

   instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例，用法为

   ```java
   boolean result = obj instanceof Class
   ```

4. 什么是隐式转换，什么是显式转换

   显示转换就是类型强转，把一个大类型的数据强制赋值给小类型的数据；隐式转换就是大范围的变量能够接受小范围的数据；隐式转换和显
   式转换其实就是自动类型转换和强制类型转换

5. 什么是自动拆箱装箱

   装箱就是自动将基本数据类型转换为包装器类型 （int-->Integer）

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

   

6. 一个java 类中包含那些内容

   属性、方法、内部类、构造方法、代码块

7. String 是最基本的数据类型吗？

   不是。Java 中的基本数据类型只有 8 个：byte、short、int、long、float、double、 char、boolean；除了基本类型（primitive type），剩下的都是引用类型（reference type），Java 5 以后引入的枚举类型也算是一种比较特殊的引用类型

8. float f=3.4;是否正确 ？

   不正确。3.4 是双精度数，将双精度型（double）赋值给浮点型（float）属于 下转型（down-casting，也称为窄化）会造成精度损失，因此需要强制类型转换 float f =(float)3.4; 或者写成 float f =3.4F

9. short s1 = 1; s1 = s1 + 1;有错吗?short s1 = 1; s1 += 1; 有错吗？

   对于 short s1 = 1; s1 = s1 + 1;由于 1 是 int 类型，因此 s1+1 运算结果也是 int 型，需要强制转换类型才能赋值给 short 型。而 short s1 =1; s1 += 1;可以正确 编译，因为 s1+= 1;相当于 s1 = (short)(s1 + 1);其中有隐含的强制类型转换

10. 重载和重写的区别

    重写：

    在子类中把父类本身有的方法重新写一遍。子类继承了父类原有的方法，但有时子类并不想原封不动的继承父类中的某个方法，所以在方法名，参数列表，返回类型(除过子类中方法的返回值是父类中方法返回值的子类时)都相同的情况下， 对方法体进行修改或重写，这就是重写。但要注意子类函数的访问修饰权限不能少于父类的

    重载：

    在一个类中，同名的方法如果有不同的参数列表（参数类型不同、参数个数不同甚至是参数顺序不同）则视为重载。同时，重载对返回类型没有要求，可以相同也可以不同，但不能通过返回类型是否相同来判断重载

11. equals与==的区别

    - ==：

      == 比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。

      1. 比较的是操作符两端的操作数是否是同一个对象
      2. 两边的操作数必须是同一类型的（可以是父子类之间）才能编译通过
      3. 比较的是地址，如果是具体的阿拉伯数字的比较，值相等则为true，如：int a=10 与 long b=10L 与 double c=10.0都是相同的（为true），因为他们都指向地址为10的堆

    - equals

      equals用来比较的是两个对象的内容是否相等，由于所有的类都是继承自java.lang.Object类的，所以适用于所有对象，如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法，而Object中的equals方法返回的却是==的判断

    - 总结

      所有比较是否相等时，都是用equals 并且在对常量相比较时，把常量写在前面，因为使用object的equals object可能为null 则空指针

    

12.  ++i  和 i++ 的区别

    i++ ： 先赋值，后计算

    ++i : 先计算，后赋值

13. 数组实例化有几种方式

    - 静态实例化。 在创建数组的时候，指定数组中的元素
    - 动态实例化， 实例会数组的时候，只指定数组的长度，数组中所有的元素都是数组类型的默认值

14. Java 中各种数据默认值

    - Byte,short,int,long默认是都是0
    - Boolean默认值是false
    - Char类型的默认值是’’
    - Float与double类型的默认是0.0
    - 对象类型的默认值是null

15. java中有没有指针？

    有指针，但是隐藏了，开发人员无法直接操作指针，由jvm来操作指针

16. java中是值传递引用传递

    理论上说，java都是引用传递，对于基本数据类型，传递是值的副本，而不是值本身。对于对象类型，传递是对象的引用，当在一个方法操作操作参数的时候，其实操作的是引用所指向的对象

17. 形参和实参的区别

18. 构造方法能不能显式调用

    不能，构造方法当成普通方法调用，只有在创建对象的时候他才会被系统调用

19. 内部类和静态内部类的区别

    - 静态内部类

      1. 静态内部类相对与外部类是独立存在的，在静态内部类中无法直接访问外部类中变量，方法。 如果要访问的化，需要new 一个外部类的对象，使用new 出来的对象来访问。 但是可以直接访问静态的变量，调用静态的方法
      2. 如果其他类要访问静态内部类的属性或者调用静态内部类的方法，直接创建一个静态内部类对象即可

    - 普通内部类

      1. 普通内部类作为外部类一个成员而存在，在普通内部类中可以直接访问外部类的属性，调用外部类的方法
      2. 如果外部类要访问内部类的属性或者调用内部类的方法，必须要创建一个内部类的对象，使用该对象访问属性或方法
      3. 如果其他的类要访问普通内部类的属性或者调用普通内部类的方法，必须要在外部类中创建一个普通内部类的对象作为一个属性，外同类可以通过该属性调用普通内部类的方法或者访问普通内部类的属性

      

20. static 关键字的作用

    1. static 可以修改内部类，方法，变量，代码块
    2. static 修饰的类，是静态内部类
    3. static 修饰的方法是静态方法，表示该方法属于当前类。 而不属于某个对象，静态方法也不能被重写。 可以直接用类名来掉哦那个。 
    4. static 修饰变量是静态变量或者类变量。 静态变量被所有实例所共享。 不会依赖于对象， 静态变量在内存中只有一份拷贝，在JVM 加载类的时候，只为静态分配一次内存
    5. static 修饰的代码块叫做静态代码块。通常用来做程序优化。静态代码块中的代码在整个类加载的时候只会执行一次

21. final 在Java中的作用。

    1. 被final 修饰的类不可以被继承
    2. final 修饰的方法不能被重写
    3. final 修饰的变量不可以被改变。 如果修饰是的引用，则引用不可变，引用指向的内容可变
    4. final 修饰的方法,JVM 会尝试将其内联，以提高运行效率
    5. final修饰的常量，在编译阶段会存入常量池中

22. String str=”aaa”,与String str=new String(“aaa”)一样吗？

    ```java
    
    String x = "张三";
    String y = "张三";
    String z = new String("张三");
    System.out.println(x == y); // true
    System.out.println(x == z); // false
    ```

    String x = "张三" 的方式，Java 虚拟机会将其分配到常量池中，而常量池中没有重复的元素，比如当执行“张三”时，java虚拟机会先在常量池中检索是否已经有“张三”,如果有那么就将“张三”的地址赋给变量，如果没有就创建一个，然后在赋给变量；而 String z = new String(“张三”) 则会被分到堆内存中，即使内容一样还是会创建新的对象

23. 强引用，弱引用，软引用和虚引用

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

24. java 创建对象的几种方式

    1. new 创建新对象
    2. 通过反射机制
    3. 采用clone机制
    4. 通过序列化机制

25. 有没有可能两个不相等的对象有相同的hashcode

    在产生hash 冲突时，两个不相等的对象，就会有相同的hashcode 。 当hash 冲突产生时，一般用一下方法来处理

    1. 拉链法 。 每个hash 表节点都要有一个next 指针，多个哈希表节点可以用next 指针构成一个单向链表。 被分配到同一个索引上的多个节点可以用这个单向链表进行存储
    2. 开发定址法  一旦发生了冲突，就去寻找下一个空的散列地址，只要散列表足够大，空的散列表地址总能找到
    3. 再哈希:又叫双哈希法,有多个不同的Hash函数.当发生冲突时,使用第二个,第三个….等哈希函数计算地址,直到无冲突

26. a=a+b与a+=b有什么区别吗

    += 操作符会进行隐式自动类型转换,此处a+=b隐式的将加操作的结果类型强制转换为持有结果的类型, 而a=a+b则不会自动进行类型转换.

27. final、finalize()、finally

    1. final为关键字  final为用于标识常量的关键字，final标识的关键字存储在常量池中
    2. finalize 为方法  finalize()方法在Object中进行了定义，用于在对象“消失”时，由JVM进行调用用于对对象进行垃圾回收，类似于C++中的析构函数；用户自定义时，用于释放对象占用的资源（比如进行I/0操作）
    3. finally 为区块标志。 用于try catch 语句中  finally{}用于标识代码块，与try{}进行配合，不论try中的代码执行完或没有执行完（这里指有异常），该代码块之中的程序必定会进行

28. JDBC操作的步骤

    1. 加载数据库驱动类
    2. 打开数据库连接
    3. 执行sql语句
    4. 处理返回结果
    5. 关闭资源

29. 两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对

    不对，如果两个对象 x 和 y 满足 x.equals(y) == true，它们的哈希码（hash code）应当相同。Java 对于 eqauls 方法和 hashCode 方法是
    这样规定的：

    1. 如果两个 对象相同（equals 方法返回 true），那么它们的 hashCode 值一定要相同
    2. 如果两个对象的 hashCode 相同，它们并不一定相同。当然，你未必要按照要求去做，但是如果你违背了上述原则就会发现在使用容器时，相同的对象可以出现在 Set 集合中，同时增加新元素的效率会大大下降（对于使用哈希存储的系统，如果哈希码频繁的冲突将会造成存取性能急剧下降）

30. char 型变量中能不能存贮一个中文汉字，为什么？

    char 类型可以存储一个中文汉字，因为 Java 中使用的编码是 Unicode（不选择任何特定的编码，直接使用字符在字符集中的编号，这是统一的唯一方法），一个 char 类型占 2 个字节（16 比特），所以放一个中文是没问题的

31. 抽象的（abstract）方法是否可同时是静态的（static）,是否可同时是本地方法（native），是否可同时被 synchronized修饰

    都不能。抽象方法需要子类重写，而静态的方法是无法被重写的，因此二者是矛盾的。本地方法是由本地代码（如 C 代码）实现的方法，而抽象方法是没有实现的，也是矛盾的。synchronized 和方法的实现细节有关，抽象方法不涉及实现细节，因此也是相互矛盾的



### 集合

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
   2. nteger 和 String 对象都可以进行默认的 TreeSet 排序，而自定义类的对象是不可以的， 自己定义的类必须实现 Comparable 接口，并且覆写相应的 compareTo()函数，才可以正常使用。
   3. 在覆写 compare()函数时，要返回相应的值才能使 TreeSet 按照一定的规则来排序
   4. 比较此对象与指定对象的顺序。如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数

   

8. HashMap (数组+ 链表+ 红黑树)

   HashMap 根据键的 hashCode 值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的。 HashMap 最多只允许一条记录的键为 null，允许多条记录的值为 null。 HashMap 非线程安全，即任一时刻可以有多个线程同时写 HashMap，可能会导致数据的不一致。

   在 Java8 中， 当链表中的元素超过了 8 个以后，会将链表转换为红黑树，在这些位置进行查找的时候可以降低时间复杂度为 O(logN)

   ![](http://qvi33264o.hn-bkt.clouddn.com/img/hashmap.png)

   

9. ConcurrentHashMap

   结构和上面一致 。都使用了数组+ 链表+ 红黑树

10. HashTable（线程安全）

    Hashtable 是遗留类，很多映射的常用功能与 HashMap 类似，不同的是它承自 Dictionary 类，并且是线程安全的，任一时间只有一个线程能写 Hashtable，并发性不如 ConcurrentHashMap， Hashtable 不建议在新代码中使用，不需要线程安全的场合可以用 HashMap 替换，需要线程安全的场合可以用 ConcurrentHashMap 替换

11. TreeMap（可排序）

    TreeMap 实现 SortedMap 接口，能够把它保存的记录根据键排序，默认是按键值的升序排序，也可以指定排序的比较器，当用 Iterator 遍历 TreeMap 时，得到的记录是排过序的。如果使用排序的映射，建议使用 TreeMap。在使用 TreeMap 时， key 必须实现 Comparable 接口或者在构造 TreeMap 传入自定义的Comparator，否则会在运行时抛出 java.lang.ClassCastException 类型的异常



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

   

2. 类型通配符 ?  

   类 型 通 配 符 一 般 是 使 用 ? 代 替 具 体 的 类 型 参 数 。 例 如 List<?> 在 逻 辑 上 是List,List 等所有 List<具体类型实参>的父类

3. 类型擦除

   java 中的泛型基本上都是在编译器这个层次来实现的。在生成的 Java 字节代码中是不包含泛型中的类型信息的。使用泛型的时候加上的类
   型参数，会被编译器在编译的时候去掉。这个过程就称为类型擦除

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

6. Selector

   Selector 类是 NIO 的核心类， Selector 能够检测多个注册的通道上是否有事件发生，如果有事件发生，便获取事件然后针对每个事件进行相应的响应处理。这样一来，只是用一个单线程就可以管理多个通道，也就是管理多个连接。这样使得只有在连接真正有读写事件发生时，才会调用函数来进行读写，就大大地减少了系统开销，并且不必为每个连接都创建一个线程，不用去维护多个线程，并且避免了多线程之间的上下文切换导致的开销

### 反射

1. 反射的作用

   反射机制是在运行时，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意个对象，都能够调用它的任意一个方法。在java中，只要给定类的名字，就可以通过反射机制来获得类的所有信息

2.  反射类的组成

   - class  表示正在运行的Java应用程序中的类和接口
   - field 提供有关类和接口的属性信息，以及对他的动态访问权限
   - constructor 提供关于类的单个构造方法的信息以及它的访问权限
   - method  提供类或者接口中某个方法的信息

3. 反射的优缺点

   ###### 优点

   1. 能够动态获取类的实例，提高灵活性
   2. 与动态编译结合

   ###### 缺点

   1. 使用反射性能较低，需要解析字节码，将内存中的对象进行解析

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



### 多线程

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

   - newCachedThreadPool 
   - newFixedThreadPool
   - newScheduledThreadPool
   - newSingleThreadExecutor 

4. sleep()和wait() 有什么区别

   1. 对于 sleep()方法，我们首先要知道该方法是属于 Thread 类中的。而 wait()方法，则是属于Object 类中的
   2. sleep()方法导致了程序暂停执行指定的时间，让出 cpu 给其他线程，但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态 （不释放锁）
   3. 在调用 sleep()方法的过程中， 线程不会释放对象锁
   4. 而当调用 wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用 notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态

5. interrupted 和 isInterruptedd方法的区别

   1. interrupted() 和 isInterrupted()的主要区别是前者会将中断状态清除而后者不会。Java多线程的中断机制是用内部标识来实现的，调用Thread.interrupt()来中断一个线程就会设置中断标识为true
   2. 当中断线程调用静态方法Thread.interrupted()来检查中断状态时，中断状态会被清零
   3. 而非静态方法isInterrupted()用来查询其它线程的中断状态且不会改变中断状态标识。简单的说就是任何抛出InterruptedException异常的方法都会将中断状态清零。无论如何，一个线程的中断状态有有可能被其它线程调用中断来改变

6. synchronized 和 ReentrantLock 有什么不同

   1. 最大区别就是对于Synchronized来说，它是java语言的关键字，是原生语法层面的互斥，需要jvm实现。而ReentrantLock它是JDK 1.5之后提供的API层面的互斥锁，需要lock()和unlock()方法配合try/finally语句块来完成
   2. Synchronized进过编译，会在同步块的前后分别形成monitorenter和monitorexit这个两个字节码指令。在执行monitorenter指令时，首先要尝试获取对象锁。如果这个对象没被锁定，或者当前线程已经拥有了那个对象锁，把锁的计算器加1，相应的，在执行monitorexit指令时会将锁计算器就减1，当计算器为0时，锁就被释放了。如果获取对象锁失败，那当前线程就要阻塞，直到对象锁被另一个线程释放为止 
   3. ，相比Synchronized，ReentrantLock类提供了一些高级功能，主要有以下3项
      - 等待可中断，持有锁的线程长期不释放的时候，正在等待的线程可以选择放弃等待，这相当于Synchronized来说可以避免出现死锁的情况
      - 公平锁，多个线程等待同一个锁时，必须按照申请锁的时间顺序获得锁，Synchronized锁非公平锁，ReentrantLock默认的构造函数是创建的非公平锁，可以通过参数true设为公平锁，但公平锁表现的性能不是很好
      - 锁绑定多个条件，一个ReentrantLock对象可以同时绑定对个对象

7. 如何保证多个线程顺序执行

   在多线程中有多种方法让线程按特定顺序执行，你可以用线程类的join()方法在一个线程中启动另一个线程，另外一个线程完成该线程继续执行。

8. SynchronizedMap和ConcurrentHashMap有什么区别

   SynchronizedMap()和Hashtable一样，实现上在调用map所有方法时，都对整个map进行同步。而ConcurrentHashMap的实现却更加精细，它对map中的所有桶加了锁。所以，只要有一个线程访问map，其他线程就无法进入map，而如果一个线程在访问ConcurrentHashMap某个桶时，其他线程，仍然可以对map执行某些操作。

   所以，ConcurrentHashMap在性能以及安全性方面，明显比Collections.synchronizedMap()更加有优势。同时，同步操作精确控制到桶，这样，即使在遍历map时，如果其他线程试图对map进行数据修改，也不会抛出ConcurrentModificationException

9. Thread类中的yield方法有什么作用

   Yield方法可以暂停当前正在执行的线程对象，让其它有相同优先级的线程执行。它是一个静态方法而且只保证当前线程放弃CPU占用而不能保证使其它线程一定能占用CPU，执行yield()的线程有可能在进入到暂停状态后马上又被执行

10. 说说自己是怎么使用 synchronized 关键字

    修饰实例方法: 作用于当前对象实例加锁，进入同步代码前要获得当前对象实例的锁

    修饰静态方法: 也就是给当前类加锁，会作用于类的所有对象实例，因为静态成员不属于任何一个实例对象，是类成员（ static 表明这是该类的一个静态资源，不管new了多少个对象，只有一份）。所以如果一个线程A调用一个实例对象的非静态 synchronized 方法，而线程B需要调用这个实例对象所属类的静态 synchronized 方法，是允许的，不会发生互斥现象，因为访问静态 synchronized 方法占用的锁是当前类的锁，而访问非静态synchronized 方法占用的锁是当前实例对象锁。

    修饰代码块: 指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。

11. volatile关键字的作用

    一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：

    1. 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
    2. 禁止进行指令重排序

    - volatile本质是在告诉jvm当前变量在寄存器（工作内存）中的值是不确定的，需要从主存中读取；synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住
    - volatile仅能使用在变量级别；synchronized则可以使用在变量、方法、和类级别的
    - volatile仅能实现变量的修改可见性，并不能保证原子性；synchronized则可以保证变量的修改可见性和原子性
    - volatile不会造成线程的阻塞；synchronized可能会造成线程的阻塞
    - volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化

    

12. Synchronized 同步锁

13. ReentrantLock

14. Condition 类和 Object 类锁方法区别区别

    1. Condition 类的 awiat 方法和 Object 类的 wait 方法等效
    2. Condition 类的 signal 方法和 Object 类的 notify 方法等效
    3. Condition 类的 signalAll 方法和 Object 类的 notifyAll 方法等效
    4. ReentrantLock 类可以唤醒指定条件的线程，而 object 的唤醒是随机的

15. tryLock 和 lock 和 lockInterruptibly 的区别

    1. tryLock 能获得锁就返回 true，不能就立即返回 false， tryLock(long timeout,TimeUnit
    unit)，可以增加时间限制，如果超过该时间段还没获得锁，返回 false
    2. lock 能获得锁就返回 true，不能的话一直等待获得锁
    3. lock 和 lockInterruptibly，如果两个线程分别执行这两个方法，但此时中断这两个线程，
    lock 不会抛出异常，而 lockInterruptibly 会抛出异常

16. ReadWriteLock 读写锁

    为了提高性能， Java 提供了读写锁，在读的地方使用读锁，在写的地方使用写锁，灵活控制，如果没有写锁的情况下，读是无阻塞的,在一定程度上提高了程序的执行效率。 读写锁分为读锁和写锁，多个读锁不互斥，读锁与写锁互斥，这是由 jvm 自己控制的，你只要上好相应的锁即可

17. 共享锁和独占锁  （java 并发包提供的加锁模式分为独占锁和共享锁）

    ###### 独占锁

    独占锁模式下，每次只能有一个线程能持有锁， ReentrantLock 就是以独占方式实现的互斥锁。独占锁是一种悲观保守的加锁策略，它避免了读/读冲突，如果某个只读线程获取锁，则其他读线程都只能等待，这种情况下就限制了不必要的并发性，因为读操作并不会影响数据的一致性

    ###### 共享锁

    共享锁则允许多个线程同时获取锁，并发访问 共享资源，如： ReadWriteLock。 共享锁则是一种乐观锁，它放宽了加锁策略，允许多个执行读操作的线程同时访问共享资源

18. 重量级锁（Mutex Lock）

    Synchronized 是通过对象内部的一个叫做监视器锁（monitor）来实现的。但是监视器锁本质又是依赖于底层的操作系统的 Mutex Lock 来实现的

    操作系统实现线程之间的切换这就需要从用户态转换到核心态，这个成本非常高，状态之间的转换需要相对比较长的时间，这就是为什么
    Synchronized 效率低的原因。因此， 这种依赖于操作系统 Mutex Lock 所实现的锁我们称之为“重量级锁” 。 JDK 中对 Synchronized 做的种种优化，其核心都是为了减少这种重量级锁的使用

    JDK1.6 以后，为了减少获得锁和释放锁所带来的性能消耗，提高性能，引入了“轻量级锁”和“偏向锁”

19. 轻量级锁

    

20. ThreadPoolExecutor 的构造方法

    1. corePoolSize：指定了线程池中的线程数量。
    2. maximumPoolSize：指定了线程池中的最大线程数量。
    3. keepAliveTime：当前线程池数量超过 corePoolSize 时，多余的空闲线程的存活时间，即多次时间内会被销毁。
    4. unit： keepAliveTime 的单位。
    5. workQueue：任务队列，被提交但尚未被执行的任务。
    6. threadFactory：线程工厂，用于创建线程，一般用默认的即可。
    7. handler：拒绝策略，当任务太多来不及处理，如何拒绝任务。

21. 拒绝策略

    当线程池中的线程已经用完了，无法继续为新任务服务，同时，等待队列也已经排满了，再也塞不下新任务了。这时候我们就需要拒绝策略机制合理的处理这个问题。JDK 内置的拒绝策略如下

    1. AbortPolicy ： 直接抛出异常，阻止系统正常运行。

    2. CallerRunsPolicy ： 只要线程池未关闭，该策略直接在调用者线程中，运行当前被丢弃的任务。显然这样做不会真的丢弃任务，但是，任务提交线程的性能极有可能会急剧下降。

    3. DiscardOldestPolicy ： 丢弃最老的一个请求，也就是即将被执行的一个任务，并尝试再次提交当前任务。

    4. DiscardPolicy ： 该策略默默地丢弃无法处理的任务，不予任何处理。如果允许任务丢失，这是最好的一种方案。

      以上内置拒绝策略均实现了 RejectedExecutionHandler 接口，若以上策略仍无法满足实际需要，完全可以自己扩展 RejectedExecutionHandler 接口。

22. Java 线程池工作过程

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

23. Java 中的阻塞队列

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

    6. LinkedTransferQueue：由链表结构组成的无界阻塞队列。

    7. LinkedBlockingDeque：由链表结构组成的双向阻塞队列

24. 什么是多线程中的上下文切换

    多线程会共同使用一组计算机上的 CPU，而线程数大于给程序分配的 CPU 数量时，为了让各个线程都有执行的机会，就需要轮转使用 CPU。不同的线程切换使用 CPU发生的切换数据等就是上下文切换

25. 死锁与活锁的区别，死锁与饥饿的区别

    

26. 在 Java 中 CycliBarriar 和 CountdownLatch 有什么区别

    CyclicBarrier 可以重复使用，而 CountdownLatch 不能重复使用。 Java 的 concurrent 包里面的 CountDownLatch 其实可以把它看作一个计数器，只不过这个计数器的操作是原子操作，同时只能有一个线程去操作这个计数器，也就是同时只能有一个线程去减这个计数器里面的值。你可以向 CountDownLatch 对象设置一个初始的数字作为计数值，任何调用这个对象上的 await()方法都会阻塞，直到这个计数器的计数值被其他的线程减为 0 为止。

    

    所以在当前计数到达零之前，await 方法会一直受阻塞。之后，会释放所有等待的线程，await 的所有后续调用都将立即返回。这种现象只出现一次——计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier。

    CountDownLatch 的一个非常典型的应用场景是：有一个任务想要往下执行，但必须要等到其他的任务执行完毕后才可以继续往下执行。假如我们这个想要继续往下执行的任务调用一个 CountDownLatch 对象的 await()方法，其他的任务执行完自己的任务后调用同一个CountDownLatch 对象上的 countDown()方法，这个调用 await()方法的任务将一直阻塞等待，直到这个 CountDownLatch 对象的计数值减到 0 为止。

    CyclicBarrier 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。因为该 barrie在释放等待线程后可以重用，所以称它为循环 的barrier。

### JVM

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

8. 新生代

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

9. 老年代

   主要存放应用程序中生命周期长的内存对象。
   老年代的对象比较稳定，所以 MajorGC 不会频繁执行。在进行 MajorGC 前一般都先进行了一次 MinorGC，使得有新生代的对象晋身入老年代，导致空间够用时才触发。当无法找到足够大的连续空间分配给新创建的较大对象时也会提前触发一次 MajorGC 进行垃圾回收腾出空间。

   MajorGC 采用标记清除算法：首先扫描一次所有老年代，标记出存活的对象，然后回收没有标记的对象。 ajorGC 的耗时比较长，因为要扫描再回收。MajorGC 会产生内存碎片，为了减少内存损耗，我们一般需要进行合并或者标记出来方便下次直接分配。当老年代也满了装不下的时候，就会抛出OOM（Out of Memory）异常。

   

10. 永久代 与 元数据（JAVA8）

    指内存的永久保存区域，主要存放 Class 和 Meta（元数据）的信息,Class 在被加载的时候被放入永久区域， 它和和存放实例的区域不同,GC不会在主程序运行期对永久区域进行清理。所以这也导致了永久代的区域会随着加载的 Class 的增多而胀满，最终抛出 OOM 异常

    

    在 Java8 中， 永久代已经被移除，被一个称为“元数据区”（元空间）的区域所取代。元空间的本质和永久代类似，元空间与永久代之间最大的区别在于： 元空间并不在虚拟机中，而是使用本地内存。因此，默认情况下，元空间的大小仅受本地内存限制。 类的元数据放入nativememory, 字符串池和类的静态变量放入 java 堆中， 这样可以加载多少类的元数据就不再由MaxPermSize 控制, 而由系统的实际可用空间来控制。

    

11. 如何判断对象可以被回收

    1. 引用计数法

       在 Java 中，引用和对象是有关联的。如果要操作对象则必须用引用进行。因此，很显然一个简单的办法是通过引用计数来判断一个对象是否可以回收。简单说，即一个对象如果没有任何与之关联的引用， 即他们的引用计数都不为 0， 则说明对象不太可能再被用到，那么这个对象就是可回收对象

    2. 可达性分析

       为了解决引用计数法的循环引用问题， Java 使用了可达性分析的方法。通过一系列的“GC roots”对象作为起点搜索。如果在“GC roots”和一个对象之间没有可达路径，则称该对象是不可达的。要注意的是，不可达对象不等价于可回收对象， 不可达对象变为可回收对象至少要经过两次标记过程。两次标记后仍然是可回收对象，则将面临回收

12. 垃圾回收算法

    - 标记清除算法

      最基础的垃圾回收算法，分为两个阶段，标注和清除。标记阶段标记出所有需要回收的对象，清除阶段回收被标记的对象所占用的空间。  该算法最大的问题是内存碎片化严重，后续可能发生大对象不能找到可利用空间的问题

    - 复制算法（copying）

      为了解决 Mark-Sweep 算法内存碎片化的缺陷而被提出的算法。按内存容量将内存划分为等大小的两块。每次只使用其中一块，当这一块内存满后将尚存活的对象复制到另一块上去，把已使用的内存清掉

      这种算法虽然实现简单，内存效率高，不易产生碎片，但是最大的问题是可用内存被压缩到了原本的一半。且存活对象增多的话， Copying算法的效率会大大降低

    - 标记整理算法(Mark-Compact)

      结合了以上两个算法，为了避免缺陷而提出。标记阶段和 Mark-Sweep 算法相同， 标记后不是清理对象，而是将存活对象移向内存的一端。然后清除端边界外的对象

    - 分代收集算法

      分代收集法是目前大部分 JVM 所采用的方法，其核心思想是根据对象存活的不同生命周期将内存划分为不同的域，一般情况下将 GC 堆划分为老生代(Tenured/Old Generation)和新生代(YoungGeneration)。老生代的特点是每次垃圾回收时只有少量对象需要被回收，新生代的特点是每次垃圾回收时都有大量垃圾需要被回收，因此可以根据不同区域选择不同的算法

13.  新生代与复制算法

    目前大部分 JVM 的 GC 对于新生代都采取 Copying 算法，因为新生代中每次垃圾回收都要回收大部分对象，即要复制的操作比较少，但通常并不是按照 1： 1 来划分新生代。一般将新生代划分为一块较大的 Eden 空间和两个较小的 Survivor 空间(From Space, To Space)，每次使用Eden 空间和其中的一块 Survivor 空间，当进行回收时，将该两块空间中还存活的对象复制到另一块 Survivor 空间中

14. 老年代与标记复制算法

    因为对象存活率高、没有额外空间对它进行分配担保, 就必须采用“标记—清理”或“标记—整理” 算法来进行回收, 不必进行内存复制, 且直接腾
    出空闲内存

15. GC 垃圾收集器

    ![image-20210630141113554](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210630141113554.png)

    - Serial 垃圾收集器（单线程、 复制算法）
    - ParNew 垃圾收集器（Serial+多线程）

16. JVM 类加载机制

    JVM 类加载机制分为五个部分： 加载 ，验证，准备，解析， 初始化

    ###### 加载

    加载是类加载过程中的一个阶段， 这个阶段会在内存中生成一个代表这个类的 java.lang.Class 对象， 作为方法区这个类的各种数据的入口。注意这里不一定非得要从一个 Class 文件获取，这里既可以从 ZIP 包中读取（比如从 jar 包和 war 包中读取），也可以在运行时计算生成（动态代理），也可以由其它文件生成（比如将 JSP 文件转换成对应的 Class 类）

    ###### 验证

    这一阶段的主要目的是为了确保 Class 文件的字节流中包含的信息是否符合当前虚拟机的要求，并且不会危害虚拟机自身的安全、

    ###### 准备

    准备阶段是正式为类变量分配内存并设置类变量的初始值阶段，即在方法区中分配这些变量所使用的内存空间。注意这里所说的初始值概念

    ###### 解析

    解析阶段是指虚拟机将常量池中的符号引用替换为直接引用的过程

    ###### 初始化

    初始化阶段是类加载最后一个阶段，前面的类加载阶段之后，除了在加载阶段可以自定义类加载器以外，其它操作都由 JVM 主导。到了初始阶段，才开始真正执行类中定义的 Java 程序代码

17. 类加载器

    虚拟机设计团队把加载动作放到 JVM 外部实现，以便让应用程序决定如何获取所需的类， JVM 提供了 3 种类加载器：

    ###### 启动类加载器(Bootstrap ClassLoader)

    负责加载 JAVA_HOME\lib 目录中的， 或通过-Xbootclasspath 参数指定路径中的， 且被虚拟机认可（按文件名识别， 如 rt.jar） 的类。

    ###### 扩展类加载器(Extension ClassLoader)

    负责加载 JAVA_HOME\lib\ext 目录中的，或通过 java.ext.dirs 系统变量指定路径中的类库。

    ###### 应用程序类加载器(Application ClassLoader)：

    负责加载用户路径（classpath）上的类库。JVM 通过双亲委派模型进行类的加载， 当然我们也可以通过继承 java.lang.ClassLoader实现自定义的类加载器。

    ![image-20210630142521914](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210630142521914.png)

18. 双亲委派机制

    当一个类收到了类加载请求，他首先不会尝试自己去加载这个类，而是把这个请求委派给父类去完成，每一个层次类加载器都是如此，因此所有的加载请求都应该传送到启动类加载其中，只有当父类加载器反馈自己无法完成这个请求的时候（在它的加载路径下没有找到所需加载的Class）， 子类加载器才会尝试自己去加载。

    采用双亲委派的一个好处是比如加载位于 rt.jar 包中的类 java.lang.Object，不管是哪个加载器加载这个类，最终都是委托给顶层的启动类加载器进行加载，这样就保证了使用不同的类加载器最终得到的都是同样一个 Object 对象

    ![image-20210630142606545](http://qvi33264o.hn-bkt.clouddn.com/img/image-20210630142606545.png)

19. 什么时候会触发FullGC

    ##### 旧生代空间不足

    旧生代空间只有在新生代对象转入及创建为大对象、大数组时才会出现不足的现象，当执行Full GC后空间仍然不足，则抛出如下错误：java.lang.OutOfMemoryError: Java heap space

20. 对象分配规则

    1. 对象优先分配在Eden区，如果Eden区没有足够的空间时，虚拟机执行一次Minor GC。
    2. 大对象直接进入老年代（大对象是指需要大量连续内存空间的对象）。这样做的目的是避免在Eden区和两个Survivor区之间发生大量的内存拷贝（新生代采用复制算法收集内存）。
    3. 长期存活的对象进入老年代。虚拟机为每个对象定义了一个年龄计数器，如果对象经过了1次Minor GC那么对象会进入Survivor区，之后每经过一次Minor GC那么对象的年龄加1，知道达到阀值对象进入老年区。
    4. 动态判断对象的年龄。如果Survivor区中相同年龄的所有对象大小的总和大于Survivor空间的一半，年龄大于或等于该年龄的对象可以直接进入老年代。
    5. 空间分配担保。每次进行Minor GC时，JVM会计算Survivor区移至老年区的对象的平均大小，如果这个值大于老年区的剩余值大小则进行一次Full GC，如果小于检查HandlePromotionFailure设置，如果true则只进行Monitor GC,如果false则进行Full GC、

21. Java对象创建过程

    1. JVM遇到一条新建对象的指令时首先去检查这个指令的参数是否能在常量池中定义到一个类的符号引用。然后加载这个类

    2. 为对象分配内存。一种办法“指针碰撞”、一种办法“空闲列表”，最终常用的办法“本地线程缓冲分配(TLAB)”

    3. 将除对象头外的对象内存空间初始化为0

    4. 对对象头进行必要设置

22. 简述Java的对象结构

    Java对象由三个部分组成：对象头、实例数据、对齐填充。

    1. 对象头由两部分组成，第一部分存储对象自身的运行时数据：哈希码、GC分代年龄、锁标识状态、线程持有的锁、偏向线程ID（一般占32/64 bit）
    2. 第二部分是指针类型，指向对象的类元数据类型（即对象代表哪个类）。如果是数组对象，则对象头中还有一部分用来记录数组长度。
    3. 实例数据用来存储对象真正的有效信息（包括父类继承下来的和自己定义的）对齐填充：JVM要求对象起始地址必须是8字节的整数倍（8字节对齐

23. 你知道哪些JVM性能调优

    设定堆内存大小   -Xmx：堆内存最大限制。
    设定新生代大小。 新生代不宜太小，否则会有大量对象涌入老年代
    -XX:NewSize：新生代大小
    -XX:NewRatio 新生代和老生代占比
    -XX:SurvivorRatio：Eden 区和survivor空间的占比
    设定垃圾回收器 年轻代用 -XX:+UseParNewGC 年老代用-XX:+UseConcMarkSweepGC

### Spring

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

9. @Qualifier 注解有什么用当您创建多个相同类型的 bean 并希望仅使用属性装配其中一个 bean 时，您可以使用@Qualifier 注解和 @Autowired 通过指定应该装配哪个确切的 bean来消除歧义

10. @RequestMapping 注解有什么用

    @RequestMapping 注解用于将特定 HTTP 请求方法映射到将处理相应请求的控制器中的特定类/方法。 此注释可应用于两个级别：
    类级别：映射请求的 URL 

    方法级别：映射 URL 以及 HTTP 请求方法

11. 有哪些类型的AOP通知（Advice）

    1. Before - 这些类型的 Advice 在 joinpoint 方法之前执行，并使用@Before 注解标记进行配置。
    2.  After Returning - 这些类型的 Advice 在连接点方法正常执行后执行，并使用@AfterReturning 注解标记进行配置。
    3.  After Throwing - 这些类型的 Advice 仅在 joinpoint 方法通过抛出异常退出并使用 @AfterThrowing 注解标记配置时执行。
    4.  After (finally) - 这些类型的 Advice 在连接点方法之后执行，无论方法退出是正常还是异常返回，并使用 @After 注解标记进行配置。
    5.  Around - 这些类型的 Advice 在连接点之前和之后执行，并使用@Around 注解标记进行配置

12. Spring MVC 组件

    1. DispatcherServlet：作为前端控制器，整个流程控制的中心，控制其它组件执行，统一调度，降低组件之间的耦合性，提高每个组件的扩展
    2. HandlerMapping：通过扩展处理器映射器实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等。
    3. HandlAdapter：通过扩展处理器适配器，支持更多类型的处理器。
    4. ViewResolver：通过扩展视图解析器，支持更多类型的视图解析，例如：jsp、freemarker、pdf、excel等

13. DispatcherServlet 的工作流程

    ![image-20210630153343101](C:\Users\Sean\AppData\Roaming\Typora\typora-user-images\image-20210630153343101.png)

    1. 向服务器发送 HTTP 请求，请求被前端控制器 DispatcherServlet 捕获。
    2.  DispatcherServlet 根据 -servlet.xml 中的配置对请求的 URL 进行解析，得到请求资源标识符（URI）。然后根据该 URI，调用HandlerMapping获得该 Handler 配置的所有相关的对象（包括 Handler 对象以及 Handler 对象对应的拦截器），最后以 HandlerExecutionChain 对象的形式返回。
    3.  DispatcherServlet 根据获得的 Handler，选择一个合适的HandlerAdapter。（附注：如果成功获得 HandlerAdapter 后，此时将开始执行拦截器的 preHandler(...)方法）。
    4. 提取 Request 中的模型数据，填充 Handler 入参，开始执行 Handler（ Controller)。在填充 Handler 的入参过程中，根据你的配置，Spring 将帮你做一些额外的工作：
       -  HttpMessageConveter：将请求消息（如 Json、xml 等数据）转换成一个对象，将对象转换为指定的响应信息
       -  数据转换：对请求消息进行数据转换。如 String 转换成 Integer、Double 等。
       -  数据根式化：对请求消息进行数据格式化。如将字符串转换成格式化数字或格式化日期等。
       -  数据验证：验证数据的有效性（长度、格式等），验证结果存储到BindingResult 或 Error 中。
    5. Handler(Controller)执行完成后，向 DispatcherServlet 返回一个ModelAndView 对象；
    6. 根据返回的 ModelAndView，选择一个适合的 ViewResolver（必须是已经注册到 Spring 容器中的 ViewResolver)返回给DispatcherServlet。
    7. ViewResolver 结合 Model 和 View，来渲染视图。
    8. 视图负责将渲染结果返回给客户端。

14. Spring中Autowired和Resource关键字的区别

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

15. Spring框架中都用到了哪些设计模式

    （1）工厂模式：BeanFactory就是简单工厂模式的体现，用来创建对象的实例；
    （2）单例模式：Bean默认为单例模式。
    （3）代理模式：Spring的AOP功能用到了JDK的动态代理和CGLIB字节码生成技术；
    （4）模板方法：用来解决代码重复的问题。比如. RestTemplate, JmsTemplate, JpaTemplate。
    （5）观察者模式：定义对象键一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都会得到通知被制动更新，如Spring中listener的实现--ApplicationListener

16. 哪些是重要的 bean 生命周期方法？

    有两个重要的 bean 生命周期方法，第一个是 setup ， 它是在容器加载 bean的时候被调用。第二个方法是 teardown 它是在容器卸载类的时候被调用。The bean 标签有两个重要的属性（init-method 和 destroy-method）。用它们你可以自己定制初始化和注销方法。它们也有相应的注解（@PostConstruct 和@PreDestroy）

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

### Spring Cloud 

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

5. 什么是 MyBatis 的接口绑定？有哪些实现方式

   接口绑定，就是在 MyBatis 中任意定义接口,然后把接口里面的方法和 SQL 语句绑定, 我们直接调用接口方法就可以,这样比起原来了 SqlSession 提供的方法我们可以有更加灵活的选择和设置。

   接口绑定有两种实现方式

   一种是通过注解绑定，就是在接口的方法上面加上@Select、@Update 等注解，里面包含 Sql 语句来绑定；

   另外一种就是通过 xml里面写 SQL 来绑定,在这种情况下,要指定 xml 映射文件里面的 namespace 必须为接口的全路径名。当 Sql 语句比较简单时候,用注解绑定, 当 SQL 语句比较复杂时候,用 xml 绑定,一般用 xml 绑定的比较多

   

### Zookeeper 

1. ZooKeeper 是一个开放源码的分布式协调服务，它是集群的管理者，监视着集群中各个节点的状态根据节点提交的反馈进行下一步合理操作。最终，将简单易用的接口和性能高效、功能稳定的系统提供给用户。分布式应用程序可以基于 Zookeeper 实现诸如数据发布/订阅、负载均衡、命名服务、分布式协调/通知、集群管理Master 选举、分布式锁和分布式队列等功能

2. Zookeeper 文件系统

   Zookeeper 提供一个多层级的节点命名空间（节点称为 znode）。与文件系统不同的是，这些节点都可以设置关联的数据，而文件系统中只有文件节点可以存放数据而目录节点不行

   Zookeeper 为了保证高吞吐和低延迟，在内存中维护了这个树状的目录结构，这种特性使得 Zookeeper 不能用于存放大量的数据，每个节点的存放数据上限为1M

3. 四种类型的数据节点 Znode

   ###### PERSISTENT-持久节点

   除非手动删除，否则节点一直存在于 Zookeeper 上

   ###### EPHEMERAL-临时节点

   临时节点的生命周期与客户端会话绑定，一旦客户端会话失效（客户端与zookeeper 连接断开不一定会话失效），那么这个客户端创建的所有临时节点都会被移除

   ###### PERSISTENT_SEQUENTIAL-持久顺序节点

   基本特性同持久节点，只是增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字

   ###### EPHEMERAL_SEQUENTIAL-临时顺序节点

   基本特性同临时节点，增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字

4. ZAB 协议

   ZAB 协议是为分布式协调服务 Zookeeper 专门设计的一种支持崩溃恢复的原子广播协议  ZAB 协议包括两种基本的模式：崩溃恢复和消息广播

   

   当整个 zookeeper 集群刚刚启动或者 Leader 服务器宕机、重启或者网络故障导致不存在过半的服务器与 Leader 服务器保持正常通信时，所有进程（服务器）进入崩溃恢复模式，首先选举产生新的 Leader 服务器，然后集群中 Follower 服务器开始与新的 Leader 服务器进行数据同步

   当集群中超过半数机器与该 Leader服务器完成数据同步之后，退出恢复模式进入消息广播模式，Leader 服务器开始接收客户端的事务请求生成事物提案来进行事务请求处理

5. Zookeeper Watcher 机制 （ 数据变更通知）

   Zookeeper 允许客户端向服务端的某个 Znode 注册一个 Watcher 监听，当服务端的一些指定事件触发了这个 Watcher，服务端会向指定客户端发送一个事件通知来实现分布式的通知功能，然后客户端根据 Watcher 通知状态和事件类型做出业务上的改变

6. watcher 的工作机制

   - 客户端注册watcher
   - 服务端处理watcher
   - 客户端回调watcher

7. Watcher 特性总结

   1. 一次性

      无论是服务端还是客户端，一旦一个watcher 被触发，zookeeper 都会将其从相应的存储中移除，再次使用需要重新注册。 这样的设计有效的减轻了服务端的压力，不然对于更新非常频繁的节点，服务端会不断的向客户端发送事件通知，无论对于网络还是服务端的压力都非常大。 

   2. 客户端串行执行

      客户端watcher 回调的过程是一个串行同步的过程，只有回调后客户端才能看到最新的数据状态。一个Watcher回调逻辑不应该太多，以免影响别的watcher执行

   3. 轻量级

      WatchEvent是最小的通信单元，结构上只包含通知状态、事件类型和节点路径，并不会告诉数据节点变化前后的具体内容

   4. 时效性

      Watcher只有在当前session彻底失效时才会无效，若在session有效期内快速重连成功，则watcher依然存在，仍可接收到通知

8. 客户端注册 Watcher 实现

   1. 调用 getData()/getChildren()/exist()三个 API，传入 Watcher 对象
   2. 标记请求 request，封装 Watcher 到 WatchRegistration
   3. 封装成 Packet 对象，发服务端发送 request
   4. 收到服务端响应后，将 Watcher 注册到 ZKWatcherManager 中进行管理
   5. 请求返回，完成注册

9. 服务端处理 Watcher 实现

   1. 服务端接收 Watcher 并存储
      	接收到客户端请求，处理请求判断是否需要注册 Watcher，需要的话将数据节点的节点路径和 ServerCnxn（ServerCnxn 代表一个客户端和服务端的连接，实现了 Watcher 的process 接口，此时可以看成一个 Watcher 对象）存储在WatcherManager 的 WatchTable 和 watch2Paths 中去

   2. Watcher 触发

   3. 调用 process 方法来触发 Watcher

      这里 process 主要就是通过 ServerCnxn 对应的 TCP 连接发送 Watcher 事件通知

10. 客户端回调 Watcher

    客户端 SendThread 线程接收事件通知，交由 EventThread 线程回调 Watcher。客户端的 Watcher 机制同样是一次性的，一旦被触发后，该 Watcher 就失效了

11. Zookeeper 服务器角色

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

12. Zookeeper 下 Server 工作状态

    服务器具有四种状态，分别是 LOOKING、FOLLOWING、LEADING、OBSERVING。

    1. LOOKING：寻找 Leader 状态。当服务器处于该状态时，它会认为当前集群中没有 Leader，因此需要进入 Leader 选举状态。
    2. FOLLOWING：跟随者状态。表明当前服务器角色是 Follower。
    3. LEADING：领导者状态。表明当前服务器角色是 Leader。
    4. OBSERVING：观察者状态。表明当前服务器角色是 Observer

13. 数据同步

    整个集群完成 Leader 选举之后，Learner（Follower 和 Observer 的统称）回向Leader 服务器进行注册。当 Learner 服务器想 Leader 服务器完成注册后，进入数据同步环节

    ##### 数据同步流程：（均以消息传递的方式进行）

    1. Learner 向 Learder 注册
    2. 数据同步
    3. 同步确认

14. Zookeeper 的数据同步种类

    1. 直接差异化同步（DIFF 同步）
    2. 先回滚再差异化同步（TRUNC+DIFF 同步）
    3. 仅回滚同步（TRUNC 同步）
    4. 全量同步（SNAP 同步

15. zookeeper 是如何保证事务的顺序一致性的

    zookeeper 采用了全局递增的事务 Id 来标识，所有的 proposal（提议）都在被提出的时候加上了 zxid，zxid 实际上是一个 64 位的数字，高 32 位是 epoch（时期; 纪元; 世; 新时代）用来标识 leader 周期，如果有新的 leader 产生出来，epoch会自增，低 32 位用来递增计数。当新产生 proposal 的时候，会依据数据库的两阶段过程，首先会向其他的server 发出事务执行请求，如果超过半数的机器都能执行并且能够成功，那么就会开始执行

16. zk 节点宕机如何处理、

    Zookeeper 本身也是集群，推荐配置不少于 3 个服务器。Zookeeper 自身也要保证当一个节点宕机时，其他节点会继续提供服务。

    如果是一个 Follower 宕机，还有 2 台服务器提供访问，因为 Zookeeper 上的数据是有多个副本的，数据并不会丢失；
    如果是一个 Leader 宕机，Zookeeper 会选举出新的 Leader。

    ZK 集群的机制是只要超过半数的节点正常，集群就能正常提供服务。只有在 ZK节点挂得太多，只剩一半或不到一半节点能工作，集群才失效。

    所以3 个节点的 cluster 可以挂掉 1 个节点(leader 可以得到 2 票>1.5)
    2 个节点的 cluster 就不能挂掉任何 1 个节点了(leader 可以得到 1 票<=1)

17. 分布式集群中为什么会有 Master、

    在分布式环境中，有些业务逻辑只需要集群中的某一台机器进行执行，其他的机器可以共享这个结果，这样可以大大减少重复计算，提高性能，于是就需要进行leader 选举

18. Zookeeper 分布式锁

    有了 zookeeper 的一致性文件系统，锁的问题变得容易。锁服务可以分为两类，一个是保持独占，另一个是控制时序 对于第一类，我们将 zookeeper 上的一个 znode 看作是一把锁，通过 createznode的方式来实现。所有客户端都去创建 /distribute_lock 节点，最终成功创建的那个客户端也即拥有了这把锁。用完删除掉自己创建的 distribute_lock 节点就释放出锁。

    对于第二类， /distribute_lock 已经预先存在，所有客户端在它下面创建临时顺序编号目录节点，和选 master 一样，编号最小的获得锁，用完删除，依次方便

19. epoch

    epoch：可以理解为当前集群所处的年代或者周期，每个 leader 就像皇帝，都有自己的年号，所以每次改朝换代， leader 变更之后，都会在前一个年代的基础上加 1。这样就算旧的 leader 崩溃恢复之后，也没有人听他的了，因为 follower 只听从当前年代的 leader 的命令

20. 投票机制

    ​	每个 sever 首先给自己投票， 然后用自己的选票和其他 sever 选票对比， 权重大的胜出，使用权重较大的更新自身选票箱。 具体选举过程如下

    1. 每个 Server 启动以后都询问其它的 Server 它要投票给谁。对于其他 server 的询问，server 每次根据自己的状态都回复自己推荐的 leader 的 id 和上一次处理事务的
    zxid（系统启动时每个 server 都会推荐自己）
    2. 收到所有 Server 回复以后，就计算出 zxid 最大的哪个 Server，并将这个 Server 相关信息设置成下一次要投票的 Server。
    3. 计算这过程中获得票数最多的的 sever 为获胜者，如果获胜者的票数超过半数，则改server 被选为 leader。否则，继续这个过程，直到 leader 被选举出来
    4. leader 就会开始等待 server 连接
    5. Follower 连接 leader，将最大的 zxid 发送给 leader
    6. Leader 根据 follower 的 zxid 确定同步点，至此选举阶段完成。
    7. 选举阶段完成 Leader 同步后通知 follower 已经成为 uptodate 状态
    8. Follower 收到 uptodate 消息后，又可以重新接受 client 的请求进行服务

21. Zookeeper 工作原理（原子广播）

    1. Zookeeper 的核心是原子广播，这个机制保证了各个 server 之间的同步。实现这个机制的协议叫做 Zab 协议。 Zab 协议有两种模式，它们分别是恢复模式和广播模式。
    2. 当服务启动或者在领导者崩溃后， Zab 就进入了恢复模式，当领导者被选举出来，且大多数 server 的完成了和 leader 的状态同步以后，恢复模式就结束了。
    3. 状态同步保证了 leader 和 server 具有相同的系统状态
    4. 一旦 leader 已经和多数的 follower 进行了状态同步后，他就可以开始广播消息了，即进入广播状态。这时候当一个 server 加入 zookeeper 服务中，它会在恢复模式下启
    动，发现 leader，并和 leader 进行状态同步。待到同步结束，它也参与消息广播。 Zookeeper服务一直维持在 Broadcast 状态，直到 leader 崩溃了或者 leader 失去了大
    部分的followers 支持。
    5. 广播模式需要保证 proposal 被按顺序处理，因此 zk 采用了递增的事务 id 号(zxid)来保证。所有的提议(proposal)都在被提出的时候加上了 zxid。
    6. 实现中 zxid 是一个 64 为的数字，它高 32 位是 epoch 用来标识 leader 关系是否改变，每次一个 leader 被选出来，它都会有一个新的 epoch。低 32 位是个递增计数。
    7. 当 leader 崩溃或者 leader 失去大多数的 follower，这时候 zk 进入恢复模式，恢复模式需要重新选举出一个新的 leader，让所有的 server 都恢复到一个正确的状态


### Kafka

1. Kafka 是什么

   Kafka 是一种高吞吐量、分布式、基于发布/订阅的消息系统，最初由 LinkedIn 公司开发，使用Scala 语言编写，目前是 Apache 的开源项目

   1. broker： Kafka 服务器，负责消息存储和转发
   2. topic：消息类别， Kafka 按照 topic 来分类消息
   3. partition： topic 的分区，一个 topic 可以包含多个 partition， topic 消息保存在各个partition 上
   4. offset：消息在日志中的位置，可以理解是消息在 partition 上的偏移量，也是代表该消息的唯一序号
   5. Producer：消息生产者
   6. Consumer：消息消费者
   7. Consumer Group：消费者分组，每个 Consumer 必须属于一个 group
   8. Zookeeper：保存着集群 broker、 topic、 partition 等 meta 数据；另外，还负责 broker 故障发现， partition leader 选举，负载均衡等功能

2. partition 的数据文件（offset， MessageSize， data）

   ###### offset

    offset 表示 Message 在这个 partition 中的偏移量， offset 不是该 Message partition 数据文件中的实际存储位置，而是逻辑上一个值，它唯一确定了 partition 中的一条 Message，可以认为 offset 是partition 中 Message 的 id

   ###### MessageSize

   MessageSize 表示消息内容 data 的大小

   ###### data

   data 为 Message 的具体内容

3. partition 会均衡分布到不同 broker 上

   由于消息 topic 由多个 partition 组成， 且 partition 会均衡分布到不同 broker 上，因此，为了有效利用 broker 集群的性能，提高消息的吞吐量， producer 可以通过随机或者hash 等方式，将消息平均发送到多个 partition 上，以实现负载均衡

4. 压缩（GZIP 或 Snappy）

   Producer 端可以通过 GZIP 或 Snappy 格式对消息集合进行压缩。 Producer 端进行压缩之后，在Consumer 端需进行解压。压缩的好处就是减少传输的数据量，减轻对网络传输的压力，在对大数据处理上，瓶颈往往体现在网络上而不是 CPU（压缩和解压会耗掉部分 CPU 资源）

5. Zookeeper 对于 Kafka 的作用是什么

   Zookeeper 是一个开放源码的、高性能的协调服务，它用于 Kafka 的分布式应用。Zookeeper 主要用于在集群中不同节点之间进行通信

   在 Kafka 中，它被用于提交偏移量，因此如果节点在任何情况下都失败了，它都可以从之前提交的偏移量中获取
   除此之外，它还执行其他活动，如: leader 检测、分布式同步、配置管理、识别新节点何时离开或连接、集群、节点实时状态等等

6. Kafka 判断一个节点是否还活着有那两个条件

   1. 节点必须可以维护和 ZooKeeper 的连接，Zookeeper 通过心跳机制检查每个节点的连接
   2. 如果节点是个 follower,他必须能及时的同步 leader 的写操作，延时不能太久

7. Kafka 与传统 MQ 消息系统之间的关键区别

   1. Kafka 持久化日志，这些日志可以被重复读取和无限期保留
   2. Kafka 是一个分布式系统：它以集群的方式运行，可以灵活伸缩，在内部通过复制数据提升容错能力和高可用性
   3. Kafka 支持实时的流式处理

8. 消费者故障，出现活锁问题如何解决

   出现 “活锁 ” 的情 况， 是由于持续 的发 送心 跳， 但是 没有 处理 。为 了预 防消 费者 在这种 情况 下一 直持有分 区，我们 使用 max.poll.interval.ms 活跃 检测 机制 。 在此基础上， 如果 你调 用的 poll 的频 率大 于最 大间 隔， 则客 户端 将主 动地 离开 组， 以便其 他消 费者 接管 该分 区。 发生 这种 情况 时， 你会 看到 offset 提交 失败 （调 用commitSync（） 引发 的 CommitFailedException）。 这是 一种 安全 机制 ，保 障只有 活动 成员 能够 提交 offset。所 以要 留在 组中 ，你 必须 持续 调用 poll

   消费者提供两个配置设置来控制 poll 循环：
   max.poll.interval.ms：增大 poll 的间 隔 ，可以 为消 费者 提供 更多 的时 间去 处理 返回的 消息（调用 poll(long)返回 的消 息，通常 返回 的消 息都 是一 批）。缺点 是此 值越大 将会 延迟 组重 新平 衡。
   max.poll.records：此 设置 限制 每次 调用 poll 返回 的消 息数 ，这 样可 以更 容易 的预测 每次 poll 间隔 要处 理的 最大 值。通过 调整 此值 ，可以 减少 poll 间隔 ，减少 重新平 衡分 组的

   对于 消息 处理 时间 不可 预测 地的 情况 ，这些 选项 是不 够的 。 处理 这种 情况 的推 荐方法 是将 消息 处理 移到 另一 个线 程中 ，让消 费者 继续 调用 poll。 但是 必须 注意
   确保已 提交 的 offset 不超 过实 际位 置。 另外 ，你 必须 禁用 自动 提交 ，并 只有 在线 程完成 处理 后才 为记 录手 动提 交偏 移量（取决 于你 ）。 还要 注意 ，你需 要 pause暂停分 区， 不会 从 poll 接收 到新 消息 ，让 线程 处理 完之 前返 回的 消息 （如 果你 的处理能 力比 拉取 消息 的慢 ，那 创建 新线 程将 导致 你机 器内 存溢 出）

   

### Redis

### Mysql

### 微服务



### Linux  相关

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

    

12. 







### 数据结构

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

2. elasticsearch 的倒排索引是什么

   传统的我们的检索是通过文章，逐个遍历找到对应关键词的位置。而倒排索引，是通过分词策略，形成了词和文章的映射关系表，这种词典+映射表即为倒排索引。有了倒排索引，就能实现 o（1）时间复杂度的效率检索文章了，极大的提高了检索效率

3. elasticsearch 索引数据多了怎么办，如何调优，部署

   索引数据的规划，应在前期做好规划，正所谓“设计先行，编码在后”，这样才能有效的避免突如其来的数据激增导致集群处理能力不足引发的线上客户检索或者其他业务受
   到影响

   -  动态索引层面

     基于模板+时间+rollover api 滚动创建索引，举例：设计阶段定义：blog 索引的模板格式为：blog_index_时间戳的形式，每天递增数据。
     这样做的好处：不至于数据量激增导致单个索引数据量非常大，接近于上线 2 的32 次幂-1，索引存储达到了 TB+甚至更大。
     一旦单个索引很大，存储等各种风险也随之而来，所以要提前考虑+及早避免

   -  存储层面

     冷热数据分离存储，热数据（比如最近 3 天或者一周的数据），其余为冷数据。对于冷数据不会再写入新数据，可以考虑定期 force_merge 加 shrink 压缩操作，节省存储空间和检索效率。

   - 部署层面

     一旦之前没有规划，这里就属于应急策略。结合 ES 自身的支持动态扩展的特点，动态新增机器的方式可以缓解集群压力，注意：如果之前主节点等规划合理，不需要重启集群也能完成动态新增的

4. elasticsearch 是如何实现 master 选举的

   1. Elasticsearch 的选主是 ZenDiscovery 模块负责的，主要包含 Ping（节点之间通过这个 RPC 来发现彼此）和 Unicast（单播模块包含一个主机列表以控制哪些节点需要 ping
      通）这两部分；
   2. 对所有可以成为 master 的节点（node.master: true）根据 nodeId 字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第 0 位）节点，暂且认为它是 master 节点。
   3. 如果对某个节点的投票数达到一定的值（可以成为 master 节点数 n/2+1）并且该节点自己也选举自己，那这个节点就是 master。否则重新选举一直到满足上述条件。
   4. 补充：master 节点的职责主要包括集群、节点和索引的管理，不负责文档级别的管理；data 节点可以关闭 http 功能

5. 详细描述一下 Elasticsearch 索引文档的过程

   第一步：客户写集群某节点写入数据，发送请求。（如果没有指定路由/协调节点，请求的节点扮演路由节点的角色。）
   第二步：节点 1 接受到请求后，使用文档_id 来确定文档属于分片 0。请求会被转到另外的节点，假定节点 3。因此分片 0 的主分片分配到节点 3 上。（文档获取分片的过程：借助路由算法获取，路由算法就是根据路由和文档 id 计算目标的分片 id 的过程）
   第三步：节点 3 在主分片上执行写操作，如果成功，则将请求并行转发到节点 1和节点 2 的副本分片上，等待结果返回。所有的副本分片都报告成功，节点 3 将向协调节点（节点 1）报告成功，节点 1 向请求客户端报告写入成功

6. 详细描述一下 Elasticsearch 搜索的过程

   搜索拆解为“query then fetch” 两个阶段。
   query 阶段的目的：定位到位置，但不取

   fetch 阶段的目的：取数据。
   路由节点获取所有文档，返回给客户端。

   1. 在初始查询阶段时，查询会广播到索引中每一个分片拷贝（主分片或者副本分片）。 每个分片在本地执行搜索并构建一个匹配文档的大小为 from + size 的优先队列。PS：在搜索的时候是会查询 Filesystem Cache 的，但是有部分数据还在 MemoryBuffer，所以搜索是近实时的。
   2. 每个分片返回各自优先队列中 所有文档的 ID 和排序值 给协调节点，它合并这些值到自己的优先队列中来产生一个全局排序后的结果列表。
   3. 接下来就是 取回阶段，协调节点辨别出哪些文档需要被取回并向相关的分片提交多个 GET 请求。每个分片加载并 丰富 文档，如果有需要的话，接着返回文档给协调节点。一旦所有的文档都被取回了，协调节点返回结果给客户端。
   4. 补充：Query Then Fetch 的搜索类型在文档相关性打分的时候参考的是本分片的数据，这样在文档数量较少的时候可能不够准确，DFS Query Then Fetch 增加了一个预查询的处理，询问 Term 和 Document frequency，这个评分更准确，但是性能会变差

7. Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法

   1. 关闭缓存 swap;
   2. 堆内存设置为：Min（节点内存/2, 32GB）;
   3. 设置最大文件句柄数；
   4. 线程池+队列大小根据业务需要做调整；
   5. 磁盘存储 raid 方式——存储有条件使用 RAID10，增加单节点性能以及避免单节点存储故障

8. Elasticsearch 中的节点（比如共 20 个），其中的 10 个选了一个 master，另外 10 个选了另一个 master，怎么办

   1. 当集群 master 候选数量不小于 3 个时，可以通过设置最少投票通过数量（discovery.zen.minimum_master_nodes）超过所有候选节点一半以上来解决脑裂问题；
   2. 当候选数量为两个时，只能修改为唯一的一个 master 候选，其他作为 data节点，避免脑裂问题

9. 详细描述一下 Elasticsearch 索引文档的过程

   1. 当分片所在的节点接收到来自协调节点的请求后，会将请求写入到 Memory Buffer，然后定时（默认是每隔 1 秒）写入到 Filesystem Cache，这个从 MomeryBuffer 到Filesystem Cache 的过程就叫做 refresh；
   2. 当然在某些情况下，存在 Momery Buffer 和 Filesystem Cache 的数据可能会丢失，ES 是通过 translog 的机制来保证数据的可靠性的。其实现机制是接收到请求后，同时也
      会写入到 translog 中，当 Filesystem cache 中的数据写入到磁盘中时，才会清除掉，这个过程叫做 flush；
   3. 在 flush 过程中，内存中的缓冲将被清除，内容被写入一个新段，段的 fsync将创建一个新的提交点，并将内容刷新到磁盘，旧的 translog 将被删除并开始一个新的translog。
   4. 、flush 触发的时机是定时触发（默认 30 分钟）或者 translog 变得太大（默认为 512M）时

10.  Lucene 的 Segement

    1. Lucene 索引是由多个段组成，段本身是一个功能齐全的倒排索引。
    2. 段是不可变的，允许 Lucene 将新的文档增量地添加到索引中，而不用从头重建索引。
    3. 对于每一个搜索请求而言，索引中的所有段都会被搜索，并且每个段会消耗CPU 的时钟周、文件句柄和内存。这意味着段的数量越多，搜索性能会越低。
    4. 为了解决这个问题，Elasticsearch 会合并小段到一个较大的段，提交新的合并段到磁盘，并删除那些旧的小段

11. 详细描述一下 Elasticsearch 更新和删除文档的过程

    1. 删除和更新也都是写操作，但是 Elasticsearch 中的文档是不可变的，因此不能被删除或者改动以展示其变更；
    2. 磁盘上的每个段都有一个相应的.del 文件。当删除请求发送后，文档并没有真的被删除，而是在.del 文件中被标记为删除。该文档依然能匹配查询，但是会在结果中被过滤掉。当段合并时，在.del 文件中被标记为删除的文档将不会被写入新段。
    3. 在新的文档被创建时，Elasticsearch 会为该文档指定一个版本号，当执行更新时，旧版本的文档在.del 文件中被标记为删除，新版本的文档被索引到一个新段。旧版本的文档依然能匹配查询，但是会在结果中被过滤掉。

12. Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法

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

13. 索引阶段性能提升方法

    1. 使用批量请求并调整其大小：每次批量数据 5–15 MB 大是个不错的起始点。
    2. 存储：使用 SSD
    3. 段和合并：Elasticsearch 默认值是 20 MB/s，对机械磁盘应该是个不错的设置。如果你用的是 SSD，可以考虑提高到 100–200 MB/s。如果你在做批量导入，完全不在意搜索，你可以彻底关掉合并限流。另外还可以增加index.translog.flush_threshold_size 设置，从默认的 512 MB 到更大一些的值，比如 1 GB，这可以在一次清空触发的时候在事务日志里积累出更大的段。
    4. 如果你的搜索结果不需要近实时的准确度，考虑把每个索引的index.refresh_interval 改到 30s。
    5. 如果你在做大批量导入，考虑通过设置 index.number_of_replicas: 0 关闭副本

14. 在并发情况下，Elasticsearch 如果保证读写一致

    1. 可以通过版本号使用乐观并发控制，以确保新版本不会被旧版本覆盖，由应用层来处理具体的冲突；
    2. 另外对于写操作，一致性级别支持 quorum/one/all，默认为 quorum，即只有当大多数分片可用时才允许写操作。但即使大多数可用，也可能存在因为网络等原因导致写入副本失败，这样该副本被认为故障，分片将会在一个不同的节点上重建。
    3. 对于读操作，可以设置 replication 为 sync(默认)，这使得操作在主分片和副本分片都完成后才会返回；如果设置 replication 为 async 时，也可以通过设置搜索请求参数_preference 为 primary 来查询主分片，确保文档是最新版本

15. 字典树

16. 拼写纠错是如何实现的

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

    

12. 服务提供者能实现失效踢出是什么原理

    服务失效踢出基于 Zookeeper 的临时节点原理

13. 服务读写推荐的容错策略是怎样的

    读操作建议使用 Failover 失败自动切换，默认重试两次其他服务器。
    写操作建议使用 Failfast 快速失败，发一次调用失败就立即报错。

14. 





