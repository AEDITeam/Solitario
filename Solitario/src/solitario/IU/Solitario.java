/*
 * Representa el juego del solitario, con sus reglas. 
 * Se recomienda una implementación modular.
 */
package solitario.IU;

import java.util.Scanner;

/**
 *
 * @author AEDI
 */
public class Solitario {
        
    public static void inicioPartida(){
        
        int sel;
        
        System.out.println("Escoge un movimiento"); //revisar
        
        Scanner selector = new Scanner(System.in);
        
        sel = selector.nextInt();
        
        switch(sel){
            
            case 1:                                //mover interior interior
                
                break;
            
            case 2:                                //mover interior exterior
                
                break;
                
            case 3:                                //finalizar partida
                
                break;
        }
    } 
    
//    public boolean existeMovimiento(){
//    
//        if(Comprobar movimiento == 0){
//    
//            System.out.println("No ha movimientos  a realizar, el juego ha finalizado");
//            
//        }
//    
//        else{
//            
//            // Invocamos función que nos permita continuar con el movimiento
//            
//        }
//        
//    return existeMovimiento;
//    }
    
    public static boolean seguirJugando() {
        
        Scanner sc = new Scanner(System.in);
        
        char respuesta;
        
        do {
            
            System.out.print("¿Quieres seguir jugando? (S/N): ");
            respuesta = sc.nextLine().toUpperCase().charAt(0);
            
        } while (respuesta != 'S' && respuesta != 'N');
        
        if (respuesta == 'S') {
            return true;
        } 
        
        else{
            return false;
        }
    }

}
