/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Service;

import com.manhnt27.spring_boot.Model.PersonalInfo;
import com.manhnt27.spring_boot.Repository.PersonalInfoRepository;
import java.time.LocalDate;
import java.util.List;
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
    public List<PersonalInfo> getPerInfoByName(String name) {
        return personalInfoRepository.findAllByName(name);
    }
    public List<PersonalInfo> getPerInfoByNameAndDOB(String name, LocalDate dob) {
        return personalInfoRepository.findAllByNameAndDob(name, dob);
    }
    public List<PersonalInfo> getPerInfoByPhoneNumber(String phone_number) {
        return personalInfoRepository.findAllByPhoneNumber(phone_number);
    }
    public void edit(long id, PersonalInfo personalInfo) {
        PersonalInfo oldPersonalInfo = personalInfoRepository.findById(id).get();
        oldPersonalInfo.setPersonalInfo(personalInfo);
        personalInfoRepository.save(oldPersonalInfo);
    }

}
