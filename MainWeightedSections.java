package WeightedSections;

public class MainWeightedSections {
    public static void main(String[] args) {
        double[] input = {0.5, 5.0, 1.0,
                          13.5, 16.5, 8.0,
                          6.5, 12.1, 4.0,
                          9.0, 15.0, 15.0,
                          3.5, 7.1, 10.0,
                          6.0, 13.0, 11.0};

        WeightedSections ws = new WeightedSections(input);
        ws.computeSequence();
        System.out.println(ws);
    }
}
