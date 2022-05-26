package org.cuit.mapper;

import org.cuit.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 遇见狂神说
 * @since 2020-06-28
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByEmail(String email);

}
