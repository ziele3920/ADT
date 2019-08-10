package pl.sda;

import org.junit.Test;
import pl.sda.List.ArrayList2x;
import pl.sda.List.IList;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayList2xTest {

    private final IList list = new ArrayList2x();

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
        assertThat(list.getHolderView()).containsExactly(3, 4, 5, 2, 1);

    }

    @Test
    public void shouldInsertCorrectlyAtTheEnd() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        list.add(5, 6);

        //then
        assertThat(list.getHolderView()).containsExactly(3, 4, 5, 2, 1, 6);

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
        list.add(2, 5);
        list.add(5, 5);

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
        assertThat(list.get(2)).isEqualTo(5);
    }

    @Test
    public void shouldSetValueProperly() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.set(2, 9);

        //then
        assertThat(list.getHolderView()[2]).isEqualTo(9);
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

    private void initializeHolderWith_3_4_5_2_1() {
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        list.add(1, 4);
        list.add(2, 5);
    }
}