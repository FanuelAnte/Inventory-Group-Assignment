/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.services;

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
 * @author henock
 */
public class UnitService {
    
    public void save(Unit unit) throws IOException {
        String sql = String.format(
            "INSERT INTO unit(code, name) VALUES('%s', '%s')", unit.getCode(), unit.getName()
        );
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public ArrayList<Unit> getAll() {
        ArrayList<Unit> data = new ArrayList<>();
        String sql = "SELECT * FROM unit ORDER BY id";
        DatabaseService service = new DatabaseService();
        try (
            Connection conn = service.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            while (rs.next()) {
                data.add(
                    new Unit(
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
    
    public void update(Unit unit, String column, String value) {
        String sql = String.format(
            "UPDATE unit SET %s='%s' WHERE id=%d",
            column,
            value,
            unit.getId()
        );
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public void delete(int id) {
        String sql = String.format(
            "DELETE FROM unit WHERE id='%d'",id);
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public void writeAll(List<Unit> units) {
        String values = "";
        for (Unit unit: units) {
            if (!values.equals("")) {
                values += ",";
            }
            values += String.format("('%s', '%s')", unit.getCode(), unit.getName());
        }
        String sql = String.format("INSERT INTO unit(code, name) VALUES %s;", values);
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
}
