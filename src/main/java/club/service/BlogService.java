package club.service;

import club.pojo.Blog;
import com.github.pagehelper.PageInfo;
/**
 * @description:
 * @author: zl
 * @create: 2024/12/7 14:43
 */
public interface BlogService {
    PageInfo<Blog> findAllBlog(String actionTime,Integer pageNum,Integer pageSize);
    int add(Blog blog);
    Blog findById(Integer id);
    int updateBlog(Blog blog);
    int del(Integer id);
    PageInfo<Blog> blogs(Integer pageNum, Integer pageSize);
}
