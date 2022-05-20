/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Model;

import com.sun.xml.bind.v2.WellKnownNamespace;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.aspectj.weaver.bcel.UnwovenClassFile;

/**
 *
 * @author tuanm
 */

@Entity
@Data
@Table(name="patientf0")
public class PatientF0 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String test_unit;
    private String health_status; 
    private LocalDate positive_date;
    private Boolean recover;
    private LocalDate negative_date;
    private long user_id;
   
    public void setPatientF0(PatientF0 patientF0) {
        this.health_status = patientF0.health_status;
        this.positive_date = patientF0.positive_date;
        this.recover = patientF0.recover;
        this.negative_date = patientF0.negative_date;
    }
}
