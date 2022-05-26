package org.cuit.service.impl;

import org.cuit.mapper.UserMapper;
import org.cuit.pojo.User;
import org.cuit.producer.mail.MailProducer;
import org.cuit.result.R;
import org.cuit.service.MailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Devil
 * @date 2022-05-25-21:17
 */
@Service
public class MailServiceImpl implements MailService {

    @Resource
    private MailProducer mailProducer;

    @Resource
    private UserMapper userMapper;
    @Override
    public R createVerifyMail(String email) {
        User user = userMapper.selectByEmail();
        return null;
    }
}
