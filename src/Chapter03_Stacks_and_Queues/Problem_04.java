package Chapter03_Stacks_and_Queues;

import java.util.Stack;

/**
 * Problem 4: Queue via Stacks
 * Implement a MyQueue class which implements a queue using two stacks.
 */

public class Problem_04 {
    public static void main(String[] str){
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.isEmpty());
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        myQueue.add(5);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.isEmpty());
    }
    public static class MyQueue{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public MyQueue(){
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void add(int data){
            this.stack1.push(data);
        }

        public int remove(){
            if(this.isEmpty())
                return Integer.parseInt(null);

            if(this.stack2.isEmpty()){
                while(!this.stack1.isEmpty()){
                    this.stack2.push(this.stack1.pop());
                }
            }
            return this.stack2.pop();
        }

        public int peek(){
            if(this.isEmpty())
                return Integer.parseInt(null);
            if(this.stack2.isEmpty()){
                while(!this.stack1.isEmpty()){
                    this.stack2.push(this.stack1.pop());
                }
            }
            return this.stack2.peek();
        }

        public boolean isEmpty(){
            return this.stack2.isEmpty() && this.stack1.isEmpty();
        }
    }
}
