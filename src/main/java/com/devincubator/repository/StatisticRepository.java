package com.devincubator.repository;

import com.devincubator.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmitry on 16.03.2018.
 */
@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
