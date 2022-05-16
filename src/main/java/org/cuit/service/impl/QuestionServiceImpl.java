package org.cuit.service.impl;

import org.cuit.pojo.Question;
import org.cuit.mapper.QuestionMapper;
import org.cuit.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 遇见狂神说
 * @since 2020-06-28
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
