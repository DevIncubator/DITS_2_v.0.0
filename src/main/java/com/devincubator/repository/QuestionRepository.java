package com.devincubator.repository;

import com.devincubator.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findByQuestionId(int questionId);

}
