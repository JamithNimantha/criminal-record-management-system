package lk.ijse.gdse.client.common;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.gdse.client.controller.LoadingController;

public class PreLoader extends Preloader{
    private Stage preLoaderStage;
    private Scene scene;

    public PreLoader() {
    }

    @Override
    public void init() throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/client/view/Loading.fxml"));
        scene=new Scene(parent);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.preLoaderStage=primaryStage;
        preLoaderStage.initStyle(StageStyle.UNDECORATED);
        preLoaderStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/lk/ijse/gdse/client/assests/icons8-password-filled-100.png"));
        primaryStage.show();
    }

    public void handleApplicationNotification(Preloader.PreloaderNotification notification){
        if (notification instanceof ProgressNotification){
            LoadingController.bar.setProgress(((ProgressNotification) notification).getProgress()/100);
        }

    }
    public void handleStateChangeNotification(Preloader.StateChangeNotification notification){
        StateChangeNotification.Type type=notification.getType();
        switch (type){
            case BEFORE_START:
                preLoaderStage.hide();
                break;
        }

    }


}
