package AgendaTelefonica.App;

import AgendaTelefonica.Dominio.Agenda;
import AgendaTelefonica.Dominio.Contacto;

public class AppAgenda {
    public static void main(String[] args) {
        Agenda Agenda = new Agenda();


        Agenda.crearContacto("Palomo", "Palomo", 666);
        Agenda.crearContacto("Juan","Garcia", 310);
        Agenda.crearContacto("Marco", "Zapata", 312);
        Agenda.crearContacto("Simon","Cardenas", 311);
        Agenda.crearContacto("Ciro", "Ciro", 58);

        Agenda.mostrarlistaContacto(Agenda.getContactos());

        Agenda.eliminarContacto(444);

        Agenda.buscarPorNombre("Marco");

        Agenda.buscarPorApellido("Ciro");

        Agenda.buscarPorCelular(310);


        Agenda.cambiarCelular(58,500);
        Agenda.mostrarlistaContacto(Agenda.getContactos());

        System.out.println("");
        Agenda.mostrarlistaContacto(Agenda.ordenarAlfabeticamente());

    }
}
