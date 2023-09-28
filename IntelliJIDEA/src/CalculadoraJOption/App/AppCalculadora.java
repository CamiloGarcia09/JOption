package CalculadoraJOption.App;
import CalculadoraJOption.Dominio.Calculadora;


public class AppCalculadora{

    public static void main(String[] args) {

        while (true) {
            int opcionElegida = Calculadora.mostrarMenu();

            switch (opcionElegida) {

                case Calculadora.SUMAR-> Calculadora.mostrarMensaje("La suma es " + Calculadora.sumar(Calculadora.numeros));
                case Calculadora.RESTAR-> Calculadora.mostrarMensaje("La resta es " + Calculadora.restar(Calculadora.numeros));
                case Calculadora.MULTIPLICAR-> Calculadora.mostrarMensaje("La multiplicacion es "
                            + Calculadora.multiplicar(Calculadora.numeros));
                case Calculadora.DIVIDIR-> Calculadora.mostrarMensaje("La division es "
                            + Calculadora.dividir(Calculadora.numeros));

            }
        }
    }
}
