Feature: API usuarios

Scenario: Crear usuario

Given url 'http://localhost:8080/users'
And request
"""
{
 "nombre": "Carlos",
 "email": "carlos@mail.com",
 "edad": 30
}
"""
When method post
Then status 200
And match response.nombre == 'Carlos'

Scenario: Obtener usuarios

Given url 'http://localhost:8080/users'
When method get
Then status 200