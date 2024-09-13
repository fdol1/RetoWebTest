package com.co.certificacion.retowebtest.tasks;

import com.co.certificacion.retowebtest.interactions.GuardarUbicacion;
import com.co.certificacion.retowebtest.interactions.SeleccionarItem;
import com.co.certificacion.retowebtest.models.DatosEnvioModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.retowebtest.userinterface.UIDatosDeEnvio.*;
import static com.co.certificacion.retowebtest.userinterface.UIDetalleProducto.BTN_ITEMS;
import static com.co.certificacion.retowebtest.userinterface.UIDetalleProducto.BTN_VER_CARRITO;
import static com.co.certificacion.retowebtest.userinterface.UIPopUpValorEnvio.BTN_APLICAR_COTIZACION;
import static com.co.certificacion.retowebtest.userinterface.UIPopUpValorEnvio.RBT_VALOR_ENVIO;

public class VerCarrito implements Task {

    private final DatosEnvioModel datosEnvioModelList;

    public VerCarrito(DatosEnvioModel datosEnvioModelList) {
        this.datosEnvioModelList = datosEnvioModelList;
    }

    public static VerCarrito conLosProductosDeCompras(DatosEnvioModel datosEnvioModelList) {
        return Tasks.instrumented(VerCarrito.class, datosEnvioModelList);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_ITEMS, WebElementStateMatchers.isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BTN_ITEMS),
                WaitUntil.the(BTN_VER_CARRITO, WebElementStateMatchers.isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BTN_VER_CARRITO),
                WaitUntil.the(SECCION_ENVIOS, WebElementStateMatchers.isClickable()).forNoMoreThan(15).seconds(),
                Click.on(SECCION_ENVIOS),
                Click.on(LISTA_PAIS),
                SeleccionarItem.deLaLista(LISTA_PAIS_VALOR, datosEnvioModelList.getPais()),
                Click.on(LISTA_DEPARTAMENTO),
                SeleccionarItem.deLaLista(LISTA_REGION_VALOR, datosEnvioModelList.getRegion()),
                Enter.theValue(datosEnvioModelList.getCodigoPostal()).into(TXT_CODIGO_POSTAL),
                Click.on(BTN_COTIZACIONES),
                WaitUntil.the(RBT_VALOR_ENVIO, WebElementStateMatchers.isClickable()).forNoMoreThan(15).seconds(),
                Click.on(RBT_VALOR_ENVIO),
                Click.on(BTN_APLICAR_COTIZACION),
                Click.on(BTN_CHECKOUT),
                GuardarUbicacion.paraFacturacion(datosEnvioModelList)
        );
    }
}