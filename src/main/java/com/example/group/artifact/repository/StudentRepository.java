package com.example.group.artifact.repository;

import org.springframework.stereotype.Repository;
import com.example.group.artifact.domain.Student;

import java.util.List;

import org.springframework.data.jpa.repository.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {

    List<Student> findDistinctByGender(String string);

    List<Student> findDistinctByRollNo(String string);

    List<Student> findDistinctNameByRollNo(String string);

}
