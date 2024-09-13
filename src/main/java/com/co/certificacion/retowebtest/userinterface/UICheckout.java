package com.co.certificacion.retowebtest.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UICheckout {


    ///Step 1
    public static final Target RBT_INVITADO = Target.the("Radio button para compra como invitado")
            .located(By.xpath("(//input[@name='account'])[2]"));

    public static final Target BTN_CONTINUAR_PASO2 = Target.the("Boton para continuar al step #2")
            .located(By.xpath("//input[@id='button-account']"));

    public static final Target TXT_PRIMER_NOMBRE = Target.the("Campo para ingresar el primer nombre")
            .located(By.xpath("//input[@id='input-payment-firstname']"));

    public static final Target TXT_SEGUNDO_NOMBRE = Target.the("Campo para ingresar el segundo nombre")
            .located(By.xpath("//input[@id='input-payment-lastname']"));

    public static final Target TXT_EMAIL = Target.the("Campo para ingresar el email")
            .located(By.xpath("//input[@id='input-payment-email']"));

    public static final Target TXT_TELEFONO = Target.the("Campo para ingresar el telegfono")
            .located(By.xpath("//input[@id='input-payment-telephone']"));

    public static final Target TXT_DIRECCION = Target.the("Campo para ingresar la direccion ")
            .located(By.xpath("//input[@id='input-payment-address-1']"));

    public static final Target TXT_CIUDAD = Target.the("Campo para ingresar la ciudad")
            .located(By.xpath("//input[@id='input-payment-city']"));

    public static final Target TXT_CODIGO_POSTAL_CHECKOUT = Target.the("Campo para el codigo postal")
            .located(By.xpath("//input[@id='input-payment-postcode']"));

    public static final Target LISTA_PAIS_CHECKOUT = Target.the("Listado de paises en la seccion de checkout")
            .located(By.xpath("//select[@id='input-payment-country']"));
    public static final Target LISTA_PAIS_VALOR_CHECKOUT = Target.the("Opciones de la lista de paises")
            .located(By.xpath("//select[@id='input-payment-country']//option"));

    public static final Target LISTA_REGION_CHECKOUT = Target.the("Listado de regiones")
            .located(By.xpath("//select[@id='input-payment-zone']"));

    public static final Target LISTA_REGION_VALOR_CHECKOUT = Target.the("Opciones en la lista de regiones")
            .located(By.xpath("//select[@id='input-payment-zone']//option"));

    public static final Target BTN_CONTINUAR_PASO4 = Target.the("Boton para continuar al step #4")
            .located(By.xpath("//input[@id='button-guest']"));

    public static final Target BTN_CONTINUAR_PASO5 = Target.the("Boton para continuar al step #5")
            .located(By.xpath("//input[@id='button-shipping-method']"));

    public static final Target RBT_ACEPTAR_TERMINOS = Target.the("Aceptar terminos y condiciones")
            .located(By.xpath("//input[@name='agree']"));

    public static final Target BTN_CONTINUAR_PASO6 = Target.the("Boton para continuar al step #6")
            .located(By.xpath("//input[@ID='button-payment-method']"));

    public static final Target BTN_CONFIRMAR_COMPRA = Target.the("Boton para confirmar la compra")
            .located(By.xpath("//input[@id='button-confirm']"));
}
