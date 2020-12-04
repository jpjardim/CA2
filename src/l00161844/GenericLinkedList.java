package l00161844;

import java.util.Iterator;

/**
 * @author paulo_jardim
 */
public class GenericLinkedList<T> implements IList{
    Node head;
    Node tail;
    int index;

    /**
     * Node class with default constructor
     */
    private class Node {
        T data;
        Node next;
        Node(T d) {
            data = d;
            next = null;
        }
    }

    /** Default Constructor */
    public GenericLinkedList() {
        head = tail = null;
        index = 0;
    }

    /**
     *
     * @return true if the linked list is empty / false if its not
     */
    @Override
    public boolean isEmpty() {
        if (index == 0)
            return true;
        return false;
    }

    /**
     * Add to the end of the list
     * @param elem generic element to be added
     */
    @Override
    public void add(Object elem) {
        Node newNode = new Node((T) elem);
        if(isEmpty()) {
            head = tail = newNode;
            index++;
        } else{
            tail.next = newNode;
            tail = newNode;
            index++;
        }
    }

    /**
     * Adds an element at a specific index
     * @param index index at which the specified element is to be inserted
     * @param elem generic type element
     */

    @Override
    public void addAtIndex(int index, Object elem) {
        Node newNode = new Node((T) elem);
        Node current = head;
        int pointer = 1;

        if(index == 0){ //if index is 0, then element goes to the head
            newNode.next = head;
            head = newNode;
            index++;
        } else if (index == size()-1){ //if index is the same size, then element goes to the tail
            tail.next = newNode;
            newNode = tail;
            index++;
        }
        else {
            while (newNode != null && pointer < size() - 1) {
                if (pointer == index) {
                    newNode.next = current.next;
                    current.next = newNode;
                    index++;
                    break;
                } else {
                    current = current.next;
                    pointer++;
                }
            }
        }
    }

    /**
     *
     * @param index index of the element to return
     * @return the element at the specified index
     */
    @Override
    public Object get(int index) {
        Node current = head;
        int pointer = 0;

        try { //try catch for index out of bounds exception
            while(current != null){ //transverse through linked list
                if (index == pointer){
                    return current.data;
                } else{
                    current = current.next;
                }
            }
            throw new IndexOutOfBoundsException("No element at this index");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * @return the number of elements in the linked list
     */
    @Override
    public int size() {
        return index+1;
    }

    /**
     * @param index of the element to be removed
     * @return the
     */
    @Override
    public Object removeAtIndex(int index) {
        Node current = head;
        int pointer = 0;

        try { //try catch for index out of bounds exception
            while(current != null){ //transverse through linked list
                if (pointer == index) { //check if element is found
                    try { //try catch for index out of bounds exception
                        Object temp = current.data;
                        current.data = current.next.data;
                        current.next = current.next.next;
                        index--;
                        return temp;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Sorry, I don't know how to delete the last node");
                    return null;
                    }
                } else{
                    current = current.next;
                    pointer++;
                }
            }
            throw new IndexOutOfBoundsException("This element was not found");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * @param elem the element to remove
     * @return true if element is found and deleted or false if not
     */
    @Override
    public boolean removeElement(Object elem) {
        Node current = head;
        try { //try catch for index out of bounds exception
            while(current != null){ //transverse through linked list
                if (current.data == elem){ //check if element is found
                    current.data = current.next.data;
                    current.next = current.next.next;
                    index--;
                    return true;
                } else{
                    current = current.next;
                }
            }
            throw new IndexOutOfBoundsException("This element was not found");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * @param elem is the object to be found
     * @return true if element is found, false if not
     */
    @Override
    public boolean contains(Object elem) {
        Node current = head;

        while(current != null){ //transverse through linked list
            if (current.data == elem){ //check if element is found
                return true;
            } else{
                current = current.next;
            }
        }
        return false;
    }

    /**
     * prints the list
     */
    public void printList() {
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    /**
     * Replaces the object at the specified index with a new element
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the object that was in the index
     */
    @Override
    public Object set(int index, Object element) {
        Node newNode = new Node((T) element);
        Node current = head;
        int pointer = 0;
        Object temp = null;

        while (newNode != null && pointer < size()) {
            if (index == 0){ //if index is 0, inserts at the beginning
                temp = head;
                newNode.next = head.next;
                return temp;
            } else if (pointer == index) { //if the pointer is the index, replaces the data
                temp = current;
                newNode.next = current.next;
                current.data = newNode.data;
                return temp;
            } else {
                current = current.next;
                pointer++;
            }
        }
        return newNode.data;
    }

    /**
     * Won't be implementing this now
     * @return
     */
    @Override
    public Iterator iterator() {
        return null;
    }
}



