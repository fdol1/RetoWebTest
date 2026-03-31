package com.co.certificacion.retowebtest.stepdefinitions;
/**
 * Esta ejecuta instrucciones previas a la ejecución del robot
 */
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class Hook {

    @Before
    public void configuracionInicial() {
        WebDriverManager.chromedriver().setup();

        OnStage.setTheStage(new OnlineCast());

    }
}
