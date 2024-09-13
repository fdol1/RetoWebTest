package com.co.certificacion.retowebtest.stepdefinitions;

import com.co.certificacion.retowebtest.tasks.AbrirNavegador;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ProcesoCompraStepDefinition {

    @Before
    public void configuracionInicial(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) ingresa a la pagina de Open Cart$")
    public void queFerIngresaALaPaginaDeOpenCart(String actor) {
        theActorCalled(actor).wasAbleTo(AbrirNavegador.enOpenCart());
    }


    @Dado("^que fer ingresa sus credenciales$")
    public void queFerIngresaSusCredenciales() {
    }

    @Dado("^que fer selecciona el producto a comprar$")
    public void queFerSeleccionaElProductoAComprar() {
    }

    @Cuando("^se dirige al carrito y comprueba su producto$")
    public void seDirigeAlCarritoYCompruebaSuProducto() {
    }

    @Cuando("^ingresa los datos para la compra$")
    public void ingresaLosDatosParaLaCompra() {
    }

    @Entonces("^verifica los precios y finaliza la compra$")
    public void verificaLosPreciosYFinalizaLaCompra() {
    }

    @Entonces("^verifica el mensaje de compra exitosa: Thank you for your order!$")
    public void verificaElMensajeDeCompraExitosaThankYouForYourOrder() {
    }

}
