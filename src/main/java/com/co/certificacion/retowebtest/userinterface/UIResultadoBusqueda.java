package com.co.certificacion.retowebtest.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Esta clase mepea los elementos de la pagina cuando se realiza una busqueda
 */

public class UIResultadoBusqueda {

    public static final Target IMG_IMAGEN_PRODUCTO = Target.the("Elemento que muestra la imagen del producto encontrado")
            .located(By.xpath("//div[@class='image']"));
}