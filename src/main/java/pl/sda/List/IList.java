package pl.sda.List;

public interface IList<T> {

    boolean isEmpty();

    int size();

    void add(T value);

    void add(int index, T value);

    T get(int index);

    void set(int index, T value);

    void remove(int index);

    int firstIndexWith(T value);

    T[] getHolderView();
}
