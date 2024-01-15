/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jose-
 */
public class Utilitaria {
    public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> mano = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<5;i++){
            int lado1 = random.nextInt(6)+1;
            int lado2 = random.nextInt(6)+1;
            Ficha ficha = new Ficha(lado1,lado2);
            mano.add(ficha);
        }
        Ficha fichaComodin = new FichaComodin();
        mano.add(fichaComodin);
        return mano;
    }
    
}
