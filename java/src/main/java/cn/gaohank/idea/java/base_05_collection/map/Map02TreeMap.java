package cn.gaohank.idea.java.base_05_collection.map;

import java.util.Map;
import java.util.TreeMap;

/*
 * TreeMap
 * key值必须是实现Comparable的。
 */
public class Map02TreeMap {
    private static class Student implements Comparable<Student> {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }

        @Override
        public String toString() {
            return "[name=" + name + ":score=" + score + "]";
        }

    }

    public static void main(String[] args) {
        Map<Student, Integer> studentMap = new TreeMap<>();
        studentMap.put(new Student("hank", 90), 84);
        studentMap.put(new Student("james", 84), 82);
        studentMap.put(new Student("bob", 95), 69);
        // 默认按照Comparable接口排序规则进行排序
        System.out.println(studentMap);
    }
}
