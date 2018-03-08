package com.devincubator.service;

import com.devincubator.entity.Question;
import com.devincubator.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }
}