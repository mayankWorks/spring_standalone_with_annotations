package com.mayank.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayank.spring.model.Emp;

//@Repository
public interface TestRepository extends JpaRepository<Emp,Long> {

}
