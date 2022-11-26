package practice.practice.dataStructure.linkedList;

import org.junit.Test;
import practice.entity.Node;

/**
 * @Author xiehu
 * @Date 2022/6/17 23:00
 * @Version 1.0
 * @Description 单链表的反转 逆序
 */
public class SingleLinkedList {
    //建一个链表结构，每个节点会指向下一个节点，通过方法让这些节点逆序
    @Test
    public void test1() {
        //node1 值为1 ，node1的next节点值为 2，2的下一个节点为3，3这个对象里面的next节点为默认null;
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        //将node1放进去进行逆序，然后再将返回的值 给node1 抓住，就完成了单链表逆序
       node1 = reversLinkedList(node1);
        //沿途打印节点的值，让node1不停的指向next节点并打印值
        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next; //正常不逆序的情况下 节点值 分别为 1  2  3
        }
        System.out.println();



    }

    //逆序 一个单链表 方法
    private Node reversLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            //原顺序 节点的下一个位置 存起来
            next = head.next;
            //因为要逆序，那么第一个节点 原来的next指向要变为指向null,由于在循环里面，这里用pre标识
            //head.next 不再跟以前一样，现在要指向前面的数据了，第一个节点前面是null
            head.next = pre;
            //然后让pre 来到head的位置，下一次循环，下个节点的指向依然逆序指向pre,也就是head,同时pre往后面移动赋值
            pre = head;
            //而head 移动到之前的next 去，第一个循环就进行了反转，后续循环继续此逻辑移动赋值。最后next为null的时候 停止
            head = next;
        }
        //当next为空的时候，head为空，那么pre就是逆序完成后的 第一个节点（逆序前的最后一个节点）
        return pre;
    }

    //引用的传递 测试
    @Test
    public void byRef() {
        Node n = new Node(1);
        n.next = new Node(100);
        byRefExample(n);
        //即使上面的方法已经对n 进行了操作，但其实是引用的传递，是拷贝了地址值进行操作，不会对
        //原有数据造成影响
        System.out.println(n.value);
        //如果将操作完的节点返回
        Node node = byRefExample2(n);
        //拷贝出来的数据操作后返回的是新数据
        System.out.println(node.value);
        //原有的节点引用数据不变
        System.out.println(n.value);
    }

    //引用传递 方法示例
    private void byRefExample(Node node) {
        node = node.next;
    }

    //引用传递 方法示例
    private Node byRefExample2(Node node) {
        node = node.next;
        return node;
    }
}

