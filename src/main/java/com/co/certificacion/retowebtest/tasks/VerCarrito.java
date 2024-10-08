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

import static com.co.certificacion.retowebtest.userinterface.UICheckout.*;
import static com.co.certificacion.retowebtest.userinterface.UIPopUpValorEnvio.BTN_APLICAR_COTIZACION;
import static com.co.certificacion.retowebtest.userinterface.UIPopUpValorEnvio.RBT_VALOR_ENVIO;

/**
 * Esta clase permite ingresar al carrito de compras y ver los productos agregados
 * Permite verificar y aplicar costos de envio
 * Permite ingresar los datos para validar costos
 * Inicia el proceso de checkout para la compra
 * Esta calse es llama despues de verificar que los productos esten disponibles
 */

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
                WaitUntil.the(SECCION_ENVIOS, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(SECCION_ENVIOS),
                Click.on(LISTA_PAIS),
                SeleccionarItem.deLaLista(LISTA_PAIS_VALOR, datosEnvioModelList.getPais()),
                Click.on(LISTA_DEPARTAMENTO),
                SeleccionarItem.deLaLista(LISTA_REGION_VALOR, datosEnvioModelList.getRegion()),
                Enter.theValue(datosEnvioModelList.getCodigoPostal()).into(TXT_CODIGO_POSTAL),
                Click.on(BTN_COTIZACIONES),
                WaitUntil.the(RBT_VALOR_ENVIO, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(RBT_VALOR_ENVIO),
                Click.on(BTN_APLICAR_COTIZACION),
                Click.on(BTN_CHECKOUT),
                GuardarUbicacion.paraFacturacion(datosEnvioModelList)
        );
    }
}