package lk.ijse.gdse.client.controller.user;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.gdse.client.common.DateConverter;
import lk.ijse.gdse.client.common.Notification;
import lk.ijse.gdse.client.proxy.ProxyHandler;
import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.common.dto.CriminalDetailDTO;
import lk.ijse.gdse.common.dto.CustomDTO;
import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.common.service.custom.CriminalService;
import lk.ijse.gdse.common.service.custom.RecordService;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
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
    private TableView<CustomDTO> tblCriminal;

    @FXML
    private JFXComboBox<String> cmbCivilStatus;

    private CriminalService criminalService;

    private RecordService recordService;

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        try {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgPhoto.getImage(),null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
            byte [] bytes=byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            CriminalDTO criminalDTO=new CriminalDTO(
                    txtID.getText(),
                    txtName.getText(),
                    txtNickName.getText(),
                    txtNIC.getText(),
                    Date.valueOf(datBirth.getValue()),
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
                    txtEyes.getText(),
                    bytes
            );
            boolean result = criminalService.deleteCriminal(criminalDTO, txtRecordID.getText());
            if (result){
                Notification.createSuccesful("Successfull","Criminal removed Successfully");
                getAllCriminals();
                clearFields();
            }else{
                Notification.createError("Failed","Criminal Cannot be removed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgPhoto.getImage(),null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
            byte [] bytes=byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            CriminalDTO criminalDTO=new CriminalDTO(
                    txtID.getText(),
                    txtName.getText(),
                    txtNickName.getText(),
                    txtNIC.getText(),
                    Date.valueOf(datBirth.getValue()),
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
                    txtEyes.getText(),
                    bytes
            );
            boolean result = criminalService.addCriminal(criminalDTO, txtRecordID.getText());
            if (result){
                Notification.createSuccesful("Successfull","Criminal Added Successfully");
                getAllCriminals();
                clearFields();
            }else{
                Notification.createError("Failed","Criminal Cannot be Added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgPhoto.getImage(),null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
            byte [] bytes=byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            CriminalDTO criminalDTO=new CriminalDTO(
                    txtID.getText(),
                    txtName.getText(),
                    txtNickName.getText(),
                    txtNIC.getText(),
                    Date.valueOf(datBirth.getValue()),
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
                    txtEyes.getText(),
                    bytes
            );
            boolean result = criminalService.updateCriminal(criminalDTO, txtRecordID.getText());
            if (result){
                Notification.createSuccesful("Successfull","Criminal updated Successfully");
                getAllCriminals();
                clearFields();
            }else{
                Notification.createError("Failed","Criminal Cannot be updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                imgPhoto.setFitHeight(226);
                imgPhoto.setFitWidth(365);
                imgPhoto.setPreserveRatio(true);
                imgPhoto.setSmooth(true);

            }else {
                Notification.createError("photo not Selected","You have not selected a Photo");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void datBirthOnAction(ActionEvent event) {
        txtAge.setText(String.valueOf(DateConverter.calculateAge(datBirth.getValue(), LocalDate.now())));
        cmbGender.requestFocus();

    }
    @FXML
    void cmbGenderOnAction(ActionEvent event) {
        txtBirthRegID.requestFocus();
    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {
        txtEthnicity.requestFocus();
    }

    @FXML
    void txtBirthRegID(ActionEvent event) {
        txtBirthPlace.requestFocus();
    }
    @FXML
    void txtBirthplaceOnAction(ActionEvent event) {
        cmbCivilStatus.requestFocus();

    }
    @FXML
    void cmbCivilStatusOnAction(ActionEvent event) {

        txtOccupation.requestFocus();
    }

    @FXML
    void txtComplexionOnAction(ActionEvent event) {
        txtHair.requestFocus();
    }

    @FXML
    void txtEthnicityOnAction(ActionEvent event) {
        txtPolitic.requestFocus();
    }

    @FXML
    void txtEyes(ActionEvent event) {
        txtRecordID.requestFocus();
    }

    @FXML
    void txtHairOnAction(ActionEvent event) {
        txtEyes.requestFocus();
    }

    @FXML
    void txtHeightOnAction(ActionEvent event) {
        txtComplexion.requestFocus();
    }

    @FXML
    void txtIDOnAction(ActionEvent event) {
        txtName.requestFocus();

    }

    @FXML
    void txtName(ActionEvent event) {
        datBirth.requestFocus();
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtNickName.requestFocus();
    }

    @FXML
    void txtNickNameOnAction(ActionEvent event) {
        txtNIC.requestFocus();
    }

    @FXML
    void txtOccupation(ActionEvent event) {
        txtAddress.requestFocus();

    }

    @FXML
    void tblCriminalOnClicked(MouseEvent event) {
        if (tblCriminal.getSelectionModel().getSelectedIndex()!=-1){
            CustomDTO dto = tblCriminal.getSelectionModel().getSelectedItem();
            txtID.setText(dto.getCriminalId());
            txtName.setText(dto.getCriminalName());
            txtNickName.setText(dto.getCriminalName());
            txtNIC.setText(dto.getCriminalNIC());
            datBirth.setValue(DateConverter.fromDate(dto.getCriminalDOB()));
            txtAge.setText(String.valueOf(dto.getAge()));
            cmbCivilStatus.setValue(dto.getCivilStatus());
            txtBirthRegID.setText(dto.getBirthRegID());
            txtBirthPlace.setText(dto.getBirthPlace());
            cmbCivilStatus.setValue(dto.getCivilStatus());
            txtOccupation.setText(dto.getOccupation());
            txtAddress.setText(dto.getAddress());
            txtEthnicity.setText(dto.getEthnicity());
            txtPolitic.setText(dto.getPoliticalView());
            txtReligion.setText(dto.getReligion());
            txtHeight.setText(String.valueOf(dto.getHeight()));
            txtComplexion.setText(dto.getComplexion());
            txtHair.setText(dto.getHair());
            txtEyes.setText(dto.getEyes());
            txtRecordID.setText(dto.getRecordID());
//            imgPhoto.setImage(new Image(new ByteArrayInputStream(dto.getPhoto())));
//            imgPhoto.setFitHeight(226);
//            imgPhoto.setFitWidth(365);
//            imgPhoto.setPreserveRatio(true);
//            imgPhoto.setSmooth(true);
        }
    }

    @FXML
    void txtPoliticOnAction(ActionEvent event) {
        txtReligion.requestFocus();
    }

    @FXML
    void txtRecordIDOnAction(ActionEvent event) {
        try {
            RecordDTO recordDTO = recordService.searchRecord(txtRecordID.getText());
            txtRecordName.setText(recordDTO.getRecordName());
        } catch (Exception e) {
            Notification.createError("cannot find Record ID for "+txtRecordID.getText(),"Try Again with another Record ID");
            e.printStackTrace();
        }

    }

    @FXML
    void txtRecordNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtReligionOnAction(ActionEvent event) {
        txtHeight.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            criminalService= ProxyHandler.getInstance().getSuperService(ProxyHandler.ServiceTypes.CRIMINAL);
            recordService = ProxyHandler.getInstance().getSuperService(ProxyHandler.ServiceTypes.RECORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setGender();
        setcivilStatus();
        Platform.runLater(() -> txtID.requestFocus());
        tblCriminal.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("criminalId"));
        tblCriminal.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("criminalName"));
        tblCriminal.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblCriminal.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ethnicity"));
        tblCriminal.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("criminalNIC"));
        tblCriminal.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("civilStatus"));
        tblCriminal.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCriminal.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("recordID"));
        getAllCriminals();

    }

    private void setGender(){
        ObservableList<String>genderList= FXCollections.observableArrayList("Male","Female");
        cmbGender.setItems(genderList);
    }

    private void setcivilStatus(){
        ObservableList<String>statusList=FXCollections.observableArrayList("Single","Married","Divorced","Widowed");
        cmbCivilStatus.setItems(statusList);
    }

    private void clearFields(){
        txtID.clear();
        txtName.clear();
        txtNickName.clear();
        txtNIC.clear();
        txtAge.clear();
        datBirth.setValue(null);
        cmbGender.setValue(null);
        txtBirthRegID.clear();
        txtBirthPlace.clear();
        cmbCivilStatus.setValue(null);
        txtOccupation.clear();
        txtAddress.clear();
        txtEthnicity.clear();
        txtPolitic.clear();
        txtReligion.clear();
        txtHair.clear();
        txtComplexion.clear();
        txtHair.clear();
        txtEyes.clear();
        txtRecordID.clear();
        txtRecordName.clear();
        txtID.requestFocus();
        imgPhoto.setImage(new Image("lk/ijse/gdse/client/assests/qKiiBMl.jpeg"));
    }
    private void getAllCriminals(){
        try {
            tblCriminal.getItems().clear();
            List<CriminalDetailDTO> allCriminals = criminalService.getAllCriminals();
            for (CriminalDetailDTO criminalDetailDTO: allCriminals){
                CustomDTO customDTO=new CustomDTO(
                        criminalDetailDTO.getCriminal().getCriminalId(),
                        criminalDetailDTO.getCriminal().getCriminalName(),
                        criminalDetailDTO.getCriminal().getCriminalNickName(),
                        criminalDetailDTO.getCriminal().getCriminalNIC(),
                        criminalDetailDTO.getCriminal().getCriminalDOB(),
                        criminalDetailDTO.getCriminal().getAge(),
                        criminalDetailDTO.getCriminal().getGender(),
                        criminalDetailDTO.getCriminal().getBirthRegID(),
                        criminalDetailDTO.getCriminal().getBirthPlace(),
                        criminalDetailDTO.getCriminal().getCivilStatus(),
                        criminalDetailDTO.getCriminal().getOccupation(),
                        criminalDetailDTO.getCriminal().getAddress(),
                        criminalDetailDTO.getCriminal().getEthnicity(),
                        criminalDetailDTO.getCriminal().getPoliticalView(),
                        criminalDetailDTO.getCriminal().getReligion(),
                        criminalDetailDTO.getCriminal().getHeight(),
                        criminalDetailDTO.getCriminal().getComplexion(),
                        criminalDetailDTO.getCriminal().getHair(),
                        criminalDetailDTO.getCriminal().getEyes(),
                        criminalDetailDTO.getCriminal().getPhoto(),
                        criminalDetailDTO.getRecord().getRecordID());
                tblCriminal.getItems().addAll(customDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
