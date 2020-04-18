/*
 * Representa al único jugador de la partida, identificado por el nombre 
 * Funcionalidad: le da la vuelta a una carta que está boca abajo, escoge una carta para moverla o al montón de descarte
 *                o la mueve encima de otra carta del interior
 */
package solitario.Core;
import solitario.Core.Mesa;
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
    
   
    
    
    
    void descartar(int i, int j, int k){
        
                
    if(esDescartable(i ,j ,k) == 1){
        
        
        moverCartaInteriorExterior(i, j);
        
        
    }
    else{
        System.out.println("No se puede hacer este movimiento");
    }
    
    
    
    
    }
    
    
    void moverAOtroMonton(){

          colocarCartaMontonInterior(quitarCarta(i, j), k, l);    

}    
    }   
        
    

