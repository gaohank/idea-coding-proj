package cn.gaohank.idea.java.base_03_class;

public class Class04Inner {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // 加上public可以被外部类创建对象，默认是private
    public class InnerClass {
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getOuterValue() {
            return Class04Inner.this.value;
        }

        public void setOuterValue(int value) {
            Class04Inner.this.value = value;
        }
    }

    // static修饰不需要实例外部类
    public static class InnerStaticClass {
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
