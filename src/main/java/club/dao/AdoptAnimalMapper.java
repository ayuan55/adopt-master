package club.dao;

import club.pojo.AdoptAnimal;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * @description:
 * @author: zl
 * @create: 2024/12/2 20:21
 */
public interface AdoptAnimalMapper extends BaseMapper<AdoptAnimal> {
        List<AdoptAnimal> all(@Param("adoptTime")String adoptTime);

}
