/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Controller;

import com.manhnt27.spring_boot.Model.PatientF0;
import com.manhnt27.spring_boot.Service.PatientF0Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tuanm
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PatientF0Controller {
    
    @Autowired
    private PatientF0Service patientF0Service;
    
    @PostMapping("/patientf0/post")
    public ResponseEntity addPersonalInfo(@RequestBody PatientF0 patientF0) {
        patientF0Service.add(patientF0);
        return ResponseEntity.ok().body(patientF0);
    }
    
     @PutMapping("/patientf0/put/{id}")
    public PatientF0 editPatientF0(@PathVariable(name = "id") Integer id,
                         @RequestBody PatientF0 patientF0){
        patientF0Service.edit(id, patientF0);
        // Trả về đối tượng sau khi đã edit
        return patientF0; 
    }

    @DeleteMapping("/patientf0/delete/{id}")
    public ResponseEntity deletePatientF0(@PathVariable(name = "id") Long id){
        patientF0Service.remove(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/patientf0/get/user_id={user_id}")
    public ResponseEntity getVaccineReportByUserId(@PathVariable(name = "user_id") Long user_id) {
        return ResponseEntity.ok().body(patientF0Service.getPatientF0ByUserId(user_id));
    }
}
