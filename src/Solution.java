import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static class Track {
        int start;
        int end;

        public Track(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static long gridlandMetro(int n, int m, int k, int[][] track) {
        long totalTrackLength = 0;
        Map<Integer, List<Track>> map = new HashMap<>(); // not null means at least one track exist on that row (key)
        for (int i = 0; i < k; i++) {
            int r = track[i][0];
            int s = track[i][1];
            int e = track[i][2];
            if (!map.containsKey(r)) {
                List<Track> l = new ArrayList<>();
                l.add(new Track(s, e));
                map.put(r, l);
            } else {
                map.put(r, mergeInterval(map.get(r), new Track(s, e)));
            }
        }
        for (Map.Entry<Integer, List<Track>> me : map.entrySet()) {
            for (Track t : me.getValue()) {
                totalTrackLength += (t.end - t.start + 1);
                if (t.end - t.start + 1 > m)
                    System.out.println("");
            }
        }

        return (long)n * (long)m - totalTrackLength;
    }

    static List<Track> mergeInterval(List<Track> orderedTracks, Track trackToMerge) {
        int i = 0;
        List<Track> r = new ArrayList<>();

        while (i < orderedTracks.size() && trackToMerge.start > orderedTracks.get(i).end) r.add(orderedTracks.get(i++));
        while (i < orderedTracks.size() && trackToMerge.end >= orderedTracks.get(i).start) {
            trackToMerge = new Track(Math.min(trackToMerge.start, orderedTracks.get(i).start),
                    Math.max(trackToMerge.end, orderedTracks.get(i).end));
            i++;
        }
        r.add(trackToMerge);
        r.addAll(orderedTracks.subList(i, orderedTracks.size()));

        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] track = new int[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        long result = gridlandMetro(n, m, k, track);
        System.out.println(result);
        in.close();
    }
}
