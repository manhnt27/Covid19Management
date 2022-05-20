/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Model.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author tuanm
 */
@Data
public class AuthAdmin {
    private String jwt;
    private String username;
    private String password;
    public AuthAdmin(String jwt, String username, String password) {
        this.jwt = jwt;
        this.username = username;
        this.password = password;
    }
}
