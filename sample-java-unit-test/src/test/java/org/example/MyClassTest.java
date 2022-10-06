package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MyClassTest {

    /**
     * assert whether hello() returns the expected message
     */
    @Test(description = "Test hello method")
    public void testHello() {
        MyClass myClass = new MyClass();
        String expectedValue = "Hello, World!";
        assertEquals(myClass.hello(), expectedValue);
    }
}