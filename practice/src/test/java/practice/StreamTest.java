package practice;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import practice.entity.NodeVO;
import practice.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
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
            userList.add(user);
        }
        User user = new User();
        user.setName("haha");
        user.setScore(100);
        userList.add(user);
        System.out.println("原数据" + userList);
        List<Integer> collect = userList.stream().filter(x -> !"jackLove".equals(x.getName()))
                .map(User::getScore).collect(Collectors.toList());
        System.out.println("符合条件的数据" + collect);
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
        System.out.println("截取后的list"+list);
        String collect = list.stream().collect(Collectors.joining(","));
        String res = String.join(",",list);
        System.out.println(collect);
        System.out.println("将list用符号隔开转换为String:"+res);
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
    public void integerTest(){
        ArrayList<String> list =new ArrayList<String>(1);
        list.add("ALL");
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }
    //有子节点，输出为树结构返回给前端
    //list转树形方
    @Test
    public void treeTest(){
        NodeVO N1 = new NodeVO("1", "山东省", "0");
        NodeVO qd = new NodeVO("2", "青岛市", "1");
        NodeVO qd1 = new NodeVO("3","市北区","2");
        NodeVO jn = new NodeVO("4","济南市","1");
        NodeVO N2 = new NodeVO("5","浙江省","0");
        NodeVO hz = new NodeVO("6","杭州市","5");
        NodeVO hz1 = new NodeVO("7","西湖区","6");
        NodeVO hz2 = new NodeVO("8","别墅区","6");
        List<NodeVO> list = new ArrayList<>();
        list.add(N1);list.add(qd);list.add(qd1);list.add(jn);
        list.add(N2);list.add(hz);list.add(hz1);list.add(hz2);
        //默认父节点为0
        List<NodeVO> nodeVOS = streamToTree(list, "0");
        //转换为json输出结果
        String res = JSON.toJSONString(nodeVOS);
        System.out.println(res);
    }

    private List<NodeVO> streamToTree(List<NodeVO> treeList,String parentId) {
        //过滤父节点
        List<NodeVO> list = treeList.stream()
                .filter(parent -> parent.getPid().equals(parentId))
                //把父节点children递归赋值 成为子节点
                .map(child -> {
                    child.setChildren(streamToTree(treeList, child.getId()));
                    return child;
                }).collect(Collectors.toList());
        return list;
    }
}
