class Solution {
    public String[] words = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        for (String bab : babbling) {
            answer += checkCount(bab);
        }
        return answer;
    }
    
    public int checkCount(String word) {
        int cnt = 0;
        String compare = "";
        while (!word.isEmpty()) {
            char c = word.charAt(0);
            switch (c) {
                case 'a' -> {
                    if (word.length() < 3) return 0;
                    if (compare.equals(word.substring(0, 3))) return 0;
                    compare = word.substring(0, 3);
                    if (compare.equals(words[0])) {
                        word = word.substring(3);
                    } else {
                        return 0;
                    }
                }
                case 'y' -> {
                    if (word.length() < 2) return 0;
                    if (compare.equals(word.substring(0, 2))) return 0;
                    compare = word.substring(0, 2);
                    if (compare.equals(words[1])) {
                        word = word.substring(2);
                    } else {
                        return 0;
                    }
                }
                case 'w' -> {
                    if (word.length() < 3) return 0;
                    if (compare.equals(word.substring(0, 3))) return 0;
                    compare = word.substring(0, 3);
                    if (compare.equals(words[2])) {
                        word = word.substring(3);
                    } else {
                        return 0;
                    }
                }
                case 'm' -> {
                    if (word.length() < 2) return 0;
                    if (compare.equals(word.substring(0, 2))) return 0;
                    compare = word.substring(0, 2);
                    if (compare.equals(words[3])) {
                        word = word.substring(2);
                    } else {
                        return 0;
                    }
                }
                default -> {
                    return 0;
                }
            }
        }
        return 1;
    }
}