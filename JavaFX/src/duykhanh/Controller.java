package duykhanh;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    private Button closeButton;
    @FXML
    Stage stage;
    @FXML
    Label label;
    @FXML
    Label eWord;
    @FXML
    TextField textInput;
    @FXML
    WebView view;
    @FXML
    ListView listSearch;
    @FXML
    KeyEvent event;
    private JFXPanel primaryStage;


//    @FXML
//    private void closeWindow(MouseEvent event) {
//        stage = (Stage) (( ImageView) event.getSource()).getScene().getWindow();
//        stage.close();
//    }


    @FXML
    private void speak() throws IOException {

        Ggdich.speakAPI("en", eWord.getText());

    }
    @FXML
    private void changeSearch() {

        if (textInput.getText().length()>0) {
            listSearch.getItems().add(textInput.getText());
        }
    }
    @FXML
    private void handle()
    {
        if(event.getCode()==(KeyCode.ENTER)) {
            listSearch.getItems().add(textInput.getText());
        }
    }
//    @FXML
//    private void removeList()
//    {
//
//        if( textInput.getText().length()==0 )
//        {
//
//            listSearch.getItems().clear();
//        }
//    }



    @FXML
    private void addNew() throws IOException {
        Stage astage =new Stage();

        astage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/Add.fxml"));
        astage.setScene(new Scene(root));
        astage.show();
    }

    @FXML
    private void editWord() throws IOException {
        Stage astage =new Stage();

        astage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/Edit.fxml"));
        astage.setScene(new Scene(root));
        astage.show();
    }


    @FXML
    private void remove() throws IOException {
        Stage astage =new Stage();

        astage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/Delete.fxml"));
        astage.setScene(new Scene(root));
        astage.show();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textInput.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            if( textInput.getText().length()==0 )
            {
                listSearch.getItems().clear();
            }
//            if(event.getCode()==(KeyCode.ENTER)) {
//                boolean add = listSearch.getItems().add(textInput.getText());
//                System.out.println("ádsadsad");
//            }
        });



          WebEngine webEngine = view.getEngine();
//        String content="<u><b>Hi</b> <i>Translate</i></u>";
        listSearch.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(
                            ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
                        eWord.setText(newValue);
                    }
                });
//
//
//
//        webEngine.loadContent(content);
//
//        listSearch.getItems().add("a");
//        listSearch.getItems().add("b");
//        listSearch.getItems().add("c");
//        listSearch.getItems().add("d");
//        listSearch.getItems().add("e");
//        listSearch.getItems().add("f");
//        listSearch.getItems().add("g");

    }
}