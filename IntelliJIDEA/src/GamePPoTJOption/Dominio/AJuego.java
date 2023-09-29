package GamePPoTJOption.Dominio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;


public class AJuego {
    private static ImageIcon iconoJuego = new ImageIcon(AJuego.class.getResource("juego.png"));
    private static ImageIcon iconoBienvenida = new ImageIcon(AJuego.class.getResource("bienvenida.png"));
    private static ImageIcon iconoInstrucciones = new ImageIcon(AJuego.class.getResource("instrucciones.png"));
    private static ImageIcon iconoHumano = new ImageIcon(AJuego.class.getResource("humano2.png"));
    private static ImageIcon iconoMaquina = new ImageIcon(AJuego.class.getResource("robot.png"));
    private static ImageIcon iconoSeleccion = new ImageIcon(AJuego.class.getResource("juego2.png"));
    private static ImageIcon iconoEmpate = new ImageIcon(AJuego.class.getResource("apretonManos.png"));
    private static ImageIcon iconoVictoria = new ImageIcon(AJuego.class.getResource("Trofeo.png"));
    private static Random jugadaMaquina = new Random();
    private static AJugador humano = new AJugador(AJugador.nombreUsuario());
    private static AJugador computadora = new AJugador("PC");



    private static Object[] OPCIONES_JUEGO = Arrays.asList("Ver instrucciones", "Jugar", "Resultados").toArray();
    private static Object[] ELEMENTOS = Arrays.asList("Piedra", "Papel", "Tijera").toArray();

    public static final int VER_INSTRUCCIONES = 0;
    public static final int JUGAR = 1;
    public static final int RESULTADOS = 2;


    public static List<String> opcionesDelJuego = new ArrayList<>();

    static {
        opcionesDelJuego.add("Piedra");
        opcionesDelJuego.add("Papel");
        opcionesDelJuego.add("Tijera");

    }

    public static int mostrarMenu() {
        int opcion = JOptionPane.showOptionDialog(null,
                "Hola " + humano.getNombre() + " ¿Qué deseas realizar?", "Juego PPvT", 0, 0,
                iconoJuego, OPCIONES_JUEGO, null);

        if (opcion == JOptionPane.CLOSED_OPTION) {
            System.exit(opcion);
        }
        return opcion;
    }

    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Juego piedra papel o tijera", 0, iconoInstrucciones);
    }

    public static void mostrarMensajeSeleccion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Juego piedra papel o tijera", 0, iconoSeleccion);
    }

    public static void mostrarMensajeHumano(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Juego piedra papel o tijera", 0, iconoHumano);
    }

    public static void mostrarMensajeMaquina(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Juego piedra papel o tijera", 0, iconoMaquina);
    }

    public static void mostrarMensajeEmapte(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Juego piedra papel o tijera", 0, iconoEmpate);
    }

    public static void mostrarMensajeResultados(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Juego piedra papel o tijera", 0, iconoVictoria);
    }


    public static void mostrarInstrucciones() {
        mostrarMensaje("1. Ambos jugadores eligen uno de los tres elementos: piedra, papel o tijera.\n" +
                "2. Las reglas son simples: la piedra aplasta las tijeras, las tijeras cortan el papel y el papel cubre la piedra.\n" +
                "3. El ganador se determina según las reglas mencionadas: quien elija un elemento que venza al del oponente gana la ronda. \n" +
                "4. Puedes jugar varias rondas para determinar un ganador general o simplemente jugar por diversión.");

    }

    public static int jugar() {
        Object opcionSeleccionada = JOptionPane.showInputDialog(
                null, "Juguemos!\nPor favor seleccione una opción",
                "Juego piedra papel o tijera", 0, iconoJuego, ELEMENTOS, 0);

        return 0;
    }

    public static int jugarMaquina() {
        int numeroMaquina = jugadaMaquina.nextInt(opcionesDelJuego.size());
        String eleccionMaquina = opcionesDelJuego.get(numeroMaquina);
        mostrarMensajeSeleccion("La maquina saco: " + eleccionMaquina);
        return numeroMaquina;
    }

    public static void ejecutarJuego() {
        int eleccionHumano = jugar();
        int eleccionMaquina = jugarMaquina();

        if (eleccionHumano == 0 && eleccionMaquina == 0 ||
                eleccionHumano == 1 && eleccionMaquina == 1 ||
                eleccionHumano == 2 && eleccionMaquina == 2) {
            mostrarMensajeEmapte("Empate");
            AJugador.sumarEmpates();


        } else if (eleccionHumano == 0 && eleccionMaquina == 1 ||
                eleccionHumano == 1 && eleccionMaquina == 2 ||
                eleccionHumano == 2 && eleccionMaquina == 0) {
            mostrarMensajeMaquina("Ganó la maquina");
            AJugador.sumarDerrotas();
        } else if (eleccionHumano == 0 && eleccionMaquina == 2 ||
                eleccionHumano == 1 && eleccionMaquina == 0 ||
                eleccionHumano == 2 && eleccionMaquina == 1) {
            mostrarMensajeHumano("Felicidades " + humano.getNombre() + "\n Ganaste");
            AJugador.sumarVictorias();
        }
    }

    public static void mostrarResultados() {
        String estadisticasHumano = "Nombre del jugador: " + humano.getNombre() +
                "\n Victorias: " + AJugador.getVictorias() +
                "\n Derrotas: " + AJugador.getDerrotas() +
                "\n Empates: " + AJugador.getEmpates();
        String estadisticasMaquina = "\n \n \n Nombre del jugador: " + computadora.getNombre() +
                "\n Victorias: " + AJugador.getDerrotas() +
                "\n Derrotas : " + AJugador.getVictorias() +
                "\n Empates: " + AJugador.getEmpates();

        mostrarMensajeResultados(estadisticasHumano + estadisticasMaquina);
    }


    public static ImageIcon getIconoBienvenida() {
        return iconoBienvenida;
    }

}

