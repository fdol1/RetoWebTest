package com.co.certificacion.retowebtest.tasks;
/**
 * Esta clase permite generar la comprar cuando el usuario ya tiene sus productos seleccionados
 */

import com.co.certificacion.retowebtest.interactions.IngresarDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class GenerarCompra implements Task {

    private final List<Map<String, String>> listDatosDeCompra;

    public GenerarCompra(List<Map<String, String>> listDatosDeCompra) {
        this.listDatosDeCompra = listDatosDeCompra;
    }

    public static GenerarCompra deProductosSeleccionados(List<Map<String, String>> listDatosDeCompra) {
        return Tasks.instrumented(GenerarCompra.class, listDatosDeCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(IngresarDatos.paraLaCompra(listDatosDeCompra));
    }
}