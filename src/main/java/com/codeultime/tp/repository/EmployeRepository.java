package com.codeultime.tp.repository;

import com.codeultime.tp.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
