/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.services;

import com.bits.Product;
import com.bits.ProductGroup;
import com.bits.Unit;
import com.bits.base.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ProductService {
    private final String fileName = "products.obj";
    
    public void save(Product product) throws IOException {
        String sql = String.format(
                "INSERT INTO product(code, name, unit_price, quantity, unit_id, product_group_id) VALUES('%s', '%s', '%s', '%s', '%s', '%s')",
                product.getCode(),
                product.getName(),
                product.getUnitPrice(),
                product.getQuantity(),
                product.getUnit().getId(),
                product.getProductGroup().getId()
        );
        
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public ArrayList<Product> getAll() {
        ArrayList<Product> data = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY id";
        DatabaseService service = new DatabaseService();
        
        try (
            Connection conn = service.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while (rs.next()) {
                data.add(
                    new Product(
                            rs.getInt("id"),
                            rs.getString("code"),
                            rs.getString("name"),
                            rs.getFloat("unit_price"),
                            rs.getFloat("quantity"),
                            getUnit(rs.getInt("unit_id")),
                            getProductGroup(rs.getInt("product_group_id"))
                    )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }
    
    public Unit getUnit(int id) {
        Unit unit = new Unit();
        
        String sql = String.format(
                "SELECT * FROM unit WHERE id = '%s'", 
                id);
        DatabaseService service = new DatabaseService();
        
        try (
            Connection conn = service.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            if (rs.next()) {
                unit = new Unit(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name")
                );
            }
            return unit;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return unit;
    }
    
    public ProductGroup getProductGroup(int id) {
        ProductGroup productGroup = new ProductGroup();
        
        String sql = String.format(
                "SELECT * FROM product_group WHERE id = '%s'", 
                id);
        DatabaseService service = new DatabaseService();
        
        try (
            Connection conn = service.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            if (rs.next()) {
                productGroup = new ProductGroup(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name")
                );
            }
            return productGroup;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productGroup;
    }
    
    public void delete(int id) {
        String sql = String.format(
            "DELETE FROM product WHERE id='%d'",id);
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public void update(Product product, String column, String value) {
        String sql = String.format(
            "UPDATE product SET %s='%s' WHERE id=%d",
            column,
            value,
            product.getId()
        );
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public void writeAll(List<Product> products) {
        String values = "";
        for (Product product: products) {
            if (!values.equals("")) {
                values += ",";
            }
            values += String.format("('%s', '%s', '%s', '%s', '%s', '%s')", 
                    product.getCode(),
                    product.getName(),
                    product.getUnitPrice(),
                    product.getQuantity(),
                    product.getUnit().getId(),
                    product.getProductGroup().getId()
            );
        }
        String sql = String.format("INSERT INTO unit(code, name, unit_price, quantity, unit_id, product_group_id) VALUES %s;", values);
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
}
