/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Controller;

import com.manhnt27.spring_boot.Model.PersonalInfo;
import com.manhnt27.spring_boot.Service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tuanm
 */

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class PersonalInfoController {
    @Autowired
    private PersonalInfoService personalInfoService;

    @PostMapping("/personal_info")
    public ResponseEntity addTodo(@RequestBody PersonalInfo personalInfo) {
        personalInfoService.add(personalInfo);
        return ResponseEntity.ok().body(personalInfo);
    }
}
