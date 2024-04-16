public class CalculoDePotenciasYMaximos {

    public static void main(String[] args) {
        // ejemplo de cálculo de potencia
        int base = 2;
        int exponent = 5;
        int result = power(base, exponent);
        System.out.println(base + " elevado a la " + exponent + " es: " + result);

        int[] data = {3, 7, 1, 9, 4, 5};
        int max = findMax(data);
        System.out.println("El valor máximo en el conjunto de datos es: " + max);
    }

    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }

    public static int findMax(int[] data) {
        return findMaxHelper(data, 0, data.length - 1);
    }

    private static int findMaxHelper(int[] data, int start, int end) {
        if (start == end) {
            return data[start];
        } else {
            int mid = (start + end) / 2;
            int maxLeft = findMaxHelper(data, start, mid);
            int maxRight = findMaxHelper(data, mid + 1, end);
            return Math.max(maxLeft, maxRight);
        }
    }
}
