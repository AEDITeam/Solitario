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
    
    public Mesa mesa;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mesa = new Mesa();
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
    
   
    
    
    
    
    public void descartar(int i, int j, int k){
          
        mesa.moverCartaInteriorExterior(i, j, k);
        
    }
    
    
    public void moverAOtroMonton(int i, int j, int k, int l){
        
        mesa.moverCartaInteriorInterior(i, j, k, l);
        
    }   
    
    /* Aquí escribimos las funciones con las que trabajaremos que no correspondan a mesa
    estas funciones pueden ser de distintos tipos y nos ayudarán a realizar estos movimientos, 
    con ellas recorreremos el array de cartas (bucles for) y observaremos cuales son volteables
    culaes son descartables y cuales están libres.
    */ 
    
    
    
}
