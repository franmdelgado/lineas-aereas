package entities;

import service.GestorVuelos;
import util.ArbolAVL;
import util.NodoAVL;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private final ArbolAVL aeronave;
    private final String origen;
    private final String destino;
    private final int capacidad;
    private final List<Integer> seats;

    public Vuelo(String origen, String destino, int capacidad) {
        this.origen = origen;
        this.destino = destino;
        this.capacidad = capacidad;
        this.aeronave = new ArbolAVL();
        this.seats = new ArrayList<>();
    }

    public boolean addPassenger(String name, String surname, int dni){
        int seat = searchSeat(seats, capacidad);
        if(seat != -1) {
            aeronave.put(new NodoAVL(seat, new Tripulante(name, surname, dni)));
            return true;
        }
        else
            return false;
    }

    private int searchSeat(List<Integer> seats, int max){
        if(seats.size() == max)
            return -1;
        else{
            int value;
            do {
                value = (int) (Math.random() * max) + 1;
            }while(seats.contains(value));

            seats.add(value);
            return value;
        }
    }

    public void imprimirVuelo() {
        System.out.println("\nVuelo " + origen + " -> " + destino);
        this.aeronave.inOrden();
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    private float getOccupiedCapacity(){
        return this.seats.size() * 100 / (float)capacidad;
    }

    public float getPrice(){
        int defaultPrice = GestorVuelos.getInstance().getDefaultPrice(this.origen, this.destino);
        float occCap = getOccupiedCapacity();

        if(this.seats.size()+1 == capacidad)
            return defaultPrice * 0.6f;
        else{
            if(occCap >= 50 && occCap < 70)
                return defaultPrice * 0.9f;

            if(occCap >= 70 && occCap < 100)
                return defaultPrice * 0.8f;
        }

        return defaultPrice;
    }
}
