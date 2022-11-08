/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.bits.ui;

import com.bits.Product;
import com.bits.ProductGroup;
import com.bits.Unit;
import com.bits.services.ProductGroupService;
import com.bits.services.ProductService;
import com.bits.services.UnitService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author user
 */
public class ProductInternalFrame extends javax.swing.JInternalFrame {
    ProductTableModel model;
    
    UnitTableModel unitModel;
    ProductGroupTableModel productGroupModel;
    
    List<Unit> unitsList = new ArrayList<>();
    List<ProductGroup> productGroupsList = new ArrayList<>();
    
    /**
     * Creates new form ProductInternalFrame
     */
    public ProductInternalFrame() {
        model = new ProductTableModel();
        unitModel = new UnitTableModel();
        productGroupModel = new ProductGroupTableModel();
        
        ProductService productService = new ProductService();
        UnitService unitService = new UnitService();
        ProductGroupService productGroupService = new ProductGroupService();
        
        model.products = productService.getAll();
        unitModel.units = unitService.getAll();
        productGroupModel.productGroups = productGroupService.getAll();
        
        unitsList = unitModel.units;
        productGroupsList = productGroupModel.productGroups;
        
        
        initComponents();
        
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        for (Unit unit: unitsList) {
            unitComboList.addItem(unit);
        }
        
        for (ProductGroup productGroup: productGroupsList) {
            productGroupComboList.addItem(productGroup);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        unitComboList = new javax.swing.JComboBox<>();
        productGroupComboList = new javax.swing.JComboBox<>();
        codeInputField = new javax.swing.JTextField();
        nameInputField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        unitPriceInputField = new javax.swing.JTextField();
        quantityInputField = new javax.swing.JTextField();
        deleteBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Products");

        jLabel1.setText("Product Code");

        jLabel2.setText("Product Name");

        jLabel3.setText("Unit Price");

        jLabel4.setText("Quantity");

        jLabel5.setText("Unit");

        jLabel6.setText("Product Group");

        saveButton.setText("Add Product");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        productTable.setModel(model);
        jScrollPane1.setViewportView(productTable);

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codeInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(nameInputField)
                            .addComponent(unitPriceInputField)
                            .addComponent(quantityInputField))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(unitComboList, 0, 115, Short.MAX_VALUE)
                                    .addComponent(productGroupComboList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addGap(30, 30, 30)
                                .addComponent(deleteBtn)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(unitComboList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(productGroupComboList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(unitPriceInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(saveButton)
                    .addComponent(quantityInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (
                codeInputField.getText().equals("") || 
                nameInputField.getText().equals("") ||
                unitPriceInputField.getText().equals("") ||
                quantityInputField.getText().equals("")
                ) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields!");
        } else {
            
            ProductService productService = new ProductService();
            Product product = new Product(
                    codeInputField.getText(), 
                    nameInputField.getText(),
                    Float.parseFloat(unitPriceInputField.getText()),
                    Float.parseFloat(quantityInputField.getText()),
                    (Unit) unitComboList.getSelectedItem(),
                    (ProductGroup) productGroupComboList.getSelectedItem()
            );
            
            try {
                productService.save(product);
            } catch (IOException ex) {
            }
            
            model.products = productService.getAll();
            model.fireTableDataChanged();
            codeInputField.setText("");
            nameInputField.setText("");
            unitPriceInputField.setText("");
            quantityInputField.setText("");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = productTable.getSelectedRow();
        int value = (int) productTable.getModel().getValueAt(row, 0);
        
        ProductService productService = new ProductService();
        productService.delete(value);
        model.products = productService.getAll();
        model.fireTableDataChanged();
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeInputField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameInputField;
    private javax.swing.JComboBox<ProductGroup> productGroupComboList;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField quantityInputField;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<Unit> unitComboList;
    private javax.swing.JTextField unitPriceInputField;
    // End of variables declaration//GEN-END:variables
}
