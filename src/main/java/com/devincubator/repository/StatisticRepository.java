package com.devincubator.repository;

import com.devincubator.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitry on 16.03.2018.
 */
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
