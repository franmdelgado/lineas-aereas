package service;

import entities.Vuelo;
import model.ShortestPathResponse;
import others.Database;
import util.Arista;
import util.Grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorVuelos {
    private final List<Vuelo> vuelos;
    private static GestorVuelos instance;
    private final Grafo matrizIncidencia;

    private GestorVuelos() {
        this.vuelos = new ArrayList<>();
        matrizIncidencia = Database.crearMatrizIncidencia();
    }

    public static GestorVuelos getInstance(){
        if(instance == null)
            instance = new GestorVuelos();

        return instance;
    }

    public void crearVuelo(String origen, String destino, int capacidad){
        List<Arista> vecinos = matrizIncidencia.getVecinos(origen);
        for (Arista a : vecinos){
            if(a.getDestino().equals(destino)){
                Vuelo vuelo = new Vuelo(origen, destino, capacidad);
                this.vuelos.add(vuelo);
                return;
            }
        }
        System.out.println("No se puede crear un vuelo a un destino que no sea vecino del origen");

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
