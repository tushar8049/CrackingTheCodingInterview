package Chapter03_Stacks_and_Queues;

/**
 * Problem 1: Three in One
 * Describe how you could use a single array to implement three stacks.
 */

public class Problem_01 {
    public static void main(String[] str){

        ThreeStack stacks = new ThreeStack(4);

        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        stacks.push(0, 4);
        stacks.push(0, 5);
        stacks.push(0, 6);
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
    }

    public static class ThreeStack {
        private int[] values;
        private int[] size;
        private int capacity;
        private int numberOfStacks = 3;

        public ThreeStack(int capacity){
            this.capacity = capacity;
            this.values = new int[this.numberOfStacks * this.capacity];
            this.size = new int[this.numberOfStacks];
        }

        public void push(int stackNo, int value){
            if(stackNo >= this.numberOfStacks)
                return;

            if( isFull(stackNo) ){
                System.out.println("Stack is full!");
                return;
            }

            this.values[ (stackNo * this.capacity) + this.size[stackNo]] = value;
            this.size[stackNo] += 1;
        }

        public int pop(int stackNo){
            if(stackNo >= this.numberOfStacks)
                return Integer.MIN_VALUE;

            if( isEmpty(stackNo) ){
                System.out.println("Stack is Empty");
                return Integer.MIN_VALUE;
            }

            this.size[stackNo] -= 1;
            int temp = this.values[(stackNo * this.capacity) + this.size[stackNo]];
            return temp;
        }

        public int peek(int stackNo){
            if(stackNo >= this.numberOfStacks)
                return Integer.MIN_VALUE;

            if( isEmpty(stackNo) ){
                System.out.println("Stack is Empty");
                return Integer.MIN_VALUE;
            }

            int temp = this.values[(stackNo * this.capacity) + this.size[stackNo] - 1];
            return temp;
        }

        public boolean isFull(int stackNo){
            return size[stackNo] == capacity;
        }

        public boolean isEmpty(int stackNo){
            return size[stackNo] == 0;
        }
    }
}
