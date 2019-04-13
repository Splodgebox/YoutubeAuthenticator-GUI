package net.romie.youtube;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.UUID;

public class GeneratorController {

    @FXML
    public TextArea code;

    @Getter
    @Setter
    public static UUID userKey;

    public void onButtonClick(ActionEvent event){
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Checker.fxml"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if (root != null) {
            primaryStage.setScene(new Scene(root));
        }
        primaryStage.show();
    }

    private boolean hasBeenDone;

    /**
     * Generate a youtube key in which the
     * user can place on their 'about' section
     * on youtube so the program can check it
     */
    public void generateCode() {
        if (hasBeenDone) return;
        UUID uuid = UUID.randomUUID();
        setUserKey(uuid);
        hasBeenDone = true;
        code.setText(uuid.toString());
    }
}
