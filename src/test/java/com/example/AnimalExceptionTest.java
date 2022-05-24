package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AnimalExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void detFoodInsectThrowsException() throws Exception {
        Animal animal = new Animal();
        thrown.expect(Exception.class);
        thrown.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        animal.getFood("Насекомое");
    }
}