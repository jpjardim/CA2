package l00161844;

import java.util.Arrays;

public class GenericStack<T> implements IStack {
    private T [ ] data;
    private int capacity = 30;
    private int counter;

    /** Default Constructor */
    public GenericStack() {
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
     * Pushes an item onto the top of this stack
     *
     * @param element the element argument.
     */
    @Override
    public void push(Object element) {
        growIfNeeded();
        data[counter++] = (T) element;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    @Override
    public Object pop() {
        Object response = peek();
        data[counter-1] = null;
        counter--;
        return response;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack
     */
    @Override
    public Object peek() {
        return data[counter-1];
    }

    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        if (counter == 0)
            return true;
        return false;
    }

    /**
     *
     * @return a string version of the array list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = counter-1; i >= 0 ; i--) {
            builder.append(data[i]).append("\n");
        }
        return builder.toString();
    }

}
