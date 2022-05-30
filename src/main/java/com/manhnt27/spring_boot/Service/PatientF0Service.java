/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Service;

import com.manhnt27.spring_boot.Model.PatientF0;
import com.manhnt27.spring_boot.Repository.PatientF0Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tuanm
 */
@Service
public class PatientF0Service {
    
    @Autowired
    private PatientF0Repository patientF0Repository;
    public PatientF0 add(PatientF0 patientF0) {
       return patientF0Repository.save(patientF0);
    }
    public void edit(long id, PatientF0 patientF0) {
        PatientF0 oldPatientF0 = patientF0Repository.findById(id).get();
        oldPatientF0.setPatientF0(patientF0);
        patientF0Repository.save(oldPatientF0);
    }
    public void remove(long id) {
        PatientF0 patientF0 = patientF0Repository.findById(id).get();
        patientF0Repository.delete(patientF0);
    }
    
    public PatientF0 getPatientF0ByUserId(Long user_id) {
        return patientF0Repository.findByUserId(user_id);
    }
}
