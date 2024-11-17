import model.ShortestPathResponse;
import service.GestorVuelos;

import static service.GestorVuelos.BARILOCHE;
import static service.GestorVuelos.BUENOS_AIRES;
import static service.GestorVuelos.CORDOBA;
import static service.GestorVuelos.MISIONES;
import static service.GestorVuelos.SALTA;
import static service.GestorVuelos.SANTA_CRUZ;
import static service.GestorVuelos.TUCUMAN;

public class Main {

    public static void main(String[] args) {
        Database.create();
        GestorVuelos gestor = GestorVuelos.getInstance();

        gestor.imprimirVuelo(CORDOBA, BUENOS_AIRES);
//        gestor.imprimirVuelo(IVuelo.CORDOBA, IVuelo.MISIONES);

        ShortestPathResponse sp = gestor.getCheaperFlight(CORDOBA, BUENOS_AIRES);
        System.out.println("Opcion mas barata viajando desde " + CORDOBA + " hasta " + BUENOS_AIRES + ": " + String.join(" -> ", sp.getPath()));
        System.out.println("Costo total: $" + sp.getTotalCost());
    }
}