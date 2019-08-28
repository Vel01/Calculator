package kiz.masterclass.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

abstract class Operation {

    //    @FXML
//    private Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine;

    @FXML
    private TextField txt_input;
    @FXML
    private Label lbl_display;


    private static List<String> keys = new ArrayList<>();

    private void readInput() {
        StringBuilder in = new StringBuilder();
        for (String val : keys) {
            in.append(val);
        }
        txt_input.setText(in.toString());
    }

    void operateATask(String key) {

        if (key.equals("'") && !Operation.keys.isEmpty()) {
            Operation.keys.remove(Operation.keys.size() - 1);
            readInput();
        }

        if (key.equals("C")) {
            Operation.keys.clear();
            readInput();
        }

        if (!key.equals("'") && !key.equals("C") && !key.equals("=")) {
            Operation.keys.add(key);
            readInput();
        }

        if (key.equals("=")) {
            lbl_display.setText(txt_input.getText());
            txt_input.clear();
            keys.clear();
        }

    }


}
