package com.co.certificacion.retowebtest.userinterface;

/**
 * Esta clase mepea los elementos de la pagina donde se encuentra el detalle del producto
 */
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UIDetalleProducto {

    public static final Target BTN_AGREGAR_AL_CARRITO = Target.the("Elemento que permite agregar un producto al carrito")
            .located(By.xpath("//a[@class='btn btn-success btn-lg']"));
}