Optional是为核心类库新设计的一个数据类型， 用来替换null 。使用optional 对象有两个目的，首先 optional 鼓励程序员适时检查变量是否为空，以避免代码缺陷 ，其次，他将一个类的API 中可能为空的值文档化. optional 就像一个处理不确定性的管道，我们在一头丢进一个可能是null 的东西，经过层层处理，最后消除不确定性。 optional在过程中保留了不确定性，从而把对null 的处理转移到了若干次处理操作的最后，减少出现NPE 异常的可能。 

optional 是一个简单的容器，其值可能是Null 或者不是null ，在Java8 之前一般某个函数应该返回非空对象但是有时却什么也没有返回，但是在Java8 中，应该返回optional 而不是 null

### optional 的一些方法

1. Optional.of()  为非空的值创建一个optional  
2. Optional.ofNullable()  empty
3. optional.isPresent()   如果值存在返回true ，否则返回false
4. optional.get()  如果optional 有值则将其返回，否则抛出noSuchElementException 
5. optional.orElse（""） 如果有值将其返回，否则返回指定的值
6. map： 如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。

### 关于optional 的规则
1. 不要将null赋值给 optional
2. 避免使用optional.get 如果不能证明存在可选项，那么永远不要调用get ,可以使用 orElse()， orElseGet() orElseThrow() 获得结果
3. 不要在字段，方法参数，集合中使用optional
4. 只有当结果不确定时，使用optional 作为返回类型
5. 不要为了链式方法而使用optional ， 

### 关于空值的一些优化
1. 如果有集合这样的返回值，一定要返回空集合，而不是Null 
2. 可以使用optional 来增加接口的可读性
3. 使用jsr 303 来进行字段属性校验
4. 可以使用Objects.nonNull() 工具类来判断是否为空

