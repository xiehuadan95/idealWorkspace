package practice.practice.dataStructure;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/6/2 14:09
 * @Version 1.0
 * @Description 前缀数组！
 * <p>
 * 最基本数据结构包含 数组（便于寻址，不便于增删数据） ，链表（便于增删数据，不便于寻址）
 * 这里为前缀数组，当需要计算 数组里面某个区间的数据和的时候，不需要每次计算每次大范围遍历再求和，而是提前求一次 再根据规律去寻找
 */
public class PrefixArray {
    @Test
    public void testPre() {
        int arr[] = {1, 23, 4, 12, 10, 4, 0, 8};
        //遍历一次 将每个位置的和计算出来存到数组里（也可建新数组来存）
        //转换为前缀数组
        int[] preArr = rangeSum(arr);  //[1, 24, 28, 40, 50, 54, 54, 62]
        //通过方法 查找自定义的信息
        Integer res = resultSum(preArr, 1, 4);
    }

    private Integer resultSum(int[] arr,int L,int R) {
         if(R-L<0 || L<0){
             System.out.println("===输入参数不合法===");
             return null;
         }
       int res =  L==0 ? arr[0]:arr[R]-arr[L-1];
        System.out.println(L+"号位到"+R+"号位的总和结果是："+res);
        return res;
    }

    //将数组的和都算出来 放在相应的位置上，0~0号位的和放0号位，0~1号位的和放1号位，0~2号位的和放2号位，0到N号位的和放n号位
    private int[] rangeSum(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int n =array.length;
        int[] preArr=new int[n];
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum+=array[i];
            preArr[i]=sum;
        }
        System.out.println("第一次遍历，组合成前缀数组"+Arrays.toString(preArr)); //
        return preArr;
    }
}
