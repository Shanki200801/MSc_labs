/*-----------------------------------------------------------
Program to calculate mean median and mode of command line arguments
@Author - Shashank
-------------------------------------------------------------*/
package Printable_java;

import java.util.Arrays;

public class StatsOpsCLargs {
    public static void main(String[] args) {
        System.out.println("The command line arguments given are");
        System.out.println(Arrays.toString(args));

        double[] array = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = Double.parseDouble(args[i]);
        }
        System.out.println("Given array is " + Arrays.toString(array));
        System.out.println("Mean is " + calcMean(array));
        System.out.println("Median is " + calcMedian(array));
        System.out.println("Mode is " + calcMode(array));
    }

    private static double calcMode(double[] array) {

        Arrays.sort(array);
        // using the emperical relation to calculate the mode ie
        // mode = mean - (3*(mean-median))
        double mode = calcMean(array) - 3 * (calcMean(array) - calcMedian(array));

        return mode;
    }

    private static double calcMedian(double[] array) {

        int size = array.length;
        Arrays.sort(array);
        if (size % 2 != 0) {
            return array[size / 2];
        }
        return (array[size / 2 - 1] + array[size / 2]) / 2;
    }

    private static double calcMean(double[] array) {
        double sum = 0;
        for (double x : array) {
            sum += x;
        }

        return sum / array.length;
    }
}
