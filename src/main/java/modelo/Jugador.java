/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author jose-
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }
    

    public Ficha getFicha(int i) {
        if (i<=mano.size()){
            return mano.get(i);
        }
        else
            return null;
    }
    
    public void removerFicha(Ficha f){
        mano.remove(f);
    }
    
    public void imprimirMano(){
        
        for(int i=0; i<mano.size();i++){
            Ficha f = mano.get(i);
            if(i!=mano.size()-1){
                System.out.print(f.toString()+" - ");
            }
            else
                System.out.println(f.toString());
        }
    }
    
    
    
}
