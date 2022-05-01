import java.util.Random;

public class Individual {
    int [] solution;
    int [] pBest;
    int [] v;


    public Individual() {
        solution = makeRandomArray();
        pBest = solution;
        v = setZero();
    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int numberOfNumber = 5;
        int[] array = new int[numberOfNumber];
        for(int i=0; i<numberOfNumber; i++) {
            array[i] = (int) (-5.0 + random.nextFloat() * (10.0));
        }
        return array;
    }

    public static int[] setZero() {
        int numberOfNumber = 5;
        int[] array = new int[numberOfNumber];
        for(int i=0; i<numberOfNumber; i++) {
            array[i] = 0;
        }
        return array;
    }
}
