/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Service;

import com.manhnt27.spring_boot.Admin;
import com.manhnt27.spring_boot.Model.Vaccine.VaccineReport;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.manhnt27.spring_boot.Repository.VaccineRepository;

/**
 *
 * @author tuanm
 */
@Service
public class VaccineService {
    @Autowired
    private VaccineRepository vaccineRepository;

   

    /**
     * Lấy ra danh sách List<Todo>
     *
     * @param limit - Giới hạn số lượng lấy ra
     *
     * @return Trả về danh sách List<Todo> dựa theo limit, nếu limit == null thì trả findAll()
     */
    public List<VaccineReport> findAll() {
        return  vaccineRepository.findAll();
    }

    /**
     * Thêm một Todo mới vào danh sách công việc cần làm
     *
     * @return Trả về đối tượng Todo sau khi lưu vào DB, trả về null nếu không thành công
     */
    public VaccineReport add(VaccineReport vaccineReport) {
       return vaccineRepository.save(vaccineReport);
    }

    public void remove(long adminId) {
        VaccineReport vaccineReport = vaccineRepository.findById(adminId).get();
        vaccineRepository.delete(vaccineReport);
    }

    public void edit(long adminId, Admin newTodo) {
        
    }
}