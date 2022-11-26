package practice.practice.dataStructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/6/1 10:31
 * @Version 1.0
 * @Description  冒泡排序 相邻两数据对比大小，两两交换位置到最后
 */
public class BubbleSort {
    @Test
    public void test(){
        int[] arr = {13,3,43,1,2,2,0,5,8,9};
        System.out.println(Arrays.toString(arr));
        //0~n-1
        //0~n-2
        //0~n-3
        int n=arr.length;
        for (int end = n-1; end>0;end--) {
            for (int i = 0; i < end; i++) {
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
    //数组里面两个值相互交换
    private void swap(int[] arr,int i,int j) {
        //考虑边界问题
       if(arr==null || arr.length<2){
           return;
       }
       int temp =arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
    }

}
