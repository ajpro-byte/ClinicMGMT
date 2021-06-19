/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic_management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;
import javax.swing.table.*;
import com.teknikindustries.bulksms.SMS;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.URI;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


/**
 *
 * @author MIS.Hardware
 */
public class Main_Frame extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public Main_Frame() {
        initComponents();
        conn = clinic_management.MysqlConnection.ConnectDB();
        CurrentDate();
        refresh_list();
        seticon();
        refresh_dapp();
    }

    public void hide_panel() {
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        
    }

 
    
    public void CurrentDate() {

        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("h:mm aa");
                s_time.setText(s.format(d));

                SimpleDateFormat st = new SimpleDateFormat("MMM-dd-yyyy");
               // SimpleDateFormat st1 = new SimpleDateFormat("MMM");
                s_date.setText(st.format(d));
               // jLabel21.setText(st1.format(d));
                //String today = st.format(d);
            
            }
        }).start();

    }
    
    public void refresh_dashapplist(){
     
//            try{
//             String sql = "SELECT Member, Fullname, Time FROM tbl_appointment_removed WHERE Date like ?";
//            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
//            pst.setString(1, "%" +jLabel21.getText()+ "%");
//            rs = (ResultSet) pst.executeQuery();
//            tbl_dash.setModel(DbUtils.resultSetToTableModel(rs));
//} catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
            
            try{
             String sql1 = "SELECT Date, Time, Remarks From tbl_availabilty WHERE Date='"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            tbl_dsclist.setModel(DbUtils.resultSetToTableModel(rs));
            
} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void refresh_dapp() {
         refresh_dashapplist();
       
            try{
             String sql = "SELECT Member, Fullname, Time FROM tbl_appointment WHERE Date like ?";
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "%" + s_date.getText()+ "%");
            rs = (ResultSet) pst.executeQuery();
            tbl_dash.setModel(DbUtils.resultSetToTableModel(rs));
} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
            int row = tbl_dash.getRowCount();
        dtoserve.setText(String.valueOf(row));
        
            try{
            String sql1 = "SELECT Member, Fullname From tbl_appointment WHERE Status='"+"Rescheduled"+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            tbl_rdasg.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
             int row2 = tbl_rdasg.getRowCount();
            dresched.setText(String.valueOf(row2));
            
//            String sql1 = "SELECT  Time FROM tbl_appointment WHERE Status like ?";
//            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql1);
//            pst.setString(1, "%" + "Rescheduled"+ "%");
//            rs = (ResultSet) pst.executeQuery();
//            tbl_rdasg.setModel(DbUtils.resultSetToTableModel(rs)); && Date = '"+s_date.getText()+"'
            try{
            String sqli = "SELECT Member, Fullname, Time,Date, ActStat From tbl_appointment_removed WHERE ActStat = '"+"Served"+"' && Date = '"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sqli);
            rs = pst.executeQuery();
            tbl_rm_serve.setModel(DbUtils.resultSetToTableModel(rs));
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
           
        int row3 = tbl_rm_serve.getRowCount();
        dreserved.setText(String.valueOf(row3));    
    
        
        
     
    
   
    
   
        //d_prd.setText(String.valueOf(row));
    
    }
    
     public void refresh_csalist() {
         
        try {
            
            String sql = "SELECT * From tbl_clientinfo";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //tbl_client_list.setModel(DbUtils.resultSetToTableModel(rs));
             astable.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
    
    public void refresh_list() {
         
        try {
            
            String sql = "SELECT * From tbl_clientinfo";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tbl_client_list.setModel(DbUtils.resultSetToTableModel(rs));
            // astable.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
    public void sentsms(){
    
        try{
             pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_clientinfo WHERE ClientID = '" + said.getText() + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                String Contact = rs.getString("Cell");
                 pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_smsacct WHERE Name = '" + sasms.getSelectedItem() + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                //String Name = rs.getString("Name");
                String user = rs.getString("Username");
                String pass = rs.getString("Password");
       SMS send = new SMS();
       send.SendSMS(user, pass, samessage.getText(), Contact, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");     
       
       JOptionPane.showMessageDialog(null,"Message Sent to "+Contact);
            }else {
            
            JOptionPane.showMessageDialog(null,"Error Sending message");
            }
            }
            }catch(Exception e){JOptionPane.showMessageDialog(null,"Error Sending message");}
    
    }
    public void refresh_sms() {
         
        try {
            
            String sql = "SELECT * From tbl_smsacct";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tbl_sms.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
    
    public void refresh_Availabilty() {
         
        try {
            
            String sql = "SELECT * From tbl_availabilty";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Atable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
    
    public void refresh_Availabilty_app() {
         
        try {
            
            String sql = "SELECT * From tbl_availabilty";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            satable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
    
//    public void refresh_sched() {
//        
//        if (satit.getText().equals("")){
//         if (sasellsched.getSelectedItem().equals("Show rescheduled only")){
//         try {
//            
//            String sql = "SELECT * From tbl_appointment where Status like '"+"Rescheduled"+"'";
//            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            satable.setModel(DbUtils.resultSetToTableModel(rs));
//            
//           
//            //satit.setText("Client Schedule");
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//         }else{
//         
//             try {
//            
//            String sql = "SELECT * From tbl_appointment where Status like '"+"Scheduled"+"'";
//            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            satable.setModel(DbUtils.resultSetToTableModel(rs));
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//             
//         }
//        
//     }}
    
    public void sa_refresh_list() {
         
        try {
            
            String sql = "SELECT * From tbl_clientinfo";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            satable.setModel(DbUtils.resultSetToTableModel(rs));
            //astable.setModel(DbUtils.resultSetToTableModel(rs));
            satit.setText("Client List");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
    
    
    
     public void refresh_appointment() {
         
        try {
            
            String sql = "SELECT * From tbl_appointment";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            satable.setModel(DbUtils.resultSetToTableModel(rs));
            //astable.setModel(DbUtils.resultSetToTableModel(rs));
            satit.setText("Appointment Schedule");
            sarem.setText("Show Removed");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
     
     public void refresh_appointment_service() {
         
        try {
            
            String sql = "SELECT * From tbl_appointment";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            astable.setModel(DbUtils.resultSetToTableModel(rs));
            //astable.setModel(DbUtils.resultSetToTableModel(rs));
            satit.setText("Appointment Schedule");
            sarem.setText("Show Removed");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
     
     public void refresh_rem() {
         
        try {
            
            String sql = "SELECT * From tbl_appointment_removed";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            satable.setModel(DbUtils.resultSetToTableModel(rs));
            satit.setText("Appointment Schedule Removed");
            sarem.setText("Show App List");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
     
     public void Refresh_Asched() {
         
        try {
            
            String sql = "SELECT * From tbl_appointment";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            actable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
     
     public void clear_sms(){
     smsname.setText("");
     smsuser.setText("");
     smspass.setText("");
     smsid.setText("[Click to Generate ID]");
     btnsms.setText("Save");
     }
     public void clear_avail(){
     AID1.setText("[Click to Generate Number]");
     ADate.setDate(null);
     Atime.setSelectedItem("7:00 AM");
     Aremarks.setText("");
     }
     
     public void clear_serv(){
     asid.setText("");
     asname.setText("");
     asdate.setText("");
     asaddress.setText("");
     assex.setText("");
     asmarital.setText("");
     asblod.setText("");
     asa.setSelectedItem("Negative");
     asb.setSelectedItem("Negative");
     asc.setSelectedItem("Negative");
     asd.setText("");
     ase.setSelectedItem("Negative");
     asf.setSelectedItem("Negative");
     asg.setSelectedItem("Negative");
     ash.setSelectedItem("Negative");
    
     asseal.setText("");
     }
     
     public void clear_app(){
     said.setText(null);
     saname.setText(null);
     samem.setText(null);
     sadate.setText(null);
     satime1.setText(null);
     samessage.setText(null);
     btngrpapp.setSelected(false);
     jCheckBox3.setSelected(false);
     btngrpapp2.setSelected(false);
     saclietsell.setSelected(false);
     }
    
    public void clear_client(){
                        CID.setText("[Click to Generate ID]");
                        CLast.setText("Lasname");
                        CMiddle.setText("Middlename");
                        CFirst.setText("Fisrtname");
                        CStreet.setText("");
                        CCity.setText("");
                        CState.setText("");
                        CZip.setText("");
                        CEmail.setText("");
                        //CBMedical.setSelectedItem(null);
                        //CMarital.setSelectedItem(null);
                        CPHome.setText("");
                        CPWork.setText("");
                        CPCell.setText("");
                        CSHome.setText("");
                        CSWork.setText("");
                        CSCell.setText("");
                        CEMName.setText("");
                        CEMContact.setText("");
                        CRefer.setText("");
                        //CBMedical.setSelectedItem(null);
                        CIFyes.setText("");
                        CConditions.setText("");
        }
    public void refresh_smslist(){
        sasms.removeAllItems();
     try{
        String sql="SELECT Name FROM tbl_smsacct";
        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
        
         
        String name =rs.getString("Name");
        sasms.addItem(name);
        // AutoCompleteDecorator.decorate(sasms);
        }
        }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    } 
    }
    
    public void clear_receipt(){
        jLabel1.setText("Update");
    ra.setText("0.00");
        rb.setText("0.00");
        rc.setText("0.00");
        rd.setText("0.00");
        re.setText("0.00");
        rf.setText("0.00");
        rg.setText("0.00");
        rh.setText("0.00");
        ri.setText("0.00");
        ri.setEnabled(false);
        rtotal.setText("0.00");
        ra.setEnabled(false);
        rb.setEnabled(false);
        rc.setEnabled(false);
        rd.setEnabled(false);
        re.setEnabled(false);
        rf.setEnabled(false);
        rg.setEnabled(false);
        rh.setEnabled(false);
        
        sra.setSelected(false);
        srb.setSelected(false);
        src.setSelected(false);
        srd.setSelected(false);
        sre.setSelected(false);
        srf.setSelected(false);
        srg.setSelected(false);
        srh.setSelected(false);
        sri.setSelected(false);
    
    }
    
    public void changepass_clear() {
        cuname.setText("");
        ccpass.setText("");
        cnpass.setText("");
        crpass.setText("");
    }
   

    public void clear_ans() {
        na1.setText("");
        na2.setText("");
        na3.setText("");
    }

    public void user_clear() {
        AID.setText("[Click to Generate ID]");
        name.setText("");
        Uname.setText("");
        pword.setText("");
        rpword.setText("");
        add.setText("");
        con.setText("");
        a1.setText("");
        a2.setText("");
        a3.setText("");
        arole1.setSelectedItem("-Select Type-");
//        atype1.setSelectedItem("-Select Role-");
        q1.setSelectedItem("- Select Question -");
        q2.setSelectedItem("- Select Question -");
        q3.setSelectedItem("- Select Question -");
//      uimage.setIcon(new ImageIcon(new ImageIcon("").getImage().getScaledInstance(uimage.getWidth(), uimage.getHeight(), Image.SCALE_DEFAULT)));
//    A_Profile.setText("Browse");
    }

    public void refresh_tbluser() {

        try {
            String sql = "SELECT AccountID,Name,Username,Address,ContactNo,Type,Status FROM tbl_user";
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tbl_user.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void refresh_tbladmin() {

        try {

            String sql = "SELECT AccountId,Name,Username,Address,ContactNo,Type,Status FROM tbl_admin";
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            tbl_admin.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void loggedin() {
        //String loginas=btngrplogin.getSelection().getActionCommand();
        try {
            String sql = "SELECT * FROM tbl_admin where Username =? and Password =? and Type=?";
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, txtusername.getText());
            pst.setString(2, txtpassword.getText());
            pst.setString(3, (String) type1.getSelectedItem());

            rs = pst.executeQuery();
            if (rs.next()) {

                //admin Login history          
                try {

                    pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_admin WHERE Username= '" + txtusername.getText() + "' and Password= '" + txtpassword.getText() + "' ");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String add3 = rs.getString("AccountID");
                        accid.setText(add3);
                        String add4 = rs.getString("Name");
                        user.setText("Logged in user:" + add4);
                        String add5 = rs.getString("type");
                        acctype.setText(add5);
                        //adding admin history
                        try {
                            String sql1 = "Insert into tbl_login_history (AccountID, Name, Username, Type, DateLogin, TimeLogin) values (?,?,?,?,?,?)";
                            Date d = new Date();
                            SimpleDateFormat s = new SimpleDateFormat("h:mm:ss");
                            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql1);

                            pst.setString(1, add3);
                            pst.setString(2, add4);
                            pst.setString(3, txtusername.getText());
                            pst.setString(4, (String) type1.getSelectedItem());
                            pst.setString(5, s_date.getText());
                            pst.setString(6, s_time.getText());

                            pst.execute();
              // JOptionPane.showMessageDialog(null, "New Admin Login History Recorded");

                        } catch (SQLException x) {
                            JOptionPane.showMessageDialog(null, x);
                        }

                        //end of rs.next
                    } else {
                        JOptionPane.showMessageDialog(null, "No Admin Data Found!!!");
                    }

                    //end of admin search
                } catch (SQLException x) {
                    JOptionPane.showMessageDialog(null, x);
                }

                JOptionPane.showMessageDialog(null, "Admin Logged In!");
                menu_logout.setText("Logout");
                Login.setVisible(false);
        Dashboard.setVisible(true);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
    
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        SMS.setVisible(false);
        
            refresh_dapp();
                        //this.dispose();
            } else {

                try {

                    String sql1 = "SELECT * FROM tbl_user where Username =? and Password =? and Type=?";
                    pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql1);

                    pst.setString(1, txtusername.getText());
                    pst.setString(2, txtpassword.getText());
                    pst.setString(3, (String) type1.getSelectedItem());

                    rs = pst.executeQuery();
                    if (rs.next()) {

                        //user Login history          
                        try {

                            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_user WHERE Username= '" + txtusername.getText() + "' and Password= '" + txtpassword.getText() + "'");
                            rs = pst.executeQuery();
                            if (rs.next()) {
                                String add3 = rs.getString("AccountID");
                        accid.setText(add3);
                        String add4 = rs.getString("Name");
                        user.setText("Logged in user:" + add4);
                        String add5 = rs.getString("type");
                        acctype.setText(add5);
                                try {
                                    String sql2 = "Insert tbl_login_history (AccountID, Name, Username, Type, DateLogin, TimeLogin) values (?,?,?,?,?,?)";
                                    Date d = new Date();
                                    SimpleDateFormat s = new SimpleDateFormat("h:mm:ss");
                                    pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql2);

                                    pst.setString(1, add3);
                                    pst.setString(2, add4);
                                    pst.setString(3, txtusername.getText());
                                    pst.setString(4, (String) type1.getSelectedItem());
                                    pst.setString(5, s_date.getText());
                                    pst.setString(6, s_time.getText());

                                    pst.execute();
               //JOptionPane.showMessageDialog(null, "New User Login History Recorded");

                                } catch (SQLException x) {
                                    JOptionPane.showMessageDialog(null, x);
                                }

                            }//end of if rs.next
                            //end try catch of try user log history
                        } catch (SQLException x) {
                            JOptionPane.showMessageDialog(null, x);
                        }

                        try {

                            JOptionPane.showMessageDialog(null, "User Logged In!");
                            menu_logout.setText("Logout");
                            Login.setVisible(false);
        Dashboard.setVisible(true);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        SMS.setVisible(false);
        refresh_dapp();
                        } catch (Exception e) {
                        }

                    } else {

                        try {

                            JOptionPane.showMessageDialog(null, "Incorect ID or Password!", "WARNING!", JOptionPane.ERROR_MESSAGE);
                        } catch (Exception e) {
                        }

                    }
                } catch (SQLException x) {
                    JOptionPane.showMessageDialog(null, x);
                }
            }
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x);
        }

    }
    
    public void calc_total(){
    float a,b,c,d,e,f,g,h,i,total;
         a = Float.parseFloat(ra.getText());
         b = Float.parseFloat(rb.getText());
         c = Float.parseFloat(rc.getText());
         d = Float.parseFloat(rd.getText());
         e = Float.parseFloat(re.getText());
         f = Float.parseFloat(rf.getText());
         g = Float.parseFloat(rg.getText());
         h = Float.parseFloat(rh.getText());
         i = Float.parseFloat(ri.getText());
         total = a + b +c+d+e+f+g+h+i;
         rtotal.setText(String.valueOf(total));
    }
    
//    public void dashboard(){
//        refresh_appointment();
//        int row = satable.getRowCount();
//        prd_count.setText(String.valueOf(row));
//        //d_prd.setText(String.valueOf(row));
//   
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrplogin = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        cbclient = new javax.swing.ButtonGroup();
        setapp = new javax.swing.ButtonGroup();
        receipt = new javax.swing.ButtonGroup();
        Main_Frame = new javax.swing.JPanel();
        Login = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        showpass = new javax.swing.JCheckBox();
        type1 = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbl_dash = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        dtoserve = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        dreserved = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        dresched = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tbl_dsclist = new javax.swing.JTable();
        jLabel94 = new javax.swing.JLabel();
        Account = new javax.swing.JPanel();
        Manacc = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        cuname = new javax.swing.JTextField();
        ccpass = new javax.swing.JPasswordField();
        jLabel87 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        cnpass = new javax.swing.JPasswordField();
        crpass = new javax.swing.JPasswordField();
        jLabel90 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        contact17 = new javax.swing.JLabel();
        nq1 = new javax.swing.JLabel();
        contact20 = new javax.swing.JLabel();
        contact19 = new javax.swing.JLabel();
        na1 = new javax.swing.JTextField();
        contact14 = new javax.swing.JLabel();
        nq2 = new javax.swing.JLabel();
        contact16 = new javax.swing.JLabel();
        na2 = new javax.swing.JTextField();
        contact13 = new javax.swing.JLabel();
        contact21 = new javax.swing.JLabel();
        nq3 = new javax.swing.JLabel();
        contact24 = new javax.swing.JLabel();
        contact23 = new javax.swing.JLabel();
        na3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Acclist = new javax.swing.JPanel();
        auclear = new javax.swing.JButton();
        aact = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_user = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_admin = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        uuclear = new javax.swing.JButton();
        uact = new javax.swing.JButton();
        adminid = new javax.swing.JLabel();
        Addacc = new javax.swing.JPanel();
        contact11 = new javax.swing.JLabel();
        a3 = new javax.swing.JTextField();
        arole1 = new javax.swing.JComboBox();
        contact10 = new javax.swing.JLabel();
        q3 = new javax.swing.JComboBox();
        contact12 = new javax.swing.JLabel();
        contact8 = new javax.swing.JLabel();
        password1 = new javax.swing.JLabel();
        con = new javax.swing.JTextField();
        rpword = new javax.swing.JPasswordField();
        contact3 = new javax.swing.JLabel();
        contact9 = new javax.swing.JLabel();
        a2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        add = new javax.swing.JTextField();
        a1 = new javax.swing.JTextField();
        q1 = new javax.swing.JComboBox();
        contact6 = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        contact2 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        hdgfd = new javax.swing.JLabel();
        q2 = new javax.swing.JComboBox();
        contact5 = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        contact7 = new javax.swing.JLabel();
        Uname = new javax.swing.JTextField();
        pword = new javax.swing.JPasswordField();
        name = new javax.swing.JTextField();
        AID = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        aupdate = new javax.swing.JButton();
        aclear = new javax.swing.JButton();
        address1 = new javax.swing.JLabel();
        Patcon = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CFirst = new javax.swing.JTextField();
        CID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CStreet = new javax.swing.JTextField();
        CLast = new javax.swing.JTextField();
        CZip = new javax.swing.JTextField();
        CMiddle = new javax.swing.JTextField();
        CCity = new javax.swing.JTextField();
        CState = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        CPCell = new javax.swing.JTextField();
        CPHome = new javax.swing.JTextField();
        CPWork = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CSHome = new javax.swing.JTextField();
        CSWork = new javax.swing.JTextField();
        CSCell = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CEMContact = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        CEMName = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        CRefer = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        CIFyes = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CConditions = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        CSave = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        CMarital = new javax.swing.JComboBox();
        CBMedical = new javax.swing.JComboBox();
        CGender1 = new javax.swing.JComboBox();
        Service = new javax.swing.JPanel();
        assearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        astable = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        ra = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        rb = new javax.swing.JTextField();
        rc = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        rd = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        rh = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        rf = new javax.swing.JTextField();
        re = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        rtotal = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        ri = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        sri = new javax.swing.JCheckBox();
        sra = new javax.swing.JCheckBox();
        srb = new javax.swing.JCheckBox();
        src = new javax.swing.JCheckBox();
        srd = new javax.swing.JCheckBox();
        sre = new javax.swing.JCheckBox();
        srf = new javax.swing.JCheckBox();
        srg = new javax.swing.JCheckBox();
        srh = new javax.swing.JCheckBox();
        jLabel114 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rclear = new javax.swing.JButton();
        rgen = new javax.swing.JButton();
        assex = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        asdate = new javax.swing.JTextField();
        asname = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        asaddress = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        asid = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        asseal = new javax.swing.JTextField();
        asblod = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        asmarital = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        asno = new javax.swing.JCheckBox();
        asyes = new javax.swing.JCheckBox();
        jLabel66 = new javax.swing.JLabel();
        asd = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        aswalkin = new javax.swing.JCheckBox();
        asa = new javax.swing.JComboBox();
        asc = new javax.swing.JComboBox();
        asb = new javax.swing.JComboBox();
        ase = new javax.swing.JComboBox();
        ash = new javax.swing.JComboBox();
        asf = new javax.swing.JComboBox();
        asg = new javax.swing.JComboBox();
        Client_List = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_client_list = new javax.swing.JTable();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        csearch = new javax.swing.JTextField();
        Setapp = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        satable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        said = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        btngrpapp = new javax.swing.JCheckBox();
        saclietsell = new javax.swing.JCheckBox();
        btngrpapp2 = new javax.swing.JCheckBox();
        Contact = new javax.swing.JLabel();
        sasave = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        samessage = new javax.swing.JTextArea();
        jLabel72 = new javax.swing.JLabel();
        saname = new javax.swing.JTextField();
        satoday = new javax.swing.JCheckBox();
        satime1 = new javax.swing.JTextField();
        sasave1 = new javax.swing.JButton();
        jLabel95 = new javax.swing.JLabel();
        samem = new javax.swing.JTextField();
        satime = new javax.swing.JLabel();
        sadate = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton13 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        satit = new javax.swing.JLabel();
        sarem = new javax.swing.JLabel();
        sasms = new javax.swing.JComboBox();
        Avail = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        actable = new javax.swing.JTable();
        ADate = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        AID1 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        AID2 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Aremarks = new javax.swing.JTextArea();
        jLabel79 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        Atable = new javax.swing.JTable();
        jLabel80 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        asearch = new javax.swing.JTextField();
        Atime = new javax.swing.JComboBox();
        Checkup = new javax.swing.JPanel();
        serv = new javax.swing.JPanel();
        payment = new javax.swing.JPanel();
        Rpayment = new javax.swing.JPanel();
        RAppoint = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbl_rdasg = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbl_rm_serve = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbl_srv_month = new javax.swing.JTable();
        SMS = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        smspass = new javax.swing.JTextField();
        smsname = new javax.swing.JTextField();
        smsuser = new javax.swing.JTextField();
        btnsms = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sms = new javax.swing.JTable();
        smsid = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        accid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        acctype = new javax.swing.JLabel();
        acctype1 = new javax.swing.JLabel();
        acctype2 = new javax.swing.JLabel();
        s_date = new javax.swing.JLabel();
        acctype4 = new javax.swing.JLabel();
        s_time = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_dashboard = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menu_addacc = new javax.swing.JMenuItem();
        menu_acclist = new javax.swing.JMenuItem();
        menu_manacc = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        user = new javax.swing.JMenu();
        menu_logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLINIC APPOINTMENT SYSTEM");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Main_Frame.setLayout(new java.awt.CardLayout());

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 0, 8, 0, new java.awt.Color(255, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinic_management/Image/Untitled-1.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtusernameKeyReleased(evt);
            }
        });
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 250, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinic_management/Image/login.png"))); // NOI18N
        jLabel10.setText("Username:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 120, 30));

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpassword.setEchoChar('x');
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordKeyReleased(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 250, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 120, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinic_management/Image/password.png"))); // NOI18N
        jLabel11.setText("Password:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Login as:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 255));
        jLabel19.setText("Forgot Password? ");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel1.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, 30));

        type1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        type1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User" }));
        jPanel1.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 180, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("CLINIC APPIONTMENT SYSTEM ");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("ACCOUNT LOGIN");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        Login.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 840, 430));

        Main_Frame.add(Login, "card2");

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 51, 51));

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("CLIENT SCHEDULED LIST");

        tbl_dash.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(tbl_dash);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel93)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
        );

        Dashboard.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dtoserve.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        dtoserve.setForeground(new java.awt.Color(51, 0, 153));
        dtoserve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dtoserve.setText("0");
        jPanel6.add(dtoserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, 50));

        jPanel10.setBackground(new java.awt.Color(255, 51, 51));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("CLIENT TO BE SERVED");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel82)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 30));

        Dashboard.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 330, 150));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 55)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("lll DASHBOARD");
        Dashboard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dreserved.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        dreserved.setForeground(new java.awt.Color(51, 0, 153));
        dreserved.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dreserved.setText("0");
        jPanel7.add(dreserved, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, 50));

        jPanel11.setBackground(new java.awt.Color(255, 51, 51));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("CLIENT SERVED");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel84)
                .addGap(114, 114, 114))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 30));

        Dashboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 330, 150));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(255, 51, 51));

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("CLIENT RESCHEDULED");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel96)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 30));

        dresched.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        dresched.setForeground(new java.awt.Color(51, 0, 153));
        dresched.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dresched.setText("0");
        jPanel14.add(dresched, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, 50));

        Dashboard.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 330, 150));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));

        tbl_dsclist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane16.setViewportView(tbl_dsclist);

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("TODAY SCHEDULE LIST");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel94)
                .addGap(152, 152, 152))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Dashboard.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 410, 280));

        Main_Frame.add(Dashboard, "card3");

        Account.setLayout(new java.awt.CardLayout());

        Manacc.setBackground(new java.awt.Color(255, 255, 255));
        Manacc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 51, 102));
        jLabel92.setText("Change Password");
        Manacc.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(51, 51, 51));
        jLabel88.setText("A strong password helps your account more secure.");
        Manacc.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, 20));

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel91.setText("Username:");
        Manacc.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        cuname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Manacc.add(cuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 220, -1));

        ccpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Manacc.add(ccpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 220, -1));

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel87.setText("Current Password:");
        Manacc.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel89.setText("New Password:");
        Manacc.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        cnpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Manacc.add(cnpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 220, -1));

        crpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Manacc.add(crpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 220, -1));

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel90.setText("Repeat Password:");
        Manacc.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        jLabel86.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 51, 102));
        jLabel86.setText("Update Account Security");
        Manacc.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        contact17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact17.setForeground(new java.awt.Color(102, 102, 102));
        contact17.setText("Personal Verification Question 1");
        Manacc.add(contact17, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, 20));

        nq1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nq1.setText("Question");
        Manacc.add(nq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, -1, 20));

        contact20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact20.setText("Question:");
        Manacc.add(contact20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, -1, 20));

        contact19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact19.setText("Answere:");
        Manacc.add(contact19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, 20));

        na1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Manacc.add(na1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 400, -1));

        contact14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact14.setForeground(new java.awt.Color(102, 102, 102));
        contact14.setText("Personal Verification Question 2");
        Manacc.add(contact14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, -1, 20));

        nq2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nq2.setText("Question");
        Manacc.add(nq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, -1, 20));

        contact16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact16.setText("Question:");
        Manacc.add(contact16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, -1, 20));

        na2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Manacc.add(na2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 400, -1));

        contact13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact13.setText("Answere:");
        Manacc.add(contact13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, 20));

        contact21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact21.setForeground(new java.awt.Color(102, 102, 102));
        contact21.setText("Personal Verification Question 3");
        Manacc.add(contact21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, -1, 20));

        nq3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nq3.setText("Question");
        Manacc.add(nq3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, 20));

        contact24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact24.setText("Question:");
        Manacc.add(contact24, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, 20));

        contact23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact23.setText("Answere:");
        Manacc.add(contact23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, -1, 20));

        na3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Manacc.add(na3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 400, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Manacc.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 80, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Manacc.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 350, 80, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Manacc.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, 80, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Manacc.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 80, -1));

        Account.add(Manacc, "card2");

        Acclist.setBackground(new java.awt.Color(255, 255, 255));
        Acclist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        auclear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        auclear.setText("Clear Selection");
        Acclist.add(auclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 120, -1));

        aact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        aact.setText("Activate");
        aact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aactActionPerformed(evt);
            }
        });
        Acclist.add(aact, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel54.setText("ACCOUNT LIST");
        Acclist.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel55.setText("ADMINISTRATOR ACCOUNT");
        Acclist.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        tbl_user.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_user.setFillsViewportHeight(true);
        tbl_user.setRowHeight(28);
        tbl_user.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tbl_user.setShowVerticalLines(false);
        tbl_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_user);

        Acclist.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 540, 370));

        tbl_admin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbl_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_admin.setFillsViewportHeight(true);
        tbl_admin.setRowHeight(28);
        tbl_admin.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tbl_admin.setShowVerticalLines(false);
        tbl_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_adminMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_admin);

        Acclist.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 540, 370));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel56.setText("ADMINISTRATOR ACCOUNT");
        Acclist.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, -1));

        uuclear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        uuclear.setText("Clear Selection");
        Acclist.add(uuclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 120, -1));

        uact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        uact.setText("Activate");
        uact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uactActionPerformed(evt);
            }
        });
        Acclist.add(uact, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 100, -1));

        adminid.setForeground(new java.awt.Color(51, 204, 255));
        Acclist.add(adminid, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 160, 20));

        Account.add(Acclist, "card3");

        Addacc.setBackground(new java.awt.Color(255, 255, 255));
        Addacc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contact11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact11.setText("Question:");
        Addacc.add(contact11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, 30));

        a3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Addacc.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 370, 30));

        arole1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        arole1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select Type-", "Admin", "User", " " }));
        Addacc.add(arole1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 300, 30));

        contact10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact10.setText("Answere:");
        Addacc.add(contact10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, -1, 30));

        q3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Question -", "What was the name of your first school?", "What's the name of the hosipital in which you were born?", "What's the nickname of your oldest child?", "What is the middle name of your father?", "What is the name of your favorite childhood cuddly toy?", "Who was your first roommate?", "What is the maiden name of your grandmother?", "What is your favorite childhood programme?" }));
        Addacc.add(q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 370, 30));

        contact12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact12.setText("Personal Verification Question 3");
        Addacc.add(contact12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, -1, 20));

        contact8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact8.setText("Question:");
        Addacc.add(contact8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, -1, 30));

        password1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password1.setText("Password:");
        Addacc.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, 20));

        con.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Addacc.add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 300, 30));
        Addacc.add(rpword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 300, 30));

        contact3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact3.setText("Answere:");
        Addacc.add(contact3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, 30));

        contact9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact9.setText("Answere:");
        Addacc.add(contact9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, -1, 30));

        a2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Addacc.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 370, 30));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setText("Name:");
        Addacc.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Addacc.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 300, 30));

        a1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Addacc.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 370, 30));

        q1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Question -", "What is your favorite color?", "What is your pet's name?", "What is your favorite foor?", "What is your favorite movie?", "What is your first girlfriend's/boyfriend's name?", "What is your favorite song?", "What is your favorite book?", "What is your favorite city?", "What is your favorite state?" }));
        Addacc.add(q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 370, 30));

        contact6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact6.setText("Question:");
        Addacc.add(contact6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, 30));

        contact.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        contact.setForeground(new java.awt.Color(51, 51, 51));
        contact.setText("Account Security");
        Addacc.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, 40));

        contact2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact2.setText("Contact:");
        Addacc.add(contact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, 30));

        type.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        type.setText("Type:");
        Addacc.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel52.setText("AccountID:");
        Addacc.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        hdgfd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        hdgfd.setText("Username:");
        Addacc.add(hdgfd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        q2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Question -", "What is your childhood nickname?", "What is the name of your favorite childhood friend?", "What is the name of your first teacher?", "Who is your favorite historical person?", "What's the name of a college you applied to but didn't attend?", "What year did you graduate from high school?", "When is your parents wedding anniversary?", "What counrty  you always dream of vacationing in?" }));
        Addacc.add(q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 370, 30));

        contact5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact5.setText("Personal Verification Question 1");
        Addacc.add(contact5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, -1, 20));

        password.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password.setText("Repeat Password:");
        Addacc.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 20));

        contact7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact7.setText("Personal Verification Question 2");
        Addacc.add(contact7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, -1, 20));

        Uname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Addacc.add(Uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 300, 30));
        Addacc.add(pword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 300, 30));

        name.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Addacc.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 300, 30));

        AID.setEditable(false);
        AID.setBackground(new java.awt.Color(255, 255, 255));
        AID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AID.setText("[Click to Generate ID]");
        AID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AIDMouseClicked(evt);
            }
        });
        Addacc.add(AID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 300, 30));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel57.setText("Add Account");
        Addacc.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 160, 29));

        aupdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        aupdate.setText("Save");
        aupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aupdateActionPerformed(evt);
            }
        });
        Addacc.add(aupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, 130, 30));

        aclear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        aclear.setText("Clear");
        aclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aclearActionPerformed(evt);
            }
        });
        Addacc.add(aclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(899, 410, 130, 30));

        address1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        address1.setText("Address:");
        Addacc.add(address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, 30));

        Account.add(Addacc, "card4");

        Main_Frame.add(Account, "card4");

        Patcon.setBackground(new java.awt.Color(255, 255, 255));
        Patcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("CLIENT INFORMATION AND MEDICAL HISTORY");
        Patcon.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Client Name (Last, Middle, First):");
        Patcon.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        CFirst.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CFirstMouseClicked(evt);
            }
        });
        CFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CFirstActionPerformed(evt);
            }
        });
        Patcon.add(CFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 200, -1));

        CID.setEditable(false);
        CID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CID.setText("[Click to Generate ID]");
        CID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CIDMouseClicked(evt);
            }
        });
        CID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CIDActionPerformed(evt);
            }
        });
        Patcon.add(CID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 51, 280, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Zipcode");
        Patcon.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 110, 20));

        CStreet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CStreet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CStreetActionPerformed(evt);
            }
        });
        Patcon.add(CStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 310, -1));

        CLast.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CLastMouseClicked(evt);
            }
        });
        CLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLastActionPerformed(evt);
            }
        });
        Patcon.add(CLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 200, -1));

        CZip.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CZipActionPerformed(evt);
            }
        });
        Patcon.add(CZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 110, -1));

        CMiddle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CMiddle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMiddleMouseClicked(evt);
            }
        });
        CMiddle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMiddleActionPerformed(evt);
            }
        });
        Patcon.add(CMiddle, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 200, -1));

        CCity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCityActionPerformed(evt);
            }
        });
        Patcon.add(CCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 200, -1));

        CState.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CStateActionPerformed(evt);
            }
        });
        Patcon.add(CState, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 200, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Client Email:");
        Patcon.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 90, 20));

        CEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEmailActionPerformed(evt);
            }
        });
        Patcon.add(CEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 310, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Client Phone:");
        Patcon.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 90, 20));

        CPCell.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CPCell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPCellActionPerformed(evt);
            }
        });
        Patcon.add(CPCell, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 170, -1));

        CPHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CPHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPHomeActionPerformed(evt);
            }
        });
        Patcon.add(CPHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 170, -1));

        CPWork.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CPWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPWorkActionPerformed(evt);
            }
        });
        Patcon.add(CPWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 170, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Client Spouse:");
        Patcon.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, 20));

        CSHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CSHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSHomeActionPerformed(evt);
            }
        });
        Patcon.add(CSHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 170, -1));

        CSWork.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CSWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSWorkActionPerformed(evt);
            }
        });
        Patcon.add(CSWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 170, -1));

        CSCell.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CSCell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSCellActionPerformed(evt);
            }
        });
        Patcon.add(CSCell, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 170, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("MEDICAL HISTORY");
        Patcon.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 200, 20));

        CEMContact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CEMContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEMContactActionPerformed(evt);
            }
        });
        Patcon.add(CEMContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 270, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Alternate Emergency Contact:");
        Patcon.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 200, 20));

        CEMName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CEMName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEMNameActionPerformed(evt);
            }
        });
        Patcon.add(CEMName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 270, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("How were you refer with us?");
        Patcon.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 200, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Do you have any of the following conditions? (Please list down)");
        Patcon.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 460, 20));

        CRefer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CRefer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CReferActionPerformed(evt);
            }
        });
        Patcon.add(CRefer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 750, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Are you currently under the care of a physician?");
        Patcon.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 300, 20));

        CIFyes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CIFyes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CIFyesActionPerformed(evt);
            }
        });
        Patcon.add(CIFyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 640, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("If yes, for what? ");
        Patcon.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 110, 20));

        CConditions.setColumns(20);
        CConditions.setRows(5);
        jScrollPane1.setViewportView(CConditions);

        Patcon.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 400, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("SHOW LIST");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Patcon.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 150, 30));

        CSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CSave.setText("SAVE");
        CSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSaveActionPerformed(evt);
            }
        });
        Patcon.add(CSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 150, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Address:");
        Patcon.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 70, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Cell");
        Patcon.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 120, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Gender");
        Patcon.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 60, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("State");
        Patcon.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 120, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Number & Street");
        Patcon.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 120, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Home");
        Patcon.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 120, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Work");
        Patcon.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 120, 20));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Client Entry ID:");
        Patcon.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("City");
        Patcon.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 120, 20));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Marital State");
        Patcon.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 120, 20));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton12.setText("CLEAR");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        Patcon.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 150, 30));

        CMarital.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Maried" }));
        Patcon.add(CMarital, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 130, -1));

        CBMedical.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        Patcon.add(CBMedical, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 90, -1));

        CGender1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        Patcon.add(CGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 130, -1));

        Main_Frame.add(Patcon, "card5");

        Service.setBackground(new java.awt.Color(255, 255, 255));
        Service.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assearchActionPerformed(evt);
            }
        });
        assearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                assearchKeyReleased(evt);
            }
        });
        Service.add(assearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 190, -1));

        astable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        astable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        astable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                astableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                astableMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(astable);

        Service.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 670, 150));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("AVAILABILITY SERVICE");
        Service.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("MEDICAL BILL");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 340, 30));

        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 290, 110, -1));

        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 290, 110, -1));

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raActionPerformed(evt);
            }
        });
        ra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                raKeyReleased(evt);
            }
        });
        jPanel16.add(ra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 100, 30));

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel97.setText("Billing Receipt");
        jPanel16.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel104.setText("TB");
        jPanel16.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, 30));

        rb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rb.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActionPerformed(evt);
            }
        });
        rb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rbKeyReleased(evt);
            }
        });
        jPanel16.add(rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 100, 30));

        rc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcKeyReleased(evt);
            }
        });
        jPanel16.add(rc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 100, 30));

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel105.setText("Heart Desease");
        jPanel16.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 100, 30));

        rd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rdKeyReleased(evt);
            }
        });
        jPanel16.add(rd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 100, 30));

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel106.setText("Blood Preasure");
        jPanel16.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, 30));

        rh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rhKeyReleased(evt);
            }
        });
        jPanel16.add(rh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 100, 30));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel107.setText("TPHA");
        jPanel16.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 100, 30));

        rg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rgKeyReleased(evt);
            }
        });
        jPanel16.add(rg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 100, 30));

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel108.setText("VLDR");
        jPanel16.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 100, 30));

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel109.setText("Liver");
        jPanel16.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 100, 30));

        rf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rfKeyReleased(evt);
            }
        });
        jPanel16.add(rf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 100, 30));

        re.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        re.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        re.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reKeyReleased(evt);
            }
        });
        jPanel16.add(re, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 30));

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel110.setText("Malria");
        jPanel16.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 100, 30));

        rtotal.setEditable(false);
        rtotal.setBackground(new java.awt.Color(255, 255, 255));
        rtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rtotal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rtotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rtotalMouseClicked(evt);
            }
        });
        rtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtotalActionPerformed(evt);
            }
        });
        jPanel16.add(rtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 170, 30));

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(204, 0, 0));
        jLabel111.setText("Click total cost field to calculate");
        jPanel16.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 170, 10));

        ri.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ri.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                riKeyReleased(evt);
            }
        });
        jPanel16.add(ri, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, 30));

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel112.setText("OTHER");
        jPanel16.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 100, 30));

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel113.setText("HIV");
        jPanel16.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, 30));

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel122.setText("Total Cost:");
        jPanel16.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 80, 30));

        sri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sriActionPerformed(evt);
            }
        });
        jPanel16.add(sri, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, 30));

        sra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sraActionPerformed(evt);
            }
        });
        jPanel16.add(sra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, 30));

        srb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srbActionPerformed(evt);
            }
        });
        jPanel16.add(srb, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, 30));

        src.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcActionPerformed(evt);
            }
        });
        jPanel16.add(src, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 30));

        srd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srdActionPerformed(evt);
            }
        });
        jPanel16.add(srd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, 30));

        sre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sreActionPerformed(evt);
            }
        });
        jPanel16.add(sre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, 30));

        srf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srfActionPerformed(evt);
            }
        });
        jPanel16.add(srf, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 30));

        srg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srgActionPerformed(evt);
            }
        });
        jPanel16.add(srg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, 30));

        srh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srhActionPerformed(evt);
            }
        });
        jPanel16.add(srh, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, 30));

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel114.setText("Medical Test Cost");
        jPanel16.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Update");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, 20));

        jPanel18.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 340, 450));

        jPanel2.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 410, 510));

        rclear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rclear.setText("Clear");
        rclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rclearActionPerformed(evt);
            }
        });
        jPanel2.add(rclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 70, -1));

        rgen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rgen.setText("Generate Receipt");
        rgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgenActionPerformed(evt);
            }
        });
        jPanel2.add(rgen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 140, -1));

        Service.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 430, 580));

        assex.setEditable(false);
        assex.setBackground(new java.awt.Color(255, 255, 255));
        assex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assexActionPerformed(evt);
            }
        });
        Service.add(assex, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 110, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("EID:");
        Service.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 30, 20));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Date Reserved:");
        Service.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 100, 20));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("Name:");
        Service.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 40, 20));

        asdate.setEditable(false);
        asdate.setBackground(new java.awt.Color(255, 255, 255));
        asdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asdateActionPerformed(evt);
            }
        });
        Service.add(asdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 120, -1));

        asname.setEditable(false);
        asname.setBackground(new java.awt.Color(255, 255, 255));
        asname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asnameActionPerformed(evt);
            }
        });
        Service.add(asname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 190, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel40.setBackground(new java.awt.Color(0, 0, 255));
        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("MEDICAL REPORT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Service.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 670, 20));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jLabel44.setBackground(new java.awt.Color(0, 0, 255));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("CLIENT TO BE SERVED");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Service.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 670, 20));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Gender:");
        Service.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 60, 20));

        asaddress.setEditable(false);
        asaddress.setBackground(new java.awt.Color(255, 255, 255));
        asaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asaddressActionPerformed(evt);
            }
        });
        Service.add(asaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 600, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Address:");
        Service.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 60, 20));

        asid.setEditable(false);
        asid.setBackground(new java.awt.Color(255, 255, 255));
        asid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asidActionPerformed(evt);
            }
        });
        Service.add(asid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 150, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel48.setText("h. TPHA Test:");
        Service.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 110, 20));

        asseal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assealActionPerformed(evt);
            }
        });
        Service.add(asseal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 540, -1));

        asblod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asblodActionPerformed(evt);
            }
        });
        Service.add(asblod, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 110, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Blood Type");
        Service.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 90, 20));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText("Marital Status");
        Service.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 90, 20));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("Seal of the clinic:");
        Service.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 110, 20));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel58.setText("a. HIV test:");
        Service.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 80, 20));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setText("b. TB test:");
        Service.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 80, 20));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("c. Heart Desease:");
        Service.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 120, 20));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel61.setText("d. High Blood preasure:");
        Service.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 150, 20));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("e. Malaria:");
        Service.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 110, 20));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("f. Liver Function:");
        Service.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 110, 20));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("g. VDRL Test: ");
        Service.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 110, 20));

        asmarital.setEditable(false);
        asmarital.setBackground(new java.awt.Color(255, 255, 255));
        asmarital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asmaritalActionPerformed(evt);
            }
        });
        Service.add(asmarital, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 110, -1));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel65.setText("Examine following Medical Conditions");
        Service.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 240, 20));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setText("Print");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        Service.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, 80, -1));

        asno.setBackground(new java.awt.Color(255, 255, 255));
        setapp.add(asno);
        asno.setText("No");
        Service.add(asno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, -1, 30));

        asyes.setBackground(new java.awt.Color(255, 255, 255));
        setapp.add(asyes);
        asyes.setText("Yes");
        Service.add(asyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, -1, 30));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("In the option of the examining physician, is the candidate fit for this fellowship?");
        Service.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 510, 30));

        asd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asdActionPerformed(evt);
            }
        });
        Service.add(asd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 180, -1));

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Service.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 470, 20));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("Clear");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Service.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, 90, -1));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel69.setText("Search");
        Service.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 20));

        aswalkin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        aswalkin.setText("SELECT FOR CLIENT WALKIN");
        aswalkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aswalkinActionPerformed(evt);
            }
        });
        Service.add(aswalkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 70, 200, -1));

        asa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negative", "Pass" }));
        Service.add(asa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 180, -1));

        asc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negative", "Pass" }));
        Service.add(asc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 180, -1));

        asb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negative", "Pass" }));
        Service.add(asb, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 180, -1));

        ase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negative", "Pass" }));
        Service.add(ase, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 180, -1));

        ash.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negative", "Pass" }));
        Service.add(ash, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 180, -1));

        asf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negative", "Pass" }));
        Service.add(asf, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 180, -1));

        asg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negative", "Pass" }));
        Service.add(asg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 180, -1));

        Main_Frame.add(Service, "card6");

        Client_List.setBackground(new java.awt.Color(255, 255, 255));
        Client_List.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Client_List.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_client_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_client_list.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_client_list.setFillsViewportHeight(true);
        tbl_client_list.setRowHeight(28);
        tbl_client_list.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tbl_client_list.setShowVerticalLines(false);
        tbl_client_list.getTableHeader().setReorderingAllowed(false);
        tbl_client_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_client_listMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_client_list);

        Client_List.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 1100, 500));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(51, 51, 51));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("SEARCH");
        Client_List.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(51, 51, 51));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("CLIENT LIST");
        Client_List.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 190, 20));

        csearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                csearchKeyReleased(evt);
            }
        });
        Client_List.add(csearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 330, 30));

        Main_Frame.add(Client_List, "card7");

        Setapp.setBackground(new java.awt.Color(255, 255, 255));
        Setapp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        satable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        satable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        satable.setFillsViewportHeight(true);
        satable.setRowHeight(28);
        satable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        satable.setShowVerticalLines(false);
        satable.getTableHeader().setReorderingAllowed(false);
        satable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                satableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(satable);

        Setapp.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 780, 480));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Appointment / Set Appointment");
        Setapp.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        said.setEditable(false);
        said.setBackground(new java.awt.Color(255, 255, 255));
        said.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        said.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saidActionPerformed(evt);
            }
        });
        Setapp.add(said, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 280, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Search:");
        Setapp.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, 50, 20));

        jTextField41.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField41KeyReleased(evt);
            }
        });
        Setapp.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 290, 30));

        btngrpapp.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btngrpapp);
        btngrpapp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btngrpapp.setText("Reschedule Client Appointment");
        btngrpapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrpappActionPerformed(evt);
            }
        });
        Setapp.add(btngrpapp, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, -1, -1));

        saclietsell.setBackground(new java.awt.Color(255, 255, 255));
        saclietsell.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saclietsell.setText("Client selection");
        saclietsell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saclietsellActionPerformed(evt);
            }
        });
        Setapp.add(saclietsell, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, 30));

        btngrpapp2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btngrpapp2);
        btngrpapp2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btngrpapp2.setText("Schedule Client Appointment");
        Setapp.add(btngrpapp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, -1, -1));

        Contact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Setapp.add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 30));

        sasave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sasave.setText("SAVE");
        sasave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sasaveActionPerformed(evt);
            }
        });
        Setapp.add(sasave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 550, 90, 30));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setText("Message to Client");
        Setapp.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 110, 20));

        samessage.setEditable(false);
        samessage.setColumns(20);
        samessage.setRows(5);
        jScrollPane8.setViewportView(samessage);

        Setapp.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, 300, 160));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel72.setText("Client Name:");
        Setapp.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 80, 30));

        saname.setEditable(false);
        saname.setBackground(new java.awt.Color(255, 255, 255));
        saname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Setapp.add(saname, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 280, 30));

        satoday.setBackground(new java.awt.Color(255, 255, 255));
        satoday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        satoday.setText("Todays Schedule");
        satoday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satodayActionPerformed(evt);
            }
        });
        Setapp.add(satoday, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, 30));

        satime1.setEditable(false);
        satime1.setBackground(new java.awt.Color(255, 255, 255));
        satime1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Setapp.add(satime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 320, 140, 30));

        sasave1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sasave1.setText("Clear");
        sasave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sasave1ActionPerformed(evt);
            }
        });
        Setapp.add(sasave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 550, 90, 30));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel95.setText("Member:");
        Setapp.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 80, 30));

        samem.setEditable(false);
        samem.setBackground(new java.awt.Color(255, 255, 255));
        samem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Setapp.add(samem, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 280, 30));

        satime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        satime.setText("Time");
        Setapp.add(satime, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 295, 80, 20));

        sadate.setEditable(false);
        sadate.setBackground(new java.awt.Color(255, 255, 255));
        sadate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Setapp.add(sadate, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 140, 30));

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox3.setText("Select Date");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        Setapp.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 140, -1));

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton13.setText("Send");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        Setapp.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 550, 80, 30));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel71.setText("Selected ID:");
        Setapp.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 80, 20));

        satit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        satit.setText("title");
        Setapp.add(satit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 370, 20));

        sarem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sarem.setText("Show Removed");
        sarem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sarem.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                saremAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        sarem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saremMouseClicked(evt);
            }
        });
        Setapp.add(sarem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, -1, 20));

        sasms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sasmsKeyReleased(evt);
            }
        });
        Setapp.add(sasms, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, 120, -1));

        Main_Frame.add(Setapp, "card8");

        Avail.setBackground(new java.awt.Color(255, 255, 255));
        Avail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        actable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        actable.setFillsViewportHeight(true);
        actable.setRowHeight(28);
        actable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        actable.setShowVerticalLines(false);
        actable.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(actable);

        Avail.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 1110, 220));

        ADate.setDateFormatString("MMM-dd-yyyy");
        Avail.add(ADate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 160, 30));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setText("Management Control / Availabilty");
        Avail.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        AID1.setEditable(false);
        AID1.setBackground(new java.awt.Color(255, 255, 255));
        AID1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AID1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AID1.setText("[Click to Generate Number]");
        AID1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AID1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AID1MouseClicked(evt);
            }
        });
        Avail.add(AID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 300, 30));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setText("Filter Date");
        Avail.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 47, -1, 30));

        AID2.setEditable(false);
        AID2.setBackground(new java.awt.Color(255, 255, 255));
        AID2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AID2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AID2.setText("[Click to Generate Number]");
        AID2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AID2MouseClicked(evt);
            }
        });
        Avail.add(AID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, -180, 300, 20));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("SET AVAILABLE SCHEDULE");
        Avail.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 320, -1));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel76.setText("Time:");
        Avail.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, -1, -1));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel77.setText("Client Scheduled");
        Avail.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel78.setText("Select Date:");
        Avail.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, -1, -1));

        Aremarks.setColumns(20);
        Aremarks.setRows(5);
        jScrollPane10.setViewportView(Aremarks);

        Avail.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 310, -1));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel79.setText("Remarks:");
        Avail.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, -1, -1));

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton15.setText("Save");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        Avail.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, 120, 30));

        Atable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Atable.setFillsViewportHeight(true);
        Atable.setRowHeight(28);
        Atable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        Atable.setShowVerticalLines(false);
        Atable.getTableHeader().setReorderingAllowed(false);
        Atable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AtableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(Atable);

        Avail.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 730, 240));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel80.setText("Availability Number:");
        Avail.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Avail.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 110, 30));

        asearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        asearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                asearchKeyReleased(evt);
            }
        });
        Avail.add(asearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 220, 30));

        Atime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM" }));
        Avail.add(Atime, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 150, 130, 30));

        Main_Frame.add(Avail, "card9");

        javax.swing.GroupLayout CheckupLayout = new javax.swing.GroupLayout(Checkup);
        Checkup.setLayout(CheckupLayout);
        CheckupLayout.setHorizontalGroup(
            CheckupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        CheckupLayout.setVerticalGroup(
            CheckupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        Main_Frame.add(Checkup, "card10");

        javax.swing.GroupLayout servLayout = new javax.swing.GroupLayout(serv);
        serv.setLayout(servLayout);
        servLayout.setHorizontalGroup(
            servLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        servLayout.setVerticalGroup(
            servLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        Main_Frame.add(serv, "card11");

        javax.swing.GroupLayout paymentLayout = new javax.swing.GroupLayout(payment);
        payment.setLayout(paymentLayout);
        paymentLayout.setHorizontalGroup(
            paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        paymentLayout.setVerticalGroup(
            paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        Main_Frame.add(payment, "card12");

        javax.swing.GroupLayout RpaymentLayout = new javax.swing.GroupLayout(Rpayment);
        Rpayment.setLayout(RpaymentLayout);
        RpaymentLayout.setHorizontalGroup(
            RpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        RpaymentLayout.setVerticalGroup(
            RpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        Main_Frame.add(Rpayment, "card13");

        RAppoint.setBackground(new java.awt.Color(255, 255, 255));
        RAppoint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_rdasg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(tbl_rdasg);

        jTabbedPane1.addTab("Client Served", jScrollPane14);

        tbl_rm_serve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(tbl_rm_serve);

        jTabbedPane1.addTab("Appointment Rescheduled", jScrollPane15);

        tbl_srv_month.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tbl_srv_month);

        jTabbedPane1.addTab("Appointment Removed", jScrollPane12);

        RAppoint.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 520));

        Main_Frame.add(RAppoint, "card14");

        SMS.setBackground(new java.awt.Color(255, 255, 255));
        SMS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("SMS Account");
        SMS.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 120, -1));

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(51, 51, 51));
        jLabel98.setText("ID:");
        SMS.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(51, 51, 51));
        jLabel99.setText("Username:");
        SMS.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 0, 204));
        jLabel100.setText("Bulksms.com");
        jLabel100.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel100MouseClicked(evt);
            }
        });
        SMS.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));
        SMS.add(smspass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 210, -1));
        SMS.add(smsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 210, -1));
        SMS.add(smsuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 210, -1));

        btnsms.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsms.setText("Save");
        btnsms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsmsActionPerformed(evt);
            }
        });
        SMS.add(btnsms, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 80, -1));

        tbl_sms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_smsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_smsMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sms);

        SMS.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 400, 230));

        smsid.setEditable(false);
        smsid.setBackground(new java.awt.Color(255, 255, 255));
        smsid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        smsid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        smsid.setText("[Click to Generate ID]");
        smsid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        smsid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smsidMouseClicked(evt);
            }
        });
        SMS.add(smsid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 210, -1));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(51, 51, 51));
        jLabel101.setText("Name:");
        SMS.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setText("Clear");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        SMS.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 70, -1));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(51, 51, 51));
        jLabel102.setText("Open URL:");
        SMS.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(51, 51, 51));
        jLabel103.setText("Password:");
        SMS.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        Main_Frame.add(SMS, "card15");

        getContentPane().add(Main_Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1130, 600));

        jToolBar1.setRollover(true);
        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1000, 30));

        jToolBar2.setRollover(true);

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("   Account ID:   ");
        jToolBar2.add(jLabel3);

        accid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accid.setText("------------------");
        jToolBar2.add(accid);

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("   Account Type:   ");
        jToolBar2.add(jLabel5);

        acctype.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        acctype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acctype.setText("------------------");
        jToolBar2.add(acctype);

        acctype1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        acctype1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acctype1.setText("                                                                                                                                                                               ");
        jToolBar2.add(acctype1);

        acctype2.setBackground(new java.awt.Color(102, 102, 102));
        acctype2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        acctype2.setForeground(new java.awt.Color(51, 51, 51));
        acctype2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acctype2.setText("Date:  ");
        jToolBar2.add(acctype2);

        s_date.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        s_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s_date.setText("MMM-dd-yyyy");
        jToolBar2.add(s_date);

        acctype4.setBackground(new java.awt.Color(102, 102, 102));
        acctype4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        acctype4.setForeground(new java.awt.Color(51, 51, 51));
        acctype4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acctype4.setText("  Time:  ");
        jToolBar2.add(acctype4);

        s_time.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        s_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s_time.setText("h:mm aa");
        jToolBar2.add(s_time);

        getContentPane().add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 1130, 20));

        jMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu1.setText("File");

        menu_dashboard.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menu_dashboard.setText("DASHBOARD");
        menu_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dashboardActionPerformed(evt);
            }
        });
        jMenu1.add(menu_dashboard);
        jMenu1.add(jSeparator1);

        jMenu3.setText("Management Control");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Client Control");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Client Service");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenu7.setText("Account Management");

        menu_addacc.setText("Add Account");
        menu_addacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_addaccActionPerformed(evt);
            }
        });
        jMenu7.add(menu_addacc);

        menu_acclist.setText("Account List");
        menu_acclist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_acclistActionPerformed(evt);
            }
        });
        jMenu7.add(menu_acclist);

        menu_manacc.setText("Manage Account");
        menu_manacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_manaccActionPerformed(evt);
            }
        });
        jMenu7.add(menu_manacc);

        jMenu3.add(jMenu7);

        jMenuItem1.setText("SMS Account");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenu1.add(jMenu3);

        jMenu4.setText("Appointment");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Availability");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Set Appointment");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenu1.add(jMenu4);

        jMenu6.setText("Report");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Appointment");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        user.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        user.setText("Please Login");
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        menu_logout.setText("Login");
        menu_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_logoutActionPerformed(evt);
            }
        });
        user.add(menu_logout);

        jMenuBar1.add(user);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
            SMS.setVisible(false);
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(true);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        refresh_smslist();
       // refresh_sched();
       
        if (saclietsell.isSelected() == true){
                sa_refresh_list();
                refresh_smslist();
               
        }else{
        refresh_appointment();
       refresh_smslist();
        }
        
        
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_admin WHERE Username= '" + txtusername.getText() + "' and Password= '" + txtpassword.getText() + "' ");
            rs = pst.executeQuery();

            if (rs.next()) {
                String add3 = rs.getString("Status");
                if (add3.contentEquals("Active")) {
                    loggedin();
                    //jLabel11.setIcon().getDefaultToolkit().getImage(getClass().getResource("tile.png")));

                } else if (add3.contentEquals("Inactive")) {
                    JOptionPane.showMessageDialog(null, "Account deactivated");

                }
            } else {
                pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_user WHERE Username= '" + txtusername.getText() + "' and Password= '" + txtpassword.getText() + "' ");
                rs = pst.executeQuery();

                if (rs.next()) {
                    String add3 = rs.getString("Status");
                    if (add3.contentEquals("Active")) {
                        loggedin();

                    } else if (add3.contentEquals("Inactive")) {
                        JOptionPane.showMessageDialog(null, "Account deactivated");

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Incorrect Username/Password Match!!!");
                }
            }
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
             SMS.setVisible(false);
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(true);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        clear_client();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void menu_addaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_addaccActionPerformed
        if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
            if (acctype.getText().equals("User")){
            JOptionPane.showMessageDialog(null, "Invalid user field");
            }else{
            SMS.setVisible(false);
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(true);
        Addacc.setVisible(true);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        }}
    }//GEN-LAST:event_menu_addaccActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cnpass.getText().equals(crpass.getText())) {
            try {

                pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_admin SET Password=? WHERE Username='" + cuname.getText() + "' and Password='" + ccpass.getText() + "'  and AccountID='" + accid.getText() + "'");

                pst.setString(1, cnpass.getText());

                int admin_update = pst.executeUpdate();

                if (admin_update != 0) {
                    changepass_clear();
                    //view_acc_det();

                    JOptionPane.showMessageDialog(null, "Admin Account Password Updated");

                } else {
                    pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_user SET Password=? WHERE Username='" + cuname.getText() + "' and Password='" + ccpass.getText() + "' and AccountID='" + accid.getText() + "'");

                    pst.setString(1, cnpass.getText());
                    int user_update = pst.executeUpdate();
                    if (user_update != 0) {
                        changepass_clear();
                        //view_acc_det();

                        JOptionPane.showMessageDialog(null, "User Account Password Updated");

                    } else {

                        JOptionPane.showMessageDialog(null, "Please check Username/Password");
                    }

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Incorrect password Match");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        changepass_clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {

            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_admin SET A1=?,A2=?,A3=? WHERE AccountID='" + accid.getText() + "' and Name='" + user.getText() + "'");

            pst.setString(1, na1.getText());
            pst.setString(2, na2.getText());
            pst.setString(3, na3.getText());

            int admin_update = pst.executeUpdate();

            if (admin_update != 0) {
                changepass_clear();

                JOptionPane.showMessageDialog(null, "Admin Account Security Updated");
                // view_acc_det();
                clear_ans();
            } else {
                pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_user SET A1=?,A2=?,A3=? WHERE AccountID='" + accid.getText() + "' and Name='" + user.getText() + "'");

                pst.setString(1, na1.getText());
                pst.setString(2, na2.getText());
                pst.setString(3, na3.getText());
                int user_update = pst.executeUpdate();
                if (user_update != 0) {
                    changepass_clear();

                    JOptionPane.showMessageDialog(null, "User Account Security Updated");
                    //view_acc_det();
                    clear_ans();
                } else {

                    JOptionPane.showMessageDialog(null, "Please check Username/Password");
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void aactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aactActionPerformed
        // TODO add your handling code here:
        if (adminid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select Account First!");
        } else if (aact.getText().equals("Activate")) {
            JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Activate");
            options[1] = new String("Cancel");
            int p = JOptionPane.showOptionDialog(frame.getContentPane(), "Activating Account Might Access Aystem Application! Do you want to Continue?", "Activate", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
            if (p == 0) {

                try {
                    pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_admin SET Status=?  WHERE AccountID='" + adminid.getText() + "'");

                    pst.setString(1, "Active");
                    int update = pst.executeUpdate();
                    if (update != 0) {
                        refresh_tbladmin();
                        adminid.setText("");
                        auclear.disable();
                        JOptionPane.showMessageDialog(null, "Account Activated");

                        //  x1.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Select Account to Deactivate");

                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            } else if (p == 1) {
                auclear.enable();
                adminid.setText("");
            }

        } else if (aact.getText().equals("Deactivate")) {
            JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Deactivate");
            options[1] = new String("Cancel");
            int p = JOptionPane.showOptionDialog(frame.getContentPane(), "Deactivating Account Might Cause Login Error! Do You Want to Continue?", "Deactivate", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
            if (p == 0) {

                try {
                    pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_admin SET Status=?  WHERE AccountID='" + adminid.getText() + "'");

                    pst.setString(1, "Inactive");
                    int update = pst.executeUpdate();
                    if (update != 0) {
                        refresh_tbladmin();
                        adminid.setText("");
                        auclear.disable();
                        JOptionPane.showMessageDialog(null, "Admin Account Deactivated");

                        // x1.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Select Account to Deactivate");

                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } else if (p == 1) {
                auclear.enable();
                adminid.setText("");
            }
        }
    }//GEN-LAST:event_aactActionPerformed

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userMouseClicked
        int a = tbl_user.getSelectedRow();
        DefaultTableModel model =  (DefaultTableModel) tbl_user.getModel();
        adminid.setText(model.getValueAt(a,0).toString());
        try {
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_user WHERE AccountID = '" + adminid.getText() + "'");
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {

                String add1 = rs.getString("Status");
                if (add1.equals("Active")){
                    uact.setText("Deactivate");
                }else if(add1.equals("Inactive")){
                    uact.setText("Activate");
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tbl_userMouseClicked

    private void tbl_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_adminMouseClicked
        int a = tbl_admin.getSelectedRow();
        DefaultTableModel model =  (DefaultTableModel) tbl_admin.getModel();
        adminid.setText(model.getValueAt(a,0).toString());
        try {
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_admin WHERE AccountID = '" + adminid.getText() + "'");
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {

                String add1 = rs.getString("Status");
                if (add1.equals("Active")){
                    aact.setText("Deactivate");
                }else if(add1.equals("Inactive")){
                    aact.setText("Activate");
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tbl_adminMouseClicked

    private void uactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uactActionPerformed

    private void AIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AIDMouseClicked
        // TODO add your handling code here:
        if (AID.getText().equals("[Click to Generate ID]")) {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hmmss");
            SimpleDateFormat st = new SimpleDateFormat("MMddyyyy");
            AID.setText("ID" + st.format(d) + s.format(d));
        } else {

        }
    }//GEN-LAST:event_AIDMouseClicked

    private void menu_acclistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_acclistActionPerformed
if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
    if (acctype.getText().equals("User")){
            JOptionPane.showMessageDialog(null, "Invalid user field");
            }else{
    SMS.setVisible(false);
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(true);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(true);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        refresh_tbladmin();
            refresh_tbluser();
        }}
    }//GEN-LAST:event_menu_acclistActionPerformed

    private void menu_manaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_manaccActionPerformed
if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
    SMS.setVisible(false);
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(true);
        Addacc.setVisible(false);
        Manacc.setVisible(true);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        }
    }//GEN-LAST:event_menu_manaccActionPerformed

    private void menu_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_dashboardActionPerformed
//hide_panel();
         if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
        Login.setVisible(false);
        Dashboard.setVisible(true);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        SMS.setVisible(false);
        refresh_dapp();
        }
    }//GEN-LAST:event_menu_dashboardActionPerformed

    private void menu_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_logoutActionPerformed
        if(menu_logout.getText().contains("Logout")){
            JFrame frame = new JFrame();
        String[] options = new String[2];
        options[0] = new String("Logout");
        options[1] = new String("Cancel");
        int p = JOptionPane.showOptionDialog(frame.getContentPane(),"Countinue logout account?","Logout", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
         
        if(p==0){
            
            accid.setText("------------------");
            acctype.setText("------------------");
           // accrole.setText("------------------");
            txtusername.setText("");
            txtpassword.setText("");
            Login.setVisible(true);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        
        SMS.setVisible(false);
        menu_logout.setText("Login");
        user.setText("Please Login");
        }else if (p==1){
            frame.dispose();
        }
        }else{
        
        }
       
    }//GEN-LAST:event_menu_logoutActionPerformed

    private void CFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CFirstActionPerformed
      
    }//GEN-LAST:event_CFirstActionPerformed

    private void CIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CIDActionPerformed

    private void CStreetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CStreetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CStreetActionPerformed

    private void CLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLastActionPerformed

    private void CZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CZipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CZipActionPerformed

    private void CMiddleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMiddleActionPerformed
       
    }//GEN-LAST:event_CMiddleActionPerformed

    private void CCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCityActionPerformed

    private void CStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CStateActionPerformed

    private void CEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CEmailActionPerformed

    private void CPCellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPCellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPCellActionPerformed

    private void CPHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPHomeActionPerformed

    private void CPWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPWorkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPWorkActionPerformed

    private void CSHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSHomeActionPerformed

    private void CSWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSWorkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSWorkActionPerformed

    private void CSCellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSCellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSCellActionPerformed

    private void CEMContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEMContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CEMContactActionPerformed

    private void CEMNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEMNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CEMNameActionPerformed

    private void CReferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CReferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CReferActionPerformed

    private void CIFyesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CIFyesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CIFyesActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
            refresh_list();
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(true);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
       if (showpass.isSelected()) {
      txtpassword.setEchoChar((char)0); //password = JPasswordField
   } else {
      txtpassword.setEchoChar('x');
   }
    }//GEN-LAST:event_showpassActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        new Forgot().setVisible(true);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void aupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aupdateActionPerformed
        // TODO add your handling code here:
        if (aupdate.getText().equals("Save")) {

            if (AID.getText().equals("[Click to Generate ID]")) {

                JOptionPane.showMessageDialog(null, "Invalid Account ID!!");

            } else if (arole1.getSelectedItem().equals("-Select Type-")) {

                JOptionPane.showMessageDialog(null, "Invalid Account Type!!");

            }  else {

                String typ = arole1.getSelectedItem().toString();
                if (typ.equals("Admin")) {
                    try {
                        String sql = "Insert into tbl_admin (AccountID, Name, Username, Password, Address, ContactNo, Type, Status, Q1, A1, Q2, A2, Q3, A3) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

                        pst.setString(1, AID.getText());
                        pst.setString(2, name.getText());
                        pst.setString(3, Uname.getText());
                        pst.setString(4, pword.getText());
                        pst.setString(5, add.getText());
                        pst.setString(6, con.getText());
                        pst.setString(7, (String) arole1.getSelectedItem());
                        pst.setString(8, "Active");
                        pst.setString(9, (String) q1.getSelectedItem());
                        pst.setString(10, a1.getText());
                        pst.setString(11, (String) q2.getSelectedItem());
                        pst.setString(12, a2.getText());
                        pst.setString(13, (String) q3.getSelectedItem());
                        pst.setString(14, a3.getText());
                       // pst.setString(15, (String) atype1.getSelectedItem());
                        if (q1.getSelectedItem().equals("- Select Question -")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (a1.getText().equals("")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (q2.getSelectedItem().equals("- Select Question -")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (a2.getText().equals("")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (q3.getSelectedItem().equals("- Select Question -")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (a3.getText().equals("")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (rpword.getText().equals(rpword.getText())) {

                            pst.execute();
                            JOptionPane.showMessageDialog(null, "New Admin Succesfully Save!");

                            refresh_tbladmin();
                            // AID.setText("ID"+a_date.getText()+a_time.getText());
                            user_clear();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect Password Match!!");

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else if (typ.equals("User")) {

                    try {
                        String sql = "Insert into tbl_user (AccountID, Name, Username, Password, Address, ContactNo, Type,Status, Q1, A1, Q2, A2, Q3, A3) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

                        pst.setString(1, AID.getText());
                        pst.setString(2, name.getText());
                        pst.setString(3, Uname.getText());
                        pst.setString(4, pword.getText());
                        pst.setString(5, add.getText());
                        pst.setString(6, con.getText());
                        pst.setString(7, (String) arole1.getSelectedItem());
                        pst.setString(8, "Active");
                        pst.setString(9, (String) q1.getSelectedItem());
                        pst.setString(10, a1.getText());
                        pst.setString(11, (String) q2.getSelectedItem());
                        pst.setString(12, a2.getText());
                        pst.setString(13, (String) q3.getSelectedItem());
                        pst.setString(14, a3.getText());
                        //pst.setString(13, (String) atype1.getSelectedItem());
                        if (q1.getSelectedItem().equals("- Select Question -")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (a1.getText().equals("")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (q2.getSelectedItem().equals("- Select Question -")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (a2.getText().equals("")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (q3.getSelectedItem().equals("- Select Question -")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (a3.getText().equals("")) {

                            JOptionPane.showMessageDialog(null, "Personal Security Q&A Information is required Please Check!! ");
                        } else if (rpword.getText().equals(rpword.getText())) {

                            pst.execute();
                            JOptionPane.showMessageDialog(null, "New User Succesfully Save!");

                            refresh_tbluser();
                            //AID.setText("ID"+a_date.getText()+a_time.getText());
                            user_clear();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect Password Match!!");

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Please Select UserType or Role");

                }

            }

        } else {
        }
    }//GEN-LAST:event_aupdateActionPerformed

    private void aclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aclearActionPerformed
        // TODO add your handling code here:
        if (aclear.getText().equals("CANCEL")) {
            user_clear();
            aupdate.setText("SAVE");
        }
        if (aclear.getText().equals("CLEAR")) {
            user_clear();
        }
    }//GEN-LAST:event_aclearActionPerformed

    private void assearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assearchActionPerformed

    private void CSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSaveActionPerformed
      
        if(CSave.getText() == "SAVE"){
      
          JFrame frame = new JFrame();
        String[] options = new String[2];
        options[0] = new String("Member");
        options[1] = new String("Non-Member");
 if (CID.getText().equals("[Click to Generate ID]"))
                        {
                        JOptionPane.showMessageDialog(null, "Ivalid ID");
                        }else{
        int p = JOptionPane.showOptionDialog(frame.getContentPane(), "Save as?", "Saving Option", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if (p == 0) {
            
            try {
                        String sql = "Insert into tbl_clientinfo (ClientID, Member, Lname, MName, Fname, Number_Street, City, State, Zipcode, Email, Gender, Marital_State, Home, Work, Cell, Spouse_Home, Spouse_Work, Spouse_Cell, EC_Name, EC_Contact, Refer, Physician, If_Yes, Conditions) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        
                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

                        pst.setString(1, CID.getText());
                        pst.setString(2, "Member");
                        pst.setString(3, CLast.getText());
                        pst.setString(4, CMiddle.getText());
                        pst.setString(5, CLast.getText());
                        pst.setString(6, CStreet.getText());
                        pst.setString(7, CCity.getText());
                        pst.setString(8,CState.getText());
                        pst.setString(9, CZip.getText());
                        pst.setString(10, CEmail.getText());
                        pst.setString(11, (String) CGender1.getSelectedItem());
                        pst.setString(12, (String) CMarital.getSelectedItem());
                        pst.setString(13, CPHome.getText());
                        pst.setString(14, CPWork.getText());
                        pst.setString(15, CPCell.getText());
                        pst.setString(16, CSHome.getText());
                        pst.setString(17, CSWork.getText());
                        pst.setString(18, CSCell.getText());
                        pst.setString(19, CEMName.getText());
                        pst.setString(20, CEMContact.getText());
                        pst.setString(21, CRefer.getText());
                        pst.setString(22, (String)CBMedical.getSelectedItem());
                        pst.setString(23, CIFyes.getText());
                        pst.setString(24, CConditions.getText());
                        
                        int add = pst.executeUpdate();
                            if(add!=0){
                                JOptionPane.showMessageDialog(null,"New member group successfully saved!");
                                clear_client();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Error saving please check!");
                               
                            }
                        
            } catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex);
                    }
            
       
        }if (p == 1) {
            try {
                        String sql = "Insert into tbl_clientinfo (ClientID, Member, Lname, MName, Fname, Number_Street, City, State, Zipcode, Email, Gender, Marital_State, Home, Work, Cell, Spouse_Home, Spouse_Work, Spouse_Cell, EC_Name, EC_Contact, Refer, Physician, If_Yes, Conditions) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

                        pst.setString(1, CID.getText());
                        pst.setString(2, "Non-Member");
                        pst.setString(3, CLast.getText());
                        pst.setString(4, CMiddle.getText());
                        pst.setString(5, CLast.getText());
                        pst.setString(6, CStreet.getText());
                        pst.setString(7, CCity.getText());
                        pst.setString(8,CState.getText());
                        pst.setString(9, CZip.getText());
                        pst.setString(10, CEmail.getText());
                        pst.setString(11, (String) CGender1.getSelectedItem());
                        pst.setString(12, (String) CMarital.getSelectedItem());
                        pst.setString(13, CPHome.getText());
                        pst.setString(14, CPWork.getText());
                        pst.setString(15, CPCell.getText());
                        pst.setString(16, CSHome.getText());
                        pst.setString(17, CSWork.getText());
                        pst.setString(18, CSCell.getText());
                        pst.setString(19, CEMName.getText());
                        pst.setString(20, CEMContact.getText());
                        pst.setString(21, CRefer.getText());
                        pst.setString(22, (String)CBMedical.getSelectedItem());
                        pst.setString(23, CIFyes.getText());
                        pst.setString(24, CConditions.getText());
                        int add = pst.executeUpdate();
                            if(add!=0){
                                JOptionPane.showMessageDialog(null,"New non-member group successfully saved!");
                            clear_client();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Error saving please check!");
                               
                            }
            } catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex);
                    }
        }}
          
          
      }else{
      
          
          try {
                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_clientinfo SET   Lname=?, MName=?, Fname=?, Number_Street=?, "
                                + "City=?, State=?, Zipcode=?, Email=?, Gender=?, Marital_State=?, Home=?, Work=?, Cell=?, Spouse_Home=?, Spouse_Work=?, Spouse_Cell=?, EC_Name=?, EC_Contact=?, Refer=?, "
                                + "Physician=?, If_Yes=?, Conditions=? WHERE ClientID='" + CID.getText() + "'");
                       
                      
                        pst.setString(1, CLast.getText());
                        pst.setString(2, CMiddle.getText());
                        pst.setString(3, CLast.getText());
                        pst.setString(4, CStreet.getText());
                        pst.setString(5, CCity.getText());
                        pst.setString(6,CState.getText());
                        pst.setString(7, CZip.getText());
                        pst.setString(8, CEmail.getText());
                        pst.setString(9, (String) CBMedical.getSelectedItem());
                        pst.setString(10, (String) CMarital.getSelectedItem());
                        pst.setString(11, CPHome.getText());
                        pst.setString(12, CPWork.getText());
                        pst.setString(13, CPCell.getText());
                        pst.setString(14, CSHome.getText());
                        pst.setString(15, CSWork.getText());
                        pst.setString(16, CSCell.getText());
                        pst.setString(17, CEMName.getText());
                        pst.setString(18, CEMContact.getText());
                        pst.setString(19, CRefer.getText());
                        pst.setString(20, (String)CBMedical.getSelectedItem());
                        pst.setString(21, CIFyes.getText());
                        pst.setString(22, CConditions.getText());
                         int update = pst.executeUpdate();
                        if (update != 0) {
                            
                            JOptionPane.showMessageDialog(null,"Account ID '"+CID.getText()+"' Updated!");
                             clear_client();
                        }else{
                        
                        JOptionPane.showMessageDialog(null,"Account ID '"+CID.getText()+"' Update Error!");
                        }
                    } catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex);
                    } 
      }
        
    }//GEN-LAST:event_CSaveActionPerformed

    private void CIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CIDMouseClicked
        if (CID.getText().equals("[Click to Generate ID]")) {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hmmss");
            SimpleDateFormat st = new SimpleDateFormat("MMddyyyy");
            CID.setText("EID" + st.format(d) + s.format(d));
        } else {

        }
    }//GEN-LAST:event_CIDMouseClicked

    private void assexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assexActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void asdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asdateActionPerformed

    private void asnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asnameActionPerformed

    private void asaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asaddressActionPerformed

    private void asidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asidActionPerformed

    private void assealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assealActionPerformed

    private void asblodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asblodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asblodActionPerformed

    private void asmaritalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asmaritalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asmaritalActionPerformed

    private void asdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asdActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        clear_client();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btngrpappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrpappActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btngrpappActionPerformed

    private void AID1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AID1MouseClicked
       if (AID1.getText().equals("[Click to Generate Number]")) {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hmmss");
            SimpleDateFormat st = new SimpleDateFormat("MMddyyyy");
            AID1.setText("AID" + st.format(d) + s.format(d));
        } else {
JOptionPane.showMessageDialog(null,"System error please check");
        }
    }//GEN-LAST:event_AID1MouseClicked

    private void AID2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AID2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AID2MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        
        if(AID1.getText().equals("[Click to Generate Number]")){
             JOptionPane.showMessageDialog(null, "Please Generate ID First!");
        }else{
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
                    String date1 = sdf.format(ADate.getDate());
                    
                    // availablefromT.setText(date);     
                    // JOptionPane.showMessageDialog(null, "date"+date);

    
       try{
           
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_availabilty WHERE Date= '" + date1 + "'");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String Time = rs.getString("Time");
                    if (Atime.getSelectedItem().equals(Time)){
                        JOptionPane.showMessageDialog(null, "Error Saving!! Time from the date selected already exist");
                    
                    }else{
                     
           
            SimpleDateFormat st = new SimpleDateFormat("MMM-dd-yyyy");
            //pst.setString(2, st.format(ADate.getDate()));
            if (AID1.getText().equals("[Click to Generate Number]")){
                  JOptionPane.showMessageDialog(null, "Invalid AID please click to generate");
            }else{
          
        String sql11 = "INSERT INTO tbl_availabilty VALUES (?,?,?,?)";
                    pst = (PreparedStatement) conn.prepareStatement(sql11);
                    pst.setString(1,AID1.getText());
                    pst.setString(2, st.format(ADate.getDate()));
                    pst.setString(3,(String)Atime.getSelectedItem());
                    pst.setString(4,Aremarks.getText());
                    int add = pst.executeUpdate();
                            if(add!=0){
                                clear_avail();
                                refresh_Availabilty();
                                JOptionPane.showMessageDialog(null, "New schedule saved successfully!!");
                            }else{JOptionPane.showMessageDialog(null, "Error schedule saving!!");}
            
            }
                    
                    }
                    }
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
           
       
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
            refresh_appointment_service();
            SMS.setVisible(false);
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(true);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
                clear_receipt();
                try{
             String sql1 = "SELECT * From tbl_appointment WHERE Date='"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            astable.setModel(DbUtils.resultSetToTableModel(rs));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
            
            Refresh_Asched();
            refresh_Availabilty();
            SMS.setVisible(false);
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(true);
        Checkup.setVisible(false);
        serv.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
            SMS.setVisible(false);
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(true);
        
        try {
            
            String sql = "SELECT * From tbl_appointment_removed where ActStat = '"+"Removed"+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tbl_srv_month.setModel(DbUtils.resultSetToTableModel(rs));
            // astable.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        try {
            
            String sql = "SELECT * From tbl_appointment_removed where Status = '"+"Rescheduled"+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tbl_rm_serve.setModel(DbUtils.resultSetToTableModel(rs));
            // astable.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        try {
            
            String sql = "SELECT * From tbl_appointment_removed where ActStat = '"+"Served"+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tbl_rdasg.setModel(DbUtils.resultSetToTableModel(rs));
            // astable.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void txtusernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_admin WHERE Username= '" + txtusername.getText() + "' and Password= '" + txtpassword.getText() + "' ");
            rs = pst.executeQuery();

            if (rs.next()) {
                String add3 = rs.getString("Status");
                if (add3.contentEquals("Active")) {
                    loggedin();
                    //jLabel11.setIcon().getDefaultToolkit().getImage(getClass().getResource("tile.png")));

                } else if (add3.contentEquals("Inactive")) {
                    JOptionPane.showMessageDialog(null, "Account deactivated");

                }
            } else {
                pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_user WHERE Username= '" + txtusername.getText() + "' and Password= '" + txtpassword.getText() + "' ");
                rs = pst.executeQuery();

                if (rs.next()) {
                    String add3 = rs.getString("Status");
                    if (add3.contentEquals("Active")) {
                        loggedin();

                    } else if (add3.contentEquals("Inactive")) {
                        JOptionPane.showMessageDialog(null, "Account deactivated");

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Incorrect Username/Password Match!!!");
                }
            }
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x);
        }
        
        }
    }//GEN-LAST:event_txtusernameKeyReleased

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           
        try {
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_admin WHERE Username= '" + txtusername.getText() + "' and Password= '" + txtpassword.getText() + "' ");
            rs = pst.executeQuery();

            if (rs.next()) {
                String add3 = rs.getString("Status");
                if (add3.contentEquals("Active")) {
                    loggedin();
                    //jLabel11.setIcon().getDefaultToolkit().getImage(getClass().getResource("tile.png")));

                } else if (add3.contentEquals("Inactive")) {
                    JOptionPane.showMessageDialog(null, "Account deactivated");

                }
            } else {
                pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_user WHERE Username= '" + txtusername.getText() + "' and Password= '" + txtpassword.getText() + "' ");
                rs = pst.executeQuery();

                if (rs.next()) {
                    String add3 = rs.getString("Status");
                    if (add3.contentEquals("Active")) {
                        loggedin();

                    } else if (add3.contentEquals("Inactive")) {
                        JOptionPane.showMessageDialog(null, "Account deactivated");

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Incorrect Username/Password Match!!!");
                }
            }
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x);
        }
        
        }
    }//GEN-LAST:event_txtpasswordKeyReleased

    private void saclietsellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saclietsellActionPerformed
         if (saclietsell.isSelected() == true){
                sa_refresh_list();
                satoday.setSelected(false);
                jCheckBox3.setSelected(false);
        }else{
        refresh_appointment();
        
        }
    }//GEN-LAST:event_saclietsellActionPerformed

    private void sasaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sasaveActionPerformed
        
      
        
        if (said.getText().equals("")){ 
           
       }else{
        try{
            
            
        if (sasave.getText().equals("SAVE")){
            
             pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_appointment WHERE Date= '" + sadate.getText() + "'");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String Time = rs.getString("Time");
                    if (satime1.getText().equals(Time)){
                        JOptionPane.showMessageDialog(null, "Error Saving!! Time from the date selected already set to other client");
                    
                    }else{
             if (btngrpapp2.isSelected() == true && btngrpapp.isSelected() == false){
             
        String sql1 = "INSERT INTO tbl_appointment(ClientID,Member,Fullname,Date,Time,Message,Status,Contact,Datereserved) VALUES (?,?,?,?,?,?,?,?,?)";
//        Date date = sadate.getDate();
//        String strdate = DateFormat.getDateInstance().format(date);
                            pst = (PreparedStatement) conn.prepareStatement(sql1);
                            pst.setString(1,said.getText());
                            pst.setString(2,samem.getText());
                            pst.setString(3, saname.getText());
                            pst.setString(4,sadate.getText());
                            pst.setString(5,satime1.getText());
                            pst.setString(6,samessage.getText());
                            pst.setString(7,"Scheduled");
                            pst.setString(8 ,contact.getText());
                            pst.setString(9 ,s_date.getText());


                            int add = pst.executeUpdate();
                            if(add!=0){
                                if (saclietsell.isSelected() == true){
                                     sentsms();
                            sa_refresh_list();
                            clear_app();
                              JOptionPane.showMessageDialog(null,"New Appointment saved successfully");
                              saclietsell.setSelected(false);
                            
                              
                              
                            }else{
                                    sentsms();
                            refresh_appointment();
                             clear_app();
                              //JOptionPane.showMessageDialog(null,"New Appointment saved successfully");
                              saclietsell.setSelected(false);  
                              
                             }

                            } else{
                                JOptionPane.showMessageDialog(null,"Appointment set failed! Please Check");
                            }
             }else if (btngrpapp.isSelected() == true && btngrpapp2.isSelected() == false) {
                     String sql1 = "INSERT INTO tbl_appointment(ClientID,Member,Fullname,Date,Time,Message,Status,Datereserved) VALUES (?,?,?,?,?,?,?,?)";

                            pst = (PreparedStatement) conn.prepareStatement(sql1);
                            pst.setString(1,said.getText());
                            pst.setString(2,samem.getText());
                            pst.setString(3, saname.getText());
                            pst.setString(4,sadate.getText());
                            pst.setString(5,satime1.getText());
                            pst.setString(6,samessage.getText());
                            pst.setString(7,"Rescheduled");
                            pst.setString(8,s_date.getText());

                            int add = pst.executeUpdate();
                            if(add!=0){
                                if (saclietsell.isSelected() == true){
                                     sentsms();
                            sa_refresh_list();
                            clear_app();
                            saclietsell.setSelected(false);
                            JOptionPane.showMessageDialog(null,"Rescheduled appointment saved successfully");
                            }else{
                                    sentsms();
                            refresh_appointment();
                              clear_app();
                            saclietsell.setSelected(false);
                            
                           // JOptionPane.showMessageDialog(null,"Rescheduled appointment saved successfully");
                           
                             }

                            } else{
                                JOptionPane.showMessageDialog(null,"Appointment set failed! Please Checkk");
                            }
                 
             }}}               
                            
        }else  if (sasave.getText().equals("UPDATE")){
            
           if(btngrpapp.isSelected() == true && btngrpapp2.isSelected() == false){
           
               
                try {
                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_appointment SET  Date=?,Time=?,Message=?,Status=? WHERE ClientID='" + said.getText() + "'");
                       
                        pst.setString(1, sadate.getText());
                        pst.setString(2, satime1.getText());
                        pst.setString(3, samessage.getText());
                        pst.setString(4, "Rescheduled");
                        
                         int update = pst.executeUpdate();
                        if (update != 0) {
                           
                            JOptionPane.showMessageDialog(null,"Custmer with '"+said.getText()+"' Updated!");
                            //sa_refresh_list();    
                            refresh_appointment();
                            clear_app();
                           sasave.setText("SAVE");
                        }else{
                        JOptionPane.showMessageDialog(null,"Customer with '"+said.getText()+"' Update Error!");
                        }
                    } catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex);
                    } 
               
               
               
           } else if (btngrpapp2.isSelected() == true && btngrpapp.isSelected() == false){
        
               try {
                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_appointment SET  Date=?,Time=?,Message=?,Status=? WHERE ClientID='" + said.getText() + "'");
                       
                        pst.setString(1, sadate.getText());
                        pst.setString(2, satime1.getText());
                        pst.setString(3, samessage.getText());
                        pst.setString(4, "Scheduled");
                        
                         int update = pst.executeUpdate();
                        if (update != 0) {
                           
                            JOptionPane.showMessageDialog(null,"Custmer with '"+said.getText()+"' Updated!");
                            refresh_appointment();
                            clear_app();
                           sasave.setText("SAVE");
                        }else{
                        JOptionPane.showMessageDialog(null,"Customer with '"+said.getText()+"' Update Error!");
                        }
                    } catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex);
                    } 
               
        }
           
        }
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Client schedule duplication is not valid!");}}
    }//GEN-LAST:event_sasaveActionPerformed

    private void sasave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sasave1ActionPerformed
clear_app();        
    }//GEN-LAST:event_sasave1ActionPerformed

    private void satableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_satableMouseClicked
      try{
           if (saclietsell.isSelected()==true){
            int z = satable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) satable.getModel();
            String lname = model.getValueAt(z,2).toString();
            String fname = model.getValueAt(z,3).toString();
            String mname = model.getValueAt(z,4).toString();
            contact.setText(model.getValueAt(z,14).toString());
            said.setText(model.getValueAt(z,0).toString());
            samem.setText(model.getValueAt(z,1).toString());
            saname.setText(fname+" "+mname+" "+lname);
        }else if (jCheckBox3.isSelected()==true){
            int z = satable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) satable.getModel();
            String Date= model.getValueAt(z,1).toString();
            String Time = model.getValueAt(z,2).toString();
            sadate.setText(Date);
            satime1.setText(Time);
            samessage.setText("");
            samessage.setFont(new Font("Monospaced",Font.PLAIN,11));
            //g2d.drawString("      "+jLabel20.get+"            ",10,y);y+=yShift;
            samessage.setText("Dear client\n\n");
            samessage.setText(samessage.getText() +"Your schedule has been set");
            samessage.setText(samessage.getText()+" on "+sadate.getText()+" and time "+satime1.getText()+"\n");
            samessage.setText(samessage.getText() +"Please come early!\n\n");
            samessage.setText(samessage.getText() +"Thank you\n\n");
            samessage.setText(samessage.getText() +"System Generated do not reply\n");
            samessage.setText(samessage.getText() +"Dole clinic");

        }else {
            if (sarem.getText()=="Show Removed"){
            clear_app();
            
              JFrame frame = new JFrame();
        String[] options = new String[2];
        options[0] = new String("Update");
        options[1] = new String("Remove");
         int p = JOptionPane.showOptionDialog(frame.getContentPane(), "Option", "Please selection option!", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if (p == 0) {
            sasave.setText("UPDATE");
        int z = satable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) satable.getModel();
            said.setText(model.getValueAt(z,0).toString());
            saname.setText(model.getValueAt(z,2).toString());
            samem.setText(model.getValueAt(z,1).toString());
            String sched = model.getValueAt(z,6).toString();
            if (sched.contentEquals("Scheduled")){
             btngrpapp.setSelected(false);
                btngrpapp2.setSelected(true);
            }else if(sched.contentEquals("Rescheduled")){
                btngrpapp.setSelected(true);
                btngrpapp2.setSelected(false);
        }
            sadate.setText(model.getValueAt(z,3).toString());
            satime1.setText(model.getValueAt(z,4).toString());
            samessage.setText(model.getValueAt(z,5).toString());
        }else if (p == 1){
            
            int z = satable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) satable.getModel();
            String ID = model.getValueAt(z,0).toString();
            

                try{
                    String sql1 = "INSERT INTO tbl_appointment_removed (ClientID, Member, Fullname, Date, Time, Message, Status, Contact, Datereserved) SELECT * FROM tbl_appointment Where ClientID = '"+ID+"'";
            
           pst = (PreparedStatement) conn.prepareStatement(sql1);
              pst.executeUpdate();     pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_appointment_removed SET  ActStat=? WHERE ClientID='" + ID + "'");

                        pst.setString(1,"Removed");

                        int update = pst.executeUpdate();
                        if (update != 0) {
                      
                                  pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM tbl_appointment WHERE ClientID='" + ID + "'");
                                   int del11 =  pst.executeUpdate();
                                   if(del11 >0){
                                       JOptionPane.showMessageDialog(null, "Data Removed");
                                       refresh_appointment();
                                }}
                            }catch(SQLException e){ JOptionPane.showMessageDialog(null, e);}
             
       }    
        }else{}
        }
       
        
      } catch(Exception e){
      
      }
    }//GEN-LAST:event_satableMouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try{
        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_clientinfo WHERE ClientID = '" + said.getText() + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                String Contact = rs.getString("Home");
       SMS send = new SMS();
       send.SendSMS("customer002", "customer002!@#", samessage.getText(), Contact, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");     
       JOptionPane.showMessageDialog(null,"Message Sent to "+Contact);
            }else {
            
            JOptionPane.showMessageDialog(null,"Error Sending message");
            }
            }catch(Exception e){JOptionPane.showMessageDialog(null,"Message sent failed");}
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
     if (jCheckBox3.isSelected() == true){
     saclietsell.setSelected(false);
     satoday.setSelected(false);
     refresh_Availabilty_app();
     }else{
     refresh_appointment();
     saclietsell.setSelected(false);
     satoday.setSelected(false);
     }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void csearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csearchKeyReleased
        try {
                String sql = "Select ClientID,Member,LName,Mname,Fname,Number_Street,City,State,Zipcode,Email,Gender,Marital_State,"
                        + "Home,Work,Cell,Spouse_Home,Spouse_Work,Spouse_Cell,EC_Contact,Refer,Physician,If_yes,Conditions from tbl_clientinfo "
                        + "where ClientID like ? or Member like ? or LName like ? or MName like ? or FName like ?";
                
                pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
                
                pst.setString(1, "%" + csearch.getText() + "%"); 
                pst.setString(2, "%" + csearch.getText() + "%"); 
                pst.setString(3, "%" + csearch.getText() + "%");  
                pst.setString(4, "%" + csearch.getText() + "%");  
                pst.setString(5, "%" + csearch.getText() + "%");  
                rs = (ResultSet) pst.executeQuery();
                tbl_client_list.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
    }//GEN-LAST:event_csearchKeyReleased

    private void AtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtableMouseClicked
             JFrame frame = new JFrame();
        String[] options = new String[2];
        options[0] = new String("Edit");
        options[1] = new String("Remove");
        int p = JOptionPane.showOptionDialog(frame.getContentPane(), "Option", "Please selection option!", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if (p == 0) {
            //SimpleDateFormat st = new SimpleDateFormat("MMM-dd-yyyy");
            //pst.setString(2, st.format(ADate.getDate()));
            int z = Atable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) Atable.getModel();
           
            //String Remarks  = model.getValueAt(z,4).toString();
            AID1.setText(model.getValueAt(z,0).toString());
            //ADate.setDate(st.format(Remarks));
            Atime.setSelectedItem(model.getValueAt(z,2).toString());
            Aremarks.setText(model.getValueAt(z,3).toString());
           // jButton15.setText("Update");
        }else if (p == 1){
            if (acctype.getText().equals("User")){
            JOptionPane.showMessageDialog(null, "Invalid user field");
            }else{
            try{
                int z = Atable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) Atable.getModel();
           
            String ID  = model.getValueAt(z,0).toString();
               // pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM tbl_stock_request  WHERE ProductID = '" + ID + "'");
                    JFrame frame3 = new JFrame();
                                    String[] options3 = new String[2];
                                    options3[0] = new String("Continue");
                                    options3[1] = new String("Cancel");
                                      int p3 = JOptionPane.showOptionDialog(frame3.getContentPane(),"Are you sure you want to remove stock in request?","Confirmation Stock Request", 0,JOptionPane.INFORMATION_MESSAGE,null,options3,null);
                                      if (p3==0){
                                      pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM tbl_availabilty  WHERE AID = '" + ID + "'");
                                        pst.executeUpdate();
                                        JOptionPane.showMessageDialog(null, "Schedule Removed!");
                                        clear_avail();
                                        refresh_Availabilty();
                                      }else if (p3 == 1){
                                      frame3.dispose();
                                      }
            
            }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
    }}
                  
    }//GEN-LAST:event_AtableMouseClicked

    private void tbl_client_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_client_listMouseClicked
        JFrame frame = new JFrame();
        String[] options = new String[2];
        options[0] = new String("Update");
        options[1] = new String("Remove");
        
        
        int z = tbl_client_list.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tbl_client_list.getModel();
           
            String ID  = model.getValueAt(z,0).toString();
        
       
        int p = JOptionPane.showOptionDialog(frame.getContentPane(), "Option", "Please selection option!", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if (p == 0) {
            
            //Fill for update
                       int y = tbl_client_list.getSelectedRow();
        TableModel modell = tbl_client_list.getModel();
        
        CID.setText(modell.getValueAt(y, 0).toString());
        CLast.setText(modell.getValueAt(y, 2).toString());
        CMiddle.setText(modell.getValueAt(y, 3).toString());
        CFirst.setText(modell.getValueAt(y, 4).toString());
        CStreet.setText(modell.getValueAt(y, 5).toString());
        CCity.setText(modell.getValueAt(y, 6).toString());
        CState.setText(modell.getValueAt(y, 7).toString());
        CZip.setText(modell.getValueAt(y, 8).toString());
        CEmail.setText(modell.getValueAt(y, 9).toString());
        CGender1.setSelectedItem(modell.getValueAt(y, 10).toString());
        CMarital.setSelectedItem(modell.getValueAt(y, 11).toString());
        CPHome.setText(modell.getValueAt(y, 12).toString());
        CPWork.setText(modell.getValueAt(y, 13).toString());
        CPCell.setText(modell.getValueAt(y, 14).toString());
        CSHome.setText(modell.getValueAt(y, 15).toString());
        CSWork.setText(modell.getValueAt(y, 16).toString());
        CSCell.setText(modell.getValueAt(y, 17).toString());
        CEMName.setText(modell.getValueAt(y, 18).toString());
        CEMContact.setText(modell.getValueAt(y, 19).toString());
        CRefer.setText(modell.getValueAt(y, 20).toString());
        CBMedical.setSelectedItem(modell.getValueAt(y, 21).toString());
        CIFyes.setText(modell.getValueAt(y, 22).toString());
        CConditions.setText(modell.getValueAt(y, 23).toString());
        
        //Switch to update
        Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(true);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
            
          CSave.setText("UPDATE"); 
            
        }else if (p == 1){
            
            if (acctype.getText().equals("User")){
            JOptionPane.showMessageDialog(null, "Invalid user field");
            }else{
            JFrame frame3 = new JFrame();
                                    String[] options3 = new String[2];
                                    options3[0] = new String("Continue Remove");
                                    options3[1] = new String("Cancel");
                                      int p3 = JOptionPane.showOptionDialog(frame3.getContentPane(),"Continue remove list?","Option", 0,JOptionPane.INFORMATION_MESSAGE,null,options3,null);
                                      if (p3==0){
                                          
                                           try{
                                      pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM tbl_clientinfo  WHERE ClientID = '" + ID + "'");
                                        int a = pst.executeUpdate();
                                        if (a!=0){
                                        refresh_list();
                                        JOptionPane.showMessageDialog(null, "Schedule Removed!");
                                        }else{
                                        JOptionPane.showMessageDialog(null, "Error!");
                                        }
                                        }catch(Exception E){JOptionPane.showMessageDialog(null, E);}
                                      }else if(p3==1){
                                      
                                      }
                                     
        }    
                            }
        
        
        
    }//GEN-LAST:event_tbl_client_listMouseClicked

    private void csearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_csearchKeyPressed

    private void jTextField41KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField41KeyReleased
        
        
        if (saclietsell.isSelected()==true){
     try {
                String sql = "Select ClientID,Member,LName,Mname,Fname,Number_Street,City,State,Zipcode,Email,Gender,Marital_State,"
                        + "Home,Work,Cell,Spouse_Home,Spouse_Work,Spouse_Cell,EC_Contact,Refer,Physician,If_yes,Conditions from tbl_clientinfo "
                        + "where ClientID like ? or Member like ? or LName like ? or MName like ? or FName like ?";
                
                pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
                
                pst.setString(1, "%" + jTextField41.getText() + "%"); 
                pst.setString(2, "%" + jTextField41.getText() + "%"); 
                pst.setString(3, "%" + jTextField41.getText() + "%");  
                pst.setString(4, "%" + jTextField41.getText() + "%");  
                pst.setString(5, "%" + jTextField41.getText() + "%");  
                rs = (ResultSet) pst.executeQuery();
                satable.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
     } else if (jCheckBox3.isSelected()==true){
    
    try{
                         String sql = "SELECT * FROM tbl_availabilty WHERE Date like ?";
                        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
                        pst.setString(1, "%" + jTextField41.getText() + "%");
                        rs = (ResultSet) pst.executeQuery();
                        satable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
                
    }else if (satit.getText().equals("Appointment Schedule Removed")){
   // JOptionPane.showConfirmDialog(null, "Appointment field Remove");
            try {
                String sql = "Select * from tbl_appointment_removed where ClientID like ? or Member like ? or Fullname like ?";
                
                pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
                
                pst.setString(1, "%" + assearch.getText() + "%"); 
                pst.setString(2, "%" + assearch.getText() + "%"); 
                pst.setString(3, "%" + assearch.getText() + "%");
                rs = (ResultSet) pst.executeQuery();
                astable.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
    }else{
        //JOptionPane.showMessageDialog(null, "Appointment field");
      try {
                String sql = "Select * from tbl_appointment where ClientID like ? or Member like ? or Fullname like ?";
                
                pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
                
                pst.setString(1, "%" + assearch.getText() + "%"); 
                pst.setString(2, "%" + assearch.getText() + "%"); 
                pst.setString(3, "%" + assearch.getText() + "%");
                rs = (ResultSet) pst.executeQuery();
                satable.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }
       
    }//GEN-LAST:event_jTextField41KeyReleased

    private void saremAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_saremAncestorAdded
        
        
        
    }//GEN-LAST:event_saremAncestorAdded

    private void saremMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saremMouseClicked
       if (sarem.getText().equals("Show Removed")){
        refresh_rem();
        satoday.setSelected(false);
        saclietsell.setSelected(false);
        jCheckBox3.setSelected(false);
        sarem.setText("Show App List");
        }else{
        sarem.setText("Show Removed");
        if (saclietsell.isSelected() == true){
                sa_refresh_list();
                satoday.setSelected(false);
       // saclietsell.setSelected(false);
        jCheckBox3.setSelected(false);
               
        }else{
        refresh_appointment();
        satoday.setSelected(false);
        saclietsell.setSelected(false);
        jCheckBox3.setSelected(false);
        //refresh_sched();
        }
          
        }
    }//GEN-LAST:event_saremMouseClicked

    private void astableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_astableMouseClicked
       if(aswalkin.isSelected()==true){
         int c1 = astable.getSelectedRow();
           DefaultTableModel model11 = (DefaultTableModel) astable.getModel();
            String cid = (model11.getValueAt(c1,0).toString());
            //String fullname1 = (lname1+""+mname1+""+fname1);
           try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT ClientID,Fullname FROM tbl_appointment WHERE ClientID = '" + cid + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                        
                        String fullname = (rs.getString("Fullname"));
                        String ID = (rs.getString("ClientID"));
                       
                            if (cid.equals(ID)){
                            JOptionPane.showMessageDialog(null,"Unable to continue, Client "+fullname+" has already on appointment schedule");
                            }
                        
                    }
                    else{
                          //JOptionPane.showMessageDialog(null,"System Error Please check");
                           int c = astable.getSelectedRow();
                DefaultTableModel model1 = (DefaultTableModel) astable.getModel();
            asid.setText( model1.getValueAt(c,0).toString());
            String lname = model1.getValueAt(c,2).toString();
            String mname = model1.getValueAt(c,3).toString();
            String fname = model1.getValueAt(c,4).toString();
            asaddress.setText( model1.getValueAt(c,5).toString());
            assex.setText( model1.getValueAt(c,10).toString());
            asmarital.setText( model1.getValueAt(c,11).toString());
            asname.setText(lname+" "+mname+" "+fname);
                    }
                    
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
       
        
    }else if(aswalkin.isSelected()==false){
        
        int c = astable.getSelectedRow();
        DefaultTableModel model1 = (DefaultTableModel) astable.getModel();
            String id = model1.getValueAt(c,0).toString();    
        JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Remove from list");
            options[1] = new String("Select");
            int p = JOptionPane.showOptionDialog(frame.getContentPane(),"Select Option","Client Selection Option", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
            if(p==0){
                try{
                    String sql1 = "INSERT INTO tbl_appointment_removed (ClientID, Member, Fullname, Date, Time, Message, Status, Contact, Datereserved) SELECT * FROM tbl_appointment Where ClientID = '"+id+"'";
            
           pst = (PreparedStatement) conn.prepareStatement(sql1);
              pst.executeUpdate();     pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_appointment_removed SET  ActStat=? WHERE ClientID='" + id + "'");

                        pst.setString(1,"Removed");

                        int update = pst.executeUpdate();
                        if (update != 0) {
                      
                                  pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM tbl_appointment WHERE ClientID='" + id + "'");
                                   int del11 =  pst.executeUpdate();
                                   if(del11 >0){
                                       JOptionPane.showMessageDialog(null, "Data Removed");
                                       clear_serv();
                                        refresh_appointment_service();
                                        clear_receipt();
                                }}
                            }catch(SQLException e){ JOptionPane.showMessageDialog(null, e);}
            }else if (p==1){
        int z = astable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) astable.getModel();
            asid.setText(model.getValueAt(z,0).toString());
            asname.setText(model.getValueAt(z,2).toString());
            asdate.setText(model.getValueAt(z,8).toString());
                            

            try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Number_Street,CIty,Marital_State,Gender FROM tbl_clientinfo WHERE ClientID = '" + asid.getText() + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                        String address = rs.getString("Number_Street");
                        String city = rs.getString("City");
                        asaddress.setText(address+""+city);
                        String Marital = rs.getString("Marital_State");
                        asmarital.setText(Marital);
                        String sex = rs.getString("Gender");
                        assex.setText(sex);
                        clear_receipt();
                    }else{
                    
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}}}
    }//GEN-LAST:event_astableMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
      
        if (asyes.isSelected()==true && asno.isSelected()==false){ 
        try{
            Connection connn = MysqlConnection.ConnectDB();
            //JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\MIS.Hardware\\Documents\\NetBeansProjects\\Clinic_Management\\src\\clinic_management\\Med_Report.jrxml");
           JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Clinic_Management\\src\\clinic_management\\Med_Report.jrxml");
           // String query = "SELECT * FROM tbl_items";
            JRDesignQuery jrquery = new JRDesignQuery();
            //jrquery.setText(query);
            JasperReport jr = JasperCompileManager.compileReport(jasperDesign);
            jasperDesign.setQuery(jrquery);
            HashMap para= new HashMap();
            
            para.put("name", asname.getText());
             para.put("gender", assex.getText());
             para.put("marital", asmarital.getText());
             para.put("address", asaddress.getText());
             para.put("blood type", asblod.getText());
             para.put("datetime", s_time.getText() +" "+ s_date.getText());
             para.put("a", asa.getSelectedItem());
             para.put("b", asb.getSelectedItem());
             para.put("c", asc.getSelectedItem());
             para.put("d", asd.getText());
             para.put("e", ase.getSelectedItem());
             para.put("f", asf.getSelectedItem());
             para.put("g", asg.getSelectedItem());
             para.put("h", ash.getSelectedItem());
             para.put("if","Yes");
            JasperPrint jp = JasperFillManager.fillReport(jr,para,connn);
            JasperPrintManager.printReport(jp, true);
            try{
           String sql1 = "INSERT INTO tbl_appointment_removed (ClientID, Member, Fullname, Date, Time, Message, Status, Contact, Datereserved) SELECT * FROM tbl_appointment Where ClientID = '"+said.getText()+"'";
            
           pst = (PreparedStatement) conn.prepareStatement(sql1);
              pst.executeUpdate();
              
            if (aswalkin.isSelected()==true){
                pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_Clientinfo WHERE ClientID= '" + asid.getText() + "'");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String contact1 = rs.getString("Cell");
                        String member = rs.getString("Member");
                        
                        String sql = "Insert into tbl_appointment_removed (ClientID,Member,Fullname,Date,Time,Message,Status,Contact,Datereserved,ActStat) values (?,?,?,?,?,?,?,?,?,?)";
                        
                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

                        pst.setString(1, asid.getText());
                        pst.setString(2, member);
                        pst.setString(3, asname.getText());
                        pst.setString(4, s_date.getText());
                        pst.setString(5, s_time.getText());
                        pst.setString(6, "N/A");
                        pst.setString(7, "WALKIN");
                        pst.setString(8, contact1);
                        pst.setString(9, s_date.getText());
                        pst.setString(10, "Served");
                        
                        int add1 = pst.executeUpdate();

                            if(add1!=0){
                                JOptionPane.showMessageDialog(null,"WALKIN Client Served");
                                 refresh_csalist();
                            }
                    }
            }else{             
            JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Remove from list");
            options[1] = new String("Stay on List");
            int p = JOptionPane.showOptionDialog(frame.getContentPane(),"Select Option","Client Selection Option", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
            if(p==0){
                  try{
                       pst = (PreparedStatement) conn.prepareStatement(sql1);
              pst.executeUpdate();     pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_appointment_removed SET  ActStat=? WHERE ClientID='" + asid.getText()  + "'");

                        pst.setString(1,"Served");

                        int update = pst.executeUpdate();
                        if (update != 0) {
                                  pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM tbl_appointment WHERE ClientID='" + asid.getText() + "'");
                                   int del11 =  pst.executeUpdate();
                                   if(del11 >0){
                                       JOptionPane.showMessageDialog(null, "Data Removed");
                                       clear_serv();
                                        refresh_appointment_service();
                                        if (aswalkin.isSelected()==true){
       refresh_csalist();
        }else{
        try{
             String sql11 = "SELECT * From tbl_appointment WHERE Date='"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql11);
            rs = pst.executeQuery();
            astable.setModel(DbUtils.resultSetToTableModel(rs));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
                                }}
                            }catch(SQLException e){ JOptionPane.showMessageDialog(null, e);}
            }else if(p==
                    1){
             if (aswalkin.isSelected()==true){
               refresh_csalist();
        }else{
        try{
             String sql13 = "SELECT * From tbl_appointment WHERE Date='"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql13);
            rs = pst.executeQuery();
            astable.setModel(DbUtils.resultSetToTableModel(rs));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
            }
            
            }        
            }catch(SQLException e){ JOptionPane.showMessageDialog(null, e);}
                            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        }else if (asno.isSelected()==true && asyes.isSelected()==false) {
        
         try{
            Connection connn = MysqlConnection.ConnectDB();
            //JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\MIS.Hardware\\Documents\\NetBeansProjects\\Clinic_Management\\src\\clinic_management\\Med_Report.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Clinic_Management\\src\\clinic_management\\Med_Report.jrxml");
    // String query = "SELECT * FROM tbl_items";
            JRDesignQuery jrquery = new JRDesignQuery();
            //jrquery.setText(query);
            JasperReport jr = JasperCompileManager.compileReport(jasperDesign);
            jasperDesign.setQuery(jrquery);
            HashMap para= new HashMap();
            
            para.put("name", asname.getText());
             para.put("gender", assex.getText());
             para.put("marital", asmarital.getText());
             para.put("address", asaddress.getText());
             para.put("blood type", asblod.getText());
             para.put("datetime", s_time.getText() +" "+ s_date.getText());
             para.put("a", asa.getSelectedItem());
             para.put("b", asb.getSelectedItem());
             para.put("c", asc.getSelectedItem());
             para.put("d", asd.getText());
             para.put("e", ase.getSelectedItem());
             para.put("f", asf.getSelectedItem());
             para.put("g", asg.getSelectedItem());
             para.put("h", ash.getSelectedItem());
             para.put("if","No");
            JasperPrint jp = JasperFillManager.fillReport(jr,para,connn);
            JasperPrintManager.printReport(jp, true);
            try{
           String sql1 = "INSERT INTO tbl_appointment_removed (ClientID, Member, Fullname, Date, Time, Message, Status, Contact, Datereserved) SELECT * FROM tbl_appointment Where ClientID = '"+said.getText()+"'";
            
           pst = (PreparedStatement) conn.prepareStatement(sql1);
              pst.executeUpdate();
                            
                if (aswalkin.isSelected()==true){
                    pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM tbl_Clientinfo WHERE ClientID= '" + asid.getText() + "'");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String contact1 = rs.getString("Cell");
                        String member = rs.getString("Member");
                        
                        String sql = "Insert into tbl_appointment_removed (ClientID,Member,Fullname,Date,Time,Message,Status,Contact,Datereserved,ActStat) values (?,?,?,?,?,?,?,?,?,?)";
                        
                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

                        pst.setString(1, asid.getText());
                        pst.setString(2, member);
                        pst.setString(3, asname.getText());
                        pst.setString(4, s_date.getText());
                        pst.setString(5, s_time.getText());
                        pst.setString(6, "N/A");
                        pst.setString(7, "WALKIN");
                        pst.setString(8, contact1);
                        pst.setString(9, s_date.getText());
                        pst.setString(10, "Served");
                        
                        int add1 = pst.executeUpdate();

                            if(add1!=0){
                                JOptionPane.showMessageDialog(null,"WALKIN Client Served");
                                 refresh_csalist();
                            }
                    }

            }else{
            
            
               JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Remove from list");
            options[1] = new String("Stay on List");
            int p = JOptionPane.showOptionDialog(frame.getContentPane(),"Select Option","Client Selection Option", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
            if(p==0){
                  try{
                       pst = (PreparedStatement) conn.prepareStatement(sql1);
              pst.executeUpdate();     pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_appointment_removed SET  ActStat=? WHERE ClientID='" + asid.getText()  + "'");

                        pst.setString(1,"Served");

                        int update = pst.executeUpdate();
                        if (update != 0) {
                                  pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM tbl_appointment WHERE ClientID='" + asid.getText() + "'");
                                   int del11 =  pst.executeUpdate();
                                   if(del11 >0){
                                       JOptionPane.showMessageDialog(null, "Data Removed");
                                       clear_serv();
                                        refresh_appointment_service();
                                        if (aswalkin.isSelected()==true){
               refresh_csalist();
        }else{
        try{
             String sql12 = "SELECT * From tbl_appointment WHERE Date='"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql12);
            rs = pst.executeQuery();
            astable.setModel(DbUtils.resultSetToTableModel(rs));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
                                }}
                            }catch(SQLException e){ JOptionPane.showMessageDialog(null, e);}
            }else if(p==1){
            if (aswalkin.isSelected()==true){
               refresh_csalist();
        }else{
        try{
             String sql13 = "SELECT * From tbl_appointment WHERE Date='"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql13);
            rs = pst.executeQuery();
            astable.setModel(DbUtils.resultSetToTableModel(rs));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
            }}
                    
            }catch(SQLException e){ JOptionPane.showMessageDialog(null, e);}
                            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        }else{
        JOptionPane.showMessageDialog(null, "Please select atleast one on yes or no option!");
        
        }
        
        
            
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       clear_serv();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void saidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saidActionPerformed

    private void astableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_astableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_astableMouseEntered

    private void btnsmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsmsActionPerformed
        if (smsid.getText().equals("[Click to Generate ID]")){
        JOptionPane.showMessageDialog(null,"Please Generate for sms ID first");
        }else{
        if (btnsms.getText().equals("Save")){
        
        try {
                        String sql = "Insert into tbl_smsacct (ID, Name, Username, Password) values (?, ?,?,?)";

                        pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);

                        pst.setString(1, smsid.getText());
                        pst.setString(2, smsname.getText());
                        pst.setString(3, smsuser.getText());
                        pst.setString(4, smspass.getText());
                        
                            int add = pst.executeUpdate();
                            if(add!=0){
                                    refresh_sms();
                                    clear_sms();
                            
                            }else{
                            JOptionPane.showMessageDialog(null,"Error saving!");
                            }
        }catch(SQLException e){JOptionPane.showMessageDialog(null,e);} 
        
        }else if (btnsms.getText().equals("Update")){
            try{
         pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_smsacct SET Name=?, Username=?, Password=? WHERE ID='" + smsid.getText() + "'");
                       
                        pst.setString(1, smsname.getText());
                        pst.setString(2, smsuser.getText());
                        pst.setString(3, smspass.getText());
                         int update = pst.executeUpdate();
                        if (update != 0) {
                           
                            JOptionPane.showMessageDialog(null,"Account Updated");
                            refresh_sms();
                             clear_sms();
                            btnsms.setText("Save");
                           // p_add.setText("Add");
                        }else{
                       
                        JOptionPane.showMessageDialog(null,"Error account update");
                        }
            }catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
        
        }}
    }//GEN-LAST:event_btnsmsActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        
        if(user.getText().contains("Please Login")){
        JOptionPane.showMessageDialog(null, "Please Login");
        }else{
        if (acctype.getText().equals("User")){
            JOptionPane.showMessageDialog(null, "Invalid user field");
            }else{
            Login.setVisible(false);
        Dashboard.setVisible(false);

        Account.setVisible(false);
        Addacc.setVisible(false);
        Manacc.setVisible(false);
        Acclist.setVisible(false);
        
        Patcon.setVisible(false);
        Service.setVisible(false);
        Client_List.setVisible(false);
        Setapp.setVisible(false);
        Avail.setVisible(false);
        Checkup.setVisible(false);
        serv.setVisible(false);
        payment.setVisible(false);
        Rpayment.setVisible(false);
        RAppoint.setVisible(false);
        SMS.setVisible(true);
        refresh_sms();
       // refresh_smslist();
        }}
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tbl_smsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_smsMouseClicked
          JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Update");
            options[1] = new String("Remove");
            int p = JOptionPane.showOptionDialog(frame.getContentPane(),"SMS Account","Selection Option", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
            if(p==0){
        int y = tbl_sms.getSelectedRow();
        TableModel modell = tbl_sms.getModel();
        smsid.setText(modell.getValueAt(y, 0).toString());
        smsname.setText(modell.getValueAt(y, 1).toString());
        smsuser.setText(modell.getValueAt(y, 2).toString());
        smspass.setText(modell.getValueAt(y, 3).toString());
        
        btnsms.setText("Update");
            }else if (p==1){
                 int y = tbl_sms.getSelectedRow();
        TableModel modell = tbl_sms.getModel();
        String id = modell.getValueAt(y, 0).toString();
            try{
                                  pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("DELETE FROM tbl_smsacct WHERE ID='" + id + "'");
                                   int del11 =  pst.executeUpdate();
                                   if(del11 >0){
                                       JOptionPane.showMessageDialog(null, "SMS Account Removed");
                                       refresh_sms();
                                       clear_sms();
                                }
                            }catch(SQLException e){ JOptionPane.showMessageDialog(null, e);}
            
            }
    }//GEN-LAST:event_tbl_smsMouseClicked

    private void smsidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smsidMouseClicked
        if (smsid.getText().equals("[Click to Generate ID]")) {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hmmss");
            SimpleDateFormat st = new SimpleDateFormat("MMddyyyy");
            smsid.setText("ID" + st.format(d) + s.format(d));
        } else {

        }
    }//GEN-LAST:event_smsidMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        clear_sms();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void tbl_smsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_smsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_smsMouseEntered

    private void sasmsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sasmsKeyReleased
//               if (sasms.equals("")){
//       sasms.removeAllItems();
//       }else{
//        try{
//        String sql="SELECT DISTINCT ProductCategory FROM tbl_category";
//        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
//        rs = pst.executeQuery();
//        while(rs.next()){
//        
//        String name =rs.getString("ProductCategory");
//        sasms.addItem(name);
//        // AutoCompleteDecorator.decorate(sasms);
//        }
//        }catch(Exception e){
//    JOptionPane.showMessageDialog(null, e);
//    } }
    }//GEN-LAST:event_sasmsKeyReleased

    private void jLabel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseClicked
            try {
  Desktop desktop = java.awt.Desktop.getDesktop();
  URI oURL = new URI("https://www.bulksms.com/account/#!/login/");
  desktop.browse(oURL);
} catch (Exception e) {
  e.printStackTrace();
}
    }//GEN-LAST:event_jLabel100MouseClicked

    private void raActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raActionPerformed

    private void rgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgenActionPerformed
       if (jLabel1.getText().equals("Save")){
       JOptionPane.showMessageDialog(null,"Cost update mode is selected, Please finish updating!");
       }else{
        try{  
        Connection connn = MysqlConnection.ConnectDB();
            //JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\MIS.Hardware\\Documents\\NetBeansProjects\\Clinic_Management\\src\\clinic_management\\med_receipt.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Clinic_Management\\src\\clinic_management\\Med_Report.jrxml");
            // String query = "SELECT * FROM tbl_items";
            JRDesignQuery jrquery = new JRDesignQuery();
            //jrquery.setText(query);
            JasperReport jr = JasperCompileManager.compileReport(jasperDesign);
            jasperDesign.setQuery(jrquery);
            HashMap para= new HashMap();
            
            para.put("a", ra.getText());
             para.put("b", rb.getText());
             para.put("c", rc.getText());
             para.put("d", rd.getText());
             para.put("e", re.getText());
             para.put("f", rf.getText());
             para.put("g", rg.getText());
             para.put("h", rh.getText());
             para.put("i", ri.getText());
             para.put("total", rtotal.getText());
             para.put("datetime", s_date.getText()+" "+s_time.getText());
             para.put("name", asname.getText());
             para.put("id", asid.getText());
            JasperPrint jp = JasperFillManager.fillReport(jr,para,connn);
            JasperPrintManager.printReport(jp, true);
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
       }
    }//GEN-LAST:event_rgenActionPerformed

    private void raKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raKeyReleased
        ///calc_total();
    }//GEN-LAST:event_raKeyReleased

    private void rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActionPerformed
        
    }//GEN-LAST:event_rbActionPerformed

    private void rbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbKeyReleased
        //calc_total();
    }//GEN-LAST:event_rbKeyReleased

    private void rcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcKeyReleased
        // TODO add your handling code here:
         //calc_total();
    }//GEN-LAST:event_rcKeyReleased

    private void rdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdKeyReleased
        // TODO add your handling code here:
         //calc_total();
    }//GEN-LAST:event_rdKeyReleased

    private void reKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reKeyReleased
        // TODO add your handling code here:
         //calc_total();
    }//GEN-LAST:event_reKeyReleased

    private void rfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfKeyReleased
       
         //calc_total();
    }//GEN-LAST:event_rfKeyReleased

    private void rgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rgKeyReleased
      // calc_total();
    }//GEN-LAST:event_rgKeyReleased

    private void rhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rhKeyReleased
