package practice.practice.proxy.dynamic;

/**
 * @Author xiehu
 * @Date 2022/9/3 11:21
 * @Version 1.0
 * @Description 计算器类 用于理解动态代理
 */
public class Calculator implements ICalculator{
    //加
    public Integer add(Integer i,Integer j){
        Integer res=i+j;
        return res;
    }
    //减
    public Integer sub(Integer i,Integer j){
        Integer res=i-j;
        return res;
    }
    //乘
    public Integer mul(Integer i,Integer j){
        Integer res=i*j;
        return res;
    }
    //除
    public Integer div(Integer i,Integer j){
        Integer res=i/j;
        return res;
    }
}
