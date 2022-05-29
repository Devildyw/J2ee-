package org.cuit.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.cuit.mapper.UserMapper;
import org.cuit.pojo.Invite;
import org.cuit.pojo.User;
import org.cuit.pojo.UserInfo;
import org.cuit.service.InviteService;
import org.cuit.service.RedisService;
import org.cuit.service.UserInfoService;
import org.cuit.service.UserService;
import org.cuit.utils.CLUtils;
import org.cuit.utils.regex.RegexUtils;
import org.cuit.vo.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Controller
public class LoginController {

    @Autowired
    InviteService inviteService;
    @Autowired
    UserService userService;
    @Resource
    RedisService redisService;
    @Resource
    UserMapper userMapper;
    @Autowired
    UserInfoService userInfoService;

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

    @GetMapping("/manage")
    public String toManage() {
        return "manager/manage";
    }

    @GetMapping("/welcome")
    public String toWelcome() {
        return "manager/welcome";
    }

    @GetMapping("/invite")
    public String toDemo01() {
        return "manager/invite";
    }

    @GetMapping("/forget")
    public String toForget() {
        return "forget";
    }

    // 注册业务
    @PostMapping("/register")
    public String register(RegisterForm registerForm, Model model) {
        CLUtils.print("注册表单信息：" + registerForm.toString());
        // 表单密码重复判断
        if (!registerForm.getPassword().equals(registerForm.getRepassword())){
            model.addAttribute("registerMsg","密码输入有误");
            return "register";
        }
        if (RegexUtils.isEmailInvalid(registerForm.getEmail())){
            model.addAttribute("registerMsg","邮箱输入有误");
            return "register";
        }
        // 用户名已存在
        User hasUser = userService.getOne(new QueryWrapper<User>().eq("username", registerForm.getUsername()));
        if (hasUser!=null){
            model.addAttribute("registerMsg","用户名已存在");
            return "register";
        }
        User haUser = userMapper.selectByEmail(registerForm.getEmail());
        if (haUser!=null){
            model.addAttribute("registerMsg","用户名已存在");
            return "register";
        }
        // 验证邀请码
        Invite invite = inviteService.getOne(new QueryWrapper<Invite>().eq("code", registerForm.getCode()));
        if (invite==null){
            model.addAttribute("registerMsg","邀请码不存在");
            return "register";
        }else {
            // 邀请码存在，判断邀请码是否有效
            if (invite.getStatus()==1){
                model.addAttribute("registerMsg","邀请码已被使用");
                return "register";
            }else {
                // 构建用户对象
                User user = new User();
                user.setUid(CLUtils.getUuid()); // 用户唯一id
                user.setRoleId(2);
                user.setUsername(registerForm.getUsername());
                // 密码加密
                String bCryptPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
                user.setPassword(bCryptPassword);
                user.setGmtCreate(CLUtils.getTime());
                user.setLoginDate(CLUtils.getTime());
                user.setAvatar("/images/avatar/avatar-"+(int) (Math.random() * 10 + 1)+".jpg");
                // 保存对象！
                userService.save(user);
                CLUtils.print("新用户注册成功：" + user);

                // 激活邀请码
                invite.setActiveTime(CLUtils.getTime());
                invite.setStatus(1);
                invite.setUid(user.getUid());
                inviteService.updateById(invite);

                UserInfo userInfo = new UserInfo();
                userInfo.setEmail(registerForm.getEmail());
                userInfo.setUid(user.getUid());
                // todo: 用户信息
                userInfoService.save(userInfo);

                // 注册成功，重定向到登录页面
                return "redirect:/toLogin";
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            System.out.println();
        }
    }

}
