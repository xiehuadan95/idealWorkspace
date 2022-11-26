package practice.practice.dataStructure.linkedList;

import org.junit.Test;
import practice.entity.DoubleNodle;

/**
 * @Author xiehu
 * @Date 2022/6/18 22:35
 * @Version 1.0
 * @Description 双链表的 逆序
 */
public class DoubleLinkedList {
    //双链表逆序 测试
    @Test
    public void test(){
        DoubleNodle d=new DoubleNodle(1);
        d.last=null;
        d.next=new DoubleNodle(2);
        d.next.next=new DoubleNodle(3);
        d.next.last=d;
        d.next.next.last=d.next;
        d = reverse(d);
       /*不逆序 应该是 往后打印应该是 1 2 3
       逆序后，d 后面的数据为 3 2 1
        while (d!=null){
            System.out.print(d.value+" ");
            d=d.next;
        }*/

        //如果不逆序 往前打印数据，应该是 1
        //逆序后 自身变为了3，last依然为null ,
        while (d!=null){
            System.out.print(d.value+" ");
            d=d.next;
        }


    }
    //双向链表 逆序处理
   private DoubleNodle reverse(DoubleNodle head){
       DoubleNodle pre =null;
       DoubleNodle next=null;
       while (head!=null){
           next=head.next;
           head.next=pre;
           head.last=next;
           pre=head;
           head=next;
       }
       return pre;

   }
}
