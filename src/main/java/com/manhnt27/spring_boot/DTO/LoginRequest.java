/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.DTO;

/**
 *
 * @author tuanm
 */

import lombok.Data;
@Data
public class LoginRequest {
    private String username;

    private String password;
}
