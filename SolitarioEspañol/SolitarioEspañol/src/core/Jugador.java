/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author juanm
 */
public class Jugador {
    public String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + '}';
    }
    
    public static void descartar(Mesa mesa, int i, int j, int k){
          
        mesa.moverCartaInteriorExterior(i, j, k);
        
    }
    
    
    public static void moverAOtroMonton(Mesa mesa, int i, int j, int k, int l){
        
        mesa.moverCartaInteriorInterior(i, j, k, l);
        
    }   
}
