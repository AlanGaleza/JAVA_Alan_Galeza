package com.kodilla.patterns.singleton;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class LoggerTestSuite {

    @Test
    public void getLastLog() {
        //Given
        //When
         Logger.getInstance().log("Log nr 1");
        //Then
        assertThat(Logger.getInstance().getLastLog()).isEqualTo("Log nr 1");
    }
}
