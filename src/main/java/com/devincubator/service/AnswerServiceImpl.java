package com.devincubator.service;


import com.devincubator.entity.Answer;
import com.devincubator.entity.Question;
import com.devincubator.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl {

    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    public List<Answer> findByQuestion(Question question){
        return answerRepository.findByQuestion(question);
    }

    public Answer findByAnswerId(Long id) {
        return answerRepository.findByAnswerId(id);
    }



}
