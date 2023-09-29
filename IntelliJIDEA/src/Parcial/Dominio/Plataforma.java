package Parcial.Dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Plataforma {

    public static final int CAPACIDAD_PLATAFORMA= 80;
    private List<Terapeuta> terapeutas;
    private String nombre;


    public Plataforma(){
        this.terapeutas = new ArrayList<>();

    }


    public boolean registrarTemperatura(String nombre, int tarifa) {
        Terapeuta t = this.buscar(nombre);

        if(this.terapeutas.size() < CAPACIDAD_PLATAFORMA && t == null){
            Terapeuta terapeutaAAgregar = new Terapeuta(nombre, tarifa);
            this.terapeutas.add(terapeutaAAgregar);
            return true;
        }

        return false;

    }


    public void eliminarTerapeuta(String nombre){
        Terapeuta terapeutaExistente = this.buscar(nombre);
        if (terapeutaExistente!= null){
            this.terapeutas.remove(terapeutaExistente);

        }
        System.out.println("El terapeuta no existe");
    }


    public Terapeuta buscar (String nombre) {

        for (Terapeuta terapeuta : this.terapeutas) {
            if (terapeuta.getNombre().equalsIgnoreCase(nombre)) {
                return terapeuta;
            }
        }
        return null;
    }


    public List<Terapeuta> buscar (int tarifa){
        List<Terapeuta> precio = new ArrayList<>();

        for (Terapeuta terapeuta : this.terapeutas) {
            if (terapeuta.getTarifa() <= (tarifa)) {
                precio.add(terapeuta);
            }
        }
        return precio;
    }


    public List<Terapeuta> buscarPorEspecialidad (String especialidad){
        List<Terapeuta> buscarEspecialidad = new ArrayList<>();

        for (Terapeuta terapeuta : this.terapeutas) {
            for (Especialidad especilidad : terapeuta.getEspecilidades()){
                if (especilidad.getNombre().equals(especialidad)) {

                    buscarEspecialidad.add(terapeuta);
                }
            }
        }
        return buscarEspecialidad;
    }


    public List<Terapeuta> getTerapeutasConMasDeDosEspecialidades(){

        return this.terapeutas.stream()
                .filter(e -> e.getEspecilidades().size()>= 2)
                .toList();
    }


    public List<Terapeuta> ordenarTerapeutasPorTarifas (){

        this.terapeutas.sort(
                Comparator.comparing(Terapeuta::getTarifa)
                        .reversed()
        );
        return this.terapeutas;

    }


    
    public List<Terapeuta> getTerapeutas() {
        return terapeutas;
    }

}

