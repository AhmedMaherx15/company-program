/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AdminRole;
import backend.EmployeeUser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ahmed Maher
 */
public class View_Employees extends javax.swing.JFrame {

    /**
     * Creates new form View_Employees
     */
    private AdminRole b;
    private AdminRolegui a;
    private Node parent;
    public View_Employees(AdminRolegui a,AdminRole b) {
        initComponents();
        this.a=a;
        this.b=b;
        EmployeeUser[] e =b.getListOfEmployees();
        DefaultTableModel tableModel =(DefaultTableModel) jTable1.getModel();
        for(int i=0;i<b.getListOfEmployees().length;i++){
        tableModel.addRow(new Object[]{e[i].employeeId,e[i].name,e[i].email,e[i].address,e[i].phoneNumber});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Id", "Name", "Email", "Address", "Phone Number"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        ((JFrame)getparentnode()).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public Node getparentnode(){
        return parent;
    }
    public void setparentnode(Node node){
        parent=node;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
}
