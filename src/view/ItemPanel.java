/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import Validations.AddSuccsessMessage;
import Validations.ItemAddValidation;
import Validations.ItemCodeValidation;
import Validations.ItemPriceValidation;
import Validations.AddingErrorMessage;
import Validations.DBErrorMessage;
import Validations.ItemDeleteConfirmationMessage;
import Validations.EnterIDMessage;
import Validations.ErrorDeletingMesage;
import Validations.ErrorLoadingDataMesage;
import Validations.DeletionSuccessMessage;
import Validations.IDValidation;
import Validations.ItemUpdateErrorMessage;
import Validations.UpdateSuccessMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.jfr.Description;

/**
 *
 * @author ASUS
 */
public class ItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProductPanel
     */
    public ItemPanel() {
        initComponents();
        connect();
        Item_Load();
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
    txtIname.setText("");
    txtBrand.setText("");
    txtDescription.setText("");
    txtSupplier.setText("");
    txtQuantity.setText("");
    txtIC.setText("");
    txtPrice.setText("");
    txtSearch.setText("");
    txtIname.requestFocus();
    }
        
    
    public void Item_Load() {
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Items");

        ResultSetMetaData rsd = rs.getMetaData();
        int columnCount = rsd.getColumnCount();

        DefaultTableModel model = (DefaultTableModel) tblItem.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            Vector<String> row = new Vector<>(columnCount);
            row.add(rs.getString("Item_id"));
            row.add(rs.getString("Iname"));
            row.add(rs.getString("Brand"));
            row.add(rs.getString("Description"));
            row.add(rs.getString("Supplier"));
            row.add(rs.getString("Quantity"));
            row.add(rs.getString("IC"));
            row.add(rs.getString("Price"));

            model.addRow(row);
        }
    } catch (SQLException ex) {
        ErrorLoadingDataMesage elidm=new ErrorLoadingDataMesage();
        elidm.setVisible(true);
    }
}
    
    public Connection getConnection() {
    return con;
}

