package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class FelineTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Animal animal;

    private final int kittensCount;
    private final int expectedParam;

    public FelineTest (int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expectedParam = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData () {
        return new Object[][] {
                {0, 0},
                {3, 3},
                {5, 5},
        };
    }

    @Test
    public void eatMeatPredatorPositiveResult() throws Exception {
        when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void eatMeatNotPredatorNegativeResult () throws Exception {
        when(animal.getFood("Травоядное")).thenReturn(List.of("Трава", "Различные растения"));
        Feline feline= new Feline();
        List<String> expected = animal.getFood("Травоядное");
        List<String> actual = feline.eatMeat();
        assertNotEquals(expected,actual);
    }

    @Test
    public void getFamilyPositiveResult () {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithKittensCountPositiveResult() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(expectedParam, actual);
    }

    @Test
    public void getKittensVerifyArgumentPositiveResult () {
        Feline feline= Mockito.mock(Feline.class);
        feline.getKittens(2);
        Mockito.verify(feline).getKittens(2);
    }


    @Test
    public void getKittensWithoutArgumentPositiveResult() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }
}