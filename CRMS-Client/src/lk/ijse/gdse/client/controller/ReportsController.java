package lk.ijse.gdse.client.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.gdse.client.common.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportsController {

    @FXML
    private JFXButton btnRecord;

    @FXML
    private JFXButton btnCrime;

    @FXML
    private JFXButton btnDetails;

    @FXML
    void btnCrime(ActionEvent event) {
        try {
            jasper("/lk/ijse/gdse/client/Reports/Criminal Details.jasper");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnDetails(ActionEvent event) {
        try {
            jasper("/lk/ijse/gdse/client/Reports/Criminal_Records_Details.jasper");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnRecord(ActionEvent event) {
        try {
            jasper("/lk/ijse/gdse/client/Reports/Rcord_Details.jasper");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
    private void jasper(String path) throws SQLException, ClassNotFoundException, JRException {
        InputStream inputStream = getClass().getResourceAsStream(path);
        HashMap map = new HashMap();
        JasperPrint jasperPrint= JasperFillManager.fillReport(inputStream,map, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }

}
