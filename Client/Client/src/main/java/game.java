import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.function.Consumer;


public class game {
        @FXML
        public Button zeroButton;
        @FXML
        public Button oneButton;
        @FXML
        public Button twoButton;
        @FXML
        public Button threeButton;
        @FXML
        public Button fourButton;
        @FXML
        public Button fiveButton;
        @FXML
        private ListView<String> listViewClient;

        @FXML
        private ImageView fiveOption;

        @FXML
        private ImageView fourOption;

        @FXML
        private ImageView oneOption;

        @FXML
        private ImageView threeOption;

        @FXML
        private ImageView twoOption;

        @FXML
        private ImageView zeroOption;

        Integer playerPick = -1;
        Integer totalGuess = -1;
        MorraInfo message;
        Client connection;

        public Integer getPlayerPick(){
                return playerPick;
        }

        public void zeroFunction(ActionEvent e) throws IOException {
                playerPick = 0;
                connection.sendMorraInfoClass("0");
        }

        public void oneFunction(ActionEvent e) throws IOException {
                playerPick = 1;
        }

        public void twoFunction(ActionEvent e) throws IOException {
                playerPick = 2;
        }

        public void threeFunction(ActionEvent e) throws IOException {
                playerPick = 3;
        }

        public void fourFunction(ActionEvent e) throws IOException {
                playerPick = 4;
        }

        public void fiveFunction(ActionEvent e) throws IOException {
                playerPick = 5;
        }

        public void setTotalGuess(Integer num)
        {
                totalGuess = num;
        }

        public void setMorraInfo(MorraInfo data)
        {
                message = data;
        }

        public void addListViewClient(String text)
        {
                listViewClient.getItems().add(text);
        }

        public void setClient(Client clientConnection) {
                connection = clientConnection;
        }

        public void sendMorraInfo()
        {
                MorraInfo morraInfo = new MorraInfo();
                morraInfo.p1Guess = playerPick;
                morraInfo.p2Guess = playerPick;

                connection.send(morraInfo);
        }
}

