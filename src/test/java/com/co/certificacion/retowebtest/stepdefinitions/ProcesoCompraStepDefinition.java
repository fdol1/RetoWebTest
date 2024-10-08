package com.co.certificacion.retowebtest.stepdefinitions;

import com.co.certificacion.retowebtest.models.DatosEnvioModel;
import com.co.certificacion.retowebtest.models.DatosFacturacionModel;
import com.co.certificacion.retowebtest.questions.VerificarDisponibilidad;
import com.co.certificacion.retowebtest.questions.VerificarMensajeDeCompra;
import com.co.certificacion.retowebtest.tasks.AbrirNavegador;
import com.co.certificacion.retowebtest.tasks.RealizarCheckout;
import com.co.certificacion.retowebtest.tasks.SeleccionarProducto;
import com.co.certificacion.retowebtest.tasks.VerCarrito;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * Esta clase permite convertir el lenguaje de negocio del escenario a lenguaje tecnico
 * Permite recibir la data con la que se simulará la interacción del usuario con el aplicativo
 * Esta llamada por el runner RunnerProcesoCompra al ejecutar el artefacto de pruebas
 */

public class ProcesoCompraStepDefinition {

    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) ingresa a la pagina de Open Cart$")
    public void queFerIngresaALaPaginaDeOpenCart(String actor) {
        theActorCalled(actor).wasAbleTo(AbrirNavegador.enOpenCart());
    }

    @Dado("^que fer busca los productos que quiere comprar$")
    public void queFerBuscaLosProductosQueQuiereComprar(DataTable productos) {
        List<Map<String, String>> agregarProductos = productos.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(SeleccionarProducto.aComprar(agregarProductos));
    }

    @Entonces("^verifica que los productos esten disponibles para la venta$")
    public void verificaQueLosProductosEstenDisponiblesParaLaVenta() {
        theActorInTheSpotlight().should(seeThat(VerificarDisponibilidad.deProductos()));
    }

    @Cuando("^fer se dirige al carrito y verifica gastos de envio$")
    public void ferSeDirigeAlCarritoYVerificaGastosDeEnvio(List<DatosEnvioModel> datosEnvioModelList) {
        theActorInTheSpotlight().attemptsTo(VerCarrito.conLosProductosDeCompras(datosEnvioModelList.get(0)));
    }

    @Cuando("^Ingresa los datos de facturacion para la compra y finaliza la compra$")
    public void ingresaLosDatosDeFacturacionParaLaCompra(List<DatosFacturacionModel> datosFacturacionModelList) {
        theActorInTheSpotlight().attemptsTo(RealizarCheckout.paraLaCompra(datosFacturacionModelList.get(0)));
    }

    @Entonces("^Verifica el mensaje de compra exitosa:(.*)$")
    public void verificaElMensajeDeCompraExitosa(String mensajeVerificacion) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeDeCompra.realizada(mensajeVerificacion)));
    }
}