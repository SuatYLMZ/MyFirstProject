package com.project.schoolmanagment.repository;

import com.project.schoolmanagment.entity.concretes.Meet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetRepository extends JpaRepository<Meet,Long> {


    List<Meet> findByStudentList_IdEquals(Long studentId);

    List<Meet> getByAdvisoryTeacher_IdEquals(Long advisoryTeacherId);

    Page<Meet> findByAdvisoryTeacher_IdEquals(Long advisoryTeacherId, Pageable pageable);
}
