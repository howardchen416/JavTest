import java.util.*;

public class GraphTraversal {

    private static class MatchResult {
        public String winningTeam;
        public String losingTeam;

        public MatchResult(String winningTeam, String losingTeam) {
            this.winningTeam = winningTeam;
            this.losingTeam = losingTeam;
        }
    }

    public static boolean canTeamABeatTeamB(List<MatchResult> matches, String teamA, String teamB) {
        Set<String> visited = new HashSet<>();
        return isReachableDFS(buildGraph(matches), teamA, teamB, visited);
    }

    private static Map<String, Set<String>> buildGraph(List<MatchResult> matches) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (MatchResult match : matches) {
            Set<String> edges = graph.get(match.winningTeam);
            if (edges == null) {
                edges = new HashSet<>();
                graph.put(match.winningTeam, edges);
            }
            edges.add(match.losingTeam);
        }
        return graph;
    }

    private static boolean isReachableDFS(final Map<String, Set<String>> graph,
                                          String curr, final String dest,
                                          Set<String> visited) {
        // base condition
        if (curr==null || visited.contains(curr))
            return false;
        if (curr == dest)
            return true;

        visited.add(curr);
        for (String nextTeam : graph.get(curr)) {
            isReachableDFS(graph, nextTeam, dest, visited);
        }

        return false;
    }

}