import java.util.Arrays;

public class MejoraDeAlgoritmos {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 5, 3, 4, 2};
        System.out.println("Arreglo original: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= 10) {
                insertionSort(arr, low, high);
                return;
            }

            int[] pivotIndices = partition(arr, low, high);
            int pivotLow = pivotIndices[0];
            int pivotHigh = pivotIndices[1];

            quickSort(arr, low, pivotLow - 1);
            quickSort(arr, pivotHigh + 1, high);
        }
    }

    public static int[] partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low;
        int right = high;
        int i = low + 1;

        while (i <= right) {
            if (arr[i] < pivot) {
                swap(arr, i++, left++);
            } else if (arr[i] > pivot) {
                swap(arr, i, right--);
            } else {
                i++;
            }
        }
        return new int[]{left, right};
    }

    public static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