public void onDeleteSuccess() {
    clearFields();
    Item_Load();
    btnadd.setEnabled(true);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIname = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtSupplier = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtIC = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        btnclear = new javax.swing.JButton();
        menu1 = new GradienTandIcons.Gradient();
        jLabel1 = new javax.swing.JLabel();
        menu3 = new GradienTandIcons.Gradient();
        menu2 = new GradienTandIcons.Gradient();

        setBackground(java.awt.SystemColor.controlHighlight);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(txtIname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 220, 30));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Search Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 250, -1));

        txtBrand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBrand.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(txtBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 220, 30));

        txtDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 220, 40));

        txtSupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSupplier.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(txtSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 220, 30));

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 220, 30));

        txtIC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtICActionPerformed(evt);
            }
        });
        add(txtIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 220, 30));

        btndelete.setBackground(new java.awt.Color(0, 0, 0));
        btndelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.setBorder(null);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 250, 39));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 250, 39));

        btnadd.setBackground(new java.awt.Color(0, 0, 0));
        btnadd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("Add");
        btnadd.setBorder(null);
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 250, 39));

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 220, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Brand");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Description");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Supplier");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Item code");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Price");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        tblItem.setBackground(new java.awt.Color(0, 0, 0));
        tblItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblItem.setForeground(new java.awt.Color(255, 255, 255));
        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Name", "Brand", "Description", "Supplier", "Quantity", "Item Code", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblItem.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblItem.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItem);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 860, 170));

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
        add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 250, 40));

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 860, 370));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ITEM MANAGER");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 410, 70));

        javax.swing.GroupLayout menu3Layout = new javax.swing.GroupLayout(menu3);
        menu3.setLayout(menu3Layout);
        menu3Layout.setHorizontalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        menu3Layout.setVerticalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        add(menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 330, 50));

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 960, 690));
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

        String id = txtSearch.getText().trim();

        if (id.isEmpty()) {
            EnterIDMessage eidM=new EnterIDMessage();
            eidM.setVisible(true);
            return;
        }

        try {
            int Item_id = Integer.parseInt(id);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Items WHERE Item_id = " + Item_id;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                txtIname.setText(rs.getString("Iname"));
                txtBrand.setText(rs.getString("Brand"));
                txtDescription.setText(rs.getString("Description"));
                txtSupplier.setText(rs.getString("Supplier"));
                txtQuantity.setText(rs.getString("Quantity"));
                txtIC.setText(rs.getString("IC"));
                txtPrice.setText(rs.getString("Price"));
                btnadd.setEnabled(false); // Disable add button to prevent adding duplicate entries
            } else
            {
            IDValidation iiv=new IDValidation();
            iiv.setVisible(true);
            }
        } catch (NumberFormatException e) {
            IDValidation iiv=new IDValidation();
            iiv.setVisible(true);
        } catch (SQLException ex) {
           DBErrorMessage dbe=new DBErrorMessage();
            dbe.setVisible(true);
        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed

    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtICActionPerformed

    }//GEN-LAST:event_txtICActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed

        String id = txtSearch.getText().trim();

    if (id.isEmpty()) {
        EnterIDMessage eidM = new EnterIDMessage();
        eidM.setVisible(true);
        return;
    }

    // Open your custom confirmation window and pass this panel + id
    ItemDeleteConfirmationMessage confirm = new ItemDeleteConfirmationMessage(this, id);
    confirm.setVisible(true);

    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String Item_id = txtSearch.getText().trim();
        String Iname = txtIname.getText().trim();
        String Brand = txtBrand.getText().trim();
        String Description = txtDescription.getText().trim();
        String Supplier = txtSupplier.getText().trim();
        String Quantity = txtQuantity.getText().trim();
        String IC = txtIC.getText().trim();
        String Price = txtPrice.getText().trim();

        if (Item_id.isEmpty() || Iname.isEmpty() || Brand.isEmpty() || Description.isEmpty() || Supplier.isEmpty() || Quantity.isEmpty() || IC.isEmpty() || Price.isEmpty()) {
            ItemAddValidation iav=new ItemAddValidation();
            iav.setVisible(true);
            return;
        }

        int ItemCode;
        double ItemPrice;
        int ItemId;

        try {
            ItemCode = Integer.parseInt(IC);
            if (ItemCode <= 0) {
                ItemCodeValidation icv=new ItemCodeValidation();
                icv.setVisible(true);
                return;
            }
        } catch (NumberFormatException e) {
            ItemCodeValidation icv=new ItemCodeValidation();
                icv.setVisible(true);
            return;
        }

        try {
            ItemPrice = Double.parseDouble(Price);
            if (ItemPrice < 0) {
                ItemPriceValidation ipv=new ItemPriceValidation();
                ipv.setVisible(true);
                return;
            }
        } catch (NumberFormatException e) {
            ItemPriceValidation ipv=new ItemPriceValidation();
                ipv.setVisible(true);
            return;
        }

        try {
            ItemId = Integer.parseInt(Item_id);
        } catch (NumberFormatException e) {
            IDValidation iiv=new IDValidation();
            iiv.setVisible(true);
            return;
        }

        try {
            Statement stmt = con.createStatement();
            String query = "UPDATE Items SET "
            + "Iname = '" + Iname + "', "
            + "Brand = '" + Brand + "', "
            + "Description = '" + Description + "', "
            + "Supplier = '" + Supplier + "', "
            + "Quantity = '" + Quantity + "', "
            + "IC = " + IC + ", "
            + "price = " + ItemPrice + " "
            + "WHERE Item_id = " + ItemId;

            int result = stmt.executeUpdate(query);

            if (result == 1) {
                UpdateSuccessMessage usm=new UpdateSuccessMessage();
                usm.setVisible(true);
                clearFields();
                Item_Load();
                btnadd.setEnabled(true);
            } else {
                ItemUpdateErrorMessage iuem=new ItemUpdateErrorMessage();
                iuem.setVisible(true);
            }
        } catch (SQLException ex) {
            DBErrorMessage dbe=new DBErrorMessage();
            dbe.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed

        String Iname = txtIname.getText().trim();
        String Brand = txtBrand.getText().trim();
        String Description = txtDescription.getText().trim();
        String Supplier = txtSupplier.getText().trim();
        String Quantity = txtQuantity.getText().trim();
        String IC = txtIC.getText().trim();
        String Price = txtPrice.getText().trim();

        if (Iname.isEmpty() || Brand.isEmpty() || Description.isEmpty() || Supplier.isEmpty() || Quantity.isEmpty() || IC.isEmpty() || Price.isEmpty()) 
        {
            ItemAddValidation iav=new ItemAddValidation();
            iav.setVisible(true);
            return;
            
        }

        int ItemCode;
        double ItemPrice;

        try {
            ItemCode = Integer.parseInt(IC);
            if (ItemCode <= 0)
            {
                ItemCodeValidation icv=new ItemCodeValidation();
                icv.setVisible(true);
                return;
            }
        } catch (NumberFormatException e) 
        {
            ItemCodeValidation icv=new ItemCodeValidation();
                icv.setVisible(true);
            return;
        }

        try {
            ItemPrice = Double.parseDouble(Price);
            if (ItemPrice < 0) {
                ItemPriceValidation ipv=new ItemPriceValidation();
                ipv.setVisible(true);
                return;
            }
        } catch (NumberFormatException e) {
            ItemPriceValidation ipv=new ItemPriceValidation();
            ipv.setVisible(true);
            return;
        }

        try {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO Items(Iname, Brand, Description, Supplier, Quantity, IC, Price) VALUES ('"
            + Iname + "', '" + Brand + "', '" + Description + "', '" + Supplier + "', '" + Quantity + "', "
            + IC + ", " + Price + ")";

            int i = stmt.executeUpdate(query);

            if (i == 1) {
                
                AddSuccsessMessage asm=new AddSuccsessMessage();
                asm.setVisible(true);
                clearFields();
                Item_Load();
            } else
            {
                AddingErrorMessage arm=new AddingErrorMessage();
                arm.setVisible(true);
            }
        } catch (SQLException ex) {
            DBErrorMessage dbe=new DBErrorMessage();
            dbe.setVisible(true);
        }

    }//GEN-LAST:event_btnaddActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed

    }//GEN-LAST:event_txtPriceActionPerformed

    private void tblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemMouseClicked

    }//GEN-LAST:event_tblItemMouseClicked

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtIname.setText("");
        txtBrand.setText("");
        txtDescription.setText("");
        txtSupplier.setText("");
        txtQuantity.setText("");
        txtIC.setText("");
        txtPrice.setText("");
        txtSearch.setText("");
        txtIname.requestFocus();
    }//GEN-LAST:event_btnclearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private GradienTandIcons.Gradient menu1;
    private GradienTandIcons.Gradient menu2;
    private GradienTandIcons.Gradient menu3;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtIC;
    private javax.swing.JTextField txtIname;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSupplier;
    // End of variables declaration//GEN-END:variables
}
