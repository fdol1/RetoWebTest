package com.co.certificacion.retowebtest.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UIDatosDeEnvio {

    public static final Target SECCION_ENVIOS = Target.the("Elemento para desplegar formulario")
            .located(By.xpath("(//h4[@class='panel-title']//a)[2]"));

    public static final Target LISTA_PAIS = Target.the("Elemento para ver los paises")
            .located(By.xpath("//select[@id='input-country']"));

    public static final Target LISTA_PAIS_VALOR = Target.the("Elemento de la lista paises")
            .located(By.xpath("//select[@id='input-country']//option"));

    public static final Target LISTA_DEPARTAMENTO = Target.the("Elemento para ver los departamentos")
            .located(By.xpath("//select[@id='input-zone']"));

    public static final Target LISTA_REGION_VALOR = Target.the("Elemento de la lista departamentos")
            .located(By.xpath("//select[@id='input-zone']/option"));

    public static final Target TXT_CODIGO_POSTAL = Target.the("Campo para ingresar codigo postal")
            .located(By.xpath("//input[@id='input-postcode']"));

    public static final Target BTN_COTIZACIONES = Target.the("Boton para ver cotizaciones")
            .located(By.xpath("//button[@id='button-quote']"));

    public static final Target BTN_CHECKOUT = Target.the("Boton para continuar el proceso de compra")
            .located(By.xpath("//div[@class= 'pull-right']"));

    public static final Target LBL_MENSAJE_ERROR = Target.the("//div[@class = 'alert alert-danger alert-dismissible']")
            .located(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']"));
}

