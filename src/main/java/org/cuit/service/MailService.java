package org.cuit.service;

import org.cuit.result.R;

/**
 * @author Devil
 * @since 2022-05-20
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
