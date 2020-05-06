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
        int z = 0;
        while (z < 3) {

            montonInterior[z][3 - z].push(b.cogerCarta());
            z++;

        }
        
        //coloca las cartas restantes
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                montonInterior[i][j].push(b.cogerCarta());
            }
        }//fin for

    }//fin funcion

    /**
     * 
     * @param i cordenada X de la carta que se desea quitar
     * @param j cordenada Y de la carta que se desea quitar
     * @return carta quitada
     */
    public Carta quitarCarta(int i, int j) {

        if(montonInterior[i][j].isEmpty()){
            return null;
        }
        
        Carta toret;

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
        
        if(verificarMovimiento(i, j, k)){
            colocarCartaMontonExterior(quitarCarta(i, j), k);
        }
        

    }
    /**
     * 
     * @param i cordenada X de la carta que se desea mover
     * @param j cordenada Y de la carta que se desea mover
     * @param k cordenada X a donde se va a mover la carta quitada
     * @param l cordenada Y a donde se va a mover la carta quitada
     */
    public void moverCartaInteriorInterior(int i, int j,int k,int l){
    
         if(verificarMovimiento(i, j, k,l)){
        colocarCartaMontonInterior(quitarCarta(i, j), k, l);
         }
    }
    
//    //verifica si existe algun movimiento posible
    public boolean existeMovimiento() {
        
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++){
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 4; k++){
                        
                        if(verificarMovimiento(x, y, j)== true){
                            return true;
                        }
                        
                        if(verificarMovimiento(x, y, j,k)== true){
                            return true;
                        }
        }//fin bucle X
        }//fin bucle Y
        }//fin bucle J
        }//fin bucle K
            
        return false;
    }
    

    @Override
    public String toString() {

        //Escribo el monton de descartes
        
//        System.out.println("" + montonExterior[0].peek() + montonExterior[1].peek() + montonExterior[2].peek() + montonExterior[3].peek());
//        System.out.println("\n");
            
            try {
                System.out.print( montonExterior[0].peek()+"\t");
        } catch (Exception e) {
                System.out.print("[-----]\t\t");
        }
            try {
                System.out.print( montonExterior[1].peek()+"\t");
        } catch (Exception e) {
                System.out.print("[-----]\t\t");
        }
            try {
                System.out.print( montonExterior[2].peek()+"\t");
        } catch (Exception e) {
                System.out.print("[-----]\t\t");
        }
            try {
                System.out.print( montonExterior[3].peek()+"\t");
        } catch (Exception e) {
                System.out.print("[-----]\t\t");
        }
           
            System.out.println("\n");
       
        //escribo el monton interior
        for (int i = 0; i < 4; i++) {
            

                System.out.println(""+ montonInterior[0][i].peek()+ "\t" + montonInterior[1][i].peek()+ "\t" + montonInterior[2][1].peek()+ "\t" + montonInterior[3][i].peek());

            
            
        }
        
        
        return "";
    }
    
    private boolean verificarMovimiento(int x, int y , int j){
    
    boolean valido = false;
    
    //Verificacion de si un As se puede mover a una pila vacia------------------------
    if(montonExterior[j].isEmpty()){
        if(montonInterior[x][y].peek().getNumero()== 1){
            return true;
        } 
    }//fin Verificacion As------------------------------------------------------------

    else{
        
         int numeroCartaExterior = montonExterior[j].peek().getNumero();
         int numeroCartaInterior = montonInterior[x][y].peek().getNumero();
         Palos paloCartaExterior = montonExterior[j].peek().getPalo();
         Palos paloCartaInterior = montonInterior[x][y].peek().getPalo();
        if(paloCartaInterior == paloCartaExterior && esSiguiente(numeroCartaInterior, numeroCartaExterior)){
            return true;
        }
    }

    return false;
    }
    
    private boolean esSiguiente(int num,int num2){
    
    int[] numerosCartas = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
    int pos=0;
    for(int i = 0; i < numerosCartas.length; i++){
        if(numerosCartas[i]==num){
            pos = i;
            break;
        }
    }
    
    return num2==numerosCartas[pos+1];
    
    }
    
    private boolean verificarMovimiento(int x, int y , int j, int k){
    
        if(montonInterior[x][y].isEmpty()||montonInterior[j][k].isEmpty()){
            return false;
        }
        
        int numeroCarta1 = montonInterior[x][y].peek().getNumero();
        int numeroCarta2 = montonInterior[j][k].peek().getNumero();
        Palos paloCarta1 = montonInterior[x][y].peek().getPalo();
        Palos paloCarta2 = montonInterior[j][k].peek().getPalo();
        
        if(paloCarta1 == paloCarta2 && esSiguiente(numeroCarta1, numeroCarta2)){
            return true;
        }

        return false;
    }

}//fin clase-----------------------------------------
