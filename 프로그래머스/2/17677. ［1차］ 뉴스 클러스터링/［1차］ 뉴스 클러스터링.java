import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> letters1 = getLetters(str1);
        ArrayList<String> letters2 = getLetters(str2);

        if (letters1.size() == 0 && letters2.size() == 0) {
            return 65536; // 둘 다 공집합일 경우
        }

        ArrayList<String> union = new ArrayList<>();
        int intersection = 0;

        for (String letter : letters2) {
            if (letters1.remove(letter)) {
                intersection++;
            }
            union.add(letter);
        }

        union.addAll(letters1);

        double answer = (double) intersection / union.size();

        return (int) (answer * 65536);
    }

    public ArrayList<String> getLetters(String words) {
       ArrayList<String> letterList = new ArrayList<>();

        for (int i = 0; i < words.length() - 1; i++) {
            char current = words.charAt(i);
            char next = words.charAt(i + 1);
            if (Character.isLetter(current) && Character.isLetter(next)) {
                StringBuilder sb = new StringBuilder();
                letterList.add(sb.append(current).append(next).toString().toLowerCase());
            }
        }

        return letterList;
    }
}