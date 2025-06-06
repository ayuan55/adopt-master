package club.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zl
 * @create: 2024/12/5 22:44
 */
@Data
public class Pet {
    private Integer id;
    private String petName;
    private String petType;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String pic;
    private Integer state;
    private String remark;

    @TableField(exist = false)
    private List<AdoptAnimal> adoptAnimalList=new ArrayList<>();
    @TableField(exist = false)
    private List<Comment> commentList=new ArrayList<>();

}
