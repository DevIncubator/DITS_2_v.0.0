package com.devincubator.service;

import com.devincubator.entity.Literature;
import com.devincubator.entity.Question;
import com.devincubator.repository.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LiteratureService {

    @Autowired
    LiteratureRepository literatureRepository;

    public List<Literature> findByQuestion(Question question){
        return literatureRepository.findByQuestion(question);
    }

}
