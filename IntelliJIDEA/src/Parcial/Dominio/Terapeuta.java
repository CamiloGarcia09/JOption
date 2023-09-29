package Parcial.Dominio;

import java.util.ArrayList;
import java.util.List;

public class Terapeuta {
    private String nombre;
    private int tarifa;
    private List<Especialidad> especilidades;

    public Terapeuta(String nombre, int tarifa) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.especilidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getTarifa() {
        return tarifa;
    }


    public List<Especialidad> getEspecilidades() {
        return especilidades;
    }
}
