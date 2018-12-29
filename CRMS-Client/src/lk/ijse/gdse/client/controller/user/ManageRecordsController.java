package lk.ijse.gdse.client.controller.user;

import com.jfoenix.controls.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.gdse.client.common.DateConverter;
import lk.ijse.gdse.client.common.Notification;
import lk.ijse.gdse.client.common.Validation;
import lk.ijse.gdse.client.proxy.ProxyHandler;
import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.common.service.ServiceFactory;
import lk.ijse.gdse.common.service.custom.RecordService;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
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
    private TableView<RecordDTO> tblRecords;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnRemove;

    private static RecordService recordService;
    static {
        try {
            recordService=ProxyHandler.getInstance().getSuperService(ProxyHandler.ServiceTypes.RECORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        boolean result = false;
        try {
            result = recordService.deleteRecord(
                    new RecordDTO(
                            txtRecordID.getText(),
                            txtRecordName.getText(),
                            cmbRecordcategory.getSelectionModel().getSelectedItem(),
                            txtIncidentLocation.getText(),
                            Date.valueOf(dateIncidentDate.getValue()),
                            Time.valueOf(timeIncidentTime.getValue()),
                            txtVictimName.getText(),
                            txtRecordDescription.getText()
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result){
            Notification.createSuccesful("Record Deleted","Crime Record Deleted Successfully");
            clearFields();
            getAllRecords();
        }else {
            Notification.createError("Failed","Crime Record Cannot be Delete");
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        boolean result = false;
        try {
            result = recordService.addRecord(
                    new RecordDTO(
                        txtRecordID.getText(),
                        txtRecordName.getText(),
                        cmbRecordcategory.getSelectionModel().getSelectedItem(),
                        txtIncidentLocation.getText(),
                        Date.valueOf(dateIncidentDate.getValue()),
                        Time.valueOf(timeIncidentTime.getValue()),
                        txtVictimName.getText(),
                        txtRecordDescription.getText()
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result){
            Notification.createSuccesful("Record Added","Crime Record Added Successfully");
            setCrimeCategory();
            clearFields();
            getAllRecords();
        }else {
            Notification.createError("Failed","Crime Record Cannot be Add");
        }


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        try {
            RecordDTO selectedItem = recordService.searchRecord(txtRecordID.getText());
            txtRecordID.setText(String.valueOf(selectedItem.getRecordID()));
            txtRecordName.setText(selectedItem.getRecordName());
            cmbRecordcategory.setValue(selectedItem.getRecordCategory());
            txtIncidentLocation.setText(selectedItem.getIncidentLocation());
            dateIncidentDate.setValue(DateConverter.fromDate(selectedItem.getIncidentDate()));
            timeIncidentTime.setValue(DateConverter.fromTime(selectedItem.getIncidentTIme()));
            txtVictimName.setText(selectedItem.getVictimsName());
            txtRecordDescription.setText(selectedItem.getRecordDec());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        boolean result = false;
        try {
            result = recordService.updateRecord(
                    new RecordDTO(
                            txtRecordID.getText(),
                            txtRecordName.getText(),
                            cmbRecordcategory.getSelectionModel().getSelectedItem(),
                            txtIncidentLocation.getText(),
                            Date.valueOf(dateIncidentDate.getValue()),
                            Time.valueOf(timeIncidentTime.getValue()),
                            txtVictimName.getText(),
                            txtRecordDescription.getText()
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result){
            Notification.createSuccesful("Record Updated","Crime Record update Successfully");

            getAllRecords();
            clearFields();
        }else {
            Notification.createError("Failed","Crime Record Cannot be update");
        }

    }

    @FXML
    void cmbRecordcategoryOnAction(ActionEvent event) {
        txtIncidentLocation.requestFocus();

    }

    @FXML
    void dateIncidentDateOnAction(ActionEvent event) {
        if (dateIncidentDate.getValue()==null)
            dateIncidentDate.requestFocus();
        timeIncidentTime.requestFocus();


    }

    @FXML
    void timeIncidentTimeOnAction(ActionEvent event) {
        if (timeIncidentTime.getValue()==null)
            timeIncidentTime.requestFocus();
        txtVictimName.requestFocus();

    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {
        dateIncidentDate.requestFocus();

    }

    @FXML
    void txtRecordIDOnAction(ActionEvent event) {
        txtRecordName.requestFocus();

    }

    @FXML
    void txtRecordNameOnAction(ActionEvent event) {
        if (txtRecordName.getText().isEmpty() &&(!Validation.nameValidate(txtRecordName.getText())) ){
            txtRecordName.requestFocus();
            txtRecordName.selectAll();
        }
        cmbRecordcategory.requestFocus();

    }

    @FXML
    void txtVictimNameOnAction(ActionEvent event) {
        txtRecordDescription.requestFocus();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
////            recordService= ProxyHandler.getInstance().getSuperService(ProxyHandler.ServiceTypes.RECORD);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Platform.runLater(() -> txtRecordID.requestFocus());

        setCrimeCategory();
        tblRecords.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("recordID"));
        tblRecords.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("recordCategory"));
        tblRecords.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("recordName"));
        tblRecords.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("incidentDate"));
        tblRecords.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("victimsName"));
        getAllRecords();

    }
    void setCrimeCategory(){
        ObservableList<String> list = FXCollections.observableArrayList("Homicide","Rape or Abuse","Child Abuse","Kidnapping","Assault","Battery","Robbery","Terrorism","Drug Dealing");
        cmbRecordcategory.setItems(list);

    }

    private void clearFields(){
        cmbRecordcategory.setValue(null);
        txtRecordID.clear();
        txtRecordName.clear();
        txtIncidentLocation.clear();
        txtRecordDescription.clear();
        txtVictimName.clear();
        dateIncidentDate.setValue(null);
        timeIncidentTime.setValue(null);
        txtRecordID.requestFocus();
    }

    @FXML
    void tblRecordsOnMouseClicked(MouseEvent event) {
        if (tblRecords.getSelectionModel().getSelectedIndex()!=-1){
            RecordDTO selectedItem = tblRecords.getSelectionModel().getSelectedItem();
            txtRecordID.setText(String.valueOf(selectedItem.getRecordID()));
            txtRecordName.setText(selectedItem.getRecordName());
            cmbRecordcategory.setValue(selectedItem.getRecordCategory());
            txtIncidentLocation.setText(selectedItem.getIncidentLocation());
            dateIncidentDate.setValue(DateConverter.fromDate(selectedItem.getIncidentDate()));
            timeIncidentTime.setValue(DateConverter.fromTime(selectedItem.getIncidentTIme()));
            txtVictimName.setText(selectedItem.getVictimsName());
            txtRecordDescription.setText(selectedItem.getRecordDec());

        }

    }

    private void getAllRecords(){
        try {
            List<RecordDTO> recordDTOS = recordService.getAllRecords();
            tblRecords.setItems(FXCollections.observableArrayList(recordDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
