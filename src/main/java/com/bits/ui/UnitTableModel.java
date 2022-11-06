/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.ui;

import com.bits.Unit;
import com.bits.Util;
import com.bits.services.UnitService;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author henock
 */
public class UnitTableModel extends AbstractTableModel {
    
    List<Unit> units = new ArrayList<>();
    String columnNames[] = {"ID", "Code", "Name"};
    Class<?> columnClasses[] = {Integer.class, String.class, String.class};
    
    Map fieldMap = new HashMap();
    
    UnitTableModel() {
        fieldMap.put(0, "Id");
        fieldMap.put(1, "Code");
        fieldMap.put(2, "Name");
    }
    
    @Override
    public int getRowCount() {
        return units.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var methodName = String.format("get%s", (String) fieldMap.get(columnIndex));
        Method method = Util.getByMethodName(units.get(rowIndex), methodName);
        Object result = Util.callMethod(method, units.get(rowIndex));
        return columnIndex == 0 ? (int) result : (String) result;
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
        Unit unit = units.get(rowIndex);
        String column = (String) fieldMap.get(columnIndex);
        var methodName = String.format("set%s", column);
        Method method = Util.getByMethodName(unit, methodName, String.class);
        Util.callMethod(method, units.get(rowIndex), aValue);

        fireTableCellUpdated(rowIndex, columnIndex);
        
        UnitService service = new UnitService();
        service.writeAll(units);
    }
}
