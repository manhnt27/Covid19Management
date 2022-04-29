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
import lombok.Data;
import org.aspectj.weaver.bcel.UnwovenClassFile;

/**
 *
 * @author tuanm
 */

@Entity
@Data
public class PatientF0 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String citizenId;
    private String phoneNumber;
    private LocalDate DOB;
    private String address;
    private LocalDate positiveDate;
    private LocalDate negativeDate;
    
    private enum Test {
        RT_PCR,
        RAPID_ANTIGEN_TEST
    }
    private enum Health {
        WELL,
        UNWELL,
        SERIOUS,
        DEAD
    }

    private Test test_type;
    private Health health_status;

}
