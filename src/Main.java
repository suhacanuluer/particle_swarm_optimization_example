public class Main {
    public static void main(String[] args) {

        int POPULATION_SIZE = 10;
        int IT_MAX = 1000; //iteration number
        int c1 = 2, c2 = 2;
        Rosenbrock rosenbrock = new Rosenbrock(); //for fitness

        Individual [] population = new Individual[POPULATION_SIZE];
        for (int i=0; i<POPULATION_SIZE; i++) {
            population[i] = new Individual();
        }

        Individual globalBest = population[0];

        for(int i=0; i<IT_MAX; i++) {
            for(Individual individual: population) {
                double bestFitnessForPopulation = rosenbrock.evaluate(globalBest.pBest);
                double currentFitness = rosenbrock.evaluate(individual.solution);
                double bestFitnessForCurrent = rosenbrock.evaluate(individual.pBest);

                if(currentFitness < bestFitnessForCurrent) {
                    individual.pBest = individual.solution;
                }

                if(currentFitness < bestFitnessForPopulation) {
                    globalBest = individual;
                }
            }
            for(Individual individual: population) {
                for(int j=0; j<individual.solution.length; j++) {
                    individual.v[j] = (int) (individual.v[j] + (c1 * Math.random() * (individual.pBest[j] - individual.solution[j])) + (c2 * Math.random() * (globalBest.pBest[j] - individual.solution[j])));
                    individual.solution[j] += individual.v[j];
                }
            }
        }

        System.out.println("Fitness: " + rosenbrock.evaluate(globalBest.pBest));
        for(int i=0; i<globalBest.pBest.length; i++) {
            System.out.print(globalBest.pBest[i] + ", ");
        }
    }
}
