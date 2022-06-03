package WeightedSections;

import java.util.Comparator;

public class SortByFinish implements Comparator<Section> {
    @Override
    public int compare(Section s1, Section s2) {
        return Double.compare(s1.getFinish(), s2.getFinish());
    }
}
