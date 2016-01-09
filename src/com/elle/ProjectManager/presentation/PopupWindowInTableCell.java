/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elle.ProjectManager.presentation;

import static com.elle.ProjectManager.logic.ITableConstants.TASKFILES_TABLE_NAME;
//import static com.elle.ProjectManager.logic.ITableConstants.TASKNOTES_TABLE_NAME;
import static com.elle.ProjectManager.logic.ITableConstants.TASKS_TABLE_NAME;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author fuxiaoqian
 */
public class PopupWindowInTableCell extends JFrame {

    private JTable selectedTable;
    private JFrame selectedFrame;
    private ProjectManagerWindow projectManager;
//    private AddIssueFileWindow addRecords;
    int selectedRow;
    int selectedColumn;

    // mics
    private boolean editBtnIsClick;
    private boolean popupWindowShow;
    private boolean inEditMode;

    /**
     * Creates new form PopupWindowInTableCell
     */
    public PopupWindowInTableCell(JFrame frame, JTable table) {
        selectedFrame = frame;
        selectedTable = table;
        projectManager = ProjectManagerWindow.getInstance();
        selectedRow = table.getSelectedRow();
        selectedColumn = table.getSelectedColumn();

        editBtnIsClick = false;
        popupWindowShow = false;
        inEditMode = false;

        initComponents();
        textAreatableCellPopup.setWrapStyleWord(true);
       

        this.setWindowLocation();
        // add control + tab keystroke to popup window
        this.setControlTabKeyEvent();
//        //setPopupWindow show in different table cell
//        this.popupWindowShowInRecordByDiffTable();
        
        setWindowFocusListener();

        this.setAlwaysOnTop(true);
        
        isEditMode();
        
        this.showWindow();

//        this.setFocusable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tableCellPopupPanel = new javax.swing.JPanel();
        areaScrollPanetableCellPopup = new javax.swing.JScrollPane();
        textAreatableCellPopup = new javax.swing.JTextArea();
        controlPopupPanel = new javax.swing.JPanel();
        confirmButtonTableCellPopup = new javax.swing.JButton();
        cancelButtonTableCellPopup = new javax.swing.JButton();
        editButtonTableCellPopup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 180));
        setSize(new java.awt.Dimension(400, 150));

        areaScrollPanetableCellPopup.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textAreatableCellPopup.setLineWrap(true);
        textAreatableCellPopup.setText("");
        textAreatableCellPopup.setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
        areaScrollPanetableCellPopup.setViewportView(textAreatableCellPopup);

        javax.swing.GroupLayout tableCellPopupPanelLayout = new javax.swing.GroupLayout(tableCellPopupPanel);
        tableCellPopupPanel.setLayout(tableCellPopupPanelLayout);
        tableCellPopupPanelLayout.setHorizontalGroup(
            tableCellPopupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaScrollPanetableCellPopup)
        );
        tableCellPopupPanelLayout.setVerticalGroup(
            tableCellPopupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaScrollPanetableCellPopup, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        controlPopupPanel.setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
        controlPopupPanel.setLayout(new java.awt.GridBagLayout());

        confirmButtonTableCellPopup.setText("Confirm");
        confirmButtonTableCellPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonTableCellPopupActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        controlPopupPanel.add(confirmButtonTableCellPopup, gridBagConstraints);

        cancelButtonTableCellPopup.setText("Cancel");
        cancelButtonTableCellPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonTableCellPopupActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        controlPopupPanel.add(cancelButtonTableCellPopup, gridBagConstraints);

        editButtonTableCellPopup.setText("Edit");
        editButtonTableCellPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonTableCellPopupActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        controlPopupPanel.add(editButtonTableCellPopup, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableCellPopupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(controlPopupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableCellPopupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(controlPopupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonTableCellPopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonTableCellPopupActionPerformed

        confirmButtonActionPerformed(evt, selectedTable);

        //recover the other functions in project manager
        setProjectManagerFunction(true);

    }//GEN-LAST:event_confirmButtonTableCellPopupActionPerformed

    private void cancelButtonTableCellPopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonTableCellPopupActionPerformed

//        selectedTable.setEnabled(true);

        windowClose();
        //recover the other functions in project manager
        setProjectManagerFunction(true);
        selectedTable.getComponentAt(selectedRow, selectedColumn).requestFocus();

    }//GEN-LAST:event_cancelButtonTableCellPopupActionPerformed

    private void editButtonTableCellPopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonTableCellPopupActionPerformed

        inEditMode = true;
        projectManager.makeTableEditable(true);
        setEnableEdit();
        textAreatableCellPopup.selectAll();
        System.out.println("set edit " + textAreatableCellPopup.isEditable());
        editBtnIsClick = true;
        setProjectManagerFunction(false);

    }//GEN-LAST:event_editButtonTableCellPopupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane areaScrollPanetableCellPopup;
    private javax.swing.JButton cancelButtonTableCellPopup;
    private javax.swing.JButton confirmButtonTableCellPopup;
    private javax.swing.JPanel controlPopupPanel;
    private javax.swing.JButton editButtonTableCellPopup;
    private javax.swing.JPanel tableCellPopupPanel;
    private javax.swing.JTextArea textAreatableCellPopup;
    // End of variables declaration//GEN-END:variables

    private void setWindowLocation() {

        // find the selected table cell 
        Rectangle cellRectTable = selectedTable.getCellRect(selectedRow, selectedColumn, true);

        int x = 0, y = 0;

        if (selectedFrame instanceof ProjectManagerWindow) {

            //convert the location in jtable to the location in projectManager window
            cellRectTable = SwingUtilities.convertRectangle(selectedTable, cellRectTable, projectManager);

            x = cellRectTable.x + 140;
            y = cellRectTable.y + 135;

        } else {
            cellRectTable = SwingUtilities.convertRectangle(selectedTable, cellRectTable, projectManager.getAddRecordsWindow());

            x = cellRectTable.x + 150;
            y = cellRectTable.y + 335;
        }
        this.setLocation(x, y);
    }
    
    private void setWindowFocusListener(){
        this.addWindowFocusListener(new WindowAdapter(){
            public void windowGainedFocus(WindowEvent e) {
                
                textAreatableCellPopup.requestFocusInWindow();
                System.out.println("gained!");
    }
        });
    }

    private void setControlTabKeyEvent() {
        textAreatableCellPopup.setFocusTraversalKeysEnabled(false);

        //register cirt+tab to aumatically confirm and shift to the next cell
        Action confirmAndShiftEvent = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setProjectManagerFunction(true);
                confirmButtonActionPerformed(e, selectedTable);

            }

        };

        InputMap im = textAreatableCellPopup.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = textAreatableCellPopup.getActionMap();

        KeyStroke bindingKey = KeyStroke.getKeyStroke("control TAB");

        im.put(bindingKey, "confirm and shift");
        am.put("confirm and shift", confirmAndShiftEvent);
    }

    private void confirmButtonActionPerformed(ActionEvent e, JTable selectedTable) {
        int row = selectedTable.getSelectedRow();
        int column = selectedTable.getSelectedColumn();

        selectedTable.setEnabled(true);

        if (projectManager.getAddRecordsWindowShow()) {

            windowClose();
            String newTableCellValue = textAreatableCellPopup.getText();
            selectedTable.getModel().setValueAt(newTableCellValue, row, column);

        } else {

            windowClose();
            String newTableCellValue = textAreatableCellPopup.getText();

            selectedTable.setValueAt(newTableCellValue, row, column);
            projectManager.uploadChanges();

        }
        selectedTable.changeSelection(selectedRow, selectedColumn + 1, false, false);
    }

    private void setProjectManagerFunction(boolean b) {
        projectManager.setDisableProjecetManagerFunction(b);
    }

    private void setEnableEdit() {
        System.out.println("frame get focused? " + this.isFocused());
        textAreatableCellPopup.setEditable(inEditMode);
        textAreatableCellPopup.requestFocusInWindow();

        editButtonTableCellPopup.setEnabled(!inEditMode);
        editButtonTableCellPopup.setVisible(!inEditMode);

        confirmButtonTableCellPopup.setVisible(inEditMode);
        confirmButtonTableCellPopup.setEnabled(inEditMode);
        cancelButtonTableCellPopup.setVisible(inEditMode);
        cancelButtonTableCellPopup.setEnabled(inEditMode);
    }

    

    private void showWindow() {
//        projectManager.setPopupWindowShowInPM(true);
        
        textAreatableCellPopup.setText((String) selectedTable.getValueAt(selectedRow, selectedColumn));
        
        this.setVisible(true);
        
        this.setFocusable(inEditMode);
        this.requestFocus();
        
        setEnableEdit();
//        projectManager.setDisableProjecetManagerFunction(!inEditMode);
        
//        popupWindowShow = true;
    }

    public void setPopupWindowShow(boolean b) {
        popupWindowShow = b;
    }

    public boolean isPopupWindowShow() {
        return popupWindowShow;
    }

    public boolean isEditButtonClicked() {
        return editBtnIsClick;
    }
    

    public void windowClose() {
        System.out.println("closed!");
//        popupWindowShow = false;
//        projectManager.setPopupWindowShowInPM(false);
        
        this.dispose();
    }

    private void isEditMode() {
        if (selectedFrame instanceof ProjectManagerWindow) {
            System.out.println(" in edit mode? " + projectManager.getEditMode());
            if (!projectManager.getEditMode()) {
                inEditMode = false;
            } else {
                inEditMode = true;;
            }
        } else if (selectedFrame instanceof AddIssueFileWindow) {

            System.out.println("add record!");
            textAreatableCellPopup.setEditable(true);
            editButtonTableCellPopup.setVisible(false);
            editButtonTableCellPopup.setEnabled(false);
        }
    }
}
