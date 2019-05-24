package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPassed() {
        System.out.println("test er fin!");
    }

    @Test
    public void testFailed() {
        fail();
    }
}