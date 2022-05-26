package org.cuit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cuit.mapper.SayMapper;
import org.cuit.pojo.Say;
import org.cuit.service.SayService;
import org.springframework.stereotype.Service;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Service
public class SayServiceImpl extends ServiceImpl<SayMapper, Say> implements SayService {

}
