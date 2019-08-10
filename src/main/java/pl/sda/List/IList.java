package pl.sda.List;

public interface IList {

    boolean isEmpty();

    int size();

    void add(long value);

    void add(int index, long value);

    long get(int index);

    void set(int index, long value);

    void remove(int index);

    int firstIndexWith(long value);

    long[] getHolderView();
}
