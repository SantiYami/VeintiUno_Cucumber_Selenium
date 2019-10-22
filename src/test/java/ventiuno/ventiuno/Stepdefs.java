package ventiuno.ventiuno;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;



import juego.Baraja;

//IMPORTAR CLASES DEL JUEGO
import juego.Carta;
import juego.Mano;


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
}
