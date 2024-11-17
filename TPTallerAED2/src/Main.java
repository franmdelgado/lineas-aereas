import model.ShortestPathResponse;
import others.Database;
import service.GestorVuelos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Database.create();
        GestorVuelos gestor = GestorVuelos.getInstance();
        Scanner sc = new Scanner(System.in);
        int op;
        String or, de;

        do{
            System.out.println("\n===== MENÚ DE OPCIONES =====");
            System.out.println("1- Registrar tripulante");
            System.out.println("2- Buscar vuelo mas barato");
            System.out.println("3- Imprimir vuelo");
            System.out.println("4- Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    // Código para la Opción 1
                    break;
                case 2:
                    opciones();
                    System.out.print("Origen: ");
                    or = sc.next();
                    System.out.print("Destino: ");
                    de = sc.next();

                    ShortestPathResponse sp = gestor.getCheaperFlight(or, de);
                    System.out.println("Opcion mas barata viajando desde " + or + " hasta " + de + ": " + String.join(" -> ", sp.getPath()));
                    System.out.println("Costo total: $" + sp.getTotalCost());
                    break;
                case 3:
                    opciones();
                    System.out.print("Origen: ");
                    or = sc.next();
                    System.out.print("Destino: ");
                    de = sc.next();
                    gestor.imprimirVuelo(or, de);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (op != 4);
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