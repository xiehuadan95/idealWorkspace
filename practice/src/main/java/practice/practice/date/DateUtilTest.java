package practice.practice.date;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author xiehu
 * @Date 2022/6/10 16:39
 * @Version 1.0
 * @Description hutool的 DateUtil 时间工具类的方法使用 格式化
 */
public class DateUtilTest {
    //入参 yyyy-MM格式 字符串
    @Test
    public void test(){
        String date="2022-12";
        //转为Date类型
        Date parseDate = DateUtil.parse(date, "yyyy-MM");
        System.out.println("Hutool转换str为目标格式日期："+parseDate);
        //获得此月的起始月 和结束日期
        Date dateBegin = DateUtil.beginOfMonth(parseDate);
        Date dateEnd = DateUtil.endOfMonth(parseDate);
        System.out.println("起始月份时间："+dateBegin+"|结束月份时间："+dateEnd);
        //格式化后的时间默认为起始月份的时间
        System.out.println(parseDate.equals(dateBegin));
    }
    //sql里面得dateTimeStamp对应java得类型
    @Test
    public void test1() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.ENGLISH);
        sdf.setLenient(false);
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println("现在时间："+format);
        Date parse = sdf.parse(format);
        System.out.println("设定时间："+parse);
    }
}
