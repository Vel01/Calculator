package kiz.masterclass.calculator;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleCalculator {

    private static double firstNumber = 0;
    private static double secondNumber = 0;

    private List<String> operators = new ArrayList<>(List.of("+", "-", "*", "/"));

    protected abstract void calculate(String operator);

    protected double operation(String operator) {
        switch (operator) {
            case "+":
                return (firstNumber + secondNumber);
            case "-":
                return (firstNumber - secondNumber);
            case "*":
                return (firstNumber * secondNumber);
            case "/":
                return (firstNumber / secondNumber);
        }
        return 0;
    }

    protected int getOperator(String operator) {
        return operators.indexOf(operator);
    }

    protected void setFirstNumber(double firstNumber) {
        SimpleCalculator.firstNumber = firstNumber;
    }

    protected void setSecondNumber(double secondNumber) {
        SimpleCalculator.secondNumber = secondNumber;
    }

}
