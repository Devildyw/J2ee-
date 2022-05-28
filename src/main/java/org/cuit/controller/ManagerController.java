package org.cuit.controller;

import org.apache.commons.lang3.StringUtils;
import org.cuit.DTO.AnnouncementDTO;
import org.cuit.pojo.Invite;
import org.cuit.pojo.Say;
import org.cuit.result.R;
import org.cuit.service.InviteService;
import org.cuit.service.SayService;
import org.cuit.utils.InviteUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Devil
 * @date 2022-05-28-13:20
 */
@RestController
public class ManagerController {
    @Resource
    private InviteService inviteService;
    @Resource
    private SayService sayService;

    @GetMapping("getInviteCode")
    public R getInvitationCode(HttpServletRequest request) {
        String code = InviteUtil.generateInvitationCode();
        Invite invite = new Invite();
        invite.setCode(code);
        invite.setGmtCreate(new Date());
        inviteService.save(invite);
        return new R(true, 200,code);
    }

}
