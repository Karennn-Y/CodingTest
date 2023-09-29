class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long compare = Long.parseLong(p);
        int p_length = p.length();
        
        for (int i = 0; i <= t.length() - p_length; i++) {
            long n = Long.parseLong(t.substring(i, i + p_length));
            if (n <= compare) answer++;
        }
        return answer;
    }
}
