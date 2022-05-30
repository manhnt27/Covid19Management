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
public class Pair<K, V> implements Serializable{
    private static final long serialVersionUID = 1L;
    private K first;
    private V second;
    
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    
     public void setFirst(K first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
