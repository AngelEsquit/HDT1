package src;

/**
 * Clase App como entrada de la aplicacion.
 * Inicializa el objeto MenuUI y llama a su método Menu para iniciar la aplicación.
 */
public class App {
    /**
     * Crea una instancia de MenuUI y llama a su método Menu.
     *
     * @param args Los argumentos de línea de comandos pasados a la aplicación.
     */
    public static void main(String[] args) {
        MenuUI menu = new MenuUI();
        menu.Menu();
    }
}
