/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Controller;

import com.manhnt27.spring_boot.Service.AnalysisPatientF0Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manhnt
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AnalysisPatientF0Controller {
    @Autowired
    private AnalysisPatientF0Service analysisPatientF0Service;
    
    @GetMapping("/analysis/patientf0")
    public ResponseEntity getAnalysisPatientF0() {
        return ResponseEntity.ok().body(analysisPatientF0Service.showAnalysisPatientF0());
    }
    
    @GetMapping("/analysis/patientf0/province_id={province_id}")
    public ResponseEntity getAnalysisPatientF0Province(@PathVariable(name = "province_id") String province_id) {
        return ResponseEntity.ok().body(analysisPatientF0Service.showAnalysisPatientF0(province_id));
    }
    
    @GetMapping("/analysis/patientf0/province_id={province_id}/district_id={district_id}")
    public ResponseEntity getAnalysisPatientF0District(@PathVariable(name = "province_id") String province_id,
                    @PathVariable(name = "district_id") String district_id) {
        System.out.println("Called");
        return ResponseEntity.ok().body(analysisPatientF0Service.showAnalysisPatientF0(province_id, district_id));
    }
}
