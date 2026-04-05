Feature: Gestion del carrito de compras desde el catalogo

  Background:
    Given que el usuario navega hacia saucedemo
    And accede al sistema

  @carrito @carrito1
  Scenario: Agregar varios productos al carrito incrementa el contador correctamente
    When agrega 4 productos aleatorios al carrito
    Then el contador del carrito debe ser 4

  @carrito @carrito2
  Scenario: El producto agregado aparece en el carrito
    When agrega un producto aleatorio al carrito
    And navega al carrito de compras
    Then el producto agregado debe aparecer en el carrito

  @carrito @carrito3
  Scenario: Eliminar todos los productos desde el catalogo deja el contador en cero
    When agrega 3 productos aleatorios al carrito
    And elimina 3 productos aleatorios desde el catalogo
    Then el contador del carrito debe ser 0

  @carrito @carrito4
  Scenario: Eliminar todos los productos desde el carrito lo deja vacio
    When agrega 2 productos aleatorios al carrito
    And navega al carrito de compras
    And elimina los productos desde el carrito
    Then el carrito debe estar vacio

  @carrito @carrito5
  Scenario: Eliminar un producto desde el catalogo decrementa el contador correctamente
    When agrega 3 productos aleatorios al carrito
    And elimina 1 productos aleatorios desde el catalogo
    Then el contador del carrito debe ser 2

  @carrito @carrito6
  Scenario: El boton Add to cart responde en menos de 2 segundos
    When agrega un producto midiendo el tiempo de respuesta
    Then el tiempo de respuesta del carrito debe ser menor a 2000 milisegundos
