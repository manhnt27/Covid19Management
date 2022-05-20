/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.manhnt27.spring_boot.Repository;

import com.manhnt27.spring_boot.Model.PersonalInfo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tuanm
 */
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long>{
    List<PersonalInfo> findAllByName(String name);
    List<PersonalInfo> findAllByNameAndDob(String name, LocalDate dob);
    List<PersonalInfo> findAllByPhoneNumber(String phone_number);

}
