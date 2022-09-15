import java.io.*;
import java.util.*;

public class MeanMedianMode_of_Array {
    public static double getMean(int[] arr) {    
        double Mean = 0;
        for (int i = 0; i < arr.length; i++)
            Mean += arr[i];
        Mean /= arr.length;

        return Mean;
    }

    public static double getMedian(int[] arr) {
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        double Median = 0;
        int v = arrCopy.length;

        if (v % 2 == 1) {
            Median = arrCopy[v / 2];
        } else {
            Median = (arrCopy[v / 2] + arrCopy[v / 2 - 1]) / 2.0;
        }

        return Median;
    }

    public static double getMode(int[] arr) {    
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int i : arrCopy) {
            if (!freq.containsKey(i))
                freq.put(i, 1);
            else
                freq.put(i, freq.get(i) + 1);
        }

        double mode = arrCopy[0];
        int maxFreq = 1;

        for (Map.Entry<Integer, Integer> me : freq.entrySet()) {
            if (me.getValue() > maxFreq) {
                maxFreq = me.getValue();
                mode = me.getKey();
            }
        }

        return mode;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int E = s.nextInt();
        s.nextLine();
        String S = s.nextLine();
        String[] Xs = S.split(" ");
        int[] X = new int[E];

        for (int i = 0; i < E; i++)
            X[i] = Integer.parseInt(Xs[i]);

        double Mean = getMean(X);
        double Median = getMedian(X);
        double Mode = getMode(X);

        System.out.printf("Mean: %.2f\n", Mean);
        System.out.printf("Median: %.2f\n", Median);
        System.out.printf("Mode: %.2f\n", Mode);

        s.close();
    }
}