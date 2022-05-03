/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manhnt27.spring_boot.UserType;

import com.manhnt27.spring_boot.Model.Vaccine.Vaccine;
import java.io.Serializable;
import java.sql.Array;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

/**
 *
 * @author tuanm
 */
public class VaccineArrayUserType implements UserType {
    protected static final int[] SQL_TYPES = { Types.ARRAY };

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return this.deepCopy(cached);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Integer[]) this.deepCopy(value);
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {

        if (x == null) {
            return y == null;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        System.out.println(names[0]);
        System.out.println(resultSet.getArray(names[0]));
        if (resultSet == null) {
            System.out.println("manhnt290");
            return null;
        }
        Array array = resultSet.getArray(names[0]);
        Object[] obj = (Object[]) array.getArray();
        System.out.println(obj.length);
        Vaccine[] vac = new Vaccine[obj.length];
        int idx = 0;
        
        for(Object o : obj)
        {
            String value = o.toString();
            value = value.substring(1, value.length() - 1);
            System.out.println(value);
            String[] attributes = value.split(",");
            System.out.println(attributes[0]);
            assert(attributes.length == 4);
            vac[idx] = new Vaccine();
            vac[idx].setLot_num(attributes[0]);
            vac[idx].setDate(LocalDate.parse(attributes[1]));
            vac[idx].setImmu_unit(attributes[2]);
            vac[idx].setVaccine_type(attributes[3]);
            idx++;
        }
        
        //Vaccine[] javaArray = (Vaccine[]) array.getArray();
        return vac;
    }

    @Override
    public void nullSafeSet(PreparedStatement statement, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        Connection connection = statement.getConnection();
        if (value == null) {
            statement.setNull(index, SQL_TYPES[0]);
        } else {
            Object[] obj = (Object[]) value;
            for(Object o: obj)
                System.out.println(o.toString());
            PGobject[] castObject = new PGobject[obj.length];
            int idx = 0;
            for(Object o: obj) {
                castObject[idx] = new PGobject();
                Vaccine vac = (Vaccine) o;
                castObject[idx].setValue(vac.getValue());
                System.out.println(castObject[idx].getValue());
                idx++;
            }
            System.out.println(value.toString());
           
            Array array = connection.createArrayOf("vaccine", castObject);
            
            statement.setArray(index, array);
        }
    }

    @Override
    public Object replace(Object original, Object target, Object owner)       throws HibernateException {
        return original;
    }

    @Override
    public Class returnedClass() {
        System.out.println("ghjf");
        return Vaccine[].class;
    }

    @Override
    public int[] sqlTypes() {
        System.out.println("ambjav");
        return new int[] { Types.ARRAY};
    }
}
    

