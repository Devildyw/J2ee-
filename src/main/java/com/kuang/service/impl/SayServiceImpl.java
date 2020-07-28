package com.kuang.service.impl;

import com.kuang.pojo.Say;
import com.kuang.mapper.SayMapper;
import com.kuang.service.SayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 遇见狂神说
 * @since 2020-07-01
 */
@Service
public class SayServiceImpl extends ServiceImpl<SayMapper, Say> implements SayService {

}
