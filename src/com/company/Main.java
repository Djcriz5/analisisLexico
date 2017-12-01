package com.company;

import com.company.Model.AnalizadorLL1;
import com.company.Model.Produccion;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
       /*
       *   HashMap<String,ArrayList<Character>> primeros;//contiene un grupo de resultados de las operacioes primero
        primeros=new HashMap<>();
        ArrayList<Character>resultado=new ArrayList<>();
        primeros.put(Character.toString('c'),resultado);
        resultado.add('a');
        System.out.println(primeros.get(Character.toString('c')).contains('a'));
        System.out.println( '\u03B5');*/
        HashMap<Character,Boolean> simbolos=new HashMap<>();
        ArrayList<Produccion >producciones=new ArrayList<>();
        producciones.add(new Produccion('E',"TX"));
        producciones.add(new Produccion('X',"+TX"));
        producciones.add(new Produccion('X',"\u03B5"));
        producciones.add(new Produccion('T',"FY"));
        producciones.add(new Produccion('Y',"*FY"));
        producciones.add(new Produccion('Y',"\u03B5"));
        producciones.add(new Produccion('F',"a"));
        producciones.add(new Produccion('F',"(E)"));
        simbolos.put('E',false);
        simbolos.put('X',false);
        simbolos.put('T',false);
        simbolos.put('F',false);
        simbolos.put('Y',false);
        simbolos.put('*',true);
        simbolos.put('a',true);
        simbolos.put('(',true);
        simbolos.put(')',true);
        simbolos.put('\u03B5',true);
        simbolos.put('+',true);

        AnalizadorLL1 ll1=new AnalizadorLL1(simbolos,producciones);
        ll1.obtenerPrimeros();
        ll1.mostrarPrimeros();




















    }
}
