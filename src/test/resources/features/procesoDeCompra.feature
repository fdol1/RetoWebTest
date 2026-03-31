#language: es
#autor: l1_fdo@hotmail.com

Característica: Procesos para compras

  Antecedentes:
    Dado que "fer" ingresa a la pagina de Open Cart

  @RutaCritica
    @comprarProductos
  Esquema del escenario: Agregar dos productos al carrito
    Dado que fer busca los productos que quiere comprar
      | producto1   | cantidad1   | precio1   | producto2   | cantidad2   | precio2   |
      | <producto1> | <cantidad1> | <precio1> | <producto2> | <cantidad2> | <precio2> |
    Cuando Ingresa los datos de facturacion para la compra y finaliza la compra
      | nombre   | pais   | ciudad   | tarjetaCredito   | mes   | anio   |
      | <nombre> | <pais> | <ciudad> | <tarjetaCredito> | <mes> | <anio> |
    Entonces Verifica el mensaje de compra exitosa:"Thank you for your purchase!"
    Ejemplos:
      | producto1         | cantidad1 | precio1 | producto2        | cantidad2 | precio2 | nombre   | pais     | ciudad   | tarjetaCredito | mes | anio |
      | Samsung galaxy s6 | 1         | 360     | Nokia lumia 1520 | 2         | 820     | Fernando | Colombia | Medellín | 7896355413     | 12  | 2026 |