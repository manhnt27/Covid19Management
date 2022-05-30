/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author manhnt
 */
@Data
@AllArgsConstructor
public class AnalysisPatientF0 {
    private int numCases;
    private int numDead;
    private int numSerious;
    private List<Pair<LocalDate, Integer>> numRecentByDay;
    private List<TopNumCases> topNumCases;
 }
