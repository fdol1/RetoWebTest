package com.co.certificacion.retowebtest.questions;
/**
 * Esta clase permite verificar que el mensaje de compra propuesto en el escenario,
 * sea igual al obtenido al finalizar la compra.
 * Esta clase es llama por ProcesoCompraStepDefinition al finalizar la compra
 */

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class VerificarMensajeDeAviso implements Question<Boolean> {

    private final String mensajeCompraEsperado;

    public VerificarMensajeDeAviso(String mensajeCompraEsperado) {
        this.mensajeCompraEsperado = mensajeCompraEsperado;
    }

    public static VerificarMensajeDeAviso faltaUnDato(String mensajeCompraEsperado) {
        return new VerificarMensajeDeAviso(mensajeCompraEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean respuesta = false;

        var alert = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
        String mensajeObtenido = alert.getText();
        alert.accept();
        if (mensajeCompraEsperado.equals(mensajeObtenido.trim())) {
            respuesta = true;
        }
        return respuesta;
    }
}