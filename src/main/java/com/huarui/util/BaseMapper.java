package com.huarui.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by sloan on 2019/7/13.
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {


}
