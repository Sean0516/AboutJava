Java 8 提供了全新的日期和时间API 。主要包括以下类

### Clock 
Clock 提供了访问当前日期和时间的方法，且clock 类是时区名满的。可以根据不同的时候区来获取当前的微秒数。某个特定的时间点也可以使用Instant 类来表示，而Instant 类则可以通过Date.from 创建旧版的date 对象

### ZoneID 
时区类，可以通过静态方法of 来指定对应的时区
### LocalDate(本地日期) LocalTime（时间） LocalDateTime (日期时间)
时间处理的类。取代之前的Calendar
 
### DateTimeFormatter
DateTimeFormatter是不可变的，所以它是线程安全的，用来替代了 SimpleDateFormat 
 
 
```
// localDate to date 
 public static Date localDate2Date(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }
    
    // localDateTime to date
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }

    //  date to  LocalDate
    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }
    
       //  date to  LocalDateTime
    public static LocalDateTime date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }
    
    // str to  LocalDate
     DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     LocalDate date = LocalDate.parse(day, dateTimeFormatter);
     // LocalDate to  str
    
     LocalDate date =LocalDate.now();
     String str=date.format(dateTimeFormatter);
    
```

 