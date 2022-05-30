/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Controller;

import com.manhnt27.spring_boot.Service.AnalysisVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manhnt
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AnalysisVaccineController {
    @Autowired
    private AnalysisVaccineService analysisVaccineService;
    
    @GetMapping("/analysis/vaccine")
    public ResponseEntity getAnalysisPatientF0() {
        return ResponseEntity.ok().body(analysisVaccineService.getTopVaccineRate());
    }
    
    
}
