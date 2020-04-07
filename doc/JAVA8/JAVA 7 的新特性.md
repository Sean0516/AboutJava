### 自动资源管理
Java 7 提高了try-with-resource 这个新的语言特性。运行try 语句本身申请更多的资源，这些资源用于try 代码块并自动关闭，只要资源实现了 autocloseable 接口即可

```
      try (BufferedReader bufferedReader = new BufferedReader(new FileReader(""))) {
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
```

### switch 字符串支持

switch 支持使用字符串进行选择。需要注意的是， 最终switch还是编译成对字符串hashcode 的switch ，然后在做字符串比较

### 文件操作类 Path ,Files
Path 和Files 这些类的出现是为了取代原来的基于io.file 的文件io 操作方式
