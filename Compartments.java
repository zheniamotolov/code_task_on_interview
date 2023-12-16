import java.util.ArrayList;
import java.util.List;

public class Compartments {
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < startIndices.size(); i++) {
            String substring = s.substring(startIndices.get(i) - 1, endIndices.get(i));
            int count = 0;
            boolean isInCompartment = false;
            int localCount = 0;
            for(char c : substring.toCharArray()){
                if(c == '|'){
                    if(isInCompartment){
                        count += localCount;
                    }
                    isInCompartment = true;
                    localCount = 0;
                } else if(c == '*' && isInCompartment){
                    localCount++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "*|*|*|";
        List<Integer> startIndices = new ArrayList<>();
        startIndices.add(1);

        List<Integer> endIndices = new ArrayList<>();
        endIndices.add(1);
        endIndices.add(6);

        System.out.println(numberOfItems(s, startIndices, endIndices));
        // Output: [0, 2]
    }
}

