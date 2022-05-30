/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Service;

import com.manhnt27.spring_boot.DTO.TopVaccineRate;
import com.manhnt27.spring_boot.Model.Vaccine.VaccineReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manhnt27.spring_boot.Repository.AnalysisVaccineRepository;
import com.manhnt27.spring_boot.Repository.VaccineRepository;
import java.util.List;

/**
 *
 * @author manhnt
 */
@Service
public class AnalysisVaccineService {
    @Autowired
    private VaccineRepository vaccineRepository;
    
    public List<TopVaccineRate> getTopVaccineRate() {
        return vaccineRepository.getTopVaccineRate();
    }
}
