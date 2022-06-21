/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventureworks2019;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vfern
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public Customer() {
        initComponents();
        ver();
        this.setLocationRelativeTo(null);

    }

    public void ver() {
        DefaultTableModel T = (DefaultTableModel) TCustomer.getModel();
        T.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columna;

        int[] anchos = {80, 70, 60, 60, 85, 280, 155};
        for (int i = 0; i < TCustomer.getColumnCount(); i++) {
            TCustomer.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try {
            Connection con = Conector.getConexion();
            String consulta = "SELECT * FROM Sales.Customer";
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columna = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columna];
                for (int i = 0; i < columna; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                T.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
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

        jLabel2 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TCustomer = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CID = new javax.swing.JTextField();
        PID = new javax.swing.JTextField();
        SID = new javax.swing.JTextField();
        TID = new javax.swing.JTextField();
        AN = new javax.swing.JTextField();
        R = new javax.swing.JTextField();
        MD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        MSOH = new javax.swing.JMenuItem();
        SOP = new javax.swing.JMenuItem();
        SOD = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenu();
        MGuardar = new javax.swing.JMenuItem();
        Modificar = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        sesion = new javax.swing.JMenuItem();

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel2.setText("Customer");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer");

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel1.setText("Datos");

        TCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustomerID", "PersonID", "StoreID", "TerritoryID", "AccountNumber", "rowguid", "ModifiedDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TCustomer.setAutoResizeMode(0);
        TCustomer.setAutoscrolls(false);
        TCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TCustomer);
        if (TCustomer.getColumnModel().getColumnCount() > 0) {
            TCustomer.getColumnModel().getColumn(0).setHeaderValue("CustomerID");
            TCustomer.getColumnModel().getColumn(1).setHeaderValue("PersonID");
            TCustomer.getColumnModel().getColumn(2).setHeaderValue("StoreID");
            TCustomer.getColumnModel().getColumn(3).setHeaderValue("TerritoryID");
            TCustomer.getColumnModel().getColumn(4).setHeaderValue("AccountNumber");
            TCustomer.getColumnModel().getColumn(5).setHeaderValue("rowguid");
            TCustomer.getColumnModel().getColumn(6).setHeaderValue("ModifiedDate");
        }

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("CustomerID");

        jLabel5.setText("PersonID");

        jLabel6.setText("StoreID");

        jLabel7.setText("TerritoryID");

        jLabel8.setText("AccountNumber");

        jLabel9.setText("rowguid");

        jLabel10.setText("ModifiedDate");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(R, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel3.setText("Customer");

        jMenu3.setText("Tabla");

        MSOH.setText("SalesOrderHeader");
        MSOH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MSOHMouseClicked(evt);
            }
        });
        MSOH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSOHActionPerformed(evt);
            }
        });
        jMenu3.add(MSOH);

        SOP.setText("SalesOffterProduct");
        SOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SOPActionPerformed(evt);
            }
        });
        jMenu3.add(SOP);

        SOD.setText("SalesOrderDetail");
        SOD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SODActionPerformed(evt);
            }
        });
        jMenu3.add(SOD);

        jMenuBar1.add(jMenu3);

        Guardar.setText("Archivo");

        MGuardar.setText("Guardar");
        MGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MGuardarActionPerformed(evt);
            }
        });
        Guardar.add(MGuardar);

        Modificar.setText("Modificar");
        Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarMouseClicked(evt);
            }
        });
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        Guardar.add(Modificar);

        jMenuBar1.add(Guardar);

        jMenu6.setText("Sesión");

        sesion.setText("Cerrar");
        sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sesionActionPerformed(evt);
            }
        });
        jMenu6.add(sesion);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TCustomerMouseClicked
        // TODO add your handling code here:
        int selec = TCustomer.rowAtPoint(evt.getPoint());
        int fila = TCustomer.getSelectedRow();
        int ID = Integer.parseInt(TCustomer.getValueAt(fila, 0).toString());
        
        try {
            Connection con = Conector.getConexion();
            PreparedStatement ps;
            ResultSet rs;
            String consulta = "SELECT * FROM Sales.Customer where CustomerID = ?";
            ps = con.prepareStatement(consulta);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                CID.setText(TCustomer.getValueAt(selec, 0) + "");
                PID.setText(TCustomer.getValueAt(selec, 1) + "");
                SID.setText(TCustomer.getValueAt(selec, 2) + "");
                TID.setText(TCustomer.getValueAt(selec, 3) + "");
                AN.setText(TCustomer.getValueAt(selec, 4) + "");
                R.setText(TCustomer.getValueAt(selec, 5) + "");
                MD.setText(TCustomer.getValueAt(selec, 6) + "");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error X_x");

        }

    }//GEN-LAST:event_TCustomerMouseClicked

    private void MGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MGuardarActionPerformed
        // TODO add your handling code here:

        int cid, pid, sid, tid;
        String an, ro;
        Timestamp md;

        cid = Integer.parseInt(CID.getText());
        pid = Integer.parseInt(PID.getText());
        sid = Integer.parseInt(SID.getText());
        tid = Integer.parseInt(TID.getText());
        an = AN.getText();
        ro = R.getText();
        md = Timestamp.valueOf(MD.getText());

        try {
            Connection con = Conector.getConexion();
            String consulta = "INSERT INTO Sales.Customer(CustomerID,PersonID,StoreID,TerritoryID,"
                    + "AccountNumber,rowguid,ModifiedDate) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(consulta);

            ps.setInt(1, cid);
            ps.setInt(2, pid);
            ps.setInt(3, sid);
            ps.setInt(4, tid);
            ps.setString(5, an);
            ps.setString(6, ro);
            ps.setTimestamp(7, md);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado UwU");
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error al Guardar X_x");

        }


    }//GEN-LAST:event_MGuardarActionPerformed

    private void MSOHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSOHActionPerformed
        // TODO add your handling code here:
        SalesOrderHeader soh = new SalesOrderHeader();
        soh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MSOHActionPerformed

    private void MSOHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MSOHMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_MSOHMouseClicked

    private void SOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SOPActionPerformed
        // TODO add your handling code here:
        SpecialOfferProduct sop = new SpecialOfferProduct();
        sop.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SOPActionPerformed

    private void SODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SODActionPerformed
        // TODO add your handling code here:
        SalesOrderDetail sod = new SalesOrderDetail();
        sod.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SODActionPerformed

    private void sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sesionActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Hasta Luego UuU");
        Menu M = new Menu();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_sesionActionPerformed

    private void ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_ModificarMouseClicked

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
        int cid = Integer.parseInt(CID.getText());
        int pid = Integer.parseInt(PID.getText());
        int sid = Integer.parseInt(SID.getText());
        int tid = Integer.parseInt(TID.getText());
        String an = AN.getText();
        String r = R.getText();
        Timestamp t = Timestamp.valueOf(MD.getText());
        try {
            Connection con = Conector.getConexion();
            String consulta = "UPDATE sales.customer SET  "
                    + "CustomerID=?, PersonID=?,StoreID=?,"
                    + "TerritoryID=?,AccountNumber=?,"
                    + "rowguid=?, ModifiedDate=?";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, cid);
            ps.setInt(2, pid);
            ps.setInt(3, sid);
            ps.setInt(4, tid);
            ps.setString(5, an);
            ps.setString(6, r);
            ps.setTimestamp(7, t);
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Registro Modificado");
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Tenemos problemas al modificar");
        }


    }//GEN-LAST:event_ModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AN;
    private javax.swing.JTextField CID;
    private javax.swing.JMenu Guardar;
    private javax.swing.JTextField MD;
    private javax.swing.JMenuItem MGuardar;
    private javax.swing.JMenuItem MSOH;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JTextField PID;
    private javax.swing.JTextField R;
    private javax.swing.JTextField SID;
    private javax.swing.JMenuItem SOD;
    private javax.swing.JMenuItem SOP;
    private javax.swing.JTable TCustomer;
    private javax.swing.JTextField TID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem sesion;
    // End of variables declaration//GEN-END:variables
}