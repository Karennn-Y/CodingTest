import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<int[], String> albums = new HashMap<>();
        HashMap<String, Integer> genreCount = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            albums.put(new int[]{plays[i], i}, genres[i]);
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genreKeyList = new ArrayList<>(genreCount.keySet());
        genreKeyList.sort((o1, o2) -> (genreCount.get(o2).compareTo(genreCount.get(o1))));

        List<int[]> keyList = new ArrayList<>(albums.keySet());
        keyList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int compare = Integer.compare(o2[0], o1[0]);
                if (compare == 0)
                    return Integer.compare(o1[1], o2[1]);
                return compare;
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<int[]> remove = new ArrayList<>();
        int cnt = 0;
        for (String g : genreKeyList) {
            for (int[] key : keyList) {
                if (cnt >= 2) break;
                if (g.equals(albums.get(key))) {
                    result.add(key[1]);
                    remove.add(key);
                    cnt++;
                }
            }
            for (int[] r : remove) {
                keyList.remove(r);
                cnt = 0;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = result.get(i);

        return answer;
    }
}