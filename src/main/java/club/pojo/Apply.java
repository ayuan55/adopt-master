package club.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description:
 * @author: zl
 * @create: 2024/12/5 20:02
 */
@Data
public class Apply {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String telephone;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;
    private Integer state;

}
