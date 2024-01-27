package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensLionReturnOne() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittensCount = 1;
        assertEquals("Ожидаемое значение равно 1", expectedKittensCount, lion.getKittens());
    }


    @Test
    public void getFoodLionReturnPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void getExceptionWhenLionSexUndefined() {
        String expectedExceptionText = "Используйте допустимые значения пола животного - самец или самка";
        Exception actualExceptionText = assertThrows(Exception.class, () -> new Lion("Неверное значение", feline));
        assertEquals("Ожидаемый текст", expectedExceptionText, actualExceptionText.getMessage());
    }
}