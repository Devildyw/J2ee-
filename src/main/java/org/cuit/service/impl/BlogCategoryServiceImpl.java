package org.cuit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cuit.mapper.BlogCategoryMapper;
import org.cuit.pojo.BlogCategory;
import org.cuit.service.BlogCategoryService;
import org.springframework.stereotype.Service;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {

}
