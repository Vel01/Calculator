package kiz.masterclass.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TextField txt_input;

    private static double total = 0;
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
            in = in + next;
        }
        txt_input.setText(in);
        switchOn = false;
    }


    private double getOperatorResult() {
        double result = 0;
//        if (operator.equals("+")) {
//            txt_input.setText((operandOne + operandTwo) + "");
//            result = (operandOne + operandTwo);
//        } else
        switchOn = true;
        series.clear();
        System.out.println(result);
        return result;
    }

    private void processingOperatorResult() {
        if (!switchOn) {
            if (!flag) {
                operandOne = Double.parseDouble(txt_input.getText());
                total = operandOne = getOperatorResult();
                flag = true;
            } else {
                operandTwo = Double.parseDouble(txt_input.getText());
                total = operandTwo = getOperatorResult();
                flag = false;
            }
        }
    }

    @FXML
    public void getOperatorWithResult(ActionEvent event) {
        operator = getKey(event);
        processingOperatorResult();
    }

    @FXML
    public void equal() {

        txt_input.setText((total + Double.parseDouble(txt_input.getText())) + "");
        //reset
        total = 0;
        operandOne = total;
        operandTwo = total;
        series.clear();
    }


    @org.jetbrains.annotations.NotNull
    private static String getKey(ActionEvent event) {
        String key = event.getSource().toString();
        key = key.substring(key.length() - 2, key.length() - 1);
        return key;
    }

}
