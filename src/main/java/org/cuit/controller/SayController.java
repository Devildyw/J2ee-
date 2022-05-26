package org.cuit.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cuit.pojo.Say;
import org.cuit.service.SayService;
import org.cuit.utils.CLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Controller
public class SayController {

    @Autowired
    SayService sayService;

    @GetMapping("/say")
    public String userIndexBlog(Model model){
        Page<Say> pageParam = new Page<>(1, 50);
        sayService.page(pageParam,new QueryWrapper<Say>().orderByDesc("gmt_create"));
        // 结果
        List<Say> sayList = pageParam.getRecords();
        model.addAttribute("sayList",sayList);
        model.addAttribute("pageParam",pageParam);

        return "page/say";
    }

    @PostMapping("/say/{role}")
    public String saveSay(@PathVariable("role") int role, Say say) {
        // 防止请求提交
        if (role != 1) {
            return "redirect:/say";
        }

        say.setId(CLUtils.getUuid());
        say.setGmtCreate(CLUtils.getTime());
        // 结果
        sayService.save(say);
        return "redirect:/say";
    }




}

