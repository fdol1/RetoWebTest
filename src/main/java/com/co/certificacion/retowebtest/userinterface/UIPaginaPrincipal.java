package com.co.certificacion.retowebtest.userinterface;
/**
 * Esta clase mepea los elementos de la pagina principal
 */

import com.co.certificacion.retowebtest.utils.Constantes;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl(Constantes.URL_PORTAL)
public class UIPaginaPrincipal extends PageObject {

    public static final Target BTN_HOME = Target.the("Elemento que permite regresar a la pagina principal")
            .located(By.xpath("(//a[@class='nav-link'])[1]"));

    public static final Target LIST_NOMBRE_PRODUCTOS = Target.the("Elemento que contiene los nombres de los productos")
            .located(By.xpath("//div[@id='tbodyid']//div//div//div//a"));

    public static final Target LIST_PRECIO_PRODUCTOS = Target.the("Elemento que contiene los precios de los productos")
            .located(By.xpath("//div[@id='tbodyid']//div//div//div//h5"));

    public static final Target BTN_CART = Target.the("Elemento para ir al carrito")
            .located(By.xpath("//a[@id='cartur']"));
}