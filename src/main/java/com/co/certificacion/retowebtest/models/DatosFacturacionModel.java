package com.co.certificacion.retowebtest.models;

/**
 * Modelo de datos para la informacion necesaria para realizar compra
 */

public class DatosFacturacionModel {

    private String tipoCompra;
    private String nombre1;
    private String nombre2;
    private String email;
    private String tel;
    private String dir;
    private String ciudad;
    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getDir() {
        return dir;
    }

    public String getCiudad() {
        return ciudad;
    }
}