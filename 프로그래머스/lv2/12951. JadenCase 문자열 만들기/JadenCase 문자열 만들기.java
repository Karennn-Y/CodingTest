class Solution {
    public String solution(String s) {
        String[] a = s.toLowerCase().split(" ");

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < a.length; i++) {
			if (a[i].isEmpty()) {
				sb.append(" ");
				continue;
			} else {
				sb.append(a[i].toUpperCase().charAt(0));
				for (int j = 1; j < a[i].length(); j++) {
					sb.append(a[i].charAt(j));
				}
			}
			if (i != a.length - 1) {
				sb.append(" ");
			}
		}
        
        if (s.substring(s.length() - 1, s.length()).equals(" ")) {
			sb.append(" ");
		}
		
        return sb.toString();
    }
}