package WeightedSections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeightedSections {
    private List<Section> list = new ArrayList<Section>();

    //constructing from array of 3*i values
    public WeightedSections(double[] input){
        int len = input.length;

        if(len == 0) throw new RuntimeException("Empty array");
        if(len % 3 != 0) throw new RuntimeException("Length of array must be dividible by 3");
        for(int i = 0; i < len/3; i++){
            list.add(new Section(input[3*i], input[3*i+1], input[3*i+2]));
        }
    }

    public void addSection(double s, double f, double w){
        list.add(new Section(s, f, w));
    }

    private void sortByFinish(){
        list.sort(new SortByFinish());
    }

    //compute most heavy sequence of sections (without overlapping)
    public void computeSequence(){
        //memoization array
        double[] mem = new double[list.size() + 1];
        mem[0] = 0.0;

        sortByFinish();
        computePrev();

        for(int i = 1; i <= list.size(); i++){
            if(list.get(i - 1).getPrev() == null)
                mem[i] = list.get(i - 1).getWeight();
            else
                mem[i] = Math.max(list.get(i - 1).getWeight() + mem[list.indexOf(list.get(i - 1).getPrev())], mem[i - 1]);
        }
        System.out.println(mem[list.size() - 1]);//debug
        printSequence();
    }

    private void computePrev(){
        if(list.size() == 0)
            throw new RuntimeException("Empty list");
        //finding previous section, that finishes before each section starts
        Collections.reverse(list);
        for(Section s: list){
            s.setPrev(findPrev(list.indexOf(s)));
        }
        Collections.reverse(list);
    }

    private Section findPrev(int index){
        for(int i = index; i < list.size(); i++){
            if(list.get(i).getFinish() <= list.get(index).getStart())
                return list.get(i);
        }
        return null;
    }

    private void printSequence() {

    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Section s: list){
            str.append("(" + s.getStart() + " - " + s.getFinish() + "): " + s.getWeight() + "    ");
        }
        //debug loop
        str.append("\n");
        for(Section s: list){
            if(s.getPrev() == null)
                str.append(s.getPrev() + "   ");
            else
                str.append("(" + s.getPrev().getStart() + " - " + s.getPrev().getFinish() +
                        "): " + s.getPrev().getWeight() + "    ");
        }
        return str.toString();
    }
}
