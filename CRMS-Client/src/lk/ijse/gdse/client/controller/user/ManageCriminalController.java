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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import lk.ijse.gdse.client.proxy.ProxyHandler;
import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.common.service.ServiceFactory;
import lk.ijse.gdse.common.service.custom.CriminalService;

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

    private static CriminalService criminalService;
    static {
        try {
            criminalService= ProxyHandler.getInstance().getSuperService(ProxyHandler.ServiceTypes.CRIMINAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        CriminalDTO criminalDTO=new CriminalDTO(
                Integer.parseInt(txtID.getText()),
                txtName.getText(),
                txtNickName.getText(),
                txtNIC.getText(),
                datBirth.getValue().toString(),
                Integer.parseInt(txtAge.getText()),
                cmbGender.getSelectionModel().getSelectedItem(),
                txtBirthRegID.getText(),
                txtBirthPlace.getText(),
                cmbCivilStatus.getSelectionModel().getSelectedItem(),
                txtOccupation.getText(),
                txtAddress.getText(),
                txtEthnicity.getText(),
                txtPolitic.getText(),
                txtReligion.getText(),
                Double.parseDouble(txtHeight.getText()),
                txtComplexion.getText(),
                txtHair.getText(),
                txtEyes.getText()
        );
        boolean result = criminalService.addCriiminalCase(criminalDTO, Integer.parseInt(txtRecordID.getText()));
        if (result){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"FUCK", ButtonType.OK);
            alert.show();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR,"Buddhika Ponnaya", ButtonType.OK);
            alert.show();

        }
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
