package CTCI_Libraries;

public class MyQueue<T> {
    public class QueueNode<T>{
        private T data;
        private QueueNode<T> next;
        public QueueNode(T data){
            this.data = data;
        }
        public T getData(){
            return this.data;
        }
        public QueueNode<T> getNext(){
            return this.next;
        }

        public void setNext(QueueNode<T> next) {
            this.next = next;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;
    private int count;

    public MyQueue(){
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    public void add(T data){
        QueueNode<T> temp = new QueueNode<>(data);
        if(this.last != null){
            this.last.next = temp;
        }
        this.last = temp;
        this.count++;

        if(this.first == null){
            this.first = this.last;
        }
    }

    public T remover(){
        if(this.isEmpty())
            return null;

        T temp = this.first.data;
        this.count--;
        this.first = this.first.next;
        return temp;
    }

    public T peek(){
        if(this.first == null)
            return null;
        return this.first.data;
    }

    public boolean isEmpty(){
        if(this.first == null)
            return true;
        return false;
    }

    public int size(){
        return this.count;
    }

    public QueueNode<T> getFirst(){
        return this.first;
    }

}
