package com.CDBA.Caffeinated;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {
    public NumberTextField() {
        this.setPromptText("Enter a number");

        this.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }
}

