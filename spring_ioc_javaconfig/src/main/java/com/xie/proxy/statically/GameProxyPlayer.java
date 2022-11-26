package com.xie.proxy.statically;

/**
 * @Author xiehu
 * @Date 2022/9/3 11:09
 * @Version 1.0
 * @Description  游戏代练 类
 */
public class GameProxyPlayer implements IGamePlayer{
    private String name;
    //将代练和游戏玩家 建立关系
    private GamePlayer gamePlayer;

    public GameProxyPlayer(String name) {
        this.name = name;
        this.gamePlayer=new GamePlayer(name);
    }

    @Override
    public void start() {
        System.out.println("拿到"+name+"的用户名密码");
        gamePlayer.start();
    }

    @Override
    public void play() {
        System.out.println("代练击杀了曹贼这个玩家");

    }
}
