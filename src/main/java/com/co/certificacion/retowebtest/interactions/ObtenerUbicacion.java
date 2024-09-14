package com.co.certificacion.retowebtest.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static com.co.certificacion.retowebtest.userinterface.UIDatosDeEnvio.*;
import static com.co.certificacion.retowebtest.util.Constantes.*;
import static com.co.certificacion.retowebtest.util.Constantes.KEY_CODIGO_POSTAL;

/**
 * Esta clase permite ingresar la ubicacion antes guardada en los datos de facturacion
 * Esta calse es llamada en el proceso de ingreso de datos para la compra de productos
 */

public class ObtenerUbicacion implements Interaction {

    public ObtenerUbicacion() {
    }

    public static ObtenerUbicacion paraFacturacion() {
        return Tasks.instrumented(ObtenerUbicacion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Map<String, String>> listaUbicacion = actor.recall(KEY_UBICACION);
        for (Map<String, String> ubicacion : listaUbicacion) {
            actor.attemptsTo(
                    WaitUntil.the(TXT_CODIGO_POSTAL_CHECKOUT, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Enter.theValue(ubicacion.get(KEY_CODIGO_POSTAL)).into(TXT_CODIGO_POSTAL_CHECKOUT),
                    WaitUntil.the(LISTA_PAIS_CHECKOUT, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(LISTA_PAIS_CHECKOUT),
                    WaitUntil.the(LISTA_PAIS_VALOR_CHECKOUT, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    SeleccionarItem.deLaLista(LISTA_PAIS_VALOR_CHECKOUT, ubicacion.get(KEY_PAIS)),
                    WaitUntil.the(LISTA_REGION_CHECKOUT, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(LISTA_REGION_CHECKOUT),
                    WaitUntil.the(LISTA_REGION_VALOR_CHECKOUT, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    SeleccionarItem.deLaLista(LISTA_REGION_VALOR_CHECKOUT, ubicacion.get(KEY_REGION))
            );
        }
    }
}