package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedLionTest {
    private final String sexLion;
    private final boolean expectedHasMane;

    public ParametrizedLionTest(String sexLion, boolean expectedHasMane) {
        this.sexLion = sexLion;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getValueLionHasMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void getSexLionReturnDoesHasMane() throws Exception {
        Lion lion = new Lion(sexLion, new Feline());
        assertEquals("У самца есть грива, у самки нет гривы", lion.doesHaveMane(), expectedHasMane);
    }
}


