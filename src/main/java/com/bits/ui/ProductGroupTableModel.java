/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.ui;

import com.bits.ProductGroup;
import com.bits.Util;
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
public class ProductGroupTableModel extends AbstractTableModel {
    
    List<ProductGroup> productGroups = new ArrayList<>();
    String columnNames[] = {"Code", "Name"};
    Class<?> columnClasses[] = {String.class, String.class};
    
    Map fieldMap = new HashMap();
    
    ProductGroupTableModel() {
        fieldMap.put(0, "Code");
        fieldMap.put(1, "Name");
    }
    
    @Override
    public int getRowCount() {
        return productGroups.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var methodName = String.format("get%s", (String) fieldMap.get(columnIndex));
        Method method = Util.getByMethodName(productGroups.get(rowIndex), methodName);
        return (String) Util.callMethod(method, productGroups.get(rowIndex));
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
        Method method = Util.getByMethodName(productGroups.get(rowIndex), methodName, String.class);
        Util.callMethod(method, productGroups.get(rowIndex), aValue);

        fireTableCellUpdated(rowIndex, columnIndex);
        
    }
    
}
