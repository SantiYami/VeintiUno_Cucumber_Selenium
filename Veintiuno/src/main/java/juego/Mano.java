/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Mano {
    ArrayList<Carta> arreglo = new ArrayList<>();
    
    public void añadirCarta(Carta carta){
        arreglo.add(carta);
    }
    
    public String toString(){
        String mano = "";
        for (int i = 0; i < arreglo.size(); i++) {
            mano += arreglo.get(i).toString() + "";   
        }
        return mano;
    }
    
    //Aqui seria donde se suma
    public int obtenerValor(){
        
        int valor = 0;  //Valor de la mano
        boolean as = false; //true si la mano tiene un as
        
        for (int i = 0; i < arreglo.size(); i++) {
            Carta temp = arreglo.get(i);
            int valorCarta = temp.obtenerValorSimbolo();
            if (valorCarta == 1){   //Hay un as
                as = true;
            }
            valor += valorCarta;
        }
        //Comprobacion del as
        if (as == true && valor + 10 <= 21) {
            valor = valor + 10;
        }        
        return valor;
    }
    
}
