import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Radio implements IRadio{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean state = false;
        float frecuency = 0;
        float[] frequencies = new float[12];
        int option = 0;

        while (true) {
            turnOn();
            scanner.nextLine();

            try { // Try para proteger el menú
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Ingrese un número.");
                scanner.nextLine();
            }
        }
    }

    public static void printMenu() {
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
        System.out.println("6: Apagar la radio");
        System.out.println("");
    }

    public static void turnOn() { // Pregunta para encender la radio
        System.out.println("");
        System.out.println("Presione cualquier tecla para encender la radio");
        System.out.println("");
    }
}
