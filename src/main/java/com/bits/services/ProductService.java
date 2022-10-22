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

/**
 *
 * @author user
 */
public class ProductService {
    private final String fileName = "products.obj";
    
    public void save(Product product) throws IOException {
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
            
            oos.writeObject(product);

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
    
    
    public ArrayList<Product> getAll() {
        boolean eof = false;
        ArrayList<Product> data = new ArrayList<>(); 

        try (
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Product product;

            while (!eof) {
                product = (Product)ois.readObject();
                if (product != null) {
                    data.add(product);
                } else {
                    eof = true;
                }
            }
        } catch (IOException ex) {
//            ex.printStackTrace();
        } finally {
            return data;
        }
    }
    
    public void writeAll(List<Product> products) {
        try {
            try (FileOutputStream fos = new FileOutputStream(fileName);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Product product: products) {
                    oos.writeObject(product);
                }
            }
        } catch (IOException ex) {
            
        }
    }
    
}
