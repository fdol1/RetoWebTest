package com.co.certificacion.retowebtest.userinterface;
/**
 * Esta clase mepea los elementos de la sección del carrito de compras
 */

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UICarritoDeCompras {

    public static final Target BTN_REALIZAR_PEDIDO = Target.the("Elemento para iniciar la compra")
            .located(By.xpath("//button[@class='btn btn-success']"));

    public static final Target LBL_NOMBRE = Target.the("Elemento para ingresar el nombre")
            .located(By.id("name"));

    public static final Target LBL_PAIS = Target.the("Elemento para ingresar el pais")
            .located(By.id("country"));

    public static final Target LBL_CIUDAD = Target.the("Elemento para ingresar la ciudad")
            .located(By.id("city"));

    public static final Target LBL_TARJETA_CREDITO = Target.the("Elemento para ingresar la tarjeta de credito")
            .located(By.id("card"));

    public static final Target LBL_MES = Target.the("Elemento para ingresar el mes")
            .located(By.id("month"));

    public static final Target LBL_ANIO = Target.the("Elemento para ingresar el anio")
            .located(By.id("year"));

    public static final Target BTN_COMPRAR = Target.the("Elemento para confirmar la compra")
            .located(By.xpath("(//button[@class='btn btn-primary'])[3]"));

    public static final Target LBL_MENSAJE_EXITOSO_DE_COMPRA = Target.the("Elemento que contiene el mensaje exitoso de compra")
            .located(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//h2"));
}