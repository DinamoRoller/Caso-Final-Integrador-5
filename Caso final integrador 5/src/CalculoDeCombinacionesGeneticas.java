import java.util.ArrayList;
import java.util.List;

public class CalculoDeCombinacionesGeneticas {

    public static void main(String[] args) {
        int length = 3; // longitud de las combinaciones genéticas
        List<String> combinations = generateCombinations(length);
        System.out.println("Combinaciones genéticas de longitud " + length + ":");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<String> generateCombinations(int length) {
        List<String> combinations = new ArrayList<>();
        if (length == 0) {
            combinations.add("");
            return combinations;
        }
        // llamada recursiva para generar combinaciones de longitud menor
        List<String> smallerCombinations = generateCombinations(length - 1);
        // para cada combinación de longitud menor, agregamos cada base nitrogenada posible
        for (String combination : smallerCombinations) {
            combinations.add(combination + "A");
            combinations.add(combination + "C");
            combinations.add(combination + "G");
            combinations.add(combination + "T");
        }
        return combinations;
    }
}
