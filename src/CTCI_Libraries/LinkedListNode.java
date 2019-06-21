package CTCI_Libraries;

import java.util.HashSet;
import java.util.Random;

public class LinkedListNode {
    public LinkedListNode next;
    public LinkedListNode prev;
    public int data;

    public LinkedListNode(){

    }

    public LinkedListNode(int data){
        this.data = data;
        this.next = null;
    }

    public static void printLinkedList(LinkedListNode head){
        System.out.println("\n This is the LinkedList:");
        while(head != null){
            System.out.print(" -> " + head.data);
            head = head.next;
        }
    }

    public static int length(LinkedListNode runner){
        int count = 0;
        while(runner!=null){
            count++;
            runner = runner.next;
        }
        return count;
    }

    public static void makeLinkedList(LinkedListNode head, int[] sequence){
        LinkedListNode list = head;
        for(int s: sequence){
            list.next = new LinkedListNode(s);
            list = list.next;
        }
    }

    public static void makeRandomLinkedList(LinkedListNode head, int number, int min, int max){
        Random r = new Random();
        LinkedListNode list = head;
        for(int i = 0; i < number; i++ ){
            list.next = new LinkedListNode( r.nextInt((max-min)+1) + min );
            list = list.next;
        }
    }

    public static HashSet<Integer> makeRandomUniqueLinkedList(LinkedListNode head, int number, int min, int max){

        if( Math.abs(max - min) < number )
            return new HashSet<>();

        Random r = new Random();
        LinkedListNode list = head;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < number; i++ ){
            int value;
            while(true){
                value = r.nextInt((max-min)+1) + min;
                if(!set.contains(value)){
                    set.add(value);
                    break;
                }
            }
            list.next = new LinkedListNode( value );
            list = list.next;
        }
        return set;
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode head){
        LinkedListNode current = head;
        LinkedListNode previous = null;
        LinkedListNode next = null;

        while(current != null){

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        return previous;
    }

    public static LinkedListNode getLastNode(LinkedListNode node){
        if(node == null)
            return null;
        while(node.next != null)
            node = node.next;

        return node;
    }


}
