package cn.gaohank.idea.java.base_12_annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Matcher("equals")
public class EqualMatcher {
    @Matcher("equals")
    public boolean Match(String l, String r) {
        return l.equals(r);
    }

    public static void main(String[] args) {
        Class<?>[] declaredClasses = EqualMatcher.class.getDeclaredClasses();
        for (Class<?> declaredClass : declaredClasses) {
            System.out.println(declaredClass);
            System.out.println(declaredClass.isAnnotation());
            System.out.println(declaredClass.isAnnotationPresent(Matcher.class));
        }

        Field[] fields = EqualMatcher.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.isAnnotationPresent(Matcher.class));
        }

        Method[] declaredMethods = EqualMatcher.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
            System.out.println(declaredMethod.isAnnotationPresent(Matcher.class));
            if (declaredMethod.isAnnotationPresent(Matcher.class)) {
                Matcher annotation = declaredMethod.getAnnotation(Matcher.class);
                if (annotation.value().equals("equals")) {
                    System.out.println("test annotation is equals");
                }
            }
        }
    }
}
