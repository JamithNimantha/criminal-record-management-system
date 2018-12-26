package lk.ijse.gdse.client.controller.user;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageCriminalController implements Initializable {

    @FXML
    private ImageView imgPhoto;

    @FXML
    private Button btnUpload;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNickName;

    @FXML
    private JFXTextField txtBirthRegID;

    @FXML
    private JFXDatePicker datBirth;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtBirthPlace;

    @FXML
    private JFXTextField txtOccupation;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtHeight;

    @FXML
    private JFXTextField txtHair;

    @FXML
    private JFXTextField txtEyes;

    @FXML
    private JFXComboBox<String> cmbGender;

    @FXML
    private JFXTextField txtComplexion;

    @FXML
    private JFXTextField txtReligion;

    @FXML
    private JFXTextField txtEthnicity;

    @FXML
    private JFXTextField txtPolitic;

    @FXML
    private JFXTextField txtRecordID;

    @FXML
    private JFXTextField txtRecordName;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private TableView<?> tblCriminal;

    @FXML
    private JFXComboBox<String> cmbCivilStatus;



    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnUploadOnAction(ActionEvent event) {

    }

    @FXML
    void datBirthOnAction(ActionEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtBirthRegID(ActionEvent event) {

    }

    @FXML
    void txtComplexionOnAction(ActionEvent event) {

    }

    @FXML
    void txtEthnicityOnAction(ActionEvent event) {

    }

    @FXML
    void txtEyes(ActionEvent event) {

    }

    @FXML
    void txtHairOnAction(ActionEvent event) {

    }

    @FXML
    void txtHeightOnAction(ActionEvent event) {

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
    void txtNickNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtOccupation(ActionEvent event) {

    }

    @FXML
    void txtPoliticOnAction(ActionEvent event) {

    }

    @FXML
    void txtRecordIDOnAction(ActionEvent event) {

    }

    @FXML
    void txtRecordNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtReligionOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGender();
        setcivilStatus();
    }

    private void setGender(){
        ObservableList<String>genderList= FXCollections.observableArrayList("Male","Female");
        cmbGender.setItems(genderList);
    }

    private void setcivilStatus(){
        ObservableList<String>statusList=FXCollections.observableArrayList("Single","Married","Divorced","Widowed");
        cmbCivilStatus.setItems(statusList);
    }

}
