/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.domino;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Ficha;
import modelo.FichaComodin;
import modelo.Juego;
import modelo.Jugador;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author jose-
 */
public class TableroController implements Initializable {
    private ComodinController comodinController;
    private ComodinDobleController comodinDobleController;

    String file="ComodinDoble.fxml";
    private boolean comodinVentanaAbierta = false;
    public void bloquearControles(boolean bloquear) {
    // Deshabilitar controles en TableroController
    mod1.setDisable(bloquear);
    // Otros controles que desees deshabilitar
    }
    public void comodinVentanaCerrada() {
        comodinVentanaAbierta = false;
    }
    public void setInteraccionTablero(boolean habilitar) {
        mode.setDisable(!habilitar);
        // Otros nodos que deseas deshabilitar/habilitar
    }
    Juego juego = new Juego();
 
    @FXML
    private Pane mod1;
    @FXML
    private Label maq;
    @FXML
    private Label NomJu;
    @FXML
    private ImageView Fondo;
    @FXML
    private AnchorPane mode;
  
    @FXML
    private HBox ManoJug21;
    @FXML
    private HBox ManoMaq21;
    @FXML
    private HBox ManoTab;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mod1.getChildren().clear();
        juego.agregarJugador(" Jugador 0");
        juego.agregarJugador("Maquina");
        NomJu.setText("Jugador 1");//cambia el nombre al label
        maq.setText("Maquina");
        mod1.getChildren().addAll(Fondo,NomJu,maq,mode);//lo agraga a la pantalla
        
