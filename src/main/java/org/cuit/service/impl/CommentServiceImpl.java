package org.cuit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cuit.mapper.CommentMapper;
import org.cuit.pojo.Comment;
import org.cuit.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
