package com.co.certificacion.retowebtest.models;

/**
 * Modelo de datos para la informacion necesaria para verificar costos de envio
 */

public class DatosEnvioModel {

    private String pais;
    private String region;
    private String codigoPostal;

    public String getPais() {
        return pais;
    }

    public String getRegion() {
        return region;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
}