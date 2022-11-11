package Printable_java.Work;

public class SelectionSort {
    public int[] selectionSort(int[] unsorted) {
        System.out.println("Using selection sort");
        for (int i = 0; i < unsorted.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[min_index] > unsorted[j]) {
                    min_index = j;
                }
            }
            int t = unsorted[i];
            unsorted[i] = unsorted[min_index];
            unsorted[min_index] = t;
        }
        return (unsorted);
    }
}
