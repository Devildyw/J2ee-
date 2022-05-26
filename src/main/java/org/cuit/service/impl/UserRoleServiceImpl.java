package org.cuit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cuit.mapper.UserRoleMapper;
import org.cuit.pojo.UserRole;
import org.cuit.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
