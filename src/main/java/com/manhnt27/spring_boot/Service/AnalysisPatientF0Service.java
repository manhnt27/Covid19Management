/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Service;

import com.manhnt27.spring_boot.DTO.AnalysisPatientF0;
import com.manhnt27.spring_boot.DTO.Pair;
import com.manhnt27.spring_boot.DTO.TopNumCases;
import com.manhnt27.spring_boot.Model.PatientF0;
import com.manhnt27.spring_boot.Repository.PatientF0Repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manhnt
 */
@Service
public class AnalysisPatientF0Service {
    @Autowired
    private PatientF0Repository patientF0Repository;
    
    private AnalysisPatientF0 analynizePatientF0(List<PatientF0> patientF0s) {
        int numCases = 0;
        int numDead = 0;
        int numSerious = 0;
        List<Pair<LocalDate, Integer>> numRecentByDay = new ArrayList<>();
        Integer[] numRecent = new Integer[5];
        for(int i = 0; i <= 4 ; i++)
            numRecent[i] = 0;
        for(PatientF0 patientF0: patientF0s) {
            if(patientF0.getHealth_status().contains("positive"))
                numCases++;
            if(patientF0.getHealth_status().contains("positive_dead"))
                numDead++;
            if(patientF0.getHealth_status().contains("positive_serious"))
                numSerious++;
            LocalDate f0Date = patientF0.getPositive_date();
            LocalDate curDate = LocalDate.now();
            for(int i = 4; i >= 0 ; i--)
                if(f0Date.plusDays(i).equals(curDate))
                    numRecent[i]++;
         }
        for(int i = 0; i <= 4 ; i++)
            numRecentByDay.add(new Pair<>(LocalDate.now().minusDays(i), numRecent[i]));
        

        List<TopNumCases> topNumCaseses = patientF0Repository.getTopNumCases();
        return new AnalysisPatientF0(numCases, numDead, numSerious, numRecentByDay, topNumCaseses);
    } 
    
    public AnalysisPatientF0 showAnalysisPatientF0() {
        List<PatientF0> patientF0s = patientF0Repository.getPositiveAll();
        return analynizePatientF0(patientF0s);
    }
    
    public AnalysisPatientF0 showAnalysisPatientF0(String province_id) {
        List<PatientF0> patientF0s = patientF0Repository.getPositiveByProvince(province_id);
        return analynizePatientF0(patientF0s);
    }
    
    public AnalysisPatientF0 showAnalysisPatientF0(String province_id, String district_id) {
        List<PatientF0> patientF0s = patientF0Repository.
                getPositiveByDistrict(province_id, district_id);
        return analynizePatientF0(patientF0s);
    }
}
