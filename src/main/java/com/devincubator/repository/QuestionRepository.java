package com.devincubator.repository;

import com.devincubator.entity.Question;
import com.devincubator.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByQuestionId(Long questionId);

    List<Question> findByTest(Test test);



}
