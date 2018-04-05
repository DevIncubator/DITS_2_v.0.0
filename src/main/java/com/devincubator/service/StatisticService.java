package com.devincubator.service;

import com.devincubator.entity.Question;
import com.devincubator.entity.Statistic;
import com.devincubator.entity.User;

import java.util.List;

/**
 * Created by Dmitry on 16.03.2018.
 */
public interface StatisticService {

    public List<Statistic> getAll();

    public Statistic create(Statistic statistic);

    public List<Statistic> findByUser(User user);

    public void addQuestionCorrect(User userId, Question question, boolean correct);
}
