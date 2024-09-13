#language: es
#autor: l1_fdo@hotmail.com

Característica: Procesos para compras

  Antecedentes:
    Dado que fer ingresa a la pagina de Open Cart

  @RutaCritica
    @AgregarProductos
  Esquema del escenario: Agregar dos productos al carrito
    Dado que fer busca los productos que quiere comprar
      | producto1   | cantidad1   | color1   | producto2   | cantidad2   | color2   |
      | <producto1> | <cantidad1> | <color1> | <producto2> | <cantidad2> | <color2> |
    Cuando fer se dirige al carrito he ingresa datos de envio
      | pais   | region   | codigoPostal   |
      | <pais> | <region> | <codigoPostal> |
    E Ingresa los datos de facturacion para la compra y finaliza la compra
      | tipoCompra   | nombre1   | nombre2   | email   | tel   | dir   | ciudad   |
      | <tipoCompra> | <nombre1> | <nombre2> | <email> | <tel> | <dir> | <ciudad> |
    Entonces Verifica el mensaje de compra exitosa:Your order has been placed!

    Ejemplos:
      | producto1    | cantidad1 | color1 | producto2 | cantidad2 | color2 | pais     | region    | codigoPostal | tipoCompra | nombre1 | nombre2 | email          | tel    | dir      | ciudad   |
      | Canon EOS 5D | 1         | Red    | iMac      | 2         | None   | Colombia | Antioquia | 050001       | Invitado   | luis    | fer     | l1@hotmail.com | 323233 | calle 10 | medellin |