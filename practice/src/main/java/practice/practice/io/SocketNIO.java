package practice.practice.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @Author xiehu
 * @Date 2022/5/19 16:09
 * @Version 1.0
 * @Description
 */
public class SocketNIO {
    public static void main(String[] args) throws Exception {
        LinkedList<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        //OS NONBLOCKING!
        ss.configureBlocking(false);

        while (true) {
            //接受客户端连接 可以不睡眠一直工作
            //Thread.sleep(1000);
            //不会阻塞
            SocketChannel client = ss.accept();
            //accept 调用内核了：1.没有客户端连接进来，返回值 ？在BIO的时候一直卡着。在NIO的时候，不会卡住，会返回-1
            //如果来客户端的连接，accept 返回的是这个客户端的 fd
            //NONBLOCKING就是代码能往下走了，只不过有不同的情况
            if (client == null) {
                System.out.println("null....");
            } else {
                client.configureBlocking(false);// socket 服务端listen socket<三次握手后
                int port = client.socket().getPort();
                System.out.println("client...port"+port);
                clients.add(client);
            }

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096); //可以在堆里 堆外
            //遍历已经连接进来的客户端 能不能读写数据
            for (SocketChannel c : clients) {   //串行化 多线程
              int num=c.read(buffer);
              if(num>0){
                  buffer.flip();
                  byte[] bytes = new byte[buffer.limit()];
                  buffer.get(bytes);

                  String b =new String(bytes);
                  System.out.println(c.socket().getPort()+":"+b);
                  buffer.clear();
              }
            }
        }


    }

}
