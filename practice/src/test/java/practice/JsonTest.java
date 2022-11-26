package practice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import practice.entity.User;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class JsonTest {
    //将list<对象>转换为jison串
    @Test
    public void JsonArrayTest() {
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setAge(18 + i);
            user.setPerson(true);
            userList.add(user);
        }
        User u = new User();
        Integer age = u.getAge()==null?10:20;
        System.out.println(age);
        //将装有对象的集合list转为json串格式
        String json = JSON.toJSONString(userList);
        System.out.println(json);
        //将json串转换为json数组
        JSONArray jsonArray = JSONArray.parseArray(json);
        System.out.println(jsonArray + "数组的长度" + jsonArray.size());
        System.out.println("转为String格式");
        //数组也可以转为String格式
        String arrayStr = jsonArray.toString();
        System.out.println(arrayStr);
    }
    //String 截取 并去除空格
    @Test
    public void strTest(){
        String a ="123456789   10";
        String res = a.substring(0, 6).trim();
        System.out.println("截取结果：["+res+"]");
    }
    //将数字转换为String类型 或者String转换为数字
    @Test
    public void strTest2(){
        int a=100;
        String b = String.valueOf(a);
        System.out.println(b);
        String c ="1";
        int res = Integer.parseInt(c);
        if(-2 != res){
        System.out.println(res);}
    }
    //运算 根据总数量 手动计算分页数量
    @Test
    public void test(){
        //查出来的总记录数
        int totalCount =10;
        int totalCount1 =5;
        int totalCount2 =21;
        //每页记录数量
        int totalName =10;
        System.out.println("分页数量"+((totalCount+totalName-1)/totalName));
        System.out.println("分页数量"+((totalCount1+totalName-1)/totalName));
        System.out.println("分页数量"+((totalCount2+totalName-1)/totalName));
    }
    //计算String长度
    @Test
    public void strTest3() throws UnsupportedEncodingException {
        Integer maxLength = 90;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("alarmLevel","普通");
        //内容 jsonStr 的length要小于400
        jsonObject.put("alarmMsg","机器[10.83.32.184]-[当月待对账短信提醒业务]-短信发送失败！账号：9012010000031077,密码：2344，31--");
        String  alarmsg = jsonObject.get("alarmMsg").toString();
        System.out.println("获取第一个串："+alarmsg+"长度为："+alarmsg.length());
        String subAlarm = alarmsg.substring(0, (maxLength - 33));
        System.out.println(subAlarm+"截取后的长度"+subAlarm.length());
        //截取完成，存入jsonObject
        jsonObject.put("alarmMsg",subAlarm);
        System.out.println("重新组成json"+jsonObject.toJSONString()+"json长度"+jsonObject.toJSONString().length());
        String jsonStr = jsonObject.toJSONString();
        System.out.println("长度："+jsonStr.length()+"||"+jsonStr);

        jsonStr = jsonStr.length()<100 ? jsonStr : (jsonStr.substring(0, 90)+"}");
        String msg ="短信发送失败！账号：9012010000031077";
        System.out.println("msg长度："+msg.length());
        //subString 方法
        msg = (msg.length()<300) ?msg:msg.replaceAll(" ","").substring(0,6);
        System.out.println("三目表达式："+msg);
       String data =jsonStr.substring(30,34);
       String data1 = "{\"alarmMsg\":\"机器[10.83.32.184]-[当月待对账短信提醒业务]-短信发送失败！账号：9012010000031077\",\"alarmLevel\":\"普通\"}";
        System.out.println("data1的长度："+data1.length());
        //固定的长度
        String data2 ="{\"alarmMsg\":\"\",\"alarmLevel\":\"普通\"}";
        System.out.println(data2.length()+"--固定长度");
        //以逗号分割
        String array = data1.split(",")[0];
        String array1 = data1.split(",")[1];
        System.out.println("分割后的0号位长度"+array.length()+array+"||"+array1+"分割后1号位的长度"+array1.length());
     //0号位进行截取 71字符 70字符
        if(data1.length()<=80){
            System.out.println("刚刚好");
        }else {
            StringBuffer buff = new StringBuffer(80);
            String[] arr = data1.split(",");
            String subStr = arr[0].substring(0,60);
            buff.append(subStr).append("\"").append(",").append(arr[1]);
            String res = buff.toString();
            System.out.println(res+"拼接后的内容，长度为："+res.length());
        }
        System.out.println(data1.split(",")[0].substring(0, 71));
        System.out.println(data1.split(",")[0].substring(0, 70));
        System.out.println("==============");
        System.out.println(data);


        //获得字节数
        byte[] strBytes = jsonStr.getBytes();
        System.out.println("字节数为："+strBytes.length+"字节数组为："+ Arrays.toString(strBytes));
        String demo ="[当月待对账短信提醒业务]-短信发送失败！账号：9012010000031077"; //82字节
        System.out.println(demo.getBytes().length);
        //取42个字节的字符串
        byte[] demoBytes = demo.getBytes(StandardCharsets.UTF_8);
        byte[] res = Arrays.copyOfRange(demoBytes, 0, 80);
        String resStr = new String(res,StandardCharsets.UTF_8);
        System.out.println(resStr);
        System.out.println("截取完的字符串"+resStr+"==字节数："+resStr.getBytes(StandardCharsets.UTF_8).length);

    }
    @Test
    public void testStr(){
        String a ="";
        String b=null;
        if(a.length()>0){
            System.out.println("长度大于0");
        }
        if(a!=null && a.length()==0){
            System.out.println("长度大于0");
        }
        System.out.println("完了");
    }


}
