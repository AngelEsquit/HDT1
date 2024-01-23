import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuUI.printMenu();
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("AM/FM");
                break;
            case 2:
                System.out.println("Siguiente emisora");
                break;
            case 3:
                System.out.println("Anterior emisora");
                break;
            case 4:
                System.out.println("Guardar emisora");
                break;
            case 5:
                System.out.println("Seleccionar una emisora guardada");
                break;
            case 6:
                System.out.println("Apagar la radio");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        scanner.close();
    }
}
