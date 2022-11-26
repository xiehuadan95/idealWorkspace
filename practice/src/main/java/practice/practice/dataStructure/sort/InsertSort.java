package practice.practice.dataStructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/6/1 11:20
 * @Version 1.0
 * @Description 插入排序，相当于之前的部分排好，后面又来了一个数据 加入进去进行排
 * 插入排序 比冒泡和选择排序 性能更好 ！
 */
public class InsertSort {
    //第一种方式插入排序
    @Test
    public void test1(){
        int[] arr = {13,3,43,1,2,2,0,5,8,9};
        int n=arr.length;
        System.out.println(Arrays.toString(arr));
        //0~0不需要排
        //0位~1位排好
        //0位~2位排好 3号位的数据要同2号位对比，如果互换，那么就是2号位数据同1号位数据对比，如果也互换，就是1号位的数据要和0号位对比，最后还互换，新下标为0
        //0位~3位排好
        //0位~n-1位排好
        for (int end = 1; end < n; end++) {
         int newNumIndex=end;
         //后面新来的数据 要满足前面有数据，同时比前面的数据小 再交换，交换后再对比
         while(newNumIndex-1>=0 && arr[newNumIndex-1]>arr[newNumIndex]){
             swap(arr,newNumIndex,newNumIndex-1);
             newNumIndex--;
         }
        }
        System.out.println(Arrays.toString(arr));
    }
    //优化后的插入排序
    @Test
    public void test2() {
        int[] arr = {13, 3, 43, 1, 2, 2, 0, 5, 8, 9};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        for (int end = 1; end < n; end++) {
           for(int pre=end-1;pre>=0 && arr[pre]>arr[pre+1];pre--){
               swap(arr,pre,pre+1);
           }
        }
        System.out.println(Arrays.toString(arr));

    }
    //交换
    private void swap(int[] arr,int i,int j){
        if(arr==null || arr.length<2){
            return;
        }
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
