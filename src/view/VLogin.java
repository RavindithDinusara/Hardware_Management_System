package view;

import Validations.LoginUnPwValidation;
import Validations.UNPWnotMatchValidation;
import javax.swing.*;

public class VLogin extends javax.swing.JFrame {

    public VLogin() 
    {
        setSize(947, 654);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        menu1 = new GradienTandIcons.Gradient();
        menu2 = new GradienTandIcons.Gradient();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1130, 660));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel3.setMinimumSize(new java.awt.Dimension(1130, 660));
        jPanel3.setPreferredSize(new java.awt.Dimension(1130, 660));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(java.awt.SystemColor.controlLtHighlight);
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel4.setText("LOGIN");

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menu1.add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 190, 70));

        jLabel1.setBackground(java.awt.SystemColor.controlLtHighlight);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel1.setText("User Name");
        menu1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtusername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        menu1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 280, 40));

        jLabel2.setBackground(java.awt.SystemColor.controlLtHighlight);
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel2.setText("Password");
        menu1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtpassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        menu1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 280, 40));

        btnlogin.setBackground(new java.awt.Color(0, 0, 0));
        btnlogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Login");
        btnlogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        menu1.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 100, 40));

        btncancel.setBackground(new java.awt.Color(0, 0, 0));
        btncancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("Cancel");
        btncancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        menu1.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 100, 40));

        jPanel3.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 1170, 680));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
    
    String username = txtusername.getText().trim();
    String password = new String(txtpassword.getPassword()).trim();

    if (username.isEmpty() || password.isEmpty()) 
    {
        LoginUnPwValidation lupvm=new LoginUnPwValidation();
        lupvm.setVisible(true);
        return;
    }

    if (username.equals("admin") && password.equals("admin")) 
    {
        MainFrame m=new MainFrame();
        this.setVisible(false);
        m.setVisible(true);          
    } 
    else 
    {
        UNPWnotMatchValidation upnm=new UNPWnotMatchValidation();
        upnm.setVisible(true);
        txtusername.setText("");
        txtpassword.setText("");
        txtusername.requestFocus();    
    }
    }//GEN-LAST:event_btnloginActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btncancelActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private GradienTandIcons.Gradient menu1;
    private GradienTandIcons.Gradient menu2;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
