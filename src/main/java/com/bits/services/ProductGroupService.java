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

/**
 *
 * @author user
 */
public class ProductGroupService {
    private final String fileName = "productGroups.obj";
    
    public void save(ProductGroup productGroup) throws IOException {
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
    
    public ArrayList<ProductGroup> getAll() {
        boolean eof = false;
        ArrayList<ProductGroup> data = new ArrayList<>(); 

        try (FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            ProductGroup productGroup;

            while (!eof) {
                productGroup = (ProductGroup)ois.readObject();
                if (productGroup != null) {
                    data.add(productGroup);
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
    
    public void writeAll(List<ProductGroup> productGroups) {
        try {
            try (FileOutputStream fos = new FileOutputStream(fileName);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                
                for (ProductGroup productGroup: productGroups) {
                    oos.writeObject(productGroup);
                }
                
            }
        } catch (IOException ex) {
            
        }
    }
}
