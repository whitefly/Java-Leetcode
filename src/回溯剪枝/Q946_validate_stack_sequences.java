package 回溯剪枝;


import java.util.Stack;

public class Q946_validate_stack_sequences {
    Stack<Integer> S = new Stack<>();

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /**
         * 思想1: 回溯剪枝,每次2种可能(即2种指针上的操作),,设计2个指针, 终止条件是不符合 或者  成功消耗掉所有指针.
         * 不过耗时比较长,因为会遍历所有可能
         */
        int index1 = 0, index2 = 0;
        return DFS(pushed, popped, index1, index2);
    }

    private boolean DFS(int[] pushed, int[] popped, int index1, int index2) {
        //终止条件
        if (index1 == pushed.length && index2 == popped.length) return true;
        boolean r = false;
        //遍历2种可能
        if (index1 < pushed.length) {
            S.add(pushed[index1]);
            index1++;
            r = DFS(pushed, popped, index1, index2);
            index1--;
            S.pop();
            if (r) return true;
        }

        if (index2 < popped.length) {
            if (S.empty()) return false;
            int k = S.pop();
            if (k == popped[index2]) {
                index2++;
                r = DFS(pushed, popped, index1, index2);
                index2--;
                S.push(k);
                if (r) return r;
            } else {
                S.push(k);
                return false;
            }
        }
        return r;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        /**
         * 思入2:考研数据结构的知识: 已经进站顺序固定,判断出栈顺序是否合法
         * 考研数据知识: 出栈序列中，元素i之后所有比i小的元素间必须是降序排列的。 前提: push中的数组是顺序排列的(所以需要做一个映射)
         * 思入:设置一个 本次扫描元素值,
         */
        //做一个顺序映射
        int map[] = new int[1000];
        for (int i = 0; i < pushed.length; i++) map[pushed[i]] = i;

        for (int i = 0; i < popped.length; i++) {
            int num1 = map[popped[i]];
            int last = -1;
            for (int j = i + 1; j < popped.length; j++) {
                int num2 = map[popped[j]];
                if (num1 < num2) continue;

                if (last == -1) last = num2;
                else {
                    if (last < num2) return false;
                    else last = num2;
                }
            }
        }
        return true;
    }

    public boolean validateStackSequences3(int[] pushed, int[] popped) {
        /**
         * 思入3: pop某值时,需要对应的stack中有恰好有该值. 所以刚加上,判断是否可以被消去.消去后,看看是否可以连续消除
         */
        int i = 0;
        for (int num1 : pushed) {
            S.add(num1);
            while (!S.empty() && S.peek() == popped[i]) {
                S.pop();
                i++;
            }
        }
        return S.empty();
    }


    public static void main(String[] args) {
        int[] pushed = {2, 0, 1}, popped = {1, 0, 2};
        Q946_validate_stack_sequences s = new Q946_validate_stack_sequences();
        System.out.println(s.validateStackSequences3(pushed, popped));
    }

}
