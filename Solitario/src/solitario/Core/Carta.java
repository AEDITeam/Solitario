/*
 * Representa una carta, formada por un número y su palo correspondiente
 */
package solitario.Core;

/**
 *
 * @author AEDI
 */
public class Carta {

    private final int numero;
    private final Palos palo;

    public Carta(int numero, Palos palo, boolean girada) {
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

        cadena.append("Carta {").append("\n");
        cadena.append(" - ").append(numero).append("\n");
        cadena.append(" - ").append(palo).append("\n");
        cadena.append("}");
       
        return cadena.toString();
    }

    
}
