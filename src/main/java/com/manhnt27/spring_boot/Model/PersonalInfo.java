/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author tuanm
 */
@Data
@Entity
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;    
    private LocalDate dob;
    private String citizen_id;
    private String address;
    private Boolean gender;
    @Column(name="phone_number")
    private String phoneNumber;
    
    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.name = personalInfo.name;
        this.citizen_id = personalInfo.citizen_id;
        this.dob = personalInfo.dob;
        this.gender = personalInfo.gender;
        this.phoneNumber  = personalInfo.phoneNumber;
        this.address = personalInfo.address;
    }
    
 }