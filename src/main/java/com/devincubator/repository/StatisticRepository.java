package com.devincubator.repository;

import com.devincubator.entity.Question;
import com.devincubator.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
