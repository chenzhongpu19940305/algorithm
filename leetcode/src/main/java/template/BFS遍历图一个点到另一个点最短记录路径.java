package template;

import java.util.*;

public class BFS遍历图一个点到另一个点最短记录路径 {
    static class Graph {
        private Map<Integer, List<Integer>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        // 添加边  有向无向均可
        public void addEdge(int s, int e) {
            adjList.putIfAbsent(s, new ArrayList<>());
            adjList.get(s).add(e);
            adjList.putIfAbsent(e, new ArrayList<>());
            adjList.get(e).add(s);
        }

        public List<List<Integer>> bfs(int s, int e) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            // 顶点入队
            queue.add(s);
            visited.add(s);
            current.add(s);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    if (cur == e) {
                        result.add(new ArrayList<>(current));
                        continue;
                    }
                }
            }
        }
    }
}
