package practice.practice.stream;

import org.junit.Test;
import practice.entity.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @Author xiehu
 * @Date 2022/7/15 10:08
 * @Version 1.0
 * @Description Stream基础的一些常规用法
 */
public class StreamTest {
    @Test
    public void test() {
        String a = "123";
        String b = "231";
        if (!a.equals(b)) {
            System.out.println("haha");
        }
    }

    @Test
    public void testList() {
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setAge(18 + i);
            user.setPerson(true);
            userList.add(user);
        }
        System.out.println(userList);
        userList.forEach(item -> item.setScore(100));
        System.out.println(userList);
    }

    //按条件筛选内容 并且将符合条件的对象的某个值拿出来
    @Test
    public void filterTest() {
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setAge(18 + i);
            user.setPerson(true);
            user.setScore(i * 20);
            user.setDate(new Date());
            userList.add(user);
        }
        User user = new User();
        user.setName("haha");
        user.setScore(100);
        user.setAge(20);
        userList.add(user);
        System.out.println("原数据" + userList);
        List<User> collect = userList.stream().filter(x -> x.getAge() > 50
        ).map(e -> new User(e.getId(), e.getAge(), e.getName(), e.getPerson(), e.getScore(), e.getDate()))
                .collect(Collectors.toList());

        if (collect == null || collect.size() == 0) {
            System.out.println(collect);
        }

        ArrayList<User> userList2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user1 = new User();
            user1.setAge(18 + i);
            user1.setPerson(true);
            user1.setScore(i * 20);
            userList2.add(user1);
        }
        System.out.println(userList2);
        boolean b = userList.addAll(userList2);
        System.out.println(b);
        System.out.println(userList);
        ArrayList<User> userList3 = new ArrayList<>();
        boolean b1 = userList.addAll(userList3);
        System.out.println(userList3);
        System.out.println(b1 + "新集合" + userList);
//        System.out.println(collect.size());
//      System.out.println("符合条件的数据" + collect);


    }

    // 将String的集合转换为 用逗号隔开的一个String
    @Test
    public void stringTest() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String s = "及九九" + i;
            list.add(s);
        }
        System.out.println(list);
        //截取list
        list = list.subList(6, 8);
        System.out.println("截取后的list" + list);
        String collect = list.stream().collect(Collectors.joining(","));
        String res = String.join(",", list);
        System.out.println(collect);
        System.out.println("将list用符号隔开转换为String:" + res);
    }

    //将String数据根据逗号，拆分成一个list<String>类型数据
    @Test
    public void stringTest1() {
        String tar = "123,sx,2,23f,wef,sef";
        ArrayList<String> areaList = new ArrayList<>();
        System.out.println(tar);
        List<String> res = Arrays.asList(tar.split(","));
        System.out.println(res);
    }

    @Test
    public void integerTest() {
        ArrayList<String> list = new ArrayList<String>(1);
        list.add("ALL");
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }


    @Test
    public void testMap() {
        Map map = new HashMap<>();
        List list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String s = "及九九" + i;
            list2.add(s);
        }
        map.put("list", list2);
        List list1 = (List) map.get("list");
        System.out.println(list1.get(0));
    }

    //根据对象的条件 进行排序 字符串的日期格式，倒序排 同时赋值
    @Test
    public void testSort() {
        ArrayList<User> userL = new ArrayList<>();
        Date date = new Date();
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setAge(18 + i);
            user.setPerson(true);
            user.setName("20220526000000");
            user.setScore(i * 20);
            user.setDate(date);
            userL.add(user);
        }
        User user1 = new User();
        user1.setName("20220412155");
//        userL.add(user1);
        User user2 = new User();
        //如果是 null  会报空指针异常 但可以是“”
        user2.setName("123");
//        userL.add(user2);
        long j = 1;
        AtomicLong d = new AtomicLong(0);
        // userL.stream().sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors.toList()).forEach(x->x.setId(d.incrementAndGet()));
        List<User> collect = userL.stream().sorted(Comparator.comparing(User::getDate).reversed()).collect(Collectors.toList());
        collect.forEach(x -> x.setId(d.incrementAndGet()));
        System.out.println(collect);
        /*for (long i = 0; i < collect.size(); i++) {
            j++;
            collect.get((int) i).setId(j);
        }
        System.out.println(collect);*/
        System.out.println(userL);
        System.out.println(j);
    }



    //流处理姓名脱敏
    @Test
    public void strName() {
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("age", 10 + i + "");
            map.put("userName", "张" + i);
            map.put("sex", "男");
            dataList.add(map);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("age", "30");
        map.put("userName", null);
        map.put("sex", "女");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("age", "40");
        map1.put("userName", "");
        map1.put("sex", "女");
        dataList.add(map);
        dataList.add(map1);
        System.out.println("待处理数据" + dataList);
        //脱敏流处理
        dataList = dataList.stream().map(e -> {
            if (null != e.get("userName") && !"".equals(e.get("userName") + "")) {
                String userName = e.get("userName").toString();
                String res = userName.substring(0, 1);
                for (int i = 0; i < userName.length() - 1; i++) {
                    res += "*";
                }
                e.put("userName", res);
            }
            return e;
        }).collect(Collectors.toList());
        System.out.println("流处理后的数据集合" + dataList);

    }


}
