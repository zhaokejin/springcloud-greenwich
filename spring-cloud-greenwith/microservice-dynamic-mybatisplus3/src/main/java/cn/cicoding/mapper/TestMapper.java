package cn.cicoding.mapper;

import cn.cicoding.vo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<User> {

    int add(User user);


}
