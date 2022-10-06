package xstream;

import com.thoughtworks.xstream.XStream;
import models.Empleado;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado(1,"Garcia", 20,2456.45f);

        XStream xStream = new XStream();
        //para mapearo
        xStream.allowTypesByWildcard(new String[]{
                "models.*"

        });
        String xml =xStream.toXML(empleado);

        //transformalo en xml
        System.out.println(xml);
        Empleado empleado2 = new Empleado();
        xStream.fromXML(xml,empleado2);
        System.out.println(empleado2);

    }
}
