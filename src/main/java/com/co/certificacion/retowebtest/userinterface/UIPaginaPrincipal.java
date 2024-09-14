package com.co.certificacion.retowebtest.userinterface;

import com.co.certificacion.retowebtest.util.Constantes;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Esta clase mepea los elementos de la pagina principal cuando
 * se abre el navegador en el portal de open cart
 */

@DefaultUrl(Constantes.URL_PORTAL)
public class UIPaginaPrincipal extends PageObject {

    public static final Target TXT_BUSCAR = Target.the("Campo para ingresar texto y buscar")
            .located(By.xpath("//div[@id='search']//input"));

    public static final Target BTN_BUSCAR = Target.the("Campo para ingresar texto y buscar")
            .located(By.xpath("//button[@class='btn btn-default btn-lg']"));
}