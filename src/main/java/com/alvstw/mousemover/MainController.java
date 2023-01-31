package com.alvstw.mousemover;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    private MouseMoverTask mouseMoverTask;

    @FXML
    protected Button startButton;
    @FXML
    protected Button stopButton;
    @FXML
    private Label descriptionText;
    @FXML
    protected NumberTextField delay;

    public MainController() {
        mouseMoverTask = new MouseMoverTask();
    }

    @FXML
    protected void onStartButtonClick() {
        startButton.setVisible(false);
        startButton.setManaged(false);
        stopButton.setVisible(true);
        stopButton.setManaged(true);

        String delayText = delay.getText();
        if (delayText != null && !delayText.isEmpty()) {
            mouseMoverTask.setDelay(Integer.parseInt(delayText));
        }

        descriptionText.setText("Mouse will move every " + mouseMoverTask.getDelay() + " milliseconds");
        mouseMoverTask.start();
    }

    @FXML
    protected void onStopButtonClick() {
        mouseMoverTask.interrupt();
        mouseMoverTask = new MouseMoverTask();

        stopButton.setVisible(false);
        stopButton.setManaged(false);
        startButton.setVisible(true);
        startButton.setManaged(true);
        descriptionText.setVisible(false);
    }
}