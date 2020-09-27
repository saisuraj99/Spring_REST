package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dxc.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}