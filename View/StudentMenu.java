/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Dao.StudentDao;
import Model.Student;
import java.io.IOException;
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
public class StudentMenu extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String TEN_FILE = "src/XML/Student.xml";
    ArrayList<Student> studentList;
    DefaultTableModel dfModel;

    public void HienThiStudent() {
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

                dfModel = new DefaultTableModel();
                dfModel.setColumnCount(0);
                dfModel.setRowCount(0);

                dfModel.addColumn("Họ và tên");
                dfModel.addColumn("CCCD");
                dfModel.addColumn("Loại bằng");
                dfModel.addColumn("Ngày thi");
                dfModel.addColumn("Kết quả");

                for (Student student : studentList) {
                    Vector v = new Vector();
                    v.add(student.getFullName());
                    v.add(student.getIdentityNumber());
                    v.add(student.getRegisteredLicenseType());
                    v.add(student.getExamDate());
                    v.add(student.getResult());

                    dfModel.addRow(v);
                }

                StudentTable.setModel(dfModel);

            } catch (SAXException ex) {
                Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    /**
     * Creates new form StudentMenu
     */
    public StudentMenu() {
        initComponents();
        HienThiStudent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ReturnButten = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Tìm kiếm CCCD:");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Tìm kiếm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setText("Thống kê");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        Edit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Edit.setText("Sửa");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton11.setText("Xóa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        StudentTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Họ và tên", "CCCD", "Loại bằng", "Ngày thi", "Kết quả"
            }
        ));
        StudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(StudentTable);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Học Viên Trung Tâm");

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
            .addComponent(jScrollPane3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ReturnButten)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButten))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7)
                    .addComponent(Edit)
                    .addComponent(jButton1)
                    .addComponent(jButton11))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        try {

            try {
                String fullName, identityNumber, registeredLicenseType, examDate, result;
                int hangChon = StudentTable.getSelectedRow();
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                doc = db.parse(TEN_FILE);

                NodeList studentList = doc.getElementsByTagName("Student");
                Node student = studentList.item(hangChon);

                Element studentElement = (Element) student;
                fullName = studentElement.getElementsByTagName("fullName").item(0).getTextContent();
                identityNumber = studentElement.getElementsByTagName("identityNumber").item(0).getTextContent();
                registeredLicenseType = studentElement.getElementsByTagName("registeredLicenseType").item(0).getTextContent();
                examDate = studentElement.getElementsByTagName("examDate").item(0).getTextContent();
                result = studentElement.getElementsByTagName("Result").item(0).getTextContent();

                Student student1 = new Student(fullName, identityNumber, registeredLicenseType, examDate, result);

                FixStudent fixStudent = new FixStudent();
                fixStudent.FixStudent(student1, hangChon);
                fixStudent.setVisible(true);
                this.dispose();
            } catch (SAXException ex) {
                Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chon Đối Tượng Muốn sửa", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        //        try {
//
//            int hangChon = StudentTable.getSelectedRow();
//            String fullName, identityNumber, registeredLicenseType, examDate, result;
//            fullName = (String) StudentTable.getValueAt(hangChon, 0);
//            identityNumber = (String) StudentTable.getValueAt(hangChon, 1);
//            registeredLicenseType = (String) StudentTable.getValueAt(hangChon, 2);
//            examDate = (String) StudentTable.getValueAt(hangChon, 3);
//            result = (String) StudentTable.getValueAt(hangChon, 4);
//
//            Student student = new Student(fullName, identityNumber, registeredLicenseType, examDate, result);
//
//            FixStudent fixStudent = new FixStudent();
//            fixStudent.FixStudent(student, hangChon);
//            fixStudent.setVisible(true);
//
//            this.dispose();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Chon Đối Tượng Muốn sửa", "Warning", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_EditActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void ReturnButtenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtenActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AddStudent().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void StudentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMouseClicked
//        int hangChon = StudentTable.getSelectedRow();
//        String fullName, identityNumber, registeredLicenseType, examDate, result;
//        fullName = (String)StudentTable.getValueAt(hangChon, 0);
//        identityNumber = (String)StudentTable.getValueAt(hangChon, 1);
//        registeredLicenseType = (String)StudentTable.getValueAt(hangChon, 2);
//        examDate = (String)StudentTable.getValueAt(hangChon, 3);
//        result = (String)StudentTable.getValueAt(hangChon, 4);


    }//GEN-LAST:event_StudentTableMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            String identityNumber, duongDan;
            int hangChon = StudentTable.getSelectedRow();
            identityNumber = (String) StudentTable.getValueAt(hangChon, 1);
            int result;
            try {
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                try {
                    doc = db.parse(TEN_FILE);
                } catch (SAXException ex) {
                    Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                duongDan = "/Object/Student[identityNumber='" + identityNumber + "']";
                XPathFactory xpf = XPathFactory.newInstance();
                XPath xp = xpf.newXPath();
                Node chon = (Node) xp.evaluate(duongDan, doc, XPathConstants.NODE);
                Node cha = chon.getParentNode();
                result = JOptionPane.showConfirmDialog(this, "ban co muon xoa doi tuong", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    cha.removeChild(chon);
                    writeStudentXML();
                    HienThiStudent();
                }

            } catch (ParserConfigurationException ex) {
                Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (XPathExpressionException ex) {
                Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn đối tượng muốn xóa!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ThongKeStudent thongKeStudent = new ThongKeStudent();
        int x = 0;
        int y = 0;
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

            String tong = String.valueOf(lStudent.getLength());
            for (int i = 0; i < lResult.getLength(); i++) {
                if (lResult.item(i).getTextContent().equalsIgnoreCase("Đỗ")) {
                    x++;
                } else {
                    y++;
                }
                String Dat = String.valueOf(x);
                String Truot = String.valueOf(y);

                thongKeStudent.ThongKeStudent(tong, Dat, Truot);

                thongKeStudent.setVisible(true);
                this.dispose();
            }
        } catch (SAXException ex) {
            Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            int value=-1;
            String indentityNumber;
            indentityNumber = search.getText();
            if(!indentityNumber.trim().isEmpty())
            {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(TEN_FILE);
            
            NodeList indentityNumberList = doc.getElementsByTagName("identityNumber");
            for(int i=0;i<indentityNumberList.getLength();i++)
            {
                if(indentityNumberList.item(i).getTextContent().equalsIgnoreCase(indentityNumber))
                {
                    value =i;
                    break;
                }
                
            }
            if(value==-1)
            {
                JOptionPane.showMessageDialog(this, "Không tìm được số căn cước công dân", "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                String fullName, identityNumber1, registeredLicenseType, examDate, result;
                NodeList studentList = doc.getElementsByTagName("Student");
                Node student = studentList.item(value);

                Element studentElement = (Element) student;
                fullName = studentElement.getElementsByTagName("fullName").item(0).getTextContent();
                identityNumber1 = studentElement.getElementsByTagName("identityNumber").item(0).getTextContent();
                registeredLicenseType = studentElement.getElementsByTagName("registeredLicenseType").item(0).getTextContent();
                examDate = studentElement.getElementsByTagName("examDate").item(0).getTextContent();
                result = studentElement.getElementsByTagName("Result").item(0).getTextContent();

                Student student1 = new Student(fullName, identityNumber1, registeredLicenseType, examDate, result);

                FixStudent fixStudent = new FixStudent();
                fixStudent.FixStudent(student1, value);
                fixStudent.setVisible(true);
                this.dispose();
            }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Không được để trống ô tìm kiếm", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SAXException ex) {
            Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StudentMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

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
//            java.util.logging.Logger.getLogger(StudentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StudentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StudentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StudentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StudentMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edit;
    private javax.swing.JButton ReturnButten;
    private javax.swing.JTable StudentTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
