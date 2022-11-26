package practice.practice.json;

import org.junit.Test;
import practice.entity.NodeVO;
import practice.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author xiehu
 * @Date 2022/6/29 14:44
 * @Version 1.0
 * @Description 有子节点的vo类，返回树形结构给前端
 */
public class JsonVO {
    //有子节点，输出为树结构返回给前端
    //list转树形方
    @Test
    public void treeTest() {
        NodeVO N1 = new NodeVO("1", "山东省", "0");
        NodeVO qd = new NodeVO("2", "青岛市", "1");
        NodeVO qd1 = new NodeVO("3", "市北区", "2");
        NodeVO jn = new NodeVO("4", "济南市", "1");
        NodeVO N2 = new NodeVO("5", "浙江省", "0");
        NodeVO hz = new NodeVO("6", "杭州市", "5");
//        NodeVO hz1 = new NodeVO("7", "西湖区", "6");
//        NodeVO hz2 = new NodeVO("8", "别墅区", "6");
        List<NodeVO> list = new ArrayList<>();
        list.add(N1);list.add(qd);list.add(qd1);list.add(jn);
        list.add(N2);list.add(hz);
//        list.add(hz1);list.add(hz2);
        //默认父节点为0
        List<NodeVO> nodeVOS = streamToTree(list, "0");
        //实体类重写了toString()
        System.out.println("直接输出："+nodeVOS);

    }

    private List<NodeVO> streamToTree(List<NodeVO> treeList, String parentId) {
        //过滤父节点 如果不满足 无children节点，则直接返回的[] 空列表
        List<NodeVO> list = treeList.stream()
                .filter(x -> x.getPid().equals(parentId))
                //把父节点children递归赋值 成为子节点
                .map(e -> {
                    e.setChildren(streamToTree(treeList, e.getId()));
                    return e;
                }).collect(Collectors.toList());
        return list;
    }

    //根据条件 将数据筛选出来同时获取其相应的内容 赋值给新的对象 并建立新的对象集合
    @Test
    public void streamNewObject() {
        ArrayList<User> users = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setAge(10 + i);
            user.setName("A" + i);
            user.setScore(20 * i);
            users.add(user);
        }
        List<NodeVO> collect = users.stream().filter(x -> x.getScore() > 100)
                .map(e -> new NodeVO(null, e.getName(), e.getScore().toString(), null))
                .collect(Collectors.toList());
        //返回的list不可能为null 如果没有数据 也是一个list 只是里面没数据。长度为0
        System.out.println(collect);
        System.out.println(collect.size());
        if (collect.size() == 0) {
            System.out.println("没有匹配的数据");
        }
        System.out.println("结束");
    }
    @Test
    public void mapTest(){
        HashMap<String,Object> result=new HashMap<>();
        HashMap<String,String> map=new HashMap<>();
        map.put("adg","doug");
        map.put("13)_3","sifj)_e");
        System.out.println(map);
        result.putAll(map);
        System.out.println(result.size());
        System.out.println(result+"============");

        if(result==null || result.size()==0) {
            System.out.println(result+"----");
        }
    }
}
