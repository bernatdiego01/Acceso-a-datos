package com.mycompany.xml;

/**
 *
 * @author berna
 */

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Xml {
    public static void main(String args[]) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            doc.setXmlVersion("1.1");
            doc.setXmlStandalone(false);
            // Curs de 1r

            Element cicle = doc.createElement("cicle");
            cicle.setAttribute("nom", "1r de DAM");

            doc.appendChild(doc);

            // Primer modul (creant l'atribut per separat)

            Element modulo1 = doc.createElement("modulo1");
            modulo1.appendChild(modulo1);
            // Se agrega un atributo al nodo elemento y su valor
            Attr attr = doc.createAttribute("nom");
            attr.setValue("Sistemes informàtics");
            modulo1.setAttributeNode(attr);
            Element hores = doc.createElement("Nombre d'hores");
            hores.setTextContent("125");
            modulo1.appendChild(hores);

            // Segon modul

            Element modulo2 = doc.createElement("modulo2");
            cicle.appendChild(modulo2);
            Attr attr2 = doc.createAttribute("nom");
            attr.setValue("Programacio");
            modulo2.setAttributeNode(attr2);
            Element hores2 = doc.createElement("Nombre d'hores");
            hores2.setTextContent("70");
            modulo2.appendChild(hores2);

            // tercer modul

            Element modulo3 = doc.createElement("modulo3");

            Attr attr3 = doc.createAttribute("nom");
            attr.setValue("Base de dades");
            modulo3.setAttributeNode(attr3);
            Element hores3 = doc.createElement("Nombre d'hores");
            hores3.setTextContent("125");
            modulo3.appendChild(hores3);
            doc.appendChild(modulo2);

            Element cicle2 = doc.createElement("cicle");
            cicle.setAttribute("nom", "2n de DAM");
            doc.appendChild(doc);

            Element modulo1_2n = doc.createElement("modulo1");
            modulo1_2n.setAttribute("Codigo", "01");

            Element mis1 = doc.createElement("Nombre");
            mis1.appendChild(doc.createTextNode("Acces a dades"));
            cicle2.appendChild(mis1);
            Element mis2 = doc.createElement("Hores");
            mis2.appendChild(doc.createTextNode("125"));
            cicle2.appendChild(mis2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(
                    new File("C:\\Users\\berna\\Desktop\\DAM2\\Accés a dades\\XML en Java"));
            transformer.transform(source, result);

        } catch (IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException e) {
        }
    }
}