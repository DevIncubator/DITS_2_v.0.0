package com.devincubator.repository;

import com.devincubator.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitry on 26.02.2018.
 */
public interface TestRepository extends JpaRepository<Test, Long> {
}
