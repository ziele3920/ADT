package pl.beder;

public class StaticTable implements Table {

    @Override
    public long size() {
        return 0;
    }

    @Override
    public long get(int index) {
        return 0;
    }

    @Override
    public int firstIndexWith(long value) {
        return 0;
    }

    @Override
    public int firstIndexWithGivenOrHigherValue(long value) {
        return 0;
    }

    @Override
    public void insertAt(int index, long value) {

    }

    @Override
    public void insertSorted(long value) {

    }

    @Override
    //TODO - This should return copy of the filled part of the array
    public long[] getHolderView() {
        return new long[0];
    }

}
