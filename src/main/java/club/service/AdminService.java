package club.service;

import club.pojo.Admins;
import com.github.pagehelper.PageInfo;


import club.pojo.Admins;
import com.github.pagehelper.PageInfo;
/**
 * @description:
 * @author: zl
 * @create: 2024/12/6 21:42
 */

public interface AdminService {
    PageInfo<Admins> adminPage(String adminName,Integer pageNum,Integer pageSize);
    Admins findById(Integer id);
    Admins login(String adminName, String adminPwd);
    PageInfo<Admins> allAdmin(String adminsName, int pageNum, int pageSize);
    int add(Admins admins);
    int update(Admins admins);
    int del(Integer id);
}
