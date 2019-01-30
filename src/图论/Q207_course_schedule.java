package 图论;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q207_course_schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * 思入: 拓扑排序的模板题.用给一个Q来存储入度为0的点. 设置一个入度数组来表示各节点的入读. 然后用邻接矩阵来表示图
         */
        Queue<Integer> Q = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();

        //构造邻接矩阵和入度表;
        for (int[] pair : prerequisites) {
            int a = pair[1], b = pair[0];
            inDegree[b]++;
            graph[a].add(b);
        }

        //寻找第一批入度=0的节点
        for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) Q.offer(i);

        //DFS
        int checked_size = 0;
        while (!Q.isEmpty()) {
            int temp = Q.poll();
            checked_size++;
            for (int next : graph[temp]) {
                inDegree[next]--;
                if (inDegree[next] == 0) Q.offer(next);
            }
        }
        //比较count和总节点个数
        return checked_size == numCourses;
    }
}
