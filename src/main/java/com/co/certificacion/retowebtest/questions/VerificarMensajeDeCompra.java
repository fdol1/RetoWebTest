package com.co.certificacion.retowebtest.questions;
/**
 * Esta clase permite verificar que el mensaje de compra propuesto en el escenario,
 * sea igual al obtenido al finalizar la compra.
 * Esta clase es llama por ProcesoCompraStepDefinition al finalizar la compra
 */

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.co.certificacion.retowebtest.userinterface.UICarritoDeCompras.LBL_MENSAJE_EXITOSO_DE_COMPRA;

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

        String mensajeCompraObtenido = LBL_MENSAJE_EXITOSO_DE_COMPRA
                .resolveFor(actor)
                .getText();

        System.out.println(mensajeCompraObtenido);
        System.out.println(mensajeCompraEsperado);

        if (mensajeCompraEsperado.equals(mensajeCompraObtenido.trim())) {
            respuesta = true;
        }
        return respuesta;
    }
}