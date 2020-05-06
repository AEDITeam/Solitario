/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author juanm
 */
public class Carta {

    private final int numero;
    private final Palos palo;

    public Carta(int numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public Palos getPalo() {
        return palo;
    }

   
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();

        cadena.append("[").append(numero).append("-");
        cadena.append(palo).append("]");
        
       
        return cadena.toString();
    }

    
}
