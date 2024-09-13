package com.co.certificacion.retowebtest.tasks;


import com.co.certificacion.retowebtest.interactions.AgregarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class SeleccionarProducto implements Task {

    private final List<Map<String, String>> listProd;

    public SeleccionarProducto(List<Map<String, String>> listProd) {
        this.listProd = listProd;
    }

    public static SeleccionarProducto aComprar(List<Map<String, String>> listProd) {
        return Tasks.instrumented(SeleccionarProducto.class, listProd);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                AgregarProducto.alCarrito(listProd)
        );
    }
}