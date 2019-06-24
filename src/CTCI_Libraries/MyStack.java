package CTCI_Libraries;

public class MyStack<T> {
    public static class StackNode<T>{
        private T data;
        private StackNode<T> next;
        public StackNode(T data){
            this.data = data;
        }
    }
    private StackNode<T> top;
    private int count;
    public MyStack(){
        this.count = 0;
        this.top = null;
    }

    public void push(T data){
        StackNode<T> t = new StackNode<>(data);
        this.count++;
        t.next = this.top;
        this.top = t;
    }

    public T pop(){
        if(this.isEmpty())
            return null;

        T temp = this.top.data;
        this.count--;
        this.top = this.top.next;
        return temp;
    }

    public T peek(){
        if(this.isEmpty())
            return null;
        return this.top.data;
    }

    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        if(this.top == null)
            return true;
        return false;
    }
}
