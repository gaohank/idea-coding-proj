package cn.gaohank.idea.java.base_02_interface;

/*
 * interface规范：
 * 1.接口不能有非抽象非静态方法，抽象类可以有
 * 2.可以有default方法（1.8新增）
 * 3.可以有静态方法（1.8新增）
 * 4.继承是单继承，接口可以多实现
 */
public interface Interface01Base {
    // 接口中变量可以通过（接口名.变量名）使用
    String DISCRIPTION = "介绍接口基础特性";

    // 可以省略关键字display
    void test();

    // 可以有静态的方法，使用（接口名.方法名）调用
    static void discribe() {
        System.out.println("接口的静态方法");
    }

    /*
     * default方法，其实就是普通方法，实现类或子接口可以重写，也可以直接调用，
     * 实现类如果想重写，在实现类中要去掉default关键字
     */
    default void display() {
        System.out.println("base接口的display方法");
    }
}
