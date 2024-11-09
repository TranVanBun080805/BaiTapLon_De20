/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Dao.ExamDao;
import Model.Exam;
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
public class AddExam extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String TEN_FILE = "src/XML/Exam.xml";
    ArrayList<Exam> examList;

    public void writeExam(Document doc, Element Object, Exam exam) {
        Element Exam = doc.createElement("Exam");
        Element dateExam = doc.createElement("dateExam");
        dateExam.setTextContent(exam.getDateExam());
        Element location = doc.createElement("location");
        location.setTextContent(exam.getLocation());
        Element examType = doc.createElement("examType");
        examType.setTextContent(exam.getExamType());
        Element licenseType = doc.createElement("licenseType");
        licenseType.setTextContent(exam.getLicenseType());
        Element numberOfVehicles = doc.createElement("numberOfVehicles");
        numberOfVehicles.setTextContent(String.valueOf(exam.getNumberOfVehicles()));

        Exam.appendChild(dateExam);
        Exam.appendChild(location);
        Exam.appendChild(examType);
        Exam.appendChild(licenseType);
        Exam.appendChild(numberOfVehicles);
        Object.appendChild(Exam);
    }

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

    private boolean nhapDayDuThongTin(String dateExam, String location, String examType, String licenseType, int numberOfVehicles) {
//        String number = String.valueOf(numberOfVehicles);
        if (dateExam.trim().isEmpty() || location.trim().isEmpty() || examType.trim().isEmpty() || licenseType.trim().isEmpty()) {
            return false;
        }

        return true;

    }

    private boolean NhapTrung(String dateExam, String location, String examType, String licenseType) {
        boolean daTrung = false;
        try {

            dbf = DocumentBuilderFactory.newInstance();
            try {
                db = dbf.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(AddExam.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        } catch (SAXException ex) {
            Logger.getLogger(AddExam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddExam.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Exam ex : examList) {
            if (ex.getDateExam().compareToIgnoreCase(dateExam) == 0 && ex.getExamType().compareToIgnoreCase(examType) == 0 && ex.getLocation().compareToIgnoreCase(location) == 0 && ex.getLicenseType().compareToIgnoreCase(licenseType) == 0) {
                daTrung = true;
                return daTrung;
            }
        }

        return daTrung;
    }

    public AddExam() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        HinhThucThi = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        LoaiBang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        SoLuongXe = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        NgayThi = new javax.swing.JTextField();
        DiaDiem = new javax.swing.JTextField();
        Thang = new javax.swing.JTextField();
        Nam = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setOpaque(true);

        HinhThucThi.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        HinhThucThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lý Thuyết", "Thực Hành" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Ngày thi");

        LoaiBang.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LoaiBang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B1", "B2", "C", "D" }));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Số lượng xe");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Địa điểm ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Hình thức thi");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Loại bằng");

        Add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Add.setText("Thêm Kỳ Thi");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Thêm Bài Thi");

        jLayeredPane1.setLayer(HinhThucThi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(LoaiBang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(SoLuongXe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(NgayThi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(DiaDiem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Thang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Nam, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DiaDiem, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(SoLuongXe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(NgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Thang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(LoaiBang, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(HinhThucThi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Add)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(75, 75, 75))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SoLuongXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoaiBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HinhThucThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(jButton2))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        String dateExam, location, examType, licenseType, ngay, thang, nam;
        int numberOfVehicles = 0;

        ngay = NgayThi.getText();
        thang = Thang.getText();
        nam = Nam.getText();
        location = DiaDiem.getText();
        examType = String.valueOf(HinhThucThi.getSelectedItem());
        licenseType = String.valueOf(LoaiBang.getSelectedItem());

        Pattern ngayThangPattern = Pattern.compile("[0-9]{2}");
        Pattern namPattern = Pattern.compile("[0-9]{1,}");

        Matcher dayMatcher = ngayThangPattern.matcher(ngay);
        Matcher thangMatcher = ngayThangPattern.matcher(thang);
        Matcher namMatcher = namPattern.matcher(nam);
        if (dayMatcher.matches() && thangMatcher.matches() && namMatcher.matches()) {
            int ngayInt = Integer.parseInt(ngay);
            int thangInt = Integer.parseInt(thang);
            int namInt = Integer.parseInt(nam);
            if (ngayInt <= 31 && thangInt <= 12 && namInt > 0) {
                dateExam = ngay+"/"+thang+"/"+nam;
                try {
                    numberOfVehicles = Integer.parseInt(SoLuongXe.getText());
                } catch (Exception e) {
                }
                if (numberOfVehicles != 0) {
                    if (!nhapDayDuThongTin(dateExam, location, examType, licenseType, numberOfVehicles)) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!!", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else if (NhapTrung(dateExam, location, examType, licenseType)) {
                        JOptionPane.showMessageDialog(this, "Nhap Trung Du Lieu", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Exam exam = new Exam(dateExam, location, examType, licenseType, numberOfVehicles);

                        Element Object = doc.getDocumentElement();
                        writeExam(doc, Object, exam);
                        writeExamXML();
                        ExamMenu examMenu = new ExamMenu();
                        examMenu.HienThiExam();
                        examMenu.setVisible(true);
                        this.dispose();

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng xe phù hợp", "Nhập lại", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nhập sai ngày tháng", "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nhập sai ngày tháng", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_AddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ExamMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField DiaDiem;
    private javax.swing.JComboBox<String> HinhThucThi;
    private javax.swing.JComboBox<String> LoaiBang;
    private javax.swing.JTextField Nam;
    private javax.swing.JTextField NgayThi;
    private javax.swing.JTextField SoLuongXe;
    private javax.swing.JTextField Thang;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
