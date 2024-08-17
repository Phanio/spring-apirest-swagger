package com.codeultime.tp.service;

import com.codeultime.tp.dto.EmployeDTO;
import com.codeultime.tp.entities.Employe;
import com.codeultime.tp.repository.EmployeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {
    private final EmployeRepository employeRepository;
    private final ModelMapper modelMapper;

    public EmployeServiceImpl(EmployeRepository employeRepository, ModelMapper mapper) {
        this.employeRepository = employeRepository;
        this.modelMapper = mapper;
    }

    @Override
    public List<EmployeDTO> getEmployes() {
        List<Employe> employes = employeRepository.findAll();
        return employes.stream().map(item -> modelMapper.map(item, EmployeDTO.class)).toList();
    }

    @Override
    public EmployeDTO create(EmployeDTO employeDto) {
        Employe employe = modelMapper.map(employeDto, Employe.class);
        return modelMapper.map(employeRepository.save(employe), EmployeDTO.class);
    }

    @Override
    public void updateEmploye(Long id, EmployeDTO employeDto) {
        employeRepository.findById(id).ifPresent(item -> {
            Employe employe = modelMapper.map(employeDto, Employe.class);
            employe.setId(id);
            employeRepository.save(employe);
        });
    }

    @Override
    public void suppression(Long id) {
        employeRepository.deleteById(id);
    }
}
