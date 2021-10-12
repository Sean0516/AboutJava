import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @Description TestArrayList
 * @Author Sean
 * @Date 2021/10/11 15:02
 * @Version 1.0
 */
public class TestArrayList {
    @Test
    public void testListIterator(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1111");
        arrayList.add("1234");
        arrayList.add("3333");
        ListIterator<String> iterator = arrayList.listIterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if ("1234".equals(next)){
                iterator.add("4321");
            }
        }
        System.out.println(arrayList);
    }
}
