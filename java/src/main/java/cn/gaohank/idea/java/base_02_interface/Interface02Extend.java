package cn.gaohank.idea.java.base_02_interface;

// 接口可以继承其他接口
public interface Interface02Extend extends Interface01Base {
    void extendTest();

    @Override
    default void display() {
        System.out.println("extend接口的display方法");
    }
}
