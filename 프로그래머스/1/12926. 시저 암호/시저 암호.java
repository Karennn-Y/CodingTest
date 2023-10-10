class Solution {
    public String solution(String s, int n) {
         StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char ch = ' ';
            if (c == ' ') {
                sb.append(c);
                continue;
            }
            if (c < 97 && c + n > 90) {
                ch = (char) (64 + (c + n - 90));
                sb.append(ch);
                continue;
            }
            if (c > 96 && c + n > 122) {
                ch = (char) (96 + (c + n - 122));
                sb.append(ch);
                continue;
            }
            ch = (char) (c + n);
            sb.append(ch);
        }
        return sb.toString();
    }
}