package practice.practice.dataStructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/5/31 10:46
 * @Version 1.0
 * @Description 选择排序 将数组里面特定的数据选出来进行排序
 */
public class SelectSort {
    //将数组的最小值取出来 进行排序
    @Test
    public void testMin() {
        int[] arr = {1, 40, -2, 7, 14, 19, 25, 33,23,6};
        //排序方法
        sortMeth(arr);
        System.out.println(Arrays.toString(arr));
    }
    private void sortMeth(int[] arr) {
        //数组长度
        int n =arr.length;
        //先从边际考虑 如果数组为空或者长度小于2 不需要额外进行排序
        if(arr == null || n <2){
            return;
        }
        //0号位 到 n-1号位上面的最小数找出来，放到0号位，1到n-1号位上的最小数找出来放1号位，依次类推...
        //找到最小值的下标
        for (int i = 0; i < n; i++) {
            int minIndex=i;
            for (int j = i+1; j < n; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            //这两个下标的值进行互换 里氏替换方法将
            if(minIndex!=i){
                swap(arr,i,minIndex);
            }
        }

    }
    //将数组两个下标上的内容，相互调换
    private void swap(int[] arr,int index,int target) {
         int temp=0;
         temp = arr[index];
         arr[index]=arr[target];
         arr[target]=temp;
    }

}
