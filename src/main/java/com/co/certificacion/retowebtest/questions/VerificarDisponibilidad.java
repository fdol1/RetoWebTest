package com.co.certificacion.retowebtest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.co.certificacion.retowebtest.userinterface.UICheckout.LBL_MENSAJE_PRODUCTO;

/**
 * Esta clase permite verificar que el producto agregado este disponible para la compra
 * Esta clase es llama por ProcesoCompraStepDefinition justo despues de abrir el carrito de compras
 */

public class VerificarDisponibilidad implements Question<Boolean> {

    public VerificarDisponibilidad() {
    }

    public static VerificarDisponibilidad deProductos() {
        return new VerificarDisponibilidad();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return !Visibility.of(LBL_MENSAJE_PRODUCTO).viewedBy(actor).asBoolean();
    }
}