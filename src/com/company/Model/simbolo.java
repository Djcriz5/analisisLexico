package com.company.Model;

/**
 * Created by criscastro on 08/11/17.
 */
public class simbolo {
    private char caracter;

    private boolean isTerminal;
    simbolo(char caracter,boolean isTerminal){
        this.caracter=caracter;
        this.isTerminal=isTerminal;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}
