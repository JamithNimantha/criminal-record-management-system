package lk.ijse.gdse.client.controller;

import com.jfoenix.controls.JFXButton;
import javafx.embed.swing.SwingFXUtils;
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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

    private UserService userService;

    @FXML
    void btnLoginInOnAction(ActionEvent event){
        try {
            checkLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void txtIDOnAction(ActionEvent event) {
        txtPass.requestFocus();
    }

    @FXML
    void txtPassOnAction(ActionEvent event) {
        try {
            checkLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void checkLogin() throws IOException {
        /*
        ********************************
        One time ID and Pass Generation
        ********************************
         */

        /* */
//
//        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgLogo.getImage(),null);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
//        byte [] bytes = byteArrayOutputStream.toByteArray();
//        byteArrayOutputStream.close();
//        try {
//            boolean b = userService.addUser(
//                    new UserDTO(
//                            "admin",
//                            null,
//                            null,
//                            "Administrator",
//                            null,
//                            null,
//                            null,
//                            null,
//                            "admin",
//                            bytes
//                    ));
//            if (b){
//                System.out.println("User Added");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




        try {
            if (!(txtID.getText().isEmpty() && txtID.getText().isEmpty())){
                UserDTO userDTO = userService.searchUser(txtID.getText());
                if (txtPass.getText().equals(userDTO.getPassword())){
                    switch (userDTO.getPermissionLevel()){
                        case "Administrator":
                            path("/lk/ijse/gdse/client/view/admin/DashBoard.fxml");
                            break;
                        case "Officer":
                            //path("/lk/ijse/gdse/client/view/user/DashBoard.fxml");
                            break;
                        case "Investigator":
                            path("/lk/ijse/gdse/client/view/user/DashBoard.fxml");
                            break;
                        default:
                    }
                }else {
                    Notification.createError("Invalid Password","Please Enter valid Password");
                    txtPass.clear();
                    txtPass.requestFocus();
                }
            }else {
                Notification.createError("Login Details Empty","Please Enter Login Details");
                txtID.requestFocus();
            }

        } catch (Exception e) {
            Notification.createError("Invalid UserID","Please Enter Valid UserID");
            e.printStackTrace();
            clearText();
            txtID.requestFocus();
        }
    }

    private void path(String path){
        Stage stage= (Stage) btnLogin.getScene().getWindow();
        Parent parent = null;
        try {
            parent = FXMLLoader.load(this.getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
    private void clearText(){
        txtID.clear();
        txtPass.clear();
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
