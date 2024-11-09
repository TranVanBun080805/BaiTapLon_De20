/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Vehicle;
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

/**
 *
 * @author tranb
 */
public class VehicleDao {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Vehicle vehicle = new Vehicle("37G1-23456", "Mec", "Thuc Hanh");
            Vehicle vehicle1 = new Vehicle("37G1-23456", "Lambo", "Thuc Hanh");
            Element ObJect = doc.createElement("ObJect");

            wirteVehicle(doc, ObJect, vehicle);
            wirteVehicle(doc, ObJect, vehicle1);

            doc.appendChild(ObJect);

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

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static public void wirteVehicle(Document doc, Element ObJect, Vehicle vehicle) {
        Element Vehicle =doc.createElement("Vehicle");
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
}
