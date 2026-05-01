Feature: Pruebas del API del casino

Background:
* url 'http://localhost:8080'

Scenario: Usuario apuesta correctamente

Given path '/casino/apostar'
And param userId = 4
And param monto = 50
When method POST
Then status 200

Scenario: Usuario apuesta monto invalido

Given path '/casino/apostar'
And param userId = 3
And param monto = -50
When method POST
Then status 400