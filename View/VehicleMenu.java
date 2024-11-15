/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Dao.VehicleDao;
import Model.Vehicle;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author tranb
 */
public class VehicleMenu extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String TEN_FILE = "src/XML/Vehicle.xml";
    ArrayList<Vehicle> vehicleList;
    DefaultTableModel dfModel;
    XPathFactory xpf;
    XPath xp;

    public void writeVehicleXML() {
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("src/XML/Vehicle.xml");
            try {
                tf.transform(source, result);
                System.out.println("Ghi file thanh cong");
            } catch (TransformerException ex) {
                Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void HienThiVehicle() {
        try {

            try {
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                doc = db.parse(TEN_FILE);

                NodeList lVehicle = doc.getElementsByTagName("Vehicle");
                NodeList lvehicleNumber = doc.getElementsByTagName("vehicleNumber");
                NodeList lvehicleInfo = doc.getElementsByTagName("vehicleInfo");
                NodeList lexamUsage = doc.getElementsByTagName("examUsage");

                vehicleList = new ArrayList<Vehicle>();

                for (int i = 0; i < lVehicle.getLength(); i++) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVehicleInfo(lvehicleInfo.item(i).getTextContent());
                    vehicle.setExamUsage(lexamUsage.item(i).getTextContent());
                    vehicle.setVehicleNumber(lvehicleNumber.item(i).getTextContent());
                    vehicleList.add(vehicle);

                }

                dfModel = new DefaultTableModel();

                dfModel.setColumnCount(0);
                dfModel.setRowCount(0);

                dfModel.addColumn("Biển số xe");
                dfModel.addColumn("Thông tin xe");
                dfModel.addColumn("Bài thi phục vụ");

                for (Vehicle vehicle : vehicleList) {
                    Vector v = new Vector();

                    v.add(vehicle.getVehicleNumber());
                    v.add(vehicle.getVehicleInfo());
                    v.add(vehicle.getExamUsage());

                    dfModel.addRow(v);
                }

                VehicleTable.setModel(dfModel);

            } catch (SAXException ex) {
                Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form VehicleMenu
     */
    public VehicleMenu() {
        initComponents();
        HienThiVehicle();
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
        VehicleTable = new javax.swing.JTable();
        Title = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        RemoveButten = new javax.swing.JButton();
        ThongKeButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        ReturnButten = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VehicleTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(VehicleTable);

        Title.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Title.setText("Quản Lý Xe Trung Tâm");

        AddButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AddButton.setText("Thêm");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        EditButton.setText("Sửa");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        RemoveButten.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        RemoveButten.setText("Xóa");
        RemoveButten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtenActionPerformed(evt);
            }
        });

        ThongKeButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ThongKeButton.setText("Thống kê");
        ThongKeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeButtonActionPerformed(evt);
            }
        });

        SearchButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        SearchButton.setText("Tìm Kiếm");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        ReturnButten.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ReturnButten.setText("Quay Lại");
        ReturnButten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReturnButten))
            .addGroup(layout.createSequentialGroup()
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemoveButten)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThongKeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButten))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(EditButton)
                    .addComponent(RemoveButten)
                    .addComponent(ThongKeButton)
                    .addComponent(SearchButton)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButtenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtenActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtenActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        new AddVehicle().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        try {

            int hangchon = VehicleTable.getSelectedRow();
            String vehicleNumber = (String) VehicleTable.getValueAt(hangchon, 0);
            String vehicleInfo = (String) VehicleTable.getValueAt(hangchon, 1);
            String examUsage = (String) VehicleTable.getValueAt(hangchon, 2);

            FixVehicle fixVehicle = new FixVehicle();
            fixVehicle.AddInfomation(vehicleNumber, vehicleInfo, examUsage, hangchon);
            fixVehicle.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn đối tượng muốn sửa!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void RemoveButtenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtenActionPerformed
        try {
            String vehicleNumber, duongDan;
            int hangChon = VehicleTable.getSelectedRow();
            vehicleNumber = (String) VehicleTable.getValueAt(hangChon, 0);
            duongDan = "/ObJect/Vehicle[vehicleNumber='" + vehicleNumber + "']";
            try {
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                doc = db.parse(TEN_FILE);

                xpf = XPathFactory.newInstance();
                xp = xpf.newXPath();
                Node chon = (Node) xp.evaluate(duongDan, doc, XPathConstants.NODE);
                Node cha = chon.getParentNode();
                int result = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Đối Tượng!!", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    cha.removeChild(chon);
                    writeVehicleXML();
                    HienThiVehicle();
                }
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (XPathExpressionException ex) {
                Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn đối tượng muốn xóa", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_RemoveButtenActionPerformed

    private void ThongKeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeButtonActionPerformed
        ThongKeVehicle thongKe = new ThongKeVehicle();
        int x = 0;
        int y = 0;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(TEN_FILE);

            NodeList examUsage = doc.getElementsByTagName("examUsage");

            String tong = String.valueOf(examUsage.getLength());

            for (int i = 0; i < examUsage.getLength(); i++) {
                if (examUsage.item(i).getTextContent().equalsIgnoreCase("Thực Hành")) {
                    x++;
                } else {
                    y++;
                }

                String thucHanh = String.valueOf(x);
                String lyThuyet = String.valueOf(y);

                thongKe.ThongKeVehicle(lyThuyet, thucHanh, tong);
                thongKe.setVisible(true);
                this.dispose();
            }
        } catch (SAXException ex) {
            Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ThongKeButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        try {
            String vehicleNumber, vehicleInfo, examUsage; 
            int value=-1;
            vehicleNumber = SearchField.getText();
            if(!vehicleNumber.trim().isEmpty())
            {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(TEN_FILE);
            
            NodeList vehicleNumberList = doc.getElementsByTagName("vehicleNumber");
            for(int i=0;i<vehicleNumberList.getLength();i++)
            {                             
                if(vehicleNumberList.item(i).getTextContent().equalsIgnoreCase(vehicleNumber))
                {
                    value=i;
                    break;
                }
            }
            if(value==-1)
            {
                JOptionPane.showMessageDialog(this, "Không tìm được biển số xe phù hợp", "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
            else
            { 
                NodeList vehicleList = doc.getElementsByTagName("Vehicle");
                Node vehicleNode = vehicleList.item(value);
                Element vehicleElement = (Element) vehicleNode;
                
                vehicleInfo = vehicleElement.getElementsByTagName("vehicleInfo").item(0).getTextContent();
                examUsage = vehicleElement.getElementsByTagName("examUsage").item(0).getTextContent();
                
                FixVehicle fixVehicle = new FixVehicle();
                fixVehicle.AddInfomation(vehicleNumber, vehicleInfo, examUsage, value);
                fixVehicle.setVisible(true);
                this.dispose();
            }        
            }
            else{
                JOptionPane.showMessageDialog(this, "Không được để trống ô tìm kíếm", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SAXException ex) {
            Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VehicleMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VehicleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VehicleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VehicleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VehicleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VehicleMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton RemoveButten;
    private javax.swing.JButton ReturnButten;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton ThongKeButton;
    private javax.swing.JLabel Title;
    private javax.swing.JTable VehicleTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
