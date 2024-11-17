package entities;

public class Tripulante {
    private String name;
    private String surname;
    private int dni;

    public Tripulante(String name, String surname, int dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Tripulante{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni=" + dni +
                '}';
    }
}
