package data;

import service.GestorVuelos;
import util.Grafo;

public class Database {
    public static String CORDOBA = "CORDOBA";
    public static String BUENOS_AIRES = "BS_AS";
    public static String JUJUY = "JUJUY";
    public static String BARILOCHE = "BARILOCHE";
    public static String MISIONES = "MISIONES";
    public static String SALTA = "SALTA";
    public static String TUCUMAN = "TUCUMAN";
    public static String SANTA_CRUZ = "SANTA_CRUZ";
    private static final GestorVuelos gestor = GestorVuelos.getInstance();

    public static void create(){
        /*
        SE CREAN 10 VUELOS Y SE AGREGAN ALGUNOS PASAJEROS COMO BASE DE DATOS INICIAL
         */
        //Vuelo completo
        gestor.createFlight(CORDOBA, JUJUY, 10);
        gestor.addPassenger("Juan", "Perez", 123, CORDOBA, JUJUY);
        gestor.addPassenger("Pedro", "Dominguez", 456, CORDOBA, JUJUY);
        gestor.addPassenger("Lucia", "Gonzalez", 789, CORDOBA, JUJUY);
        gestor.addPassenger("Florencia", "Schmidt", 321, CORDOBA, JUJUY);
        gestor.addPassenger("Gustavo", "Rodriguez", 654, CORDOBA, JUJUY);
        gestor.addPassenger("Carlos", "Torres", 987, CORDOBA, JUJUY);
        gestor.addPassenger("Lourdes", "Angulo", 147, CORDOBA, JUJUY);
        gestor.addPassenger("Gisela", "Diaz", 258, CORDOBA, JUJUY);
        gestor.addPassenger("Jose", "Solari", 369, CORDOBA, JUJUY);
        gestor.addPassenger("Candela", "Suarez", 753, CORDOBA, JUJUY);

        //Vuelo al 90% de capacidad
        gestor.createFlight(JUJUY, BUENOS_AIRES, 10);
        gestor.addPassenger("Juan", "Perez", 123, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Pedro", "Dominguez", 456, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Lucia", "Gonzalez", 789, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Florencia", "Schmidt", 321, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Gustavo", "Rodriguez", 654, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Carlos", "Torres", 987, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Lourdes", "Angulo", 147, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Gisela", "Diaz", 258, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Gisela", "Diaz", 258, JUJUY, BUENOS_AIRES);

        //Vuelo al 50% de capacidad
        gestor.createFlight(TUCUMAN, CORDOBA, 10);
        gestor.addPassenger("Juan", "Perez", 123, TUCUMAN, CORDOBA);
        gestor.addPassenger("Pedro", "Dominguez", 456, TUCUMAN, CORDOBA);
        gestor.addPassenger("Lucia", "Gonzalez", 789, TUCUMAN, CORDOBA);
        gestor.addPassenger("Florencia", "Schmidt", 321, TUCUMAN, CORDOBA);
        gestor.addPassenger("Gustavo", "Rodriguez", 654, TUCUMAN, CORDOBA);

        //creacion de vuelo incorrecto
        gestor.createFlight(CORDOBA, SALTA, 10);

        //Vuelo al 70% de capacidad
        gestor.createFlight(CORDOBA, BARILOCHE, 10);
        gestor.addPassenger("Juan", "Perez", 123, CORDOBA, BARILOCHE);
        gestor.addPassenger("Pedro", "Dominguez", 456, CORDOBA, BARILOCHE);
        gestor.addPassenger("Lucia", "Gonzalez", 789, CORDOBA, BARILOCHE);
        gestor.addPassenger("Florencia", "Schmidt", 321, CORDOBA, BARILOCHE);
        gestor.addPassenger("Gustavo", "Rodriguez", 654, CORDOBA, BARILOCHE);
        gestor.addPassenger("Carlos", "Torres", 987, CORDOBA, BARILOCHE);
        gestor.addPassenger("Lourdes", "Angulo", 147, CORDOBA, BARILOCHE);

        //Vuelo al 10% de capacidad
        gestor.createFlight(BUENOS_AIRES, MISIONES, 10);
        gestor.addPassenger("Juan", "Perez", 123, BUENOS_AIRES, MISIONES);

        //Vuelo al 20% de capacidad
        gestor.createFlight(BUENOS_AIRES, CORDOBA, 10);
        gestor.addPassenger("Juan", "Perez", 123, BUENOS_AIRES, CORDOBA);
        gestor.addPassenger("Pedro", "Dominguez", 456, BUENOS_AIRES, CORDOBA);

        //Vuelo al 30% de capacidad
        gestor.createFlight(BUENOS_AIRES, SANTA_CRUZ, 10);
        gestor.addPassenger("Juan", "Perez", 123, BUENOS_AIRES, SANTA_CRUZ);
        gestor.addPassenger("Pedro", "Dominguez", 456, BUENOS_AIRES, SANTA_CRUZ);
        gestor.addPassenger("Lucia", "Gonzalez", 789, BUENOS_AIRES, SANTA_CRUZ);

        //Vuelo al 80% de capacidad
        gestor.createFlight(SANTA_CRUZ, BARILOCHE, 10);
        gestor.addPassenger("Juan", "Perez", 123, SANTA_CRUZ, BARILOCHE);
        gestor.addPassenger("Pedro", "Dominguez", 456, SANTA_CRUZ, BARILOCHE);
        gestor.addPassenger("Lucia", "Gonzalez", 789, SANTA_CRUZ, BARILOCHE);
        gestor.addPassenger("Florencia", "Schmidt", 321, SANTA_CRUZ, BARILOCHE);
        gestor.addPassenger("Gustavo", "Rodriguez", 654, SANTA_CRUZ, BARILOCHE);
        gestor.addPassenger("Carlos", "Torres", 987, SANTA_CRUZ, BARILOCHE);
        gestor.addPassenger("Lourdes", "Angulo", 147, SANTA_CRUZ, BARILOCHE);
        gestor.addPassenger("Gisela", "Diaz", 258, SANTA_CRUZ, BARILOCHE);

        //Vuelo al 60% de capacidad
        gestor.createFlight(SALTA, BUENOS_AIRES, 10);
        gestor.addPassenger("Juan", "Perez", 123, SALTA, BUENOS_AIRES);
        gestor.addPassenger("Pedro", "Dominguez", 456, SALTA, BUENOS_AIRES);
        gestor.addPassenger("Lucia", "Gonzalez", 789, SALTA, BUENOS_AIRES);
        gestor.addPassenger("Florencia", "Schmidt", 321, SALTA, BUENOS_AIRES);
        gestor.addPassenger("Gustavo", "Rodriguez", 654, SALTA, BUENOS_AIRES);
        gestor.addPassenger("Carlos", "Torres", 987, SALTA, BUENOS_AIRES);

        //Vuelo al 40% de capacidad
        gestor.createFlight(BARILOCHE, CORDOBA, 10);
        gestor.addPassenger("Juan", "Perez", 123, BARILOCHE, CORDOBA);
        gestor.addPassenger("Pedro", "Dominguez", 456, BARILOCHE, CORDOBA);
        gestor.addPassenger("Lucia", "Gonzalez", 789, BARILOCHE, CORDOBA);
        gestor.addPassenger("Florencia", "Schmidt", 321, BARILOCHE, CORDOBA);

        //Vuelo vacio
        gestor.createFlight(MISIONES, BUENOS_AIRES, 10);

        //por simplicidad no se admite la creacion de un vuelo origen -> destino existente
        gestor.createFlight(MISIONES, BUENOS_AIRES, 10);

    }

    public static Grafo crearMatrizIncidencia(){
        Grafo matrizIncidencia = new Grafo();

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

        return matrizIncidencia;
    }
}
