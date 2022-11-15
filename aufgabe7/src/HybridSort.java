// HybridSort.java

/**
 * Aufgabe 7 Generische Sortiermethoden
 *
 * @author Julian Klimek & Stefan Ptacek
 * @version 05.05.2022
 */

public class HybridSort<T extends Comparable<? super T>> {

    public static <T extends Comparable<T>> void quicksort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static <T extends Comparable<T>> void quicksort(T[] a, int left, int right) {

        while (left < right) {

            if (right - left < 50) {
                insertionSort(a, left, right);
                break;
            }
            else {
                // Teileschritt
                int pivot = partition(a, left, right);

                // Herrscheschritt
                if (pivot - left < right - pivot) {
                    quicksort(a, left, pivot - 1);
                    left = pivot + 1;
                }
                else {
                    quicksort(a, pivot + 1, right);
                    right = pivot - 1;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a, int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            for (int j = i - 1; j >= left; j--) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    // Swap
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                else
                    break;
            }
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int left, int right) {

        T pivot = a[right];
        int i = left - 1;
        int j = right;

        while (true) {
            do i++; while (a[i].compareTo(pivot) < 0);
            do j--; while (j >= left && a[j].compareTo(pivot) > 0);
            if (i >= j) {
                break;
            }
            T tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        // Pivotelement pivot = a[right] und a[i] vertauschen
        a[right] = a[i];
        a[i] = pivot;

        return i;
    }

    /* Alternative partition()
    private static <T extends Comparable<T>> int partition(T arr[], int low,
                                 int high)
    {
        T pivot = arr[high];
        int i = low;
        int j = low;

        while (i <= high) {
            if (arr[i].compareTo(pivot) > 0 )
                i++;
            else {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1;
    }*/
}
