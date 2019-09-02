package 栈;

import java.util.Stack;

public class Q901_online_stock_span {
    /*
    思入: 单调栈,求左起第一大,则单调递减栈
    注意重复点 22 21 22
     */
    static class StockSpanner {
        private Stack<int[]> stack = null;
        int index = 0;

        public StockSpanner() {
            stack = new Stack<>();
            stack.add(new int[]{-1, Integer.MAX_VALUE});
        }

        public int next(int price) {
            while (!stack.isEmpty() && stack.peek()[1] <= price) stack.pop();
            int result = index - stack.peek()[0];
            stack.add(new int[]{index++, price});
            return result;
        }
    }

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            System.out.println(s.next(price));
        }

    }

}
