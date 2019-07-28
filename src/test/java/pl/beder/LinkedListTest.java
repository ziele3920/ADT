package pl.beder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    private final LinkedList linkedTable = new LinkedList();

    @Test
    public void emptyTableShouldHaveSize_0() {
        //when
        long size = linkedTable.size();

        //then
        assertThat(size).isEqualTo(0);
    }

    @Test
    public void tableWithOneElementShouldHaveSize1() {
        //when
       linkedTable.insertAt(0, 5);
        long size = linkedTable.size();

        //then
        assertThat(size).isEqualTo(1);
    }

    @Test
    public void shouldInsertValuesCorrectly() {
        //when
        linkedTable.insert(1);
        linkedTable.insert(2);
        linkedTable.insert(3);

        //then
        assertThat(linkedTable.getHolderView()).containsExactly(1, 2, 3);
        assertThat(linkedTable.firstIndexWith(2)).isEqualTo(1);
    }

    @Test
    public void shouldInsertValuesAtIndexCorrectly() {
        //when
        linkedTable.insertAt(0, 1);
        linkedTable.insertAt(0, 2);
        linkedTable.insertAt(0, 3);

        //then
        assertThat(linkedTable.getHolderView()).containsExactly(3, 2, 1);

    }

    @Test
    public void shouldInsertValuesCorrectly2() {
        //when
        initializeHolderWith_3_4_5_2_1();

        //then
        assertThat(linkedTable.getHolderView()).containsExactly(3, 4, 5, 2, 1);

    }

    @Test
    public void shouldInsertCorrectlyAtTheEnd() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        linkedTable.insertAt(5, 6);

        //then
        assertThat(linkedTable.getHolderView()).containsExactly(3, 4, 5, 2, 1, 6);

    }

    @Test
    public void shouldReturnMinusOneAsIndexWhenValueIsNotPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = linkedTable.firstIndexWith(7L);

        //then
        assertThat(index_with_value_7).isEqualTo(-1);
    }

    @Test
    public void shouldReturnCorrectIndexWhenValueIsPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_5 = linkedTable.firstIndexWith(5L);

        //then
        assertThat(index_with_value_5).isEqualTo(2);
    }

    @Test
    public void shouldReturnFirstIndexWhenValueIsRepeated() {
        //given
        initializeHolderWith_3_4_5_2_1();
        linkedTable.insertAt(2, 5);
        linkedTable.insertAt(5, 5);

        //when
        long index_with_value_7 = linkedTable.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnMinusOneThereIsNoHigherValuePresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index = linkedTable.firstIndexWithGivenOrHigherValue(6);

        //then
        assertThat(index).isEqualTo(-1L);
    }

    @Test
    public void shouldReturnIndexThatHasHigherValue() {
        //given
        initializeHolderWith_3_4_5_2_1();
        linkedTable.insert(10L);

        //when
        long index = linkedTable.firstIndexWithGivenOrHigherValue(6);

        //then
        assertThat(index).isEqualTo(5L);
    }

    @Test
    public void shouldBeSortedWhenUsingOnlyInsertSortedMethod() {
        //when
        linkedTable.insertSorted(5);
        linkedTable.insertSorted(8);
        linkedTable.insertSorted(12);
        linkedTable.insertSorted(345);
        linkedTable.insertSorted(1);
        linkedTable.insertSorted(-65);

        //then
        assertThat(linkedTable.getHolderView()).containsExactly(-65L, 1L, 5L, 8L, 12L, 345L);
    }

    private void initializeHolderWith_3_4_5_2_1() {
        linkedTable.insertAt(0, 1);
        linkedTable.insertAt(0, 2);
        linkedTable.insertAt(0, 3);
        linkedTable.insertAt(1, 4);
        linkedTable.insertAt(2, 5);
    }
}