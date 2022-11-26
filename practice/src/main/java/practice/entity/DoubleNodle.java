package practice.entity;

/**
 * @Author xiehu
 * @Date 2022/6/18 22:39
 * @Version 1.0
 * @Description 双向链表节点 ，抽象有前指针指向一个节点，后指针指向一个节点
 */
public class DoubleNodle {
    public int value;
    public DoubleNodle last;
    public DoubleNodle next;

    public DoubleNodle(int value) {
        this.value = value;
    }
}
