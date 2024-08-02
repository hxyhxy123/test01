package com.hmdp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmdp.entity.Shop;
import org.apache.ibatis.annotations.Insert;
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
public interface ShopMapper extends BaseMapper<Shop> {

    @Insert("insert into tb_shop" +
            "        (id, name, type_id, images, area, address, x, y, avg_price," +
            "         comments, open_hours, create_time, update_time)" +
            "        values (#{id}, #{name}, #{type_id}, #{images}, #{area}, #{address}, #{x}, #{y}," +
            "                #{avg_price}, #{comments}, #{open_hours}, #{create_time}, #{update_time})")
    void shopInsertTo(Shop shop);

    @Select(value = "select id as shop_id,name as shop_name, type_id as shop_type_id, create_time as shop_create_time " +
            "from tb_shop " +
            "where create_time <(select Sage from tb_shop where name=#{name})")
    Shop shopSelectOne(String name);

    @Select(value = "select address ,id ,select sort from tb_shop_type " +
            "from tb_shop where id =#{shopId}")
    Shop shopSelectTwo(Long shopId);

}
