package GamePPoTJOption.App;
import GamePPoTJOption.Dominio.AJuego;


public class AppPPoT {
    public static void main(String[] args) {


        while (true) {
            int opcionElegida = AJuego.mostrarMenu();

            switch (opcionElegida) {

                case AJuego.VER_INSTRUCCIONES -> AJuego.mostrarInstrucciones();
                case AJuego.JUGAR -> AJuego.ejecutarJuego();
                case AJuego.RESULTADOS -> AJuego.mostrarResultados();

            }
        }
    }
}