        for(Jugador jugador: juego.getJugadores()){
            if(jugador.getNombre().equalsIgnoreCase("Maquina")){
                ArrayList<Ficha> mano= jugador.getMano();
                System.out.println(mano);
                for (Ficha ficha : mano){
                    ImageView imv= new ImageView("fichasag/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
                    imv.setId(ficha.getLado1()+"."+ficha.getLado2());
                    imv.setFitWidth(100);
                    imv.setFitHeight(80);
                    ManoMaq21.getChildren().addAll(imv);
                    ManoMaq21.setSpacing(20);
                    //event(ManoMaq21,imv,ManoTab,ficha, mano,jugador);
                }
            }else{
                ArrayList<Ficha> mano= jugador.getMano();
                System.out.println(mano);
                for (Ficha ficha : mano){
                    ImageView imv= new ImageView("fichasag/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
                    imv.setId(ficha.getLado1()+"."+ficha.getLado2());
                    System.out.println(imv.getId());
                    imv.setFitWidth(100);
                    imv.setFitHeight(80);
                    ManoJug21.getChildren().addAll(imv);
                    ManoJug21.setSpacing(20);
            
                    event(ManoJug21,imv,ManoTab,ficha,mano,jugador);
                    
            }
            
        }
        mode.getChildren().clear();  
        mode.getChildren().addAll(ManoMaq21,ManoJug21,ManoTab);
        }
    }
    
    public void event(HBox hb, ImageView imv,HBox hbtab,Ficha ficha, ArrayList<Ficha> mano,Jugador jugador){
        imv.setCursor(Cursor.HAND);
        if(ficha instanceof FichaComodin){
            System.out.println(juego.getLineaJuego().isEmpty());
            if(juego.getLineaJuego().isEmpty()== true){
                imv.setOnMouseClicked(event -> {
                if (!comodinVentanaAbierta) {
                    abrirVentanaComodin(imv,jugador,ficha,file);
                    comodinVentanaAbierta = true;
                }
                });
        }else if(juego.getLineaJuego().isEmpty()== false){
                imv.setOnMouseClicked(event -> {
                if (!comodinVentanaAbierta) {
                   abrirVentanaComodin(imv,jugador,ficha,file);
                   comodinVentanaAbierta = true;  
            }
        });}
        }
        else{
        imv.setOnMouseClicked(event -> {
            boolean posibleMaquina = false;
            boolean validar = juego.agregarFichaLinea(ficha, jugador);
            if(validar==true){
                ImageView imvagg= new ImageView("fichasag/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
                imvagg.setFitWidth(50);
                imvagg.setFitHeight(45);
                ArrayList<Ficha> lineaJuego = juego.getLineaJuego();
                if(lineaJuego.isEmpty()){
                    file="Comodin.fxml";
                    hbtab.getChildren().addAll(imvagg);
                    hb.getChildren().remove(imv);
                    if(!(jugador.getMano()==null))
                    posibleMaquina = juego.validarMovimientos(juego.getJugadores().get(1));
                    turnoMaquina(hbtab);
                }
                else{
                    if(lineaJuego.get(0)==ficha){
                        file="Comodin.fxml";
                        hbtab.getChildren().add(0, imvagg);
                        hb.getChildren().remove(imv);
                        if(!(jugador.getMano()==null))
                        posibleMaquina = juego.validarMovimientos(juego.getJugadores().get(1));
                        turnoMaquina(hbtab);
                    }
                    else if(lineaJuego.get(lineaJuego.size()-1)==ficha){
                        file="Comodin.fxml";
                        hbtab.getChildren().addAll(imvagg);
                        hb.getChildren().remove(imv);
                        if(!(jugador.getMano()==null))
                        posibleMaquina = juego.validarMovimientos(juego.getJugadores().get(1));
                        turnoMaquina(hbtab);
                    }
                }
            }
            
                Finalizar(jugador,posibleMaquina);
        });
        }
    }
    private void abrirVentanaComodin(ImageView imv,Jugador jugador, Ficha ficha,String nombre) {
        try {
            if(nombre.equals("Comodin.fxml")){
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource(nombre));
                Parent root = loader.load();


                // Configurar el nuevo Controller si es necesario
                ComodinController comodinController = loader.getController();
                comodinController.setStage(stage);
                comodinController.setTableroController(this);
                bloquearControles(true);// Pasar la referencia del TableroController
                // ...

                // Establecer la nueva escena en el nuevo Stage
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);

                // Manejar el evento onClose del Stage para restablecer el estado
                stage.setOnCloseRequest(windowEvent -> comodinVentanaAbierta = false);

                // Mostrar el nuevo Stage
                stage.setResizable(false);
                System.out.println(imv.getId());
                ManoJug21.getChildren().remove(imv);
                juego.mostrarLinea();
                jugador.removerFicha(ficha);
                stage.showAndWait();
            }else if (nombre.equals("ComodinDoble.fxml")){
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource(nombre));
                Parent root = loader.load();

                    // Configurar el nuevo Controller si es necesario
                ComodinDobleController comodindobleController = loader.getController();
                comodindobleController.setStage(stage);
                comodindobleController.setTableroController(this);
                bloquearControles(true);// Pasar la referencia del TableroController
                // ...

                // Establecer la nueva escena en el nuevo Stage
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);

                // Manejar el evento onClose del Stage para restablecer el estado
                stage.setOnCloseRequest(windowEvent -> comodinVentanaAbierta = false);

                // Mostrar el nuevo Stage
                stage.setResizable(false);
                System.out.println(imv.getId());
                ManoJug21.getChildren().remove(imv);
                juego.mostrarLinea();
                jugador.removerFicha(ficha);
                stage.showAndWait();
                
            }

        }catch (IOException ex) {
            ex.printStackTrace();  
        }
    }
    public void imprimirImagenEnManoTab(String rutaImagen) {
        try {
            boolean posibleMaquina = false;
            String[] str= rutaImagen.split("\\.");
            // Crear una nueva ImageView con la imagen especificada
            if(juego.getLineaJuego().isEmpty()){
                ImageView nuevaImagen = new ImageView("fichasag/" + "Ficha" + rutaImagen + ".png");
                nuevaImagen.setFitWidth(50); // Ajusta el ancho según sea necesario
                nuevaImagen.setFitHeight(45); // Ajusta la altura según sea necesario
                ManoTab.getChildren().add(nuevaImagen);
                int lado1= Integer.parseInt(str[0]);
                int lado2= Integer.parseInt(str[1]);
                Ficha ficha= new Ficha(lado1,lado2);
                juego.getLineaJuego().add(ficha);
                turnoMaquina(ManoTab);
            }else{
            if( rutaImagen.startsWith("-1")){
                ImageView nuevaImagen = new ImageView("FichasComodin/" + "Ficha" + rutaImagen + ".png");
                nuevaImagen.setFitWidth(50); // Ajusta el ancho según sea necesario
                nuevaImagen.setFitHeight(45); // Ajusta la altura según sea necesario
                ManoTab.getChildren().add(nuevaImagen);
                int lado1 = Integer.parseInt(str[1]);
                Ficha ficha= new Ficha(-1,lado1);
                System.out.println(ficha);
                juego.getLineaJuego().add(ficha);
                posibleMaquina = juego.validarMovimientos(juego.getJugadores().get(1));
                turnoMaquina(ManoTab);
                juego.mostrarLinea();
                Finalizar(juego.getJugadores().get(0),posibleMaquina);
            }else if( rutaImagen.endsWith("-1")){
                ImageView nuevaImagen = new ImageView("FichasComodin/" + "Ficha" + rutaImagen + ".png");
                nuevaImagen.setFitWidth(50); // Ajusta el ancho según sea necesario
                nuevaImagen.setFitHeight(45); // Ajusta la altura según sea necesario
                ManoTab.getChildren().add(0,nuevaImagen);
                int lado1 = Integer.parseInt(str[0]);
                Ficha ficha= new Ficha(lado1,-1);
                System.out.println(ficha);
                juego.getLineaJuego().add(0,ficha);
                posibleMaquina = juego.validarMovimientos(juego.getJugadores().get(1));
                turnoMaquina(ManoTab);
                juego.mostrarLinea();
                Finalizar(juego.getJugadores().get(0),posibleMaquina);
            }
            }

            // Agregar la nueva ImageView a ManoTab
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void Finalizar(Jugador jugador,boolean posibleMaquina){
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(700));
        pauseTransition.setOnFinished(e -> {
            boolean posibleJugar = juego.validarMovimientos(jugador);
                if(jugador.getMano()==null){
                  if (comodinController != null) {
                    comodinController.cerrarVentana();
                  }
                  if (comodinDobleController != null) {
                   comodinDobleController.cerrarVentana();
                  }

                System.out.println("El "+jugador.getNombre()+" HA GANADO");
                Alerta(jugador.getNombre());
                }
                else if(posibleJugar==false && posibleMaquina==true){
                    if (comodinController != null) {
                    comodinController.cerrarVentana();
                    }
                    if (comodinDobleController != null) {
                   comodinDobleController.cerrarVentana();
                    }
                    System.out.println("EL "+jugador.getNombre()+" HA PERDIDO");
                    Alerta(juego.getJugadores().get(1).getNombre());
                }
                
            });
            pauseTransition.play();
        }
        
    private void turnoMaquina(HBox hbtab){
        Jugador maquina = juego.getJugadores().get(1);
        ArrayList<Ficha> manoMaquina = new ArrayList<>(maquina.getMano());
        boolean validarMaquina = juego.jugarMaquina(maquina);
        
        if(validarMaquina==true){
            PauseTransition pause = new PauseTransition(Duration.millis(500));
            pause.setOnFinished(event -> {
            for(Ficha fichas : maquina.getMano()){
                manoMaquina.remove(fichas);
            }
            Ficha fichaJugada = manoMaquina.get(0);
            int lado1=fichaJugada.getLado1();
            int lado2=fichaJugada.getLado2();
            ImageView imvagg = new ImageView();
            if(fichaJugada instanceof FichaComodin){
                imvagg = new ImageView("FichasComodin/" + "Ficha" + lado1 + "." + lado2 + ".png");
            }else{
                imvagg = new ImageView("fichasag/" + "Ficha" + lado1 + "." + lado2 + ".png");
            }
            imvagg.setFitWidth(50);
            imvagg.setFitHeight(45);
            ArrayList<Ficha> lineaJuego = juego.getLineaJuego();
            String idDelete = "";
            if(fichaJugada instanceof FichaComodin){
                idDelete = "-1.-1";
            }
            else {
                idDelete = lado1+"."+lado2;
            }
            if(lineaJuego.isEmpty()){
                    hbtab.getChildren().addAll(imvagg);
                    for(int i=0; i<ManoMaq21.getChildren().size();i++){
                        if(ManoMaq21.getChildren().get(i).getId().equals(idDelete)){
                           ManoMaq21.getChildren().remove(i);
                           break;
                        }
                    }
            }
            else{
                if(lineaJuego.get(0)==fichaJugada){
                    hbtab.getChildren().add(0, imvagg);
                    for(int i=0; i<ManoMaq21.getChildren().size();i++){
                        if(ManoMaq21.getChildren().get(i).getId().equals(idDelete)){
                           ManoMaq21.getChildren().remove(i);
                           break;
                        }
                    }
                }
                else if(lineaJuego.get(lineaJuego.size()-1)==fichaJugada){
                    hbtab.getChildren().addAll(imvagg);
                    for(int i=0; i<ManoMaq21.getChildren().size();i++){
                        if(ManoMaq21.getChildren().get(i).getId().equals(idDelete)){
                           ManoMaq21.getChildren().remove(i);
                           break;
                        }
                    }
                }
            }
            
        });
             pause.play();
        }
        else{
            System.out.println("La Maquina ha perdido");
            Alerta(juego.getJugadores().get(0).getNombre());
        }
    }
    
    
    private void Alerta(String ganador){
        
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("FIN DE LA PARTIDA");
         alert.setHeaderText("FIN DE LA PARTIDA");
         alert.setContentText("FELICIDADES, "+ganador+" HA GANADO");
//         alert.showAndWait();
         Platform.runLater(() -> {
         Optional<ButtonType> result = alert.showAndWait();
         
         if(result.get()==ButtonType.OK){
             try {
                 App.setRoot("Domino");
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
         }
         });
    }
}

  

