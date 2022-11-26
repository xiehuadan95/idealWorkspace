package practice;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxpTest {
    @Test
    public void test1(){
        /*
        //[a-z]表示a~z之间的任何一个字符, {3}表示3个字符, 意思是匹配一个长度为3, 并且每个字符属于a~z的字符串
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("abc");
        System.out.println(m.matches());
    }
         */
        //[a-z]表示a~z之间的任何一个字符, {3}表示3个字符, 意思是匹配一个长度为3, 并且每个字符属于a~z的字符串
        //Pattern p = Pattern.compile("^([1-9][0-9]{0,2},[1-9][0-9]{0,2})?$");
       Pattern p = Pattern.compile("^([1-9])?$");  //如果是空串匹配，如果是空串有空格是不匹配的
        //Pattern p = Pattern.compile("^[1-9]|\\s$"); //同 ？有区别，如果是带有空格的空字符串是匹配的，空串不匹配
        Matcher m = p.matcher("1");
        Matcher m1 = p.matcher("");
        Matcher m2 = p.matcher(" ");
        Matcher m3 = p.matcher(",");
        System.out.println(m.matches());
        System.out.println(m1.matches());
        System.out.println(m2.matches());
        System.out.println(m3.matches());
    }
//    Integer 与 int的比较
    @Test
    public void test(){
        Integer i =2000;
        int a =2000;
        int i1 = i.intValue();
        System.out.println(i.equals(a));
        System.out.println(a==i1);
        int b=300;
        System.out.println(a>b);

    }
}

