package practice.practice.proxy.statically;

/**
 * @Author xiehu
 * @Date 2022/9/3 11:00
 * @Version 1.0
 * @Description 静态代理 模式 这个类为游戏玩家
 */
public class GamePlayer implements IGamePlayer{
    private String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    //登录游戏
    public void start(){
        System.out.println("====登录游戏====");
        System.out.println(name+"开始了游戏");
//        this.name=name;
    }
    //打怪
    public void play(){
        System.out.println(name+"被曹贼玩家击杀了====");
    }
}
