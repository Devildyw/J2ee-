package org.cuit.controller;

import org.cuit.result.R;
import org.cuit.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Devil
 * @since 2022-05-20
 */
@RestController
@RequestMapping("mall")
public class MailController {
    @Resource
    private MailService mailService;

    @GetMapping("verify")
    public R verifyMail(String email){
        return mailService.createVerifyMail(email);
    }
}
