/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitarioespañol;
import core.Jugador;
import core.Mesa;
import java.util.Scanner;
import static solitarioespañol.ES.pideCadena;
import static solitarioespañol.ES.pideNumero;

/**
 *
 * @author juanm
 */
public class Juego {
    public static void inicioPartida(){
        System.out.println( "\nBienvenido al juego solitario" );
        String nombre = pideCadena("Dame tu nombre: ");
        Jugador jugador = new Jugador(nombre);
        
        
        do{
            
            int op = 1;
            Mesa mesa = new Mesa();

        do {
            System.out.println( "\nEstas juagando al increible juego solitario" );
            

            op = menu();

            switch( op ) {

                case 1:
                    moverCarta();
                    break;
                case 2:
                    mesa.movimientosPosibles(  );
                    break;
                case 3:
                    System.out.println( "Fin." );
                    op = 0;
                    break;
                default:
                    System.out.println( "No es correcta esa opción ( " 
                                        + op + " )" );
            }
        } while( op != 0 );
            
        }while(seguirJugando());
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
              && toret > 3 );

        System.out.println();
        return toret;
    }
    public static void moverCarta(){
        //Condiciones para mover carta
        //Elegir funcion correspondiente en funcion de tipo de movimiento
        /*
        if(movimientoPosible == True){
            ....
        }else{
            sout("Ese movimiento no es posible")
        }
        */
        
    }
        
}
