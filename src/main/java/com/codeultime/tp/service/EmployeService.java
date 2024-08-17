package com.codeultime.tp.service;

import com.codeultime.tp.dto.EmployeDTO;

import java.util.List;


public interface EmployeService {
    List<EmployeDTO> getEmployes();

    EmployeDTO create(EmployeDTO employeDto);

    void updateEmploye(Long id, EmployeDTO employeDto);

    void suppression(Long id);
}
