package cn.gaohank.idea.java.base_04_exception;

public class Exception02Throw extends Exception {
    Exception02Throw() {
    }

    private Exception02Throw(String message) {
        super(message);
    }

    public void throwException(String str) throws Exception02Throw {
        if (str == null) {
            throw new Exception02Throw("参数为null异常");
        }
    }

    public void throwRException(String str) {
        if (str == null) {
            throw new RuntimeException("Exception02Throw RuntimeException");
        }
    }
}
