package com.devincubator.repository;

import com.devincubator.entity.UserStatistic;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Dmitry on 27.03.2018.
 */
public interface UserStatisticRepository extends Repository<UserStatistic, Long> {

    List<UserStatistic> findAll();
}
