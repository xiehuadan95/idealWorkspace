package practice.practice.jvm;

/**
 * @Author xiehu
 * @Date 2022/5/4 15:10
 * @Version 1.0
 * @Description 证明CPU存在乱序执行的例子，反证
 */
public class Disorder {
    private static int x=0,y=0;
    private static int a=0,b=0;
//无论这两个线程怎么排列组合 如果没有重排序，一定不会存在x=0 且 y=0
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        //不停的死循环
        for (; ; ) {
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread one= new Thread(new Runnable() {
                @Override
                public void run() {
                    //由于线程one先启动，下面这句话让它等一等线程two
                    //shortWati(100000);
                    //前后没有依赖关系 a=1和 x=b
                    a=1;
                    x=b;
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    //如果不存在乱序，b=1一定在y=a前面
                    b=1;
                    y=a;
                }
            });
            one.start();other.start();
            one.join();other.join();
            String result = "第"+i+"次（"+x+","+y+")";
            if(x==0 && y==0){
                System.err.println(result);
                break;
            }else{
                System.out.println(result);
            }
        }

    }
    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end=System.nanoTime();
        }while (start+interval>=end);
    }

}
