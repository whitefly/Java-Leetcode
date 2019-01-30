package 图论;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q210_course_schedule_ii {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> Q = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();

        //构造邻接矩阵;
        for (int[] pair : prerequisites) {
            int a = pair[1], b = pair[0];
            inDegree[b]++;
            graph[a].add(b);
        }

        //寻找第一批入度=0的节点
        for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) Q.offer(i);

        //DFS
        int count = 0;
        int[] result = new int[numCourses];
        while (!Q.isEmpty()) {
            int temp = Q.poll();
            result[count++] = temp;
            for (int next : graph[temp]) {
                inDegree[next]--;
                if (inDegree[next] == 0) Q.offer(next);
            }
        }
        //比较count和总节点个数

        return count == numCourses ? result : new int[0];
    }
}
