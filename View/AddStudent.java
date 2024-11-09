/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Dao.StudentDao;
import Model.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
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
public class AddStudent extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String TEN_FILE = "src/XML/Student.xml";
    ArrayList<Student> studentList;

    public AddStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        LoaiBang = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        KetQua = new javax.swing.JComboBox<>();
        CCCD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        HoTen = new javax.swing.JTextField();
        Ngay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Thang = new javax.swing.JTextField();
        Nam = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane2.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane2.setOpaque(true);
        jLayeredPane2.setPreferredSize(new java.awt.Dimension(450, 425));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("CCCD");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Họ và tên");

        Add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Add.setText("Thêm");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Ngày thi");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Loại bằng");

        LoaiBang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LoaiBang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B1", "B2", "C", "D" }));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Kết quả");

        KetQua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        KetQua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đỗ", "Trượt" }));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Thông Tin Học Viên");

        jLayeredPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(LoaiBang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(KetQua, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(CCCD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(HoTen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Ngay, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Thang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Nam, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(33, 33, 33)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(Add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(HoTen)
                            .addComponent(CCCD)
                            .addComponent(LoaiBang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(KetQua, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Thang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(LoaiBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KetQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(jButton1))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(TEN_FILE);
            Pattern ngaypaPattern = Pattern.compile("[0-9]{2}");
            NodeList indentityNumberList = doc.getElementsByTagName("identityNumber");
            Pattern namPattern = Pattern.compile("[0-9]{4}");
            String fullName, identityNumber, registeredLicenseType, examDate, result, day, month, year;
            Pattern pattern = Pattern.compile("0[0-9]{11}");
            fullName = HoTen.getText();
            identityNumber = CCCD.getText();
            Matcher matcher = pattern.matcher(identityNumber);
            registeredLicenseType = String.valueOf(LoaiBang.getSelectedItem());
            result = String.valueOf(KetQua.getSelectedItem());
            day = Ngay.getText();
            month = Thang.getText();
            year = Nam.getText();
            try {
                int dayInt = Integer.parseInt(day);
                int monthInt = Integer.parseInt(month);
                int yearInt = Integer.parseInt(year);

                Matcher dayMatcher = ngaypaPattern.matcher(day);
                Matcher monthMatcher = ngaypaPattern.matcher(month);
                Matcher yearMatcher = namPattern.matcher(year);
                if (dayMatcher.matches() && monthMatcher.matches() && yearMatcher.matches()) {
                    if (dayInt <= 31 && monthInt <= 12 && yearInt > 0) {
                        examDate = day + "/" + month + "/" + year;
                        if (!nhapDayDuThongTin(fullName, identityNumber, registeredLicenseType, examDate, result, day, month, year)) {
                            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!!", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else if (NhapTrung(identityNumber)) {
                            JOptionPane.showMessageDialog(this, "Nhập trùng CCCD!!", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Student student = new Student(fullName, identityNumber, registeredLicenseType, examDate, result);
                            if (matcher.matches()) {
                                Element Object = doc.getDocumentElement();
                                writeStudent(doc, Object, student);
                                writeStudentXML();
                                StudentMenu stmMenu = new StudentMenu();
                                stmMenu.HienThiStudent();
                                stmMenu.setVisible(true);
                                this.dispose();
                            } else {
                                JOptionPane.showMessageDialog(this, "Nhap sai căn cước công dân", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Nhập sai ngày tháng năm", "Lỗi", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Nhập sai ngày tháng năm", "Lỗi", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Nhập sai ngày tháng năm", "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SAXException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_AddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new StudentMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    private boolean nhapDayDuThongTin(String fullName, String identityNumber, String registeredLicenseType, String examDate, String result, String ngay, String thang, String nam) {
        if (fullName.trim().isEmpty() || identityNumber.trim().isEmpty() || ngay.trim().isEmpty() || thang.trim().isEmpty() || nam.trim().isEmpty()) {
            return false;
        } else if (registeredLicenseType.trim().isEmpty() || examDate.trim().isEmpty() || result.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean NhapTrung(String identityNumber) {
        boolean daTrung = false;
        try {

            try {
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                doc = db.parse(TEN_FILE);

                NodeList lStudent = doc.getElementsByTagName("Student");
                NodeList lFullName = doc.getElementsByTagName("fullName");
                NodeList lIdentityNumber = doc.getElementsByTagName("identityNumber");
                NodeList lRegisteredLicenseType = doc.getElementsByTagName("registeredLicenseType");
                NodeList lExamDate = doc.getElementsByTagName("examDate");
                NodeList lResult = doc.getElementsByTagName("Result");

                studentList = new ArrayList<>();

                for (int i = 0; i < lStudent.getLength(); i++) {
                    Student student = new Student();
                    student.setFullName(lFullName.item(i).getTextContent());
                    student.setIdentityNumber(lIdentityNumber.item(i).getTextContent());
                    student.setRegisteredLicenseType(lRegisteredLicenseType.item(i).getTextContent());
                    student.setExamDate(lExamDate.item(i).getTextContent());
                    student.setResult(lResult.item(i).getTextContent());

                    studentList.add(student);
                }

            } catch (SAXException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Student st : studentList) {
            if (st.getIdentityNumber().compareToIgnoreCase(identityNumber) == 0) {
                daTrung = true;
                break;
            }
        }
        return daTrung;

    }

    public void writeStudent(Document doc, Element Object, Student student) {
        Element Student = doc.createElement("Student");
        Element fullName = doc.createElement("fullName");
        fullName.setTextContent(student.getFullName());
        Element identityNumber = doc.createElement("identityNumber");
        identityNumber.setTextContent(student.getIdentityNumber());
        Element registeredLicenseType = doc.createElement("registeredLicenseType");
        registeredLicenseType.setTextContent(student.getRegisteredLicenseType());
        Element examDate = doc.createElement("examDate");
        examDate.setTextContent(student.getExamDate());
        Element Result = doc.createElement("Result");
        Result.setTextContent(student.getResult());

        Student.appendChild(fullName);
        Student.appendChild(identityNumber);
        Student.appendChild(registeredLicenseType);
        Student.appendChild(examDate);
        Student.appendChild(Result);
        Object.appendChild(Student);
    }

    public void writeStudentXML() {
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("src/XML/Student.xml");
            try {
                tf.transform(source, result);
                System.out.println("Ghi file thanh cong");
            } catch (TransformerException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField CCCD;
    private javax.swing.JTextField HoTen;
    private javax.swing.JComboBox<String> KetQua;
    private javax.swing.JComboBox<String> LoaiBang;
    private javax.swing.JTextField Nam;
    private javax.swing.JTextField Ngay;
    private javax.swing.JTextField Thang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    // End of variables declaration//GEN-END:variables
}
