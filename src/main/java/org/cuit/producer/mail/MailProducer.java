package org.cuit.producer.mail;

import com.mysql.jdbc.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.cuit.DTO.MailDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Slf4j
@Component
public class MailProducer {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void SendMailSync(MailDTO mailDTO){
        SendResult sendResult = rocketMQTemplate.syncSend("notice:mail", mailDTO);
        log.info("sendResult==>{}",sendResult);
    }
}
