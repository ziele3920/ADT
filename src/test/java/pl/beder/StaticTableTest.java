package pl.beder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StaticTableTest {

    private final StaticTable staticTable = new StaticTable();

    @Test
    public void shouldInsertValuesCorrectly() {
        //when
        staticTable.insertAt(0, 1);
        staticTable.insertAt(0, 2);
        staticTable.insertAt(0, 3);

        //then
        assertThat(staticTable.getHolderView()).containsExactly(3, 2, 1);

    }

    @Test
    public void shouldInsertValuesCorrectly2() {
        //when
        initializeHolderWith_3_4_5_2_1();

        //then
        assertThat(staticTable.getHolderView()).containsExactly(3, 4, 5, 2, 1);

    }

    @Test
    public void shouldInsertCorrectlyAtTheEnd() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        staticTable.insertAt(5, 6);

        //then
        assertThat(staticTable.getHolderView()).containsExactly(3, 4, 5, 2, 1, 6);

    }

    @Test
    public void shouldReturnMinusOneAsIndexWhenValueIsNotPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = staticTable.firstIndexWith(7L);

        //then
        assertThat(index_with_value_7).isEqualTo(-1);
    }

    @Test
    public void shouldReturnCorrectIndexWhenValueIsPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = staticTable.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnFirstIndexWhenValueIsRepeated() {
        //given
        initializeHolderWith_3_4_5_2_1();
        staticTable.insertAt(2, 5);
        staticTable.insertAt(5, 5);

        //when
        long index_with_value_7 = staticTable.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnIndexSameAsSizeWhenThereIsNoHigherValuePresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index = staticTable.firstIndexWithGivenOrHigherValue(6);

        //then
        assertThat(index).isEqualTo(5L);
    }

    @Test
    public void shouldReturnIndexThatHasHigherValue() {
        //given
        initializeHolderWith_3_4_5_2_1();
        staticTable.insertAt(5, 10L);

        //when
        long index = staticTable.firstIndexWithGivenOrHigherValue(6);

        //then
        assertThat(index).isEqualTo(5L);
    }

    @Test
    public void shouldBeSortedWhenUsingOnlyInsertSortedMethod() {
        //when
        staticTable.insertSorted(5);
        staticTable.insertSorted(8);
        staticTable.insertSorted(12);
        staticTable.insertSorted(345);
        staticTable.insertSorted(1);
        staticTable.insertSorted(-65);

        //then
        assertThat(staticTable.getHolderView()).containsExactly(-65L, 1L, 5L, 8L, 12L, 345L);
    }

    private void initializeHolderWith_3_4_5_2_1() {
        staticTable.insertAt(0, 1);
        staticTable.insertAt(0, 2);
        staticTable.insertAt(0, 3);
        staticTable.insertAt(1, 4);
        staticTable.insertAt(2, 5);
    }
}