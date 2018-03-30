package com.devincubator.service;

import com.devincubator.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAll();

    void addQuestion(Question question);

    Question findByQuestionId(Long questionId);

}
