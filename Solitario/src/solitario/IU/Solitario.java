/*
 * Representa el juego del solitario, con sus reglas. 
 * Se recomienda una implementación modular.
 */
package solitario.IU;

//import java.util.Scanner;

/**
 *
 * @author AEDI
 */
public class Solitario {
        
    public static void inicioPartida(){
        
        int sel;
        
//        System.out.println("Escoge un movimiento"); 
//        
//        Scanner kb = new Scanner(System.in);
//        
        sel = pideNumero("Escoge un movimiento");                          //revisar
        
        switch(sel){
            
            case 1:                                //mover interior interior
                
                int i, j ,k ,l;
                
                
                System.out.println("Escoge las coordenadas de una carta y de la pila interior de destino:\n");
                

                i = pideNumero("\nPrimera coordenada de la carta:");
                
                j = pideNumero("\nSegunda coordenada de la carta:");
                
                k = pideNumero("\nPrimera coordenada de la pila:");
                
                l = pideNumero("\nSegunda coordenada de la pila:");
                
                
                moverAOtroMonton(i, j, k, l);

                
                break;
            
            case 2:                                //mover interior exterior
                
                
                int x, y ,z;
                
                
                System.out.println("Escoge las coordenadas de una carta y la pila de descartes de destino:\n");
                                

                x = pideNumero("\nPrimera coordenada de la carta:");               

                y = pideNumero("\nSegunda coordenada de la carta:");                

                z = pideNumero("\nPila de destino:");
                
                
                descartar(x, y, z);         
                
                
                break;
                
            case 3:                                //finalizar partida
                
                seguirJugando();
                
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
        
//        Scanner sc = new Scanner(System.in);
        
        char respuesta;
        
        do {
            
//            System.out.print("¿Quieres seguir jugando? (S/N): ");
//            respuesta = sc.nextLine().toUpperCase().charAt(0);
            
            respuesta = pideChar("¿Quieres seguir jugando? (S/N): ");
            
        } while (respuesta != 'S' || respuesta != 'N' || respuesta != 's' || respuesta != 'n');
        
        
        if (respuesta == 'S' || respuesta == 's') {
            return true;
        }  
        
        else{
            return false;
            
        }
    }
}
