package cn.gaohank.idea.java.base_10_invoke;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 获得类信息：
 * 1.对象.getClass
 * 2.类.class
 * 3.Class.forName(类路径);
 */
public class Invoke01ClassInfo {
    public static class Student {
        int age;
        int height;
        String name;

        @SuppressWarnings("unused")
        private Student() {
        }

        public Student(int age, int height, String name) {
            this.age = age;
            this.height = height;
            this.name = name;
        }

        @Override
        public String toString() {
            return "[" + name + ":" + age + "/" + height + "]";
        }
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {
        Student student = new Student(28, 170, "hank");
        Class<? extends Student> stuClass = student.getClass();
        System.out.println(stuClass.getName());
        System.out.println(Arrays.toString(stuClass.getConstructors()));
        System.out.println("获得多个构造方法，包括private");
        System.out.println(Arrays.toString(stuClass.getDeclaredConstructors()));

        System.out.println("获得某个构造方法");
        Constructor<? extends Student> constructor = stuClass.getConstructor(Integer.TYPE, Integer.TYPE, String.class);
        System.out.println(constructor);
    }
}
