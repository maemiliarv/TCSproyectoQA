Feature: Compra de producto en DemoBlaze


  @demoqa
  Scenario: Prueba Demoqa
    Given que el usuario navega hacia demoqa.com
    When acceder al sistema
    Then el catalogo de productos debe estar visible
    And el titulo del catalogo existe
    And el boton del menu desplegable existe
    And la url debe ser la del catalogo



