package pl.beder;

public interface Table {

    long size();

    long get(int index);

    int firstIndexWith(long value);

    int firstIndexWithGivenOrHigherValue(long value);

    void insertAt(int index, long value);

    void insertSorted(long value);

    long[] getHolderView();
}
