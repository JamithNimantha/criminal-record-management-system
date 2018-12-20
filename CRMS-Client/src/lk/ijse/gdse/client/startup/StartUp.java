package lk.ijse.gdse.client.startup;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.gdse.client.common.PreLoader;

public class StartUp extends Application {

    private static final int countLimit =30000;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/client/view/Login.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
       // launch(args);
        LauncherImpl.launchApplication(StartUp.class, PreLoader.class,args);
    }

    @Override
    public void init() throws Exception {
        for (int i=0;i<countLimit;i++){
            double progress=(100*i)/countLimit;
            LauncherImpl.notifyPreloader(this,new Preloader.ProgressNotification(progress));
        }
    }
}
