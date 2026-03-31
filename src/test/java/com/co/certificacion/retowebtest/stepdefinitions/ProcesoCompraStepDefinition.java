package com.co.certificacion.retowebtest.stepdefinitions;


import com.co.certificacion.retowebtest.questions.VerificarMensajeDeAviso;
import com.co.certificacion.retowebtest.questions.VerificarMensajeDeCompra;
import com.co.certificacion.retowebtest.tasks.AbrirNavegador;
import com.co.certificacion.retowebtest.tasks.GenerarCompra;
import com.co.certificacion.retowebtest.tasks.SeleccionarProducto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * Esta clase permite convertir el lenguaje de negocio del escenario a lenguaje tecnico
 * Permite recibir la data con la que simulará la interacción del usuario con el aplicativo
 * Está llamada por el runner RunnerProcesoCompra al ejecutar el artefacto de pruebas
 */

public class ProcesoCompraStepDefinition {

    @Dado("que {string} ingresa a la pagina de Open Cart")
    public void queFerIngresaALaPaginaDeOpenCart(String actor) {
        theActorCalled(actor).wasAbleTo(AbrirNavegador.enOpenCart());
    }

    @Dado("que fer busca los productos que quiere comprar")
    public void queFerBuscaLosProductosQueQuiereComprar(DataTable productos) {
        List<Map<String, String>> agregarProductos = productos.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(SeleccionarProducto.aComprar(agregarProductos));
    }


    @Cuando("Ingresa los datos de facturacion para la compra y finaliza la compra")
    public void ingresaLosDatosDeFacturacionParaLaCompraYFinalizaLaCompra(DataTable datosFacturacionModelList) {
        List<Map<String, String>> datosDeCompra = datosFacturacionModelList.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(GenerarCompra.deProductosSeleccionados(datosDeCompra));
    }

    @Entonces("Verifica el mensaje de compra exitosa:{string}")
    public void verificaElMensajeDeCompraExitosa(String mensajeVerificacion) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeDeCompra.realizada(mensajeVerificacion)));

    }

    @Entonces("Verifica el mensaje de aviso: {string}")
    public void verificaElMensajeDeAviso(String mensajeVerificacion) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeDeAviso.faltaUnDato(mensajeVerificacion)));

    }
}