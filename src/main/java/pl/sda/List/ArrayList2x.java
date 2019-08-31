package pl.sda.List;

import java.util.Arrays;

public class ArrayList2x implements IList {

    private long[] holder;
    private int size = 0;
    private final int arraySizeMultipler = 2;

    public ArrayList2x() {
        holder = new long[arraySizeMultipler];
    }

    // to do
    @Override
    public boolean isEmpty() {
        return size==0 ? true : false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public long get(int index) {
        checkBounds(index);
        return holder[index];
    }
    @Override
    public void set(int index, long value) {
        checkBounds(index);
        holder[index] = value;
    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        for(int i = index; i < size-1; i++)
            holder[i] = holder[i+1];
        size--;
    }

    @Override
    public int firstIndexWith(long value) {
        for (int i = 0; i < size; i++) {
            if (value == holder[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(int index, long value) {
        checkInsertBounds(index);
        if(holder.length == size)
            incrementHolderLength();
        for (int i = size; i > index; i--) {
            holder[i] = holder[i - 1];
        }
        holder[index] = value;
        size++;
    }

    private void incrementHolderLength() {
        int newHolderSize = holder.length * arraySizeMultipler;
        long[] newHolder = new long[newHolderSize];
        for(int i = 0; i < size; i++)
            newHolder[i] = holder[i];
        holder = newHolder;
    }

    @Override
    public void add(long value) {
        if(holder.length == size)
            incrementHolderLength();
        holder[size] = value;
        size++;
    }

    @Override
    //TODO - This should return copy of the filled part of the array
    public long[] getHolderView() {
        return Arrays.copyOfRange(holder, 0, size);
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
