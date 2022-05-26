package org.cuit.service.impl;

import org.cuit.DTO.MailDTO;
import org.cuit.mapper.UserMapper;
import org.cuit.pojo.User;
import org.cuit.producer.mail.MailProducer;
import org.cuit.result.R;
import org.cuit.service.MailService;
import org.cuit.utils.VerifyUtil;
import org.cuit.utils.regex.RegexUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Service
public class MailServiceImpl implements MailService {

    @Resource
    private MailProducer mailProducer;

    @Resource
    private UserMapper userMapper;
    @Override
    public R createVerifyMail(String email) {
        if (StringUtils.isEmpty(email)){
            return new R(false,-1001,"邮箱不能为空");
        }
        if (RegexUtils.isEmailInvalid(email)) {
            return new R(false,-100,"邮箱不符合格式");
        }
        User user = userMapper.selectByEmail(email);
        if (user == null){
            return new R(false,-999,"该用户没有注册");
        }
        MailDTO mailDTO = new MailDTO();
        //6位邮箱验证码
        mailDTO.setCode(VerifyUtil.generateVerificationCode());
        mailDTO.setUser(user);
        mailDTO.setEmail(email);
        mailProducer.SendMailSync(mailDTO);

        return new R(true,200,"发送成功");
    }
}
