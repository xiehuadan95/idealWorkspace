package practice.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 返回给前端的实体类 带有子节点
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NodeVO {
    private String id;
    private String name;
    private String pid;
    private List<NodeVO> children;

    public NodeVO(String id, String name, String pid) {
        this.id=id;
        this.name=name;
        this.pid=pid;
    }
    @Override
    public String toString(){return JSON.toJSONString(this);}
}
