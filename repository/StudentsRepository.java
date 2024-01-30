package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

}
