/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits;

import java.util.Date;

/**
 *
 * @author henock
 */
public class Purchase {
    private Product product;
    private Date purchaseDate;
    private float quantity;
    private float totalPrice;

    public Purchase() {
    }
    
    public Purchase(Product product, Date purchaseDate, float quantity, float totalPrice) {
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the purchaseDate
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * @param purchaseDate the purchaseDate to set
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
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
        this.quantity = quantity;
    }

    /**
     * @return the totalPrice
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
