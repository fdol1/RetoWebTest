package com.co.certificacion.retowebtest.runners;
/**
 * Esta clase inicia el proceso inicia todo el proceso de pruebas
 */

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/procesoDeCompra.feature",
        tags = "@RutaCritica",
        glue = {"com.co.certificacion.retowebtest.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerProcesoCompra {
}