/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Service;

import com.manhnt27.spring_boot.Model.PersonalInfo;
import com.manhnt27.spring_boot.Repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tuanm
 */
@Service
public class PersonalInfoService {
    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    public PersonalInfo add(PersonalInfo personalInfo) {
       return personalInfoRepository.save(personalInfo);
    }
}
