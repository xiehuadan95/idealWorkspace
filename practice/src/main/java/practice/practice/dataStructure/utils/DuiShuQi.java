package practice.practice.dataStructure.utils;

import org.junit.Test;

/**
 * @Author xiehu
 * @Date 2022/6/5 23:41
 * @Version 1.0
 * @Description 用于比对算法结果是否正确，用随机数据放进去进行比对.不依赖线上的测试，随意控制样本大小进行验证算法
 */
public class DuiShuQi {
    //入参数组，目标value,返回boolean 对比数组排序是否正确，
    @Test
    public void compareSort() {
        int maxLen=5;
        int maxValue=1000;
        int testTimes=10000;
        for (int i = 0; i < testTimes; i++) {
            //生成随机数组
            int[] arr1 = lenValueRandom(maxLen,maxValue);
            //克隆一份,备份
            int[] temp = copyArr(arr1);
            //选择排序
            sortMeth(arr1);
            //大样本随机进行选择排序后
            if(!isSorted(arr1)){
                //可控制样本长度，将出错的样本数据打印出来
                for (int j = 0; j < temp.length; j++) {
                    System.out.print(temp[j]+" ");
                }
                System.out.println();
                System.out.println("选择排序错了！");
                //一旦出现错，停止循环，否则 会一直循环去测随机生成的数组
                break;
              //  return;
            }

        }

    }
    //生成随机数组
    private int[] generateRandomArray(int maxSize,int maxValue){
        int [] arr=new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)((maxValue+1)*Math.random())-(int)(maxValue*Math.random());
        }
        return arr;

    }
    //返回一个数组，arr长度[0,maxlen-1],value[0,maxvalue-1]
    private  int[] lenValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }
    //拷贝方法，给的数组，拷贝一份并生成新数组
    private  int[] copyArr(int[] arr){
        int len=arr.length;
        int[] res=new int[len];
        for (int i = 0; i < len; i++) {
            res[i]=arr[i];
        }
        return res;
    }
    //验证两个等长数组是不是一样的值，的方法
    private  boolean equalVaules(int[] a,int[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
    //验证1个数组是否使已经排序正确且完成
    private boolean isSorted(int[] arr){
        //如果只有一个数，没必要比较
        if(arr.length<2){
            return true;
        }
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max>arr[i]){
                return false;
            }
            max=Math.max(max,arr[i]);
        }
        return true;
    }




    //选择排序
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
