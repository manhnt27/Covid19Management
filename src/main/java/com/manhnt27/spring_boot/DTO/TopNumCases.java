/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.manhnt27.spring_boot.DTO;

import java.io.Serializable;

/**
 *
 * @author manhnt
 */
public class TopNumCases implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private Long num_cases;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum_cases() {
        return num_cases;
    }

    public void setNum_cases(Long num_cases) {
        this.num_cases = num_cases;
    }

    public TopNumCases(String name, Long num_cases) {
        this.name = name;
        this.num_cases = num_cases;
    }

    
    
    
}
