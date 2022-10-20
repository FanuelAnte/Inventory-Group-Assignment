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
public class Sale {
    private Product product;
    private Date saleDate;
    private float quantity;
    private float totalPrice;
    
    public Sale() {
    }
    
    public Sale(Product product, Date saleDate, float quantity, float totalPrice) {
        this.product = product;
        this.saleDate = saleDate;
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
     * @return the saleDate
     */
    public Date getSaleDate() {
        return saleDate;
    }

    /**
     * @param saleDate the saleDate to set
     */
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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
