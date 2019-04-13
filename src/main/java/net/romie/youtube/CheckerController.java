package net.romie.youtube;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CheckerController {

    @FXML
    public TextField textField;
    @FXML
    public Label label;

    public void onConfirmClick(){
        if (textField.getText().isEmpty()) return;
        validateUser(textField.getText());
    }

    /**
     * Search their youtube about page
     * and check if it contains the generated
     * code
     * @param ID - ID of the youtube channel
     */
    private void validateUser(String ID){
        try {
            URL url = new URL("https://www.youtube.com/channel/" + ID + "/about");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains(GeneratorController.getUserKey().toString())) {
                    label.setText("You have been validated!");
                    label.setTextFill(Color.GREEN);
                    in.close();
                    return;
                }
            }
            label.setText("You have not been validated!");
            label.setTextFill(Color.RED);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
