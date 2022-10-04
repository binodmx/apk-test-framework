package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MyClassTest {

    @Test
    public void testHello() {
        MyClass myClass = new MyClass();
        String expectedValue = "Hello, there!";
        assertEquals(myClass.hello(), expectedValue);
    }
}