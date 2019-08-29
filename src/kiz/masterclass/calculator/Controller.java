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
    private boolean flag = false;
    private boolean switchOn = false;


    private static List<String> series = new ArrayList<>();

    @FXML
    public void onButtonClick(ActionEvent event) {
        series.add(getKey(event));
        String in = "";
        for (String next : series) {
            in = String.format("%s%s", in, next);
        }
        txt_input.setText(in);
        switchOn = false;
    }

    private double getOperatorResult() {
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
                operandOne = getOperatorResult();
                flag = true;
            } else {
                operandTwo = Double.parseDouble(txt_input.getText());
                operandTwo = getOperatorResult();
                flag = false;
            }
        }
    }

    @FXML
    public void getOperatorWithResult(ActionEvent event) {
        operator = getKey(event);

        if (!flag) {
            operandOne = Double.parseDouble(txt_input.getText());
            txt_input.setText((operandOne - operandTwo) + "");
            series.clear();

            flag = true;
        } else {
            operandTwo = Double.parseDouble(txt_input.getText());
            txt_input.setText((operandOne - operandTwo) + "");
            series.clear();

            flag = false;
        }


//        close for debugging purposes
//        if (operator.equals("+"))
//            additionOperationResult();
//
//        super.setFirstNumber(Double.parseDouble(txt_input.getText()));
    }


    @FXML
    public void equal() {

        calculate(operator);
        //reset
        operandOne = 0;
        operandTwo = 0;
        series.clear();
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
