/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Stack;

/**
 *
 * @author AEDI
 */
public class Mesa {

    private Stack<Carta>[][] montonInterior;
    private Stack<Carta>[] montonExterior;

    public Mesa() {
        //crea el monton interior, y exterior
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
   
        //llama a la funcion colocar cartas
        this.colocarCartas(new Baraja());
  
    }

    public void colocarCartas(Baraja b) {
        
        //llama a la funcion de baraja que desordena la baraja
        b.reordenar();

        //coloca una carta en cada hueco de la matriz
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                montonInterior[i][j].push(b.cogerCarta());
            }
        }//fin for

        //coloca una carta en la primera diagonal
        int x = 0;
        while (x < 4) {

            montonInterior[x][x].push(b.cogerCarta());
            x++;

        }
        //coloca una carta en la segunda diagonal
        int z = 1;
        while (z < 4) {

            montonInterior[z][4 - z].push(b.cogerCarta());
            z++;

        }
        
        //coloca las cartas restantes
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                montonInterior[i][j].push(b.cogerCarta());
            }
        }//fin for
      
            //crea una carta nueva, con valor 0 en las pilas exteriores, para que se puedan realizar las operaciones de mover cartas ahi
            montonExterior[0].push(new Carta(0,Palos.BASTOS)); 
            montonExterior[1].push(new Carta(0,Palos.COPAS)); 
            montonExterior[2].push(new Carta(0,Palos.ESPADAS)); 
            montonExterior[3].push(new Carta(0,Palos.OROS)); 
           
            

    }//fin funcion

    public Stack<Carta>[][] getMontonInterior() {
        return montonInterior;
    }

    public Stack<Carta>[] getMontonExterior() {
        return montonExterior;
    }
    
    
    /**
     * 
     * @param cartaE    carta especifica que se buscara y extraera de la matriz(monton interior)
     * @return 
     */
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

    /**
     * 
     * @param i cordenada X de la carta que se desea quitar
     * @param j cordenada Y de la carta que se desea quitar
     * @return carta quitada
     */
    public Carta quitarCarta(int i, int j) {

        Carta toret = null;

        toret = montonInterior[i][j].pop();

        return toret;
    }

    /**
     * 
     * @param carta carta que se desea colocar en el monton interior
     * @param i cordenada X de la carta que se desea quitar
     * @param j cordenada y de la carta que se desea quitar
     */
    public void colocarCartaMontonInterior(Carta carta, int i, int j) {

        montonInterior[i][j].push(carta);
    }
    
    /**
     * 
     * @param carta carta que se desea colocar en el monton interior
     * @param i cordenada X de la carta que se desea quitar
     */
    public void colocarCartaMontonExterior(Carta carta, int i) {

        montonExterior[i].push(carta);
    }
    
   /**
    * 
    * @param i cordenada X de la carta que se desea quitar
    * @param j cordenada Y de la carta que se desea quitar
    * @param k cordenada X a la cual se desea mover la carta del monton exterior
    */
    public void moverCartaInteriorExterior(int i, int j,int k){
    
        colocarCartaMontonExterior(quitarCarta(i, j), k);

    }
    /**
     * 
     * @param i cordenada X de la carta que se desea mover
     * @param j cordenada Y de la carta que se desea mover
     * @param k cordenada X a donde se va a mover la carta quitada
     * @param l cordenada Y a donde se va a mover la carta quitada
     */
    public void moverCartaInteriorInterior(int i, int j,int k,int l){
    
        colocarCartaMontonInterior(quitarCarta(i, j), k, l);

    }
    
    //verifica si existe algun movimiento posible
    public boolean existeMovimiento() {

        //inicializacion de variables
        boolean hayMovimiento = false;
        int h = 0;
        int i = 0;
        int x = 0;
        int y = 0;

        //verificacion de si se puede descartar alguna carta-------------------------------------------------------------------------------------------------
        while (h < 4 && hayMovimiento == false) {
            i = 0;
            x = 0;
            while (i < 4 && hayMovimiento == false) {
                 x = 0;
                while (x < 4 && hayMovimiento == false) {

                    //guardo el numero y palo de la carta de origen y destino, para hacer la verificacion mas legible
                    int numeroCartaExtterior = montonExterior[h].peek().getNumero();
                    int numeroCartaInterior = montonInterior[x][y].peek().getNumero();
                    Palos paloCartaExterior = montonExterior[h].peek().getPalo();
                    Palos paloCartaInterior = montonInterior[x][y].peek().getPalo();

                    if (paloCartaExterior == paloCartaInterior && numeroCartaExtterior == ((numeroCartaInterior) - 1)) {
                        hayMovimiento = true;
                    }
                    x++;
                }
                i++;
            }
            h++;
        }
        
        //FIN verificacion de si se puede descartar alguna carta-------------------------------------------------------------------------------------------------
        
        //reinicio de variables
        x = 0;
        i = 0;
        h = 0;

        while (h < 4 && hayMovimiento == false) {
            x = 0;
            i = 0;
            y = 0;
            while (i < 4 && hayMovimiento == false) {
                x = 0;
                y = 0;
                while (x < 4 && hayMovimiento == false) {
                     y = 0;
                    while (y < 4 && hayMovimiento == false) {

                        //guardo el numero y palo de la carta de origen y destino, para hacer la verificacion mas legible
                        int numeroCarta1 = montonInterior[h][i].peek().getNumero();
                        int numeroCarta2 = montonInterior[x][y].peek().getNumero();
                        Palos paloCarta1 = montonInterior[h][i].peek().getPalo();
                        Palos paloCarta2 = montonInterior[x][y].peek().getPalo();

                        if (paloCarta1 == paloCarta2 && numeroCarta2 == ((numeroCarta1) - 1)) {
                            hayMovimiento = true;
                        }
                        y++;
                    }
                    x++;
                }
                i++;
            }
            h++;
        }

        return hayMovimiento;
    }
    

    @Override
    public String toString() {
        
        System.out.println("");
        
        //Escribo el monton de descartes
        System.out.println("[" + montonExterior[0].peek()+ "]" + "[" + montonExterior[1].peek()+ "]"+ "[" + montonExterior[2].peek()+ "]"+ "[" + montonExterior[3].peek()+ "]");
        System.out.println("\n");
       
        //escribo el monton interior
        for (int i = 0; i < 4; i++) {
            

                System.out.println("[" + montonInterior[i][0].peek()+ "] " + "[" +  montonInterior[i][1].peek()+ "] "   + "[" + montonInterior[i][2].peek()+ "] " + "[" + montonInterior[i][3].peek()+ "] ");
                System.out.println("\n");
            
            
        }
        
        
        return "";
    }
    
    
    
    
    
    
    

}//fin clase-----------------------------------------
