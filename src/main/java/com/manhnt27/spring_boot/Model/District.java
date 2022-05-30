/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Model;

import javax.persistence.Id;

/**
 *
 * @author manhnt
 */
public class District {
    @Id
    private String id;
    private String name;
    private Long population;
    private String province_id;
}
