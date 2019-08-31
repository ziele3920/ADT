package pl.sda.List;

public class SelectionSort {
    public int[] sort(int[] tableToSort) {
        int firstUnsortedIndex = 0;
        do {
            int minIndex = findMinValueIndex(tableToSort, firstUnsortedIndex);
            int tmp = tableToSort[minIndex];
            tableToSort[minIndex] = tableToSort[firstUnsortedIndex];
            tableToSort[firstUnsortedIndex] = tmp;
        } while(++firstUnsortedIndex != tableToSort.length);
        return tableToSort;
    }

    private int findMinValueIndex(int[] table, int startIndex) {
        int minValue = table[startIndex];
        int minValueIndex = startIndex;
        for(int i = startIndex+1; i < table.length; i++) {
            if(table[i] < minValue) {
                minValue = table[i];
                minValueIndex = i;
            }
        }
        return minValueIndex;
    }
}
