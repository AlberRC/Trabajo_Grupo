package Bar;

import java.util.Scanner;

/**
 * Esta clase actuará como nuestro main, ejecutando el bucle principal de nuestro juego.
 * @author Pablo Lin
 * @version 1.0.0
 */
public class bar {
    /**
     * Primero se le preguntará al jugador una cantidad de dinero a apostar, posteriormente
     * se hará una tirada en la tragaperras y por último se comprobará si ha surgido línea o no.
     * @since 1.0.0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Adicto adicto = new Adicto(55);
        int dineroApostado = 0;
        TragaPerras tragaPerras = new TragaPerras(3, adicto);
        System.out.println(tragaPerras);
        System.out.println("Dale a la 'k' para jugar con la máquina: ");
        char iniciarJuego = sc.next().charAt(0);
        while (iniciarJuego != 'k') {
            System.out.println("Eres un necio, no trolees: ");
            iniciarJuego = sc.next().charAt(0);

        }

        while (iniciarJuego == 'k') {
            if (adicto.dineroApostado == 0) {
                System.out.println(adicto);
                System.out.println("Cuánto dinero quiere apostar:)?: ");
                dineroApostado = sc.nextInt();
                while (dineroApostado < 1) {
                    System.out.println("Eres un necio petulante, no trolees: ");
                    dineroApostado = sc.nextInt();
                }
                adicto.apostar(dineroApostado);
            }
                tragaPerras.tirar();
                System.out.println(tragaPerras.toString());
                if (tragaPerras.comprobarLinea()) {
                    System.out.println("Has ganado!!!");
                    adicto.ganarLinea();
                    System.out.println(adicto.toString());
                    System.out.println("Quiere jugar otra o que: ");
                    iniciarJuego = sc.next().charAt(0);
                }
                else {
                    adicto.perderLinea();
                    System.out.println(adicto);
                    System.out.println("Mala suerte, quiere otra o que: ");
                    iniciarJuego = sc.next().charAt(0);
                }
        }
        int dineroActual = 0;
        System.out.println(dineroActual);
    }
}
