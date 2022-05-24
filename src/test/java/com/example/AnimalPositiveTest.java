package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalPositiveTest {
    private final String animalKind;
    private final List<String> expectedParam;

    public AnimalPositiveTest(String animalKind, List<String> expectedParam) {
        this.animalKind = animalKind;
        this.expectedParam = expectedParam;
    }


    @Parameterized.Parameters
    public static Object [][] getFoodData () {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodParametersPositiveResult() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalKind);
        assertEquals(expectedParam, actual);
    }

    @Test
    public void getFamilyPositiveResult() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }
}
