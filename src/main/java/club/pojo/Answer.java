package club.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @description:
 * @author: zl
 * @create: 2024/12/5 19:02
 */
@Data
public class Answer {
    private Integer id;
    private Integer userId;
    private Integer replayId;
    private Integer commentId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date answerTime;
    private String content;

    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private Answer answer;
    @TableField(exist = false)
    private Comment comment;

}
