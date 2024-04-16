import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GestionDeFechas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dates = new ArrayList<>();

        // pide al usuario que introduzca las fechas
        System.out.println("Introduce las fechas (en formato dd/mm/yyyy) una por línea. Escribe 'fin' para terminar:");
        String input;
        while (!(input = scanner.nextLine()).equals("fin")) {
            if (isValidDate(input)) {
                dates.add(input);
            } else {
                System.out.println("Formato de fecha incorrecto. Introduce la fecha en formato dd/mm/yyyy.");
            }
        }

        // ordena las fechas
        Collections.sort(dates);

        // muestra las fechas ordenadas
        System.out.println("\nFechas ordenadas:");
        for (String date : dates) {
            System.out.println(date);
        }
    }

    // valida el formato de la fecha (dd/mm/yyyy)
    public static boolean isValidDate(String date) {
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}
