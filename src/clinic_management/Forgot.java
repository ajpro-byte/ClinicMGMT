/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic_management;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import com.sun.speech.freetts.*;
/**
 *
 * @author MIS.Hardware
 */
public class Forgot extends javax.swing.JFrame {
Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Creates new form Forgot
     */
    public Forgot() {
        initComponents();
               //  conn = (Connection) MysqlConnection.ConnectDB();
               conn = (Connection) clinic_management.MysqlConnection.ConnectDB();
         Info.setVisible(true);
                security.setVisible(false);
                newpass.setVisible(false);
                refresh_admin();
                 seticon();
    }
    
    public void refresh_admin() {
        try {
            //DateAdded,Supplier,ProductID,Description,Category,Quantity,Value,Price,Sale
            String sql = "SELECT AccountID,Name FROM tbl_admin";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            tbl_list.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
     
     
     public void refresh_user() {
        try {
            //DateAdded,Supplier,ProductID,Description,Category,Quantity,Value,Price,Sale
            String sql = "SELECT AccountID,Name FROM tbl_user";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            tbl_list.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private static final String VOICENAME="kevin16";
    Voice voice;
     VoiceManager vm = VoiceManager.getInstance();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        Info3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        AccName3 = new javax.swing.JTextField();
        AccID3 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_list3 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        select3 = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        security = new javax.swing.JPanel();
        key = new javax.swing.JLabel();
        contact17 = new javax.swing.JLabel();
        nq1 = new javax.swing.JLabel();
        contact20 = new javax.swing.JLabel();
        contact19 = new javax.swing.JLabel();
        na1 = new javax.swing.JTextField();
        contact14 = new javax.swing.JLabel();
        nq2 = new javax.swing.JLabel();
        na2 = new javax.swing.JTextField();
        contact21 = new javax.swing.JLabel();
        nq3 = new javax.swing.JLabel();
        na3 = new javax.swing.JTextField();
        contact23 = new javax.swing.JLabel();
        contact24 = new javax.swing.JLabel();
        contact13 = new javax.swing.JLabel();
        contact16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        newpass = new javax.swing.JPanel();
        uname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        repeatepass = new javax.swing.JPasswordField();
        newpass1 = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        jPanel7.setLayout(new java.awt.CardLayout());

        Info3.setBackground(new java.awt.Color(255, 255, 255));
        Info3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 97, 139)));
        Info3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("X");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        Info3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, 40));

        AccName3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AccName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccName3ActionPerformed(evt);
            }
        });
        Info3.add(AccName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 290, 40));

        AccID3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Info3.add(AccID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 290, 40));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbl_list3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbl_list3.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_list3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_list3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_list3);

        Info3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 220, 390));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Account Name:");
        Info3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("AccountID:");
        Info3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Next");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Info3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 90, 30));

        select3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        select3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User" }));
        select3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                select3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        Info3.add(select3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 30));

        jPanel8.setBackground(new java.awt.Color(2, 97, 139));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("FORGOT PASSWORD");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel16)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        Info3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 360, 30));

        jPanel7.add(Info3, "card2");

        security.setBackground(new java.awt.Color(255, 255, 255));
        security.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 97, 139)));
        security.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        key.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        key.setForeground(new java.awt.Color(0, 51, 102));
        key.setText("Account Security");
        security.add(key, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        contact17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact17.setForeground(new java.awt.Color(102, 102, 102));
        contact17.setText("Personal Verification Question 1");
        security.add(contact17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 20));

        nq1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nq1.setText("Question");
        security.add(nq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, 20));

        contact20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact20.setText("Question:");
        security.add(contact20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 20));

        contact19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact19.setText("Answere:");
        security.add(contact19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 20));

        na1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        security.add(na1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 400, -1));

        contact14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact14.setForeground(new java.awt.Color(102, 102, 102));
        contact14.setText("Personal Verification Question 2");
        security.add(contact14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, 20));

        nq2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nq2.setText("Question");
        security.add(nq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, 20));

        na2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        security.add(na2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 400, -1));

        contact21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact21.setForeground(new java.awt.Color(102, 102, 102));
        contact21.setText("Personal Verification Question 3");
        security.add(contact21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, 20));

        nq3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nq3.setText("Question");
        security.add(nq3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, 20));

        na3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        security.add(na3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 400, -1));

        contact23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact23.setText("Answere:");
        security.add(contact23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 20));

        contact24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact24.setText("Question:");
        security.add(contact24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, 20));

        contact13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact13.setText("Answere:");
        security.add(contact13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 20));

        contact16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact16.setText("Question:");
        security.add(contact16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 20));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Next");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        security.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 90, 30));

        jLabel17.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("X");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        security.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, 40));

        jPanel7.add(security, "card3");

        newpass.setBackground(new java.awt.Color(255, 255, 255));
        newpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 97, 139)));
        newpass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newpass.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 360, 40));

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel18.setText("Repeate Password");
        newpass.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel19.setText("Username");
        newpass.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel20.setText("New Password");
        newpass.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        repeatepass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newpass.add(repeatepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 360, 40));

        newpass1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newpass.add(newpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 360, 40));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        newpass.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 140, 30));

        jLabel21.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("X");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        newpass.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, 40));

        jPanel7.add(newpass, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void AccName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccName3ActionPerformed

    private void tbl_list3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_list3MouseClicked
        // TODO add your handling code here:
        int z = tbl_list.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl_list.getModel();
        AccID.setText(model.getValueAt(z, 0).toString());
        AccName.setText(model.getValueAt(z, 1).toString());
    }//GEN-LAST:event_tbl_list3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        try{
            String sql = "SELECT * FROM tbl_admin where AccountID =? and Name=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, AccID.getText());
            pst.setString(2, AccName.getText());

            rs = pst.executeQuery();
            if (rs.next()) {

                pst = (PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_admin WHERE AccountID= '" + AccID.getText() + "' and Name= '" + AccName.getText() + "' ");
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString("Q1");
                    String add2 = rs.getString("Q2");
                    String add3 = rs.getString("Q3");
                    nq1.setText(add1);
                    nq2.setText(add2);
                    nq3.setText(add3);

                }
                Info.setVisible(false);
                security.setVisible(true);
                newpass.setVisible(false);
                key.setText("Admin Account Security");
            }else{

                String sql1 = "SELECT * FROM tbl_user where AccountID =? and Name=?";
                pst = (PreparedStatement) conn.prepareStatement(sql1);
                pst.setString(1, AccID.getText());
                pst.setString(2, AccName.getText());

                rs = pst.executeQuery();
                if (rs.next()) {

                    pst = (PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_user WHERE AccountID= '" + AccID.getText() + "' and Name= '" + AccName.getText() + "' ");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Q1");
                        String add2 = rs.getString("Q2");
                        String add3 = rs.getString("Q3");
                        nq1.setText(add1);
                        nq2.setText(add2);
                        nq3.setText(add3);

                    }
                    Info.setVisible(false);
                    security.setVisible(true);
                    newpass.setVisible(false);
                    key.setText("User Account Security");
                }else{
                    //voice.speak("Account ID/Name not exist on the database please check from table!!!");
                    JOptionPane.showMessageDialog(null, "Account ID/Name not exist on the database!!!");
                }
            }
        }catch(SQLException x) {
            JOptionPane.showMessageDialog(null, x);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void select3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_select3PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (select.getSelectedItem().equals("Admin")){
            refresh_admin();
        }else{
            refresh_user();
        }
    }//GEN-LAST:event_select3PopupMenuWillBecomeInvisible

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        if (key.getText().equals("Admin Account Security")){
            try{
                String sql = "SELECT * FROM tbl_admin where AccountID =? and Q1=? and A1=?";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1, AccID.getText());
                pst.setString(2, nq1.getText());
                pst.setString(3, na1.getText());

                rs = pst.executeQuery();
                if (rs.next()) {
                    //q1
                    String sq2 = "SELECT * FROM tbl_admin where AccountID =? and Q2=? and A2=?";
                    pst = (PreparedStatement) conn.prepareStatement(sq2);
                    pst.setString(1, AccID.getText());
                    pst.setString(2, nq2.getText());
                    pst.setString(3, na2.getText());

                    rs = pst.executeQuery();
                    if (rs.next()) {
                        //q2
                        String sq3 = "SELECT * FROM tbl_admin where AccountID =? and Q3=? and A3=?";
                        pst = (PreparedStatement) conn.prepareStatement(sq3);
                        pst.setString(1, AccID.getText());
                        pst.setString(2, nq3.getText());
                        pst.setString(3, na3.getText());

                        rs = pst.executeQuery();
                        if (rs.next()) {
                            Info.setVisible(false);
                            security.setVisible(false);
                            newpass.setVisible(true);
                        }else{
                            //voice.speak("Incorrect Answere Question number 3!!");
                            JOptionPane.showMessageDialog(null, "Incorrect Answere Question number 3!!");
                        }

                    }else{
                        //voice.speak("Incorrect Answere Question number 2!!");
                        JOptionPane.showMessageDialog(null, "Incorrect Answere Question number 2!!");
                    }

                }else{
                    //voice.speak("Incorrect Answere Question number 1!!");
                    JOptionPane.showMessageDialog(null, "Incorrect Answere Question number 1!!");
                }
            }catch(SQLException x) {
                JOptionPane.showMessageDialog(null, x);
            }
        }else{
            try{
                String sql = "SELECT * FROM tbl_user where AccountID =? and Q1=? and A1=?";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1, AccID.getText());
                pst.setString(2, nq1.getText());
                pst.setString(3, na1.getText());

                rs = pst.executeQuery();
                if (rs.next()) {
                    //q1
                    String sq2 = "SELECT * FROM tbl_user where AccountID =? and Q2=? and A2=?";
                    pst = (PreparedStatement) conn.prepareStatement(sq2);
                    pst.setString(1, AccID.getText());
                    pst.setString(2, nq2.getText());
                    pst.setString(3, na2.getText());

                    rs = pst.executeQuery();
                    if (rs.next()) {
                        //q2
                        String sq3 = "SELECT * FROM tbl_user where AccountID =? and Q3=? and A3=?";
                        pst = (PreparedStatement) conn.prepareStatement(sq3);
                        pst.setString(1, AccID.getText());
                        pst.setString(2, nq3.getText());
                        pst.setString(3, na3.getText());

                        rs = pst.executeQuery();
                        if (rs.next()) {
                            Info.setVisible(false);
                            security.setVisible(false);
                            newpass.setVisible(true);
                        }else{
                            // voice.speak("Incorrect Answere Question number 3!!");
                            JOptionPane.showMessageDialog(null, "Incorrect Answere Question number 3!!");
                        }

                    }else{
                        // voice.speak("Incorrect Answere Question number 2!!");
                        JOptionPane.showMessageDialog(null, "Incorrect Answere Question number 2!!");
                    }

                }else{
                    //voice.speak("Incorrect Answere Question number 1!!");
                    JOptionPane.showMessageDialog(null, "Incorrect Answere Question number 1!!");
                }
            }catch(SQLException x) {
                JOptionPane.showMessageDialog(null, x);
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        if(newpass1.getText().equals(repeatepass.getText())){
            try{
                String sql = "SELECT * FROM tbl_admin where AccountID =? and Name=? and Username =?";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1, AccID.getText());
                pst.setString(2, AccName.getText());
                pst.setString(3, uname.getText());

                rs = pst.executeQuery();
                if (rs.next()) {

                    pst=(com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_admin SET Password=? WHERE Username='"+uname.getText()+"' and AccountID='"+AccID.getText()+"'  and Name='"+AccName.getText()+"'");

                    pst.setString(1,newpass1.getText());

                    int admin_update = pst.executeUpdate();

                    if (admin_update!=0){
                        try{
                            jButton3.setText("Saving...");
                            Thread.sleep(40);
                            // voice.speak("Admin Account New Password Saved Successfully");
                            JOptionPane.showMessageDialog(null, "Admin Account New Password Saved");
                            this.dispose();
                        }catch(Exception x){
                            JOptionPane.showMessageDialog(null, x);
                        }
                    }

                }else{

                    String sq2 = "SELECT * FROM tbl_user where AccountID =? and Name=? and Username =?";
                    pst = (PreparedStatement) conn.prepareStatement(sq2);
                    pst.setString(1, AccID.getText());
                    pst.setString(2, AccName.getText());
                    pst.setString(3, uname.getText());

                    rs = pst.executeQuery();
                    if (rs.next()) {

                        pst=(com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_user SET Password=? WHERE Username='"+uname.getText()+"' and AccountID='"+AccID.getText()+"'  and Name='"+AccName.getText()+"'");

                        pst.setString(1,newpass1.getText());

                        int admin_update1 = pst.executeUpdate();

                        if (admin_update1!=0){
                            try{
                                jButton3.setText("Saving...");
                                Thread.sleep(40);
                                // voice.speak("User Account New Password Saved Successfully");
                                JOptionPane.showMessageDialog(null, "User Account New Password Saved");
                                this.dispose();

                            }catch(Exception x){
                                JOptionPane.showMessageDialog(null, x);
                            }
                        }

                    }else{
                        //voice.speak("Inccorect Username Please Check!");
                        JOptionPane.showMessageDialog(null, "Inccorect Username!");

                    }

                }
            }catch(SQLException x) {
                JOptionPane.showMessageDialog(null, x);
            }
        }else{
            //voice.speak("Inccorect Password Match Please Check!");
            JOptionPane.showMessageDialog(null, "Inccorect Password Match!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

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
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forgot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccID;
    private javax.swing.JTextField AccID1;
    private javax.swing.JTextField AccID2;
    private javax.swing.JTextField AccID3;
    private javax.swing.JTextField AccName;
    private javax.swing.JTextField AccName1;
    private javax.swing.JTextField AccName2;
    private javax.swing.JTextField AccName3;
    private javax.swing.JPanel Info;
    private javax.swing.JPanel Info1;
    private javax.swing.JPanel Info2;
    private javax.swing.JPanel Info3;
    private javax.swing.JLabel contact13;
    private javax.swing.JLabel contact14;
    private javax.swing.JLabel contact16;
    private javax.swing.JLabel contact17;
    private javax.swing.JLabel contact19;
    private javax.swing.JLabel contact20;
    private javax.swing.JLabel contact21;
    private javax.swing.JLabel contact23;
    private javax.swing.JLabel contact24;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel key;
    private javax.swing.JTextField na1;
    private javax.swing.JTextField na2;
    private javax.swing.JTextField na3;
    private javax.swing.JPanel newpass;
    private javax.swing.JPasswordField newpass1;
    private javax.swing.JLabel nq1;
    private javax.swing.JLabel nq2;
    private javax.swing.JLabel nq3;
    private javax.swing.JPasswordField repeatepass;
    private javax.swing.JPanel security;
    private javax.swing.JComboBox select;
    private javax.swing.JComboBox select1;
    private javax.swing.JComboBox select2;
    private javax.swing.JComboBox select3;
    private javax.swing.JTable tbl_list;
    private javax.swing.JTable tbl_list1;
    private javax.swing.JTable tbl_list2;
    private javax.swing.JTable tbl_list3;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
private void seticon() {
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Clinic.png")));
    }
}
