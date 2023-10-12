public int[] solution (int[] score, int k) {
        int[] answer = new int[score.length];
        ArrayList<Integer> fame = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            fame.add(score[i]);
            Collections.sort(fame);
            if (fame.size() > k)
                fame.remove(0);
            Collections.sort(fame);
            answer[i] = fame.get(0);
        }
        return answer;
}
