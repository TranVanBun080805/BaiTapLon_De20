/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Student;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class StudentDao {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Student student = new Student("Tran Van Bun", "040205001652", "B1","20-11-2024" ,"Đỗ");
            Student student1 = new Student("Tran Van Bun1", "040205001652", "A1", "08-08-2023",  "ĐỖ");

            Element Object = doc.createElement("Object");


            
            doc.appendChild(Object);

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

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public void writeStudent(Document doc, Element Object, Student student) {
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
}
