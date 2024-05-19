import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] tuplesList = s.substring(1, s.length() - 1).split("(?<=}),");
        
        Arrays.sort(tuplesList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
        for (String tuples : tuplesList) {
            String[] arr = tuples.substring(1, tuples.length() - 1).split(",");
            for (String t : arr) {
                int tuple = Integer.parseInt(t);
                if (!answer.contains(tuple))
                    answer.add(tuple);
            }
        }
        return answer;
    }
}