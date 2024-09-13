package com.co.certificacion.retowebtest.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UIFinCompra {

    public static final Target LBL_MENSAJE_DE_COMPRA = Target.the("Elemento donde se visualiza el estado de la compra")
            .located(By.xpath("(//div[@id='content']//h1)[1]"));


}
