package com.project.schoolmanagment.repository;

import com.project.schoolmanagment.entity.concretes.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,Long> {


    List<StudentInfo>getAllByStudentId_Id(Long studentId);


    boolean existsByIdEquals(Long id);
}
