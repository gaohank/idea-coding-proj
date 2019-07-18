package cn.gaohank.idea.java.base_03_class;

/*
 * 泛型类
 */
public class Class07Generics<L, R> {
    public void display(L left, R right) {
        System.out.println("left class is " + left.getClass());
        System.out.println("right class is " + right.getClass());
    }

    public Class getLeftClass(L left) {
        return left.getClass();
    }
}
