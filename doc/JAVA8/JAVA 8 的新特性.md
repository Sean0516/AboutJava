### Lambda  表达式
Lambda表达式。它可以让你很简洁地表示一个行为或传递代码。可以把Lambda表达式看作匿名功能，它基本上就是没有声明名称的方法，但和匿名类一样，它也可以作为参数传递给一个方法
lambda 表达式的语法格式如下：
下面是一个lambda表达式的重要特征。

1. 可选类型声明 - 无需声明参数的类型。编译器可以从该参数的值推断。
2. 可选圆括号参数 - 无需在括号中声明参数。对于多个参数，括号是必需的。
3. 可选大括号 - 表达式主体没有必要使用大括号，如果主体中含有一个单独的语句。
4. 可选return关键字 - 编译器会自动返回值，如果主体有一个表达式返回的值。花括号是必需的，以表明表达式返回一个值。


### 函数接口
函数接口指的是仅仅包含一个抽象方法的接口，可以认为任何一个lambda 表达式都可以等价转换为对于的函数式接口，可以将任意只包含一个抽象方法的接口用作Lambda 表达式，但是使用@FunctionalInterface 有助于编译器检查函数接口的合法性。例如

```
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}
```
JAVA 8 自带几个常用函数接口

Predicate 接收一个参数并返回Boolean

Consumer 接收一个参数，不返回值

function 接收一个参数并产生一个结果

supplier 不接收参数，对于给定的泛型类型产生一个实例

### 接口的默认方法
Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法

```
interface Demo {
   default void say(String name){
       sout("hello" +name)
   }
}
```
### 方法引用 
方法引用有助于自己的名字指向方法。方法参考描述使用“::”符号。 方法引用通过方法的名字来指向一个方法,方法引用可以使语言的构造更紧凑简洁，减少冗余代码

### Stream 
Stream是Java8 引入的一个非常重要的特性 ，其代表着一系列可以在其上进行多种操作的元素，这些操作可以是中间操作，也可以是最终操作，最终操作返回操作结果，而中间操作返回流本身，并且你可以通过多次调用同一个流操作方法来将操作结果串起来。 。Stream是在一个源的基础上创建出来的，例如java.util.Collection中的list或者set（map不能作为Stream的源）。Stream操作往往可以通过顺序或者并行两种方式来执行。 


### Optional<T> 
在Java 8里有一个 Optional<T> 类，如果你能一致地使用它的话，就可以帮助你避免出现
NullPointer 异常。它是一个容器对象，可以包含，也可以不包含一个值。 Optional<T> 中有
方法来明确处理值不存在的情况，这样就可以避免 NullPointer 异常了。换句话说，它使用类
型系统，允许你表明我们知道一个变量可能会没有值

### 时间日期API
新增 LocalDateTime  日期时间 ,LocalDate 日期  LocalTime 时间

DateTimeFormatter 为不可变且线程安全的类，可以放心在多线程环境下使用

Clock提供了对当前时间和日期的访问功能。Clock是对当前时区敏感的，并可用于替代System.currentTimeMillis()方法来获取当前的毫秒时间。当前时间线上的时刻可以用Instance类来表示。Instance也能够用于创建原先的java.util.Date对象。

