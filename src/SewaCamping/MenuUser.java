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
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import static SewaCamping.Menu.ID;

/**
 *
 * @author Lenovo - GK
 */
public class MenuUser extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private Connection con;
    private Statement stat;
    private ResultSet res;

    public static int ID;

    public MenuUser() {
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
        btnpesan = new javax.swing.JButton();
        MenuBarAdmin = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
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

        btnpesan.setText("Pesan");
        btnpesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesanActionPerformed(evt);
            }
        });

        jMenu6.setText("History Order");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        MenuBarAdmin.add(jMenu6);

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
                .addContainerGap()
                .addComponent(btnpesan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesan))
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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int baris = table.getSelectedRow();
        ID = (int) table.getValueAt(baris, 0);
        System.out.println(ID);
    }//GEN-LAST:event_tableMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void btnpesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesanActionPerformed
        // TODO add your handling code here:
        if (ID != 0) {
            int id_user, id_alat;
            id_user = Login.IDU;
            id_alat = ID;
            String tanggal = LocalDate.now().toString();

            int response = JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin Ingin Menyewa Alat Dengan ID " + id_alat, "Konfirmasi", JOptionPane.YES_NO_OPTION);
            switch (response) {
                case JOptionPane.YES_OPTION:
                    try {
                        Connection conn = koneksi.getConnection();
                        String sql = "INSERT INTO tborder VALUES (NULL,?,?,?)";
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, id_alat);
                        stmt.setInt(2, id_user);
                        stmt.setString(3, tanggal);

                        int rowAffected = stmt.executeUpdate();
                        if (rowAffected > 0) {
                            ID = 0;
                            JOptionPane.showMessageDialog(this, "Berhasil Menyewa Alat!", "SQL Information", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "Harap Pilih Alat Terlebih Dahulu");
        }
    }//GEN-LAST:event_btnpesanActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        Historyorder HO = new Historyorder();
        HO.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu6MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBarAdmin;
    private javax.swing.JButton btnpesan;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
