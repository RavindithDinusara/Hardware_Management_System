/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Validations.DeletionSuccessMessage;
import Validations.EnterIDMessage;
import Validations.ErrorDeletingMesage;
import Validations.IDValidation;
import Validations.CusDeleteConfirmationMessage;
import Validations.ErrorLoadingDataMesage;
import Validations.ItemAddValidation;
import Validations.CusAddSuccMessage;
import Validations.CusIdMessage;
import Validations.CusUpdateMessage;
import Validations.DBErrorMessage;
import Validations.EnterCusIDMessage;
import Validations.ErrorAddingCusMessage;
import Validations.ErrorUpdatingCusMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class CustomerPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerPanel
     */
    public CustomerPanel() {
        initComponents();
        connect();
        Customer_Load();
    }
    Connection con;
    Statement stmt;
    ResultSet rs;
    public void connect()
    {      
        try 
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/hardware", "root", "");     
    } 
        catch (ClassNotFoundException ex)
        {
        DBErrorMessage dbe=new DBErrorMessage();
        dbe.setVisible(true);
    } 
        catch (SQLException ex) 
    {
        DBErrorMessage dbe=new DBErrorMessage();
        dbe.setVisible(true);
    }
    } 
    private void clearFields()
    {
    txtCname.setText("");
    txtCaddress.setText("");
    txtCtel.setText("");
    btnGender.clearSelection();
    txtCS.setText("");
    txtCname.requestFocus();
    }
    
    public void Customer_Load() {
    int columnCount;

    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

        ResultSetMetaData rsMetaData = rs.getMetaData();
        columnCount = rsMetaData.getColumnCount();

        DefaultTableModel tableModel = (DefaultTableModel) tblCustomer.getModel();
        tableModel.setRowCount(0);

        while (rs.next()) {
            Vector<String> rowData = new Vector<>();

            for (int i = 1; i <= columnCount; i++) {
                rowData.add(rs.getString(i));
            }

            tableModel.addRow(rowData);
        }
    } catch (SQLException ex) {
        ErrorLoadingDataMesage elidm=new ErrorLoadingDataMesage();
        elidm.setVisible(true);
    }
}
    
    public Connection getConnection() 
    {
    return con;
}
    
    public void onDeleteSuccess() {
    clearFields();
    Customer_Load();
    btnadd.setEnabled(true);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGender = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCtel = new javax.swing.JTextField();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCaddress = new javax.swing.JTextArea();
        txtCname = new javax.swing.JTextField();
        menu5 = new GradienTandIcons.Gradient();
        menu3 = new GradienTandIcons.Gradient();
        btnadd = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btndelete = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnclear = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCS = new javax.swing.JTextField();
        menu4 = new GradienTandIcons.Gradient();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();

        setBackground(java.awt.SystemColor.controlHighlight);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(java.awt.SystemColor.controlHighlight);
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel2.setText("Customer Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel3.setBackground(java.awt.SystemColor.controlHighlight);
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel3.setText("Address");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel5.setBackground(java.awt.SystemColor.controlHighlight);
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel5.setText("Gender");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel4.setBackground(java.awt.SystemColor.controlHighlight);
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel4.setText("Tel");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        txtCtel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCtel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(txtCtel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 250, 30));

        rbMale.setBackground(new java.awt.Color(0, 0, 0));
        btnGender.add(rbMale);
        rbMale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbMale.setForeground(java.awt.SystemColor.controlLtHighlight);
        rbMale.setText("Male");
        rbMale.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        rbMale.setOpaque(true);
        add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        rbFemale.setBackground(new java.awt.Color(0, 0, 0));
        btnGender.add(rbFemale);
        rbFemale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbFemale.setForeground(java.awt.SystemColor.controlLtHighlight);
        rbFemale.setText("female");
        rbFemale.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        rbFemale.setOpaque(true);
        add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        txtCaddress.setColumns(20);
        txtCaddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCaddress.setRows(5);
        txtCaddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane2.setViewportView(txtCaddress);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 250, 60));

        txtCname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(txtCname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 250, 30));

        btnadd.setBackground(new java.awt.Color(0, 0, 0));
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnaddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnaddMouseExited(evt);
            }
        });
        btnadd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Add");
        btnadd.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 10, 30, -1));

        btnupdate.setBackground(new java.awt.Color(0, 0, 0));
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnupdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnupdateMouseExited(evt);
            }
        });
        btnupdate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Update");
        btnupdate.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 10, 50, -1));

        btndelete.setBackground(new java.awt.Color(0, 0, 0));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndeleteMouseExited(evt);
            }
        });
        btndelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Delete");
        btndelete.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 60, -1));

        btnclear.setBackground(new java.awt.Color(0, 0, 0));
        btnclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnclearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnclearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnclearMouseExited(evt);
            }
        });
        btnclear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Clear");
        btnclear.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 160, -1));

        txtCS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCS.setForeground(new java.awt.Color(102, 102, 102));
        txtCS.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Search Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        txtCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menu3Layout = new javax.swing.GroupLayout(menu3);
        menu3.setLayout(menu3Layout);
        menu3Layout.setHorizontalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu3Layout.createSequentialGroup()
                .addContainerGap(576, Short.MAX_VALUE)
                .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCS)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        menu3Layout.setVerticalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtCS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        menu4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CUSTOMER MANAGER");
        menu4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 62));

        tblCustomer.setBackground(new java.awt.Color(0, 0, 0));
        tblCustomer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblCustomer.setForeground(new java.awt.Color(255, 255, 255));
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Customer Address", "Customer Tel", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCustomer.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblCustomer.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        javax.swing.GroupLayout menu5Layout = new javax.swing.GroupLayout(menu5);
        menu5.setLayout(menu5Layout);
        menu5Layout.setHorizontalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu4, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        menu5Layout.setVerticalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(menu4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        add(menu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 970, 680));
    }// </editor-fold>//GEN-END:initComponents

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked

    }//GEN-LAST:event_tblCustomerMouseClicked

    private void txtCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCSActionPerformed

        String customer_id = txtCS.getText().trim();

        if (customer_id.isEmpty()) {
            EnterIDMessage eidm=new EnterIDMessage();
            eidm.setVisible(true);
            
            return;
        }

        try {
            int memberId = Integer.parseInt(customer_id);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM customer WHERE customer_id = " + memberId;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                txtCname.setText(rs.getString("name"));
                txtCaddress.setText(rs.getString("address"));
                txtCtel.setText(rs.getString("tel"));
                String gender = rs.getString("gender");

                if ("Male".equalsIgnoreCase(gender)) {
                    rbMale.setSelected(true);
                } else if ("Female".equalsIgnoreCase(gender)) {
                    rbFemale.setSelected(true);
                }

                btnadd.setEnabled(false); // Disable add button to prevent adding duplicate entries
            } else 
            {
                EnterIDMessage eidM=new EnterIDMessage();
                eidM.setVisible(true);
            }
        } catch (NumberFormatException e) {
            EnterIDMessage eidM=new EnterIDMessage();
            eidM.setVisible(true);
        } catch (SQLException ex) {
            DBErrorMessage dbe=new DBErrorMessage();
            dbe.setVisible(true);
        }
    }//GEN-LAST:event_txtCSActionPerformed

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
       String name = txtCname.getText().trim();
        String address = txtCaddress.getText().trim();
        String telephone = txtCtel.getText().trim();
        String gender = "";

        if (rbMale.isSelected()) {
            gender = "Male";
        } else if (rbFemale.isSelected()) {
            gender = "Female";
        }

        if (name.isEmpty() || address.isEmpty() || telephone.isEmpty() || gender.isEmpty()) {
            ItemAddValidation iav=new ItemAddValidation();
            iav.setVisible(true);
            return;
        }

        try {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO customer(name, address, tel, gender) VALUES ('"
            + name + "', '" + address + "', '" + telephone + "', '" + gender + "')";

            int result = stmt.executeUpdate(query);

            if (result == 1) {
                CusAddSuccMessage casm=new CusAddSuccMessage();
                casm.setVisible(true);

                txtCname.setText("");
                txtCaddress.setText("");
                txtCtel.setText("");
                btnGender.clearSelection();
                txtCname.requestFocus();
                Customer_Load();
            } else {
                ErrorAddingCusMessage eacm=new ErrorAddingCusMessage();
                eacm.setVisible(true);
            }
        } catch (SQLException ex) 
        {
            DBErrorMessage dbe=new DBErrorMessage();
            dbe.setVisible(true);
        }
    }//GEN-LAST:event_btnaddMouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        String customer_id = txtCS.getText().trim();
        String name = txtCname.getText().trim();
        String address = txtCaddress.getText().trim();
        String telephone = txtCtel.getText().trim();
        String gender = "";

        if (rbMale.isSelected()) {
            gender = "Male";
        } else if (rbFemale.isSelected()) {
            gender = "Female";
        }

        if (customer_id.isEmpty() || name.isEmpty() || address.isEmpty() || telephone.isEmpty() || gender.isEmpty()) {
            ItemAddValidation iav=new ItemAddValidation();
            iav.setVisible(true);
            return;
        }

        try {
            int customerId = Integer.parseInt(customer_id);
            Statement stmt = con.createStatement();
            String query = "UPDATE customer SET "
            + "name = '" + name + "', "
            + "address = '" + address + "', "
            + "tel = '" + telephone + "', "
            + "gender = '" + gender + "' "
            + "WHERE customer_id = " + customerId;

            int result = stmt.executeUpdate(query);

            if (result == 1) {
                CusUpdateMessage cupm=new CusUpdateMessage();
                cupm.setVisible(true);
                
                clearFields();
                Customer_Load();
                btnadd.setEnabled(true);
            } else {
                ErrorUpdatingCusMessage eucm=new ErrorUpdatingCusMessage();
                eucm.setVisible(true);
            }
        } catch (NumberFormatException e) {
            CusIdMessage cim=new CusIdMessage();
            cim.setVisible(true);
            
        } catch (SQLException ex) {
            DBErrorMessage dbe=new DBErrorMessage();
            dbe.setVisible(true);
        }
    }//GEN-LAST:event_btnupdateMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        String customer_id = txtCS.getText().trim();

        if (customer_id.isEmpty()) {
            EnterCusIDMessage ecim=new EnterCusIDMessage();
            ecim.setVisible(true);
            return;
        }

       CusDeleteConfirmationMessage confirm = new CusDeleteConfirmationMessage(this,customer_id);
       confirm.setVisible(true);
    }//GEN-LAST:event_btndeleteMouseClicked

    private void btnclearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclearMouseClicked
        txtCname.setText("");
    txtCaddress.setText("");
    txtCtel.setText("");
    btnGender.clearSelection();
    txtCS.setText("");
    txtCname.requestFocus();
    }//GEN-LAST:event_btnclearMouseClicked

    private void btnaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseEntered
        btnadd.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_btnaddMouseEntered

    private void btnupdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseEntered
        btnupdate.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_btnupdateMouseEntered

    private void btndeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseEntered
        btndelete.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_btndeleteMouseEntered

    private void btnclearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclearMouseEntered
        btnclear.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_btnclearMouseEntered

    private void btnaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseExited
        btnadd.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_btnaddMouseExited

    private void btnupdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseExited
        btnupdate.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_btnupdateMouseExited

    private void btndeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseExited
        btndelete.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_btndeleteMouseExited

    private void btnclearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclearMouseExited
        btnclear.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_btnclearMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGender;
    private javax.swing.JPanel btnadd;
    private javax.swing.JPanel btnclear;
    private javax.swing.JPanel btndelete;
    private javax.swing.JPanel btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private GradienTandIcons.Gradient menu3;
    private GradienTandIcons.Gradient menu4;
    private GradienTandIcons.Gradient menu5;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtCS;
    private javax.swing.JTextArea txtCaddress;
    private javax.swing.JTextField txtCname;
    private javax.swing.JTextField txtCtel;
    // End of variables declaration//GEN-END:variables
}
