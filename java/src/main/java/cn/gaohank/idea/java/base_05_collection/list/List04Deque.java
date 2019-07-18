package cn.gaohank.idea.java.base_05_collection.list;

import java.util.Deque;
import java.util.LinkedList;

// 栈由LinkedList实现
public class List04Deque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.push("aaa");
        deque.push("bbb");
        deque.push("ccc");
        deque.push(null);
        deque.push("bbb");
        deque.push("ccc");

        for (String str : deque) {
            System.out.println(str);
        }

        System.out.println(deque.size());

        deque.forEach((s)->System.out.println(s + "---" + deque.size()));
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque);
    }
}
