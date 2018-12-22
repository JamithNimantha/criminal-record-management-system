package lk.ijse.gdse.client.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardController {

    @FXML
    private AnchorPane pnlMain;

    @FXML
    private ImageView imgLogo;

    @FXML
    private JFXButton btnDash;

    @FXML
    private JFXButton btnUser;

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
    void btnCriminalsOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

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
    void btnUserOnAction(ActionEvent event){
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
