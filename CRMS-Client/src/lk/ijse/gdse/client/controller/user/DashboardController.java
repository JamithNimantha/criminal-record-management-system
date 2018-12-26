package lk.ijse.gdse.client.controller.user;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private AnchorPane pnlMain;

    @FXML
    private ImageView imgLogo;

    @FXML
    private JFXButton btnDash;

    @FXML
    private JFXButton btnRecords;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnSettings;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnCriminals;

    @FXML
    private JFXButton btnReports;

    @FXML
    private JFXButton btnUser;

    @FXML
    void btnCriminalsOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            Parent parent= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/client/view/Login.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnRecordsOnAction(ActionEvent event) {

    }

    @FXML
    void btnReportsOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) {

    }

    @FXML
    void btnUserOnAction(ActionEvent event) {
        Node node = null;
        try {
            node = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/client/view/admin/ManageUser.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!pnlMain.getChildren().isEmpty()){
            pnlMain.getChildren().remove(0);
        }
        pnlMain.getChildren().add(node);



    }

}
