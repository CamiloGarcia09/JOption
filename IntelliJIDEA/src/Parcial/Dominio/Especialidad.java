package Parcial.Dominio;


public class Especialidad {
    private String nombre;


    public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad(){
        this.nombre = "Ansiedad";
    }

    public String getNombre() {
        return nombre;
    }
}
