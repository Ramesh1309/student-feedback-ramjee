package com.cma.principal.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cma.principal.entity.StudentFeedbackDBEntity;

@Repository
public interface StudentFeedbackResponseJPA extends JpaRepository<StudentFeedbackDBEntity,Long> {

}
