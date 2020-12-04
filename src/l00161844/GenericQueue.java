package l00161844;

import java.util.Arrays;

public class GenericQueue<T> implements IQueue{
    private T [ ] data;
    private int capacity = 30;
    private int counter;

    /** Default Constructor */
    public GenericQueue() {
        data = (T[]) new Object[capacity];
        counter = 0;
    }

    /**
     * helper method to grow the array if necessary
     */
    private void growIfNeeded() {
        if(counter >= capacity) {
            data = Arrays.copyOf(data, capacity*2);
        } else{
            return;
        }
    }

    /**
     * Inserts the specified element into the queue
     *
     * @param element the element argument.
     */
    @Override
    public void enque(Object element) {
        growIfNeeded();
        data[counter++] = (T) element;
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     */
    @Override
    public Object dequeue() {
        Object response = first();
        data[0] = null;
        for(int j = 0; j < counter-1; j++){
            data[j] = data[j+1];
        }
        counter--;
        return response;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     */
    @Override
    public Object first() {
        return data[0];
    }

    /**
     * Tests if this Queue is empty.
     *
     * @return {@code true} if and only if this queue contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        if (counter == 0)
            return true;
        return false;
    }

    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= counter-1; i++) {
            builder.append(data[i]).append(", ");
        }
        return builder.toString();
    }
}
