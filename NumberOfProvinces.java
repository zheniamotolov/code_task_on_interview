import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class NumberOfProvinces {
    public void dfs(int node, int[][] isConnected, boolean[] visit) {

        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public void dfsStack(int node, int[][] isConnected, boolean[] visit) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            int curNode = stack.pop();
            visit[curNode] = true;
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[curNode][i] == 1 && !visit[i]) {
                    stack.push(i);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int numberOfComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;

                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
}
