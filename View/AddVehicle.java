/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Dao.VehicleDao;
import Model.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author tranb
 */
public class AddVehicle extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String TEN_FILE = "src/XML/Vehicle.xml";
    ArrayList<Vehicle> vehicleList;

    public void wirteVehicle(Document doc, Element ObJect, Vehicle vehicle) {
        Element Vehicle = doc.createElement("Vehicle");
        Element vehicleNumber = doc.createElement("vehicleNumber");
        vehicleNumber.setTextContent(vehicle.getVehicleNumber());
        Element vehicleInfo = doc.createElement("vehicleInfo");
        vehicleInfo.setTextContent(vehicle.getVehicleInfo());
        Element examUsage = doc.createElement("examUsage");
        examUsage.setTextContent(vehicle.getExamUsage());

        Vehicle.appendChild(vehicleNumber);
        Vehicle.appendChild(vehicleInfo);
        Vehicle.appendChild(examUsage);
        ObJect.appendChild(Vehicle);

    }

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
    
    private boolean nhapDayDuThongTin(String vehicleInfo, String vehicleNumber, String examUsage)
    {
        
        if(vehicleInfo.trim().isEmpty() || vehicleNumber.trim().isEmpty() || examUsage.trim().isEmpty())
        {
            return false;
        }
        
        return true;
    }
    
    public boolean nhapTrung(String vehicleInfo, String vehicleNumber)
    {
        boolean daTrung = false;
        
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db= dbf.newDocumentBuilder();
            doc = db.parse(TEN_FILE);
            
            NodeList lVehicle = doc.getElementsByTagName("Vehicle");
            NodeList lVehicleNumber = doc.getElementsByTagName("vehicleNumber");
            NodeList lVehicleInfo = doc.getElementsByTagName("vehicleInfo");
            NodeList lExamUsage = doc.getElementsByTagName("examUsage");
            
            vehicleList = new ArrayList<>();
            
            for(int i=0;i<lVehicle.getLength();i++)
            {
                Vehicle vehicle = new Vehicle();
                
                vehicle.setVehicleInfo(lVehicleInfo.item(i).getTextContent());
                vehicle.setExamUsage(lExamUsage.item(i).getTextContent());
                vehicle.setVehicleNumber(lVehicleNumber.item(i).getTextContent());
                
                vehicleList.add(vehicle);
            }
            
            
        } catch (SAXException ex) {
            Logger.getLogger(AddVehicle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddVehicle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AddVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for(Vehicle phuongtien : vehicleList)
        {
            if(phuongtien.getVehicleInfo().equalsIgnoreCase(vehicleInfo) && phuongtien.getVehicleNumber().equalsIgnoreCase(vehicleNumber))
            {
                daTrung = true;
            }
        }
        
        return daTrung;
    }

    public AddVehicle() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        ThongTinXe = new javax.swing.JTextField();
        BienSoXe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BaiThi = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Thêm Phương Tiện");

        ExitButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ExitButton.setText("Thoát");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        AddButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AddButton.setText("Thêm");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Bài thi phục vụ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Thông tin xe");

        BaiThi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BaiThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thực Hành", "Lý Thuyêt" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Biển số xe");

        jLayeredPane1.setLayer(ThongTinXe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(BienSoXe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ExitButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(AddButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(BaiThi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(ExitButton))
                    .addComponent(ThongTinXe)
                    .addComponent(BienSoXe)
                    .addComponent(BaiThi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(78, 78, 78))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ThongTinXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BienSoXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BaiThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(ExitButton))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String vehicleInfo, vehicleNumber, examUsage;
        Pattern pattern = Pattern.compile("[0-9]{2}[A-Z]-[0-9]{5}");
        vehicleInfo = ThongTinXe.getText();
        vehicleNumber = BienSoXe.getText();
        vehicleNumber = vehicleNumber.toUpperCase();
        examUsage  = String.valueOf(BaiThi.getSelectedItem());
        Matcher matcher = pattern.matcher(vehicleNumber);
        if(!nhapDayDuThongTin(vehicleInfo, vehicleNumber, examUsage))
        {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Đầy Đủ Thông Tin!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(nhapTrung(vehicleInfo, vehicleNumber))
        {
            JOptionPane.showMessageDialog(this, "Thông Tin Đã Bị Trùng!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            if(matcher.matches())
            {
            Vehicle vehicle = new Vehicle();
            
            vehicle.setVehicleInfo(vehicleInfo);
            vehicle.setExamUsage(examUsage);
            vehicle.setVehicleNumber(vehicleNumber);
            
            Element ObJect = doc.getDocumentElement();
            wirteVehicle(doc, ObJect, vehicle);
            writeVehicleXML();
            
            VehicleMenu vehicleMenu = new VehicleMenu();
            vehicleMenu.HienThiVehicle();
            vehicleMenu.setVisible(true);
            this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Nhập sai biển số xe", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        new VehicleMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JComboBox<String> BaiThi;
    private javax.swing.JTextField BienSoXe;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField ThongTinXe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
