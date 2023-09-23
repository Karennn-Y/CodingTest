class Solution {
    public String solution(String X, String Y) {
                int[] xArr=new int[10];
        int[] yArr=new int[10];
        for (int i=0; i<X.length(); i++){
            xArr[(int)(X.charAt(i)-'0')]++;
        }
        for (int i=0; i<Y.length(); i++){
            yArr[(int)(Y.charAt(i)-'0')]++;
        }
        String result="";
        for (int i=9; i>-1; i--) {
            int num= Math.min(xArr[i], yArr[i]);
            result+=Integer.toString(i).repeat(num);
        }
        if (result.equals("")) return "-1";
        if (result.charAt(0)=='0') return "0";
        return result;
    }
}