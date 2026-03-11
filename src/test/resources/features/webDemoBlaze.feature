#language: es
#Author: David Cruz
#Email: david3505@hotmail.com
@all
Característica: Compra de productos en Demoblaze

  @ejemploWeb
  Escenario: Usuario realiza una compra exitosa de 2 productos aleatorios en Demoblaze
    Dado que el usuario accede al sitio Demoblaze
    Cuando agrega 2 productos ramdom de cualquier categoria al carrito
    #Y visualiza el carrito de compras
    #Y completa el formulario de compra con los datos del JSON y finaliza la compro
    #Entonces debe ver un mensaje de confirmacion con el ID de la orden y el monto total