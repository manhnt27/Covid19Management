/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.manhnt27.spring_boot.Repository;


import com.manhnt27.spring_boot.DTO.TopVaccineRate;
import com.manhnt27.spring_boot.Model.Vaccine.VaccineReport;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tuanm
 */
@Repository
public interface VaccineRepository extends JpaRepository<VaccineReport, Long> {
    @Query("SELECT "
            + "new com.manhnt27.spring_boot.DTO.TopVaccineRate(p.name, p.id, "
            + "COUNT(p)*100.0/p.population as rate) from VaccineReport AS v "
            + "JOIN Province AS p ON v.province_id = p.id " 
            + "GROUP BY p.id " 
            + "ORDER BY rate DESC")
    List<TopVaccineRate> getTopVaccineRate();
    
    VaccineReport findByUserId(Long user_id);
}
