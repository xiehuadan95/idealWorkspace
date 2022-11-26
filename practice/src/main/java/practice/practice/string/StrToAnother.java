package practice.practice.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xiehu
 * @Date 2022/5/23 17:25
 * @Version 1.0
 * @Description
 */
public class StrToAnother {
    //Double String 转换，避免科学计数法并最后得到String 保留两位小数
    @Test
    public void strToDoub() {
        String d = "37428939900.23";
        String d1 = "37428939900.1";
        String d2 = "37428939900";
        String d3="342332349.1";
        //需要将金额字符串 转换为保留两位小数的金额字符串
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String res = decimalFormat.format(new BigDecimal(d));
        System.out.println("正常有两位小数的数据：" + res);
        String res1 = decimalFormat.format(new BigDecimal(d1));
        System.out.println("正常有一位小数的数据：" + res1);
        String res2 = decimalFormat.format(new BigDecimal(d2));
        System.out.println("正常没有小数的数据：" + res2);
        //转为带逗号的金额格式
        DecimalFormat df2 = new DecimalFormat("###,###.00");
        String d3Str = df2.format(new BigDecimal(d3));
        System.out.println("\""+d3Str+"\"");
        //如果数值位数不够
        String format = df2.format(new BigDecimal("1"));
        System.out.println("当数据位数不够的时候："+format);
    }

    //Double 转String 避免科学计数法
    @Test
    public void doubToStr() {
        Double d = 37428939900.23;
        String s = String.valueOf(d);
        String s1 = Double.toString(d);
        System.out.println("普通方式转换1：" + s + " 普通方式转换2" + s1 + " 均有科学计数法");
        //避免科学计数法
        String res = new BigDecimal(Double.toString(d)).toPlainString();
        System.out.println(res);
    }

    //将数字转换为String类型 或者String转换为数字
    @Test
    public void strToNum() {
        int a = 100;
        String b = String.valueOf(a);
        System.out.println(b);
        String c = "1";
        int res = Integer.parseInt(c);
        if (-2 != res) {
            System.out.println(res);
        }
    }

    //int整数 左填充0 固定总位数 得到String
    @Test
    public void strFill() {
        int tar = 1234;
        //0 代表要补的0（不能补字符，如果没有，就会填充空格） 6是最后总的字符长度  d 表示参数位整数类型
        String res = String.format("%06d", tar);
        System.out.println("左补位0，补全后共六位：" + res);
        String res1 = String.format("%017d", tar);
        System.out.println("左补位0，补全后共十七位：" + res1);
        String res2 = String.format("%10d", tar);
        System.out.println("左补位无内容，补全后共十位：" + res2 + " 补全后的字符串长度：" + res2.length());
        //目标为字符串 右补空位
        String tarS = "abcd";
        String resS = String.format("%-6s", tarS);
        System.out.println("右补全共六位：|" + resS + "|长度为：" + resS.length());
        //目标为字符串 左补空位
        String resS1 = String.format("%16s", tarS);
        System.out.println("左补全共十六位：|" + resS1 + "|长度为：" + resS1.length());
    }

    //目标为double类型实现 左补0，右对齐 计算位数会计算小数点
    //%后的0 表示补0,12表示总计位数；.2 或者.3表示目标的精度的小数位数，会自动截取，f代表目标为浮点数
    @Test
    public void strFillD() {
        Double tar = 30402.234;
        String res = String.format("%012.2f", tar);
        System.out.println("左补0，共12位，精度2位：" + res + "|长度为：" + res.length());
        String res1 = String.format("%012.3f", tar);
        System.out.println("左补0，共12位，精度3位：" + res1 + "|长度为：" + res1.length());
        System.out.println("=================================================");
        double tar1 = 30402.1;
        String res2 = String.format("%.2f", tar1);
        System.out.println("左补0，共12位，精度2位：" + res2 + "|长度为：" + res2.length());
        String res3 = String.format("%12.2f", tar1);
        System.out.println("左补空格，共12位，精度2位：[" + res3 + "]长度为：" + res3.length());
        String res4 = String.format("%-12.2f", tar1);
        System.out.println("右补空格，共12位，精度2位：[" + res4 + "]长度为：" + res4.length());
    }

