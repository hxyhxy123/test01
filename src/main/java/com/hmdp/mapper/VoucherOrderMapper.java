package com.hmdp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.VoucherOrder;
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
public interface VoucherOrderMapper extends BaseMapper<VoucherOrder> {

    //三表查询
    @Select(value = "select tb_voucher.create_time as no, tb_voucher.pay_type as name " +
            "from tb_voucher,tb_voucher_order " +
            "where tb_voucher.id=tb_voucher_order.voucher_id " +
            "and tb_voucher_order.user_id in (select tb_user.id from tb_user where nick_name=#{username})")
    VoucherOrder voucherSelectOne(String userName);

    //两表多嵌套查询三级嵌套

//    static final String s6="select distinct student.Sno, student.Sname from student,SC where student.Sno=SC.Sno and SC.Cno in (select SC.Cno from SC,student where SC.Sno=student.Sno and student.Sno in (select student.Sno from student where student.Sname='刘晨' ))";
}
