package org.cuit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cuit.mapper.QuestionMapper;
import org.cuit.pojo.Question;
import org.cuit.service.QuestionService;
import org.springframework.stereotype.Service;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
