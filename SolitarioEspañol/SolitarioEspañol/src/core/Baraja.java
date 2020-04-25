/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author juanm
 */


public class Baraja {

    private Stack <Carta> mazo;

    public Baraja() {

        mazo = new Stack<>();

        int[] cartasAceptadas = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};

        // Recorro los diferentes palos
        for (int i = 0; i < Palos.values().length; i++) {

            // Recojo el palo seleccionado
            Palos palo = Palos.values()[i];

            // Recorro los numeros de cartas existentes por cada palo
            for (int x = 0; x < cartasAceptadas.length; x++) {

                // new Carta(Palo, Numero, Volteada)
                mazo.push(new Carta(cartasAceptadas[x], palo));
            }
        }

        // Barajo las cartas para desordenarlas
        reordenar();

        for (Carta carta : mazo) {

            System.out.println(carta);
        }
    }

    // Get's
    public Carta cogerCarta() {

        return mazo.pop();
    }

    // Metodos extras
    public void reordenar() {

        Random genRandom = new Random();

        for (int i = 0; i < 100; i++) {

            //tomo un Nº aleatorio dentro del mazo
            int numRandom = genRandom.nextInt(39) + 1;

            //El remove devuelve el objeto y reordena el mazo (no deja pos vacía)
            //el push situa el objeto en la primera pos a escoger (encima del mazo)
            Carta cartaEscogida = mazo.remove(numRandom);
            mazo.push(cartaEscogida);
        }
    }

}
