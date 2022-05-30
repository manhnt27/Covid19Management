/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Controller;

/**
 *
 * @author tuanm
 */

import com.manhnt27.spring_boot.Model.Vaccine.VaccineReport;
import com.manhnt27.spring_boot.Service.VaccineService;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class VaccineController {
    @Autowired
    private VaccineService vaccineService;
    
    @GetMapping("/vaccine")
    public List<VaccineReport> getTodoList() {
        return vaccineService.findAll();
    }
    
    @GetMapping("/vaccine/get/user_id={user_id}")
    public ResponseEntity getVaccineReportByUserId(@PathVariable(name = "user_id") Long user_id) {
        return ResponseEntity.ok().body(vaccineService.getVaccineReportByUserId(user_id));
    }

    @PutMapping("/vaccine/put/{id}")
    public VaccineReport editVaccine(@PathVariable(name = "id") Long id,
                         @RequestBody VaccineReport vaccineReport){
        vaccineService.edit(id, vaccineReport);
        // Trả về đối tượng sau khi đã edit
        return vaccineReport;    
    }


    @PostMapping("/vaccine/post")
    public ResponseEntity addVaccineReport(@RequestBody VaccineReport vaccineReport) {
        vaccineService.add(vaccineReport);
        return ResponseEntity.ok().body(vaccineReport);
    }
}