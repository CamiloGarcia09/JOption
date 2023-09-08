package MaquinaExpendedora.App;

import MaquinaExpendedora.Dominio.Expendedora;
import MaquinaExpendedora.Dominio.Snack;

public class AppMaquina {
    public static void main(String[] args) {
        Expendedora Expendedora = new Expendedora();

        //El usuario crea los snacks que quiera ingresar a la maquina
        Snack Rosquillas = new Snack("Rosquillas", 1,800,0);
        Snack Chocorramo = new Snack("Chocorramo", 2,1200,0);
        Snack Manimoto = new Snack("Manimoto", 3,100,0);
        Snack Tosh = new Snack("Tosh", 4,300,0);
        Snack Jet = new Snack("Jet", 5,350,6);
        Snack Papitas = new Snack("Papitas", 6,750,5);
        Snack Oreo = new Snack("Oreo", 7,800,6);
        Snack Festival = new Snack("Festival", 8,800,6);
        Snack Chokis = new Snack("Chokis", 9,800,5);
        Snack Golochips = new Snack("Golochips", 10,800,6);
        Snack Gol = new Snack("Gol", 11,71,6);
        Snack Tosti = new Snack("Tosti", 12,89,5);
        Snack Detodito = new Snack("Detodito", 13,120,5);


        //El usuario agrega la cantidad de Snack que quiera
        Expendedora.agregarUnSnack(Rosquillas);
        Expendedora.agregarUnSnack(Chocorramo);
        Expendedora.agregarUnSnack(Manimoto);
        Expendedora.agregarUnSnack(Tosh);
        Expendedora.agregarUnSnack(Jet);
        Expendedora.agregarUnSnack(Papitas);
        Expendedora.agregarUnSnack(Oreo);
        Expendedora.agregarUnSnack(Festival);
        Expendedora.agregarUnSnack(Chokis);
        Expendedora.agregarUnSnack(Golochips);
        Expendedora.agregarUnSnack(Gol);
        Expendedora.agregarUnSnack(Tosti);
        Expendedora.agregarUnSnack(Detodito);


        //Se muestra los Snacks de la maquina
        Expendedora.mostrarlistaSnacks(Expendedora.getSnacks());

        Expendedora.sacarUnaUnidadPorCodigo(2);

        Expendedora.sacarUnaUnidadPorNombre("Rosquillas");

        Expendedora.aumentarCantidadDeSnacksPorCodigo(1);

        Expendedora.aumentarCantidadDeSnacksPorNombre("hola");

        Expendedora.quitarUnSnack(2);

        Expendedora.obtenerCantidadDeSnack(71);

        Expendedora.SnacksAgotados();

        Expendedora.SnacksDisponibles();

        Expendedora.ordenarValorMayorAMenor(Expendedora.getSnacks());

        Expendedora.ordenarCantidadMenorAMayor(Expendedora.getSnacks());
    }
}
