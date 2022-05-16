package org.cuit.service.impl;

import org.cuit.pojo.Blog;
import org.cuit.mapper.BlogMapper;
import org.cuit.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 遇见狂神说
 * @since 2020-06-29
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
