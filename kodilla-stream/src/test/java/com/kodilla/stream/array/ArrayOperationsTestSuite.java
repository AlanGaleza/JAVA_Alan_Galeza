package com.kodilla.stream.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] table = {20, 40, 60, 80};

        AverageArrayCount average = new AverageArrayCount();

        //When
        double result = average.getAverage(table);

        //Then
        assertThat(result).isEqualTo(50.0);
        assertThat(average.getTableValue(table, 1)).isEqualTo(40);
    }
}
