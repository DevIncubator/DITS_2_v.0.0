package com.devincubator.service;

import com.devincubator.entity.Question;
import com.devincubator.entity.Test;

import java.util.List;

public interface QuestionService {

    List<Question> getAll();

    List<Question> findByTest(Test test);

    void addQuestion(Question question);

    Question findByQuestionId(Long questionId);

}
