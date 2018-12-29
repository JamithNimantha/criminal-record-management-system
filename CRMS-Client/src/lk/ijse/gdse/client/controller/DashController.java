package lk.ijse.gdse.client.controller;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class DashController implements Initializable {

    @FXML
    private ImageView imgLogo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RotateTransition rt = new RotateTransition(Duration.millis(3000), imgLogo);
        rt.setByAngle(360);
        // imgLogo.setTranslateZ(imgLogo.getBoundsInLocal().getWidth() / 2.0);
        imgLogo.setRotationAxis(Rotate.Y_AXIS);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();
    }
}
