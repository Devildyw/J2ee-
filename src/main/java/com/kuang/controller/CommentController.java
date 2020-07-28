package com.kuang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuang.pojo.Comment;
import com.kuang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 遇见狂神说
 * @since 2020-06-30
 */
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    // 删除评论
    @GetMapping("/user/comment/delete/{uid}/{cid}")
    public String deleteComment(@PathVariable String uid,@PathVariable String cid){
        commentService.remove(new QueryWrapper<Comment>().eq("comment_id", cid));
        return "redirect:/user/comment/"+uid+"/1/10";
    }

}

