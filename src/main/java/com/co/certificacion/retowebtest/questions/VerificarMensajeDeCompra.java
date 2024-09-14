package com.co.certificacion.retowebtest.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.co.certificacion.retowebtest.userinterface.UIFinCompra.LBL_MENSAJE_DE_COMPRA;

/**
 * Esta clase permite verificar que el mensaje de compra propuesto en el escenario,
 * sea igual al obtenido al finalizar la compra.
 * Esta clase es llama por ProcesoCompraStepDefinition al finalizar la compra
 */

public class VerificarMensajeDeCompra implements Question<Boolean> {

    private final String mensajeCompraEsperado;

    public VerificarMensajeDeCompra(String mensajeCompraEsperado) {
        this.mensajeCompraEsperado = mensajeCompraEsperado;
    }

    public static VerificarMensajeDeCompra realizada(String mensajeCompraEsperado) {
        return new VerificarMensajeDeCompra(mensajeCompraEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean respuesta = false;
        actor.attemptsTo(WaitUntil.the(LBL_MENSAJE_DE_COMPRA, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds());
        List<WebElementFacade> mensajeCompraObtenido = LBL_MENSAJE_DE_COMPRA.resolveAllFor(actor);

        if (mensajeCompraEsperado.equals(mensajeCompraObtenido.get(0).getText().trim())) {
            respuesta = true;
        }
        return respuesta;
    }
}