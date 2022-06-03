package WeightedSections;

public class Section {
    private final double start;
    private final double finish;
    private final double weight;
    private Section prev;

    public Section(double start, double finish, double weight){
        this.start = start;
        this.finish = finish;
        this.weight = weight;
        this.prev = null;
    }

    public double getStart() {
        return start;
    }

    public double getFinish() {
        return finish;
    }

    public double getWeight() {
        return weight;
    }

    public Section getPrev() {
        return prev;
    }

    public void setPrev(Section prev) {
        this.prev = prev;
    }
}
