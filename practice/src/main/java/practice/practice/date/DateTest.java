package practice.practice.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {
    //传统Date类格式化为yyyyMMdd
    @Test
    public void test() {
        Date date1 = new Date();
        System.out.println(date1);
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        String nowDate = yyyyMMdd.format(date1);
        System.out.println(nowDate);
    }

    //JDK8 日期方式 新旧对比，以前的方式线程不安全，新方式线程安全
    @Test
    public void test1() {
        Date oldDate = new Date();
        //LocalDate 时间统一为年月日 2022-00-22 格式
        LocalDate nowDate = LocalDate.now();
        System.out.println("以前常用的日期方式：" + oldDate + "字符串后" + oldDate.toString() + "现在用的日期方式：" + nowDate + "字符串后" + nowDate.toString());
        //以前常用的日期方式：Mon Apr 18 15:11:27 CST 2022字符串后Mon Apr 18 15:11:27 CST 2022现在用的日期方式：2022-04-18字符串后2022-04-1
        //格式化 可用yyyy-MM-dd 、yyyyMMdd 、yyyyMMdd HH:mm:ss 、yyyy/MM/dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String oldDateF = sdf.format(oldDate);
        System.out.println("老方式格式化时间后:" + oldDateF);
        //老方式格式化时间后:2022-04-18
        //新日期方式 格式化操作
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String nowTime = nowDate.format(dtf);
        String nowTime2 = nowDate.format(dateTimeFormatter);
        System.out.println("新时间格式化为：" + nowTime + nowTime2);
        //新时间格式化为：2022/04/18
    }

    //LocalDate的转换
    @Test
    public void strToLD() {
        //LocalDate转String
        LocalDate now = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dateStr = now.format(dtf);
        System.out.println("LocalDate转String:" + dateStr);
        //date转LocalDate
        Date date = new Date();
        LocalDateTime date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        String dateStr1 = date1.format(dtf);
        System.out.println("Date转LocalDate:" + dateStr1);
    }

    //时间戳转LocallDateTime
    @Test
    public void daTimeToLD() {
        long timeStamp = System.currentTimeMillis();
        System.out.println("转换之前：" + timeStamp);
        Instant instant = Instant.ofEpochMilli(timeStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("时间戳转LocalDateTime:" + localDateTime);
    }

    //常用api
    @Test
    public void localDateTest() {
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println("目前具体的时间" + nowTime);
        LocalDate nowDate = LocalDate.now();
        System.out.println("目前的日期：" + nowDate);
        LocalDateTime nowTimeMn = LocalDateTime.MIN;
        LocalDateTime nowTimeMx = LocalDateTime.MAX;
        System.out.println("最小时间" + nowTimeMn);
        System.out.println("最大时间" + nowTimeMx);
        /* 目前具体的时间2022-04-19T10:40:05.589
           目前的日期：2022-04-19
        */
        //getYear() 获取当前年份 LocalDateTime和 LocalDate均可
        System.out.println("获取当前日期的年份:" + nowTime.getYear());
        System.out.println("获取当前日期的月份:" + nowTime.getMonth());
        System.out.println("获取当前日期是第几月:" + nowTime.getMonthValue());
        System.out.println("表示该对象标识的是星期几:" + nowTime.getDayOfWeek());
        System.out.println("表示该对象表示的日期是这个月第几天:" + nowTime.getDayOfMonth());
        System.out.println("表示该对象表示的日期是今年的第几天:" + nowTime.getDayOfYear());
        System.out.println("目前的分钟数：" + nowTime.getMinute());
        System.out.println("============= LocalDate 独有API =========================");
        //LocalDate 才有 的 API
        System.out.println("是否是闰年：" + nowDate.isLeapYear());
        System.out.println("这个月有多少天：" + nowDate.lengthOfMonth());
        System.out.println("今年有多少天：" + nowDate.lengthOfYear());
    }

    //操作类API
    @Test
    public void testApi() {
        LocalDate now = LocalDate.now();
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println("目前时间" + nowTime);
        LocalDateTime oldTime = nowTime.withYear(1999);
        System.out.println("修改目前年份为1999后的时间：" + oldTime);
        LocalDateTime oldTime2 = oldTime.withMonth(2).withHour(12).withMinute(30).withSecond(20).withNano(112);
        System.out.println("修改时间年月日时分秒：" + oldTime2);
        //当前时间对象增加指定年份月份时间
        LocalDateTime oldTime3 = oldTime2.plusYears(10).plusMonths(1).plusHours(2).plusMinutes(10).plusNanos(1000);
        System.out.println("修改后的时间：oldTime3="+oldTime3);
        /*
        修改目前年份为1999后的时间：1999-04-19T11:10:27.415
        修改时间年月日时分秒：1999-02-19T12:30:20.000000112
        修改后的时间：oldTime3 = 2009-03-19T14:40:20.000001112
         */
        //当前时间对象减去指定的年份、天数等
        LocalDateTime oldTime4 = oldTime3.minusYears(2).minusDays(380).minusHours(1);
        System.out.println("修改后的时间：oldTime4 = "+oldTime4);
        //修改后的时间：oldTime4 = 2006-03-04T13:40:20.000001112
        //两日期对比，如果返回为正，表示比目标时间晚 反之为负
        int res = oldTime3.compareTo(oldTime4);
        //2009年 比 2006年 晚三年   oldTime3和oldTime4对比：3
        System.out.println("oldTime3和oldTime4对比："+res);
        int res2 = oldTime4.compareTo(oldTime3);
       // oldTime4和oldTime3对比：-3
        System.out.println("oldTime4和oldTime3对比："+res2);
        //比较当前对象日期是否在某对象日期之前
        boolean before = oldTime.isBefore(oldTime3);
        //true
        System.out.println("oldTime是否在oldTime3之前："+before);
        boolean after = oldTime.isAfter(oldTime3);
        //false
        System.out.println("oldTime是否在oldTime3之后："+after);
        boolean equal = oldTime.isEqual(oldTime2);
        //false
        System.out.println("oldTime是否与oldTime3相等："+equal);
    }
    //时间转换为 带年月日时分秒
    @Test
    public void testTime(){
        Date date = new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = time.format(date);
        String year = format.substring(0,4);
        String month = format.substring(4,6);
        String day = format.substring(6,8);
        String hours =format.substring(8,10);
        String minutes = format.substring(10,12);
        String seconds =format.substring(12,14);
        System.out.println(year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒");
        System.out.println(format);

    }

    //转为 yyyy/MM/dd HH:mm:ss
    @Test
    public void enTime(){
        Date date = new Date();
        System.out.println("目标时间："+date);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("格式化后的时间："+format);
    }
    //对时间类字符串进行截取
    @Test
    public void timeStrSub(){
        Date date = new Date();
        System.out.println(date.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("目标时间："+format);
        //不要最后两位
        String res = format.replace('-','/').substring(0, format.length() - 3);
        System.out.println("截取后的字符串为："+res);
    }

}
