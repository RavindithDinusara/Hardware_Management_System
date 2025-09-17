/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Validations.CIDEmptyMessage;
import Validations.CIDNotFoundMessage;
import Validations.ErrorIssueMessage;
import Validations.ErrorLoadingDataMesage;
import Validations.IIDEmptyMessage;
import Validations.IssueSuccessMessage;
import Validations.ItemNotFoundMessage;
import Validations.ItemAddValidation;
import Validations.NoStockMessage;
import Validations.DBErrorMessage;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class Issue_ItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form Issue_ProductPanel
     */
    private ItemPanel itemPanel;
    
    public void setItemPanel(ItemPanel itemPanel) {
    this.itemPanel = itemPanel;
    
}
    public Issue_ItemPanel() {
        initComponents();
        for (int i = 1; i <= 1000; i++) {
        cmbQuantity.addItem(String.valueOf(i));
        
    }

        connect();
        IssueItem_Load();       
    }
    Connection con;
    Statement stmt;
    ResultSet rs;
    private double unitPrice = 0.0; 
    
    
    
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
    
    public void IssueItem_Load() {
    int columnCount;

    try {
        Statement stmt = con.createStatement();
        String query = "SELECT \n" +
"    i.issue_id, \n" +
"    c.name, \n" +
"    it.Iname AS Pname, \n" +
"    i.issue_date, \n" +
"    i.Quantity, \n" +
"    i.total_price\n" +
"FROM \n" +
"    issueItem i\n" +
"JOIN \n" +
"    customer c ON i.customer_id = c.customer_id\n" +
"JOIN \n" +
"    items it ON i.Item_id = it.Item_id;";



        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsMetaData = rs.getMetaData();
        columnCount = rsMetaData.getColumnCount();

        DefaultTableModel tableModel = (DefaultTableModel) tblIssueItem.getModel();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu2 = new GradienTandIcons.Gradient();
        menu3 = new GradienTandIcons.Gradient();
        jLabel1 = new javax.swing.JLabel();
        menu1 = new GradienTandIcons.Gradient();
        jLabel8 = new javax.swing.JLabel();
        txtTOTprice = new javax.swing.JTextField();
        txtCID = new javax.swing.JTextField();
        btnclear = new javax.swing.JButton();
        txtIN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        txtCN = new javax.swing.JTextField();
        txtIID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DSissuedate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cmbQuantity = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssueItem = new javax.swing.JTable();

        setBackground(java.awt.SystemColor.controlHighlight);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ISSUE ITEM");
        menu3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 50));

        menu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total price");
        menu1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 100, 20));

        txtTOTprice.setBackground(new java.awt.Color(204, 204, 204));
        txtTOTprice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTOTprice.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTOTprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTOTpriceKeyPressed(evt);
            }
        });
        menu1.add(txtTOTprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 200, 30));

        txtCID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtCID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCIDKeyPressed(evt);
            }
        });
        menu1.add(txtCID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 200, 30));

        btnclear.setBackground(new java.awt.Color(0, 0, 0));
        btnclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.setBorder(null);
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        menu1.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 260, 40));

        txtIN.setBackground(new java.awt.Color(204, 204, 204));
        txtIN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtINKeyPressed(evt);
            }
        });
        menu1.add(txtIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Customer ID");
        menu1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        btnadd.setBackground(new java.awt.Color(0, 0, 0));
        btnadd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("ISSUE");
        btnadd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        menu1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 260, 50));

        txtCN.setBackground(new java.awt.Color(204, 204, 204));
        txtCN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCNKeyPressed(evt);
            }
        });
        menu1.add(txtCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 200, 30));

        txtIID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtIID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIIDActionPerformed(evt);
            }
        });
        txtIID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIIDKeyPressed(evt);
            }
        });
        menu1.add(txtIID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 200, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Item ID");
        menu1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Issue Date");
        menu1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        DSissuedate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        menu1.add(DSissuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 200, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity");
        menu1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        cmbQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQuantityActionPerformed(evt);
            }
        });
        menu1.add(cmbQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, -1));

        tblIssueItem.setBackground(new java.awt.Color(0, 0, 0));
        tblIssueItem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblIssueItem.setForeground(new java.awt.Color(255, 255, 255));
        tblIssueItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Item Name", "Issue Date", "Quantity", "TOT price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblIssueItem.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblIssueItem.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblIssueItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIssueItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIssueItem);

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 980, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void tblIssueItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIssueItemMouseClicked

    }//GEN-LAST:event_tblIssueItemMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed

        String customer_id = txtCID.getText().trim();
        String Item_id = txtIID.getText().trim();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String issue_date = "";

        if (DSissuedate.getDate() != null) {
            issue_date = dateFormat.format(DSissuedate.getDate());
        }

        String QuantityStr = cmbQuantity.getSelectedItem().toString();
        String priceStr = txtTOTprice.getText().trim(); // This is total price now

        if (customer_id.isEmpty() || Item_id.isEmpty() || issue_date.isEmpty() || QuantityStr.isEmpty() || priceStr.isEmpty()) {
            ItemAddValidation iav=new ItemAddValidation();
            iav.setVisible(true);
            return;
        }

        try {
            int Quantity = Integer.parseInt(QuantityStr);
            double total_price = Double.parseDouble(priceStr); // Already calculated

            Statement stmt = con.createStatement();

            // Check available stock before issuing
            ResultSet rs = stmt.executeQuery("SELECT Quantity FROM Items WHERE Item_id = " + Item_id);
            if (rs.next()) {
                int currentStock = rs.getInt("Quantity");
                if (currentStock < Quantity) {
                    NoStockMessage nsm=new NoStockMessage();
                    nsm.setVisible(true);
                    return;
                }
            } else {
                NoStockMessage nsm=new NoStockMessage();
                    nsm.setVisible(true);
                return;
            }

            // Insert issued product
            String query = "INSERT INTO issueItem(customer_id, Item_id, issue_date, Quantity, total_price) VALUES ('"
            + customer_id + "', '" + Item_id + "', '" + issue_date + "', " + QuantityStr + ", " + total_price + ")";
            int result = stmt.executeUpdate(query);

            // Reduce volume from product table
            String updateVolumeQuery = "UPDATE Items SET Quantity = Quantity - " + Quantity + " WHERE Item_id = " + Item_id;
            stmt.executeUpdate(updateVolumeQuery);

            if (result == 1) {
                IssueSuccessMessage ism=new IssueSuccessMessage();
                ism.setVisible(true);

                txtCID.setText("");
                txtIID.setText("");
                txtCN.setText("");
                txtIN.setText("");
                DSissuedate.setDate(null);
                cmbQuantity.setSelectedIndex(0);
                txtTOTprice.setText("");

                IssueItem_Load();
                if (itemPanel != null) 
                {
                itemPanel.Item_Load();
                }
                                            
            } else {
                ErrorIssueMessage eim=new ErrorIssueMessage();
                eim.setVisible(true);
            }

        } catch (NumberFormatException ex) {
            ErrorIssueMessage eim=new ErrorIssueMessage();
                eim.setVisible(true);
        } catch (SQLException ex) {
            DBErrorMessage dbe=new DBErrorMessage();
            dbe.setVisible(true);
        }

    }//GEN-LAST:event_btnaddActionPerformed

    private void txtIIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIIDActionPerformed

    }//GEN-LAST:event_txtIIDActionPerformed

    private void txtIIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIIDKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String Item_id = txtIID.getText().trim();

            if (Item_id.isEmpty()) {
                IIDEmptyMessage iidem=new IIDEmptyMessage();
                iidem.setVisible(true);
                return;
            }

            try {
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM Items WHERE Item_id = '" + Item_id + "'";
                ResultSet rs = stmt.executeQuery(query);

                if (!rs.next()) {
                    ItemNotFoundMessage infm=new ItemNotFoundMessage();
                    infm.setVisible(true);
                } else {
                    String productName = rs.getString("Iname");
                    unitPrice = rs.getDouble("Price"); // Save unit price

                    txtIN.setText(productName.trim()); // Show product name
                    txtTOTprice.setText(""); // Clear total price until volume is selected
                }

                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                DBErrorMessage dbe=new DBErrorMessage();
                dbe.setVisible(true);
            }
        }

    }//GEN-LAST:event_txtIIDKeyPressed

    private void txtCIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCIDKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String customer_id = txtCID.getText().trim();

            if (customer_id.isEmpty()) {
                CIDEmptyMessage cidem=new CIDEmptyMessage();
                cidem.setVisible(true);
                return;              
            }

            try {
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM customer WHERE customer_id = '" + customer_id + "'";
                ResultSet rs = stmt.executeQuery(query);

                if (!rs.next()) {
                    CIDNotFoundMessage cidnfm=new CIDNotFoundMessage();
                    cidnfm.setVisible(true);
                } else {
                    String CusName = rs.getString("name");
                    txtCN.setText(CusName.trim());
                }

                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                DBErrorMessage dbe=new DBErrorMessage();
                dbe.setVisible(true);
            }
        }

    }//GEN-LAST:event_txtCIDKeyPressed

    private void txtTOTpriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTOTpriceKeyPressed

    }//GEN-LAST:event_txtTOTpriceKeyPressed

    private void txtCNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCNKeyPressed

    }//GEN-LAST:event_txtCNKeyPressed

    private void cmbQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQuantityActionPerformed

        String volumeStr = cmbQuantity.getSelectedItem().toString();

        if (!volumeStr.isEmpty()) {
            try {
                int volume = Integer.parseInt(volumeStr);
                double totalPrice = volume * unitPrice;

                txtTOTprice.setText(String.valueOf(totalPrice)); // Show total price
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_cmbQuantityActionPerformed

    private void txtINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtINKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtINKeyPressed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtCID.setText("");
        txtIID.setText("");
        txtCN.setText("");
        txtIN.setText("");
        DSissuedate.setDate(null);
        cmbQuantity.setSelectedIndex(0);
        txtTOTprice.setText("");
    }//GEN-LAST:event_btnclearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DSissuedate;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JComboBox<String> cmbQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private GradienTandIcons.Gradient menu1;
    private GradienTandIcons.Gradient menu2;
    private GradienTandIcons.Gradient menu3;
    private javax.swing.JTable tblIssueItem;
    private javax.swing.JTextField txtCID;
    private javax.swing.JTextField txtCN;
    private javax.swing.JTextField txtIID;
    private javax.swing.JTextField txtIN;
    private javax.swing.JTextField txtTOTprice;
    // End of variables declaration//GEN-END:variables
}
