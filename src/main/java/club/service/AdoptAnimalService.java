package club.service;

import club.pojo.AdoptAnimal;
import com.github.pagehelper.PageInfo;
/**
 * @description:
 * @author: zl
 * @create: 2024/12/7 12:02
 */
public interface AdoptAnimalService {
    Integer create(AdoptAnimal adoptAnimal);
    PageInfo<AdoptAnimal> all(String adoptTime,Integer pageNum, Integer pageSize);
    int update(Integer id, Integer state);
    PageInfo<AdoptAnimal> allAdoptAnimal(String userName,Integer pageNum,Integer pageSize, Integer state);
}
