/*
* Representa la mesa de juego, donde estarán todas las cartas.
* Tendrá dos partes diferenciadas:
* - la parte interior, donde inicialmente estarán colocadas las cartas correctamente para jugar al solitario
* - los montones exteriores, donde estarán colocadas las cartas por palo ordenadas de menor a mayor
* Estructura: Se utilizarán TADs adecuados para su respresentación. En concreto:
* - Una matriz de Pilas para representar la parte o montón interior 
* - Un array de Pilas para representar los montones exteriores.
* Funcionalidad: colocar las cartas para iniciar el juego, quitar una carta de la parte interior, colocar una carta en el interior,
* colocar una carta en el montón exterior correspondiente, visualizar cartas en la mesa, etc

La Pila es una estructura de datos que existe en Java y que se corresponde con la clase Stack. Por lo tanto debereis hacer uso de dicha
clase para representar la mesa de juego, y en particular de los métodos que se indican a continuación (de ser necesarios):

        public boolean empty();
        // Produce: Si la pila está vacía devuelve true, sino false.
        public Carta peek();
        // Produce: Devuelve la Carta del tope de la pila, sin eliminarla de ella.
        public Carta pop();
        // Produce: Elimina la Carta del tope de la pila y la devuelve.
        public void push(Carta item);
        // Produce: Introduce la Carta en el tope de la pila.
 */
package solitario.Core;

import java.util.Stack;

/**
 *
 * @author AEDI
 */
public class Mesa {

    private Stack<Carta>[][] montonInterior;
    private Stack<Carta>[] montonExterior;

    public Mesa() {
        this.montonInterior = new Stack[4][4];
        this.montonExterior = new Stack[4];

        //crear pilas en la matriz
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                montonInterior[i][j] = new Stack<>();
            }
        }//fin for

        //crear pilas en el array
        for (int j = 0; j < 4; j++) {
            montonExterior[j] = new Stack<>();
        }
        
         
        
        
        
        
        
        this.colocarCartas(new Baraja());
        this.toString();
        
        
        
        
    }

    public void colocarCartas(Baraja b) {
        
        b.reordenar();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                montonInterior[i][j].push(b.cogerCarta());
            }
        }//fin for

        int x = 0;
        while (x < 4) {

            montonInterior[x][x].push(b.cogerCarta());
            x++;

        }
        int z = 1;
        while (z < 4) {

            montonInterior[z][4 - z].push(b.cogerCarta());
            z++;

        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                montonInterior[i][j].push(b.cogerCarta());//Dar la vuelta
            }
        }//fin for
                

    }//fin funcion

    public Carta quitarCarta(Carta cartaE) {

        Carta toret = null;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (cartaE == montonInterior[i][j].peek()) {
                    toret = montonInterior[i][j].pop();
                }
            }
        }//fin for

        return toret;
    }

    public Carta quitarCarta(int i, int j) {

        Carta toret = null;

        toret = montonInterior[i][j].pop();

        return toret;
    }

    public void colocarCartaMontonInterior(Carta carta, int i, int j) {

        montonInterior[i][j].push(carta);
    }
    
    public void colocarCartaMontonExterior(Carta carta, int i) {

        montonExterior[i].push(carta);
    }
    
   
    public void moverCartaInteriorExterior(int i, int j,int k){
    
        colocarCartaMontonExterior(quitarCarta(i, j), k);

    }
    
    public void moverCartaInteriorInterior(int i, int j,int k,int l){
    
        colocarCartaMontonInterior(quitarCarta(i, j), k, l);

    }

    @Override
    public String toString() {
        
        System.out.println("");
        
        System.out.println("[" + montonExterior[0].peek()+ "]" + "[" + montonExterior[1].peek()+ "]"+ "[" + montonExterior[2].peek()+ "]"+ "[" + montonExterior[3].peek()+ "]");
        System.out.println("\n");
       
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                System.out.println("[" + montonInterior[i][0].peek()+ "] " + "[" +  montonInterior[i][1].peek()+ "] "   + "[" + montonInterior[i][2].peek()+ "] " + "[" + montonInterior[i][3].peek()+ "] ");
                System.out.println("\n");
            
            }
        }
        
        
        return "";
    }
    
    
    
    
    
    
    

}//fin clase-----------------------------------------
