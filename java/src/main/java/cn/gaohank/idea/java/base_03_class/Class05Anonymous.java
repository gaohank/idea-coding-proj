package cn.gaohank.idea.java.base_03_class;

interface InterTest {
    void display();
    void test();
}

/*
 * 匿名内部类
 * 1.匿名内部类是没有名字的内部类
 * 2.匿名内部类就相当于内部类要调用的外部类或接口的一个对象
 * 3.匿名类不用起名，按父类去new，把未实现的抽象方法实现
 */
public class Class05Anonymous {
    static void show(InterTest interTest) {
        interTest.display();
        interTest.test();
    }

    public static void main(String[] args) {
        show(new InterTest() {
            @Override
            public void display() {
                System.out.println("display");
            }

            @Override
            public void test() {
                System.out.println("test");
            }
        });
    }
}
