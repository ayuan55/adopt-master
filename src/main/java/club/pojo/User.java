package club.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: zl
 * @create: 2024/12/5 23:04
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private Integer age;
    private String telephone;
    private String Email;
    private String address;
    private String pic;
    private Integer state;
    @TableField(exist = false)
    List<Comment> commentList;
    @TableField(exist = false)
    List<AdoptAnimal> animalList;

}
