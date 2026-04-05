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

  @carrito @carrito7
  Scenario: El boton Add to cart es visible y esta habilitado para todos los productos
    When verifica que los botones Add to cart son visibles y estan habilitados
    Then todos los botones Add to cart deben estar disponibles

  @carrito @carrito8
  Scenario: El flujo de agregar producto al carrito es estable en 3 ejecuciones consecutivas
    When ejecuta el flujo de agregar producto al carrito 3 veces consecutivas
    Then todas las ejecuciones deben haber sido exitosas

  @carrito @carrito9
  Scenario: El boton Add to cart funciona correctamente en distintas configuraciones de ventana
    When verifica el boton Add to cart en distintos tamaños de ventana
    Then el boton debe funcionar correctamente en todas las configuraciones

  @carrito @carrito10
  Scenario: El carrito con 6 productos carga en menos de 3 segundos
    When agrega todos los productos disponibles al carrito
    And navega al carrito midiendo el tiempo de carga
    Then el tiempo de carga del carrito debe ser menor a 3000 milisegundos
