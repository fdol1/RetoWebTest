package com.co.certificacion.retowebtest.interactions;

import com.co.certificacion.retowebtest.util.IsRadioButtonSelected;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

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
        boolean estaMarcado = actor.asksFor(IsRadioButtonSelected.of(elemento));
        if (!estaMarcado) {
            actor.attemptsTo(Click.on(elemento));
        }
    }
}