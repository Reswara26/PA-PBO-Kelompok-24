/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import db_connector.db_connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Frame: Login.java
 * Fungsi: Autentikasi pengguna admin/kontraktor secara case-sensitive
 * @author hp
 */
public class Login extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    // ✅ Konstruktor utama
    public Login() {
        initComponents();

        // ✅ Event tombol "LOG IN"
        jButton1.addActionListener(e -> {
            String username = jTextField1.getText().trim();
            String password = new String(jPasswordField1.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username dan Password harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try (Connection conn = db_connection.getConnection()) {
                // ✅ Pakai BINARY agar case-sensitive
                String query = """
                    SELECT p.*, 
                           CASE 
                               WHEN a.id_pengguna IS NOT NULL THEN 'admin' 
                               WHEN k.id_pengguna IS NOT NULL THEN 'kontraktor'
                               ELSE 'unknown'
                           END AS role
                    FROM pengguna p
                    LEFT JOIN admin a ON p.id_pengguna = a.id_pengguna
                    LEFT JOIN kontraktor k ON p.id_pengguna = k.id_pengguna
                    WHERE BINARY p.username=? AND BINARY p.password=?;
                """;

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("role");
                    System.out.println("DEBUG: Role terdeteksi = " + role);

                    switch (role.toLowerCase()) {
                        case "admin" -> {
                            JOptionPane.showMessageDialog(this, "Login berhasil sebagai ADMIN!");
                            SwingUtilities.invokeLater(() -> {
                                try {
                                    Menu_Admin adminFrame = new Menu_Admin(username);
                                    adminFrame.setLocationRelativeTo(null);
                                    adminFrame.setAlwaysOnTop(true);
                                    adminFrame.setVisible(true);
                                    System.out.println("DEBUG: Frame Menu_Admin ditampilkan");
                                    this.dispose();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(this, "Gagal membuka Menu_Admin:\n" + ex.getMessage());
                                }
                            });
                        }
                        case "kontraktor" -> {
                            JOptionPane.showMessageDialog(this, "Login berhasil sebagai KONTRAKTOR!");
                            SwingUtilities.invokeLater(() -> {
                                try {
                                    Menu_Kontraktor kontraktorFrame = new Menu_Kontraktor(username);
                                    kontraktorFrame.setLocationRelativeTo(null);
                                    kontraktorFrame.setAlwaysOnTop(true);
                                    kontraktorFrame.setVisible(true);
                                    System.out.println("DEBUG: Frame Menu_Kontraktor ditampilkan");
                                    this.dispose();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(this, "Gagal membuka Menu_Kontraktor:\n" + ex.getMessage());
                                }
                            });
                        }
                        default -> JOptionPane.showMessageDialog(this, "Role tidak dikenali.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau Password salah!", "Login Gagal", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo (4).png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 250, 140));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jLabel4.setText("Log In Sebagai Kontraktor/Admin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 300, 40));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 130, 30));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 130, 30));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOG IN");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 230, 40));

        jPasswordField1.setBackground(new java.awt.Color(255, 102, 0));
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 310, 40));

        jTextField1.setBackground(new java.awt.Color(255, 102, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 310, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login Page.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 801, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
