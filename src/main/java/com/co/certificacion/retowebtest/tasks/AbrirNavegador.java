package com.co.certificacion.retowebtest.tasks;

import com.co.certificacion.retowebtest.userinterface.UIPaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Esta clase permite abrir el navegador en la pagina de Open cart
 */

public class AbrirNavegador implements Task {

    private UIPaginaPrincipal uiPaginaPrincipal;

    public static AbrirNavegador enOpenCart() {
        return Tasks.instrumented(AbrirNavegador.class);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(uiPaginaPrincipal));
        BrowseTheWeb.as(actor).getDriver().manage().window().maximize();
    }
}