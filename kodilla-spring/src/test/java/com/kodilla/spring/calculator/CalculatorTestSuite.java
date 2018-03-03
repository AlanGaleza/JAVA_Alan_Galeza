package com.kodilla.spring.calculator;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double addResult = calculator.add(0, 1);
        double subResult = calculator.sub(2, 1);
        double mulResult = calculator.mul(1, 1);
        double divResult = calculator.div(1, 1);
        //Then
        assertThat(1.0).isEqualTo(addResult);
        assertThat(1.0).isEqualTo(subResult);
        assertThat(1.0).isEqualTo(mulResult);
        assertThat(1.0).isEqualTo(divResult);
    }
}
