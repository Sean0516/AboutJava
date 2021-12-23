package array;

import com.duplicall.map.CustomLinkedHashMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Queue;

/**
 * @Description array.TestHashMap
 * @Author Sean
 * @Date 2021/9/14 16:26
 * @Version 1.0
 */
public class TestHashMap {
    @Test
    public void test(){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("1","2");
        hashMap.put("2","2");
        hashMap.put("3","2");
        hashMap.put("4","2");
        boolean b = hashMap.containsValue("2");

    }
    @Test
    public void testLinkedHashMap(){
        LinkedHashMap<String,String> map = new CustomLinkedHashMap();
        map.put("1","2");
        map.put("2","2");
        map.put("3","2");
        map.put("4","2");
        map.put("5","2");
        map.put("6","2");
        System.out.println(map);
    }
}
