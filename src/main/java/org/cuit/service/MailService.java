package org.cuit.service;

import org.cuit.result.R;

/**
 * @author Devil
 * @date 2022-05-25-21:17
 */
public interface MailService {
    /**
     * 发送邮件
     *
     * @param email
     * @return
     */
    R createVerifyMail(String email);
}
