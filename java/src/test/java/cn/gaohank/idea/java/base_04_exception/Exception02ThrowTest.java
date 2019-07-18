package cn.gaohank.idea.java.base_04_exception;

import org.junit.Test;

public class Exception02ThrowTest {

    @Test
    public void throwException() throws Exception02Throw {
        Exception02Throw exception02Throw = new Exception02Throw();
        try {
            exception02Throw.throwException(null);
        } catch (Exception02Throw e) {
            System.out.println("exception is " + e);
        }
    }
}