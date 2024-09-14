package com.co.certificacion.retowebtest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.co.certificacion.retowebtest.userinterface.UIDatosDeEnvio.LBL_MENSAJE_ERROR;

public class VerificarDisponibilidad implements Question<Boolean> {

    public VerificarDisponibilidad() {
    }

    public static VerificarDisponibilidad deProductos() {
        return new VerificarDisponibilidad();
    }

    @Override
    public Boolean answeredBy(Actor actor) {


        return !Visibility.of(LBL_MENSAJE_ERROR).viewedBy(actor).asBoolean();
    }
}