package practice;

import org.junit.Test;
import practice.practice.proxy.dynamic.MyTest;
import practice.practice.proxy.statically.GamePlayer;
import practice.practice.proxy.statically.GameProxyPlayer;
import practice.practice.proxy.statically.IGamePlayer;

/**
 * @Author xiehu
 * @Date 2022/9/3 11:05
 * @Version 1.0
 * @Description 代理 模式的测试类
 */
public class ProxyTest {
    @Test
    public void test(){
        GamePlayer gamePlayer = new GamePlayer("张三");
        gamePlayer.start();
        gamePlayer.play();
    }
    //让代练来玩游戏 用接口来接收
    @Test
    public void test01(){
        IGamePlayer gamePlayer = new GameProxyPlayer("张三");
        gamePlayer.start();
        gamePlayer.play();
    }
    @Test
    public void proxy(){
        IGamePlayer obj =(IGamePlayer) MyTest.createProxy(new GamePlayer("阿呆"));
        obj.start();
    }
}
