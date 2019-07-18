package com.huarui.dao;

import com.huarui.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by sloan on 2019/7/13.
 */

@Mapper
public interface AccountMapper extends BaseMapper<Account>
{


    @Select({
            "select * from account where id = #{id}"
    })
    Account findAccountById(@Param("id") Long id);
}
