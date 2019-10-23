package ventiuno.ventiuno;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;



import juego.Baraja;

//IMPORTAR CLASES DEL JUEGO
import juego.Carta;
import juego.Mano;
import veintiuno.Veintiuno;


public class Stepdefs {
	
	/*
	 * SUMA DE CARTAS CORRECTA EN COMPARACIÓN AL RESULTADO DE LA CLASE MANO Y UNA SUMA MANUAL
	 * 
	 * 
	 * 
	 */
	
	private Mano manojuego = new Mano();
	private int valormano;
	
	@Given("secuencia de cartas J-Q")
	public void secuencia_de_cartas_J_Q() {
		
		//AÑADIR CARTAS A LA MANO
		manojuego.añadirCarta(new Carta('Q','P'));
		manojuego.añadirCarta(new Carta('J','P'));
			
	}

	@When("obtener valor jugador")
	public void obtener_valor_jugador() {
		//Obtenemos el valor de la mano del jugador
		 valormano = manojuego.obtenerValor();
	}
	

	@Then("la suma de las cartas debe ser {int}")
	public void la_suma_de_las_cartas_debe_ser(Integer int1) {
		assertEquals(int1.intValue(), valormano);
	}
	
	/*
	 * 
	 * VERIFICAR LA EXISTENCIA DE CUATRO GRUPOS DE CARTAS MAXIMO
	 * 
	 * 
	 * 
	 */
	
	private Baraja baraja = new Baraja();
	Set<Character> gruposEncontrados = new  HashSet<Character>();
	
	@Given("baraja de cartas")
	public void baraja_de_cartas() {
		baraja.crearCartas();
	}

	@When("recorrer toda la baraja")
	public void recorrer_toda_la_baraja() {
		Carta current;
		do {
			current = baraja.obtenerCarta();
			if (current!=null) {
				gruposEncontrados.add(current.getTipo());
			}
		}while(current!=null);

	}

	@Then("el numero de grupo de cartas es {int}")
	public void el_numero_de_grupo_de_cartas_es(Integer int1) {
		assertEquals(gruposEncontrados.size(), int1.intValue());
	}
	
	/*
	 * 
	 * Verificar funcionamiento del juego
	 * Casa plantarse antes de 17
	 * Jugador gana
	 * Jugador pierde
	 */
	
	private Veintiuno juego = new Veintiuno();
	
	@Given("jugando veintiuno")
	public void jugando_veintiuno() {
		try {
			juego.jugar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("termina el juego")
	public void termina_el_juego() {
		while (juego.getTermino()!=true){
			
		}
	}

	@Then("el numero de cartas de la casa debe ser menos de diecisiete")
	public void el_numero_de_cartas_de_la_casa_debe_ser_menos_de_diecisiete() {
		assertTrue(juego.getManoCasa().obtenerValor()< 29);
	}
	
	@Then("el jugador gana o pierde")
	public void el_jugador_gana_o_pierde() {
		
		int totalcasa = juego.getManoCasa().obtenerValor();
        int totaljugador = juego.getManoJugador().obtenerValor();

        if (totalcasa > totaljugador) {
            if (totalcasa <= 21) {//Caso, gana casa con mayor puntaje que el jugador
            	assertFalse(juego.getJugadorGana());
            } else {
                if (totaljugador <= 21) {//Caso, gana jugador con mayor puntaje que la casa
                	assertTrue(juego.getJugadorGana());
                } else {//Pierden ambos
                	assertFalse(juego.getJugadorGana());
                }
            }
        }else{
            if (totaljugador <= 21) {//Caso, gana jugador con mayor puntaje que la casa
                assertTrue(juego.getJugadorGana());
            } else {
                if (totalcasa <= 21) {//Caso, gana casa con mayor puntaje que el jugador
                	assertFalse(juego.getJugadorGana());
                }else {//Pierden ambos
                	assertFalse(juego.getJugadorGana());
                }
            }
        }
        if (totalcasa == totaljugador) {
            if (totalcasa <= 21) {//caso de empate
                assertTrue(juego.getJugadorGana());
            } else {//Pierden ambos
            	assertFalse(juego.getJugadorGana());
            }
        }
	}
}
