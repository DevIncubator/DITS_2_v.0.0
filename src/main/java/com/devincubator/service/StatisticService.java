package com.devincubator.service;

import com.devincubator.entity.Question;
import com.devincubator.entity.Statistic;

import java.util.List;

/**
 * Created by Dmitry on 16.03.2018.
 */
public interface StatisticService {

    public List<Statistic> getAll();

    public Statistic create(Statistic statistic);

    public void addQuestionCorrect(Question question, boolean correct);
}
