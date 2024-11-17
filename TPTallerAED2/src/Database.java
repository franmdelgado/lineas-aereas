import service.GestorVuelos;

import static service.GestorVuelos.BUENOS_AIRES;
import static service.GestorVuelos.CORDOBA;
import static service.GestorVuelos.JUJUY;

public class Database {
    private static final GestorVuelos gestor = GestorVuelos.getInstance();
    public static void create(){
        gestor.crearVuelo(CORDOBA, JUJUY, 10);

        gestor.addPassenger("Juan", "Perez", 123, CORDOBA, JUJUY);
        gestor.addPassenger("Pedro", "Dominguez", 456, CORDOBA, JUJUY);
        gestor.addPassenger("Lucia", "Gonzalez", 789, CORDOBA, JUJUY);
        gestor.addPassenger("Florencia", "Schmidt", 321, CORDOBA, JUJUY);
        gestor.addPassenger("Gustavo", "Rodriguez", 654, CORDOBA, JUJUY);
        gestor.addPassenger("Carlos", "Torres", 987, CORDOBA, JUJUY);
        gestor.addPassenger("Lourdes", "Angulo", 147, CORDOBA, JUJUY);
        gestor.addPassenger("Gisela", "Diaz", 258, CORDOBA, JUJUY);
        gestor.addPassenger("Jose", "Solari", 369, CORDOBA, JUJUY);
        //gestor.addPassenger("Candela", "Suarez", 753, CORDOBA, JUJUY);
        //gestor.addPassenger("Nadia", "Martinez", 753, CORDOBA, BUENOS_AIRES);

        gestor.crearVuelo(JUJUY, BUENOS_AIRES, 10);
        gestor.addPassenger("Juan", "Perez", 123, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Pedro", "Dominguez", 456, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Lucia", "Gonzalez", 789, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Florencia", "Schmidt", 321, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Gustavo", "Rodriguez", 654, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Carlos", "Torres", 987, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Lourdes", "Angulo", 147, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Gisela", "Diaz", 258, JUJUY, BUENOS_AIRES);
        gestor.addPassenger("Gisela", "Diaz", 258, JUJUY, BUENOS_AIRES);
        //gestor.addPassenger("Gisela", "Diaz", 258, JUJUY, BUENOS_AIRES);


    }
}
