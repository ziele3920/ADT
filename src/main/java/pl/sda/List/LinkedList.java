package pl.sda.List;

public class LinkedList<T> implements IList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size==0 ? true : false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        Node<T> tmp = getNodeFromIndex(index);
        return tmp.getValue();
    }

    @Override
    public void set(int index, T value) {
        checkBounds(index);
        Node<T> tmp = getNodeFromIndex(index);
        tmp.setValue(value);
    }

    //to do
    @Override
    public void remove(int index) {
        checkBounds(index);
        Node<T> removingNode = getNodeFromIndex(index);
        Node<T> prev = removingNode.getPrev();
        Node<T> next = removingNode.getNext();
        if(index != 0)
            prev.setNext(next);
        else
            this.first = next;
        if(index != size-1)
            next.setPrev(prev);
        else
            this.last = prev;
        size--;
    }

    private Node<T> getNodeFromIndex(int index) {
        Node<T> tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    @Override
    public int firstIndexWith(T value) {
        int index = 0;
        Node<T> tmp = first;
        while (tmp != null) {
            if (tmp.getValue() == value) {
                return index;
            }
            index++;
            tmp = tmp.getNext();
        }
        return -1;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            last = first = new Node(value);
        } else {
            Node<T> next = new Node(value);
            last.setNext(next);
            next.setPrev(last);
            last = next;
        }
        size++;
    }

    @Override
    public void add(int index, T value) {
        checkInsertBounds(index);
        if (size == 0 || index == size) {
            add(value);
            return;
        }

        Node<T> tmpPrev = first;
        for (int i = 0; i < index; i++) {
            tmpPrev = tmpPrev.getNext();
        }

        insertBetween(tmpPrev, value);
    }

    private void insertBetween(Node replaced, T value) {
        Node<T> newNode = new Node(value);

        Node<T> beforeReplaced = replaced.getPrev();
        //No node before replaced this means that replaced was first node!
        //Now 'first' must point to the newNode we inserted
        if (beforeReplaced == null) {
            first = newNode;
        } else {
            beforeReplaced.setNext(newNode);
            newNode.setPrev(beforeReplaced);
        }
        newNode.setNext(replaced);
        replaced.setPrev(newNode);

        size++;
    }

    @Override
    public T[] getHolderView() {
        T[] longs = (T[]) new Object[size];
        int index = 0;
        Node<T> tmp = first;
        while (tmp != null) {
            longs[index++] = tmp.getValue();
            tmp = tmp.getNext();
        }
        return longs;
    }

    //When retrieving value last element is at index size -1
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    //when inserting value you can add it between other or exactly at the end which is index = size
    private void checkInsertBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }
}
