package lk.ijse.gdse.client.controller;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.application.LauncherImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ImageView imgLogo;

    @FXML
    private TextField txtID;

    @FXML
    private PasswordField txtPass;

    @FXML
    private JFXButton btnLogin;

    @FXML
    void btnLoginInOnAction(ActionEvent event) throws IOException {
        Stage stage= (Stage) btnLogin.getScene().getWindow();
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/client/view/admin/DashBoard.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }


    @FXML
    void txtIDOnAction(ActionEvent event) {

    }

    @FXML
    void txtPassOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
