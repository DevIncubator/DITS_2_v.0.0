package com.devincubator.service;

import com.devincubator.entity.Question;
import com.devincubator.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findByQuestionId(Long questionId) {
        return questionRepository.findByQuestionId(questionId);
    }
}