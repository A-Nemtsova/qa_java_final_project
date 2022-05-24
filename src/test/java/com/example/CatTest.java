package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    private Feline feline;

    @Before
    public void initCat () {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundPositiveResult() {
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodPositiveResult() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> foodForCat = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foodForCat);
    }
}