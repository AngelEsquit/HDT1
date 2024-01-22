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
        while (true) {
            turnOn();
            scanner.nextLine();

            try { // Try para proteger el menú
                opcion = scanner.nextInt();
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
        System.out.println("1: Buscar un producto");
        System.out.println("2: Lista de productos");
        System.out.println("3: Ventas");
        System.out.println("4: Ver informe");
        System.out.println("5: Registrar venta");
        System.out.println("6: Apagar la radio");
        System.out.println("");
    }

    public static void turnOn() { // Pregunta para encender la radio
        System.out.println("");
        System.out.println("Presione cualquier tecla para encender la radio");
        System.out.println("");
    }
}
