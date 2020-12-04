package l00161844;

import java.util.Iterator;

public class GenericArrayList<T> implements IList{
    private T[] buffer;
    private int nextFreeLoc;
    private int currentCapacity;
    private static final int INITIAL_CAPACITY = 10;

    /** Default Constructor */
    public GenericArrayList() {
        currentCapacity = INITIAL_CAPACITY;
        nextFreeLoc = 0;
        buffer = (T[]) new Object[currentCapacity];
    }

    /**
     * add element at the end
     * @param elem element to be added
     */
    @Override
    public void add(Object elem) {
        growArrayIfNeeded(); //I've farmed this out to a private "helper" method
        buffer[nextFreeLoc++] = (T) elem;
    }

    /**
     * add element at specified index
     * @param index index at which the specified element is to be inserted
     * @param elem element to be added
     */
    @Override
    public void addAtIndex(int index, Object elem) {
        if (index <= nextFreeLoc) {
            growArrayIfNeeded();
            buffer[index] = (T) elem;
        }
    }

    /**
     * replaces the element at the specified index with a new one
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the existing, replaced element
     */
    @Override
    public Object set(int index, Object element) {
        Object temp = get(index);
        buffer[index] = (T) element;
        return temp;
    }

    /**
     *
     * @param index index of the element to return
     * @return the elemenet at the specified index
     */
    public T get(int index) {
        if(index >= nextFreeLoc) {
            return null;
        }
        return buffer[index];
    }

    /**
     * @param index of the element to be removed
     * @return the
     */
    @Override
    public Object removeAtIndex(int index) {
        Object resp = null;
        if (index <= nextFreeLoc) {
            resp = get(index);
            for( int i = index; i<nextFreeLoc; i++) {
                buffer[i] = buffer[i+1];
            }
            nextFreeLoc--;
        }
        return resp;
    }

    /**
     * @param elem is the object to be found
     * @return true if element is found, false if not
     */
    @Override
    public boolean contains(Object elem) {
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++) {
            if(buffer[index].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * I won't be implementing this now
     * @return
     */
    @Override
    public Iterator iterator() {
        return null;
    }

    /**
     * @return true if the linked list is empty / false if its not
     */
    @Override
    public boolean isEmpty() {
        return (nextFreeLoc == 0);
    }

    /**
     * @return the number of elements in the array list
     */
    @Override
    public int size() {
        return nextFreeLoc;
    }

    /**
     * @param elem the element to remove
     * @return true if element is found and deleted or false if not
     */
    @Override
    public boolean removeElement(Object elem) {
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++) {
            if(buffer[index].equals(elem)) {
                matchFound = true;
                for( int i = index; i<nextFreeLoc; i++) {
                    buffer[i] = buffer[i+1];
                }
                nextFreeLoc--;
            }
        }
        return matchFound;
    }

    /**
     * helper method to grow the array if necessary
     */
    private void growArrayIfNeeded() {
        if(nextFreeLoc == currentCapacity) {
            T[] tempArr = (T[]) new Object[buffer.length * 2];
            currentCapacity *= 2;
            for(int i = 0; i < buffer.length; i++) {
                tempArr[i] = buffer[i];
            }
            buffer = tempArr;
        }
    }

    /**
     *
     * @return a string version of the array list
     */
    @Override
    public String toString() {
        String data = "";
        for(int i = 1; i < nextFreeLoc; i++) {
            data += " " +buffer[i] + ",";
        }
        return "MyStringArrayList[" + data + " ]";
    }
}

