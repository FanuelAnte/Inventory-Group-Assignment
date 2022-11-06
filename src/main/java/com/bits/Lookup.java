/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author henock
 */
public class Lookup implements Serializable {    
    private int id;
    private String code;
    private String name;
    
    public Lookup() {
    }
    
    public Lookup(String code, String name) {
        if (Util.validateLength(code, 3)) {
            this.code = code;
            this.name = name;
        } else {
            String error = String.format("The code %s is invalid.", code);
            throw new IllegalArgumentException(error);
        }
    }
    
    public Lookup(int id, String code, String name) {
        this(code, name);
        this.id = id;
    }
    
    public static Lookup getByCode(ArrayList<? extends Lookup> items, String code) {
        return items.stream().filter(
            (var item) -> code.equals(item.getCode())
        ).findFirst().orElse(null);
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        if (Util.validateLength(code, 3)) {
            this.code = code;
        } else {
            String error = String.format("The code %s is invalid.", code);
            throw new IllegalArgumentException(error);
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
