import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class OrganizacionDeDocumentos {

    public static void main(String[] args) {
        // ruta del archivo de entrada y salida
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // llamar a la función para ordenar el archivo
        sortFileLinesAlphabetically(inputFile, outputFile);
    }

    public static void sortFileLinesAlphabetically(String inputFile, String outputFile) {
        try {
            // lee las líneas del archivo de entrada
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // ordena las líneas alfabéticamente
            Collections.sort(lines);

            // escribe las líneas ordenadas en el archivo de salida
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (String sortedLine : lines) {
                writer.write(sortedLine);
                writer.newLine();
            }
            writer.close();

            System.out.println("Las líneas del archivo han sido ordenadas");
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
