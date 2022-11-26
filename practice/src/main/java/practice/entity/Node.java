package practice.entity;

/**
 * @Author xiehu
 * @Date 2022/6/17 23:02
 * @Version 1.0
 * @Description  链表实体类，单链表始终存了下一个节点Node的地址值（抽象为指针）
 */
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

}
