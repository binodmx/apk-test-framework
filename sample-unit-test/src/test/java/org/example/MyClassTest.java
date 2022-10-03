package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyClassTest {

    @Test
    public void hello() {
        MyClass myClass = new MyClass();
        assertEquals("Hello, there!", myClass.hello());
    }
}