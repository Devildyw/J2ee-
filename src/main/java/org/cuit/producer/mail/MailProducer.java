package org.cuit.producer.mail;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.cuit.DTO.MailDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Component
public class MailProducer {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void SendMailSync(MailDTO mailDTO){

    }
}
