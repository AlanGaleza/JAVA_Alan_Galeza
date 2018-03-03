package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient(Ingredients.BACON)
                .burgers(2)
                .sauce(Sauce.STANDARD)
                .ingredient(Ingredients.CHEESE)
                .ingredient(Ingredients.CHILLI_PEPPER)
                .roll(Roll.WITH_SESAM)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredient().size();
        //Then
        Assert.assertEquals(3, howManyIngredients);
    }
}