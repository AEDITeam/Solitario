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
      
            
            montonExterior[0].push(new Carta(0,Palos.BASTOS)); 
            montonExterior[1].push(new Carta(0,Palos.COPAS)); 
            montonExterior[2].push(new Carta(0,Palos.ESPADAS)); 
            montonExterior[3].push(new Carta(0,Palos.OROS)); 
           
            

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
