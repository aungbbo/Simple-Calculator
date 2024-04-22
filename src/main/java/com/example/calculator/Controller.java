package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private TextField txtField;
    private String generalObject;
    private Double firstDouble;
    private int click = 0;

    @FXML
    void handleDigitAction(ActionEvent event) {
        String digitObject = ((Button) event.getSource()).getText();
        String oldText = txtField.getText();
        String newText = oldText + digitObject;
        txtField.setText(newText);
    }

    @FXML
    void handleGeneralAction(ActionEvent event) {
        generalObject = ((Button) event.getSource()).getText();
        switch (generalObject) {
            case "AC":
                txtField.setText("");
                click = 0;
                break;
            case "+/-":
                double plusMinus = Double.parseDouble(String.valueOf(txtField.getText()));
                plusMinus = plusMinus * (-1);
                txtField.setText(String.valueOf(plusMinus));
                break;
            case "+":
            case "-":
            case "*":
            case "÷":
            case "%":
                String currentText = txtField.getText();
                firstDouble = Double.parseDouble(currentText);
                txtField.setText("");
                click = 0;
                break;
            default:
        }
    }

    @FXML
    void handleDecimalAction(ActionEvent event) {
        if (click == 0) {
            String decimalObject = ((Button) event.getSource()).getText();
            String oldText = txtField.getText();
            String newText = oldText + decimalObject;
            txtField.setText(newText);
            click = 1;
        }
    }

    @FXML
    void handleEqualAction(ActionEvent event) {
        double result = 0;
        double secondDouble = Double.parseDouble(txtField.getText());

        switch (generalObject) {
            case "+":
                result = firstDouble + secondDouble;
                break;
            case "-":
                result = firstDouble - secondDouble;
                break;
            case "*":
                result = firstDouble * secondDouble;
                break;
            case "÷":
                result = firstDouble / secondDouble;
                break;
            case "%":
                result = firstDouble % secondDouble;
                break;
            default:
        }

        String format = String.format("%.1f", result);
        txtField.setText(format);
    }
}
