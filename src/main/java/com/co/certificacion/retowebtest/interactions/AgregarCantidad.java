package com.co.certificacion.retowebtest.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.retowebtest.userinterface.UIDetalleProducto.BTN_AGREGAR_AL_CARRITO;
import static com.co.certificacion.retowebtest.userinterface.UIPaginaPrincipal.BTN_HOME;

public class AgregarCantidad implements Interaction {

    String cantidad;

    public AgregarCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public static AgregarCantidad delProducto(String cantidad) {
        return  Tasks.instrumented(AgregarCantidad.class, cantidad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        for(int i=1; i<=Integer.parseInt(cantidad); i++){
            actor.attemptsTo(
                    WaitUntil.the(BTN_AGREGAR_AL_CARRITO, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(BTN_AGREGAR_AL_CARRITO),
                    EsperarElemento.mientrasCarga()
            );
            var alert = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
            alert.accept();
        }
        actor.attemptsTo(
                WaitUntil.the(BTN_HOME, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_HOME));
    }
}