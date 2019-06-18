package CTCI_Libraries;

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


}
