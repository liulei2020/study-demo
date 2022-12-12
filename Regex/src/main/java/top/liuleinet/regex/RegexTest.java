package top.liuleinet.regex;

import java.util.regex.Pattern;

/**
 * @classname: RegexTest
 * @author: lei.liu
 * @description: 正则测试
 * @date: 2022/11/16
 * @version: v1.0
 **/
public class RegexTest {
    public static void main(String[] args) {
        String content = "hello";
        String pattern = ".*el.*";
        Boolean isMatch = Pattern.matches(pattern,content);
        System.out.println("字符串" + content + "中是否包含了 'el' 子字符串? " + isMatch);

        System.out.println("\\");
        System.out.println("\\\\");

        String content1 = "zoo";
        String content2 = "z";
        String pattern1 = "zo*";
        Boolean isMatch2 = Pattern.matches(pattern1,content1);
        Boolean isMatch3 = Pattern.matches(pattern1,content2);
        System.out.println(isMatch2);
        System.out.println(isMatch3);
    }
}
