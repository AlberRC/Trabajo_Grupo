package b300oobasica.E320GlobosExplosivos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int cantidadGlobos = 5;
        Globo[] globos = new Globo[cantidadGlobos];
        int globoActual = 0;

        int victoriasJ1 = 0, victoriasJ2 = 0;
        int jugadorActual = 1;

        System.out.println("Bienvenido al juego de los globos explosivos");

        do { // Rondas
            globos[globoActual] = new Globo();

            do { // Soplidos
                System.out.printf("J1 " + "v ".repeat(victoriasJ1) + "· ".repeat(3 - victoriasJ1) + "      TURNO: J%d      " + "J2 " + "v ".repeat(victoriasJ2) + "· ".repeat(3 - victoriasJ2) + "\n", jugadorActual);

                System.out.println(globos[globoActual]);

                System.out.println("Introduce la cantidad que quieres inflar: ");
                int cantidadInflar = teclado.nextInt();
                while (cantidadInflar <= 0) {
                    System.out.println("No puedes soplar 0 ó menos");
                    cantidadInflar = teclado.nextInt();
                }

                globos[globoActual].inflar(cantidadInflar);

                jugadorActual = jugadorActual == 1 ? 2 : 1; // Alterna el jugador.

                if (globos[globoActual].explotado()) {
                    System.out.println("¡Explotó!");
                    System.out.println(globos[globoActual]);

                    if (jugadorActual == 1) victoriasJ1++;
                    else victoriasJ2++; // Victoria para el jugador que NO soplaba (acabamos de alternar).
                }
            } while (!globos[globoActual].explotado());

            globoActual++;
        } while (victoriasJ1 < cantidadGlobos/2 && victoriasJ2 < cantidadGlobos/2);

        // Ya se ha cambiado el jugador pero es correcto, ya que acaba de explotar
        // un globo y habrá ganado el jugador al que NO le ha explotado el globo.
        System.out.printf("Ha ganado el jugador %d\n", jugadorActual);
    }
}
