package practice.practice.dataStructure.timeComplexity;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/6/5 0:00
 * @Version 1.0
 * @Description 时间复杂度，从二分查找算法开始
 */
public class BinarySearch {
    //测试find 方法
    @Test
    public void findTest() {
        int[] array = {1, 2, 5, 8, 10, 11};
        int[] array1 = {1, 2, 5, 8, 10, 11, 12};
        //对数器 寻找数组里是否有目标数字
        boolean logarithm = find2(array, 10);
        System.out.println("对数器找到的内容是否有目标10 | " + logarithm);
        boolean res = find(array, 10);
        boolean res1 = find(array, 9);
        boolean res2 = find(array1, 10);
        boolean res3 = find(array1, 9);
        System.out.println("偶数位数组是否有目标数字" + res);
        System.out.println("偶数位数组内无目标数字，继续寻找" + res1);
        System.out.println("奇数位数组是否有目标数字" + res2);
        System.out.println("奇数位数组内无目标数字，继续寻找" + res3);
    }

    //查找有序数组中>=某个num的 最左的数值的下标
    @Test
    public void leftMostFind() {
        int[] array = {1, 2, 5, 8, 9, 9, 10, 11, 19, 21};
        int[] array1 = {1, 2, 5, 8, 10, 11, 11, 12, 22, 31};
        //对数器 寻找大于等于目标数的最左的那个数
        int res = findLeftMostIndex(array, 8);
        System.out.println("array>=8的最左侧的数为：" + array[res]);
        int res1 = findLeftMostIndex(array1, 11);
        System.out.println("array1>=11的最左侧的数为：" + array1[res1]);

    }

    //在一个无序数组中，相邻的两个数不相等，找到其中一个局部最小值(比左边的小，比右边的小)
    /*三种情况
    1.0号位比1号位小，0号位为局部最小
    2.n-1号位小于n-2号位，n-1号位为局部最小
    3.边界值都无局部最小，中间必有至少一个数为局部最小，0到n-1位置必有局部最小
    */
    @Test
    public void findMin() {
        int[] arr = {18, 15, 12, 23, 45, 11, 10, 55, 56, 67};
        int minIndex = oneMinIndex(arr);
        System.out.println("index:" + minIndex);
        System.out.println("局部最小值为：" + arr[minIndex]);
        int maxLen = 5;
        int maxValue = 20;
        int testTime = 10000;
        System.out.println("测试开始===");
        for (int i = 0; i < testTime; i++) {
            int[] array = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(array);
            if (!check(array, ans)) {
                printArray(array);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束===");
    }

    //有序数组中找某个数 是否存在 逐位遍历
    private boolean find2(int[] arr, int num) {
        for (int cur : arr) {
            if (cur == num) return true;
        }
        return false;
    }

    //有序数组中找某个数 是否存在 二分法
    private boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        //最左下标为L ，最右下标为长度减1
        int LIndex = 0;
        int RIndex = arr.length - 1;
        //循环进行二分查找，当找不到一直二分，直到最左下标大于最右下标
        while (LIndex <= RIndex) {
            int mid = (RIndex + LIndex) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                LIndex = mid + 1;
                // if(arr[mid]>num)
            } else {
                RIndex = mid - 1;
            }
        }
        return false;
    }

    //寻找有序数组>=某个num的最左侧的值
    private int findLeftMostIndex(int[] arr, int num) {
        //边界判断 如果数组为空
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    //直接遍历找>=某个num的最左侧的值
    private int finLeftMostTest(int[] arr, int num) {
        //边界判断 如果数组为空
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                res = i;
                break;
            }
        }
        return res;
    }

    //寻找其中一个局部最小的值的下标
    private int oneMinIndex(int[] arr) {
        //考虑边界问题
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        if (arr.length == 1) {
            return 0;
        }
//        if(arr.length==2){
//            return arr[0]>arr[1] ? arr[1]:arr[0];
//        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        }
        int L = 0;
        int R = n - 1;
//        int ans = -1;
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        //二分到最后，可能左边没数，也可能右边没数，L==R-1的情况，跳出了循环，二分到最后只有两个数。
        //所以这么返回，如果不考虑这个，会有mid-1 或者mid+1越界问题
        return arr[L] < arr[R] ? L : R;
    }

    //用对数器进行验证
    @Test
    public void duiShuQi() {
        int testTime = 50000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (findLeftMostIndex(arr, value) != finLeftMostTest(arr, value)) {
                System.out.println("出错了！");
                succed = false;
                break;
            }
        }
        System.out.println(succed ? "Nice!" : "Faild!");
    }

    //生成随机数组
    private int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    //打印数组
    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //验证方法局部最小值 是否正确 用于测试
    private boolean check(int[] arr, int minIndex) {
        //边界问题 如果数组长度为0 是否最小的下标返回的是-1;
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        //左边是不是真的比这个数大？在left>=0的情况下 判断左边的数是否真的比此数大；如果left<0,说明左边没有数，不影响，所以返回true
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        //同理
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    //生成随机且相邻数不等且无序数组
    private int[] randomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * maxSize);
        int arr[] = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                //保证相邻不相等，从1开始随机依次往后，用抽象为i位置和i-1位置
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                }
                while (arr[i] == arr[i - 1]);
            }
        }
        return arr;

    }
}
