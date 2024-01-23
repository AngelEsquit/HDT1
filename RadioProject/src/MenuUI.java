package src;
import java.util.Scanner;
/**
 * La clase MenuUI representa la interfaz de usuario.
 */
/**
 * Represents the user interface for the radio application menu.
 * Allows the user to perform various actions.
 */
public class MenuUI {

    /**
     * Método que muestra y gestiona el menú de la aplicación de radio.
     * Permite al usuario realizar varias acciones.
     */

    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        Radio radio = new Radio();
        int button;
        while (true){
            System.out.println("");
            System.out.println("**************************************");
            System.out.println("                Menú");
            System.out.println("**************************************");
            System.out.println("Ingrese la opción que desee:");
            System.out.println("1: AM/FM");
            System.out.println("2: Siguiente emisora");
            System.out.println("3: Anterior emisora");
            System.out.println("4: Guardar emisora");
            System.out.println("5: Seleccionar una emisora guardada");
            System.out.println("6: Encender/Apagar la radio");
            System.out.println("");
            
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("AM/FM");
                    radio.toogleAMFM();
                    break;
                case 2:
                    System.out.println("Siguiente emisora");
                    radio.nextFrequency();
                    break;
                case 3:
                    System.out.println("Anterior emisora");
                    radio.previousFrequency();
                    break;
                case 4:
                    System.out.println("Guardar emisora");
                    System.out.println("Ingrese el número de botón en el cual desea guardar la emisora (del 1 al 12)");
                    button = scanner.nextInt();
                    if (button < 1 || button > 12) {
                        System.out.println("Opción inválida");
                        break;
                    }
                    else {
                        radio.setFavFrequency(button);
                        break;
                    }
                case 5:
                    System.out.println("Seleccionar una emisora guardada");
                    System.out.println("Ingrese el número de botón en el cual desea guardar la emisora (del 1 al 12)");
                    button = scanner.nextInt();
                    if (button < 1 || button > 12) {
                        System.out.println("Opción inválida");
                        break;
                    }
                    else {
                        radio.getFavFrequency(button);
                        break;
                    }
                case 6:
                    System.out.println("Encender/Apagar la radio");
                    radio.tooglePowerOffOn();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } 
    }
}

