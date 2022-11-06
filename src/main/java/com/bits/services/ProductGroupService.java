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
public class ProductGroupService {
    public void save(ProductGroup productGroup) throws IOException {
        String sql = String.format(
            "INSERT INTO product_group(code, name) VALUES('%s', '%s')", productGroup.getCode(), productGroup.getName()
        );
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public ArrayList<ProductGroup> getAll() {
        ArrayList<ProductGroup> data = new ArrayList<>();
        String sql = "SELECT * FROM product_group ORDER BY id";
        DatabaseService service = new DatabaseService();
        try (
            Connection conn = service.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            while (rs.next()) {
                data.add(
                    new ProductGroup(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name")
                    )
                );
            }
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }
    
    public void update(ProductGroup productGroup, String column, String value) {
        String sql = String.format(
            "UPDATE product_group SET %s='%s' WHERE id=%d",
            column,
            value,
            productGroup.getId()
        );
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public void writeAll(List<ProductGroup> productGroups) {
        String values = "";
        for (ProductGroup productGroup: productGroups) {
            if (!values.equals("")) {
                values += ",";
            }
            values += String.format("('%s', '%s')", productGroup.getCode(), productGroup.getName());
        }
        String sql = String.format("INSERT INTO product_group(code, name) VALUES %s;", values);
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
}
