package org.cuit.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.cuit.pojo.Comment;
import org.cuit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Devil
 * @since 2022-05-20
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

