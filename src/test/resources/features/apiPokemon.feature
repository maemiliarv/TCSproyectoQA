#language: es
#Author: David Cruz
#Email: david3505@hotmail.com
@all
Característica: Probar consultas de la API de Pokemon

  @ejemploAPI
  Escenario: Usuario consulta el nombre de Pikachu en la API de Pokemon
    Dado que el usuario hace una consulta a la API de Pokemon para obtener el nombre de Pikachu
    Cuando obtiene el resultado
    Entonces el nombre de Pokemon debe ser "pikachu"