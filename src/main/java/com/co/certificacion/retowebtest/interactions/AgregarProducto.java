package com.co.certificacion.retowebtest.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.co.certificacion.retowebtest.userinterface.UIDetalleProducto.*;
import static com.co.certificacion.retowebtest.userinterface.UIPaginaPrincipal.BTN_BUSCAR;
import static com.co.certificacion.retowebtest.userinterface.UIPaginaPrincipal.TXT_BUSCAR;
import static com.co.certificacion.retowebtest.userinterface.UIResultadoBusqueda.IMG_IMAGEN_PRODUCTO;
import static com.co.certificacion.retowebtest.util.Constantes.*;

/**
 * Esta clase permite buscar productos y agregarlos al carrito
 * Selecciona las caracteristicas de los productos para la compra
 * Identifica cuantos productos le han llegado desde el escenario
 */

public class AgregarProducto implements Interaction {
    private final List<Map<String, String>> listProd;

    public AgregarProducto(List<Map<String, String>> prod) {
        this.listProd = prod;
    }

    public static AgregarProducto alCarrito(List<Map<String, String>> prod) {
        return Tasks.instrumented(AgregarProducto.class, prod);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (int i = 1; i <= listProd.get(0).size() / 4; i++) {

            actor.attemptsTo(
                    WaitUntil.the(TXT_BUSCAR, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Clear.field(TXT_BUSCAR),
                    Enter.theValue(listProd.get(0).get(KEY_NOMBRE_PRODUCTO + i)).into(TXT_BUSCAR),
                    Click.on(BTN_BUSCAR),
                    WaitUntil.the(IMG_IMAGEN_PRODUCTO, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(IMG_IMAGEN_PRODUCTO),
                    Clear.field(TXT_CANTIDAD),
                    Enter.theValue(listProd.get(0).get(KEY_CANTIDAD_PRODUCTO + i)).into(TXT_CANTIDAD));

            if (!Objects.equals(listProd.get(0).get(KEY_COLOR_PRODUCTO + i), NO_VALIDO)) {
                actor.attemptsTo(
                        WaitUntil.the(LISTA_COLOR, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                        Click.on(LISTA_COLOR),
                        SeleccionarItem.deLaLista(LISTA_COLOR_VALOR, listProd.get(0).get(KEY_COLOR_PRODUCTO + i)));
            }
            actor.attemptsTo(Click.on(BTN_AGREGAR_AL_CARRITO));
        }
    }
}