    //String工具类 对字符串进行 左右补齐
    //org.apache.commons.lang3.StringUtils;
    @Test
    public void strFillUtils() {
        String tar = "012ATarget";
        String resL = StringUtils.leftPad(tar, 12, "L");
        System.out.println("左补位L+[" + resL + "]补全后长度为：" + resL.length());
        String r = StringUtils.rightPad(tar, 12, "R");
        System.out.println("右补位R+[" + r + "]补全后长度为：" + r.length());
        String res = StringUtils.leftPad(tar, 12);
        System.out.println("左补位空格+[" + res + "]补全后长度为：" + res.length());
        String s = StringUtils.rightPad(tar, 12);
        System.out.println("右补位空格+[" + s + "]补全后长度为：" + s.length());
    }
    //自增操作，自增的数据转为String
    @Test
   public void autoStr(){
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            System.out.print(count.incrementAndGet()+" ");
        }
    }
    @Test
    public void objToStr(){
        Object o = new Object();
        o="";
        System.out.println(o.toString());
        if("".equals(o)){
            System.out.println("字符串可与字符串对象比较，equals方法通用！");
        }
        if(null==o){
            System.out.println("空串喝null是有区别的，不是一个东西");
        }
        o=null;
        System.out.println((String)o);
        String res = null!=o ? o.toString():"[]";
        System.out.println(res);
    }
    //字符串列表 的内容 往stringBuffer里面添加 并换行
    @Test
    public void strToBuf(){
        List<String> list =new ArrayList<>();
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 20; i++) {
            if(i==16 || i==17){
                list.add(" ");
            }else {
                list.add(""+count.incrementAndGet());
            }
        }
        System.out.println(list);
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i <= list.size(); i++) {
            if(i%4!=0){
                buffer.append(list.get(i-1)).append(",");
            }else {
                buffer.append(list.get(i-1)).append("\r\n");
            }
        }
        System.out.println(buffer);
    }
    //字符串截取 姓名脱敏
    @Test
    public void strSub(){
       List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add("张"+i);
        }
        list.add("张三四");
        list.add(null);
        list.add("");
        for (int i = 0; i < list.size(); i++) {
            if (null != list.get(i) && !"".equals(list.get(i))) {
                String res = list.get(i).substring(0, 1);
                for (int j = 0; j < list.get(i).length() - 1; j++) {
                    res += "*";
                }
                list.set(i, res);
            }
        }
        System.out.println(list);
        String str ="2022-02-03 15:30:10";
        System.out.println("截取时间只保留年月日:"+str.replace("-","/").substring(0, 10));
        System.out.println("截取时间只保留年月日:"+str.replace("-","/").substring(8, 10));

    }
    //一些转译字符得意思
    @Test
    public void test2(){
        String name ="haah.lala.pdf";
        //在原有文件名后面再加后缀
        String concat = name.concat(".").concat(name.substring(name.lastIndexOf(".")+1));
        System.out.println(concat);
        //最后出现'.'这个字符的下标是多少
        int index =name.lastIndexOf(".");
        System.out.println("出现.这个字符的下标是："+index);
        String subRes = name.substring(index + 1);
        System.out.println("截取后的结果|："+subRes);
        //换行
        System.out.println("\n===换行的转译符===\n啦啦啦\n哈哈哈");
        //回车
      System.out.print("\r===回车转译符===回车啦");
        //回车换行，光标移到行首
        System.out.print("===回车换行===\r\n回车换行\r\n并且到了行首\\打印出了\\斜杠");
    }
    @Test
    public void test3(){
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> hk = new HashMap<>();
        map.put("1","234");
        hk.putAll(map);
        System.out.println(hk.get("1"));
    }
    @Test
    public void test4(){
        String a ="01";
        String b ="02";
        String msg = "hahah";
        if(msg!=null && (a.equals("02")||b.equals("02"))){
            System.out.println(msg);
        }
        if(msg!=null && (a.equals("01")||b.equals("01"))){
            System.out.println(msg);
        }
        if(msg!=null && (a.equals("01")||b.equals("02"))){
            System.out.println(msg);
        }
        if(msg!=null && (a.equals("03")||b.equals("02"))){
            System.out.println(msg);
        }
        if(msg!=null && (a.equals("03")||b.equals("03"))){
            System.out.println(msg);
        }
        if(msg!=null && (a.equals("01")||b.equals("03"))){
            System.out.println(msg);
        }
    }
    @Test
    public void testRe(){
        String name="user.";
        name=name.replaceAll("\\.","/");
        System.out.println(name);
    }
    @Test
    public void testStr(){
        String xm="买买提-sd·d（）中文";
        String name="买买提-sd·d()中文";
        System.out.println(xm.equals(name));
        System.out.println(xm.trim().equals(name.trim()));
        System.out.println(xm.length()+"|"+name.length());
    }



}

