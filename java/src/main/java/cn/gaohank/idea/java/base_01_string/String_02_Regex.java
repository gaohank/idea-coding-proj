package cn.gaohank.idea.java.base_01_string;

import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

/*
 * 正则表达式
 *
 * "."代表任意一个字符
 * "\"转义字符
 * \d    表示任意一个数字
 * \w    表示任意一个字符，数字、字母、下划线
 * \s    表示任意一个空白字符（\t \r \n \f \x0B）
 * \D    表示任意一个非数字字符
 * \W    表示任意一个非单词字符
 * \S    表示任意一个非空白字符
 *
 * {n}    匹配n个内容
 * {n,}   至少匹配n个
 * {n,m}  匹配n到m个
 *
 * ()分组
 * (() | ()) 表示或关系
 *
 * ^$表示开头或者结尾
 *
 */
public class String_02_Regex {
    public static void main(String[] args) throws PatternSyntaxException {
        String str = "hello";
        System.out.println(str.matches("\\w+"));
        System.out.println(str.replace("l", "world"));
        System.out.println(str.replaceAll("l", "world")); // 替换所有
        System.out.println(str.replaceFirst("l", "world")); // 替换第一个

        str = "hello world";
        String[] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));

        String regex = ".";
        String array[] = {"1", ".", "\\", "=", "\t", "abc", "$"};

        // 判断每一个元素是否匹配
        for (String s : array) {
            System.out.println(s.matches(regex));
        }

        str = "hello";
        // 替换为6
        System.out.println(str.replaceAll("[[:alpha:]]", "6"));

        // 把第一个符合条件的替换成"ff"
        regex = "\\w";
        str = "$jdk8";
        System.out.println(str.replaceAll(regex, "6"));

        // 把任意一个非，。的标点替换为空格
        regex = "[^\u4E00-\u9FA5^\\w^，。]";
        str = "12，,.4。你好hello,$$..￥￥.￥￥world$";
        System.out.println(str.replaceAll(regex, " "));

        // 把字符串分成多个子字符串
        str = "天安门，王府井，大栅栏，鸟巢";
        String strs[] = str.split("，");
        System.out.println(Arrays.toString(strs));
    }
}
