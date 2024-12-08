import model.ShortestPathResponse;
import data.Database;
import service.GestorVuelos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Database.create();
            GestorVuelos gestor = GestorVuelos.getInstance();
            Scanner sc = new Scanner(System.in);
            int op;
            String or, de;

            do{
                System.out.println("\n===== MENÚ DE OPCIONES =====");
                System.out.println("1- Crear vuelo");
                System.out.println("2- Registrar tripulante");
                System.out.println("3- Buscar vuelo mas barato");
                System.out.println("4- Imprimir vuelo");
                System.out.println("5- Salir");
                System.out.print("Seleccione una opción: ");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        opciones();
                        System.out.print("Origen: ");
                        or = sc.next();
                        System.out.print("Destino: ");
                        de = sc.next();
                        System.out.print("Capacidad: ");
                        int cap = sc.nextInt();
                        gestor.createFlight(or, de, cap);
                        break;
                    case 2:
                        opciones();
                        System.out.print("Origen: ");
                        or = sc.next();
                        System.out.print("Destino: ");
                        de = sc.next();
                        System.out.print("Nombre: ");
                        String nombre = sc.next();
                        System.out.print("Apellido: ");
                        String apellido = sc.next();
                        System.out.print("DNI: ");
                        int dni = sc.nextInt();
                        gestor.addPassenger(nombre, apellido, dni, or, de);
                        break;
                    case 3:
                        opciones();
                        System.out.print("Origen: ");
                        or = sc.next();
                        System.out.print("Destino: ");
                        de = sc.next();

                        ShortestPathResponse sp = gestor.getCheaperFlight(or, de);
                        System.out.println("Opcion mas barata viajando desde " + or + " hasta " + de + ": " + String.join(" -> ", sp.getPath()));
                        System.out.println("Costo total: $" + sp.getTotalCost());
                        break;
                    case 4:
                        opciones();
                        System.out.print("Origen: ");
                        or = sc.next();
                        System.out.print("Destino: ");
                        de = sc.next();
                        gestor.printFlight(or, de);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (op != 5);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void opciones(){
        System.out.println("Elija entre estas opciones");
        System.out.println("CORDOBA");
        System.out.println("BS_AS");
        System.out.println("JUJUY");
        System.out.println("BARILOCHE");
        System.out.println("MISIONES");
        System.out.println("SALTA");
        System.out.println("TUCUMAN");
        System.out.println("SANTA_CRUZ\n");
    }
}