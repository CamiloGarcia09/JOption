package GamePPoTJOption.Dominio;
import javax.swing.*;

public class AJugador {
    private static int victorias=0;
    private static int derrotas=0;
    private static int empates=0;
    private  String nombre;

    public AJugador(String nombre) {
        this.nombre=nombre;
    }

    public static String nombreUsuario() {
        String nombreJugador = (String) JOptionPane.showInputDialog(null,
                "¿Cual es tu nombre?","PPoT", 0,
                AJuego.getIconoBienvenida(),null,null);
        return nombreJugador;
    }

    public static int sumarDerrotas(){
        derrotas +=1;
        return derrotas;
    }

    public static int sumarVictorias(){
        victorias += 1;
        return victorias;
    }

    public static int sumarEmpates(){
        empates += 1;
        return empates;
    }



    public static int getVictorias() {
        return victorias;
    }

    public static int getDerrotas() {
        return derrotas;
    }

    public  String getNombre() {
        return nombre;
    }

    public static int getEmpates() {
        return empates;
    }
}

