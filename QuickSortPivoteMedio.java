import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class QuickSortPivoteMedio {

    // ================= QUICK SORT =================
    public static void quickSort(int[] arr, int low, int high) {

        int i = low;
        int j = high;

        // pivote en la posicion media
        int pivote = arr[(low + high) / 2];

        while (i <= j) {

            while (arr[i] < pivote)
                i++;

            while (arr[j] > pivote)
                j--;

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(arr, low, j);

        if (i < high)
            quickSort(arr, i, high);
    }

    // ================= SWAP =================
    public static void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // ================= GENERADORES =================
    public static int[] arregloAleatorio(int tamaño) {

        Random r = new Random();
        int[] arr = new int[tamaño];

        for (int i = 0; i < tamaño; i++)
            arr[i] = r.nextInt(100000);

        return arr;
    }

    public static int[] arregloCreciente(int tamaño) {

        int[] arr = new int[tamaño];

        for (int i = 0; i < tamaño; i++)
            arr[i] = i;

        return arr;
    }

    public static int[] arregloDecreciente(int tamaño) {

        int[] arr = new int[tamaño];

        for (int i = 0; i < tamaño; i++)
            arr[i] = tamaño - i;

        return arr;
    }

    // ================= MEDICION =================
    public static long medirTiempo(int[] arreglo) {

        int[] copia = Arrays.copyOf(arreglo, arreglo.length);

        long inicio = System.nanoTime();

        quickSort(copia, 0, copia.length - 1);

        return System.nanoTime() - inicio;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        int[] tamaños = {100, 1000, 5000, 10000};

        try {

            FileWriter archivo =
                    new FileWriter("resultadosQuickSortMedio.csv");

            archivo.write("Tipo,Tamaño,Tiempo(ns)\n");

            for (int tamaño : tamaños) {

                archivo.write("Aleatorio," + tamaño + "," +
                        medirTiempo(arregloAleatorio(tamaño)) + "\n");

                archivo.write("Creciente," + tamaño + "," +
                        medirTiempo(arregloCreciente(tamaño)) + "\n");

                archivo.write("Decreciente," + tamaño + "," +
                        medirTiempo(arregloDecreciente(tamaño)) + "\n");

                System.out.println("OK tamaño: " + tamaño);
            }

            archivo.close();
            System.out.println("CSV pivote medio generado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}