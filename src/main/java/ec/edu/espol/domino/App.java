package ec.edu.espol.domino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Ficha;
import modelo.Juego;
import modelo.Jugador;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Domino"), 900, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
//        Juego juego = new Juego();
//        Scanner scanner = new Scanner(System.in);
//        
//        juego.agregarJugador(" Jugador 0");
//        juego.agregarJugador("Maquina");
// 
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
//                            int pos = scanner.nextInt();
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
//        }
//    }

    
