package com.devincubator.service;

import com.devincubator.entity.Link;
import com.devincubator.entity.Literature;
import com.devincubator.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinkServiceImpl {

    @Autowired
    LinkRepository linkRepository;

    public List<Link> findByLiterature(Literature literature){
        return linkRepository.findByLiterature(literature);
    }
}
