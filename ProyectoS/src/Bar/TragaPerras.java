package Bar;

import java.util.Random;

/**
 * Esta clase crea una máquina tragaperras
 * con la que se podrá tirar y apostar
 * @author Pablo Lin
 * @version 1.0.0
 */
public class TragaPerras {
    String[][] maquina;
    String[] simbolos = {"🍕", "🍟", "🍔"};
    Random random = new Random();
    Adicto adicto;

    /**
     * Crea una máquina tragaperras utilizando un
     * array 2D e introduciéndole elementos del array <code>String[] simbolos</code>
     * @param tamano dimensiones del array 2D
     * @param adicto jugador
     * @see Adicto
     */
    public TragaPerras(int tamano, Adicto adicto) {
        this.maquina = new String[tamano][tamano];
        this.adicto = adicto;
        for (int i = 0; i < maquina.length; i++) {
            for (int j = 0; j < maquina[i].length; j++) {
                maquina[i][j] = simbolos[i];
            }
        }
    }

    /**
     * Este método renueva los elementos de cada una de las posiciones de la máquina
     * sobreponiendo un símbolo nuevo elegido de forma aleatoria del array de <code>String[] simbolos</code>.
     * <br>
     * De esta forma se simula una tirada en una máquina tragaperras.
     * @since 1.0.0
     */
    public void tirar() {
        for (int i = 0; i < maquina.length; i++) {
            for (int j = 0; j < maquina[i].length; j++) {
                maquina[i][j] = simbolos[random.nextInt(0, simbolos.length)];
            }
        }
    }

    /**
     * Comprueba si un jugador ha ganado o no.
     * @deprecated Este método fue un método fallido que será eliminado en futuras versiones
     * @return devuelve true si edl jugador ha gando, en caso contrario, devuelve false.
     */
    public boolean comprobarVictoria() {
        return true;
    }

    /**
     * Este método va comprobando cada una de las posiciones de la máquina
     * para ver si los elementos de una misma linea horizontal coinciden.
     * @return devuelve true si se ha conseguido linea, en caso contrario, false.
     */
    public boolean comprobarLinea() {
        for (int i = 0; i < maquina.length; i++) {
            int contador = 0;
            for (int j = 0; j < maquina[i].length - 1; j++) {
                if (!(maquina[i][j].equals(maquina[i][j + 1]))) {
                    break;
                }
                else if (maquina[i][j].equals(maquina[i][j + 1])) {
                    contador++;
                    if (contador == maquina.length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Dibuja la máquina utilizando guiones y barras laterales para simular la estructura de una tragaperras.
     * También añade los elementos del array 2D y dibuja el símbolo siguiente "[k]", simulando un botón con el
     * que empezar una tirada.
     *
     * @return Todos estos elementos se van añadiendo a un <code>StringBuilder</code> que luego es devuelto como un <code>String</code>.
     */
    public String toString() {
        StringBuilder texto = new StringBuilder();
        texto.append("+---------+" + "\n");
        for (int i = 0; i < maquina.length; i++) {
            for (int j = 0; j < maquina[i].length; j++) {
                if (j == 0) {
                    texto.append("|" + maquina[i][j]);
                }
                else if (j == maquina[i].length - 1) {
                    if (i == 1) {
                        texto.append(maquina[i][j] + "|" + "[k]");
                    }
                    else {texto.append(maquina[i][j] + "|");}
                }
                else {texto.append("|" + maquina[i][j] + "|");}
            }
            texto.append("\n");
        }
        texto.append("+---------+" + "\n");
        return texto.toString();

        }
}
