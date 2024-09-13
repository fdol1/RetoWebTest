package com.co.certificacion.retowebtest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/compraProceso.feature",
        tags = "@RutaCritica",
        glue = {"com.co.certificacion.retowebtest"},
        snippets = SnippetType.CAMELCASE
)

public class RunnerProcesoCompra {
}