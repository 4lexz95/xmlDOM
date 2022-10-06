package Escritura;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        //Creo un elemento
         Element raiz = document.createElement("estudiantes");
         //Se lo enchufo al padre
         document.appendChild(raiz);


         // Creamos el primer estudiante
        Element estudia1 = document.createElement("estudiante");
        raiz.appendChild(estudia1);


        //agregamos un atributo

        Attr dni1 = document.createAttribute("dni");
        dni1.setValue("12345678H");
        estudia1.setAttributeNode(dni1);

        Element nombre1 = document.createElement("nombre");
        estudia1.appendChild(nombre1);
        nombre1.setTextContent("Yeffry");

        Element nota1 = document.createElement("nota");
        estudia1.appendChild(nota1);
        nota1.setTextContent("4.5");


        //Creamos 2º estudiante

        // Creamos el 2º estudiante
        Element estudia2 = document.createElement("estudiante");
        raiz.appendChild(estudia2);


        //agregamos un atributo

        Attr dni2 = document.createAttribute("dni");
        dni2.setValue("12345678H");
        estudia2.setAttributeNode(dni2);

        Element nombre2 = document.createElement("nombre");
        estudia2.appendChild(nombre2);
        nombre2.setTextContent("Yeffry");

        Element nota2 = document.createElement("nota");
        estudia2.appendChild(nota2);
        nota2.setTextContent("4.5");

// Transforma el documento en formato dom y de ahi escribirlo en un fichero
        // Creamos un traductor de elements a DOM
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer optimus = tf.newTransformer();
        DOMSource  ds = new DOMSource(document);

        //OJO LA LINEA DEL MILLON
        optimus.setOutputProperty(OutputKeys.INDENT, "yes");


        StreamResult result = new StreamResult(new File("estudiantes.xml"));
        optimus.transform(ds, result);



    }
}
