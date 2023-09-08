package AgendaTelefonica.Dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Agenda {
    private List<Contacto> contactos;
    public static final int CAPACIDAD_AGENDA=50;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }


    public void crearContacto(String nombre, String apellido, long celular) {
        Contacto c = this.buscarPorCelular(celular);

        if (this.contactos.size() < CAPACIDAD_AGENDA && c == null) {
            Contacto contactoAAgregar = new Contacto(nombre, apellido, celular);
            this.contactos.add(contactoAAgregar);

        } else {
            System.out.println("");
            System.out.println("El contacto no se pudo crear.");
        }
    }


    public boolean eliminarContacto(long celularAEliminar) {
        Contacto contactoExistente = this.buscarPorCelular(celularAEliminar);

        if (contactoExistente != null) {
            this.contactos.remove(contactoExistente);
            mostrarlistaContacto(contactos);
            return true;
        }
        System.out.println("");
        System.out.println("El contacto no existe, no es posible eliminarlo");
        return false;
    }


    public List<Contacto> buscarPorNombre(String nombreABuscar) {
        List<Contacto> contactosPorNombre = new ArrayList<>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombreABuscar)) {
                contactosPorNombre.add(contacto);
                System.out.println("");
                System.out.println("Contacto encontrado ");
                mostrarlistaContacto(contactosPorNombre);
            }
        }
        return contactosPorNombre;
    }


    public List<Contacto> buscarPorApellido(String apellidoABuscar) {
        List<Contacto> contactosPorApellido = new ArrayList<>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getApellido().equalsIgnoreCase(apellidoABuscar)) {
                contactosPorApellido.add(contacto);
                System.out.println("");
                System.out.println("Contacto encontrado ");
                mostrarlistaContacto(contactosPorApellido);
            }
        }

        return contactosPorApellido;
    }


    public Contacto buscarPorCelular(long celularABuscar) {
        List<Contacto> contactoCelularABuscar = new ArrayList<>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getCelular()==celularABuscar) {
                contactoCelularABuscar.add(contacto);

                return contacto;
            }
        }
        mostrarlistaContacto(contactoCelularABuscar);
        return null;
    }


    public void cambiarCelular(long celularActual, long nuevoCelular) {
        Contacto contactoExistente = this.buscarPorCelular(celularActual);

        if (contactoExistente != null) {
            contactoExistente.celular=nuevoCelular;
            System.out.println("");
            System.out.println("Numero cambiado con exito ");

        }
    }


    public List<Contacto> ordenarAlfabeticamente(){
        this.contactos.sort(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido));
        return this.contactos;
    }


    public void mostrarlistaContacto(List<Contacto>list){

        for (Contacto c : list) {
            System.out.println("   Nombre: " + c.getNombre() + "  Apellido: " + c.getApellido() + "  Celular: " + c.getCelular());
        }

    }

    public List<Contacto> getContactos() {
        return contactos;
    }
}


