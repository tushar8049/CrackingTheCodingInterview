package Chapter03_Stacks_and_Queues;

import CTCI_Libraries.MyQueue;

import java.util.LinkedList;

/**
 * Problem 6: Animal Shelter
 * An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations such as
 * enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in Linked list data structure.
 */

public class Problem_06 {
    public static void main(String[] arg){

        AnimalShelter queue = new AnimalShelter();

        queue.add("cat-1");
        queue.add("dog-1");
        queue.add("cat-2");
        queue.add("cat-3");
        queue.add("dog-2");
        queue.add("cat-4");

        System.out.println(queue.dequeueAny());
        System.out.println(queue.dequeueAnimal("cat"));
        System.out.println(queue.dequeueAny());
        System.out.println(queue.dequeueAnimal("dog"));
        System.out.println(queue.dequeueAnimal("dog"));
        System.out.println(queue.dequeueAnimal("dog"));
        System.out.println(queue.dequeueAny());
        System.out.println(queue.dequeueAny());
        System.out.println(queue.dequeueAny());
    }

    public static class AnimalShelter extends MyQueue<String> {

        public AnimalShelter(){
            super();
        }

        public String dequeueAny(){
            return remover();
        }

        public String dequeueAnimal(String animal){
            QueueNode<String> runner = getFirst();
            QueueNode<String> previous = null;

            while( runner != null ){
                if(runner.getData().substring(0,3).equalsIgnoreCase(animal)){
                    if(previous == null)
                        return remover();
                    previous.setNext(runner.getNext());
                    return runner.getData();
                }
                previous = runner;
                runner = runner.getNext();
            }
            return "No Animal Found";
        }

    }
}
