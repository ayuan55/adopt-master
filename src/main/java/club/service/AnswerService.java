package club.service;

import club.pojo.Answer;

import java.util.List;
/**
 * @description:
 * @author: zl
 * @create: 2024/12/7 13:41
 */
public interface AnswerService {
    List<Answer> answersAboutOneComment(Integer commentId);
    Integer create(Integer userId, Integer commentId, String content);
    Answer findById(Integer id);
    Integer creates(Integer userId, Integer replayrId, String content, Integer commentId);
}
