package com.devincubator.service;

import com.devincubator.entity.Question;
import com.devincubator.entity.Test;

import java.util.List;

public interface QuestionService {
    List<Question> getAll();

    Question findByQuestionId(Long id);

    List<Question> findByTest(Test test);
}
