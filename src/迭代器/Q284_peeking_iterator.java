package 迭代器;

import java.util.*;

public class Q284_peeking_iterator {
    static class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> nums;
        private Integer peek;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            // iterator is  exists, just need to foreach
            this.nums = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (peek != null) return peek;
            if (!nums.hasNext()) return null;
            return peek = nums.next();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peek != null) {
                Integer temp = peek;
                peek = null;
                return temp;
            } else if (!nums.hasNext()) return null;
            else return nums.next();
        }

        @Override
        public boolean hasNext() {
            return peek != null || nums.hasNext();
        }

    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList();
        Iterator<Integer> iterator = ints.iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);

        System.out.println(peekingIterator.next());  //1
        System.out.println(peekingIterator.peek()); //2
        System.out.println(peekingIterator.next()); //2
        System.out.println(peekingIterator.next()); //3
        System.out.println(peekingIterator.hasNext()); //false


    }
}
