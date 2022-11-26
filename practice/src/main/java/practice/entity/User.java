package practice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    @TableField(value="age")
    private Integer age;
    private String name = "jackLove";
    private Boolean person;
    private Integer score;
    private Date date;

}
