/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.DTO;

import java.io.Serializable;

/**
 *
 * @author manhnt
 */
public class TopVaccineRate implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String unitId;
    private Double rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public TopVaccineRate(String name, String unitId, Double rate) {
        this.name = name;
        this.unitId = unitId;
        this.rate = rate;
    }

    
    
}
