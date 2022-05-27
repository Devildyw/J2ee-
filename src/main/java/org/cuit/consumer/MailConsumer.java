package org.cuit.consumer;

import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.cuit.DTO.MailDTO;
import org.cuit.pojo.User;
import org.cuit.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Devil
 * @date 2022-05-26-19:00
 */
@Component
@RocketMQMessageListener(messageModel = MessageModel.CLUSTERING, consumerGroup = "ChangLeMailConsumer",
        selectorType = SelectorType.TAG, selectorExpression = "mail",
        consumeMode = ConsumeMode.CONCURRENTLY, nameServer = "${rocketmq.name-server}", topic = "notice")
public class MailConsumer implements RocketMQListener<MailDTO> {
    private static final long EXPIRE_TIME = 60*6;
    @Resource
    RedisService redisService;
    @Resource
    private JavaMailSenderImpl javaMailSender;

    @Resource
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String sendMailer;
    @Override
    public void onMessage(MailDTO message) {
        String code = message.getCode();
        User user = message.getUser();
        String email = message.getEmail();

        //发送邮件验证码
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //新建邮件对象
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            //邮件发送人
            mimeMessageHelper.setFrom(sendMailer+"(常乐村论坛官方)");
            //邮件发信人
            mimeMessageHelper.setTo(email);
            //设置主题
            mimeMessageHelper.setSubject("常乐村论坛邮箱验证码");
            mimeMessageHelper.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("username",user.getUsername());
            context.setVariable("verifyCode", Arrays.asList(code.split("")));
            context.setVariable("expireTime",EXPIRE_TIME/60);
            String mail = templateEngine.process("mailcode/emailCode.html", context);
            mimeMessageHelper.setText(mail,true);
            javaMailSender.send(mimeMessage);
            //将邮件验证码存入redis中
            System.out.println(code);
            redisService.set(code.toLowerCase(),email,EXPIRE_TIME);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
