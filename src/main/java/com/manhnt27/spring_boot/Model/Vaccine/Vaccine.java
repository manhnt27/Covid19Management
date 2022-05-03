/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.Model.Vaccine;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.postgresql.util.PGobject;

/**
 *
 * @author tuanm
 */

@Data

public class Vaccine { 
   
    private String lot_num;
    private LocalDate date;
    private String immu_unit;
    private String vaccine_type;

    @Override
    public boolean equals(Object obj)
    {
          
    // if both the object references are 
    // referring to the same object.
    if(this == obj)
            return true;
          
        // it checks if the argument is of the 
        // type Geek by comparing the classes 
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
          
        // type casting of the argument. 
        Vaccine vaccine = (Vaccine) obj;
          
        // comparing the state of argument with 
        // the state of 'this' Object.
        return (vaccine.hashCode() == this.hashCode());
    }

    @Override 
    public int hashCode() {
        System.out.println("Manh!!!!!");
        return Objects.hash(vaccine_type, lot_num, date, immu_unit);
    }
    
    public String getValue() {
        String dateVal = (date == null) ? "null" : date.toString();
        return '(' + lot_num + ',' + dateVal + ','
            + immu_unit + ',' + vaccine_type + ')';
    }
}
