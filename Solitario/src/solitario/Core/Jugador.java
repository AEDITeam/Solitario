/*
 * Representa al único jugador de la partida, identificado por el nombre 
 * Funcionalidad: le da la vuelta a una carta que está boca abajo, escoge una carta para moverla o al montón de descarte
 *                o la mueve encima de otra carta del interior
 */
package solitario.Core;

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
    
       
    
    
    public boolean descartar(int i, int j, int k){
        
                
    if(esDescartable(i ,j ,k) == 1){
        
        
        moverCartaInteriorExterior(i, j);
        
        
        
    
    
    // Invocamos función de mover a la pila de descartes
    
    
    
    
    }
    else{
        print("No se puede hacer este movimiento");
    }
    
    
    return darVuelta;
    
    }
    
    
    public boolean moverAOtroMonton(){
    
    
    if (cartaLibre == 1){


        // Invocamos función de mover la carta a otro que se pueda mover
    

}    
    }   
    
    /* Aquí escribimos las funciones con las que trabajaremos que no correspondan a mesa
    estas funciones pueden ser de distintos tipos y nos ayudarán a realizar estos movimientos, 
    con ellas recorreremos el array de cartas (bucles for) y observaremos cuales son volteables
    culaes son descartables y cuales están libres.
    */ 
    
    
    
}
