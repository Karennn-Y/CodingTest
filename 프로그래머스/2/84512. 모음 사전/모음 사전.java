class Solution {
    int answer = 0, cnt = 0;
    public int solution(String word) {
        String[] words = {"A", "E", "I", "O", "U"};
        dfs(words, "", word);
        return answer;
    }
    
    public void dfs (String[] words, String currentWord, String word) {
        if (currentWord.length() == 5 || currentWord.equals(word)) {
            if (currentWord.equals(word))
                answer = cnt;
            return;
        }
        for (int i = 0; i < 5; i++) {
            cnt++;
            dfs(words, currentWord + words[i], word);
        }
    }
}