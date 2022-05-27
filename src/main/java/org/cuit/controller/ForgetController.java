package org.cuit.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.cuit.DTO.ForgetDTO;
import org.cuit.mapper.UserMapper;
import org.cuit.pojo.User;
import org.cuit.result.R;
import org.cuit.service.InviteService;
import org.cuit.service.RedisService;
import org.cuit.service.UserInfoService;
import org.cuit.service.UserService;
import org.cuit.utils.regex.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Devil
 * @date 2022-05-27-14:36
 */
@RestController
public class ForgetController {
    @Autowired
    InviteService inviteService;
    @Autowired
    UserService userService;
    @Resource
    UserMapper userMapper;
    @Resource
    RedisService redisService;
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/forget")
    public R forget(@RequestBody ForgetDTO forgetDTO){
        System.out.println(forgetDTO.toString());
        String code = forgetDTO.getCode();
        String repassword = forgetDTO.getRepassword();
        String password = forgetDTO.getPassword();
        String username = forgetDTO.getUsername();
        String disEmail = forgetDTO.getEmail();
        User user = userMapper.selectByEmail(disEmail);

        if (RegexUtils.isCodeInvalid(code)){
            return new R(false,-1003,"验证码格式不对");
        }
        if (!redisService.hasKey(code)){
            return new R(false,-1004,"验证码无效");
        }
        String email = (String) redisService.get(code);

        if (!email.equals(disEmail)||!user.getUsername().equals(username)){
            return new R(false,-1004,"验证码无效");
        }
        if (StringUtils.isEmpty(repassword)||StringUtils.isEmpty(password)||StringUtils.isEmpty(username)){
            return new R(false,-1005,"参数无效");
        }
        if (!repassword.equals(password)){
            return new R(false,-1006,"两次密码不同");
        }
        System.out.println("dafaf");
        QueryWrapper<User> eq = new QueryWrapper<User>().eq("username", username);
        User one = userService.getOne(eq);
        one.setPassword(new BCryptPasswordEncoder().encode(password));
        userService.updateById(one);
        redisService.del(code);
        return new R(true,200,"修改成功");
    }
}
