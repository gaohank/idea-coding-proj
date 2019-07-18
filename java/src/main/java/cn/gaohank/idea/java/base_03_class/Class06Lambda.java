package cn.gaohank.idea.java.base_03_class;

interface I1 {
    void test1();
}

interface I2 {
    void test2(String str);
}

interface I3{
    int test3(int a, int b);
}

/*
 * lambda是为了代替匿名内部类的繁琐语法，
 * 目标是函数式接口（接口只有一个方法）
 * 形参部分：可以省略形参的参数类型，如果形参就一个，连()都可以省了
 * 方法体部分：如果方法体就一句话，可以把{}和这句话后面的分号都省了
 * 方法如果有返回值，且就一句话（方法体中只有一个return语句），连return都可以省了
 * 引用类方法：    类名::类方法     (a,b,...)->{类名.类方法(a,b,...)}
 * 引用实例方法： 对象::实例方法    (a,b,...)->{特定对象.实例方法(a,b,...)}
 * 引用类对象实例方法： 类对象::实例方法   (a,b,...)->{a.实例方法(b,...)}
 * 引用构造器：    类名::new    (a,b,...)->{new 类名(a,b,...)}
 */
public class Class06Lambda {
    public static void main(String[] args) {
        I1 i1 = () -> System.out.println("i1 test");
        i1.test1();

        I2 i2 = s -> System.out.println("i2 test " + s);
        i2.test2("gaohank");

        I3 i3 = (a, b) -> a + b;
        System.out.println(i3.test3(1, 2));
    }
}
