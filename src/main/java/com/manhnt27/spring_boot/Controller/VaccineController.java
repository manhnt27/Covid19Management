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

/**
 * Lưu ý, @RequestMapping ở class, sẽ tác động tới
 * tất cả các RequestMapping ở bên trong nó.
 * 
 * Mọi Request ở trong method sẽ được gắn thêm prefix /api/v1
 */
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

   


    /*
    @RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
    thành đối tượng Todo
     */
    @PutMapping("/vaccine/put/{id}")
    public VaccineReport editVaccine(@PathVariable(name = "id") Long id,
                         @RequestBody VaccineReport vaccineReport){
        vaccineService.edit(id, vaccineReport);
        // Trả về đối tượng sau khi đã edit
        return vaccineReport;    
    }

    @DeleteMapping("/vaccine/{adminId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "adminId") Long adminId){
        vaccineService.remove(adminId.longValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/vaccine/post")
    public ResponseEntity addVaccineReport(@RequestBody VaccineReport vaccineReport) {
        vaccineService.add(vaccineReport);
        return ResponseEntity.ok().body(vaccineReport);
    }
}