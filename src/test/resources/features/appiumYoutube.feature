@all
Feature: Navegación en Youtube

  @ejemploMovil @android
  Scenario: Buscar un video en Youtube
    Given que el usuario abre Youtube
    When busca un video de futbol
    Then debería ver resultados relacionados

