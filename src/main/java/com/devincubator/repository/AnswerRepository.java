package com.devincubator.repository;

import com.devincubator.entity.Answer;
import com.devincubator.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByQuestion(Question question);

    Answer findByAnswerId(Long id);

    Answer findByDescription(String description);

//    Question findByQuestion
}
