package pl.sda;

import org.junit.Test;
import pl.sda.List.IList;
import pl.sda.List.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    private final IList list = new LinkedList();

    @Test
    public void emptyTableShouldHaveSize_0() {
        //when
        long size = list.size();

        //then
        assertThat(size).isEqualTo(0);
    }

    @Test
    public void tableWithOneElementShouldHaveSize1() {
        //when
        list.add(0, 5);
        long size = list.size();

        //then
        assertThat(size).isEqualTo(1);
    }

    @Test
    public void shouldInsertValuesCorrectly() {
        //when
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);

        //then
        assertThat(list.getHolderView()).containsExactly(3, 2, 1);

    }

    @Test
    public void shouldInsertValuesCorrectly2() {
        //when
        initializeHolderWith_3_4_5_2_1();

        //then
        assertThat(list.getHolderView()).containsExactly(3L, 4L, 5L, 2L, 1L);

    }

    @Test
    public void shouldInsertCorrectlyAtTheEnd() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        list.add(5, 6L);

        //then
        assertThat(list.getHolderView()).containsExactly(3L, 4L, 5L, 2L, 1L, 6L);

    }

    @Test
    public void shouldReturnMinusOneAsIndexWhenValueIsNotPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = list.firstIndexWith(7L);

        //then
        assertThat(index_with_value_7).isEqualTo(-1);
    }

    @Test
    public void shouldReturnCorrectIndexWhenValueIsPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = list.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnFirstIndexWhenValueIsRepeated() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.add(2, 5L);
        list.add(5, 5L);

        //when
        long index_with_value_7 = list.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnTrueIfListIsEmpty() {
        assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalseIfListIsNotEmpty() {
        list.add(6);
        assertThat(list.isEmpty()).isEqualTo(false);
    }

    @Test
    public void shoulgGetValueProperly() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //then
        assertThat(list.get(2)).isEqualTo(5L);
    }

    @Test
    public void shouldSetValueProperly() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.set(2, 9L);

        //then
        assertThat(list.getHolderView()[2]).isEqualTo(9L);
    }

    @Test
    public void shouldDecrementSizeWhenRemove() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.remove(2);

        //then
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void shouldRemoveValuePropoerly() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.remove(2);

        //then
        assertThat(list.firstIndexWith(5)).isEqualTo(-1);
    }

    @Test
    public void lastElementShouldGetValuePropoerly() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //then
        assertThat(list.get(4)).isEqualTo(1L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenRemoveLastAndGetRemovedIndex() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.remove(4);

        list.get(4);
    }

    @Test
    public void lastElementShouldGetValuePropoerlyAfterRemoveEarlierLast() {
        //given
        initializeHolderWith_3_4_5_2_1();

        list.remove(4);

        assertThat(list.get(3)).isEqualTo(2L);
    }

    @Test
    public void firstElementShouldGetValuePropoerly() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //then
        assertThat(list.get(0)).isEqualTo(3L);
    }

    @Test
    public void firstElementShouldGetValuePropoerlyAfterRemoveEarlierFirst() {
        //given
        initializeHolderWith_3_4_5_2_1();

        list.remove(0);

        assertThat(list.get(0)).isEqualTo(4L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenSetOutOfBoundIndex() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.set(5, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenGetOutOfBoundIndex() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.get(5);
    }

    private void initializeHolderWith_3_4_5_2_1() {
        list.add(0, 1L);
        list.add(0, 2L);
        list.add(0, 3L);
        list.add(1, 4L);
        list.add(2, 5L);
    }
}