package practice.practice.regexp;

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
   //只允许输入01，06两个值
    @Test
    public void test(){
        Pattern p = Pattern.compile("^0[1,6]$");
        Matcher m = p.matcher("0");
        Matcher m1 = p.matcher("01");
        Matcher m2 = p.matcher("02");
        Matcher m3 = p.matcher(" ");
        Matcher m4 = p.matcher("1");
        Matcher m5 = p.matcher("16");
        Matcher m6 = p.matcher("11");
        Matcher m7 = p.matcher("61");
        Matcher m8 = p.matcher("00");
        Matcher m9 = p.matcher("012");
        System.out.println(m.matches());
        System.out.println(m1.matches());
        System.out.println(m2.matches());
        System.out.println(m3.matches());
        System.out.println(m4.matches());
        System.out.println(m5.matches());
        System.out.println(m6.matches());
        System.out.println(m7.matches());
        System.out.println(m8.matches());
        System.out.println(m9.matches());
    }
    //允许输入01~08这之间的数字
    @Test
    public void test2(){
        Pattern p = Pattern.compile("^[0][1-8]$");
        Matcher m = p.matcher("0");
        Matcher m1 = p.matcher("01");
        Matcher m2 = p.matcher("02");
        Matcher m3 = p.matcher("09");
        Matcher m4 = p.matcher("08");
        System.out.println(m.matches());
        System.out.println(m1.matches());
        System.out.println(m2.matches());
        System.out.println(m3.matches());
        System.out.println(m4.matches());
    }
    //满足长度要求的数字，限定数字的长度
    @Test
    public  void testLen(){
        Pattern p=Pattern.compile("^\\d{6,30}$");
        int tar =1000;
        int tar1 =100000;
        int tar2 =10000000;
        String num = ranNumStr(tar);
        String num1 = ranNumStr(tar1);
        String num2 = ranNumStr(tar2);
        Matcher m = p.matcher(num);
        Matcher m1 = p.matcher(num1);
        Matcher m2 = p.matcher(num2);
        System.out.println(m.matches()+"|长度："+num.length());
        System.out.println(m1.matches()+"|长度："+num1.length());
        System.out.println(m2.matches()+"|长度："+num2.length());

    }
    //匹配 其中这几个字符之一 ，可为2个也可为多个
    @Test
    public void testMust(){
        Pattern p = Pattern.compile("^I|U|a$");
        Matcher m = p.matcher("I");
        Matcher m1 = p.matcher("a");
        Matcher m2 = p.matcher("U");
        Matcher m3 = p.matcher("u");
        System.out.println("I是否匹配："+m.matches());
        System.out.println("a是否匹配："+m1.matches());
        System.out.println("U是否匹配："+m2.matches());
        System.out.println("u是否匹配："+m3.matches());
    }
    //生成[maxInt ~maxInt*2]范围内的数 返回String
    private String ranNumStr(int maxInt){
        int res = (int) (Math.random() * maxInt)+maxInt;
        return res+"";

    }
    //指定的字符允许
    @Test
    public void testEng(){
        Pattern P = Pattern.compile("^A|C|D|F$");
        Matcher a = P.matcher("A");
        Matcher c = P.matcher("C");
        Matcher d = P.matcher("D");
        Matcher f = P.matcher("F");
        Matcher a1 = P.matcher("a");
        Matcher a2 = P.matcher("b");
        Matcher a3 = P.matcher("d");
        Matcher a4 = P.matcher("f");
        Matcher a5 = P.matcher("1");
        Matcher a6 = P.matcher("");
        System.out.println(a.matches());
        System.out.println(c.matches());
        System.out.println(d.matches());
        System.out.println(f.matches());
        System.out.println(a1.matches());
        System.out.println(a2.matches());
        System.out.println(a3.matches());
        System.out.println(a4.matches());
        System.out.println(a5.matches());
        System.out.println(a6.matches());
    }

}

