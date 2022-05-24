package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private Feline feline;

    @Test
    public void getKittensPositiveResult() {
        lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeMalePositiveResult() throws Exception {
        lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFemalePositiveResult () throws Exception {
        lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveKittenThrowsException () throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        lion = new Lion("Львенок");
    }

    @Test
    public void getFoodPositiveResult() throws Exception {
        List<String> foodForFeline = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(foodForFeline);
        lion = new Lion(feline);
        List<String> foodForLion = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foodForLion);
    }
}