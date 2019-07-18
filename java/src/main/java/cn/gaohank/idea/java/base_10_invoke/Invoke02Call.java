package cn.gaohank.idea.java.base_10_invoke;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Invoke02Call {
    public static class Student {
        int age;
        int height;
        String name;

        @SuppressWarnings("unused")
        private Student() {
            // TODO Auto-generated constructor stub
        }

        public Student(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        @SuppressWarnings("unused")
        public void run() {
            System.out.println("run " + age + "" + height);
        }

        @SuppressWarnings("unused")
        public void eat() {
            System.out.println("eat");
        }

        @Override
        public String toString() {
            return "[" + name + ":" + age + "/" + height + "]";
        }
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student("bob", 30, 160);
        // 反射方法较多
        Method[] methods = Student.class.getMethods();
        System.out.println(Arrays.toString(methods));
        System.out.println(methods.length);

        // 反射具体的方法
        Method eat = Student.class.getMethod("eat");
        eat.invoke(student);
    }
}
