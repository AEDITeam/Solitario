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
    private boolean girada;

    public Carta(int numero, Palos palo, boolean girada) {
        this.numero = numero;
        this.palo = palo;
        this.girada = girada;
    }

    public int getNumero() {
        return numero;
    }

    public Palos getPalo() {
        return palo;
    }

    public boolean isGirada() {
        return girada;
    }

    public void setGirada(boolean girada) {
        this.girada = girada;
    }

    @Override
    public String toString() {
        return "Carta{" + "numero=" + numero + ", palo=" + palo + ", girada=" + girada + '}';
    }

    
}