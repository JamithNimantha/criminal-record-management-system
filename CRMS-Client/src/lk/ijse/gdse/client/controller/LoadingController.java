package lk.ijse.gdse.client.controller;

import com.jfoenix.controls.JFXProgressBar;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingController implements Initializable {

    @FXML
    private ImageView imgLogo;
   // public static double value;

    @FXML
    private JFXProgressBar progressBar;
    public static JFXProgressBar bar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logoStateChange();
        progressBar.setProgress(JFXProgressBar.INDETERMINATE_PROGRESS);
        bar=this.progressBar;

    }

    private void logoStateChange(){
        RotateTransition rt = new RotateTransition(Duration.millis(3000), imgLogo);
        rt.setByAngle(360);
       // imgLogo.setTranslateZ(imgLogo.getBoundsInLocal().getWidth() / 2.0);
        imgLogo.setRotationAxis(Rotate.Y_AXIS);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();
    }
}
