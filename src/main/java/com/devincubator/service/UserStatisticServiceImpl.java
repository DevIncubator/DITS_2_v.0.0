package com.devincubator.service;

import com.devincubator.entity.UserStatistic;
import com.devincubator.repository.UserStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitry on 27.03.2018.
 */
@Service
public class UserStatisticServiceImpl {

    @Autowired
    private UserStatisticRepository userStatisticRepository;

    public List<UserStatistic> getAll() {
        return userStatisticRepository.findAll();
    }
}
