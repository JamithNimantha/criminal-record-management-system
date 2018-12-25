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
import lk.ijse.gdse.client.common.Notification;
import lk.ijse.gdse.client.proxy.ProxyHandler;
import lk.ijse.gdse.common.dto.UserDTO;
import lk.ijse.gdse.common.service.ServiceFactory;
import lk.ijse.gdse.common.service.custom.UserService;

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

    UserService userService;

    @FXML
    void btnLoginInOnAction(ActionEvent event){
        /*
        ********************************
        One time ID and Pass Generation
        ********************************
         */

        /*
        try {
            boolean b = userService.addUser(
                    new UserDTO(
                            txtID.getText(),
                            null,
                            null,
                            "Administrator",
                            null,
                            null,
                            null,
                            null,
                            txtPass.getText(),
                            null
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        */


        try {
            if (!(txtID.getText().isEmpty() && txtID.getText().isEmpty())){
                UserDTO userDTO = userService.searchUser(txtID.getText());
                if (txtPass.getText().equals(userDTO.getPassword())){
                    switch (userDTO.getPermissionLevel()){
                        case "Administrator":
                            Stage stage= (Stage) btnLogin.getScene().getWindow();
                            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/client/view/admin/DashBoard.fxml"));
                            Scene scene = new Scene(parent);
                            stage.setScene(scene);
                            stage.centerOnScreen();
                            stage.setResizable(false);
                            stage.show();
                            break;
                        case "Officer":
                            break;
                        case "Investigator":
                            break;
                            default:
                    }
                }else {
                    Notification.createError("Invalid Password","Please Enter valid Password");
                }
            }else {
                Notification.createError("Login Details Empty","Please Enter Login Details");
            }

        } catch (Exception e) {
            Notification.createError("Invalid UserID","Please Enter Valid UserID");
            //e.printStackTrace();
        }

    }


    @FXML
    void txtIDOnAction(ActionEvent event) {

    }

    @FXML
    void txtPassOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            userService= ProxyHandler.getInstance().getSuperService(ServiceFactory.ServiceTypes.USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
