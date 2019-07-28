package pl.beder;

public class LinkedList implements Table {
    Node first;
    Node last;
    int size = 0;

    @Override
    public long size() {
        return size;
    }

    @Override
    public long get(int index) {
        checkBounds(index);

        Node tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        return tmp.getValue();
    }

    @Override
    public int firstIndexWith(long value) {
        int index = 0;
        Node tmp = first;
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
    public int firstIndexWithGivenOrHigherValue(long value) {
        int index = 0;
        Node tmp = first;
        while (tmp != null) {
            if (tmp.getValue() >= value) {
                return index;
            }
            index++;
            tmp = tmp.getNext();
        }
        return -1;
    }

    @Override
    public void insert(long value) {
        if (first == null) {
            first = new Node(value);
            last = first;
        } else {
            Node next = new Node(value);
            last.setNext(next);
            next.setPrev(last);
            last = next;
        }
        size++;
    }

    @Override
    public void insertAt(int index, long value) {
        checkInsertBounds(index);
        
        Node tmpPrev = first;

        for (int i = 0; i < index; i++) {
            tmpPrev = tmpPrev.getNext();
        }

        if (tmpPrev == null) {
            insertFirstNode(value);
        } else if (tmpPrev.getNext() == null) {
            insertLastNode(tmpPrev, value);
        } else {
            insertBetween(tmpPrev, tmpPrev.getNext(), value);
        }
    }

    private void insertFirstNode(long value) {
        Node newNode = new Node(value);
        first = last = newNode;
    }

    private void insertLastNode(Node previous, long value) {
        Node newNode = new Node(value);
        previous.setNext(newNode);
        newNode.setPrev(previous);
    }

    private void insertBetween(Node previous, Node next, long value) {
        Node newNode = new Node(value);
        previous.setNext(newNode);
        newNode.setPrev(previous);

        newNode.setNext(next);
        next.setPrev(newNode);
    }

    @Override
    public void insertSorted(long value) {

    }

    @Override
    public long[] getHolderView() {
        long[] longs = new long[size];
        int index = 0;
        Node tmp = first;
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

    //when inserting value you can insert it between other or exactly at the end which is index = size
    private void checkInsertBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }
}
