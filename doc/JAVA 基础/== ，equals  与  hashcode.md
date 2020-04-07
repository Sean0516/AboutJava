主要讨论 == 与 equals 的区别，以及 重写equals 与hashCode 

### == 与 equals 的区别

> 等号的作用是用于判断两个对象的地址是不是相等的。即判断两个对象是不是同一个对象（==基本数据类型进行等号比较时，比较的是值。 对于引用数据类型等号则比较的是内存地址==）

> equals 的作用是判断两个对象是否相等。 一般分为以下两种情况
1. 当类没有覆盖equals 方法是，使用equals进行比较时，等价于通过 == 来比较两个对象
2. 当类覆盖了equals 方法，则通过equals方法来比较两个对象的内容是否相等，若内容相等，则认为两个对象相等
需要注意的是，由于String 的equals方法被重写过，所以string的equals方法比较的是对象的值


### equals 和 hashcode 

> hashcode 和 equals 用来标识对象，两个方法协同工作用来判断对象是否相等。 对象通过调用Object.hashcode 生成哈希值，由于可能会存在哈希冲突的情况，因此当hashCode  相同时，还需要再调用equals 进行比较。 但是，当hashCode 不同时，则跳过equals直接判断object不同，加快哈希冲突的解决效率。

hashcode 和equals 的相关规定如下：
 
1.如果两个对象的equals 结果相等，则两个对象的hashcode 返回值必须也是相同的

2.如果两个对象相等，则两个对象分表调用equals方法都返回true

3.两个对象的hashcode 相等，但是他们不一定是相等的

4.==重写equals方法时，必须同时重写hashecode 方法==

5.haseCode 的默认行为是在堆上的对象产生独特值，如果没有重写haseCode 则该class 的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）

###  重写 equals 方法

```
public class Student {
    private String name;
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
         int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
    }

       public boolean equals(Object obj) {
        if (obj!=null && obj.getClass()==this.getClass()){
            Student student= (Student) obj;
            if (student.getName()==null || name==null){
                return false;
            }else {

                return name.equals(student.getName());
            }
        }
        return  false;
```

关于重写hashcode 
    首先生成一个int 类型的变量 result  并初始化一个值，比如17 
    然后对类中每一个重要字段，也就是影响到对象的值的字段（equals 中有进行比较的字段） 进行如下操作 ： a. 计算这个字段的hashValue = naem.hashCode() b. 执行 result= 31 * result + hashValue

使用31 的原因在于 31 可以被JVM 优化 ， 由于JVM 里面最有效的计算方式就是进行位运算。 31 可以在jvm 中高效的机械能位运算

    
    
在重写 equals 方法时需要注意

1. 应该考虑null 的情况，增加null 的判断
2. 在equals 中使用getClass 进行类型判断,而不是 instanceof (当存在类继承的时候，容易出现问题，父类使用了instanceof 关键字)
3. 记得同时重写hashcode方法

