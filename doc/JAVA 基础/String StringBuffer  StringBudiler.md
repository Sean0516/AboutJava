### String
    
String 是不可改变的字符串，创建后就不能再改变，String 类包括用于检查序列的各个字符的方法，用于比较字符串，收索字符串，提取字符串以及创建将所有字符的大小写的转换。 在使用String 的使用有以下地方需要注意
1.  推荐直接使用String 直接量进行赋值
简单来说就是直接使用String str=""; 而不是使用String str=new String(""); 因为Java为了避免在一个系统中大量产生String 对象，于是设计了一个字符串池，在字符串池中所容纳的都是一创建的对象。 字符串池的创建机制如下： 当创建一个字符串时，先检查池中是否存在字面值相等的字符串，如果有，则不再创建，直接返回该对象的引用。如果没有创建则创建，放入池中，并返回新对象的引用。而使用new  创建的对象不会检查字符串池，也不会将对象放入对象池中。而是直接在堆内存空间创建一个新的对象。 使用对象池不仅可以提高效率，还减少了内存空间的占用，推荐在开发中使用直接赋值的方法创建String 对象
2. 推荐使用String 自带的equals 方法来进行字符串是否等于的检查。 不应该使用 == 来做匹配
3. 关于 空字符串 和  null字符串
空字符串为 "" 表示长度为0 的字符串。 字符串是一个Java 对象，有自己的长度和内容 （长度为0 ，内容为空） 。 而 null字符串 ，则表示没有任何对象与该变量关联

### StringBuffer  
    
StringBuffer 是线程安全的可变字符序列。他可以通过某些方法调用来更改序列的长度和内容。  StringBuffer 可以安全地被多个线程使用，这些方法在必要时进行同步，以便人恶化特定实例上的所有操作都按照与所涉及的各个线程所执行方法的调用顺序一致。 StringBuffer 和String 一样都是用来存储字符串的，只不过他们内部的实现不一样。 对于stringBuffer 而言，他在处理字符串时，在对其做修改操作时，并不会产生一个新字符串对象，所以说在内存使用方面来说，他是优于String 的，但是由于他是同步的，他的速度则是慢于StringBulider.
StringBuffer 更加侧重与字符串的变化，例如追加 append()，修改 insert()，和删除 delete()
    
### StringBuilder 
StringBuilder  是线程不安全的字符序列。他和StringBuffer 的功能基本相同。 区别大于线程安全方面。 主要用于替换StringBuffer 在单线程使用的情况。 在不需要多线程的情况下，推荐使用StringBuilder 而不是StringBuffer  。如果需要多线程同步，则建议使用StringBuffer

从性能方面来说 ，由于Strin 类的操作都是产生一个新的String 对象，而StringBuffer 和StringBuilder 则是只有一个字符串组再扩容。所以String 类的操作远慢于另外两个。而且由于StringBuffer  是线程安全的，所以StringBulider 的速度最快

### String StringBuffer StringBuiler 的使用场景
1. String 在字符串不经常发生变化的场景，例如常量的申明，少量的变量运算
2. StringBuffer 在频繁进行字符串的运算（拼接，替换，删除等） ，并且运行在多线程的环境中，可以考虑StrigBuffer 
3. StringBuilder 在频繁进行字符串的运算（拼接、替换、删除等）的单线程的环境中
    
### 关于字符串拼接方式

在合适的场所需要选择合适的字符串拼接方式，目前字符串拼接有三种方式 加号 concat 以及append 其中加号是很常用的，从执行速度来说，append> concat > + 

1.  +方法拼接字符串
虽然+  方法 会使用stringbuilder 的append方法进行追加，但是每次都会创建一个stringbuilder对象 并且最终还是要使用toString 方法转化为string 字符串。 
2. concat 方法 
整体上看上去就是一个数组拷贝，但是每次的concat 方法都会创建一个string 对象，
3. append 方法
append 方法一直在做字符串数组处理，加长，然后数组拷贝。都是基本的数据处理
三种实现方法不同，性能也不一样，但是并不是一定要使用append 方法，大多数清空下我们都是可以使用加号操作，只有在系统系能能临界的使用才考虑使用concat 和append 方法
    
    