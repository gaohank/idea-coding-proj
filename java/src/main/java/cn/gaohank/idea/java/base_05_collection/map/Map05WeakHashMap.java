package cn.gaohank.idea.java.base_05_collection.map;

import java.util.Map;
import java.util.WeakHashMap;

/*
 * WeakHashMap
 * 垃圾回收只回收没有引用指向的对象，但WeakHashMap的引用是弱引用，
 * 如果垃圾回收map中指向的对象可以被回收，不受map控制
 * System.gc
 */
public class Map05WeakHashMap {
    private static class Student implements Comparable<Student> {

        String name;
        int age;
        int score;

        public Student(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            // TODO Auto-generated method stub
            return this.score - o.score;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + score;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Student other = (Student) obj;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (score != other.score)
                return false;
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Map<Student,Integer> map = new WeakHashMap<>();
        for (int i = 0; i < 10; i++) {
            Student s = new Student("张三"+i,23,49+i);
            map.put(s, 90);
        }

        System.out.println(map.size());
        System.gc();//垃圾回收
        Thread.sleep(2000);
        System.out.println(map.size());
    }
}
