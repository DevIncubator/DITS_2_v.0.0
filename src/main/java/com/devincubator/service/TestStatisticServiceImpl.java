package com.devincubator.service;

import com.devincubator.entity.TestStatistic;
import com.devincubator.repository.TestStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitry on 19.03.2018.
 */
@Service
public class TestStatisticServiceImpl {

    @Autowired
    private TestStatisticRepository testStatisticRepository;

    public List<TestStatistic> getAll() {
        return testStatisticRepository.findAll();
    }

}
