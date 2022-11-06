/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.services;

import com.bits.ProductGroup;
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
public class ProductGroupService  {
    //private final String fileName = "productGroups.obj";
    
    public void save(ProductGroup productGroup) throws IOException {
        String sql = String.format(
        "INSERT INTO product_group(code, name) VALUES('%s', '%s')", product_group.getCode(), product_group.getName());
        DatabseService service = new DatabseService();
        service.execute(sql);
    }       
        /*
        File f = new File(fileName);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            if (f.exists()) {
                fos = new FileOutputStream(fileName, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
            }
            
            oos.writeObject(productGroup);

            oos.close();
            fos.close();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
    */
    public ArrayList<ProductGroup> getAll() {
        ArrayList<ProductGroup> data = new ArrayList<>(); 
        String sql = "SELECT * FROM product_group ORDER BY id";
        DatabseService service = new DatabseService();
        try (
               Connection conn = service.connect();
               Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery(sql)
                ){
            while(rs.next()) {
                data.add(
                new ProductGroup(
                rs.getInt("id"),
                rs.getString("code"),
                rs.getString("name")
                )  
                );
            }
                return data;
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        return data;
    }
    
    public void update(ProductGroup product_group, String column, String value) {
        String sql = String.format(
        "UPDATE product_group SET %s='%s' WHERE id=%d",
                column,
                value,
                product_group.getId()
        );
        DatabseService service = new DatabseService();
        service.execute(sql);
    }
        
        
    public void writeAll(List<ProductGroup> productGroups) {
       String values = "";
       for (ProductGroup product_group: productGroups) {
           if (!values.equals("")) {
               values += ",";
           }
           values += String.format("('%s', '%s')", product_group.getCode(), product_group.getName());
       }   
       String sql = String.format("INSERT INTO product_group(code, name) VALUES %s;", values);
       DatabseService service = new DatabseService();
       service.execute(sql);
    }
}
