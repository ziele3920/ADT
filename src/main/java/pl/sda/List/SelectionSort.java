package pl.sda.List;

public class SelectionSort {

    public IList sort(IList<Integer> listToSort) {
        int firstUnsortedIndex = 0;
        do {
            int minIndex = findMinValueIndex(listToSort, firstUnsortedIndex);
            int tmp = listToSort.get(minIndex);
            listToSort.set(minIndex, listToSort.get(firstUnsortedIndex));
            listToSort.set(firstUnsortedIndex, tmp);
        } while(++firstUnsortedIndex != listToSort.size());
        return listToSort;
    }

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

    private int findMinValueIndex(IList<Integer> list, int startIndex) {
        int minValue = list.get(startIndex);
        int minValueIndex = startIndex;
        for(int i = startIndex+1; i < list.size(); i++) {
            if(list.get(i) < minValue) {
                minValue = list.get(i);
                minValueIndex = i;
            }
        }
        return minValueIndex;
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
