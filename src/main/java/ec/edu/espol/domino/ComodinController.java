/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.domino;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class ComodinController implements Initializable {
    private TableroController tableroController;
    ArrayList<String> fichas= new ArrayList<>();
    
    private Stage stage;  // Guardar una referencia al Stage actual
    @FXML
    private HBox com1;
    @FXML
    private BorderPane mod12;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private HBox com2;

    public void setTableroController(TableroController tableroController) {
        this.tableroController = tableroController;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        mod12.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        mod12.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        fichas.add("-1.1");fichas.add("-1.2");fichas.add("-1.3");fichas.add("-1.4");fichas.add("-1.5");fichas.add("-1.6");
        fichas.add("1.-1");fichas.add("2.-1");fichas.add("3.-1");fichas.add("4.-1");fichas.add("5.-1");fichas.add("6.-1");
        for(String ad: fichas){
//            String[] str = ad.split("\\.");
            
            ImageView imv = new ImageView("FichasComodin/" + "Ficha" + ad + ".png");
            imv.setId(ad);
            imv.setCursor(Cursor.HAND);
            imv.setOnMouseClicked(event -> {
                tableroController.imprimirImagenEnManoTab(ad);
                stage.close();
                if (tableroController != null) {
                    tableroController.comodinVentanaCerrada();
                    tableroController.bloquearControles(false);
                }

            });
            System.out.println(imv.getId());
            imv.setFitWidth(65);
            imv.setFitHeight(55);

        // Agregar el evento OnMouseClicked

        if (ad.startsWith("-1")) {
            com1.getChildren().addAll(imv);
            com1.setSpacing(10);
        }
        if (ad.endsWith("-1")) {
            com2.getChildren().addAll(imv);
            com2.setSpacing(10);
        }
        }
    }
    public void cerrarVentana() {
        if (stage != null) {
            stage.close();
            if (tableroController != null) {
                tableroController.comodinVentanaCerrada();
                tableroController.bloquearControles(false);
            }
        }
    }
    

}