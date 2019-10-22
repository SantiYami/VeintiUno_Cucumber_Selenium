package ventiuno.ventiuno;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.*;


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
}
