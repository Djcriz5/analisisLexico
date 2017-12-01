package com.company.Model;

/**
 * Created by criscastro on 08/11/17.
 */
public class Produccion {
    private  char caracter;
    private  String  produccion;
    public Produccion(char caracter, String produccion){
        this.caracter=caracter;
        this.produccion=produccion;

    }

    public boolean contieneProduccion(char caracter ){
        return produccion.indexOf(caracter)!=-1;
    }

    public char getCaracter(){
        return this.caracter;
    }

    public  String getProduccion(){
        return produccion;
    }
}
