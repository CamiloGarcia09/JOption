package com.CuentaBancaria.App;
import com.CuentaBancaria.Dominio.CuentaBancaria;

public class AppBanco {
    public static void main(String[] args) {
        CuentaBancaria miCuenta = new CuentaBancaria(123);

        miCuenta.autorizarProcesos(true);

        miCuenta.consignar(1000);
        System.out.println();
        String numero = miCuenta.mostrarNumeroDeCuenta(1040032061);
        System.out.println(numero);


        if (miCuenta.activa==true){

            miCuenta.retirar(200);
            miCuenta.transeferir(800,"Nequi");


            String saldo = miCuenta.consultarSaldo();
            System.out.println(saldo);
        }
        else{
            System.out.println("Lo siento, tu cuenta bancaria no está activa 😱");
        }
    }
}

