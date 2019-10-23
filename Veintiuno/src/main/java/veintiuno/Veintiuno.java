/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veintiuno;

import juego.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author david
 */
public class Veintiuno {

	// TODO code application logic here
    private Baraja baraja = new Baraja();
    private Mano manoCasa = new Mano();
    private Mano manoJugador = new Mano();
	private Boolean termino = false;
	private Boolean jugadorGana = false;
    
    public void jugar () throws IOException {
        baraja.crearCartas();
        
        //Se le reparten dos cartas a la casa
        manoCasa.añadirCarta(baraja.obtenerCarta());
        manoCasa.añadirCarta(baraja.obtenerCarta());
        //Se le reparten dos cartas a al jugador
        manoJugador.añadirCarta(baraja.obtenerCarta());
        manoJugador.añadirCarta(baraja.obtenerCarta());

        //Regla de que la casa siempre toma carta si la suma es menor a 17
        while (manoCasa.obtenerValor() < 17) {
            manoCasa.añadirCarta(baraja.obtenerCarta());
        }

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String teclado = "";
        do {
            if (teclado.equalsIgnoreCase("O")) {
                manoJugador.añadirCarta(baraja.obtenerCarta());
            } else {
                if (teclado.equalsIgnoreCase("P")) {
                    break;
                }
            }
            System.out.println("Tus cartas son: " + manoJugador.toString());
            System.out.println("Que desea hacer?, Otra[O] o Plantarse[P]?");
            teclado = br.readLine();
        } while (!"P".equals(teclado));

        System.out.println("La Casa tiene: " + manoCasa.toString());

        int totalcasa = manoCasa.obtenerValor();
        int totaljugador = manoJugador.obtenerValor();

        if (totalcasa > totaljugador) {
            if (totalcasa <= 21) {//Caso, gana casa con mayor puntaje que el jugador
                System.out.println("La casa gana con: " + totalcasa);
                System.out.println("El jugador pierde con: " + totaljugador);
            } else {
                if (totaljugador <= 21) {//Caso, gana jugador con mayor puntaje que la casa
                    System.out.println("El jugador gana con: " + totaljugador);
                    System.out.println("La casa pierde con: " + totalcasa);
                    jugadorGana = true;
                } else {//Pierden ambos
                    System.out.println("La casa pierde con: " + totalcasa + ", y el jugador pierde con: " + totaljugador);
                }
            }
        }else{
            if (totaljugador <= 21) {//Caso, gana jugador con mayor puntaje que la casa
                System.out.println("La jugador gana con: " + totaljugador);
                System.out.println("El casa pierde con: " + totalcasa);
                jugadorGana = true;
            } else {
                if (totalcasa <= 21) {//Caso, gana casa con mayor puntaje que el jugador
                    System.out.println("La casa gana con: " + totalcasa);
                    System.out.println("El jugador pierde con: " + totaljugador);
                }else {//Pierden ambos
                    System.out.println("La casa pierde con: " + totalcasa + ", y el jugador pierde con: " + totaljugador);
                }
            }
        }
        if (totalcasa == totaljugador) {
            if (totalcasa <= 21) {//caso de empate
                System.out.println("La casa y el jugador empatan con: " + totalcasa);
                jugadorGana = true;
            } else {//Pierden ambos
                System.out.println("La casa y el jugador pierden con: " + totalcasa);
            }
        }
        termino = true;
    }

	public Baraja getBaraja() {
		return baraja;
	}

	public Mano getManoCasa() {
		return manoCasa;
	}

	public Mano getManoJugador() {
		return manoJugador;
	}

	public Boolean getTermino() {
		return termino;
	}

	public Boolean getJugadorGana() {
		return jugadorGana;
	}
	
}
