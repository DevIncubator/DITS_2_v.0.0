package com.devincubator.repository;

import com.devincubator.entity.Question;
import com.devincubator.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
