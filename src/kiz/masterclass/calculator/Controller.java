package kiz.masterclass.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Controller extends SimpleCalculator {
    @FXML
    private TextField txt_input;

    private static double operandOne = 0;
    private static double operandTwo = 0;
    private static String operator = "";
    private static boolean flag = false;
    private boolean switchOn = false;


    private static List<String> series = new ArrayList<>();

    private void readText(ActionEvent event) {
        series.add(getKey(event));
        String in = "";
        for (String next : series) {
            in = String.format("%s%s", in, next);
        }
        txt_input.setText(in);
    }

    @FXML
    public void onButtonClick(ActionEvent event) {
        readText(event);
        switchOn = false;
    }

    private double getAdditionResult() {
        double result = (operandOne + operandTwo);
        txt_input.setText(result + "");
        switchOn = true;
        series.clear();
        return result;
    }

    private void additionOperationResult() {
        if (!switchOn) {
            if (!flag) {
                operandOne = Double.parseDouble(txt_input.getText());
                operandOne = getAdditionResult();
                flag = true;
            } else {
                operandTwo = Double.parseDouble(txt_input.getText());
                operandTwo = getAdditionResult();
                flag = false;
            }
        }
    }

    private double getSubtractionResult() {
        txt_input.setText((operandOne - operandTwo) + "");
        series.clear();
        switchOn = true;
        return (operandOne - operandTwo);
    }

    private void subtractionOperationResult() {
        if (!txt_input.getText().equals("-") && !switchOn) {
            if (!flag) {
                operandOne = Double.parseDouble(txt_input.getText());
                operandOne = getSubtractionResult();
                flag = true;
            } else {
                operandTwo = Double.parseDouble(txt_input.getText());
                operandOne = operandTwo = getSubtractionResult();
                operandTwo = 0;
            }
        }
    }

    @FXML
    public void getOperatorsResult(ActionEvent event) {
        operator = getKey(event);
        if (txt_input.getText().isEmpty() && !switchOn) {
            readText(event);
        } else {

            if (operator.equals("+"))
                additionOperationResult();
            else if (operator.equals("-"))
                subtractionOperationResult();

            if (!txt_input.getText().equals("-"))
                super.setFirstNumber(Double.parseDouble(txt_input.getText()));
        }
    }

    private static void reset() {
        operandTwo = operandOne = 0;
        series.clear();
        flag = false;
    }

    @FXML
    public void equal() {
        calculate(operator);
        reset();
    }


    @org.jetbrains.annotations.NotNull
    private static String getKey(ActionEvent event) {
        String key = event.getSource().toString();
        key = key.substring(key.length() - 2, key.length() - 1);
        return key;
    }

    @Override
    protected void calculate(String operator) {
        super.setSecondNumber(Double.parseDouble(txt_input.getText()));
        int i = super.getOperator(operator);
        String[] operators = new String[]{"+", "-", "*", "/"};
        txt_input.setText(super.operation(operators[i]) + "");
    }
}
