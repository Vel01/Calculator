package kiz.masterclass.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller extends Operation {


    @FXML
    public void onButtonClick(ActionEvent event) {
        String key = event.getSource().toString();
        key = key.substring(key.length() - 2, key.length() - 1);
        System.out.println(key);
        operateATask(key);

    }

}
