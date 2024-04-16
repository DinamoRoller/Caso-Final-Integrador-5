import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BusquedaEficienteEnTextos {

    public static void main(String[] args) {
        String filename = "textfile.txt"; // nombre del archivo de texto
        String wordToSearch = "example"; // palabra a buscar

        // búsqueda lineal
        System.out.println("Búsqueda lineal:");
        boolean foundLinear = linearSearch(filename, wordToSearch);
        if (foundLinear) {
            System.out.println("La palabra '" + wordToSearch + "' fue encontrada en el archivo");
        } else {
            System.out.println("La palabra '" + wordToSearch + "' no fue encontrada en el archivo");
        }

        // búsqueda binaria
        System.out.println("\nBúsqueda binaria:");
        boolean foundBinary = binarySearch(filename, wordToSearch);
        if (foundBinary) {
            System.out.println("La palabra '" + wordToSearch + "' fue encontrada en el archivo");
        } else {
            System.out.println("La palabra '" + wordToSearch + "' no fue encontrada en el archivo");
        }
    }

    // Búsqueda lineal en un archivo de texto
    public static boolean linearSearch(String filename, String wordToSearch) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(wordToSearch)) {
                    return true; // Se encontró la palabra en esta línea
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false; // La palabra no se encontró en el archivo
    }

    // Búsqueda binaria en un archivo de texto (requiere que el archivo esté ordenado)
    public static boolean binarySearch(String filename, String wordToSearch) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int low = 0;
            int high = countLines(filename) - 1; // Obtener el número total de líneas
            while (low <= high) {
                int mid = low + (high - low) / 2;
                line = getLine(filename, mid);
                if (line.compareTo(wordToSearch) == 0) {
                    return true; // Se encontró la palabra
                } else if (line.compareTo(wordToSearch) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false; // La palabra no se encontró en el archivo
    }

    // Método auxiliar para contar las líneas en un archivo
    public static int countLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }

    // Método auxiliar para obtener una línea específica de un archivo
    public static String getLine(String filename, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        for (int i = 0; i <= lineNumber; i++) {
            line = reader.readLine();
        }
        reader.close();
        return line;
    }
}
