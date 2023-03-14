class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.toLowerCase().split(" ");

        for (String word : words) {
            if (word.isEmpty()) {
                answer.append(" ");
                continue;
            }
            answer.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");

        }
        if (s.charAt(s.length() - 1) == ' ') {
            return answer.toString();
        }
        return answer.toString().trim();
    }
}