package com.devincubator.repository;

import com.devincubator.entity.Link;
import com.devincubator.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    List<Link> findByLiterature(Literature literature);

}
