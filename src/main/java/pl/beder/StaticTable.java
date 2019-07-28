package pl.beder;

import java.util.Arrays;

public class StaticTable implements Table {

    private final long[] holder;
    private int size = 0;

    public StaticTable() {
        holder = new long[1_000_000];
    }

    public StaticTable(int size) {
        this.holder = new long[size];
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public long get(int index) {
        return 0;
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
    public int firstIndexWithGivenOrHigherValue(long value) {
        int index = firstIndexWith(value);

        if (index == -1) {
            for (int i = 0; i < size; i++) {
                if (value < holder[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override            //   0             2           size= 1
    public void insertAt(int index, long value) {
        for (int i = size; i > index; i--) {
            holder[i] = holder[i - 1];
        }
        holder[index] = value;
        size++;
    }

    @Override
    public void insert(long value) {
        holder[size] = value;
        size++;
    }

    @Override
    public void insertSorted(long value) {
        int index = firstIndexWithGivenOrHigherValue(value);
        if (index == -1) {
            insert(value);
        } else {
            insertAt(index, value);
        }
    }

    @Override
    //TODO - This should return copy of the filled part of the array
    public long[] getHolderView() {
        return Arrays.copyOfRange(holder, 0, size);

    }

}
