package com.devincubator.repository;

import com.devincubator.entity.TestStatistic;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Dmitry on 19.03.2018.
 */
public interface TestStatisticRepository extends Repository<TestStatistic, Long> {

    List<TestStatistic> findAll();
}
