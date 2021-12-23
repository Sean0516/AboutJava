package set;

import org.junit.Test;

import java.util.*;

/**
 * @Description TestHashSet
 * @Author Sean
 * @Date 2021/12/22 11:18
 * @Version 1.0
 */
public class TestSet {
    @Test
    public void testHashSet() {
        HashSet<String> strings = new HashSet<>();
        strings.add("A");
        strings.add("C");
        strings.add("B");
        strings.add("E");
        strings.add("R");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next = " + next);
        }
    }

    @Test
    public void testTreeSet() {
        TreeSet<String> strings = new TreeSet<>();
        strings.add("A");
        strings.add("C");
        strings.add("B");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next = " + next);
        }
        String first = strings.first();
        System.out.println("first = " + first);
        String last = strings.last();
        System.out.println("last = " + last);
        boolean c = strings.remove("C");
    }

    @Test
    public void testLinkedHashSet() {
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("A");
        strings.add("B");
        strings.add("E");
        strings.add("R");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next = " + next);
        }
        boolean b = strings.remove("B");
        System.out.println("b = " + b);

    }
}
