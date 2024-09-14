package com.co.certificacion.retowebtest.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Esta clase permite verificar si un elemento radio button esta selecciona y seleccionarlo
 * Esta calse siempre que se quiera saber del estado de un elemento de tipo radio button
 */

public class MarcarOpcion implements Interaction {

    private final Target elemento;

    public MarcarOpcion(Target elemento) {
        this.elemento = elemento;
    }

    public static MarcarOpcion deseada(Target elemento) {
        return Tasks.instrumented(MarcarOpcion.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!elemento.resolveFor(actor).isSelected()) {
            actor.attemptsTo(Click.on(elemento));
        }
    }
}