package com.devincubator.repository;

import com.devincubator.entity.QuestionStatistic;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Dmitry on 27.03.2018.
 */
public interface QuestionStatisticRepository extends Repository<QuestionStatistic, Long> {

    List<QuestionStatistic> findAll();
}
