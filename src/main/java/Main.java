import code.EscribirJAXB;
import code.LeerJAXB;
import libs.Leer;

public class Main {
    public static void main(String[] args){
        boolean salir = false;
        int opcion;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Leer XML con JAXB");
            System.out.println("2. Escribir XML con JAXB");

            opcion = Leer.pedirEntero("Introduce una opción: ");

            switch (opcion) {
                case 0 -> {salir = true;}
                case 1 -> {LeerJAXB.leer();}
                case 2 -> {EscribirJAXB.escribir();}
                default -> {System.out.println("La opcion seleccionada no existe");}
            }
        } while (!salir);
    }
}
