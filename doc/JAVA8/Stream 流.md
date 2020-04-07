Stream 是对集合对象功能的增强，他专注于对集合对象进行各种非常 便利，高效的聚合操作，或者大批量数据操作。 stream api 借助于同样新出现的lambda 表达式，极大的提高编程效率和程序可读性。同时也提供串行和并行两种模式进行汇聚操作。并发模式可以利用多核处理器优势，使用fork.join 并行方式来拆分任务和加速处理过程。
stream 就如同一个迭代器，单向，不可往复，数据只能遍历一次，遍历过一次后就用尽了。 而和迭代器不同的是，stream 可以并行化操作

### 流的构成
当我们使用一个流的时候，通常包括三个基本步骤:

获取一个数据源--> 数据转换--> 执行操作获取最终结果， 每次转换原有的stream对象不变，返回一个新的stream 对象。 这就允许对齐操作可以像链条一样排列。变成一个管道

### 流的操作

流的操作主要分为两种
1.  intermediate （中间操作） 
> 一个流可以后面跟随零个或者多个intermediate操作，其目的主要是打开流，做出某种程度的数据映射/过滤。然后返回一个新的流，交给下一个操作使用，这类操作都是惰性化的。也就是说，中间操作仅仅调用到这类方法，并没有真正开始流的遍历

filter 接收一个predicate 来过滤流中的所有元素

sorterd 返回流已排序版本

map 通过指定的函数将流中的每一个元素转变为另外的对象

flatMap 每个元素转换得到的stream对象，会把子stream 中的元素压缩到复几何

peek 生成一个包含原Stram 的所有元素的新stream

limit 对一个stream 进行阶段操作

skip 返回一个丢弃原stream 的前N个元素后生效元素组成的新


2.  terminal 最终操作 
> 一个流只能有一个terminal操作，当这个操作执行后，流就会被使用，无法再被操作。 所以这必定是流的最后一个操作。 terminal操作的执行，才会真正开始流的遍历，并且会生成一个结果。

reduce 使用指定的函数对流中元素实施消减，返回一个办好所有被消减元素的optional

collect 把流中的元素聚合到其他数据结构中

match anymatch  allmatch  等操作可以用来检测是否某种predicate 和流中元素想匹配

count 返回流中的元素数量

findfirst 返回流中的第一个元素

max min 使用给定的比较器 返回stream中的最大值或最小值

由于intermediate操作是一个lazy操作，所以，在多次转换操作时，指挥在terminal操作的时候融合起来，一起循环完成，我们可以理解为： stream 里有一个操作函数的集合，每次转换操作就是把转换函数放入这个集合中，在terminal操作的时候循环stream对应的集合，然后对每个元素执行所有的函数流的中间操作

### 流的创建
除了 list或者set 等数据可以转化为流，流还可以通过以下方式进行创建

1. 由值创建  

```
Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
```

2. 由数组创建

```
String [] strings={"sean","red","green","green"};
        Arrays.stream(strings)
```

3. 由文件创建

```
 Stream<String> lines = Files.lines(Paths.get("D:\\data.txt"), StandardCharsets.UTF_8)
```


### 流需要注意的地方
1. 流并不存储值，他只是某数据的一个视图，对流的操作会产生一个结果，但流的数据源不会被修改
2. stream 只能被消费一次，一旦遍历过就会失效
3. 慎重使用并行流， 其底层使用的是forkjoin pool 的commonpool ，在不做任何配置的情况下，所有并行流都共用同一个线程池，而且此线程池还会被其他机制依赖

