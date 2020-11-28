package 桶思想;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Q621_task_scheduler {
    public int leastInterval(char[] tasks, int n) {
        //统计字母个数
        int[] counter = new int[26];
        for (char c : tasks) counter[c - 'A']++;
        Arrays.sort(counter);

        //判断最大的有几个
        int maxCount = 0;
        for (int i = 25; i >= 0 && counter[i] == counter[25]; i--) maxCount++;

        return Math.max(tasks.length, (counter[25] - 1) * (n + 1) + maxCount);
    }
}
