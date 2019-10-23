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

  @tag3  
  Scenario: La casa se planta si suma diecisiete o más
    Given jugando veintiuno
    When termina el juego
    Then el numero de cartas de la casa debe ser menos de diecisiete
    
  @tag4  
  Scenario: El jugador se planta y gana o pierde
    Given jugando veintiuno
    When termina el juego
    Then el jugador gana o pierde