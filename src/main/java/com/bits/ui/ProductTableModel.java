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
        "ID",
        "Code", 
        "Name", 
        "UnitPrice", 
        "Quantity", 
        "Unit", 
        "ProductGroup" 
    };
    Class<?> columnClasses[] = {
        Integer.class,
        String.class, 
        String.class,
        float.class,
        float.class,
        Unit.class,
        ProductGroup.class
    }; 

    Map fieldMap = new HashMap();
    
    ProductTableModel() {
        fieldMap.put(0, "Id");
        fieldMap.put(1, "Code");
        fieldMap.put(2, "Name");
        fieldMap.put(3, "UnitPrice");
        fieldMap.put(4, "Quantity");
        fieldMap.put(5, "Unit");
        fieldMap.put(6, "ProductGroup");
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
        Object result = Util.callMethod(method, products.get(rowIndex));
        return result;
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
        return columnIndex != 0;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        String column = (String) fieldMap.get(columnIndex);
        var methodName = String.format("set%s", column);
        Method method = Util.getByMethodName(product, methodName, String.class);
        Util.callMethod(method, products.get(rowIndex), aValue);
        
        fireTableCellUpdated(rowIndex, columnIndex);
        
        ProductService productService = new ProductService();
        productService.writeAll(products);
    }
}
