package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description array.TestArrayList
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

    @Test
    public void testLinkedList(){
        LinkedList<String> strings = new LinkedList<>();
        strings.add("123");
        String s = strings.get(0);
        System.out.println(s);
    }
    @Test
    public void testCopyOnWriteArrayList(){
        CopyOnWriteArrayList<String> msg = new CopyOnWriteArrayList<>();
        msg.add("demo");
        msg.add("demo2");
        String s = msg.get(0);
        System.out.println("s = " + s);

    }
}
