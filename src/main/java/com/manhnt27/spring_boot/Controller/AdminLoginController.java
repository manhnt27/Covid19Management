/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Controller;

import com.manhnt27.spring_boot.DTO.LoginRequest;
import com.manhnt27.spring_boot.DTO.LoginResponse;
import com.manhnt27.spring_boot.Model.Admin.AuthAdmin;
import com.manhnt27.spring_boot.Security.AdminDetails;
import com.manhnt27.spring_boot.Utils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class AdminLoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.getUsername());
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        System.out.println(authentication.isAuthenticated());
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Trả về jwt cho người dùng.
        AdminDetails adminDetails = (AdminDetails) authentication.getPrincipal();
        String jwt = tokenProvider.generateToken(adminDetails);
        
        return ResponseEntity.ok().body(new AuthAdmin(jwt, adminDetails.getUsername(), adminDetails.getPassword()));
    }

    @GetMapping("/login")
    public String getTodoList() {
        return "asd";
    }

}
