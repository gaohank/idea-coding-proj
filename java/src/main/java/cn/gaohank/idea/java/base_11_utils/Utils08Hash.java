package cn.gaohank.idea.java.base_11_utils;

public class Utils08Hash {
    public static<T> int getHashCode(T t) {
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }
}
