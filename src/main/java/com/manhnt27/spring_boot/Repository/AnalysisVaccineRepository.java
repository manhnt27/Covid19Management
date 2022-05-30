/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.manhnt27.spring_boot.Repository;

import com.manhnt27.spring_boot.Model.Vaccine.VaccineReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author manhnt
 */
@Repository
public interface AnalysisVaccineRepository extends JpaRepository<VaccineReport, Long>{
   
}
