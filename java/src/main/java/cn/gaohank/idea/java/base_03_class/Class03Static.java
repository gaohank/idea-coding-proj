package cn.gaohank.idea.java.base_03_class;

// 普通类不允许声明为静态，只有内部类可以
public class Class03Static {
    private String name = "gaohank"; // 构造对象前执行

    public Class03Static() {
        System.out.println("name is " + name);
    }

    // 只执行一次，类加载时执行
    static {
        System.out.println("静态代码块，在加载时执行");
    }

    public static void main(String[] args) {
        Class03Static class03Static1 = new Class03Static();
        Class03Static class03Static2 = new Class03Static();
    }
}
