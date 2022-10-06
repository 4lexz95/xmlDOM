package Lecturas;

import models.Empleado;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File ficherEmpleadosXML = new File("Empleados.xml");

        //Herramienta(Document Builder Factory) que permita parsear el fichero XML => NO LEO PASO A PASO EL FICHERO
        //Lee todo el fichero y intentar montar estructura tipo dom y coger los nodos que corresponden

        // es para generar variables de tipo  docuemens
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        //ahora cargo dentor de una variable Documento
        Document document = db.parse(ficherEmpleadosXML);


        //Limpio los nodos para una mejor visualizacion (quitarle carcteres especiales)
        document.getDocumentElement().normalize();

//Eso hara que acceda a la raiz del documento
        System.out.println("Raiz del documento: "+ document.getDocumentElement().getNodeName());


        //sacar lista de nodos almacenar en una variable

        //NodeList nodos = document.getChildNodes();
        NodeList nodos = document.getElementsByTagName("empleado");

        for (int i = 0; i < nodos.getLength(); i++) {
            //Extraer el nodo

            Node nodo = nodos.item(i);
            System.out.println("elemento: "+ nodo.getNodeName());
            //compruebo que tiene hijos dentro
            if (nodo.getNodeType() == Node.ELEMENT_NODE){
                Element empleado = (Element) nodo;
                //Atributos
                String dni = empleado.getAttribute("dni");
                String apellido = empleado.getElementsByTagName("apellido").item(0).getTextContent();
                //getTextContent() para leer el texto dentro del elementos
                int id = Integer.parseInt(empleado.getElementsByTagName("id").item(0).getTextContent());
                int dep = Integer.parseInt(empleado.getElementsByTagName("dep").item(0).getTextContent());
                float salario = Float.parseFloat(empleado.getElementsByTagName("dep").item(0).getTextContent());

                //subnodos

                //creamos
                Empleado emp = new Empleado(id,apellido,dep,salario);
                System.out.println(emp);


            }


        }







    }
}
