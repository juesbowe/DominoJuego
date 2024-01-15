/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.domino;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author jose-
 */
public class ComodinDobleController implements Initializable {
    private TableroController tableroController;
    ArrayList<String> fichas= new ArrayList<>();
    @FXML
    private HBox comdo1;
    public void setTableroController(TableroController tableroController) {
            this.tableroController = tableroController;
    }
    


    @FXML
    private HBox comdo;
    private Stage stage;
    @FXML
    private BorderPane mod20;
    private double xOffset = 0;
    private double yOffset = 0;
    /**
     * Initializes the controller class.
     */
    public void setStage(Stage stage) {
            this.stage = stage;
    }


        @Override
    public void initialize(URL url, ResourceBundle rb) {


        mod20.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            mod20.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });
            fichas.add("1.1");fichas.add("2.2");fichas.add("3.3");fichas.add("4.4");fichas.add("5.5");fichas.add("6.6");
            for(String ad: fichas){
    //            String[] str = ad.split("\\.");
                if(ad.equals("1.1") ||ad.equals("2.2") ||ad.equals("3.3") ){
                    ImageView imv = new ImageView("fichasag/" + "Ficha" + ad + ".png");
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
                    imv.setFitWidth(95);
                    imv.setFitHeight(85);
                    comdo.getChildren().addAll(imv);
                    comdo.setSpacing(10);
                }else if(ad.equals("4.4") ||ad.equals("5.5") ||ad.equals("6.6")){
                    ImageView imv = new ImageView("fichasag/" + "Ficha" + ad + ".png");
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
                    imv.setFitWidth(95);
                    imv.setFitHeight(85);
                    comdo1.getChildren().addAll(imv);
                    comdo1.setSpacing(10);
                }
            


            // Agregar el evento OnMouseClicked
              
    }}
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
