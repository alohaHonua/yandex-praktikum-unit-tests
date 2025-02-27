package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

// 1) Пометить класс специальной аннотацией
@RunWith(Parameterized.class)

public class PalindromeServiceTest {

    // 2) Объявить поля в классе, которые будут параметрами
    private final String checkedText;
    private final boolean expected;

    // 3) Написать конструктор, в котором будут инициализироваться поля
    public PalindromeServiceTest(String checkedText, boolean expected){
        this.checkedText = checkedText;
        this.expected = expected;
    }


   // 4) Написать метод, который хранит набор параметров для теста
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"anna", true},
                {"anka", false},
                {"q", true}
        };
    }

    // 5) Сам тест
    @Test
    public void shouldCheckPalindrome(){
        PalindromeService palindromeService = new PalindromeService();
        boolean actual = palindromeService.isPalindrome(checkedText);
        assertEquals(expected, actual);
    }

}