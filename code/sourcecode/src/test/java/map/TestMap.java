package map;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @Description TestMap
 * @Author Sean
 * @Date 2021/12/22 14:26
 * @Version 1.0
 */
public class TestMap {
    @Test
    public void testTreeMap() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("A", "demo");
        treeMap.put("C", "demo2");
        treeMap.put("D", "demo2");
        treeMap.put("B", "demo2");
        String value = treeMap.get("B");
        System.out.println("value = " + value);

        for (String s : treeMap.keySet()) {
            System.out.println("s = " + s);
        }
        treeMap.remove("B");
    }
}
