package com.co.certificacion.retowebtest.interactions;
/**
 * Esta clase permite seleccionar un ítem de una lista desplegable
 * Identifica el ítem en la lista por medio del nombre y lo selecciona
 * Esta clase es llamada siempre que se tengan elementos seleccionables en listas
 */

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class SeleccionarItem implements Interaction {

    private Target lista;
    private String opcion;

    public SeleccionarItem(Target lista, String opcion) {
        this.lista = lista;
        this.opcion = opcion;
    }

    public static SeleccionarItem deLaLista(Target lista, String opcion) {
        return new SeleccionarItem(lista, opcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listObjeto = lista.resolveAllFor(actor);
        for (int i = 0; i < listObjeto.size(); i++) {
            if (listObjeto.get(i).getText().trim().equals(opcion)) {
                listObjeto.get(i).click();
                break;
            }
        }
    }
}