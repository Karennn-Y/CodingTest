class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        int cnt = 0;
        
        for (char c : s.toCharArray()){
            if(c == 'p')
                cnt++;
            else if(c == 'y')
                cnt--;
        }
        
        return (cnt == 0) ? true : false;
    }
}