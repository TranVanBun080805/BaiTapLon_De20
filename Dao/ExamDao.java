/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Exam;
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

public class ExamDao {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Exam exam = new Exam("23-11-2023","Ha Noi", "Ly Thuyet", "A1", 50);
            Exam exam1 = new Exam("24-12-2023","Ha Noi", "Thuc Hanh", "A1", 50);
            
            
            Element Object = doc.createElement("Object");


            doc.appendChild(Object);

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

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ExamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
}
