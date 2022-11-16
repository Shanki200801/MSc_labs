import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[] array = { 2, 6, 1, 3, 5 };
        for (int i = 0; i < array.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min_index] > array[j]) {
                    min_index = j;
                }
            }
            int t = array[min_index];
            array[min_index] = array[i];
            array[i] = t;
        }

        System.out.println(Arrays.toString(array));

    }
}
