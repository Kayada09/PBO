/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SewaCamping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo - GK
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private Connection con;
    private Statement stat;
    private ResultSet res;

    public static int ID;

    public Menu() {
        initComponents();
        koneksi();
        
        tabel();
    }

    public void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_alatcamping", "root", "");
            stat = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void tabel() {
        koneksi();
        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.setRowCount(0);

        try {
            String sql = "select * from alat";
            res = stat.executeQuery(sql);
            while (res.next()) {
                tb.addRow(new Object[]{
                    res.getInt("id_alat"),
                    res.getString("nama"),
                    res.getString("jenis"),
                    res.getInt("harga"),
                    res.getString("deskripsi")
                });
            }
            res.close();
            stat.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    private void tabel(String search) {
        koneksi();
        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.setRowCount(0);

        try {
            String sql = "select * from alat WHERE nama LIKE '%" + search + "%' OR jenis LIKE '%" + search + "%'";
            res = stat.executeQuery(sql);
            while (res.next()) {
                tb.addRow(new Object[]{
                    res.getInt("id_alat"),
                    res.getString("nama"),
                    res.getString("jenis"),
                    res.getInt("harga"),
                    res.getString("deskripsi")
                });
            }
            res.close();
            stat.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
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
        table = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        MenuBarAdmin = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Alat", "Nama Alat", "Jenis Alat", "Harga", "Deskripsi"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jMenu1.setText("Manajemen Data");

        jMenu3.setText("Tambah Data");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu3);

        jMenu4.setText("Ubah Data");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu4);

        jMenu5.setText("Hapus Data");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu5);

        MenuBarAdmin.add(jMenu1);

        jMenu2.setText("Logout");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        MenuBarAdmin.add(jMenu2);

        setJMenuBar(MenuBarAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 67, Short.MAX_VALUE)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        String cari = txtsearch.getText();
        tabel(cari);
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        AddAlat AP = new AddAlat();
        AP.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int baris = table.getSelectedRow();
        ID = (int) table.getValueAt(baris, 0);
        System.out.println(ID);
    }//GEN-LAST:event_tableMouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        if (ID != 0) {
            int response = JOptionPane.showConfirmDialog(this, "Apakah Ingin Menghapus Parfum Dengan ID " + ID, "Konfirmasi", JOptionPane.YES_NO_OPTION);

            switch (response) {
                case JOptionPane.YES_OPTION:
                    try {
                        Connection conn = koneksi.getConnection();
                        String sql = "DELETE FROM alat WHERE id_alat = ?";
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, ID);

                        int rowAffected = stmt.executeUpdate();
                        if (rowAffected > 0) {
                            ID = 0;
                            JOptionPane.showMessageDialog(this, "Berhasil Menghapus Alat!", "SQL Information", JOptionPane.INFORMATION_MESSAGE);
                            stmt.close();
                            tabel();
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Harap Pilih Data Terlebih Dahulu!");
        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        EditAlat EP = new EditAlat();
        EP.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBarAdmin;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
