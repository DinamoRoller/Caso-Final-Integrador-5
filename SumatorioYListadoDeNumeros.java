import java.util.ArrayList;
import java.util.List;

public class SumatorioYListadoDeNumeros {

    public static void main(String[] args) {
        // ejemplo de suma de números naturales
        int n = 5;
        int sum = sumNaturals(n);
        System.out.println("La suma de los primeros " + n + " números naturales es: " + sum);

        // ejemplo de listado de números en un rango dado
        int start = 3; // inicio del rango
        int end = 7; // fin del rango
        List<Integer> numbers = listNumbersInRange(start, end);
        System.out.println("Números en el rango [" + start + ", " + end + "]: " + numbers);
    }

    // función recursiva para calcular la suma de números naturales
    public static int sumNaturals(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumNaturals(n - 1);
        }
    }

    // función recursiva para listar números en un rango dado
    public static List<Integer> listNumbersInRange(int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        if (start > end) {
            return numbers;
        } else {
            numbers.add(start);
            numbers.addAll(listNumbersInRange(start + 1, end));
            return numbers;
        }
    }
}
