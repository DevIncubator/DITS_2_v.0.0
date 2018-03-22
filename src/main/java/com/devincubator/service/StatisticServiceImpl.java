package com.devincubator.service;

import com.devincubator.entity.Statistic;
import com.devincubator.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dmitry on 16.03.2018.
 */

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;


    @Override
    public List<Statistic> getAll() {

        return
                statisticRepository.findAll();
    }

    @Override
    public Statistic create(Statistic statistic) {
        return statisticRepository.save(statistic);
    }
}
