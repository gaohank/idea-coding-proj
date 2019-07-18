package cn.gaohank.idea.java.base_04_exception;

public class Exception01Try {
    private static void divide_test(int a, int b) {
        try {
            System.out.println(a + "/" + b + "=" + a/b);
        } catch (ArithmeticException e) {
            System.out.println("除0");
        } finally {
            System.out.println("finally divide_test");
        }
        System.out.println("out divide_test");
    }

    private static void arr_test() {
        int arr[] = {0,20,30};

        try {
            divide_test(arr[2], arr[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界");
        } finally { // 不管异常有没有捕获，都会执行。
            System.out.println("finally arr_test");
        }

        System.out.println("out arr_test");
    }

    @SuppressWarnings("null")
    private static void except_test() {
        String str = null;
        try {
            arr_test();
            System.out.println(str.length());
        } catch (ArithmeticException e) {
            System.out.println("除0");
        } catch (NullPointerException e) {
            System.out.println("空指针");
        } finally {
            System.out.println("finally except_test");
        }

        System.out.println("out arr_test");
    }

    public static void main(String[] args) {
        except_test();
    }
}
