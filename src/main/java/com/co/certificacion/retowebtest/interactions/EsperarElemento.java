package com.co.certificacion.retowebtest.interactions;
/**
 * Esta clase permite dar una espera de un segundo a elementos que aparecen demasiado pronto y la auto no lo controla
 */
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class EsperarElemento implements Interaction {

    public EsperarElemento() {
    }

    public static EsperarElemento mientrasCarga() {
        return Tasks.instrumented(EsperarElemento.class);

    }

    @Override
    public <T extends Actor> void performAs(T t) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}