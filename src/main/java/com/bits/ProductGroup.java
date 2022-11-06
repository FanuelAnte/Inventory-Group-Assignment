 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author henock
 */
public class ProductGroup extends Lookup implements Serializable {
    public ProductGroup() {
    }
    
    public ProductGroup(String code, String name) {
        super(code, name);
    }

    public static ArrayList<ProductGroup> getProductGroups() {
        ProductGroup[] groups = {
            new ProductGroup("SWT", "Sweets"),
            new ProductGroup("SDR", "Soft Drinks"),
            new ProductGroup("ALC", "Alcoholic Drinks"),
            new ProductGroup("ELE", "Electronics"),
            new ProductGroup("FUR", "Furniture")
        };
        return new ArrayList<>(Arrays.asList(groups));
    }
    
    public static ProductGroup getByCode(String code) {
        return (ProductGroup) Lookup.getByCode(ProductGroup.getProductGroups(), code);
    }

    public ProductGroup(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
