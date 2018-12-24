package lk.ijse.gdse.client.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import lk.ijse.gdse.client.common.Notification;
import lk.ijse.gdse.client.proxy.ProxyHandler;
import lk.ijse.gdse.common.dto.UserDTO;
import lk.ijse.gdse.common.service.ServiceFactory;
import lk.ijse.gdse.common.service.custom.UserService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.util.List;
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
    private TableView<UserDTO> tblUser;

    UserService userService;

    private File file;

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgPhoto.getImage(),null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
            byte [] bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
//            byte[] bytes = new byte[(int) file.length()];
//            FileInputStream fileInputStream = new FileInputStream(file);
//            fileInputStream.read(bytes);
//            fileInputStream.close();
            //UserService userService = ProxyHandler.getInstance().getSuperService(ServiceFactory.ServiceTypes.USER);
            boolean b = userService.addUser(
                    new UserDTO(
                            txtID.getText(),
                            txtName.getText(),
                            txtPosition.getText(),
                            cmbPermission.getValue().toString(),
                            txtDepartment.getText(),
                            txtAddress.getText(),
                            txtEmail.getText(),
                            txtTel.getText(),
                            txtPass.getText(),
                            bytes
                    ));
            if (b){
                Notification.createSuccesful("Successfull","User Added Successfully");
                getAllUsers();
            }else {
                Notification.createError("Failed","User Cannot be Added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgPhoto.getImage(),null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
            byte [] bit = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
//            byte[] bytes = new byte[(int) file.length()];
//            FileInputStream fileInputStream = new FileInputStream(file);
//            fileInputStream.read(bytes);
//            fileInputStream.close();
            boolean b = userService.updateUSer(
                    new UserDTO(
                            txtID.getText(),
                            txtName.getText(),
                            txtPosition.getText(),
                            cmbPermission.getValue().toString(),
                            txtDepartment.getText(),
                            txtAddress.getText(),
                            txtEmail.getText(),
                            txtTel.getText(),
                            txtPass.getText(),
                            bit

                    ));
            if (b){
                Notification.createSuccesful("Successfull","User Updated Successfully");
                getAllUsers();
            }else {
                Notification.createError("Failed","User Cannot be Update");
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
            file = fileChooser.showOpenDialog(new Stage());
            if (file!=null){
                String imagePath= file.toURI().toURL().toString();
                if (imgPhoto!=null){
                    imgPhoto.setImage(null);
                }
                imgPhoto.setImage(new Image(imagePath));
                //imgPhoto.getImage();
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
        if (tblUser.getSelectionModel().getSelectedIndex()!=-1){
            UserDTO selectedItem = tblUser.getSelectionModel().getSelectedItem();
            txtID.setText(selectedItem.getID());
            txtName.setText(selectedItem.getName());
            txtPosition.setText(selectedItem.getPosition());
            txtDepartment.setText(selectedItem.getDepartment());
            cmbPermission.setValue(selectedItem.getPermissionLevel());
            txtAddress.setText(selectedItem.getAddress());
            txtEmail.setText(selectedItem.getEmail());
            txtTel.setText(selectedItem.getTelphone());
            txtPass.setText(selectedItem.getPassword());
            imgPhoto.setImage(new Image(new ByteArrayInputStream(selectedItem.getPhoto())));
            imgPhoto.setFitHeight(190);
            imgPhoto.setFitWidth(210);
            imgPhoto.setPreserveRatio(true);
            imgPhoto.setSmooth(true);
//            file = new File(""+txtID.getText());
//            try {
//                BufferedImage bufferedImage = ImageIO.read(selectedItem.getPhoto());
//                ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
//                ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

    }

//    private void setPhoto(){
//        imgPhoto.setImage(new Image(imagePath));
//        imgPhoto.setFitHeight(190);
//        imgPhoto.setFitWidth(210);
//        imgPhoto.setPreserveRatio(true);
//        imgPhoto.setSmooth(true);
//    }

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
        try {
            userService = ProxyHandler.getInstance().getSuperService(ServiceFactory.ServiceTypes.USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setPermission();
        tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblUser.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("position"));
        tblUser.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("department"));
        tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("permissionLevel"));
        getAllUsers();

    }
    private void getAllUsers(){
        List<UserDTO> allUsers = null;
        try {
            allUsers = userService.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblUser.setItems(FXCollections.observableArrayList(allUsers));

    }
}
