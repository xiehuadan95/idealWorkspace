package practice.pojo;

import cn.hutool.core.lang.Assert;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author xiehu
 * @Date 2022/7/14 10:20
 * @Version 1.0
 * @Description 模拟mq传过来的消息对象
 * 依赖包 org.springframework.amqp.core
 */
@Getter
@Setter
public class MessageMq implements Serializable {
    private static final long serialVersionUID = 7054474727112166623L;

    private static final String ENCODING = Charset.defaultCharset().name();
    private static final Set<String> whiteListPatterns =
            new LinkedHashSet<>(Arrays.asList("java.util.*", "java.lang.*"));

    private final byte[] body;

    public MessageMq(byte[] body) {
        this.body = body;
    }

    public static void addWhiteListPatterns(String... patterns) {
        Assert.notNull(patterns, "'patterns' cannot be null");
        whiteListPatterns.addAll(Arrays.asList(patterns));
    }
    public static Set<String> getWhiteListPatterns(){
        return MessageMq.whiteListPatterns;
    }
    private String getBodyContextAsString() {
        if (this.body == null) {
            return null;
        }
        String res = "";
        try {
            res = new String(this.body, ENCODING);
        } catch (Exception e) {
            //ignore
        }
        return res + "(byte[" + this.body.length + "])";

    }
    public byte[] getBody(){return this.body;}

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append("Body: '").append(this.getBodyContextAsString()).append("'").append("}");
        return buffer.toString();
    }
}
