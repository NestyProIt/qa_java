package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void getFamilyReturnFamilyCat() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Ожидается семейство-кошачьи", expectedFamily, actualFamily);
    }

    @Test
    public void getFoodReturnPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> aclualFood = feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
        assertEquals("Пища для хищника: животные, птицы, рыба", expectedFood, aclualFood);
    }

    @Test
    public void getKittensWithOutArgumentsReturnOne() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals("Ожидаемое значение равно 1", expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getKittensWithArgumentsReturnCount() {
        int expectedKittensCount = 4;
        int countKittens = 4;
        int actualKittensCount = feline.getKittens(countKittens);
        assertEquals("Ожидаемое значение равно 4", expectedKittensCount, actualKittensCount);
    }
}
