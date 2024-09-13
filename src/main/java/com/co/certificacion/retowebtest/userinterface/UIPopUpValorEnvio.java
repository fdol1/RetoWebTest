package com.co.certificacion.retowebtest.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UIPopUpValorEnvio {

    public static final Target RBT_VALOR_ENVIO = Target.the("Radio button para seleccionar la tarifa fija de envio")
            .located(By.xpath("//input[@name='shipping_method']"));

    public static final Target BTN_APLICAR_COTIZACION = Target.the("Boton para aplicar una cotizacion")
            .located(By.xpath("//input[@id='button-shipping']"));
}