/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Controller;

import com.manhnt27.spring_boot.Model.PersonalInfo;
import com.manhnt27.spring_boot.Service.PersonalInfoService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tuanm
 */

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PersonalInfoController {
    @Autowired
    private PersonalInfoService personalInfoService;

    @PostMapping("/personal_info/post")
    public ResponseEntity addPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        personalInfoService.add(personalInfo);
        return ResponseEntity.ok().body(personalInfo);
    }

    @GetMapping("/personal_info/get/{name}")
    public ResponseEntity getUserByName(@PathVariable(name = "name") String name){
        return ResponseEntity.ok().body(personalInfoService.getPerInfoByName(name));
    }
    
    @GetMapping("/personal_info/get/id={id}")
    public ResponseEntity getUserByName(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personalInfoService.getPerInfoById(id));
    }
    
    @GetMapping("/personal_info/get/phone_number={phone_number}")
    public ResponseEntity getUserByPhoneNumber(@PathVariable(name = "phone_number") String phone_number){
        return ResponseEntity.ok().body(personalInfoService.getPerInfoByPhoneNumber(phone_number));
    }
    
     @GetMapping("/personal_info/get/{name}/{dob}")
    public ResponseEntity getUserByNameAndDOB(@PathVariable(name = "name") String name,
        @PathVariable(name = "dob") String dobString){
        LocalDate dobDate = LocalDate.parse(dobString);
        return ResponseEntity.ok().body(
            personalInfoService.getPerInfoByNameAndDOB(name, dobDate));
    }
   
    @PutMapping("/personal_info/put/{id}")
    public PersonalInfo editPersonalInfo(@PathVariable(name = "id") Integer id,
                         @RequestBody PersonalInfo personalInfo){
        personalInfoService.edit(id, personalInfo);
        // Trả về đối tượng sau khi đã edit
        return personalInfo;    
}
}
