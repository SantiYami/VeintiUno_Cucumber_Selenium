/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author david
 */
public class Baraja {
    private Carta baraja[] = new Carta[52];//Baraja con las 52 cartas
    private int posicion = 0;//Posicion de la carta
    
    public void crearCartas(){
        String simbolos = "23456789DJQKA";
        String tipos = "PCRT";
        int index = 0;
        
        //Agregar las cartas al array baraja
        for (int i = 0; i < tipos.length(); i++) {
            for (int j = 0; j < simbolos.length(); j++) {
                Carta temp = new Carta();
                temp.setSimbolo(simbolos.charAt(j));
                temp.setTipo(tipos.charAt(i));
                this.baraja[index] = temp;
                index++;
            }
        }
        barajar();//Baraja las cartas despues de crearlas
    }
    
    private void barajar(){
        //La clase Collections provee un metodo para barajar un array
        Collections.shuffle(Arrays.asList(this.baraja));
    }

    public Carta obtenerCarta() {
        if (posicion == 51) {
            System.out.println("No hay mas cartas en la baraja");
            return null;
        }
        Carta temp = this.baraja[posicion];
        posicion++;//Moverse a una posicion a la derecha de la baraja
        return temp;
    }
    
}
