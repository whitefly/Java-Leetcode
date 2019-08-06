package 迭代器;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q341_flatten_nested_list_iterator {
    static public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    static class NestedIterator implements Iterator<Integer> {
        /*
        思入:将未来所有的NestedInteger都逆序放在stack中,
         */
        private Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) stack.add(nestedList.get(i));
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            //不断取出,不断逆序
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                List<NestedInteger> list = stack.pop().getList();
                for (int i = list.size() - 1; i >= 0; i--) stack.add(list.get(i));
            }
            return !stack.isEmpty();
        }
    }
}
