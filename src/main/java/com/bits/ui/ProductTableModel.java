/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.ui;

import com.bits.Product;
import com.bits.ProductGroup;
import com.bits.Unit;
import com.bits.Util;
import com.bits.services.ProductService;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class ProductTableModel extends AbstractTableModel {
    List<Product> products = new ArrayList<>();
    String columnNames[] = {
        "Code", 
        "Name", 
        "UnitPrice", 
        "Quantity", 
        "Unit", 
        "ProductGroup" 
    };
    Class<?> columnClasses[] = {
        String.class, 
        String.class,
        float.class,
        float.class,
        Unit.class,
        ProductGroup.class
    }; 

    Map fieldMap = new HashMap();
    
    ProductTableModel() {
        fieldMap.put(0, "Code");
        fieldMap.put(1, "Name");
        fieldMap.put(2, "UnitPrice");
        fieldMap.put(3, "Quantity");
        fieldMap.put(4, "Unit");
        fieldMap.put(5, "ProductGroup");
    }
    
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var methodName = String.format("get%s", (String) fieldMap.get(columnIndex));
        Method method = Util.getByMethodName(products.get(rowIndex), methodName);
        return (Object) Util.callMethod(method, products.get(rowIndex));
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var methodName = String.format("set%s", (String) fieldMap.get(columnIndex));
        Method method = Util.getByMethodName(products.get(rowIndex), methodName, String.class);
        Util.callMethod(method, products.get(rowIndex), aValue);
        
        fireTableCellUpdated(rowIndex, columnIndex);
        
        ProductService productService = new ProductService();
        productService.writeAll(products);
    }
    
}
