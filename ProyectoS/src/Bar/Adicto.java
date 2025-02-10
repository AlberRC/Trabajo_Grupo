package Bar;

/**
 * Esta clase representa al jugador de la máquina tragaperras
 * y nos permite interactuar con esta.
 * @see TragaPerras
 * @author Pablo Lin
 * @version 1.0.0
 */
public class Adicto {
    int dinero;
    int dineroApostado;

    /**
     * Crea un jugador
     * @param dineroTotal es el dinero con el que va empezar el jugador.
     */
    public Adicto(int dineroTotal) {
        this.dinero = dineroTotal;
    }

    /**
     * Este método nos permite apostar una cierta cantidad de dinero.
     * Esta cantidad se le será asignada a la variable <code>int dineroApostado</code>
     * @param dineroApostado
     * @since 1.0.0
     */
    public void apostar(int dineroApostado) {
        this.dineroApostado = dineroApostado;
        dinero = dinero - dineroApostado;
    }

    /**
     * En caso de que el método <code>comprobarLinea</code> haya devuelto True,
     * el <code>dineroApostado</code> se duplicará.
     * @see TragaPerras#comprobarLinea
     * @since 1.0.0
     */
    public void ganarLinea() {
        dineroApostado = dineroApostado * 2;
    }

    /**
     * En caso de que el método <code>comprobarLinea</code> haya devuelto False,
     * el <code>dineroApostado</code> se reducirá a la mitad.
     * @see TragaPerras#comprobarLinea()
     * @since 1.0.0
     */
    public void perderLinea() {
        dineroApostado = dineroApostado / 2;
    }

    /**
     * Muestra información esencial para el jugador como su dinero total y su dinero apostado.
     * @return Toda la información se añade a un <code>StringBuilder</code> y se devuelve como un <code>String</code>.
     */
    public String toString() {
        StringBuilder texto = new StringBuilder();
        texto.append("Este es tu dinero: " + dinero + "\n");
        texto.append("Este es tu dinero apostado: " + dineroApostado + "\n");
        return texto.toString();

    }

}
