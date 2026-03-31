package com.co.certificacion.retowebtest.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static com.co.certificacion.retowebtest.userinterface.UIDetalleProducto.BTN_AGREGAR_AL_CARRITO;
import static com.co.certificacion.retowebtest.userinterface.UIPaginaPrincipal.*;
import static com.co.certificacion.retowebtest.utils.Constantes.KEY_PRODUCTO;

/**
 * Esta clase permite buscar productos y agregarlos al carrito
 * Selecciona las caracteristicas de los productos para la compra
 * Identifica cuantos productos le han llegado desde el escenario
 */

public class AgregarAlCarrito implements Interaction {
    private final List<Map<String, String>> listProd;

    public AgregarAlCarrito(List<Map<String, String>> prod) {
        this.listProd = prod;
    }

    public static AgregarAlCarrito deCompras(List<Map<String, String>> prod) {
        return Tasks.instrumented(AgregarAlCarrito.class, prod);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (int i = 1; i <= listProd.get(0).size() / 3; i++) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_HOME, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    SeleccionarItem.deLaLista(LIST_NOMBRE_PRODUCTOS, listProd.get(0).get(KEY_PRODUCTO + i)),
                    WaitUntil.the(BTN_AGREGAR_AL_CARRITO, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(BTN_AGREGAR_AL_CARRITO),
                    EsperarElemento.mientrasCarga()
                    //AgregarAlCarrito.laCantidadSeleccionada(listProd.get(0).get(KEY_CANTIDAD + i)),
            );
            var alert = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            actor.attemptsTo(
                    WaitUntil.the(BTN_HOME, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(BTN_HOME));
        }
    }
}