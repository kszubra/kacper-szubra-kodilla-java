package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.enums.Bun;
import com.kodilla.patterns.builder.bigmac.enums.Ingredients;
import com.kodilla.patterns.builder.bigmac.enums.Sauces;
import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testCreatingBigmac() {
        //Given
        Bigmac testBigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.NO_SESAME)
                .burgers(3)
                .sauce(Sauces.ISLES_1000)
                .ingredient(Ingredients.LETTUCE)
                .ingredient(Ingredients.ONION)
                .ingredient(Ingredients.CHEESE)
                .ingredient(Ingredients.CHAMPIGNON)
                .build();
        System.out.println(testBigmac);

        //When
        int expectedIngredientsNumber = 4;
        int expectedBurgersNumbere = 3;
        Sauces expectedSauce = Sauces.ISLES_1000;

        //Then
        Assert.assertEquals(expectedIngredientsNumber, testBigmac.getIngeredients().size());
        Assert.assertEquals(expectedBurgersNumbere, testBigmac.getBurgers());
        Assert.assertEquals(expectedSauce, testBigmac.getSauce());
    }
}
