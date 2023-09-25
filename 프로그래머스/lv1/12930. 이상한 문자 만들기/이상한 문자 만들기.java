
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] string = s.split("");
        int cnt = 0;
        for(String str : string) {
            cnt = str.contains(" ") ? 0 : cnt + 1;
            sb.append((cnt % 2 == 0) ? str.toLowerCase() : str.toUpperCase());
        }
        return sb.toString();
    }
}
