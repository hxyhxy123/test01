package com.hmdp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //单表子查询
    @Select(value = "select * from tb_user where create_time not in (select create_time from tb_user where #{userId}<3)")
    User userSelectOne(Long userId);

    //两表带星
    @Select(value = "select a.*, b.* from tb_user a inner join tb_user_info b on a.id = b.user_id")
    UserDTO userSelectTwo();

}
