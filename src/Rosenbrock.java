public class Rosenbrock {
    public double evaluate(int[] solution){
        int numberOfVariables = solution.length;
        double[] x = new double[numberOfVariables];

        for(int i=0; i<numberOfVariables; i++) {
            x[i] = solution[i];
        }
        double sum = 0.0;

        for(int i=0; i<numberOfVariables-1; i++) {
            double temp1 = (x[i] * x[i]) - x[i+1];
            double temp2 = x[i] - 1.0;
            sum += (100.0 * temp1 * temp1) + (temp2 * temp2);
        }
        return sum;
    }
}
