package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeTest {

    @Test
    public void constructor_should_set_properties() {
        // The 3A's - Arrange, Act, Assert

        //Step One : Arrange - since this is a testing constructor, there is nothing to step up

        /* Since the test is creating a new Coffee object and verifying its properties, there is no logic needed under Arrange.
        In more complex tests, you might create multiple objects or test data as part of the setup.
         */


        // Step Two: Act - call the constructor by creating a new object, passing valid parameters

        /* Under Act, add code to create a new Coffee instance:
         */

        Coffee coffee = new Coffee("Large", "Decaf", new String[]{"Cream", "Sugar"}, 2.99);

        //Step Three: Assert - verify the properties are set up appropriately

        /* The Assert step is where you write code to make the test pass or fail.
        Under Assert, you verify all the things that must be true for the test to pass. These are assertions:
         */

        assertEquals("Large", coffee.getSize(), "size not set correctly");
        assertEquals("Decaf", coffee.getBlend(), "blend not set correctly" );
        assertEquals(2.99, coffee.getPrice(), 0.001, "price not set correctly");
        //^^^ 0.001 is the delta, the allowable difference when comparing doubles
        assertEquals(2, coffee.getAdditions().length, "additions not set correctly");

    }
}
