package src;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Radio radio = new Radio();
        int button;
        int option = scanner.nextInt();
        while (true){
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