package duykhanh;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerClose implements Initializable {

    private Stage stage;

    @FXML
    private void closeWindow(MouseEvent event) {
        stage = ( Stage ) (( ImageView ) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
