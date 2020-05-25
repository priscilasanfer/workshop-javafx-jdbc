package gui;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAction");
    }

    public void onMenuItemDepartmentAction() {
        loadView("/gui/DepartmentList.fxml");
    }

    public void onMenuItemAboutAction() {
        loadView("/gui/About.fxml");
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {

    }

    public synchronized void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVBox.getChildren());

        } catch (IOException e) {
            Alerts.showAlert("IO EXception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }


}
