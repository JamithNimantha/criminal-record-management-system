package lk.ijse.gdse.client.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageUserController implements Initializable {

    @FXML
    private ImageView imgPhoto;

    @FXML
    private Button btnUpload;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPosition;

    @FXML
    private JFXTextField txtDepartment;

    @FXML
    private JFXComboBox<String> cmbPermission;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtTel;

    @FXML
    private JFXPasswordField txtPass;

    @FXML
    private TableView<?> tblUser;

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnUploadOnAction(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Image");
            fileChooser.setInitialDirectory(new File("/home"));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files",
                             "*.png", "*.jpg"));
            File file = fileChooser.showOpenDialog(new Stage());
            if (file!=null){
                String imagePath= file.toURI().toURL().toString();
                if (imgPhoto!=null){
                    imgPhoto.setImage(null);
                }
                imgPhoto.setImage(new Image(imagePath));
                imgPhoto.setFitHeight(190);
                imgPhoto.setFitWidth(210);
                imgPhoto.setPreserveRatio(true);
                imgPhoto.setSmooth(true);

            }else {
                System.out.println("didnt select a file");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void cmbPermissionOnAction(ActionEvent event) {

    }

    @FXML
    void tblUserOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtDepartmentOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmail(ActionEvent event) {

    }

    @FXML
    void txtIDOnAction(ActionEvent event) {

    }

    @FXML
    void txtName(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtPassOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtTelOnAction(ActionEvent event) {

    }
    void setPermission(){
        ObservableList<String> permissionSet = FXCollections.observableArrayList("Officer", "Investigator", "Administrator");
        cmbPermission.setItems(permissionSet);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setPermission();
    }
}
