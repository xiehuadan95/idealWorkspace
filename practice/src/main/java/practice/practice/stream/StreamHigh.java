package practice.practice.stream;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import practice.entity.User;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * @Author xiehu
 * @Date 2022/7/15 10:08
 * @Version 1.0
 * @Description Stream进阶复杂用法
 */
public class StreamHigh {
    //取两个list的交集，去重情况下，测试效率,可用guava开源工具包 更快
    @Test
    public void testIn() {
        //先转为set 这样效率最高，list 会遍历处理
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (long i = 1000000000000L; i < 1000000500000L; i++) {
            list.add(Math.random() * 500000L + 1000000000000L + "");
            set.add(Math.random() * 500000L + 1000000000000L + "");
        }
        long l = System.currentTimeMillis();
        List<String> collect = list.stream().filter(set::contains).collect(Collectors.toList());
        System.out.println("耗时:" + (System.currentTimeMillis() - l));

        //用guava 更快
        long l1 = System.currentTimeMillis();
        //将list转为set  用两个set对比
        Set<String> set2 = new HashSet<>(list);
        Sets.SetView<String> intersection = Sets.intersection(set, set2);
        System.out.println("guava耗时：" + (System.currentTimeMillis() - l1));
    }

    //用多线程方式去取数据 得到两个list或者set的交集数据 程序有误暂时未写出
    @Test
    public void testThread() throws ExecutionException, InterruptedException {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            list.add(RandomUtils.nextInt(500000, 1000000) + "");
            list2.add(RandomUtils.nextInt(500000, 1000000) + "");
        }
        System.out.println("抽取其中一个数据:" + list.get(101) + " || " + list2.get(101));
        long startTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        //提交任务获取执行结果 自行写一个对比方法，10000条数据就给要给线程去执行，最后返回对象
        ForkJoinTask<List<String>> f = pool.submit(new Sum(list, list2));
        //关闭线程池
        pool.shutdown();
        List<String> res = f.get();
        long endTime = System.currentTimeMillis();
        System.out.println("多线程耗费时间：" + (endTime - startTime));
        System.out.println("获取到的交集数据数量：" + res.size());

    }

    class Sum extends RecursiveTask<List<String>> {
        //        private static final long serialVersionUID = -4644435596407896760L;
        private List<String> list;
        private List<String> compareList;
        private static final long THRESHOLD = 10000; //分叉的阈值

        public Sum(List<String> list, List<String> compareList) {
            this.list = list;
            this.compareList = compareList;
            this.compute();
        }

        @Override
        protected List<String> compute() {
            //判断范围是否在阈值范围内
            if (THRESHOLD >= list.size()) {
                List<String> res = new ArrayList<>();
                for (String l : list) {
                    if (compareList.contains(l)) {
                        res.add(l);
                    }
                }
                return res;
            } else {
                Sum left = new Sum(this.list.subList(0, this.list.size() / 2), compareList);
                Sum right = new Sum(this.list.subList(this.list.size() / 2 + 1, this.list.size()), compareList);
                //分叉
                left.fork();
                right.fork();
                List<String> join = left.join();
                List<String> join1 = right.join();
                join.addAll(join1);
                return join;
            }
        }
    }

    //流处理将list数据 按照一定条件筛选出来 且去重
    @Test
    public void test2() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            User user = new User();
            if (i < 3) {
                user.setAge(18);
            } else {
                user.setAge(18 + i);
            }
            list.add(user);
        }
        //已知获取到了一个对象列表
        // 对结果集收集的结果再用function函数进行处理，第一个参数是Collector，可以使用Collectors里面的各种工具类
        List<User> groupList = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(
                        () -> new TreeSet<>(
                                //这个比较的方式可自定义
                                Comparator.comparing(
                                        //根据年龄和名字组合去重
                                       x -> x.getAge() + x.getName()
                                        //User::getAge 根据对象年龄来去重
                                )
                        )
                ), ArrayList::new)
        );
        //结果集
        for (User user : groupList) {
            System.out.println(user);
        }
    }
}
