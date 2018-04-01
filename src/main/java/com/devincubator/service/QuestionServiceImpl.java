package com.devincubator.service;

import com.devincubator.entity.Question;
import com.devincubator.entity.Test;
import com.devincubator.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public List<Question> findByTest(Test test) {
        return questionRepository.findByTest(test);
    }

    public Question findByQuestionId(Long id) {return questionRepository.findByQuestionId(id);}
}