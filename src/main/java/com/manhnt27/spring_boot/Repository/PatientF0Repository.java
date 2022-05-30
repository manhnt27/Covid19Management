/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.manhnt27.spring_boot.Repository;

import com.manhnt27.spring_boot.DTO.TopNumCases;
import com.manhnt27.spring_boot.Model.PatientF0;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author tuanm
 */
public interface PatientF0Repository extends JpaRepository<PatientF0, Long>{
    @Query(value = "SELECT * FROM patientf0 where health_status LIKE 'positive%'",
            nativeQuery= true)
    List<PatientF0> getPositiveAll();
    
    @Query(value = "SELECT * FROM patientf0 p "
            + "WHERE p.health_status LIKE 'positive%' "
            + "AND p.province_id = :province_id",
            nativeQuery= true)
    List<PatientF0> getPositiveByProvince(@Param("province_id") String province_id);
    
    @Query(value = "SELECT * FROM patientf0 p "
            + "WHERE p.health_status LIKE 'positive%' "
            + "AND p.province_id = :province_id "
            + "AND p.district_id = :district_id",
            nativeQuery= true)
    List<PatientF0> getPositiveByDistrict(@Param("province_id") String province_id,
            @Param("district_id") String district_id);
    
    @Query("SELECT "
            + "new com.manhnt27.spring_boot.DTO.TopNumCases(pr.name, count(p) as num) "
            + "FROM PatientF0 p " 
            + "JOIN Province pr ON p.province_id = pr.id "
            + "GROUP BY pr.id "
            + "ORDER BY num DESC")
    List<TopNumCases> getTopNumCases();
    
    PatientF0 findByUserId(Long user_id);
}
