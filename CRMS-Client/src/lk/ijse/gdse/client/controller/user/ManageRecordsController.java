package lk.ijse.gdse.client.controller.user;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import lk.ijse.gdse.client.proxy.ProxyHandler;
import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.common.service.ServiceFactory;
import lk.ijse.gdse.common.service.custom.RecordService;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ManageRecordsController implements Initializable {

    @FXML
    private JFXTextField txtRecordID;

    @FXML
    private JFXTextField txtRecordName;

    @FXML
    private JFXTextField txtVictimName;

    @FXML
    private JFXTextField txtIncidentLocation;

    @FXML
    private JFXComboBox<String> cmbRecordcategory;

    @FXML
    private JFXTextArea txtRecordDescription;

    @FXML
    private JFXDatePicker dateIncidentDate;

    @FXML
    private JFXTimePicker timeIncidentTime;

    @FXML
    private TableView<?> tblRecords;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXTextField txtInvestigatingOfficer;
    private static RecordService recordService;
    static {
        try {
            recordService= ProxyHandler.getInstance().getSuperService(ProxyHandler.ServiceTypes.RECORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {

        RecordDTO recordDTO=new RecordDTO(
                Integer.parseInt(txtRecordID.getText()),
                txtRecordName.getText(),
                cmbRecordcategory.getSelectionModel().getSelectedItem(),
                txtIncidentLocation.getText(),
                new Date(),
                new Date(),
                txtVictimName.getText(),
                txtRecordDescription.getText()
        );
        boolean result = recordService.addRecord(recordDTO);
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
    void cmbRecordcategoryOnAction(ActionEvent event) {

    }

    @FXML
    void dateIncidentDateOnAction(ActionEvent event) {

    }

    @FXML
    void timeIncidentTimeOnAction(ActionEvent event) {

    }

    @FXML
    void txtInvestigatingOfficerOnAcion(ActionEvent event) {

    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {

    }

    @FXML
    void txtRecordIDOnAction(ActionEvent event) {

    }

    @FXML
    void txtRecordNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtVictimNameOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    setCrimeCategory();

    }
    private void setCrimeCategory(){
        ObservableList<String> list = FXCollections.observableArrayList("Homicide","Rape or Abuse","Child Abuse","Kidnapping","Assault","Battery","Robbery","Terrorism","Drug Dealing");
        cmbRecordcategory.setItems(list);
    }
}
