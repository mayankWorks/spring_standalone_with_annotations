package com.mayank.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank.spring.model.Emp;

public interface TestRepository extends JpaRepository<Emp,Long> {

}
