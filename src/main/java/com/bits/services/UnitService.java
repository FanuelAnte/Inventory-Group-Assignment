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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henock
 */
public class UnitService {
    private final String filename = "units.obj";
    
    public void save(Unit unit) throws IOException {
        File f = new File(filename);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                fos = new FileOutputStream(filename, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(filename);
                oos = new ObjectOutputStream(fos);
            }
            
            oos.writeObject(unit);

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
    
    public ArrayList<Unit> getAll() {
        boolean eof = false;
        ArrayList<Unit> data = new ArrayList<>(); 

        try (
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Unit unit;

            while (!eof) {
                unit = (Unit)ois.readObject();
                if (unit != null) {
                    data.add(unit);
                } else {
                    eof = true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return data;
        }
    }
    
    public void writeAll(List<Unit> units) {
        try {
            try (FileOutputStream fos = new FileOutputStream(filename);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Unit unit: units) {
                    oos.writeObject(unit);
                }
            }
        } catch (IOException ex) {
            
        }
    }
}
