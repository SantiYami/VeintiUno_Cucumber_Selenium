@tag
Feature: Tests sobre Juego Veintiuno

	@tag1
  Scenario: La suma es correcta
    Given secuencia de cartas J-Q
    When obtener valor jugador
    Then la suma de las cartas debe ser 20
    
  @tag2  
  Scenario: Los grupos de cartas son correctos
    Given baraja de cartas
    When recorrer toda la baraja
    Then el numero de grupo de cartas es 4

