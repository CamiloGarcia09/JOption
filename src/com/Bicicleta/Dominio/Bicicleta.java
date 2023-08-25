package com.Bicicleta.Dominio;

import com.CuentaBancaria.Dominio.CuentaBancaria;

public class Bicicleta {
    public String marca;
    public String color;
    public int  modelo;
    public double velocidad;
    public int cambioActual;


    public void acelerar(double valorAceleracion){
        this.velocidad += valorAceleracion;
    }

    public void frenar (double valorFrenado){
        if(this.velocidad - valorFrenado>0){
            this.velocidad -= valorFrenado;
        }else{
            System.out.println("La velocidad despues de la frenada debe ser mayor a 0");
        }
    }

    public String verVelocidad(){
        return "la bici va a " + this.velocidad + "Km/h";

    }

    public void cambiarPinon(int nuevoPinon){

    }
}
