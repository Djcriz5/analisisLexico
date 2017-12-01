package com.company.Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by criscastro on 08/11/17.
 */
public class AnalizadorLL1 {
    private char EPSILON='\u03B5'; //caracter especial epsilon griego
    private  HashMap<Character,Boolean> simbolos; // representa los simbolos de la gramatica
    // si el key (caracter) tiene un valor true entonces es terminal si no es NO TERMINAL
    private ArrayList<Produccion> producciones;

    private HashMap<String,ArrayList<Character>>primeros;//contiene un grupo de resultados de las operacioes primero

    public AnalizadorLL1(HashMap<Character,Boolean> simbolos,ArrayList<Produccion>producciones ){
        this.simbolos=simbolos;
        this.producciones=producciones;
        this.primeros=new HashMap<>();
    }
    public ArrayList<Character> primero(char c){
        ArrayList<Character> resultado;
        if((resultado=primeros.get(Character.toString(c)))!=null){
            return  resultado;
        }else{
            resultado=new ArrayList<Character>();
            primeros.put(Character.toString(c),resultado);
        }
        if(esTerminal(c)){
             resultado.add(c);
             return resultado;
        }
        for (Produccion p :produccionesConElsimbolo(c)) {
            for (int i = 0; i < p.getProduccion().length(); i++) {
                char simboloActual=p.getProduccion().charAt(i);
                if(simboloActual==EPSILON){//agregamos epsilon al conjunto de primeros
                    resultado.add(EPSILON);
                    break;
                }

                //si no entonces es un no terminal y va al conjunto de primeros del simbolo original
                //exepto si es epsilon,entonces unimos su conjunto primero con el del simbolo original
                //System.out.println("simbolo actual"+simboloActual);
                ArrayList<Character> primeroDeNoTerminal=primero(simboloActual);
                if(!primeroDeNoTerminal.contains(EPSILON)){
                    mezclar(primeroDeNoTerminal,resultado);
                    break;
                }//si no entonces tenemos a epsilon en el primer no terminal
                //ponemos todos los simbolos excepto epsilon
                //descartamos este no terminal y avanzamos al siguiente simbolo es decir no rompemos el loop
                mezclar(primeroDeNoTerminal,resultado,EPSILON);


            }
        }


        return resultado;
    }

    private boolean esTerminal(char c){
        //System.out.println("es terminal??: "+c);
        return this.simbolos.get(c);
    }

    private ArrayList<Produccion> produccionesConElsimbolo(char simbolo){
        ArrayList<Produccion> produccionesDeSimbolo=new ArrayList<>();
        for (Produccion p :this.producciones) {
            if(p.getCaracter()==simbolo){
                produccionesDeSimbolo.add(p);
            }
        }
        return  produccionesDeSimbolo;
    }

    private void  mezclar(ArrayList<Character>origen ,ArrayList<Character>destino){
        for(char c : origen){
            if(!destino.contains(c)) destino.add(c);
        }
    }

    private void  mezclar(ArrayList<Character>origen ,ArrayList<Character>destino,char  excluir){
      for(char c : origen){
          if(!destino.contains(c)) destino.add(c);
          }

    }

    public void obtenerPrimeros(){
        for (Produccion p:producciones) {
          //  System.out.println(p.getCaracter());
            primero(p.getCaracter());
        }
    }

    public void mostrarPrimeros() {
        for (String s : primeros.keySet()) {
            System.out.print("[ "+s+" ::");
            for (char c:primeros.get(s)) {
                System.out.print(" "+c+" ");
            }
            System.out.println(" ]");

        }
    }


}
