/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Model.Vaccine;

import java.io.Serializable;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tuanm
 */
@Entity
@Data
public class VaccineReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private Integer num_doses;
    @Column(name="user_id")
    private Long userId;
    @Type(type = "com.manhnt27.spring_boot.UserType.VaccineArrayUserType")
    private Vaccine[] vaccine;
    private String province_id;
    private String district_id;
    
    public void setVaccineReport(VaccineReport vaccineReport) {
        this.num_doses = vaccineReport.num_doses;
        this.vaccine = vaccineReport.vaccine;
    }
   
}
