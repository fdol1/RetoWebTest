package com.co.certificacion.retowebtest.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.retowebtest.userinterface.UIDetalleProducto.BTN_ITEMS;
import static com.co.certificacion.retowebtest.userinterface.UIDetalleProducto.BTN_VER_CARRITO;

/**
 * Esta clase permite interactuar con los items que llevan al usuario al carrito
 * Esta calse es llamada despues de agregar todos los productos listados al carrito
 */

public class AbrirCarrito implements Interaction {

    public AbrirCarrito() {
    }

    public static AbrirCarrito deCompras() {
        return Tasks.instrumented(AbrirCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_ITEMS, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_ITEMS),
                WaitUntil.the(BTN_VER_CARRITO, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_VER_CARRITO)
        );
    }
}