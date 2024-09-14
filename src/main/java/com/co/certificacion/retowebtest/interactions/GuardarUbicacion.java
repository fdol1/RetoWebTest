package com.co.certificacion.retowebtest.interactions;

import com.co.certificacion.retowebtest.models.DatosEnvioModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.co.certificacion.retowebtest.util.Constantes.*;

/**
 * Esta clase permite guardar los datos de ubicacion usados para
 * identificar los gastos de envios y reutilizarlos mas adelante en
 * el diligenciamiento de los datos para la facturacion y envio
 * Esta calse es llamada despues de verificar los costos de envio
 */

public class GuardarUbicacion implements Interaction {

    private final DatosEnvioModel datosEnvioModelList;

    public GuardarUbicacion(DatosEnvioModel datosEnvioModelList) {
        this.datosEnvioModelList = datosEnvioModelList;
    }

    public static GuardarUbicacion paraFacturacion(DatosEnvioModel datosEnvioModelList) {
        return Tasks.instrumented(GuardarUbicacion.class, datosEnvioModelList);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Map<String, String>> listaUbicacion = new ArrayList<>();
        Map<String, String> ubicacion = new HashMap<>();

        ubicacion.put(KEY_PAIS, datosEnvioModelList.getPais());
        ubicacion.put(KEY_REGION, datosEnvioModelList.getRegion());
        ubicacion.put(KEY_CODIGO_POSTAL, datosEnvioModelList.getCodigoPostal());
        listaUbicacion.add(ubicacion);
        actor.remember(KEY_UBICACION, listaUbicacion);
    }
}