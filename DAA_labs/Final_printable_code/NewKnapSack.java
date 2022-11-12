package Final_printable_code;

import java.util.*;

class NewKnapSack {
    int totpro, capacity;

    void knapsck(int w[], int ob[], int p[], int Case, float piwi[], int tempcap, int x[], int n) {
        int i, k, temppro = 0, j;

        capacity = tempcap;

        if (Case <= 3) {
            for (i = 0; i < n; i++)
                x[i] = 0;

            sort(w, ob, p, n, Case, piwi);

            for (i = 0; i < n; i++) {
                if (tempcap >= w[i]) {
                    tempcap = tempcap - w[i];
                    k = ob[i];
                    x[k - 1] = 1;
                }
            }

            for (i = 0; i < n; i++)
                for (j = 0; j < n; j++)
                    if (i + 1 == ob[j])
                        temppro = temppro + (x[i] * p[j]);

            System.out.print("\nSolution Set For Case " + Case + ":X= ");
            for (i = 0; i < n; i++)
                System.out.print(" " + x[i]);

            System.out.println("\n Case " + Case + " Profit is " + temppro);

            Case++;

            if (totpro < temppro)
                totpro = temppro;

            knapsck(w, ob, p, Case, piwi, capacity, x, n);
        } else
            System.out.println("\n\n Optimal Profit is " + totpro);
    }

    void swap(int a[], int i, int j) {
        int temp;

        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    void swap1(float a[], int i, int j) {
        float temp;

        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    void sort(int w[], int ob[], int p[], int n, int cas, float piwi[]) {
        int i, j;

        for (i = 0; i < n; i++)
            for (j = i + 1; j < n; j++) {
                if (w[i] >= w[j] && cas == 1) {
                    swap(w, i, j);

                    swap(ob, i, j);

                    swap(p, i, j);

                    swap1(piwi, i, j);
                }
                if (p[i] <= p[j] && cas == 2) {
                    swap(p, j, i);
                    swap(ob, i, j);
                    swap(w, i, j);
                    swap1(piwi, i, j);
                }
                if (piwi[i] <= piwi[j] && cas == 3) {
                    swap1(piwi, j, i);
                    swap(p, i, j);
                    swap(ob, i, j);
                    swap(w, i, j);
                }
            }
    }

    public static void main(String args[]) {
        int n, m, w[], p[], i, ob[], x[];
        float piwi[], a, b;

        w = new int[50];
        p = new int[50];
        ob = new int[50];
        x = new int[50];
        piwi = new float[50];

        Scanner sc = new Scanner(System.in);

        System.out.println("\n Enter the Value of N: ");
        n = sc.nextInt();

        System.out.println("\n Enter the Capacity: ");
        m = sc.nextInt();

        System.out.println("\n Enter " + n + " Weigths: ");
        for (i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            ob[i] = i + 1;
        }

        System.out.println("\n Enter " + n + " Profits: ");
        for (i = 0; i < n; i++)
            p[i] = sc.nextInt();

        for (i = 0; i < n; i++) {
            a = p[i];
            b = w[i];
            piwi[i] = a / b;
        }

        NewKnapSack ks = new NewKnapSack();
        ks.knapsck(w, ob, p, 1, piwi, m, x, n);
    }
}