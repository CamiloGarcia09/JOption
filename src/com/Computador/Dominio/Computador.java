package com.Computador.Dominio;

public class Computador {
    public boolean on;
    public int battery;
    public String marca;
    public String user;

    public Computador(String user, int battery){
        this.user=user;
        this.battery=battery;
        this.on=true;
    }



    public String seeBatteryLevel(){
        return "Hola " + user + " el computador tiene: " + battery + "%" + " de bateria";
    }


}


