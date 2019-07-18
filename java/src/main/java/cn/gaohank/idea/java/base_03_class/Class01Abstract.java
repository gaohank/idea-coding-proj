package cn.gaohank.idea.java.base_03_class;

/*
 * 抽象类就是父类，把子类的公共部分提出来
 * 和普通父类的区别是：
 * 		提出来的公共部分不实现
 * 		抽象类只是比普通类多了一种抽象方法，其他的普通类有东西，它都可以有
 * 抽象类在class前加上关键字abstract
 * 抽象方法在返回值前加上关键字abstract
 * 如果一个类包含抽象方法，这个类叫抽象类
 * 抽象类不能new ,因为抽象类里可能会有抽象的方法（没被实现的方法）
 * 只要一个类被定义成抽象类，它就不能new
 * 子类必须实现抽象父类的所有抽象方法，才算完整，才能new,除非这个子类也是抽象类
 * abstract和final不能同时修饰一个类
 */

/*
 * 不加任何访问权限限定的成员采用的是默认的访问权限，称为default或package。
 * default权限意味着可以被这个类本身和同一个包的类访问。
 * 在其他包中定义的类，即使是这个类的子类，也不能直接访问这些成员。
 * 这种访问权限相当于把同一个包中的类作为可信的朋友。
 * 对于构造方法，如果不加任何访问权限也是default访问权限，
 * 除了这个类本身和同一个包中的类之外，其他类不能生成该类的实例
 */
public abstract class Class01Abstract {
    static String lastName;
    String name;

    public Class01Abstract(String name) {
        this.name = name;
    }

    public abstract void display(); // 抽象方法，和普通方法区别是没有{}
    public void test() {
        System.out.println("test");
    }
}
