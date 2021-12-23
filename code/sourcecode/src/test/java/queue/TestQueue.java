package queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description TestQueue
 * @Author Sean
 * @Date 2021/12/22 15:20
 * @Version 1.0
 */
public class TestQueue {
    @Test
    public void testQueue() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("A");
        queue.add("C");
        queue.add("X");
        queue.add("B");
        queue.offer("Z");
        String element = queue.element();
        System.out.println("element = " + element);
        String peek = queue.peek();
        System.out.println("peek = " + peek);
        String poll = queue.poll();
        System.out.println("poll = " + poll);
        System.out.println("queue = " + queue);
    }
}
