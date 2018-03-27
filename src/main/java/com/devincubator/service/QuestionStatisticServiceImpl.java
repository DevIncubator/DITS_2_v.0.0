package com.devincubator.service;

import com.devincubator.entity.QuestionStatistic;
import com.devincubator.repository.QuestionStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitry on 27.03.2018.
 */
@Service
public class QuestionStatisticServiceImpl {

    @Autowired
    private QuestionStatisticRepository questionStatisticRepository;

    public List<QuestionStatistic> getAll() {
        return questionStatisticRepository.findAll();
    }
}