// calc_total();        // TODO add your handling code here:
    }//GEN-LAST:event_rhKeyReleased

    private void riKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_riKeyReleased
 //calc_total();        // TODO add your handling code here:
 if (ri.isEnabled()==true){
 calc_total();
 }else{
 
 }
    }//GEN-LAST:event_riKeyReleased

    private void rtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtotalActionPerformed
        
    }//GEN-LAST:event_rtotalActionPerformed

    private void rtotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtotalMouseClicked

    //JOptionPane.showMessageDialog(null,"test");
         float a,b,c,d,e,f,g,h,i,total;
         a = Float.parseFloat(ra.getText());
         b = Float.parseFloat(rb.getText());
         c = Float.parseFloat(rc.getText());
         d = Float.parseFloat(rd.getText());
         e = Float.parseFloat(re.getText());
         f = Float.parseFloat(rf.getText());
         g = Float.parseFloat(rg.getText());
         h = Float.parseFloat(rh.getText());
         i = Float.parseFloat(ri.getText());
         total = a + b +c+d+e+f+g+h+i;
         rtotal.setText(String.valueOf(total));

    }//GEN-LAST:event_rtotalMouseClicked

    private void sraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sraActionPerformed
        if (jLabel1.getText().equals("Save")){
        ra.setEnabled(true);
        
        }else if (jLabel1.getText().equals("Update")){
        if (sra.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Cost FROM tbl_cost WHERE Test = '" + "HIV" + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                        //String address = rs.getString("Number_Street");
                        ra.setEnabled(false);
                        ra.setText(rs.getString("Cost"));
                        calc_total();
                    }else{
                    JOptionPane.showMessageDialog(null,"System error encountered please check!");
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
        }else if(sra.isSelected()==false){ra.setText("0.00");calc_total();}
        }
    }//GEN-LAST:event_sraActionPerformed

    private void srbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srbActionPerformed
    
         if (jLabel1.getText().equals("Save")){
        rb.setEnabled(true);
        
        }else if (jLabel1.getText().equals("Update")){
        
        if (srb.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Cost FROM tbl_cost WHERE Test = '" + "TB" + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                        rb.setEnabled(false);
                        //String address = rs.getString("Number_Street");
                        rb.setText(rs.getString("Cost"));calc_total();
                    }else{
                    JOptionPane.showMessageDialog(null,"System error encountered please check!");
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
        }else if(srb.isSelected()==false){rb.setText("0.00");calc_total();}}
    }//GEN-LAST:event_srbActionPerformed

    private void srcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcActionPerformed
       if (jLabel1.getText().equals("Save")){
        rc.setEnabled(true);
        
        }else if (jLabel1.getText().equals("Update")){
        if (src.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Cost FROM tbl_cost WHERE Test = '" + "Heart" + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                        rc.setEnabled(false);
                        //String address = rs.getString("Number_Street");
                        rc.setText(rs.getString("Cost"));calc_total();
                    }else{
                    JOptionPane.showMessageDialog(null,"System error encountered please check!");
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
        }else if(src.isSelected()==false){rc.setText("0.00");calc_total();}}
    }//GEN-LAST:event_srcActionPerformed

    private void srdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srdActionPerformed
        if (jLabel1.getText().equals("Save")){
        rd.setEnabled(true);
        
        }else if (jLabel1.getText().equals("Update")){
        if (srd.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Cost FROM tbl_cost WHERE Test = '" + "Blood" + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                        //String address = rs.getString("Number_Street");
                        rd.setText(rs.getString("Cost"));calc_total();
                    }else{
                    JOptionPane.showMessageDialog(null,"System error encountered please check!");
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
        }else if(src.isSelected()==false){rd.setText("0.00");calc_total();}}
    }//GEN-LAST:event_srdActionPerformed

    private void sreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sreActionPerformed
        
         if (jLabel1.getText().equals("Save")){
        re.setEnabled(true);
        
        }else if (jLabel1.getText().equals("Update")){
        
        if (sre.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Cost FROM tbl_cost WHERE Test = '" + "Malaria" + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                        re.setEnabled(false);
                        //String address = rs.getString("Number_Street");
                        re.setText(rs.getString("Cost"));calc_total();
                    }else{
                    JOptionPane.showMessageDialog(null,"System error encountered please check!");
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
        }else if(src.isSelected()==false){re.setText("0.00");calc_total();}}
    }//GEN-LAST:event_sreActionPerformed

    private void srfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srfActionPerformed
      if (jLabel1.getText().equals("Save")){
        rf.setEnabled(true);
        
        }else if (jLabel1.getText().equals("Update")){
        if (srf.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Cost FROM tbl_cost WHERE Test = '" + "Liver" + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                                rf.setEnabled(false);
                        //String address = rs.getString("Number_Street");
                        rf.setText(rs.getString("Cost"));calc_total();
                    }else{
                    JOptionPane.showMessageDialog(null,"System error encountered please check!");
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
        }else if(src.isSelected()==false){rf.setText("0.00");calc_total();}}
    }//GEN-LAST:event_srfActionPerformed

    private void srgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srgActionPerformed
       if (jLabel1.getText().equals("Save")){
        rg.setEnabled(true);
        
        }else if (jLabel1.getText().equals("Update")){
        if (srg.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Cost FROM tbl_cost WHERE Test = '" + "VLDR" + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                        rg.setEnabled(false);
                        //String address = rs.getString("Number_Street");
                        rg.setText(rs.getString("Cost"));calc_total();
                    }else{
                    JOptionPane.showMessageDialog(null,"System error encountered please check!");
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
        }else if (src.isSelected()==false){rg.setText("0.00");calc_total();}}
    }//GEN-LAST:event_srgActionPerformed

    private void srhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srhActionPerformed
       if (jLabel1.getText().equals("Save")){
        rh.setEnabled(true);
        
        }else if (jLabel1.getText().equals("Update")){
        if (srh.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement("SELECT Cost FROM tbl_cost WHERE Test = '" + "TPHA" + "'");
                    rs = (ResultSet) pst.executeQuery();
                    if (rs.next()){
                                rh.setEnabled(false);
                        //String address = rs.getString("Number_Street");
                        rh.setText(rs.getString("Cost"));calc_total();
                    }else{
                    JOptionPane.showMessageDialog(null,"System error encountered please check!");
                    }
           }catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
        }else if (src.isSelected()==false){rh.setText("0.00");calc_total();}}
    }//GEN-LAST:event_srhActionPerformed

    private void sriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sriActionPerformed
        if (sri.isSelected()==true){
        ri.setEnabled(true); ri.setText("");calc_total();
        }else{
                ri.setEnabled(false);ri.setText("0.00");calc_total();
        }
    }//GEN-LAST:event_sriActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       clear_avail();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void asearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asearchKeyReleased
        try{
                         String sql = "SELECT * FROM tbl_availabilty WHERE Date like ?";
                        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
                        pst.setString(1, "%" + asearch.getText() + "%");
                        rs = (ResultSet) pst.executeQuery();
                        Atable.setModel(DbUtils.resultSetToTableModel(rs));
            
                        String sql1 = "SELECT * FROM tbl_appointment WHERE Date like ?";
                        pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql1);
                        pst.setString(1, "%" + asearch.getText() + "%");
                        rs = (ResultSet) pst.executeQuery();
                        actable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }      
    }//GEN-LAST:event_asearchKeyReleased

    private void satodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satodayActionPerformed
        if (satoday.isSelected()==true){
        try {
            
            String sql = "SELECT * From tbl_appointment where Date like '"+ s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            satable.setModel(DbUtils.resultSetToTableModel(rs));
            
           
            saclietsell.setSelected(false);
            jCheckBox3.setSelected(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }else if (satoday.isSelected()==false){
        try {
            
            String sql = "SELECT * From tbl_appointment";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            satable.setModel(DbUtils.resultSetToTableModel(rs));
             saclietsell.setSelected(false);
                         jCheckBox3.setSelected(false);

            //satit.setText("Client Schedule");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    }//GEN-LAST:event_satodayActionPerformed

    private void assearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_assearchKeyReleased
        if (aswalkin.isSelected()==true){
        
        try {
                String sql = "Select ClientID,Member,LName,Mname,Fname,Number_Street,City,State,Zipcode,Email,Gender,Marital_State,"
                        + "Home,Work,Cell,Spouse_Home,Spouse_Work,Spouse_Cell,EC_Contact,Refer,Physician,If_yes,Conditions from tbl_clientinfo "
                        + "where ClientID like ? or Member like ? or LName like ? or MName like ? or FName like ?";
                
                pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
                
                pst.setString(1, "%" + assearch.getText() + "%"); 
                pst.setString(2, "%" + assearch.getText() + "%"); 
                pst.setString(3, "%" + assearch.getText() + "%");  
                pst.setString(4, "%" + assearch.getText() + "%");  
                pst.setString(5, "%" + assearch.getText() + "%");  
                rs = (ResultSet) pst.executeQuery();
                astable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
            
        }else{
        
        if (assearch.getText().equals("")){
        try{
             String sql1 = "SELECT * From tbl_appointment WHERE Date='"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            astable.setModel(DbUtils.resultSetToTableModel(rs));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }else{
        try {
                String sql = "Select * from tbl_appointment where ClientID like ? or Member like ? or Fullname like ?";
                
                pst = (com.mysql.jdbc.PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql);
                
                pst.setString(1, "%" + assearch.getText() + "%"); 
                pst.setString(2, "%" + assearch.getText() + "%"); 
                pst.setString(3, "%" + assearch.getText() + "%");
                rs = (ResultSet) pst.executeQuery();
                astable.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }    }
    }//GEN-LAST:event_assearchKeyReleased

    private void aswalkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aswalkinActionPerformed
         if (aswalkin.isSelected()==true){
        refresh_csalist();
        }else{
        try{
             String sql1 = "SELECT * From tbl_appointment WHERE Date='"+s_date.getText()+"'";
            pst = (PreparedStatement) (java.sql.PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            astable.setModel(DbUtils.resultSetToTableModel(rs));
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    }//GEN-LAST:event_aswalkinActionPerformed

    private void CLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLastMouseClicked
        CLast.setText("");
    }//GEN-LAST:event_CLastMouseClicked

    private void CMiddleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMiddleMouseClicked
         CMiddle.setText("");
    }//GEN-LAST:event_CMiddleMouseClicked

    private void CFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFirstMouseClicked
         CFirst.setText("");
    }//GEN-LAST:event_CFirstMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(acctype.getText().equals("User")){
        jLabel1.setText("Invalid user field!!");
        }else{
        if (jLabel1.getText().equals("Update")){
        jLabel1.setText("Save");
        
        }else if (jLabel1.getText().equals("Save")){
        //HIV
        if(sra.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_cost SET Cost=? WHERE Test = '"+"HIV"+"'");
                pst.setString(1, ra.getText());
                pst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        }else{ra.setText("0.00");}
        
        //TB
        if(srb.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_cost SET Cost=? WHERE Test = '"+"TB"+"'");
                pst.setString(1, rb.getText());
                pst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        }else{}
        
         //TB Heart
        if(src.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_cost SET Cost=? WHERE Test = '"+"Heart"+"'");
                pst.setString(1, rc.getText());
                pst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        }else{rc.setText("0.00");}
        
         //Blood 
        if(srd.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_cost SET Cost=? WHERE Test = '"+"Blood"+"'");
                pst.setString(1, rd.getText());
                pst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        }else{rd.setText("0.00");}
        
         //TB Malaria
        if(sre.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_cost SET Cost=? WHERE Test = '"+"Malaria"+"'");
                pst.setString(1, re.getText());
                pst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        }else{re.setText("0.00");}
        
         //TB Liver
        if(srf.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_cost SET Cost=? WHERE Test = '"+"Liver"+"'");
                pst.setString(1, rf.getText());
                pst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        }else{rf.setText("0.00");}
        
         //TB VLDR
        if(srg.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_cost SET Cost=? WHERE Test = '"+"VLDR"+"'");
                pst.setString(1, rg.getText());
                pst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        }else{rg.setText("0.00");}
        
         //TB TPHA
        if(srh.isSelected()==true){
        try{
            pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE tbl_cost SET Cost=? WHERE Test = '"+"TPHA"+"'");
                pst.setString(1, rh.getText());
                pst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        }else{rh.setText("0.00");}
        jLabel1.setText("Update");
        clear_receipt();
        }}
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rclearActionPerformed
        clear_receipt();

    }//GEN-LAST:event_rclearActionPerformed

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
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ADate;
    private javax.swing.JTextField AID;
    private javax.swing.JTextField AID1;
    private javax.swing.JTextField AID2;
    private javax.swing.JPanel Acclist;
    private javax.swing.JPanel Account;
    private javax.swing.JPanel Addacc;
    private javax.swing.JTextArea Aremarks;
    private javax.swing.JTable Atable;
    private javax.swing.JComboBox Atime;
    private javax.swing.JPanel Avail;
    private javax.swing.JComboBox CBMedical;
    private javax.swing.JTextField CCity;
    private javax.swing.JTextArea CConditions;
    private javax.swing.JTextField CEMContact;
    private javax.swing.JTextField CEMName;
    private javax.swing.JTextField CEmail;
    private javax.swing.JTextField CFirst;
    private javax.swing.JComboBox CGender1;
    private javax.swing.JTextField CID;
    private javax.swing.JTextField CIFyes;
    private javax.swing.JTextField CLast;
    private javax.swing.JComboBox CMarital;
    private javax.swing.JTextField CMiddle;
    private javax.swing.JTextField CPCell;
    private javax.swing.JTextField CPHome;
    private javax.swing.JTextField CPWork;
    private javax.swing.JTextField CRefer;
    private javax.swing.JTextField CSCell;
    private javax.swing.JTextField CSHome;
    private javax.swing.JTextField CSWork;
    private javax.swing.JButton CSave;
    private javax.swing.JTextField CState;
    private javax.swing.JTextField CStreet;
    private javax.swing.JTextField CZip;
    private javax.swing.JPanel Checkup;
    private javax.swing.JPanel Client_List;
    private javax.swing.JLabel Contact;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Main_Frame;
    private javax.swing.JPanel Manacc;
    private javax.swing.JPanel Patcon;
    private javax.swing.JPanel RAppoint;
    private javax.swing.JPanel Rpayment;
    private javax.swing.JPanel SMS;
    private javax.swing.JPanel Service;
    private javax.swing.JPanel Setapp;
    private javax.swing.JTextField Uname;
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JButton aact;
    private javax.swing.JLabel accid;
    private javax.swing.JLabel acctype;
    private javax.swing.JLabel acctype1;
    private javax.swing.JLabel acctype2;
    private javax.swing.JLabel acctype4;
    private javax.swing.JButton aclear;
    private javax.swing.JTable actable;
    private javax.swing.JTextField add;
    private javax.swing.JLabel address1;
    private javax.swing.JLabel adminid;
    private javax.swing.JComboBox arole1;
    private javax.swing.JComboBox asa;
    private javax.swing.JTextField asaddress;
    private javax.swing.JComboBox asb;
    private javax.swing.JTextField asblod;
    private javax.swing.JComboBox asc;
    private javax.swing.JTextField asd;
    private javax.swing.JTextField asdate;
    private javax.swing.JComboBox ase;
    private javax.swing.JTextField asearch;
    private javax.swing.JComboBox asf;
    private javax.swing.JComboBox asg;
    private javax.swing.JComboBox ash;
    private javax.swing.JTextField asid;
    private javax.swing.JTextField asmarital;
    private javax.swing.JTextField asname;
    private javax.swing.JCheckBox asno;
    private javax.swing.JTextField asseal;
    private javax.swing.JTextField assearch;
    private javax.swing.JTextField assex;
    private javax.swing.JTable astable;
    private javax.swing.JCheckBox aswalkin;
    private javax.swing.JCheckBox asyes;
    private javax.swing.JButton auclear;
    private javax.swing.JButton aupdate;
    private javax.swing.JCheckBox btngrpapp;
    private javax.swing.JCheckBox btngrpapp2;
    private javax.swing.ButtonGroup btngrplogin;
    private javax.swing.JButton btnsms;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup cbclient;
    private javax.swing.JPasswordField ccpass;
    private javax.swing.JPasswordField cnpass;
    private javax.swing.JTextField con;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel contact10;
    private javax.swing.JLabel contact11;
    private javax.swing.JLabel contact12;
    private javax.swing.JLabel contact13;
    private javax.swing.JLabel contact14;
    private javax.swing.JLabel contact16;
    private javax.swing.JLabel contact17;
    private javax.swing.JLabel contact19;
    private javax.swing.JLabel contact2;
    private javax.swing.JLabel contact20;
    private javax.swing.JLabel contact21;
    private javax.swing.JLabel contact23;
    private javax.swing.JLabel contact24;
    private javax.swing.JLabel contact3;
    private javax.swing.JLabel contact5;
    private javax.swing.JLabel contact6;
    private javax.swing.JLabel contact7;
    private javax.swing.JLabel contact8;
    private javax.swing.JLabel contact9;
    private javax.swing.JPasswordField crpass;
    private javax.swing.JTextField csearch;
    private javax.swing.JTextField cuname;
    private javax.swing.JLabel dresched;
    private javax.swing.JLabel dreserved;
    private javax.swing.JLabel dtoserve;
    private javax.swing.JLabel hdgfd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem menu_acclist;
    private javax.swing.JMenuItem menu_addacc;
    private javax.swing.JMenuItem menu_dashboard;
    private javax.swing.JMenuItem menu_logout;
    private javax.swing.JMenuItem menu_manacc;
    private javax.swing.JTextField na1;
    private javax.swing.JTextField na2;
    private javax.swing.JTextField na3;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nq1;
    private javax.swing.JLabel nq2;
    private javax.swing.JLabel nq3;
    private javax.swing.JLabel password;
    private javax.swing.JLabel password1;
    private javax.swing.JPanel payment;
    private javax.swing.JPasswordField pword;
    private javax.swing.JComboBox q1;
    private javax.swing.JComboBox q2;
    private javax.swing.JComboBox q3;
    private javax.swing.JTextField ra;
    private javax.swing.JTextField rb;
    private javax.swing.JTextField rc;
    private javax.swing.JButton rclear;
    private javax.swing.JTextField rd;
    private javax.swing.JTextField re;
    private javax.swing.ButtonGroup receipt;
    private javax.swing.JTextField rf;
    private javax.swing.JTextField rg;
    private javax.swing.JButton rgen;
    private javax.swing.JTextField rh;
    private javax.swing.JTextField ri;
    private javax.swing.JPasswordField rpword;
    private javax.swing.JTextField rtotal;
    private javax.swing.JLabel s_date;
    private javax.swing.JLabel s_time;
    private javax.swing.JCheckBox saclietsell;
    private javax.swing.JTextField sadate;
    private javax.swing.JTextField said;
    private javax.swing.JTextField samem;
    private javax.swing.JTextArea samessage;
    private javax.swing.JTextField saname;
    private javax.swing.JLabel sarem;
    private javax.swing.JButton sasave;
    private javax.swing.JButton sasave1;
    private javax.swing.JComboBox sasms;
    private javax.swing.JTable satable;
    private javax.swing.JLabel satime;
    private javax.swing.JTextField satime1;
    private javax.swing.JLabel satit;
    private javax.swing.JCheckBox satoday;
    private javax.swing.JPanel serv;
    private javax.swing.ButtonGroup setapp;
    private javax.swing.JCheckBox showpass;
    private javax.swing.JTextField smsid;
    private javax.swing.JTextField smsname;
    private javax.swing.JTextField smspass;
    private javax.swing.JTextField smsuser;
    private javax.swing.JCheckBox sra;
    private javax.swing.JCheckBox srb;
    private javax.swing.JCheckBox src;
    private javax.swing.JCheckBox srd;
    private javax.swing.JCheckBox sre;
    private javax.swing.JCheckBox srf;
    private javax.swing.JCheckBox srg;
    private javax.swing.JCheckBox srh;
    private javax.swing.JCheckBox sri;
    private javax.swing.JTable tbl_admin;
    private javax.swing.JTable tbl_client_list;
    private javax.swing.JTable tbl_dash;
    private javax.swing.JTable tbl_dsclist;
    private javax.swing.JTable tbl_rdasg;
    private javax.swing.JTable tbl_rm_serve;
    private javax.swing.JTable tbl_sms;
    private javax.swing.JTable tbl_srv_month;
    private javax.swing.JTable tbl_user;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    private javax.swing.JLabel type;
    private javax.swing.JComboBox type1;
    private javax.swing.JButton uact;
    private javax.swing.JMenu user;
    private javax.swing.JButton uuclear;
    // End of variables declaration//GEN-END:variables
private void seticon() {
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Clinic.png")));
    }
}
