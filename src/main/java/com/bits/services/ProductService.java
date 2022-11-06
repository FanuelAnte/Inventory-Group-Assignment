/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.services;

import com.bits.Product;
import com.bits.Unit;
import com.bits.base.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class ProductService {
    private final String fileName = "products.obj";
    
    public void save(Product product) throws IOException {
            String sql = String.format(
                    "INSERT INTO product(code, name, unit_price, quantity, unit_id, product_group_id)"
                            + "VALUES('%s', '%s', '?', '?', ,'?', '?')", product.getCode(), product.getName(), product.getUnitPrice(), product.getQuantity(),product.getUnit(), product.getProductGroup());
            DatabseService service = new DatabseService();
            service.execute(sql);   
    }
            
            
            
    public ArrayList<Product> getAll() {
                ArrayList<Product> data = new ArrayList<>(); 
                String sql = "SELECT * FROM product ORDER BY id";
                DatabseService service = new DatabseService();
                try (
                    Connection conn = service.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)
                ) {
                    while(rs.next()) {
                        data.add(
                        new Product(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getFloat("unitPrice"),
                        rs.getFloat("quantity"),
                        rs.getObject("Unit"),
                        rs.getObject("productGroup")
                        ));
                    }
                    return data;
                } catch(SQLException ex){
                    ex.printStackTrace();
                }
                    
            return data;
    }

        
     public void update(Product product, String column, String value) {
        String sql = String.format(
        "UPDATE product SET %s='%s' WHERE id=%d",
                column,
                value,
                product.getId()
        );
        DatabseService service = new DatabseService();
        service.execute(sql);
    }
       
        
        
        
        
        
        
    
    public void writeAll(List<Product> products) {
       
       String values = "";
       for (Product product: products ) {
           if (!values.equals("")) {
               values += ",";
           }
           values += String.format(
                    "INSERT INTO product(code, name, unit_price, quantity, unit_id, product_group_id)"
                            + "VALUES('%s', '%s', '?', '?', ,'?', '?')", product.getCode(), product.getName(), product.getUnitPrice(), product.getQuantity(),product.getUnit(), product.getProductGroup());
       }   
       String sql = String.format("INSERT INTO product(code, name, unit_price, quantity, unit_id, product_group_id) VALUES %s;", values);
       DatabseService service = new DatabseService();
       service.execute(sql);
    }
}

