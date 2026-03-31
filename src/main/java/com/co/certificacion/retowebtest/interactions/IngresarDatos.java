package com.co.certificacion.retowebtest.interactions;

/**
 * Esta clase permite ingresar los datos personales para realizar la compra
 */

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static com.co.certificacion.retowebtest.userinterface.UICarritoDeCompras.*;
import static com.co.certificacion.retowebtest.userinterface.UIPaginaPrincipal.BTN_CART;
import static com.co.certificacion.retowebtest.utils.Constantes.*;

public class IngresarDatos implements Interaction {

    private final List<Map<String, String>> listDatosDeCompra;

    public IngresarDatos(List<Map<String, String>> listDatosDeCompra) {
        this.listDatosDeCompra = listDatosDeCompra;
    }

    public static IngresarDatos paraLaCompra(List<Map<String, String>> listDatosDeCompra) {
        return Tasks.instrumented(IngresarDatos.class, listDatosDeCompra);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_CART, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_CART),
                WaitUntil.the(BTN_REALIZAR_PEDIDO, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_REALIZAR_PEDIDO),
                WaitUntil.the(BTN_COMPRAR, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                EsperarElemento.mientrasCarga(),
                Enter.theValue(listDatosDeCompra.get(0).get(NOMBRE)).into(LBL_NOMBRE),
                Enter.theValue(listDatosDeCompra.get(0).get(PAIS)).into(LBL_PAIS),
                Enter.theValue(listDatosDeCompra.get(0).get(CIUDAD)).into(LBL_CIUDAD),
                Enter.theValue(listDatosDeCompra.get(0).get(TARJETA_CREDITO)).into(LBL_TARJETA_CREDITO),
                Enter.theValue(listDatosDeCompra.get(0).get(MES)).into(LBL_MES),
                Enter.theValue(listDatosDeCompra.get(0).get(ANIO)).into(LBL_ANIO),
                Click.on(BTN_COMPRAR),
                EsperarElemento.mientrasCarga()
        );

    }
}