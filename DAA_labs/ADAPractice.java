import java.util.Arrays;

/**
 * ADAPractice
 */
public class ADAPractice {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 6, 4, 2, 1 };

        bubbleSort(arr);
        insertionSort(arr);
        selectionSort(arr);
        System.out.println(Arrays.toString(minmax(arr, 0, arr.length - 1)));
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int t = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = t;
        }

        System.out.println("selection sort " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Insertions sort " + Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        System.out.println("Bubble sort " + Arrays.toString(arr));
    }

    private static int[] minmax(int[] arr, int low, int high) {
        if (low + 1 < high) {
            int[] mm = new int[2];
            int mid = (low + high) / 2;
            int[] mm1 = minmax(arr, low, mid);
            int[] mm2 = minmax(arr, mid + 1, high);
            mm[0] = Math.min(mm1[0], mm2[0]);
            mm[1] = Math.max(mm1[1], mm2[1]);
            return mm;

        } else if (low + 1 == high) {
            int[] mm = new int[2];
            if (arr[low] < arr[high]) {
                mm[0] = arr[low];
                mm[1] = arr[high];
            } else {
                mm[0] = arr[high];
                mm[1] = arr[low];
            }
            return mm;
        } else {
            int[] mm = new int[2];
            mm[0] = arr[low];
            mm[0] = arr[high];
            return mm;

        }
    }
}