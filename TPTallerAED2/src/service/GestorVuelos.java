package service;

import entities.Vuelo;
import model.ShortestPathResponse;
import util.Arista;
import util.Grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorVuelos {
    public static String CORDOBA = "CORDOBA";
    public static String BUENOS_AIRES = "BS AS";
    public static String JUJUY = "JUJUY";
    public static String BARILOCHE = "BARILOCHE";
    public static String MISIONES = "MISIONES";
    public static String SALTA = "SALTA";
    public static String TUCUMAN = "TUCUMAN";
    public static String SANTA_CRUZ = "SANTA CRUZ";
    private final List<Vuelo> vuelos;
    private static GestorVuelos instance;
    private final Grafo matrizIncidencia;

    private GestorVuelos() {
        this.vuelos = new ArrayList<>();
        matrizIncidencia = new Grafo();
        crearMatrizIncidencia();
    }

    public static GestorVuelos getInstance(){
        if(instance == null)
            instance = new GestorVuelos();

        return instance;
    }

    private void crearMatrizIncidencia(){
        matrizIncidencia.addArista(CORDOBA, BUENOS_AIRES, 120000);
        matrizIncidencia.addArista(CORDOBA, JUJUY, 80000);
        matrizIncidencia.addArista(CORDOBA, BARILOCHE, 200000);

        matrizIncidencia.addArista(BUENOS_AIRES, CORDOBA, 150000);
        matrizIncidencia.addArista(BUENOS_AIRES, JUJUY, 120000);
        matrizIncidencia.addArista(BUENOS_AIRES, BARILOCHE, 250000);
        matrizIncidencia.addArista(BUENOS_AIRES, MISIONES, 200000);
        matrizIncidencia.addArista(BUENOS_AIRES, SANTA_CRUZ, 350000);

        matrizIncidencia.addArista(JUJUY, CORDOBA, 75000);
        matrizIncidencia.addArista(JUJUY, BUENOS_AIRES, 120000);
        matrizIncidencia.addArista(JUJUY, SALTA, 55000);
        matrizIncidencia.addArista(JUJUY, TUCUMAN, 68000);

        matrizIncidencia.addArista(BARILOCHE, CORDOBA, 220000);
        matrizIncidencia.addArista(BARILOCHE, BUENOS_AIRES, 350000);
        matrizIncidencia.addArista(BARILOCHE, SANTA_CRUZ, 550000);

        matrizIncidencia.addArista(MISIONES, BUENOS_AIRES, 170000);

        matrizIncidencia.addArista(SALTA, CORDOBA, 60000);
        matrizIncidencia.addArista(SALTA, BUENOS_AIRES, 110000);
        matrizIncidencia.addArista(SALTA, JUJUY, 80000);
        matrizIncidencia.addArista(SALTA, TUCUMAN, 60000);

        matrizIncidencia.addArista(TUCUMAN, CORDOBA, 55000);
        matrizIncidencia.addArista(TUCUMAN, BUENOS_AIRES, 1250000);
        matrizIncidencia.addArista(TUCUMAN, JUJUY, 20000);

        matrizIncidencia.addArista(SANTA_CRUZ, BUENOS_AIRES, 380000);
        matrizIncidencia.addArista(SANTA_CRUZ, BARILOCHE, 550000);
    }

    public void crearVuelo(String origen, String destino, int capacidad){
        Vuelo vuelo = new Vuelo(origen, destino, capacidad);
        this.vuelos.add(vuelo);
    }

    public void addPassenger(String name, String surname, int dni, String origen, String destino){
        Optional<Vuelo> vuelo = findVuelo(origen, destino);
        if(vuelo.isPresent()) {
            if(!vuelo.get().addPassenger(name, surname, dni)) {
                System.out.print("\nEl pasajero " + name + " " + surname + " DNI: " + dni);
                System.out.println(" no pudo ser agregado, el vuelo esta completo");
            }
        }
        else {
            System.out.print("\nEl pasajero " + name + " " + surname + " DNI: " + dni);
            System.out.println(" no pudo ser agregado porque el vuelo " + origen + " -> " + destino + " no existe");
        }
    }

    public Optional<Vuelo> findVuelo(String origen, String destino){
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getOrigen().equalsIgnoreCase(origen) && vuelo.getDestino().equalsIgnoreCase(destino))
                return Optional.of(vuelo);
        }
        return Optional.empty();
    }

    public void imprimirVuelo(String origen, String destino){
        Optional<Vuelo> vuelo = findVuelo(origen, destino);
        if (vuelo.isPresent())
            vuelo.get().imprimirVuelo();
        else
            System.out.println("\nNo existe informacion para mostrar porque el vuelo " + origen + " -> " + destino + " no fue creado");
    }

    public int getDefaultPrice(String origen, String destino){
        List<Arista> aristas = matrizIncidencia.getVecinos(origen);
        for(Arista a : aristas){
            if(a.getDestino().equalsIgnoreCase(destino))
                return a.getPeso();
        }
        return -1;
    }

    public ShortestPathResponse getCheaperFlight(String origen, String destino){
        return matrizIncidencia.getShortestPath(origen, destino);
    }

}
