/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits;

import java.io.Serializable;

/**
 *
 * @author henock
 */
public class Product extends Lookup implements Serializable {
    private int id;
    private float unitPrice;
    private float quantity;
    private Unit unit;
    private ProductGroup productGroup;
    
    public Product() {
    }
    
    public Product(
        int id,
        String code,
        String name,
        float unitPrice,
        float quantity,
        Unit unit,
        ProductGroup productGroup
    ) {
        super(id, code, name);
        String error = null;
        
        if (!Util.validatePositive(unitPrice)) {
            error = String.format("The price %f is invalid", unitPrice);
        } else if (!Util.validatePositive(quantity)) {
            error = String.format("The quantity %f is invalid.", quantity);
        }
        
        if (error != null) {
            throw new IllegalArgumentException(error);
        } else {
            this.unitPrice = unitPrice;
            this.quantity = quantity;
            this.unit = unit;
            this.productGroup = productGroup;
        }
    }
    
    public Product(
        String code,
        String name,
        float unitPrice,
        float quantity,
        Unit unit,
        ProductGroup productGroup
    ) {
        super(code, name);
        String error = null;
        
        if (!Util.validatePositive(unitPrice)) {
            error = String.format("The price %f is invalid", unitPrice);
        } else if (!Util.validatePositive(quantity)) {
            error = String.format("The quantity %f is invalid.", quantity);
        }
        
        if (error != null) {
            throw new IllegalArgumentException(error);
        } else {
            this.unitPrice = unitPrice;
            this.quantity = quantity;
            this.unit = unit;
            this.productGroup = productGroup;
        }
    }

    
    /**
     * @return the unitPrice
     */
    public float getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(float unitPrice) {
        if (Util.validatePositive(unitPrice)) {
            this.unitPrice = unitPrice;
        } else {
            throw new IllegalArgumentException(String.format("The price %.2f is invalid.", unitPrice));
        }
    }

    /**
     * @return the quantity
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(float quantity) {
        if (Util.validatePositive(quantity)) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException(String.format("The quantity %.2f is invalid.", quantity));
        }
    }

    /**
     * @return the unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * @return the productGroup
     */
    public ProductGroup getProductGroup() {
        return productGroup;
    }

    /**
     * @param productGroup the productGroup to set
     */
    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
    
    
}
