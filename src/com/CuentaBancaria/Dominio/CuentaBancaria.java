package com.CuentaBancaria.Dominio;


public class CuentaBancaria {
    public int numero;
    public long saldo;
    public boolean activa;
    public Banco banco;
    public Usuario propietario;

    public CuentaBancaria(int numero){
        this.numero = numero;
        this.activa = true;
    }







    public String mostrarNumeroDeCuenta(int idCuenta){
        numero = idCuenta;
        String numeroDeCuenta = "Tu numero de cuenta es: " + numero + "\n" + "Saldo actual: " + saldo + "\n";
        return numeroDeCuenta;
    }


    public void consignar(long valorAConsignar){
        saldo+=valorAConsignar;
    }

    public long retirar(long valorARetirar) {
        if (saldo >= valorARetirar) {
            saldo -= valorARetirar;
            System.out.println("Retiraste: " + valorARetirar + " pesos \n ");
            return saldo;
        }
        else {
            System.out.println("Saldo insuficiente para el retiro.");
            System.out.println("Deberias tener: " + (valorARetirar-saldo) + " pesos más.\n");
            return saldo;
        }
    }

    public String consultarSaldo() {
        String mensajeSaldo = "Tu saldo es: " + saldo + " pesos\n";
        return mensajeSaldo;
    }


    public boolean autorizarProcesos(boolean estadoDeLaCuenta){
        activa=estadoDeLaCuenta;
        return activa;
    }


    public long transeferir(long valorATransferir, String cuantaDestino){

        if (saldo >= valorATransferir) {
            saldo -= valorATransferir;
            System.out.println("Transferiste: " + valorATransferir + " pesos al banco '" + cuantaDestino +"'\n " );
            return saldo;
        }
        else {
            System.out.println("Saldo insuficiente para hacer la transferencia.");
            System.out.println("Deberias tener: " + (valorATransferir - saldo) + " pesos más.\n");
            return saldo;
        }
    }
}
