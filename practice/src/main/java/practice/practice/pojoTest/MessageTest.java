package practice.practice.pojoTest;

import org.junit.Test;
import practice.pojo.MessageMq;

import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * @Author xiehu
 * @Date 2022/7/14 11:35
 * @Version 1.0
 * @Description
 */
public class MessageTest {
    @Test
    public void test() {
        String req = "i'm request body 啦啦啦！";
        byte[] reqBytes = req.getBytes(StandardCharsets.UTF_8);
        MessageMq message = new MessageMq(reqBytes);
        MessageMq.addWhiteListPatterns("java.util.Arrays","java.util.stream.Collectors");
        Set<String> whiteListPatterns = MessageMq.getWhiteListPatterns();
        System.out.println("配置信息："+whiteListPatterns.toString());
        System.out.println("Message对象内容："+message);
    }
}
