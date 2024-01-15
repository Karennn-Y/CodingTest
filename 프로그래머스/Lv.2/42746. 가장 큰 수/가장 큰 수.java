import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution (int[] numbers) {
        ArrayList<String> numberString = new ArrayList<>();
        for (int number : numbers) {
            numberString.add(number + "");
        }
        numberString.sort(((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));
        if(numberString.get(0).equals("0")) return "0";
        return String.join("", numberString);
    }

}