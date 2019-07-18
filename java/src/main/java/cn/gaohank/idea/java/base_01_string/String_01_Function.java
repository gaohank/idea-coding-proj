package cn.gaohank.idea.java.base_01_string;

public class String_01_Function {
    public static void main(String[] args) {
        String name = "gao song ling";

        System.out.println(name.indexOf(" "));
        System.out.println(name.substring(0, name.indexOf(" ")));

        System.out.println(name);
        System.out.println(name.equals("helo"));
        System.out.println(name.charAt(2));
        System.out.println(name.codePointAt(1)); // 返回unicode字符集中的编号
        System.out.println(name.concat("is a man")); // 连接
        System.out.println(name.contains("song")); // 字符串中是否包含给定字符串
        System.out.println(name.compareTo("gao songling")); // 比较字符串
        System.out.println(name.toUpperCase());
        System.out.println(name.indexOf('o'));
        System.out.println(name.indexOf("song"));
        System.out.println(name.indexOf('g', 1));
        System.out.println(name.trim());    // 去掉首尾的空格

        char myname[] = {'h', 'a', 'n', 'k'};
        System.out.println(String.copyValueOf(myname));
        System.out.println(name);

        String s1 = "test.txt";
        System.out.println(s1.endsWith(".txt"));	// 查找是否以".txt"结尾
        System.out.println(s1.startsWith("test"));  // 查找前缀是否以开头
        System.out.println(s1.equalsIgnoreCase("TEST.TXT")); // 忽略大小写

        byte[] b = name.getBytes();
        System.out.println(b.length);
        System.out.println(b[0]);

        System.out.println(s1.replace('t', 'a')); // 替换
        System.out.println(s1.substring(2)); // 截取字符串
        System.out.println(s1.substring(2, 4)); // 包头不包尾

        System.out.println(String.format("%.2f", 12.334456));

    }
}
