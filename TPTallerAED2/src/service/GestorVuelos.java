package service;

import entities.Vuelo;
import model.ShortestPathResponse;
import data.Database;
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

    public void createFlight(String origen, String destino, int capacidad){
        Optional<Vuelo> v = findFlight(origen, destino);
        if(v.isPresent()) {
            System.out.println("El vuelo " + origen + " -> " + destino + " ya existe");
            return;
        }
        List<Arista> vecinos = matrizIncidencia.getVecinos(origen);
        for (Arista a : vecinos){
            if(a.getDestino().equals(destino)){
                Vuelo vuelo = new Vuelo(origen, destino, capacidad);
                this.vuelos.add(vuelo);
                System.out.println("Se ha creado el vuelo " + origen + " -> " + destino);
                return;
            }
        }
        System.out.println("No se puede crear el vuelo " + origen + " -> " + destino + ": " + destino + " no es vecino de " + origen);
    }

    public void addPassenger(String name, String surname, int dni, String origen, String destino){
        Optional<Vuelo> vuelo = findFlight(origen, destino);
        if(vuelo.isPresent()) {
            float p = vuelo.get().getPrice();
            if(!vuelo.get().addPassenger(name, surname, dni)) {
                System.out.print("\nEl pasajero " + name + " " + surname + " DNI: " + dni);
                System.out.println(" no pudo ser agregado, el vuelo esta completo");
            }
            else
                System.out.println("Tripulante " + name + " " + surname + " registrado. El precio es $" + p);
        }
        else {
            System.out.print("\nEl pasajero " + name + " " + surname + " DNI: " + dni);
            System.out.println(" no pudo ser agregado porque el vuelo " + origen + " -> " + destino + " no existe");
        }
    }

    public Optional<Vuelo> findFlight(String origen, String destino){
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getOrigen().equalsIgnoreCase(origen) && vuelo.getDestino().equalsIgnoreCase(destino))
                return Optional.of(vuelo);
        }
        return Optional.empty();
    }

    public void printFlight(String origen, String destino){
        Optional<Vuelo> vuelo = findFlight(origen, destino);
        if (vuelo.isPresent())
            vuelo.get().imprimirVuelo();
        else
            System.out.println("\nNo existe informacion para mostrar porque el vuelo " + origen + " -> " + destino + " no fue creado");
    }

    public int getDefaultPrice(String origen, String destino) {
        List<Arista> aristas = matrizIncidencia.getVecinos(origen);
        for(Arista a : aristas){
            if(a.getDestino().equalsIgnoreCase(destino))
                return a.getPeso();
        }
        throw new IllegalArgumentException("Error al obtener 'defaultPrice': El vertice " + destino + " no es vecino de " + origen);
    }

    public ShortestPathResponse getCheaperFlight(String origen, String destino){
        return matrizIncidencia.getShortestPath(origen, destino);
    }

}
