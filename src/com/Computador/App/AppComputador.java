package com.Computador.App;
import com.Computador.Dominio.Computador;

public class AppComputador {
    public static void main(String[] args) {
        Computador miPc = new Computador("Camilo",75);

        String battery = miPc.seeBatteryLevel();
        System.out.println(battery);

    }
}
