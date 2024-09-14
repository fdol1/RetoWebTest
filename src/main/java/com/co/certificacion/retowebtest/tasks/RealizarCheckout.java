package com.co.certificacion.retowebtest.tasks;

import com.co.certificacion.retowebtest.interactions.MarcarOpcion;
import com.co.certificacion.retowebtest.interactions.ObtenerUbicacion;
import com.co.certificacion.retowebtest.models.DatosFacturacionModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.retowebtest.userinterface.UICheckout.*;

public class RealizarCheckout implements Task {

    private final DatosFacturacionModel datosFacturacionModelList;

    public RealizarCheckout(DatosFacturacionModel datosFacturacionModelList) {
        this.datosFacturacionModelList = datosFacturacionModelList;
    }

    public static RealizarCheckout paraLaCompra(DatosFacturacionModel datosFacturacionModelList) {
        return Tasks.instrumented(RealizarCheckout.class, datosFacturacionModelList);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(RBT_INVITADO, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                MarcarOpcion.deseada(RBT_INVITADO),
                Click.on(BTN_CONTINUAR_PASO2),
                Enter.theValue(datosFacturacionModelList.getNombre1()).into(TXT_PRIMER_NOMBRE),
                Enter.theValue(datosFacturacionModelList.getNombre2()).into(TXT_SEGUNDO_NOMBRE),
                Enter.theValue(datosFacturacionModelList.getEmail()).into(TXT_EMAIL),
                Enter.theValue(datosFacturacionModelList.getTel()).into(TXT_TELEFONO),
                Enter.theValue(datosFacturacionModelList.getDir()).into(TXT_DIRECCION),
                Enter.theValue(datosFacturacionModelList.getCiudad()).into(TXT_CIUDAD),
                ObtenerUbicacion.paraFacturacion(),
                Click.on(BTN_CONTINUAR_PASO4),
                WaitUntil.the(BTN_CONTINUAR_PASO5, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_CONTINUAR_PASO5),
                WaitUntil.the(RBT_ACEPTAR_TERMINOS, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(RBT_ACEPTAR_TERMINOS),
                WaitUntil.the(BTN_CONTINUAR_PASO6, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_CONTINUAR_PASO6),
                WaitUntil.the(BTN_CONFIRMAR_COMPRA, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_CONFIRMAR_COMPRA)
        );
    }
}