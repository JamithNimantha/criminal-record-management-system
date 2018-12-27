package lk.ijse.gdse.client.controller.user;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.gdse.client.common.Notification;
import lk.ijse.gdse.client.proxy.ProxyHandler;
import lk.ijse.gdse.common.dto.UserDTO;
import lk.ijse.gdse.common.service.ServiceFactory;
import lk.ijse.gdse.common.service.custom.UserService;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OfficerController implements Initializable {

    @FXML
    private ImageView imgPhoto;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPosition;

    @FXML
    private JFXTextField txtDepartment;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtTel;

    @FXML
    private TableView<UserDTO> tblUser;

    @FXML
    private JFXTextField txtPermissionLevel;

    private UserService userService;

    @FXML
    void btnSearchOnAction(ActionEvent event){
        searchUser();
    }

    @FXML
    void tblUserOnMouseClicked(MouseEvent event) {
        if (tblUser.getSelectionModel().getSelectedIndex()!=-1){
            UserDTO selectedItem = tblUser.getSelectionModel().getSelectedItem();
            txtID.setText(selectedItem.getID());
            txtName.setText(selectedItem.getName());
            txtAddress.setText(selectedItem.getAddress());
            txtPosition.setText(selectedItem.getPosition());
            txtDepartment.setText(selectedItem.getDepartment());
            txtTel.setText(selectedItem.getTelphone());
            txtEmail.setText(selectedItem.getEmail());
            txtPermissionLevel.setText(selectedItem.getPermissionLevel());
            imgPhoto.setImage(new Image(new ByteArrayInputStream(selectedItem.getPhoto())));
            imgPhoto.setPreserveRatio(true);
            imgPhoto.setSmooth(true);
        }
    }

    @FXML
    void txtIDOnAction(ActionEvent event) {
        searchUser();
    }

    private void searchUser(){
        try {
            UserDTO selectedItem = userService.searchUser(txtID.getText());
            txtID.setText(selectedItem.getID());
            txtName.setText(selectedItem.getName());
            txtAddress.setText(selectedItem.getAddress());
            txtPosition.setText(selectedItem.getPosition());
            txtDepartment.setText(selectedItem.getDepartment());
            txtTel.setText(selectedItem.getTelphone());
            txtEmail.setText(selectedItem.getEmail());
            txtPermissionLevel.setText(selectedItem.getPermissionLevel());
            imgPhoto.setImage(new Image(new ByteArrayInputStream(selectedItem.getPhoto())));
            imgPhoto.setPreserveRatio(true);
            imgPhoto.setSmooth(true);
        } catch (Exception e) {
            Notification.createError("Unavialable USer","Cannot find User");
           // e.printStackTrace();
        }

    }

    private void getAllUsers(){
        List<UserDTO> userDTOS =null;
        try {
            userDTOS=userService.getAllUsers();
        } catch (Exception e) {
            Notification.createError("Database Error","Contact System Admin");
          //  e.printStackTrace();
        }
        tblUser.setItems(FXCollections.observableArrayList(userDTOS));


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            userService = ProxyHandler.getInstance().getSuperService(ServiceFactory.ServiceTypes.USER);
        } catch (Exception e) {
            Notification.createError("Database Error","Contact System Admin");
        }
        tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblUser.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("position"));
        tblUser.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("department"));
        tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("telphone"));
        getAllUsers();
    }
}
