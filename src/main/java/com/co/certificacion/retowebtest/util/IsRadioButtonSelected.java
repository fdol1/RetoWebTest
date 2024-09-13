package com.co.certificacion.retowebtest.util;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class IsRadioButtonSelected implements Question<Boolean> {

    private final Target radioButton;

    public IsRadioButtonSelected(Target radioButton) {
        this.radioButton = radioButton;
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return radioButton.resolveFor(actor).isSelected();
    }

    public static IsRadioButtonSelected of(Target radioButton) {
        return new IsRadioButtonSelected(radioButton);
    }
}