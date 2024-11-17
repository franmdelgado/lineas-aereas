package util;

import entities.Tripulante;

public class NodoAVL {
    private int seat;
    private Tripulante tripulante;
    private NodoAVL left;
    private NodoAVL right;
    private int height;

    public NodoAVL(int seat, Tripulante tripulante) {
        this.seat = seat;
        this.tripulante = tripulante;
        this.height = 1;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public NodoAVL getLeft() {
        return left;
    }

    public void setLeft(NodoAVL left) {
        this.left = left;
    }

    public NodoAVL getRight() {
        return right;
    }

    public void setRight(NodoAVL right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Tripulante getTripulante() {
        return tripulante;
    }

    public void setTripulante(Tripulante tripulante) {
        this.tripulante = tripulante;
    }
}
