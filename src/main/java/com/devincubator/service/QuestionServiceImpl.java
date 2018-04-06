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

    @Override
    public List<Question> findByTest(Test test) {
        return questionRepository.findByTest(test);
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findByQuestionId(Long questionId) {
        return questionRepository.findByQuestionId(questionId);
    }

    @Override
    public Question findByDescription(String description) {
        return questionRepository.findByDescription(description);
    }
}