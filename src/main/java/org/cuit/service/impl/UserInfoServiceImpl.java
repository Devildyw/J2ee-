package org.cuit.service.impl;

import org.cuit.pojo.UserInfo;
import org.cuit.mapper.UserInfoMapper;
import org.cuit.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 遇见狂神说
 * @since 2020-06-29
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
