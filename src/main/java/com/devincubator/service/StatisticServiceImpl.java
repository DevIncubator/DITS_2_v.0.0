package com.devincubator.service;

import com.devincubator.entity.Question;
import com.devincubator.entity.Statistic;
import com.devincubator.entity.User;
import com.devincubator.repository.StatisticRepository;
import com.devincubator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Dmitry on 16.03.2018.
 */

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Statistic> getAll() {
        return statisticRepository.findAll();
    }

    @Override
    public Statistic create(Statistic statistic) {
        return statisticRepository.save(statistic);
    }


    public void addQuestionCorrect(User user, Question question, boolean correct){
        Date date = new Date();
        Statistic statistic = new Statistic(user, question, date, correct);
        statisticRepository.save(statistic);
    }

    public List<Statistic> findByUser(User user){
        return statisticRepository.findByUser(user);
    }
}
