/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitarioespañol;
import core.Jugador;
import core.Mesa;
import java.util.Scanner;
import java.util.Stack;
import core.Carta;
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
        callBuclePrincipal();       
    }
    
    
    public static void callBuclePrincipal(){
        do{
            
            int op = 1;
            Mesa mesa = new Mesa();
            
        if(mesa.existeMovimiento() == true){   
            do {
            System.out.println( "\nEstas juagando al increible juego solitario" );
            
            mesa.toString();
            
            op = menu();

            switch( op ) {

                case 1:
                    if(mesa.existeMovimiento() == true){     
                        callBucleMovimiento(mesa);
                    }else{                           
                        System.out.println("No quedan movimientos disponibles");
                        op = 0;
                    }                                
                    break;
                case 2:
                    instrucciones();
                    break;
                case 3:
                    System.out.println( "Fin." );
                    op = 0;
                    break;
                case 4:
                    callEasterEgg();
                    break;
                default:
                    System.out.println( "No es correcta esa opción ( " 
                                        + op + " )" );
            }
        } while( op != 0 );
            
        }            
            
        }while(seguirJugando());
    }
    
    
    public static void callEasterEgg(){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("\nGracias por jugar al Solitario");
        System.out.println("\nDesarrollado por:");
        System.out.println("\nJuanma Peteiro || Andres Garcia || Cedric Piñeiro || Daniel Rodriguez || Victor Rodriguez.");
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    public static void instrucciones(){
        System.out.println("***************************************************************************************************************************************************");
        System.out.println("                                                                 SOLITARIO");
        System.out.println("***************************************************************************************************************************************************");
        System.out.printf("\nEl solitario es un juego de cartas para el que no necesitas a nadie más. Este solitario está pensado para esos momentos de aburrimiento \n"
                + "o de viajes eternos. Solo necesitas una baraja española y a ti mismo.\n");
        System.out.println("\n***************************************************************************************************************************************************");
        System.out.println("                                                             Objetivo del juego");
        System.out.println("***************************************************************************************************************************************************");
        System.out.printf("\nPara jugar al solitario son necesarias 40 cartas de la baraja española. La baraja está compuesta de 4 palos (oros, espadas, bastos y copas) "
                + "\ncada uno con siete cartas enumeradas del 1 al 7 y tres figuras (sota, caballo y rey) correspondientes a los números 10, 11 y 12 respectivamente. "
                + "\nEl objetivo del juego es comenzar con todas las cartas desordenadas y terminar con cuatro montones ordenados de menor a mayor, uno para cada palo "
                + "\nde la baraja.\n");
        System.out.println("\n***************************************************************************************************************************************************");
        System.out.println("                                                           Cómo jugar al solitario");
        System.out.println("***************************************************************************************************************************************************");
        System.out.printf("\nSe colocan 16 cartas boca abajo, formando 4 columnas y 4 filas. A continuación, se colocan 8 cartas boca abajo encima de aquellas que están "
                + "\nen las diagonales. Por último, se colocan boca arriba las 16 cartas restantes, encima de las que ya están colocadas (a esta zona se llamará zona-Interior). "
                + "\nEl objetivo es ir quitando las cartas de la zona-interior de menor a mayor colocándolas en cuatro montones exteriores, (uno para cada palo) que han de "
                + "\nempezar con la carta numerada con el 1.\n");
        System.out.println("\n***************************************************************************************************************************************************");
        System.out.println("                                                              Reglas del juego");
        System.out.println("***************************************************************************************************************************************************");
        System.out.printf("\n-> Se puede mover una carta de la zona-interior al montón exterior si la última carta almacenada en el montón exterior es del mismo palo "
                + "\ny una unidad más pequeña que la que se quiere colocar (fíjate que después del 7 viene el 10). Si debajo de ella existiese una carta boca abajo "
                + "\nse gira para hacerla visible." 
                + "\n-> Si el montón exterior está vacío, sólo se podrá colocar una carta que contenga un as." 
                + "\n-> En la zona-interior se puede mover una carta sobre otra, siempre que la carta que se va a ocultar sea del mismo palo y una unidad mayor que la que se mueve "
                + "\n(fíjate que encima del 10 se debe colocar un 7). Este movimiento tiene como objetivo hacer visible la carta que está debajo de la que se está"
                + "\n moviendo." 
                + "\n-> No se puede mover una carta a un hueco vacío en la zona-interior.\n");
        System.out.println("\n***************************************************************************************************************************************************");
        System.out.println("                                                             Final de una partida");
        System.out.println("***************************************************************************************************************************************************");
        System.out.printf("\nEl juego continúa siempre que exista un movimiento posible, es decir, un movimiento de una carta a algún montón exterior o un movimiento"
                + "\n dentro de la zona-interior. El juego puede finalizar con dos situaciones:\n" 
                + "\n-> Los montones exteriores contienen todas las cartas Los cuatro montones exteriores tienen 10 cartas del mismo palo ordenados de menor a mayor."
                + "\n Objetivo conseguido\n" 
                + "\n-> No hay más movimientos posibles y quedan cartas en la zona-interior Puede ocurrir que el solitario no finalice, quedan cartas en la zona-interior"
                + "\n y no es posible ningún movimiento. Objetivo no conseguido");
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////MENÚ DE MOVIMIENTOS/////////////////////////////////////////////////////////////////
    public static void callBucleMovimiento(Mesa mesa){
        int op = 1;
        do {
            System.out.println( "\nEscoge el movimiento que deseas hacer" );
            

            op = moverCarta();

            switch( op ) {

                case 1:
                    
                    moverInterior(mesa);
                    
                    op = 0;
                    break;
                case 2:
                    
                    moverExterior(mesa);
                    
                    op = 0;
                    break;
                default:
                    System.out.println( "No es correcta esa opción ( " 
                                        + op + " )" );
            }
        } while( op != 0 );
        
    }
    ////////////////////////////////////////////////////////FIN MENÚ DE MOVIMIENTOS/////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
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
                            + "2. Mostrar instrucciones\n"
                            + "3. Finalizar partida\n");
            toret = pideNumero( "Selecciona: " );
        } while( toret < 1
              || toret > 4);

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
    
    public static void moverInterior(Mesa mesa){
        int i, j ,k ,l;
                
        System.out.println("Escoge las coordenadas de una carta y de la pila interior de destino:\n");
                
        i = pideNumero("\nPrimera coordenada de la carta:");
        j = pideNumero("\nSegunda coordenada de la carta:");
        k = pideNumero("\nPrimera coordenada de la pila:");
        l = pideNumero("\nSegunda coordenada de la pila:");
                    
                    //Comprobación del movimiento entre pilas interiores
                    
        Stack <Carta> [][] montonInterior1 = mesa.getMontonInterior();
                    
        Carta carta1 = montonInterior1[i][j].peek();
        Carta carta2 = montonInterior1[k][l].peek();
                    
        if(carta1.getNumero() == carta2.getNumero()-1 && carta1.getPalo() == carta2.getPalo()){
                        
            Jugador.moverAOtroMonton(mesa, i, j, k, l);
                        
        }
        else{
            System.out.println("\nMovimiento no válido");
        }
    }
        
    public static void moverExterior(Mesa mesa){
        int x, y ,z;
             
        System.out.println("Escoge las coordenadas de una carta y la pila de descartes de destino:\n");
                     
        x = pideNumero("\nPrimera coordenada de la carta:");               
        y = pideNumero("\nSegunda coordenada de la carta:");                
        z = pideNumero("\nPila de destino:");
                    
                    //Comprobación del movimiento hacia las pilas de descartes
                    
        Stack <Carta> [][] montonInterior2 = mesa.getMontonInterior();
        Stack <Carta> [] montonExterior = mesa.getMontonExterior();
                    
        Carta carta3 = montonInterior2[x][y].peek();
        Carta carta4 = montonExterior[z].peek();
                    
        if(carta3.getNumero() == carta4.getNumero()+1 && carta3.getPalo() == carta4.getPalo()){
            Jugador.descartar(mesa, x, y, z);
        }
        else{
            System.out.println("\nMovimiento no válido");
        }
    }
    
}   