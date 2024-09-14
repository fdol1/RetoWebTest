package com.co.certificacion.retowebtest.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UIDetalleProducto {

    public static final Target LISTA_COLOR = Target.the("Elemento desplegable para seleccionar el color")
            .located(By.xpath("//select[@id='input-option226']"));

    public static final Target LISTA_COLOR_VALOR = Target.the("Elemento color dentro de la lista desplegable de colores")
            .located(By.xpath("//select[@id='input-option226']//option"));

    public static final Target TXT_CANTIDAD = Target.the("Elemento para ingresar cantidad del producto")
            .located(By.xpath("//input[@id='input-quantity']"));

    public static final Target BTN_AGREGAR_AL_CARRITO = Target.the("Elemento para agregar producto al carrito")
            .located(By.xpath("//button[@id='button-cart']"));

    public static final Target BTN_ITEMS = Target.the("Elemento para ver los items en el carrito")
            .located(By.xpath("//span[@id='cart-total']"));

    public static final Target BTN_VER_CARRITO = Target.the("Elemento para ir al carrito de compras")
            .located(By.xpath("//p[@class='text-right']//a"));
}