package com.devincubator.repository;

import com.devincubator.entity.Literature;
import com.devincubator.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature, Long> {

    List<Literature> findByQuestion(Question question);

}
