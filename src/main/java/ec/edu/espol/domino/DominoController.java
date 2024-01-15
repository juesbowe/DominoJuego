/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.domino;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.Ficha;
import modelo.Juego;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author jose-
 */
public class DominoController implements Initializable {
    
    
    Juego juego = new Juego();

    @FXML
    private ImageView Start;
    @FXML
    private AnchorPane Tablero;
    @FXML
    private AnchorPane mod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        
        // TODO  
    @FXML
    private void Start(MouseEvent event) {
        try {
            App.setRoot("Tablero");
        } catch (IOException ex) {
        }
       
//        juego.agregarJugador(" Jugador 0");
//        juego.agregarJugador("Maquina");
//        NomJu.setText("Jugador 1");
//        maq.setText("Maquina");
//        mod.getChildren().addAll(NomJu,maq);
//        for (Jugador jugador : juego.getJugadores()){
//            if(jugador.getNombre().equalsIgnoreCase("Maquina")){
//                ArrayList<Ficha> mano= jugador.getMano();
//                System.out.println(mano);
//                for(Ficha ficha: mano){
//                    System.out.println("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
//                    ImageView imv= new ImageView("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
//                    imv.setFitWidth(90);
//                    imv.setFitHeight(120);
//                    ManoMaq.getChildren().addAll(imv);
//                    ManoMaq.setSpacing(20);
//                    
//                }
//            }else{
//                ArrayList<Ficha> mano= jugador.getMano();
//                System.out.println(mano);
//                for(Ficha ficha: mano){
//                    System.out.println("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
//                    ImageView imv= new ImageView("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
//                    imv.setFitWidth(90);
//                    imv.setFitHeight(120);
//                    ManoJug.getChildren().addAll(imv);
//                    ManoJug.setSpacing(20);
//                    
//                }
//            
//            }
//           
//        }
//        mod.getChildren().addAll(ManoJug, ManoMaq);
//    }
    }
}
                
        
//            ImageView imv1 = new ImageView("fichas/"+"Ficha"+"1.1"+".png");
//            ImageView imv2 = new ImageView("fichas/"+"Ficha"+"1.2"+".png");
//            ImageView imv3 = new ImageView("fichas/"+"Ficha"+"1.3"+".png");
//            ManoMaq.getChildren().addAll(imv1);
//            imv1.setFitWidth(90);
//            imv1.setFitHeight(120);
//            ManoTab.getChildren().addAll(imv2);
//            imv2.setFitWidth(90);
//            imv2.setFitHeight(120);
//            ManoJug.getChildren().addAll(imv3);
//            imv3.setFitWidth(90);
//            imv3.setFitHeight(120);
//            mod.getChildren().addAll(ManoMaq);
//            mod.getChildren().addAll(ManoTab);
//            mod.getChildren().addAll(ManoJug);
 
//        Juego juego = new Juego();
//        
//        juego.agregarJugador(" Jugador 0");
//        juego.agregarJugador("Maquina");
//        
//        boolean jugando = true;
//        while(jugando == true){
//            ArrayList<Jugador> jugadoresEliminados = new ArrayList<>();
//            
//            for (Jugador jugador : juego.getJugadores()) {
//                
//                System.out.print(jugador.getNombre() + ": Mano -> ");jugador.imprimirMano();
//                System.out.print("Línea de Juego -> ");juego.mostrarLinea();
//                
//                boolean validar = false;
//                
//                if (jugador.getNombre().equalsIgnoreCase("Maquina")){
//                    validar = juego.jugarMaquina(jugador);  
//                    if(validar==true){
//                        System.out.println("Movimiento valido.");
//                    }
//                }
//                else{
//                    boolean validarMovimientos = juego.validarMovimientos(jugador);
//                    if(validarMovimientos == true){
//                        while(validar==false){
//                            System.out.print("Índice de ficha para jugar (0 es el primero): ");
//                            int pos =  ();
//                            while (pos < 0 || pos >= jugador.getMano().size()){
//                                System.out.println("Índice no válido. Intenta de nuevo.");
//                                System.out.print("Índice de ficha para jugar (0 es el primero): ");
//                                pos = scanner.nextInt();
//                            }
//                            Ficha ficha = jugador.getFicha(pos);
//                            validar = juego.agregarFichaLinea(ficha, jugador);
//                            if (validar == true){
//                                System.out.println("Movimiento valido."); 
//                            }else if(validar == false){
//                                System.out.println("Ficha tenía "+ ficha +" No puedo jugar esa ficha, inténtalo de nuevo");
//                            }
//                        }
//                    }
//                }
//                
//                if (validar == true){
//                    System.out.print("Nueva Línea de Juego -> ");juego.mostrarLinea();System.out.println("");
//                } else if(validar == false && jugador.getMano().isEmpty()) {
//                    jugando = false;
//                    System.out.println("EL JUGADOR: "+jugador.getNombre()+" HA GANADO!!");
//                } else if(validar == false){
//                    jugadoresEliminados.add(jugador);
//                    System.out.println("El JUGADOR: "+jugador.getNombre()+" NO TIENE FICHAS JUGABLES, POR LO TANTO HA SIDO ELIMINADO");
//                    System.out.println("");
//                }
//                if (juego.getJugadores().size()-jugadoresEliminados.size() == 1){
//                    break;
//                }
//
//            }
//            for(Jugador jugador : jugadoresEliminados ){
//                juego.getJugadores().remove(jugador);
//            }
//            if(juego.getJugadores().size()==1){
//                System.out.println("EL GANADOR ES EL JUGADOR: "+juego.getJugadores().get(0).getNombre());
//                jugando =false;
//            } 
//     
//    }
//    }
   
   


