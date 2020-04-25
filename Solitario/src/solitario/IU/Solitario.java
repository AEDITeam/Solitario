/*
 * Representa el juego del solitario, con sus reglas. 
 * Se recomienda una implementación modular.
 */
package solitario.IU;

//import java.util.Scanner;

import java.util.Scanner;
import solitario.Core.Jugador;
import solitario.Core.Mesa;



/**
 *
 * @author AEDI
 */
public class Solitario {
        public static void inicioPartida(){
        System.out.println( "\nBienvenido al juego solitario" );
        String nombre = pideCadena("Dame tu nombre: ");
        Jugador jugador = new Jugador(nombre);
        callBuclePrincipal();
    }
     
  public static void callBuclePrincipal(){
        do{
            
            int op = 1;
            
            Mesa mesa = new Mesa();

        do {
            System.out.println( "\nEstas juagando al increible juego solitario" );
            

            op = menu();

            switch( op ) {

                case 1:
                    callBucleMovimiento();
                    break;
                case 2:
                    //mesa.movimientosPosibles(  );
                    break;
                case 3:
                    System.out.println( "Fin." );
                    op = 0;
                    break;
                case 42:
                    callEasterEgg();
                    break;
                default:
                    System.out.println( "No es correcta esa opción ( " 
                                        + op + " )" );
            }
        } while( op != 0 );
            
        }while(seguirJugando());
    }  
    
  public static void callEasterEgg(){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("\nGracias por jugar al Solitario");
        System.out.println("\nDesarrollado por:");
        System.out.println("\nJuanma Peteiro || Andres Garcia || Cedric Piñeiro || Daniel Rodriguez || Victor Rodriguez.");
        System.out.println("---------------------------------------------------------------------------------------------");
    }
  
   public static void callBucleMovimiento(){
        int op = 1;
        do {
            System.out.println( "\nEscoge el movimiento que deseas hacer" );
            

            op = moverCarta();

            switch( op ) {

                case 1:
                    //moverCartaInteriorInterior(i,j,k,l);
                    op = 0;
                    break;
                case 2:
                    //moverCartaInteriorExterior(i, j, k);
                    op = 0;
                    break;
                default:
                    System.out.println( "No es correcta esa opción ( " 
                                        + op + " )" );
            }
        } while( op != 0 );
        
    }
   
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
   
    public static int menu()
    {
        int toret;

        do {
            System.out.println(
                              "\n1. Mover carta\n"
                            + "2. Mostrar pista\n"
                            + "3. Finalizar partida\n");
            toret = pideNumero( "Selecciona: " );
        } while( toret < 1
              || toret > 3 );

        System.out.println();
        return toret;
    }
    
    public static int moverCarta(){
        //Condiciones para mover carta
        //Elegir funcion correspondiente en funcion de tipo de movimiento
        
        int toret2;
        
        do{
        System.out.println(
                           "\n1. Mover una carta de una pila de la mesa a otra\n"
                           + "2. Mover una carta de una pila del interior a la pila de descartes\n");
        toret2 = pideNumero( "Selecciona: ");
        
        }while (toret2 < 1 || toret2 > 2);
        System.out.println();
        
        return toret2;
        
    }
}
