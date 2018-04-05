package com.devincubator.repository;

import com.devincubator.entity.Statistic;
import com.devincubator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    List<Statistic> findByUser(User user);

}
