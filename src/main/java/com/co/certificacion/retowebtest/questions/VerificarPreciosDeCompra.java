package com.co.certificacion.retowebtest.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.co.certificacion.retowebtest.userinterface.UIFinCompra.LBL_MENSAJE_DE_COMPRA;

public class VerificarPreciosDeCompra implements Question<Boolean> {

    private final String mensajeCompraEsperado;

    public VerificarPreciosDeCompra(String mensajeCompraEsperado) {
        this.mensajeCompraEsperado = mensajeCompraEsperado;
    }

    public static VerificarPreciosDeCompra realizada(String mensajeCompraEsperado) {
        return new VerificarPreciosDeCompra(mensajeCompraEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return true;
    }
}