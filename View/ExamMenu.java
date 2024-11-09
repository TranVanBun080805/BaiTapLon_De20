/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Dao.ExamDao;
import Model.Exam;
import Model.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExamMenu extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String TEN_FILE = "src/XML/Exam.xml";
    ArrayList<Exam> examList;
    DefaultTableModel dfModel;
    XPathFactory xpf;
    XPath xp;
    String duongDan;

    public void writeExamXML() {
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("src/XML/Exam.xml");
            try {
                tf.transform(source, result);
                System.out.println("Ghi file thanh cong");
            } catch (TransformerException ex) {
                Logger.getLogger(ExamDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ExamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void HienThiExam() {
        try {

            try {
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                doc = db.parse(TEN_FILE);

                NodeList lExam = doc.getElementsByTagName("Exam");
                NodeList lDateExam = doc.getElementsByTagName("dateExam");
                NodeList lLocation = doc.getElementsByTagName("location");
                NodeList lExamType = doc.getElementsByTagName("examType");
                NodeList lLicenseType = doc.getElementsByTagName("licenseType");
                NodeList lNumberOfVehicles = doc.getElementsByTagName("numberOfVehicles");

                examList = new ArrayList<>();

                for (int i = 0; i < lExam.getLength(); i++) {
                    Exam exam = new Exam();

                    exam.setDateExam(lDateExam.item(i).getTextContent());
                    exam.setLocation(lLocation.item(i).getTextContent());
                    exam.setExamType(lExamType.item(i).getTextContent());
                    exam.setLicenseType(lLicenseType.item(i).getTextContent());
                    exam.setNumberOfVehicles(Integer.parseInt(lNumberOfVehicles.item(i).getTextContent()));

                    examList.add(exam);

                }

                dfModel = new DefaultTableModel();
                dfModel.setColumnCount(0);
                dfModel.setRowCount(0);

                dfModel.addColumn("Ngày thi");
                dfModel.addColumn("Địa điểm");
                dfModel.addColumn("Hình thức thi");
                dfModel.addColumn("Loại bằng");
                dfModel.addColumn("Số lượng xe");

                for (Exam exam : examList) {
                    Vector v = new Vector();

                    v.add(exam.getDateExam());
                    v.add(exam.getLocation());
                    v.add(exam.getExamType());
                    v.add(exam.getLicenseType());
                    v.add(exam.getNumberOfVehicles());

                    dfModel.addRow(v);

                }

                ExamTable.setModel(dfModel);
            } catch (SAXException ex) {
                Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ExamMenu() {
        initComponents();
        HienThiExam();
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
        ExamTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        FixButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Ngay = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Thang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Nam = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        ExamTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ExamTable);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Bài Thi Trung Tâm");

        AddButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        AddButton.setText("Thêm");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        FixButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        FixButton.setText("Sửa");
        FixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FixButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        DeleteButton.setText("Xóa");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Ngày:");

        jLabel3.setText("Tháng:");

        jLabel4.setText("Năm :");

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton5.setText("Tìm Kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Quay Lại");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Thang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FixButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(Thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(Nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(FixButton)
                    .addComponent(DeleteButton))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        new AddExam().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void FixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FixButtonActionPerformed
        try {

            FixExam fixExam = new FixExam();
            try {
                int hangChon = ExamTable.getSelectedRow();
                String dateExam, location, examType, licenseType, numberOfVehicles;
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                doc = db.parse(TEN_FILE);

                NodeList ExamList = doc.getElementsByTagName("Exam");

                Node Exam = ExamList.item(hangChon);
                Element studentElement = (Element) Exam;

                dateExam = studentElement.getElementsByTagName("dateExam").item(0).getTextContent();
                location = studentElement.getElementsByTagName("location").item(0).getTextContent();
                examType = studentElement.getElementsByTagName("examType").item(0).getTextContent();
                licenseType = studentElement.getElementsByTagName("licenseType").item(0).getTextContent();
                numberOfVehicles = studentElement.getElementsByTagName("numberOfVehicles").item(0).getTextContent();

                fixExam.TruyenThongtin(dateExam, location, examType, licenseType, numberOfVehicles, hangChon);

                fixExam.setVisible(true);
                this.dispose();

            } catch (SAXException ex) {
                Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn đối tượng bạn muốn sửa!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_FixButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        try {
            try {
                int result;
                int hangChon = ExamTable.getSelectedRow();
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                doc = db.parse(TEN_FILE);

                NodeList ExamList = doc.getElementsByTagName("Exam");
                Node Exam = ExamList.item(hangChon);

                result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa đối tượng", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    Exam.getParentNode().removeChild(Exam);
                    writeExamXML();
                    HienThiExam();
                }
            } catch (SAXException ex) {
                Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn dối tượng muốn xóa!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String day, month, year;
        day = Ngay.getText();
        month = Thang.getText();
        year = Nam.getText();
        ArrayList<Exam> examSearchList = new ArrayList<>();
        if (!day.trim().isEmpty() && !month.trim().isEmpty() && !year.trim().isEmpty()) {
            Pattern ngayThangPattern = Pattern.compile("[0-9]{2}");
            Pattern namPattern = Pattern.compile("[0-9]{1,}");

            Matcher ngayMatcher = ngayThangPattern.matcher(day);
            Matcher thangMatcher = ngayThangPattern.matcher(month);
            Matcher namMatcher = namPattern.matcher(year);

            if (ngayMatcher.matches() && thangMatcher.matches() && namMatcher.matches()) {
                int ngayInt = Integer.parseInt(day);
                int thangInt = Integer.parseInt(month);
                int namInt = Integer.parseInt(year);
                if (ngayInt <= 31 && thangInt <= 12 && namInt > 0) {
                    try {
                        String dateSearch = day + "/" + month + "/" + year;
                        dbf = DocumentBuilderFactory.newInstance();
                        db = dbf.newDocumentBuilder();
                        doc = db.parse(TEN_FILE);
                        
                        NodeList examList = doc.getElementsByTagName("Exam");
                        boolean found = false;
                        for(int i=0;i<examList.getLength();i++)
                        {
                            Element examElement = (Element) examList.item(i);
                            String dateExam = examElement.getElementsByTagName("dateExam").item(0).getTextContent();
                            
                            if(dateSearch.equals(dateExam))
                            {
                                String location, examType, licenseType;
                                int numberOfVehicles;
                                location = examElement.getElementsByTagName("location").item(0).getTextContent();
                                examType = examElement.getElementsByTagName("examType").item(0).getTextContent();
                                licenseType = examElement.getElementsByTagName("licenseType").item(0).getTextContent();
                                numberOfVehicles = Integer.parseInt(examElement.getElementsByTagName("numberOfVehicles").item(0).getTextContent());
                                Exam exam = new Exam(dateExam, location, examType, licenseType, numberOfVehicles);
                                found = true;
                                examSearchList.add(exam);
                            }
                        }
                        if(!found)
                        {
                            JOptionPane.showMessageDialog(this, "Không tìm thấy ngày tháng năm cần tìm", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else
                        {
                            ExamSearch examSearch = new ExamSearch();
                            examSearch.HienThiKetQuaTimKiem(examSearchList);
                            examSearch.setVisible(true);
                            this.dispose();
                        }
                    } catch (SAXException ex) {
                        Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(ExamMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Nhập sai ngày tháng năm", "Lỗi", JOptionPane.WARNING_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(this, "Nhập sai ngày tháng năm", "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ ô tìm kiếm", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
//            java.util.logging.Logger.getLogger(ExamMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ExamMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ExamMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ExamMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ExamMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTable ExamTable;
    private javax.swing.JButton FixButton;
    private javax.swing.JTextField Nam;
    private javax.swing.JTextField Ngay;
    private javax.swing.JTextField Thang;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
